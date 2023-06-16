package TestRunner.Retail;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/Features/Retail",
        //tags = "@retail-demo and @US05 or @retail-demo and @US07 or @retail-demo and @US09",
       tags="@simple-test",
      //  tags="@US01 or @US02 or @US03 or @US04 or @US06 or @US08 or @US09",
      // tags = "@US01 or @US02 or @US03 or @US04 or @US05 or @US06 or @US07 or @US08 or @US09",  //Run All Features
        glue = "StepDefinitions",
        plugin ={"pretty","rerun:output/rerun.txt", "html:output/cucumber.html","json:output/cucumber.json","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        dryRun = false,
        monochrome = true
)
public class JunitRunnerForRetailApp {

}
