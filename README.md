# Сервис 2 (Сервис отправки сообщений)

## Описание

Этот сервис служит потребителем Kafka. Когда он получает сообщение, он отправляет уведомление на электронную почту (указанную в коде) и сохраняет результат отправки (успешно или нет) в базу данных.

## Основные возможности:

1. Прослушивание сообщений из Kafka. 
2. Автоматическая отправка полученных сообщений на указанный email. 
3. Сохранение информации о отправленных сообщениях в базе данных, включая статус отправки. 
4. Получение списка всех отправленных сообщений через HTTP GET запрос. 
5. Использование базы данных Postgres для хранения информации о отправленных сообщениях.

## Инструкция по установке и запуску

## Требования к окружению:

- Java версии 17 или новее
- Docker и Docker-compose для запуска Kafka и Zookeeper

## Настройка и запуск:

1. Клонируйте репозиторий на свою локальную машину.
2. Перейдите в директорию проекта `\message-service\message-service`.
3. Если вы еще не запустили Kafka и Zookeeper для Первого сервиса, используйте команду `docker-compose up` для их запуска.
4. Запустите приложение с помощью вашей IDE или через командную строку с использованием `mvn spring-boot:run`.

## Endpoints:

- GET `/sent-messages` - Возвращает список отправленных сообщений и коды ответов.
  http://localhost:8081/sent-messages

**Примечание:**

- По умолчанию e-mail для отправки уведомлений установлен на "arys.java@mail.ru".
- Перед тестированием второго сервиса, убедитесь, что вы указали правильный адрес электронной почты в методе listen класса EmailService, куда вы хотите получить тестовое сообщение.

---

Если у вас возникнут какие-либо проблемы или вопросы
- **Электронная почта:** [chenemesov01@gmail.com]
- **WhatsApp:** [87004005797]