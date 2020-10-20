import io
import struct
from collections import namedtuple
from swagger_server.models.parsed_fileds import ParsedFileds as Field

class Deprecated(Exception):
     def __init__(self, message):
        self.message = message

class PbParser:
  def __init__(self, data):
    self.data = io.BytesIO(data)
    self.len = len(data)

  '''
    Reads n bytes of data (little endian)
  '''
  def read(self, f, data, n):
    b = data.read(n)
    if len(b) == 0:
      raise RuntimeError(f'Field: #{f}, unexpected EOF')
    return int.from_bytes(b, "little")
    

  def getFieldInfo(self):
    b = self.read('#root', self.data,1)       # read a byte 
    no_msb = (b & 0x7F)    # clear msb
    t = no_msb & 0x7       # last 3 bits is type 
    field_no = no_msb >> 3 # 3 bits to the right is field number
    return (t, field_no)

  def parseStartGroup(self, f):
    raise Deprecated(f'Field #{f}, Start group is deprecated')

  def parseEndGroup(self, f):
   raise Deprecated(f'Field #{f}, End group is deprecated')

  def parseVarint(self, f, data):
    bit_acc = []
    while True:
        b = self.read(f, data, 1)
        has_more = b & 0x80
        bit_acc.append((b & 0x7F))
        if not has_more:
            break
    return Field(type="Varint", data=sum(
        reversed(
          [(x << i*7) for i,x in enumerate(bit_acc)]
        )
      )
    )

  def unpack(self, f, l, data):
    Parser = namedtuple('Parser', ['size', 'func'])
    parsers = [
      Parser(size=8, func=self.parse64bit),
      Parser(size=4, func=self.parse32bit),
      Parser(size=1, func=self.parseVarint),
    ]
    parser = Parser(size=0, func=None)
    for p in parsers:
      if l % p.size == 0:
        parser = p
        break
    
    d = io.BytesIO(data)
    iters = l // parser.size
    ret = []
    if iters != l: # Only for fixed length values
      for _ in range(iters):
        ret.append(parser.func(f,d))
    else: # Only for Varint
      while d.tell() != l:
        ret.append(parser.func(f, d))

    return ret

  def parseLengthDelimited(self, f):
    l = self.read(f, self.data, 1)
    v = self.data.read(l)

    def parseEmbedd(f,l,v):
      ret = PbParser(v).parse()
      if len(ret):
        return Field(type="EmbeddedMessage", data=ret)

    def parsePacked(f,l,v):
      ret = self.unpack(f, l, v)
      if len(ret):
        return Field(type="Packed", data=ret)
    
    def parseStr(f,l,v):
      ret = v.decode()
      return Field(type="StringOrBytes", data=ret)
  
    parsers = [parseEmbedd, parseStr, parsePacked]
    for p in parsers:  
      try:
        ret = p(f,l,v)
        if ret:
          return ret
        
      except Exception as e:
        continue

  def parse64bit(self, f, data):
    v = data.read(8)
    return Field(type="Double", data=struct.unpack('d', v))

  def parse32bit(self, f, data):
    v = data.read(4)
    return Field(type="Float", data=struct.unpack('f', v))

  def parse(self):
    to_return = []
    while self.len != self.data.tell():
      t, f = self.getFieldInfo()
      if t == 0: # Decode 'Varint'
        to_return.append(self.parseVarint(f, self.data))
        continue
      if t == 1: # 64-bit -> fixed64, sfixed64, double
        to_return.append(self.parse64bit(f, self.data))    
        continue
      if t == 2: # Length-delimited
        to_return.append(self.parseLengthDelimited(f))
        continue
      if t == 3: # Start group
        self.parseStartGroup(f)
      if t == 4: # End group
        self.parseEndGroup(f)
      if t == 5: # 32-bit -> fixed32, sfixed32, float
        to_return.append(self.parse32bit(f, self.data))    
        continue
    return to_return

        