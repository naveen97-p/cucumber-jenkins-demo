package TestRunner.JenkinsRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/Features/JenkinsDemo",
       tags="@simple-test",
        glue = "StepDefinitions",
        plugin ={"pretty","rerun:output/rerun.txt", "html:output/cucumber.html","json:output/cucumber.json","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        dryRun = false,
        monochrome = true
)
public class JunitRunnerForJenkins {

}
