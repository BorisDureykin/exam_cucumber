package steps.api_open_url;

import io.cucumber.java.ru.Когда;
import steps.api_request_respone.RequestSpecificationAllTests;
import steps.api_request_respone.ResponseAllTests;

import static util.Config.getConfigValue;

public class OpenUrlApi extends RequestSpecificationAllTests {


    @Когда("Открываем {string}, c endpoint = {string},  method = {string} сверяем statusCode = {string} и  pathSchema = {string}")
    public static void openUrlApi(String keyUrl, String endpoint, String method, String statusCode, String pathSchema) {

        String url = getConfigValue(keyUrl);

        ResponseAllTests.responseGet(requestSpecificationAllTests(url), null, endpoint, method, statusCode, pathSchema);
    }
}
