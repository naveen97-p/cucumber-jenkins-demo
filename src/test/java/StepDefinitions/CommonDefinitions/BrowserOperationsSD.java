package StepDefinitions.CommonDefinitions;

import Utilities.BrowserInstance;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Then;

public class BrowserOperationsSD extends BrowserInstance {

    //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>COMMON CODE FOR ALL SDs<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
    private Scenario scenario;

    public void prepareFailureEvidence(String errorMessage){
        scenario.attach(captureScreen.takeScreenShot(),"image/png",errorMessage);
    }

    @Before
    public void beforeTest(Scenario scenario){
        this.scenario = scenario;
    }

    @After
    public void testScenarioCondition(){
        if (scenario.isFailed()){
            prepareFailureEvidence("Above scenario has been failed. Ref: Attachment");
            scenario.log("PageURL: "+driver.getCurrentUrl());
            scenario.log("Terminated the browser as a failure noticed in above scenario");
            driver.quit();
        }
    }
    //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>COMMON CODE FOR ALL SDs<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<


    @Then("User terminates the browser")
    public void user_terminates_the_browser() throws InterruptedException {
        //Thread.sleep(2);
        driver.close();
        scenario.log("Browser has been terminated by the User");
        System.out.println("Browser has been terminated by the User");

    }
    @Then("User terminates all windows of the browser")
    public void user_terminates_all_windows_of_the_browser() throws InterruptedException {
        Thread.sleep(2);
        driver.quit();

        System.out.println(driver);
        scenario.log("All windows have been terminated by the User");
        System.out.println("All windows have been terminated by the User");

    }
}
