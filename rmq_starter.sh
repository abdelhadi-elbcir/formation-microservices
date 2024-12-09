docker ps -a --format '{{.Names}}' | grep -q some-rabbit && docker rm some-rabbit
docker run -d --hostname mq-rabbit --name some-rabbit -p 15672:15672 -p 5672:5672 rabbitmq:3-management

