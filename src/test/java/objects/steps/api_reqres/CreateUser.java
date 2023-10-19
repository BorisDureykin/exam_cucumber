package objects.steps.api_reqres;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.Тогда;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import objects.steps.api_all_request_respone.ResponseAllTests;

import java.util.List;
import java.util.Map;

import static hooks.WebHooks.saveMessage;
import static objects.steps.api_all_request_respone.RequestSpecificationAllTests.requestSpecificationAllTests;
import static objects.steps.api_reqres.UpdateJsonObject.getJsonObjectToString;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static util.Config.getConfigValue;


public class CreateUser extends ResponseAllTests {

    private static String keyUrl;
    private static String endpoint;
    private static String method;
    private static String statusCode;
    private static String pathSchema;
    private static String nameValue;
    private static String jobValue;

    @Дано("Параметры создания пользователя:")
    public void setDataTable(DataTable table) {
        List<Map<String, String>> parameters = table.asMaps(String.class, String.class);
        Map<String, String> params = parameters.get(0);
        keyUrl = params.get("keyUrl");
        endpoint = params.get("endpoint");
        method = params.get("method");
        statusCode = params.get("statusCode");
        pathSchema = params.get("pathSchema");
        nameValue = params.get("nameValue");
        jobValue = params.get("jobValue");
    }


    @Тогда("Отправляем запрос на создание пользователя и проверяем полученный ответ")
    public static void createUser() {

        String url = getConfigValue(keyUrl);

        RequestSpecification request = requestSpecificationAllTests(url);

        String body = getJsonObjectToString();

        Response response = responseGet(request, body, endpoint, method, statusCode, pathSchema);

        String message = "Проверяем Поле 'name' и Поле 'job' на соответствие ожидаемым значениям- 'name': " + nameValue + " 'job': " + jobValue;

        saveMessage("Проверяем поля ответа ", message);

        assertEquals(nameValue, response.path("name"), "Поле 'name' не соответствует ожидаемому значению");

        assertEquals(jobValue, response.path("job"), "Поле 'job' не соответствует ожидаемому значению");
    }
}
