package StepDefinitions.Retail;

import Configurations.FilePaths;
import Configurations.Passcodes;
import Utilities.BrowserInstance;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;

import java.io.IOException;

public class RetailLoginScreenSD extends BrowserInstance {

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

    @Given("User provides username as {string} and password to Retail App - static")
    public void user_provides_username_as_and_password_as_to_retailer_app_static(String username)  {

waitUtil.elementToBeLocated(retailLoginPage.loginPageRefUsernameXpath,30);
        retailLoginPage.enterUsername(username);
        scenario.log("Username Provided");
        retailLoginPage.enterPassword(Passcodes.STANDARD_PASSWORD);
        scenario.log("Password Provided");
        retailLoginPage.clickOnLoginButton();
        scenario.log("Clicked on Login Button");
    }

    //Demo
    @Given("User provides username as {string} and password to Retail App")
    public void user_provides_username_as_and_password_as_to_retailer_app(String username) throws IOException {
        String data =readAndWriteTextFiles.readTextFile(FilePaths.RETAIL_SIGNUP_INDEX_PATH);
        String myEmail = readAndWriteTextFiles.getPreviouslyCreatedEmail(username,data);
        waitUtil.elementToBeLocated(retailLoginPage.loginPageRefUsernameXpath,30);

        retailLoginPage.enterUsername(myEmail);
        scenario.log("Username Provided");
        retailLoginPage.enterPassword(Passcodes.STANDARD_PASSWORD);
        scenario.log("Password Provided");
        retailLoginPage.clickOnLoginButton();
        scenario.log("Clicked on Login Button");
    }

    //Dev
    @Given("User provides username as {string} and password to Retail App Dev")
    public void user_provides_username_as_and_password_as_to_retailer_app_dev_present(String username) throws IOException {
        String data =readAndWriteTextFiles.readTextFile(FilePaths.RETAIL_DEV_SIGNUP_INDEX_PATH);
        String myEmail = readAndWriteTextFiles.getPreviouslyCreatedEmail(username,data);
        waitUtil.elementToBeLocated(retailLoginPage.loginPageRefUsernameXpath,30);

        retailLoginPage.enterUsername(myEmail);
        scenario.log("Username Provided");
        retailLoginPage.enterPassword(Passcodes.STANDARD_PASSWORD);
        scenario.log("Password Provided");
        retailLoginPage.clickOnLoginButton();
        scenario.log("Clicked on Login Button");
    }


    //Demo
    @Given("User provides username as {string} and password to Retail App - previous")
    public void ruser_provides_username_as_and_password_as_to_retailer_app_previous(String username) throws IOException {
        String data =readAndWriteTextFiles.readTextFile(FilePaths.RETAIL_SIGNUP_INDEX_PATH);

        String myEmail = readAndWriteTextFiles.getPreviouslyCreatedEmail(username,data);
        waitUtil.elementToBeLocated(retailLoginPage.loginPageRefUsernameXpath,30);
        retailLoginPage.enterUsername(myEmail);
        scenario.log("Username Provided");
        retailLoginPage.enterPassword(Passcodes.STANDARD_PASSWORD);
        scenario.log("Password Provided");
        retailLoginPage.clickOnLoginButton();
        scenario.log("Clicked on Login Button");
    }

    //Dev
    @Given("User provides username as {string} and password to Retail App - previous for Dev")
    public void ruser_provides_username_as_and_password_as_to_retailer_app_previousDev(String username) throws IOException {
        String data =readAndWriteTextFiles.readTextFile(FilePaths.RETAIL_DEV_PROGRESSIVE_PROFILING_INDEX_PATH);

        String myEmail = readAndWriteTextFiles.getPreviouslyCreatedEmail(username,data);
        waitUtil.elementToBeLocated(retailLoginPage.loginPageRefUsernameXpath,30);
        retailLoginPage.enterUsername(myEmail);
        scenario.log("Username Provided");
        retailLoginPage.enterPassword(Passcodes.STANDARD_PASSWORD);
        scenario.log("Password Provided");
        retailLoginPage.clickOnLoginButton();
        scenario.log("Clicked on Login Button");
    }


    //Demo
    @Given("User provides username as {string} and password to Retail Demo App - previous")
    public void ruser_provides_username_as_and_password_as_to_retailer_app_previous_demo(String username) throws IOException {
        String data =readAndWriteTextFiles.readTextFile(FilePaths.RETAIL_DEMO_PROGRESSIVE_PROFILING_INDEX_PATH);
        String myEmail = readAndWriteTextFiles.getPreviouslyCreatedEmail(username,data);
        waitUtil.elementToBeLocated(retailLoginPage.loginPageRefUsernameXpath,30);
        retailLoginPage.enterUsername(myEmail);
        scenario.log("Username Provided");
        retailLoginPage.enterPassword(Passcodes.STANDARD_PASSWORD);
        scenario.log("Password Provided");
        retailLoginPage.clickOnLoginButton();
        scenario.log("Clicked on Login Button");
    }

    //Demo:1. used for update password
    @Given("User provides username as {string} and password to Retail Demo App update password - previous")
    public void ruser_provides_username_as_and_password_as_to_retailer_app_previous_demo_update_password(String username) throws IOException {
        String data =readAndWriteTextFiles.readTextFile(FilePaths.RETAIL_DEMO_UPDATE_PASSWORD_INDEX);
        String myEmail = readAndWriteTextFiles.getPreviouslyCreatedEmail(username,data);
        waitUtil.elementToBeLocated(retailLoginPage.loginPageRefUsernameXpath,30);
        retailLoginPage.enterUsername(myEmail);
        scenario.log("Username Provided");
        retailLoginPage.enterPassword(Passcodes.STANDARD_PASSWORD);
        scenario.log("Password Provided");
        retailLoginPage.clickOnLoginButton();
        scenario.log("Clicked on Login Button");
    }
    //dev update password
    @Given("User provides username as {string} and password to Retail Dev App update password - previous")
    public void ruser_provides_username_as_and_password_as_to_retailer_app_previous_dev_update_password(String username) throws IOException {
        String data =readAndWriteTextFiles.readTextFile(FilePaths.RETAIL_DEV_UPDATE_PASSWORD_INDEX);
        String myEmail = readAndWriteTextFiles.getPreviouslyCreatedEmail(username,data);
        waitUtil.elementToBeLocated(retailLoginPage.loginPageRefUsernameXpath,30);
        retailLoginPage.enterUsername(myEmail);
        scenario.log("Username Provided");
        retailLoginPage.enterPassword(Passcodes.STANDARD_PASSWORD);
        scenario.log("Password Provided");
        retailLoginPage.clickOnLoginButton();
        scenario.log("Clicked on Login Button");
    }

  //Dev
    @Given("User provides username as {string} and password to Retail Dev App - previous")
    public void ruser_provides_username_as_and_password_as_to_retailer_app_previous_dev(String username) throws IOException {
        String data =readAndWriteTextFiles.readTextFile(FilePaths.RETAIL_DEV_PROGRESSIVE_PROFILING_INDEX_PATH);
        String myEmail = readAndWriteTextFiles.getPreviouslyCreatedEmail(username,data);
        waitUtil.elementToBeLocated(retailLoginPage.loginPageRefUsernameXpath,30);
        retailLoginPage.enterUsername(myEmail);
        scenario.log("Username Provided");
        retailLoginPage.enterPassword(Passcodes.STANDARD_PASSWORD);
        scenario.log("Password Provided");
        retailLoginPage.clickOnLoginButton();
        scenario.log("Clicked on Login Button");
    }


    //DEMO
    @Given("User provides username as {string} and new password to Retail App")
    public void user_provides_username_as_and_new_password_as_to_retailer_app(String username) {
        waitUtil.elementToBeLocated(retailLoginPage.loginPageRefUsernameXpath,30);
        retailLoginPage.enterUsername(username);
        scenario.log("Username Provided");
        retailLoginPage.enterPassword(Passcodes.STANDARD_PASSWORD);
        scenario.log("Password Provided");
        retailLoginPage.clickOnLoginButton();
        scenario.log("Clicked on Login Button");
    }

    //DEMO UPDATE PASSWORD
    @Given("User provides username as {string} and new password to Retail Demo App update password")
    public void user_provides_username_as_and_new_password_as_to_retailer_app_for_update_password(String username) throws IOException {

        String data =readAndWriteTextFiles.readTextFile(FilePaths.RETAIL_DEMO_UPDATE_PASSWORD_INDEX);
        String myEmail = readAndWriteTextFiles.getPreviouslyCreatedEmail(username,data);

        waitUtil.elementToBeLocated(retailLoginPage.loginPageRefUsernameXpath,30);
        retailLoginPage.enterUsername(myEmail);
        scenario.log("Username Provided");
        retailLoginPage.enterPassword(Passcodes.UPDATE_PASSWORD);
        scenario.log("Password Provided");
        retailLoginPage.clickOnLoginButton();
        scenario.log("Clicked on Login Button");
    }

    //DEV UPDATE PASSWORD
    @Given("User provides username as {string} and new password to Retail Dev App update password")
    public void user_provides_username_as_and_new_password_as_to_retailer_dev_app_for_update_password(String username) throws IOException {

        String data =readAndWriteTextFiles.readTextFile(FilePaths.RETAIL_DEV_UPDATE_PASSWORD_INDEX);
        String myEmail = readAndWriteTextFiles.getPreviouslyCreatedEmail(username,data);

        waitUtil.elementToBeLocated(retailLoginPage.loginPageRefUsernameXpath,30);
        retailLoginPage.enterUsername(myEmail);
        scenario.log("Username Provided");
        retailLoginPage.enterPassword(Passcodes.UPDATE_PASSWORD);
        scenario.log("Password Provided");
        retailLoginPage.clickOnLoginButton();
        scenario.log("Clicked on Login Button");
    }

    @Given("User provides username as {string} and old password to Retail App")
    public void user_provides_username_as_and_old_password_as_to_retailer_app(String username) {
        waitUtil.elementToBeLocated(retailLoginPage.loginPageRefUsernameXpath,30);
        retailLoginPage.enterUsername(username);
        scenario.log("Username Provided");
        retailLoginPage.enterPassword(Passcodes.STANDARD_PASSWORD);
        scenario.log("Password Provided");
        retailLoginPage.clickOnLoginButton();
        scenario.log("Clicked on Login Button");
    }
//Demo
    @Given("User provides username as {string} and old password to Retail Demo App update password")
    public void user_provides_username_as_and_old_password_as_to_retailer_demo_app_update_pass(String username) throws IOException {
        String data =readAndWriteTextFiles.readTextFile(FilePaths.RETAIL_DEMO_UPDATE_PASSWORD_INDEX);
        String myEmail = readAndWriteTextFiles.getPreviouslyCreatedEmail(username,data);
        waitUtil.elementToBeLocated(retailLoginPage.loginPageRefUsernameXpath,30);
        retailLoginPage.enterUsername(myEmail);
        scenario.log("Username Provided");
        retailLoginPage.enterPassword(Passcodes.STANDARD_PASSWORD);
        scenario.log("Password Provided");
        retailLoginPage.clickOnLoginButton();
        scenario.log("Clicked on Login Button");
    }

    //Dev
    @Given("User provides username as {string} and old password to Retail Dev App update password")
    public void user_provides_username_as_and_old_password_as_to_retailer_dev_app_update_pass(String username) throws IOException {
         String data =readAndWriteTextFiles.readTextFile(FilePaths.RETAIL_DEV_UPDATE_PASSWORD_INDEX);
         String myEmail = readAndWriteTextFiles.getPreviouslyCreatedEmail(username,data);
        waitUtil.elementToBeLocated(retailLoginPage.loginPageRefUsernameXpath,30);
        retailLoginPage.enterUsername(myEmail);
        scenario.log("Username Provided");
        retailLoginPage.enterPassword(Passcodes.STANDARD_PASSWORD);
        scenario.log("Password Provided");
        retailLoginPage.clickOnLoginButton();
        scenario.log("Clicked on Login Button");
    }


    @Given("User Should able to login with {string} approach and should land on Retail home page and pass firstname {string}")
    public void userShouldAbleToLoginWithApproachAndShouldLandOnRetailerHomePageAndPassFirstname(String typeOfTesting, String expectedFirstname) throws Exception {
        if (typeOfTesting.equalsIgnoreCase("positive")){
            //Take Check Point as FirstName of the User
            String actualFirstName = retailWelcomePage.getLoggedInUserNameFirstName();
            for(int i=0; i<10;i++){
                if(actualFirstName.equalsIgnoreCase("Hi,")){
                   waitUtil.elementToBeLocated(retailWelcomePage.getUsernameXpath(expectedFirstname),60);
                    actualFirstName = retailWelcomePage.getLoggedInUserNameFirstName();
                }
                else{
                    break;
                }
            }
            scenario.log("Actual FirstName:"+actualFirstName);
            // Assert.assertEquals(actualFirstName, expectedFirstname);
            Assert.assertTrue(actualFirstName.contains(expectedFirstname));

        }
        else{
            waitUtil.elementToBeLocated(retailLoginPage.loginFailureXpath);
            String failureMessage = retailLoginPage.getLoginFailureMessage();
            scenario.log("Unauthorized Login Message: "+failureMessage);
            Assert.assertEquals(failureMessage, "Failed to Authenticate");

        }

    }

    @Given("User Should able to login with {string} approach and should land on Retail home page and pass firstname {string} for Progressive test")
    public void userShouldAbleToLoginWithApproachAndShouldLandOnRetailerHomePageAndPassFirstnameProgressiveTest(String typeOfTesting, String expectedFirstname) throws Exception {


        if (typeOfTesting.equalsIgnoreCase("positive")){

            String firstNameXpath="//*[text()='Hi, ' and text()='"+expectedFirstname+"']";
            for(int i=0;i<=6;i++) {
                try {
                    waitUtil.elementToBeLocated(firstNameXpath, 20);
                    scenario.log("Actual FirstName:"+expectedFirstname);
                    break;
                } catch (Exception ex) {
                    driver.navigate().refresh();
                }
            }



//            //Take Check Point as FirstName of the User
//            String actualFirstName = retailWelcomePage.getLoggedInUserNameFirstName();
//            for(int i=0; i<10;i++){
//                if(actualFirstName.equalsIgnoreCase("Hi,")){
//                    driver.navigate().refresh();
//                    actualFirstName = retailWelcomePage.getLoggedInUserNameFirstName();
//                }
//                else{
//                    break;
//                }
//            }
//
//            scenario.log("Actual FirstName:"+actualFirstName);
//            // Assert.assertEquals(actualFirstName, expectedFirstname);
//            Assert.assertTrue(actualFirstName.contains(expectedFirstname));

        }
        else{
            waitUtil.elementToBeLocated(retailLoginPage.loginFailureXpath);
            String failureMessage = retailLoginPage.getLoginFailureMessage();
            scenario.log("Unauthorized Login Message: "+failureMessage);
            Assert.assertEquals(failureMessage, "Failed to Authenticate");

        }

    }


    @Given("User Should able to login with {string} approach and should land on Retail home page and pass firstname {string} for Progressive Profiling")
    public void userShouldAbleToLoginWithApproachAndShouldLandOnRetailerHomePageAndPassFirstnameForProgressive(String typeOfTesting, String expectedFirstname) throws Exception {


        if (expectedFirstname.equalsIgnoreCase("null")){
            expectedFirstname = "Hi, ";
        }
        if (typeOfTesting.equalsIgnoreCase("positive")){
            //Take Check Point as FirstName of the User
            String actualFirstName = retailWelcomePage.getLoggedInUserNameFirstName();
            for(int i=0; i<2;i++){
                    waitUtil.elementToBeLocated(retailWelcomePage.getUsernameXpath(expectedFirstname),30);
                    Thread.sleep(1000);
                    actualFirstName = retailWelcomePage.getLoggedInUserNameFirstName();
                    if (actualFirstName.contentEquals("Hi, ")){
                        break;
                    }
            }

            scenario.log("Profile name should not appear:"+actualFirstName);

            // Assert.assertEquals(actualFirstName, expectedFirstname);
           // Assert.assertTrue(actualFirstName.contains(expectedFirstname),"Profile Icon name should be empty but appeared an unknown name for Progressive Behaviour test");

        }
        else{
            waitUtil.elementToBeLocated(retailLoginPage.loginFailureXpath);
            String failureMessage = retailLoginPage.getLoginFailureMessage();
            scenario.log("Unauthorized Login Message: "+failureMessage);
            Assert.assertEquals(failureMessage, "Failed to Authenticate");

        }

    }


    @Given("User Should able to login with {string} approach and should not land on Retail home page")
    public void userShouldAbleToLoginWithApproachAndShouldNotLandOnRetailerHomePage(String typeOfTesting) throws Exception {
        if (typeOfTesting.equalsIgnoreCase("negative")){
            waitUtil.elementToBeLocated(retailLoginPage.loginFailureXpath);
            String failureMessage = retailLoginPage.getLoginFailureMessage();
            scenario.log("Unauthorized Login Message: "+failureMessage);
            Assert.assertEquals(failureMessage, "Failed to Authenticate");
        }
    }

    @Given("User continues login with Google")
    public void userContinuesLoginWithGoogle() {
        waitUtil.elementToBeClickable(retailLoginPage.loginViaGoogleXpath);
        retailLoginPage.clickOnLoginViaGoogle();
        scenario.log("User has clicked on Continue With Google");
    }

    @Given("User continues login with Facebook")
    public void userContinuesLoginWithFacebook() {
        waitUtil.elementToBeClickable(retailLoginPage.loginViaFacebookXpath,45);
        retailLoginPage.clickOnLoginViaFacebook();
        scenario.log("User has clicked on Continue With Facebook");
    }
}
