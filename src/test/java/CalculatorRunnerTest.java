import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/feature/Calculator.feature",
        glue = "objects/steps/cucumber_calculator",
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        plugin = {"pretty",
                "io.qameta.allure.cucumber6jvm.AllureCucumber6Jvm",
                "json:target/cucumber.json",
                "html:target/test-output"}
)

public class CalculatorRunnerTest {
}