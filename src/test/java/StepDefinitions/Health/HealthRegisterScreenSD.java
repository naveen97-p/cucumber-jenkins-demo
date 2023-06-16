package StepDefinitions.Health;

import Configurations.FilePaths;
import Utilities.BrowserInstance;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.testng.Assert;

import java.io.IOException;

public class HealthRegisterScreenSD extends BrowserInstance {

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




    @And("User provides invalid registration details like {string}, {string}, {string},{string},{string},{string}")
    public void userProvidesInValidRegistrationDetailsLike(String email, String firstName, String lastName, String userName, String termsAndCond,String receiveEmails ){
        waitUtil.elementToBeLocated(healthRegistrationPage.registrationInfoTextXpath);
        healthRegistrationPage.enterFirstName(firstName);
        scenario.log("User has filled firstname field");
        healthRegistrationPage.enterLastName(lastName);
        scenario.log("User has filled lastname field");
        healthRegistrationPage.enterEmail(email);
        scenario.log("User has filled email field");
        healthRegistrationPage.enterUsername(userName);
        scenario.log("User has filled username field");
        healthRegistrationPage.enterPassword();
        scenario.log("User has filled password field");
        healthRegistrationPage.enableTermsAndConditionsCheckBox(termsAndCond);
        scenario.log("User has chosen T&C decision as "+termsAndCond);
        healthRegistrationPage.enableReceiveEmailsCheckBox(receiveEmails);
        scenario.log("User has chosen Newsletter decision as "+receiveEmails);
        scenario.attach(captureScreen.takeScreenShot(),"image/png","User Provided details");
        healthRegistrationPage.clickOnSignUpButton();
        scenario.log("User has clicked on sign-up button");


        waitUtil.elementToBeLocated(healthRegistrationPage.failedRegMsgXpath);
        String actualErrorMsg= healthRegistrationPage.getSignUpFailedMessage();
        Assert.assertEquals(actualErrorMsg,"Cannot read properties of undefined (reading 'message')");
        scenario.log("Sign-Up has failed as expected due to invalid data");
        scenario.log("Actual Error Msg:"+actualErrorMsg);

    }


    @And("User provides valid registration details like {string}, {string}, {string},{string},{string},{string}")
    public void userProvidesValidRegistrationDetailsLike(String email, String firstName, String lastName, String userName, String termsAndCond,String receiveEmails ) throws IOException {
        waitUtil.elementToBeLocated(healthRegistrationPage.registrationInfoTextXpath);

        //Get the Index and Create Email and Username
        String data =readAndWriteTextFiles.readTextFile(FilePaths.HEALTH_SIGNUP_INDEX_PATH);
        String myEmail = readAndWriteTextFiles.createAnUniqueEmailEntry(email,data);
        String usernameFromEmail = readAndWriteTextFiles.getUsernameFromEmail(myEmail);

        healthRegistrationPage.enterFirstName(firstName);
        scenario.log("User has filled firstname field");
        healthRegistrationPage.enterLastName(lastName);
        scenario.log("User has filled lastname field");
        healthRegistrationPage.enterEmail(myEmail);
        scenario.log("User has filled email field");
        healthRegistrationPage.enterUsername(usernameFromEmail);
        scenario.log("User has filled username field");
        healthRegistrationPage.enterPassword();
        scenario.log("User has filled password field");
        healthRegistrationPage.enableTermsAndConditionsCheckBox(termsAndCond);
        scenario.log("User has chosen T&C decision as "+termsAndCond);
        healthRegistrationPage.enableReceiveEmailsCheckBox(receiveEmails);
        scenario.log("User has chosen Newsletter decision as "+receiveEmails);
        scenario.attach(captureScreen.takeScreenShot(),"image/png","User Provided details");
        healthRegistrationPage.clickOnSignUpButton();
        scenario.log("User has clicked on sign-up button");
    }


}
