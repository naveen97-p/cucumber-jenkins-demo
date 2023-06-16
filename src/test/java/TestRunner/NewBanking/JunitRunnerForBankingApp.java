package TestRunner.NewBanking;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/Features/Banking/newUI",
        tags = "@new-bank and @delegate-access",
       // tags = "@US05", //Run I-Frame Privacy&Consent Test
        //tags = "@US04", //Run I-Frame Preferences Test
        //tags = "@US01 or @US02 or @US03 or @US06 or @US07 or @US08",  //Run All Features
        glue = "StepDefinitions",
        plugin ={"pretty","rerun:output/rerun.txt", "html:output/cucumber.html","json:output/cucumber.json","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        dryRun = false,
        monochrome = true
)
public class JunitRunnerForBankingApp {

}
