import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {"pretty"},
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        features = "src/e2e-tests/resources/features",
        glue = "com.qa.lemonade.change.stepdefinitions",
        tags = "@e2e and not @WIP"
)
public class CucumberTestSuite {
}
