import connexion
import six
from swagger_server.pb_parser import PbParser
from swagger_server.models.parsed import Parsed  
from swagger_server import util


def parse_post(upfile=None):  
    """Converts protobuf binary format to json


    :param upfile: The file to upload.
    :type upfile: werkzeug.datastructures.FileStorage

    :rtype: Parsed
    """
    return Parsed(fileds=PbParser(upfile.read()).parse())
