FROM python:3-alpine
# Upgrade all
RUN apk update && apk upgrade -U -a
# Upgrade pip
RUN python3 -m pip install --upgrade pip

RUN mkdir -p /usr/src/app
WORKDIR /usr/src/app

COPY requirements.txt /usr/src/app/
# Install dependencies
RUN pip3 install --no-cache-dir -r requirements.txt
RUN pip3 install connexion[swagger-ui]

COPY . /usr/src/app

EXPOSE 8080

ENTRYPOINT ["python3"]

CMD ["-m", "swagger_server"]