package StepDefinitions.Retail;

import Configurations.FilePaths;
import Utilities.BrowserInstance;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.testng.Assert;

import java.io.IOException;

public class RetailSignUpScreenSD extends BrowserInstance {
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

            // scenario.attach(captureScreen.takeScreenShot(), "image/png", "Above step has been failed. Ref: Attachment");
        }

    }

    @Given("User must signup with Email")
    public void userSignUpWithEmail() {
        waitUtil.elementToBeClickable(retailSignUpPage.signUpThroughEmailXpath,45);
        retailSignUpPage.clickOnSignUpViaEmail();
        scenario.log("User has clicked on signup via Email");
    }
    @Given("User must signup with Facebook")
    public void userSignUpWithFacebook() {
        waitUtil.elementToBeClickable(retailSignUpPage.signUpThroughFacebookXpath,45);
        retailSignUpPage.clickOnSignUpViaFacebook();
        scenario.log("User has clicked on signup via Facebook");
    }

    @Given("User must signup with Google")
    public void userSignUpWithGoogle() {
        waitUtil.elementToBeClickable(retailSignUpPage.signUpThroughGoogleXpath);
        retailSignUpPage.clickOnSignUpViaGoogle();
        scenario.log("User has clicked on signup via Google");
    }

    //Demo
    @And("User provides valid email signup details like {string}, {string}, {string},{string},{string}")
    public void userProvidesValidEmailSignupDetailsLike(String email, String firstName, String lastName, String termsAndCond, String receiveEmails) throws IOException {
        waitUtil.elementToBeLocated(retailSignUpWithEmailPage.emailXpathOnSignUpPage,45);

        //Get the Index and Create Email and Username
        String data =readAndWriteTextFiles.readTextFile(FilePaths.RETAIL_SIGNUP_INDEX_PATH);
        String myEmail = readAndWriteTextFiles.createAnUniqueEmailEntry(email,data);

        retailSignUpWithEmailPage.enterEmail(myEmail);
        scenario.log("User has filled email field");
        retailSignUpWithEmailPage.enterFirstName(firstName);
        scenario.log("User has filled firstname");
        retailSignUpWithEmailPage.enterLastName(lastName);
        scenario.log("User has filled lastname");
        retailSignUpWithEmailPage.enterPassword();
        scenario.log("User has filled password field");
        retailSignUpWithEmailPage.enterConfirmPassword();
        scenario.log("User has filled confirm password field");
        retailSignUpWithEmailPage.enableTermsAndConditionsCheckBox(termsAndCond);
        scenario.log("User has chosen T&C decision");
        retailSignUpWithEmailPage.enableReceiveEmailsCheckBox(receiveEmails);
        scenario.log("User has chosen Newsletter decision");
        scenario.attach(captureScreen.takeScreenShot(),"image/png","User Provided details");
        retailSignUpWithEmailPage.clickOnSignUpButton();
        scenario.log("User has clicked on sign-up button");
    }


    //Demo
    @And("User provides valid email signup details like {string}, {string}, {string},{string},{string} update password Demo")
    public void userProvidesValidEmailSignupDetailsLikeDemoPasswordUpdate(String email, String firstName, String lastName, String termsAndCond, String receiveEmails) throws IOException {
        waitUtil.elementToBeLocated(retailSignUpWithEmailPage.emailXpathOnSignUpPage,45);

        //Get the Index and Create Email and Username
        String data =readAndWriteTextFiles.readTextFile(FilePaths.RETAIL_DEMO_UPDATE_PASSWORD_INDEX);
        String myEmail = readAndWriteTextFiles.createAnUniqueEmailEntry(email,data);

        retailSignUpWithEmailPage.enterEmail(myEmail);
        scenario.log("User has filled email field");
        retailSignUpWithEmailPage.enterFirstName(firstName);
        scenario.log("User has filled firstname");
        retailSignUpWithEmailPage.enterLastName(lastName);
        scenario.log("User has filled lastname");
        retailSignUpWithEmailPage.enterPassword();
        scenario.log("User has filled password field");
        retailSignUpWithEmailPage.enterConfirmPassword();
        scenario.log("User has filled confirm password field");
        retailSignUpWithEmailPage.enableTermsAndConditionsCheckBox(termsAndCond);
        scenario.log("User has chosen T&C decision");
        retailSignUpWithEmailPage.enableReceiveEmailsCheckBox(receiveEmails);
        scenario.log("User has chosen Newsletter decision");
        scenario.attach(captureScreen.takeScreenShot(),"image/png","User Provided details");
        retailSignUpWithEmailPage.clickOnSignUpButton();
        scenario.log("User has clicked on sign-up button");
    }
    //Dev update password
    @And("User provides valid email signup details like {string}, {string}, {string},{string},{string} update password Dev")
    public void userProvidesValidEmailSignupDetailsLikeDevPasswordUpdate(String email, String firstName, String lastName, String termsAndCond, String receiveEmails) throws IOException {
        waitUtil.elementToBeLocated(retailSignUpWithEmailPage.emailXpathOnSignUpPage,45);

        //Get the Index and Create Email and Username
        String data =readAndWriteTextFiles.readTextFile(FilePaths.RETAIL_DEV_UPDATE_PASSWORD_INDEX);
        String myEmail = readAndWriteTextFiles.createAnUniqueEmailEntry(email,data);

        retailSignUpWithEmailPage.enterEmail(myEmail);
        scenario.log("User has filled email field");
        retailSignUpWithEmailPage.enterFirstName(firstName);
        scenario.log("User has filled firstname");
        retailSignUpWithEmailPage.enterLastName(lastName);
        scenario.log("User has filled lastname");
        retailSignUpWithEmailPage.enterPassword();
        scenario.log("User has filled password field");
        retailSignUpWithEmailPage.enterConfirmPassword();
        scenario.log("User has filled confirm password field");
        retailSignUpWithEmailPage.enableTermsAndConditionsCheckBox(termsAndCond);
        scenario.log("User has chosen T&C decision");
        retailSignUpWithEmailPage.enableReceiveEmailsCheckBox(receiveEmails);
        scenario.log("User has chosen Newsletter decision");
        scenario.attach(captureScreen.takeScreenShot(),"image/png","User Provided details");
        retailSignUpWithEmailPage.clickOnSignUpButton();
        scenario.log("User has clicked on sign-up button");
    }


    //Dev
    @And("User provides valid email signup details like {string}, {string}, {string},{string},{string} for Dev")
    public void userProvidesValidEmailSignupDetailsLikeForDev(String email, String firstName, String lastName, String termsAndCond, String receiveEmails) throws IOException {
        waitUtil.elementToBeLocated(retailSignUpWithEmailPage.emailXpathOnSignUpPage,45);

        //Get the Index and Create Email and Username
        String data =readAndWriteTextFiles.readTextFile(FilePaths.RETAIL_DEV_SIGNUP_INDEX_PATH);
        String myEmail = readAndWriteTextFiles.createAnUniqueEmailEntry(email,data);

        retailSignUpWithEmailPage.enterEmail(myEmail);
        scenario.log("User has filled email field");
        retailSignUpWithEmailPage.enterFirstName(firstName);
        scenario.log("User has filled firstname");
        retailSignUpWithEmailPage.enterLastName(lastName);
        scenario.log("User has filled lastname");
        retailSignUpWithEmailPage.enterPassword();
        scenario.log("User has filled password field");
        retailSignUpWithEmailPage.enterConfirmPassword();
        scenario.log("User has filled confirm password field");
        retailSignUpWithEmailPage.enableTermsAndConditionsCheckBox(termsAndCond);
        scenario.log("User has chosen T&C decision");
        retailSignUpWithEmailPage.enableReceiveEmailsCheckBox(receiveEmails);
        scenario.log("User has chosen Newsletter decision");
//        waitUtil.elementToBeLocated(retailSignUpWithEmailPage.capchaVerifyXpath);
//        retailSignUpWithEmailPage.clickOnCapchaVerify();
//        scenario.log("User has clicked on Captcha Verify");

        scenario.attach(captureScreen.takeScreenShot(),"image/png","User Provided details");

        retailSignUpWithEmailPage.clickOnSignUpButton();
        scenario.log("User has clicked on sign-up button");
    }




    @And("User provides invalid email signup details like {string}, {string}, {string},{string},{string}")
    public void userProvidesInvalidEmailSignupDetailsLike(String email, String firstName, String lastName, String termsAndCond, String receiveEmails) {
        waitUtil.elementToBeLocated(retailSignUpWithEmailPage.emailXpathOnSignUpPage,45);
        retailSignUpWithEmailPage.enterEmail(email);
        scenario.log("User has filled email field");
        retailSignUpWithEmailPage.enterFirstName(firstName);
        scenario.log("User has filled firstname");
        retailSignUpWithEmailPage.enterLastName(lastName);
        scenario.log("User has filled lastname");
        retailSignUpWithEmailPage.enterPassword();
        scenario.log("User has filled password field");
        retailSignUpWithEmailPage.enterConfirmPassword();
        scenario.log("User has filled confirm password field");

        retailSignUpWithEmailPage.enableTermsAndConditionsCheckBox(termsAndCond);
        scenario.log("User has chosen T&C decision");
        retailSignUpWithEmailPage.enableReceiveEmailsCheckBox(receiveEmails);
        scenario.log("User has chosen Newsletter decision");
        scenario.attach(captureScreen.takeScreenShot(),"image/png","User Provided details");
        retailSignUpWithEmailPage.clickOnSignUpButton();
        scenario.log("User has clicked on sign-up button");
        waitUtil.elementToBeLocated(retailSignUpWithEmailPage.failedSignUpXpath,40);
        String actualErrorMsg= retailSignUpWithEmailPage.getSignUpFailedMessage();
        Assert.assertEquals(actualErrorMsg,"Failed to register");
        scenario.log("Sign-Up has failed as expected due to invalid data");
        scenario.log("Actual Error Msg:"+actualErrorMsg);

    }

    @And("User provides valid email signup detail like {string}, {string} & {string}")
    public void userProvidesValidEmailSignupDetailsLike(String email, String termsAndCond, String receiveEmails) throws IOException {

        String data =readAndWriteTextFiles.readTextFile(FilePaths.RETAIL_SIGNUP_INDEX_PATH);
        String myEmail = readAndWriteTextFiles.createAnUniqueEmailEntry(email,data);

        waitUtil.elementToBeLocated(retailSignUpWithEmailPage.emailXpathOnSignUpPage,45);
        retailSignUpWithEmailPage.enterEmail(myEmail);
        scenario.log("User has filled email field");
        retailSignUpWithEmailPage.enterPassword();
        scenario.log("User has filled password field");
        retailSignUpWithEmailPage.enterConfirmPassword();
        scenario.log("User has filled confirm password field");
        retailSignUpWithEmailPage.enableTermsAndConditionsCheckBox(termsAndCond);
        scenario.log("User has chosen T&C decision");
        retailSignUpWithEmailPage.enableReceiveEmailsCheckBox(receiveEmails);
        scenario.log("User has chosen Newsletter decision");
        scenario.attach(captureScreen.takeScreenShot(),"image/png","User Provided details");
        retailSignUpWithEmailPage.clickOnSignUpButton();
        scenario.log("User has clicked on sign-up button");

    }


    //Progressive Profiling Sign-up
//Demo
    @And("User provides valid email signup details like {string}, {string}, {string} for Progressive Profiling")
    public void userProvidesValidEmailSignupDetailsForProgressiveProfiling(String email, String termsAndCond, String receiveEmails) throws IOException {

        String data =readAndWriteTextFiles.readTextFile(FilePaths.RETAIL_DEMO_PROGRESSIVE_PROFILING_INDEX_PATH);
        String myEmail = readAndWriteTextFiles.createAnUniqueEmailEntry(email,data);

        waitUtil.elementToBeLocated(retailSignUpWithEmailPage.emailXpathOnSignUpPage,45);
        retailSignUpWithEmailPage.enterEmail(myEmail);
        scenario.log("User has filled email field");
        retailSignUpWithEmailPage.enterPassword();
        scenario.log("User has filled password field");
        retailSignUpWithEmailPage.enterConfirmPassword();
        scenario.log("User has filled confirm password field");
        retailSignUpWithEmailPage.enableTermsAndConditionsCheckBox(termsAndCond);
        scenario.log("User has chosen T&C decision");
        retailSignUpWithEmailPage.enableReceiveEmailsCheckBox(receiveEmails);
        scenario.log("User has chosen Newsletter decision");
        scenario.attach(captureScreen.takeScreenShot(),"image/png","User Provided details");
        retailSignUpWithEmailPage.clickOnSignUpButton();
        scenario.log("User has clicked on sign-up button");
    }

    //Dev
    @And("User provides valid email signup details like {string}, {string}, {string} for Progressive Profiling for Dev")
    public void userProvidesValidEmailSignupDetailsForProgressiveProfilingDev(String email, String termsAndCond, String receiveEmails) throws IOException {

        String data =readAndWriteTextFiles.readTextFile(FilePaths.RETAIL_DEV_PROGRESSIVE_PROFILING_INDEX_PATH);
        String myEmail = readAndWriteTextFiles.createAnUniqueEmailEntry(email,data);

        waitUtil.elementToBeLocated(retailSignUpWithEmailPage.emailXpathOnSignUpPage,45);
        retailSignUpWithEmailPage.enterEmail(myEmail);
        scenario.log("User has filled email field");
        retailSignUpWithEmailPage.enterPassword();
        scenario.log("User has filled password field");
        retailSignUpWithEmailPage.enterConfirmPassword();
        scenario.log("User has filled confirm password field");
        retailSignUpWithEmailPage.enableTermsAndConditionsCheckBox(termsAndCond);
        scenario.log("User has chosen T&C decision");
        retailSignUpWithEmailPage.enableReceiveEmailsCheckBox(receiveEmails);
        scenario.log("User has chosen Newsletter decision");
        scenario.attach(captureScreen.takeScreenShot(),"image/png","User Provided details");
        retailSignUpWithEmailPage.clickOnSignUpButton();
        scenario.log("User has clicked on sign-up button");
    }

}
