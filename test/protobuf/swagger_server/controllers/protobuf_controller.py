import connexion
import six

from swagger_server.models.parsed import Parsed  # noqa: E501
from swagger_server import util


def parse_post(upfile=None):  # noqa: E501
    """Converts protobuf binary format to json

     # noqa: E501

    :param upfile: The file to upload.
    :type upfile: werkzeug.datastructures.FileStorage

    :rtype: Parsed
    """
    return 'do some magic!'
