package StepDefinitions.Banking;

import Utilities.BrowserInstance;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.testng.Assert;

public class BankingSignUpEmailSD extends BrowserInstance {

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

    @And("User tries for sign-up with email")
    public void userTriesForSignUpWithEmail() {
        waitUtil.elementToBeLocated(bankingSignUpPage.bankSignUpScreenRef,40);
        scenario.log("User has landed on Sign-Up page of Bank App");
        bankingSignUpPage.clickOnEmailSignUp();
        scenario.log("User has clicked on \"Sign-Up with Email\"");

    }

    @Given("User provides {string} on Sign-up Email page of Bank app and check if the message has been sent")
    public void userProvidesOnSignUpEmailPageOfBankAppAndCheckIfTheMessageHasBeenSent(String email) {
        waitUtil.elementToBeLocated(bankingSignUpPage.bankSignUpEmailScreenRef,40);
        scenario.log("User has landed on \"ENTER YOUR EMAIL page\" of Bank App");
        bankingSignUpPage.enterEmail(email);
        scenario.log("User has entered email address for Sign-Up");
        bankingSignUpPage.clickOnNext();
        scenario.log("User has clicked on Next button");
        waitUtil.elementToBeLocated(bankingSignUpPage.emailSentToYourMailAddressRef,30);
        scenario.log("Email has been sent text is verified.");
    }

    @And("User provides sign-up details like {string}, {string}, {string}, password and {string}")
    public void userProvidesSignUpDetailsLikePasswordAnd(String username, String firstname, String lastname, String termsAndConditions) {

            waitUtil.elementToBeLocated(bankingSignUpEmailPage.emailXpathOnSignUpPage);
            scenario.log("User has landed on Create New Account Page");
            bankingSignUpEmailPage.enterUsername(username);
            bankingSignUpEmailPage.enterFirstName(firstname);
            bankingSignUpEmailPage.enterLastName(lastname);
            bankingSignUpEmailPage.enterPassword();
            bankingSignUpEmailPage.enableTermsAndConditionsCheckBox(termsAndConditions);
            if(termsAndConditions.equalsIgnoreCase("True")){
                scenario.log("User has provided Username, Firstname, Lastname, Password and ENABLED-T&C");}
            else {
                scenario.log("User has provided Username, Firstname, Lastname, Password and DISABLED-T&C");
            }
            scenario.attach(captureScreen.takeScreenShot(),"image/png","Ref: User Registration Details");
            bankingSignUpEmailPage.clickOnCreateYourAccount();

    }
}
