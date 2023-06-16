package TestRunner.All;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/Features",
        tags = "@no_tests",
        glue = "StepDefinitions",
        plugin ={"pretty", "html:target/cucumber.html","json:target/cucumber.json","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        dryRun = false,
        monochrome = true
)

public class TestNGRunnerForAllApps extends AbstractTestNGCucumberTests {
}
