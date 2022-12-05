# Описание проекта

Проект реализует основной функционал используемых технологий (демо проект):
* rabbitmq template + config (amqp)
* gateway / load balancer (apigw)
* общий модуль для общения между сервисами по http с помощью open feign (clients)
* kubernetes (k8s branch)
  Бизнес логика:
* регистрация аккаунта (customer-service)
* проверка аккаунта (fraud-service)
* отправка оповещения о регистрации или подтверждения (notification-service)

Основные используемые технологии:
- Java 17
- Spring (Boot, Web, Data JPA, Validation)
- Spring Cloud (gateway, eureka, sleuth, zipkin)
- RabbitMQ
- Kafka (only local env)
- PostgreSQL
- Jackson
- Lombok
- Kubernetes (k8s branch)
- jib container builder

![alt text](https://github.com/ModiconMe/microservices-demo/blob/main/Architecture.png "ARCHITECTURE")

