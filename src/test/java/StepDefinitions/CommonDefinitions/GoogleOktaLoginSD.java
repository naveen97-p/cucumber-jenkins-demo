package StepDefinitions.CommonDefinitions;

import Configurations.Passcodes;
import Configurations.UrlRepo;
import Utilities.BrowserInstance;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Then;

public class GoogleOktaLoginSD extends BrowserInstance {
    //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>COMMON CODE FOR ALL SDs<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
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
    @Then("User provides google username {string} and password and logs in")
    public void userProvidesGoogleUsernameAndPasswordAndLogsIn(String googleUsername) {
        waitUtil.elementToBeLocated(googleOktaPage.googleEmailXpath);
        googleOktaPage.enterGoogleUsername(googleUsername);
        scenario.log("User has provided Gmail username");
        googleOktaPage.clickOnNextButton();
        scenario.log("User has clicked on Next button");
        waitUtil.elementToBeLocated(googleOktaPage.googlePasswordXpath);
        googleOktaPage.enterGooglePassword(Passcodes.GMAIL_PASSWORD);
        scenario.log("User has provided Gmail password");

    }

    @Then("User should sign out from Gmail account")
    public void userShouldSignOutFromGmailAccount() {
        BrowserInstance.getDriver(UrlRepo.GOOGLE_ACCOUNT_LOGOUT_URL);
        scenario.log("User has removed all Gmail account's passwords");
    }

}
