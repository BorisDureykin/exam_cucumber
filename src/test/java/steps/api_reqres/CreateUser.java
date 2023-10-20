package steps.api_reqres;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.Затем;
import io.cucumber.java.ru.Тогда;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import steps.api_request_respone.RequestSpecificationAllTests;
import steps.api_request_respone.ResponseAllTests;

import java.util.List;
import java.util.Map;

import static hooks.Hooks.saveMessage;
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
    private static Response response;

    @Тогда("Отправляем запрос на создание пользователя")
    public static void createUser() {

        String url = getConfigValue(keyUrl);

        RequestSpecification request = RequestSpecificationAllTests.requestSpecificationAllTests(url);

        String body = UpdateJsonObject.getJsonObjectToString();

        response = responseGet(request, body, endpoint, method, statusCode, pathSchema);
    }

    @Затем("Сверяем ответ с ожидаемым значением полей name и job")
    public static void checkNameAndJob() {

        String actualName = response.path("name");

        String actualjob = response.path("job");

        String message = "Проверяем Поле 'name' на соответствие. Ожидаемое значение: " + nameValue + ", актуальное значение: " + actualName;

        saveMessage("Проверяем поле name", message);

        assertEquals(nameValue, actualName, "Поле 'name' не соответствует ожидаемому значению");

        message = "Проверяем Поле 'job' на соответствие. Ожидаемое значение: " + jobValue + ", актуальное значение: " + actualjob;

        saveMessage("Проверяем поле job ", message);

        assertEquals(jobValue, actualjob, "Поле 'job' не соответствует ожидаемому значению");

    }

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
}
