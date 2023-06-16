package TestRunner.Health;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/Features/Health",
        tags = "@no_tests",
        //tags = "@health-manage-roles",
        //tags = "@US01 or @US02 or @US03 or @US04 or @US05",  //Run All Features
        glue = "StepDefinitions",
        plugin ={"pretty","rerun:output/rerun.txt", "html:output/cucumber.html","json:output/cucumber.json","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        dryRun = false,
        monochrome = true
)

public class TestNGRunnerForHealthApp extends AbstractTestNGCucumberTests {

}
