import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/feature",
        glue = {"steps/api_rick_and_morty",
                "steps/api_open_url",
                "steps/api_reqres",
                "steps/api_request_respone",
                "hooks"},
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        plugin = {"pretty",
                "io.qameta.allure.cucumber6jvm.AllureCucumber6Jvm",
                "json:target/cucumber.json",
                "html:target/test-output"}
)

public class TestRunner {
}
