package StepDefinitions.NewBank;

import Configurations.FilePaths;
import Configurations.Passcodes;
import Utilities.BrowserInstance;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;

import java.io.IOException;

public class NewBankWelcomeScreenSD extends BrowserInstance {
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

    @And("User verifies the new bank site is accessible")
    public void userVerifiesTheNewBankSiteIsAccessible() {
        waitUtil.elementToBeLocated(newBankWelcomePage.welcomeScreenRef,45);
        scenario.log("New Bank Page has been appeared as expected");
        String pageUrl = newBankWelcomePage.getPageUrl();
        Assert.assertEquals(pageUrl,newBankWelcomePage.welcomeScreenPageUrl);
        scenario.log("Page URl is appeared as expected, URL:"+pageUrl);
    }


    @And("User clicks on OpenAnAccount on new Bank app")
    public void userClicksOnOpenAnAccountOnNewBankApp() {
        waitUtil.elementToBeLocated(newBankWelcomePage.openAnAccountRefXpath,45);
        newBankWelcomePage.clickOnOpenAnAccountButton();
        scenario.log("User has clicked on Open An New Account");
    }

    @And("User clicks on ForgetPassword link on new Bank app")
    public void userClicksOnForgetPasswordOnNewBankApp() {
        try{
            waitUtil.elementToBeLocated(newBankWelcomePage.forgetPasswordLinkXpath,25);
        }
        catch(Exception ex){
            driver.navigate().refresh();
            waitUtil.elementToBeLocated(newBankWelcomePage.forgetPasswordLinkXpath,50);
        }

        newBankWelcomePage.clickOnForgetPasswordLink();
        scenario.log("User has clicked on Forget Password Link");
    }

    @And("User waits until the login section appears for new Bank app")
    public void userWaitsUntilTheLoginSectionAppearsForNewBankApp() {
        try{
            waitUtil.elementToBeLocated(newBankWelcomePage.loginSectionScreenRef,15);
        }
        catch(Exception ex){
            driver.navigate().refresh();
            waitUtil.elementToBeLocated(newBankWelcomePage.loginSectionScreenRef,30);
        }

        scenario.log("Login Section has appeared");
    }

    @Given("User provides {string} and  password for new bank app - static")
    public void userProvidesAndPasswordForNewBankAppStatic(String username) {
        waitUtil.elementToBeLocated(newBankWelcomePage.loginSectionScreenRef,15);
        newBankWelcomePage.enterUsername(username);
        scenario.log("User has provided username");
        newBankWelcomePage.enterPassword(Passcodes.NEW_BANKING_PASSWORD);
        scenario.log("User has provided password");
        newBankWelcomePage.clickOnSignOnButton();
        scenario.log("User has clicked on Sign-On button");
    }

    @Given("User provides {string} and  password for new bank app - previous")
    public void userProvidesAndPasswordForNewBankAppPrevious(String username) throws IOException {
        waitUtil.elementToBeLocated(newBankWelcomePage.loginSectionScreenRef,15);

        String data =readAndWriteTextFiles.readTextFile(FilePaths.NEW_BANK_REGISTER_EMAIL_INDEX_PATH);
        String usernameDb = readAndWriteTextFiles.getPreviouslyCreatedUsername(username,data);

        newBankWelcomePage.enterUsername(usernameDb);
        scenario.log("User has provided username");
        newBankWelcomePage.enterPassword(Passcodes.NEW_BANKING_PASSWORD);
        scenario.log("User has provided password");
        newBankWelcomePage.clickOnSignOnButton();
        scenario.log("User has clicked on Sign-On button");
    }

    @Then("User checks the invalid login message on login screen {string}")
    public void userChecksTheInvalidLoginMessageOnLoginScreen(String typeOfTesting) {
        if(!typeOfTesting.equalsIgnoreCase("positive")){
            try {
                waitUtil.elementToBeLocated(newBankWelcomePage.firstNameInvalidError, 20);
                scenario.log("Invalid Username error message has been verified");
            }catch (Exception ex){
                waitUtil.elementToBeLocated(newBankWelcomePage.passwordInvalidError, 20);
                scenario.log("Invalid Password or Username error message has been verified");
            }
        }
    }
}
