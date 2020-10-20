
## Тестовые файлы  
| Имя файла | Описание |  
| --------- | -------- |  
| [`pb_simple_varint_test.bin`](./testfiles/pb_simple_varint_test.bin) | Базовый тест сообщения, содержит байты: `08  96  01`|
| [`pb_simple_string_test.bin`](./testfiles/pb_simple_string_test.bin) | Тест текстовых данных, содержит байты: `12  07  74  65  73  74  69  6e  67` |
| [`pb_embedded_message_test.bin`](./testfiles/pb_embedded_message_test.bin) | Тест вложеного сообщения, содержит байты: ` 1a  03  08  96  01` |
| [`pb_packed_value_test.bin`](./testfiles/pb_packed_value_test.bin) | Тест 'упкованых' полей, содержит байты: `22 06 03 8E  02 9E A7 05` |


## Использование
```bash
docker build -t pb2json_swagger .

docker run -p 8080:8080 pb2json_swagger
```
[`http://localhost:8000/ui`](http://localhost:8000/ui)