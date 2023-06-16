package StepDefinitions.Banking;

import Utilities.BrowserInstance;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class BankingWelcomeScreenSD extends BrowserInstance {
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

    @And("User lands on Welcome page of Bank application")
    public void userLandsOnWelcomePageOfBankApplication() {
        waitUtil.elementToBeLocated(bankingWelcomePage.bankWelcomeScreenRef,45);
        scenario.log("User has landed on Welcome page of Bank App");
        String actualURL= bankingWelcomePage.getWelcomePageUrl();
        String expectedURL=bankingWelcomePage.bankWelcomeScreenPageUrl;
        Assert.assertEquals(actualURL,expectedURL,"Invalid Page URL, Expected:\""+expectedURL+"\", Actual:\""+actualURL+"\"");
    }

    @Then("User clicks on signup button on Welcome page of Bank app")
    public void userClicksOnSignUpButtonOnWelcomePageOfBankApp() {
        bankingWelcomePage.clickOnSignUpButton();
        scenario.log("User has clicked on Sign-Up button");
    }

    @Then("User clicks on login button on Welcome page of Bank app")
    public void userClicksOnLoginButtonOnWelcomePageOfBankApp() {
        bankingWelcomePage.clickOnLoginButton();
        scenario.log("User has clicked on Login button");
    }

    @Then("User clicks on CreateNewAccount button on Welcome page of Bank app")
    public void userClicksOnCreateNewAccButtonOnWelcomePageOfBankApp() {
        bankingWelcomePage.clickOnOpenNewAccountButton();
        scenario.log("User has clicked on Create New Account button");
    }



}
