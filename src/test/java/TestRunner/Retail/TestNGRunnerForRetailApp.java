package TestRunner.Retail;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/Features/Retail",
        tags = "@no_tests",
       // tags = "@US01 or @US02 or @US03 or @US04 or @US05 or @US06 or @US07 or @US08 or @US09",  //Run All Features
        glue = "StepDefinitions",
        plugin ={"pretty","rerun:test-output/rerun.txt", "html:test-output/cucumber.html","json:test-output/cucumber.json","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        dryRun = false,
        monochrome = true
)

public class TestNGRunnerForRetailApp extends AbstractTestNGCucumberTests {

}
