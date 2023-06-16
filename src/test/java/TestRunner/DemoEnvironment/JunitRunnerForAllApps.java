package TestRunner.DemoEnvironment;


import Utilities.CustomDateTimeFormat;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        tags = "@retail-demo or @banking or @health",
        features = "src/test/java/Features",
        glue = "StepDefinitions",
        plugin ={"pretty","rerun:output/rerun.txt", "html:output/cucumber.html","json:output/cucumber.json","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        dryRun = false,
        monochrome = true
)
public class JunitRunnerForAllApps extends CustomDateTimeFormat{

}

 //   mvn clean test -Dtest=TestRunner.DemoEnvironment.JunitRunnerForAllApps