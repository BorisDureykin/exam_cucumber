# language: ru
@Api
@reqresTestsApi
Функция: Reqres Tests Api

  @ПроверкаДоступностиСайта
  Сценарий: Открываем URL, проверяем statusCode и сверяем тело ответа
    Когда Открываем "UrlReqresIn", c endpoint = "/api/unknown",  method = "GET" сверяем statusCode = "200" и  pathSchema = "reqres/SchemaOpenUrl.json"

  @СозданиеПользователя
  Сценарий: Изменяем Json файл: изменяя имя и добавляя поле job и создаем пользователя
    Когда Изменяем в файле "src/test/resources/reqres/user.json" name на: "Tomato" и добавляем поле job с значением "Eat maket"
    Дано Параметры создания пользователя:
      | keyUrl       |  endpoint    | method | statusCode | pathSchema                         | nameValue | jobValue  |
      | UrlReqresIn  |  /api/users  | POST   | 201        | reqres/SchemaCreateUserReqres.json | Tomato    | Eat maket |
    Тогда Отправляем запрос на создание пользователя и проверяем полученный ответ