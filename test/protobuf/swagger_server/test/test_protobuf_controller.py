# coding: utf-8

from __future__ import absolute_import

from flask import json
from six import BytesIO

from swagger_server.models.parsed import Parsed  # noqa: E501
from swagger_server.test import BaseTestCase


class TestProtobufController(BaseTestCase):
    """ProtobufController integration test stubs"""

    def test_parse_post(self):
        """Test case for parse_post

        Converts protobuf binary format to json
        """
        data = dict(upfile=(BytesIO(b'some file data'), 'file.txt'))
        response = self.client.open(
            '//parse',
            method='POST',
            data=data,
            content_type='multipart/form-data')
        self.assert200(response,
                       'Response body is : ' + response.data.decode('utf-8'))


if __name__ == '__main__':
    import unittest
    unittest.main()
