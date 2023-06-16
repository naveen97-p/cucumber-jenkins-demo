package StepDefinitions.NewBank;

import Configurations.FilePaths;
import Configurations.Passcodes;
import Utilities.BrowserInstance;
import Utilities.WriteToCSV;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ExecutionException;

public class NewBankRegistrationScreenSD extends BrowserInstance {
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

    @Given("User provides the account creation using {string} and submit")
    public void userProvidesTheAccountCreationUsingAndSubmit(String modeOfRegistration) throws Exception {
        if(modeOfRegistration.equalsIgnoreCase("GOVT_ID")){
            waitUtil.elementToBeLocated(newBankOpenAnAccountPage.openAnAccScreenRef,45);
            newBankOpenAnAccountPage.clickOnGovtIdVerificationRadioButton();
            scenario.log("User has clicked on Sign-Up through Gov.t Issued ID Verification");
            waitUtil.elementToBeClickable(newBankOpenAnAccountPage.continueButtonRefXpathForOpenAnAccDecision,30);
            newBankOpenAnAccountPage.clickOnDecisionSignUpButton();
        }
        else if (modeOfRegistration.equalsIgnoreCase("EMAIL")) {
            waitUtil.elementToBeLocated(newBankOpenAnAccountPage.openAnAccScreenRef,45);
            newBankOpenAnAccountPage.clickOnRegistrationFormRadioButton();
            scenario.log("User has clicked on Sign-Up through Email MFA");
            waitUtil.elementToBeClickable(newBankOpenAnAccountPage.continueButtonRefXpathForOpenAnAccDecision,30);
            newBankOpenAnAccountPage.clickOnDecisionSignUpButton();

        }else{
            throw new Exception("Kindly provide the mode of registration as per the standard keys. Eg: GOVT_ID for Registration Using Govt ID or EMAIL for Registration using Email MFA process in the Parameterization.");
        }
    }

    @Given("User provides the {string} to complete the verification {string} and continue")
    public void userProvidesTheToCompleteTheVerificationAndContinue(String email, String typeOfTesting) throws InterruptedException, IOException {
        //Get the Index and Create Email and Username
        String data =readAndWriteTextFiles.readTextFile(FilePaths.NEW_BANK_REGISTER_GOVT_INDEX_PATH);
        String myEmail = readAndWriteTextFiles.createAnUniqueEmailEntry(email,data);


        waitUtil.elementToBeLocated(newBankOpenAnAccountPage.welcomeOnBoardPageRefXpath,45);
        Assert.assertEquals(newBankOpenAnAccountPage.getPageUrl(),newBankOpenAnAccountPage.onBoardSignUpVerifyURL);
        scenario.log("Welcome On Board URL has been verified");
        if(!(typeOfTesting.equalsIgnoreCase("positive"))){
            newBankOpenAnAccountPage.provideEmailToOnBoardNewUser(email);
        }else {
            newBankOpenAnAccountPage.provideEmailToOnBoardNewUser(myEmail);
        }
        scenario.log("User has provided the email address");
        newBankOpenAnAccountPage.enableTermsAndConditionsCheckBoxForOnBoardUser();
        scenario.log("User has clicked on T&C check box");
        newBankOpenAnAccountPage.clickOnContinueButtonForWelcomeOnboard();
        scenario.log("User has clicked on Continue");
        if(!(typeOfTesting.equalsIgnoreCase("positive"))){
            waitUtil.elementToBeLocated(newBankOpenAnAccountPage.existingUserErrorMsgForOnBoardGovtVerificationUserErrorMsg,45);
            scenario.log(email+" has been already registered error message verified");
            }
        }

     @Then("User saves the {string} Registration via Govt ID data to CSV file for new Bank site")
     public void userSavesTheRegistrationViaGovtIdDataToCsvFile(String email) throws IOException {
         //Username,Password, FirstName, LastName, Email, NewsLetters
         //Get the Index and Create Email and Username
         String data =readAndWriteTextFiles.readTextFile(FilePaths.NEW_BANK_REGISTER_GOVT_INDEX_PATH);
         String myEmail = readAndWriteTextFiles.createAnUniqueEmailEntry(email,data);
         //Update if the data is used
         readAndWriteTextFiles.updateTextFile(data, FilePaths.NEW_BANK_REGISTER_GOVT_INDEX_PATH);

         String feedDataFormat = myEmail;
         try {
             WriteToCSV.feedDataToCSVFile(feedDataFormat, true, FilePaths.NEW_BANKING_TEST_SIGN_UP_GOVT_DATA_PATH);
             scenario.log("Test Data is loaded to CSV file in this path:"+ FilePaths.NEW_BANKING_TEST_SIGN_UP_GOVT_DATA_PATH);
         }
         catch (IOException exception){
             scenario.log("Kindly create or keep the file with name as: \"NewBankRegisterGovtIDData.csv\" in this path: "+ FilePaths.NEW_BANKING_TEST_SIGN_UP_GOVT_DATA_PATH);
             scenario.log("Error Details:"+exception);
         }

     }

    @Then("User completes Identity Verification for {string} and clicks on continue {string}")
    public void userCompletesIdentityVerificationAndClicksOnContinue(String email, String typeOfTesting) throws IOException {
        if(typeOfTesting.equalsIgnoreCase("positive")){
            waitUtil.elementToBeLocated(newBankOpenAnAccountPage.verifyYourIdentityScreenRef,45);
            //Save the Created Data
            userSavesTheRegistrationViaGovtIdDataToCsvFile(email);
            Assert.assertEquals(newBankOpenAnAccountPage.getPageUrl(),newBankOpenAnAccountPage.onBoardSignUpVerifyURL);
            scenario.log("Verify Identity URL has been verified");
            newBankOpenAnAccountPage.clickOnContinueButtonForVerifyIdentity();
            scenario.log("User has clicked on Continue");
        }
        else{
            scenario.log("Skipping the Test as it falls under Negative testing");
        }
    }

    @Then("User clicks waits for QR code to appear along with the secret code {string}")
    public void userClicksWaitsForQRCodeToAppearAlongWithTheSecretCode(String typeOfTesting) {
        if(typeOfTesting.equalsIgnoreCase("positive")){
            waitUtil.elementToBeLocated(newBankOpenAnAccountPage.verifyMFACodeScreenRef,45);
            scenario.log("QR Code Page has been verified");
            Assert.assertEquals(newBankOpenAnAccountPage.getPageUrl(),newBankOpenAnAccountPage.onBoardSignUpVerifyURL);
            scenario.log("QR Code Page URL has been verified");
        }
        else{
            scenario.log("Skipping the Test as it falls under Negative testing");
        }
    }

    @And("User clicks on Terms and Condition link on Welcome On Board Page")
    public void userClicksOnTermsAndConditionLinkOnWelcomeOnBoardPage() {
        waitUtil.elementToBeLocated(newBankOpenAnAccountPage.welcomeOnBoardPageRefXpath,45);
        Assert.assertEquals(newBankOpenAnAccountPage.getPageUrl(),newBankOpenAnAccountPage.onBoardSignUpVerifyURL);
        scenario.log("Welcome On Board URL has been verified");
        waitUtil.elementToBeClickable(newBankOpenAnAccountPage.termsAndConditionsForWelcomeOnBoardPageXpath,30);
        newBankOpenAnAccountPage.clickOnTermsAndConditionsLinkOnWelcomeOnBoardPage();
        scenario.log("User has clicked on Terms & Conditions hyper link");
    }

    @And("User clicks on Terms and Condition link on Registration Welcome On Board Page")
    public void userClicksOnTermsAndConditionLinkOnRegWelcomeOnBoardPage() {
        waitUtil.elementToBeLocated(newBankOpenAnAccountPage.welcomeOnBoardPageRefXpath,45);
        Assert.assertEquals(newBankOpenAnAccountPage.getPageUrl(),newBankOpenAnAccountPage.onBoardRegSignUpVerifyURL);
        scenario.log("Welcome On Board URL has been verified");
        waitUtil.elementToBeClickable(newBankOpenAnAccountPage.termsAndConditionsForWelcomeOnBoardPageXpath,30);
        newBankOpenAnAccountPage.clickOnTermsAndConditionsLinkOnWelcomeOnBoardPage();
        scenario.log("User has clicked on Terms & Conditions hyper link");
    }


    @Then("User opens Terms and Conditions page in new window, Page URL and Information should be appeared as expected")
    public void userOpensTermsAndConditionsPageInNewWindowPageURLAndInformationShouldBeAppearedAsExpected() {
        String climbWindow=driver.getWindowHandle();//new-bank-app
        String child_window=null;
        Set<String> s=driver.getWindowHandles();//2
        // Now iterate using Iterator
        Iterator<String> I1= s.iterator();
        while(I1.hasNext())
        {
            child_window = I1.next();
            if (!climbWindow.equals(child_window)) {
                driver.switchTo().window(child_window);
                scenario.log("User has switched from Welcome On Board page > Terms & Condition page");
                break;
            }
        }
        //Deloitte Security Access Token Mechanism
//        waitUtil.elementToBeLocated(deloitteSecurityLayerPage.accessThroughEntryTokenXpath);
//        deloitteSecurityLayerPage.clickOnAccessThroughEntryToken();
//        scenario.log("User is clicked on AccessThroughEntryToken");
//        waitUtil.elementToBeClickable(deloitteSecurityLayerPage.enterTokenXpath);
//        deloitteSecurityLayerPage.enterAccessToken(Passcodes.ENTRY_TOKEN_FOR_NEW_BANKING);
//        scenario.log("User has provided Access Token");
//        deloitteSecurityLayerPage.clickOnSubmitButton();
//        scenario.log("User has received the Access to Deloitte");
        //End of Module

        try{
            waitUtil.elementToBeLocated(newBankOpenAnAccountPage.termsAndConditionUiTextXpath,40);
            scenario.log("Terms & Conditions Page UI text is appeared as expected");
        }
        catch(Exception ex){
            driver.navigate().refresh();
            waitUtil.elementToBeLocated(newBankOpenAnAccountPage.termsAndConditionUiTextXpath,50);
            scenario.log("Terms & Conditions Page UI text is appeared as expected");
        }

        Assert.assertEquals(newBankOpenAnAccountPage.getPageUrl(),newBankOpenAnAccountPage.termsAndConditionsPageURLforWelcomeOnBoard);
        scenario.log("T&C Page URL has been verified");


    }

    @Given("User provides {string}, {string}, {string}, {string}, {string} and password for Signup page of new Bank app")
    public void userProvidesAndPasswordForSignupPageOfNewBankApp(String email, String firstname, String lastname, String username, String typeOfTesting) throws IOException {
        try {
            waitUtil.elementToBeLocated(newBankSignUpPage.registrationScreenRef, 35);
        }
        catch(Exception ex){
            driver.navigate().refresh();
            waitUtil.elementToBeLocated(newBankSignUpPage.registrationScreenRef, 45);
        }
        scenario.log("Registration via Email Page has been appeared as expected");
        Assert.assertEquals(newBankSignUpPage.getPageUrl(), newBankSignUpPage.registerUserPageUrl);
        scenario.log("Registration via Email Page URL is verified as expected");

        String data =readAndWriteTextFiles.readTextFile(FilePaths.NEW_BANK_REGISTER_EMAIL_INDEX_PATH);
        String myEmail = readAndWriteTextFiles.createAnUniqueEmailEntry(email,data);
        String usernameWithIndex = readAndWriteTextFiles.getUsernameFromEmailAndIndex(email, data);


        if(typeOfTesting.equalsIgnoreCase("positive")){
            newBankSignUpPage.enterEmail(myEmail);
            scenario.log("User has provided the Email address");
            newBankSignUpPage.enterFirstname(firstname);
            scenario.log("User has provided the FirstName");
            newBankSignUpPage.enterLastname(lastname);
            scenario.log("User has provided the LastName");
            newBankSignUpPage.enterUsername(usernameWithIndex);
            scenario.log("User has provided the Username");
            newBankSignUpPage.enterPassword(Passcodes.NEW_BANKING_PASSWORD);
            scenario.log("User has provided the password");
            newBankSignUpPage.enterConfirmPassword(Passcodes.NEW_BANKING_PASSWORD);
            scenario.log("User has provided the confirm password");
            newBankSignUpPage.enableTermsAndConditionsCheckBoxForOnBoardUser();
            scenario.log("User has enabled the T&C");
            newBankSignUpPage.clickOnRegisterButton();
            scenario.log("User has clicked on Register button");
            waitUtil.elementToBeLocated(newBankSignUpPage.selectMfaRefScreenXpath);
            Assert.assertEquals(newBankSignUpPage.getPageUrl(),newBankSignUpPage.selectMfaRefPageUrl);
            scenario.log("User has landed on Select MFA page and URL has been verified as expected");
            newBankSignUpPage.clickOnIWillDoItLaterLink();
            scenario.log("User has skipped the MFA device registration");

        }else{
            newBankSignUpPage.enterEmail(email);
            scenario.log("User has provided the Email address");
            newBankSignUpPage.enterFirstname(firstname);
            scenario.log("User has provided the firstname");
            newBankSignUpPage.enterLastname(lastname);
            scenario.log("User has provided the lastname");
            newBankSignUpPage.enterUsername(username);
            scenario.log("User has provided the Username");
            newBankSignUpPage.enterPassword(Passcodes.NEW_BANKING_PASSWORD);
            scenario.log("User has provided the password");
            newBankSignUpPage.enterConfirmPassword(Passcodes.NEW_BANKING_PASSWORD);
            scenario.log("User has provided the confirm password");
            newBankSignUpPage.enableTermsAndConditionsCheckBoxForOnBoardUser();
            scenario.log("User has enabled the T&C");
            newBankSignUpPage.clickOnRegisterButton();
            scenario.log("User has clicked on Register button");
            waitUtil.elementToBeLocated(newBankSignUpPage.emailAlreadyRegisteredErrorMsgXpath,40);
            scenario.log("\"email: is unique but a non-unique value is provided\" error message has been verified");
        }
    }


    @Then("User lands on setup new password page")
    public void userLandsOnSetupNewPasswordPage() {
        waitUtil.elementToBeLocated(newBankWelcomePage.setupNewPasswordRefScreenXpath);
        scenario.log("User has landed on Setup New Password Page");
        Assert.assertEquals(newBankWelcomePage.getPageUrl(),newBankWelcomePage.setupForgetPasswordPageUrl);
        scenario.log("Setup Password Page URL has been verified");
    }

    @Then("User provides new password, confirm password and submit the form")
    public void userProvidesNewPasswordConfirmPasswordAndSubmitTheForm() {
        waitUtil.elementToBeLocated(newBankWelcomePage.setupNewPasswordRefScreenXpath);
        String randomPasscode = randomStrings.getRandomFormatOfPasscode(4,4,3);
        //randomPasscode value should be saved in txt file to use it for normal login password
        newBankWelcomePage.enterNewPasswordForForgetPassword(randomPasscode);
        scenario.log("User has provided new Password");
        newBankWelcomePage.enterConfirmNewPasswordForForgetPassword(randomPasscode);
        scenario.log("User has provided confirm new Password");
        newBankWelcomePage.clickOnSubmitSetupForgetPassword();
        scenario.log("User has clicked on Submit forget password form");
    }
    @Then("User provides invalid new password, confirm password and submit the form")
    public void userProvidesInvalidNewPasswordConfirmPasswordAndSubmitTheForm() {
        waitUtil.elementToBeLocated(newBankWelcomePage.setupNewPasswordRefScreenXpath);
        String randomPasscode = randomStrings.getRandomStringOfLowerCase(5);
        //randomPasscode value should be saved in txt file to use it for normal login password
        newBankWelcomePage.enterNewPasswordForForgetPassword(randomPasscode);
        scenario.log("User has provided invalid new Password");
        newBankWelcomePage.enterConfirmNewPasswordForForgetPassword(randomPasscode);
        scenario.log("User has provided invalid confirm new Password");
        newBankWelcomePage.clickOnSubmitSetupForgetPassword();
        scenario.log("User has clicked on Submit forget password form");
        waitUtil.elementToBeLocated(newBankWelcomePage.errorMessageForInvalidPasswordPolicy);
        scenario.log("Site isn't allowing further as User's password doesn't meet the password policy requirement");
    }

    @Given("User provides {string} to forget password page and verifies the UI text information")
    public void userProvidesToForgetPasswordPageAndVerifiesTheUITextInformation(String email) {
        String climbWindow=driver.getWindowHandle();//new-bank-app
        String child_window=null;
        Set<String> s=driver.getWindowHandles();//2
        // Now iterate using Iterator
        Iterator<String> I1= s.iterator();
        while(I1.hasNext())
        {
            child_window = I1.next();
            if (!climbWindow.equals(child_window)) {
                driver.switchTo().window(child_window);
                scenario.log("User has switched from Welcome On Board page > Forget Password page");
                break;
            }
        }

        //Deloitte Security Access Token Mechanism
//        waitUtil.elementToBeLocated(deloitteSecurityLayerPage.accessThroughEntryTokenXpath);
//        deloitteSecurityLayerPage.clickOnAccessThroughEntryToken();
//        scenario.log("User is clicked on AccessThroughEntryToken");
//        waitUtil.elementToBeClickable(deloitteSecurityLayerPage.enterTokenXpath);
//        deloitteSecurityLayerPage.enterAccessToken(Passcodes.ENTRY_TOKEN_FOR_NEW_BANKING);
//        scenario.log("User has provided Access Token");
//        deloitteSecurityLayerPage.clickOnSubmitButton();
//        scenario.log("User has received the Access to Deloitte");
        //End of Module
        try{
            waitUtil.elementToBeLocated(newBankWelcomePage.forgetPasswordRefScreenXpath,30);
            scenario.log("User has landed on Forget Password Page");
        }
        catch(Exception ex){
            driver.navigate().refresh();
            waitUtil.elementToBeLocated(newBankWelcomePage.forgetPasswordRefScreenXpath,30);
            scenario.log("User has landed on Forget Password Page");
        }

            Assert.assertEquals(newBankWelcomePage.getPageUrl(),newBankWelcomePage.forgetPasswordPageUrl);
            scenario.log("Forget Password Page URL has been verified");

            newBankWelcomePage.enterUsernameForgetPassword(email);
            scenario.log("User has provided email to get the recovery code");
            newBankWelcomePage.clickOnSubmitForgetPassword();
            scenario.log("User has clicked on submit forget password to get the recovery code");
    }


    @Then("User provides invalid recovery token for setup new password form")
    public void userProvidesInvalidRecoveryTokenForSetupNewPasswordForm() {
        waitUtil.elementToBeLocated(newBankWelcomePage.setupNewPasswordRefScreenXpath);
        scenario.log("User has landed on Setup New Password Page");
        newBankWelcomePage.enterRecoveryCodeForForgetPassword("iNvaLiDC");
        scenario.log("User has provide the Invalid Recovery code to setup new password page");
        String randomPasscode = randomStrings.getRandomFormatOfPasscode(4,4,3);
        //randomPasscode value should be saved in txt file to use it for normal login password
        newBankWelcomePage.enterNewPasswordForForgetPassword(randomPasscode);
        scenario.log("User has provided valid new Password");
        newBankWelcomePage.enterConfirmNewPasswordForForgetPassword(randomPasscode);
        scenario.log("User has provided valid confirm new Password");
        newBankWelcomePage.clickOnSubmitSetupForgetPassword();
        scenario.log("User has clicked on Submit forget password form");
        waitUtil.elementToBeLocated(newBankWelcomePage.errorMessageForInvalidErrorCode);
        scenario.log("Site isn't allowing further as user has provided the invalid recovery code");

    }
}


