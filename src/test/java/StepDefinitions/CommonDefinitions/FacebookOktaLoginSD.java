package StepDefinitions.CommonDefinitions;

import Configurations.Passcodes;
import Configurations.UrlRepo;
import Utilities.BrowserInstance;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Then;

public class FacebookOktaLoginSD extends BrowserInstance {

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

    @Then("User provides facebook username {string} and password and logs in")
    public void userProvidesFacebookUsernameAndPasswordAndLogsIn(String facebookUsername) {

        waitUtil.elementToBeLocated(facebookOktaPage.facebookEmailXpath,35);
        facebookOktaPage.enterFacebookEmailId(facebookUsername);
        scenario.log("User has provided Facebook username");
        waitUtil.elementToBeLocated(facebookOktaPage.facebookPasswordXpath,30);
        facebookOktaPage.enterFacebookPassword(Passcodes.FACEBOOK_PASSWORD);
        scenario.log("User has provided Facebook password");
        facebookOktaPage.clickOnLoginButton();
        scenario.log("User has clicked on Facebook login button");
    }


    @Then("User should sign out from Facebook account")
    public void userShouldSignOutFromFacebookAccount() {
        BrowserInstance.getDriver(UrlRepo.FACEBOOK_ACCOUNT_LOGOUT_URL);
        scenario.log("User has hit facebook logout link");
        waitUtil.elementToBeClickable(facebookOktaPage.facebookProfileIconXpath,40);
        facebookOktaPage.clickOnProfileIcon();
        waitUtil.elementToBeClickable(facebookOktaPage.facebookLogoutXpath,35);
        facebookOktaPage.clickOnLogoutButton();
        scenario.log("User has logged out from facebook");

    }

    @Then("User facebook account should not be active")
    public void userFacebookAccountShouldNotBeActive() {
        waitUtil.elementToBeLocated(facebookOktaPage.facebookEmailXpath,30);
        facebookOktaPage.enterFacebookEmailId("VERIFICATION CHECK");
    }
}
