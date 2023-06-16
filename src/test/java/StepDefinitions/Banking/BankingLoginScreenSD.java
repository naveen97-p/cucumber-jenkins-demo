package StepDefinitions.Banking;

import Configurations.Passcodes;
import Utilities.BrowserInstance;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

public class BankingLoginScreenSD extends BrowserInstance {
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

    @And("User lands on login page of Bank Application")
    public void userLandsOnLoginPageOfBankApplication() {
        waitUtil.elementToBeLocated(bankingLoginPage.bankLoginScreenRef);
        scenario.log("User is landed on Login page");
    }


    @Given("provides {string}, password then login")
    public void providesPasswordThenLogin(String username) {
        waitUtil.elementToBeLocated(bankingLoginPage.bankLoginUsernameFieldRefXpath);
        bankingLoginPage.enterUsername(username);
        scenario.log("User has entered username");
        bankingLoginPage.enterPassword(Passcodes.BANKING_PASSWORD);
        scenario.log("User has entered password");
        bankingLoginPage.clickOnLoginButton();
        scenario.log("User has clicked on login");
    }
    @Given("provides {string}, new password then login")
    public void providesNewPasswordThenLogin(String username) {
        waitUtil.elementToBeLocated(bankingLoginPage.bankLoginUsernameFieldRefXpath);
        bankingLoginPage.enterUsername(username);
        scenario.log("User has entered username");
        bankingLoginPage.enterPassword(Passcodes.UPDATE_PASSWORD);
        scenario.log("User has entered password");
        bankingLoginPage.clickOnLoginButton();
        scenario.log("User has clicked on login");
    }

}
