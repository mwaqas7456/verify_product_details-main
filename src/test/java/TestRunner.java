import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources",
        glue = "stepDefinitions",
        plugin = {"pretty", "html:target/cucumber-html-report.html"},
        monochrome = true
)
public class TestRunner {
}
