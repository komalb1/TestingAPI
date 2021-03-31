package runners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue={"StepFactory.stepDef/GetRequest"},
        dryRun = true
)
public class TestRunner {

}
