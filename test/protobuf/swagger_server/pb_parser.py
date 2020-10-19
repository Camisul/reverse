import io
import struct

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
  def read(self, n):
    return int.from_bytes(self.data.read(l), "little")

  def getFieldInfo(self):
    b = self.read(1)       # read a byte 
    no_msb = (b & 0x7F)    # clear msb
    t = no_msb & 0x7       # last 3 bits is type 
    field_no = no_msb >> 3 # 3 bits to the right is field number
    return (t, field_no)

  def parse(self):
    to_return = []
    while self.len != self.data.tell():
      t, _ = self.getFieldInfo()
      if t == 0: # Decode 'Variant'
        bit_acc = []
        while True:
            b = read(sample, 1)
            has_more = b & 0x80
            bit_acc.append((b & 0x7F))
            if not has_more:
                break
        ret = sum(
          reversed(
            [(x << i*7) for i,x in enumerate(bit_acc)]
          )
        )
        to_return.append(Field(type="Variant", data=ret))
        continue
      if t == 1: # 64-bit -> fixed64, sfixed64, double
        v = sample.read(8)
        ret = struct.unpack('d', v)
        to_return.append(Field(type="Double", data=ret))        
        continue
      if t == 2: # Length-delimited
        l = read(sample, 1)
        ret = sample.read(l)
        # TODO(cami): Add UTF-8 detection,
        to_return.append(Field(type="String", data=ret))
        continue
      if t == 3: # Start group
        raise Deprecated('Start group is deprecated')

      if t == 4: # End group
        raise Deprecated('End group is deprecated')

      if t == 5: # 32-bit -> fixed32, sfixed32, float
        v = sample.read(4)
        ret = struct.unpack('f', v)
        to_return.append(Field(type="Float", data=ret))        
        continue
    return to_return

        