package runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions (
					tags = (""),
					features = "src/test/resources/features",
					glue = "stepDefination1",
					plugin = {"html:target/cucumber-reports", "json:target/cucumber.json",
						  "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
					monochrome = true
					)

public class SmokeRunnerTest {


}
