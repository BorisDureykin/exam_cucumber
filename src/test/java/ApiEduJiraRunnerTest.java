import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/feature/ApiEduJira.feature",
        glue = {"objects/steps/api_edu_jira","objects/steps/api_all_request_respone", "hooks"},
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        plugin = {"pretty",
                "io.qameta.allure.cucumber6jvm.AllureCucumber6Jvm",
                "json:target/cucumber.json",
                "html:target/test-output"}
)
public class ApiEduJiraRunnerTest {
}
