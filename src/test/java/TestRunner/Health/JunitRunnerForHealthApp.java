package TestRunner.Health;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/Features/Health",
        tags = "@health",
        //tags = "@US06", //Run I-Frame Privacy&Consent Test
        //tags = "@US08", //Run I-Frame Preferences Test
       //tags = "@US01 or @US02 or @US03 or @US04 or @US05 or @US06 or @US07 or @US08 or @US09",  //Run All Test of Health
        glue = "StepDefinitions",
        plugin ={"pretty","rerun:output/rerun.txt", "html:output/cucumber.html","json:output/cucumber.json","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        dryRun = false,
        monochrome = true
)
public class JunitRunnerForHealthApp {

}
