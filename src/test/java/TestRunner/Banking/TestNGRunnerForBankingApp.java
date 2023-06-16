package TestRunner.Banking;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/Features/Banking",
        //tags = "@US01 or @US02 or @US03 or @US04 or @US05 or @US06",  //Run All Features
        tags = "@no_tests",
        glue = "StepDefinitions",
        plugin ={"pretty","rerun:test-output/rerun.txt", "html:test-output/cucumber.html","json:test-output/cucumber.json","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        dryRun = false,
        monochrome = true
)

public class TestNGRunnerForBankingApp extends AbstractTestNGCucumberTests {

}
