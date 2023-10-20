# Экзаменационное задание 2 Cucumber, maven, Rest Assured, allure

### Запуск тестов через терминал: <mvn clean test>

## Файл src/main/java/util/Config.java
- Реализована конфигурация системы на использование файла src/test/resources/application.properties

## Файл src/test/java/hooks/Hooks.java
- Содержит Attachment для создания сообщения

# API тесты сайта https://rickandmortyapi.com/api

### в папке src/test/java/steps/api_rick_and_morty
реализована логика шагов теста сайта https://rickandmortyapi.com/api

### Реализованы тесты:

#### Test OpenUrl
Открываем URL и проверяем statusCode и body на соответствие схеме.

#### Test testGetCharacter
Находим информацию по персонажу Морти Смит.
Выбираем из ответа последний эпизод, где появлялся Морти.
Получаем из списка последнего эпизода последнего персонажа.
Получаем данные по местонахождению и расе этого персонажа.
Проверяем, этот персонаж той же расы и находится там же где и Морти?

# API тесты сайта https://reqres.in/

### в папке src/test/java/steps/api_reqres
реализована логика шагов теста по сату https://reqres.in/

### Реализованы тесты:

#### Test OpenUrl
Открываем URL и проверяем statusCode и body на соответствие схеме.

#### Test testCreate

Создан тест запрос для создания пользователя
Body в запрос предается из ранее созданного файла, меняется
name и добавляется поле Job
{ "name": "Tomato", "job": "Eat maket" }
Проверяем, что получили ответ 201.
Сверяем, что полученный response имеет валидные данные по значениям key и value.
