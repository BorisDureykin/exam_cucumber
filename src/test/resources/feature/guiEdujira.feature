# language: ru

@GUI
@ifellowEduJiraTestsGui
Функция: ifellow Edu Jira Tests GUI

  @ПроверкаДоступностиСайта
  Сценарий: Открываем URL, проверяем URL и TitlePage
    Когда Открываем "UrlIfellowJira"
    Тогда Проверяем URL "UrlIfellowJira" и TitlePage "System Dashboard - Jira"

  @АвторизацияПозитивныйКейс
  Сценарий: Авторизация
    Когда Открываем "UrlIfellowJira"
    Тогда Вводим "login" вводим "password" и нажимаем Войти
    Когда Заходим в профиль
    То Сверяем имя профиля с "login"

  @АвторизацияНеверныйЛогин
  Сценарий: Авторизация
    Когда Открываем "UrlIfellowJira"
    Тогда Вводим "AAAA" вводим "password" и нажимаем Войти
    То Проверяем сообщение о неверной авторизации

  @АвторизацияНеверныйПароль
  Сценарий: Авторизация
    Когда Открываем "UrlIfellowJira"
    Тогда Вводим "login" вводим "QQQQQQ" и нажимаем Войти
    То Проверяем сообщение о неверной авторизации

  @ПодсчетЗадач
  Сценарий: "Вход в проект TEST и проверка количества задач в проекте
    Когда Открываем "UrlIfellowJira"
    Тогда Вводим "login" вводим "password" и нажимаем Войти
    Затем Заходим в проект "TEST"
    Затем Выводим количество задач в проекте "TEST"
    Дано Параметры получения ключа проекта:
      | nameCoToProject  |  endpoint             | method | statusCode | pathSchema                               |
      | TEST             | /rest/api/2/project/  | GET    | 200        | ifellow_edu_jira/schemaGetProjectKey.json|
    Тогда Получаем ключ продукта
    Дано Параметры получения колмчества задач в проекте:
      |  endpoint             | method | statusCode | pathSchema                               |
      | /rest/api/2/search    | GET    | 200        | ifellow_edu_jira/schemaSearch.json       |
    Тогда Получаем количество задач в проекте API
    Тогда Сравниваем количество задач в проекте "TEST" полученное по API и отображаемое на экране

  @ПоискЗадачи
  Сценарий: Поиск задачи по имени и просмотр статуса задачи и привязку к версии
    Когда Открываем "UrlIfellowJira"
    Тогда Вводим "login" вводим "password" и нажимаем Войти
    Когда Заходим в профиль
    Затем Производим поиск задачи "TestSelenium"
    Затем Сверяем статус задачи с ожидаемым: "Сделать"
    И Сверяем поле 'затронуты версии', ожидаемое значение: "Version 2.0"

  @СозданиеЗадачи
  Сценарий: Создаем задачу и переводим созданную задачу по статусам
    Когда Открываем "UrlIfellowJira"
    Тогда Вводим "login" вводим "password" и нажимаем Войти
    Затем Создаем задачу с типом Ошибка и темой "Create Issue student AT14 GUI Cucumber" и получаем номер созданной задачи
    И Переводим созданную задачу по статусам GUI

  @СозданиеЗадачиБезТемы
  Сценарий: Создаем задачу без заполнения темы и проверяем сообщение об ошибке
    Когда Открываем "UrlIfellowJira"
    Тогда Вводим "login" вводим "password" и нажимаем Войти
    Затем Создаем задачу с типом Ошибка и темой "" и получаем номер созданной задачи