package TestRunner.All;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

import Utilities.*;


@RunWith(Cucumber.class)
@CucumberOptions(
        tags = "@retail-demo or @retail-dev or @banking or @health or @new-bank",
        //Tester must use the annotations as per the need in tags section

        features = "src/test/java/Features",
        glue = "StepDefinitions",
        plugin ={"pretty","rerun:output/rerun.txt", "html:output/cucumber.html","json:output/cucumber.json","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        dryRun = false,
        monochrome = true
)
public class JunitRunnerForAllApps extends CustomDateTimeFormat{

}
