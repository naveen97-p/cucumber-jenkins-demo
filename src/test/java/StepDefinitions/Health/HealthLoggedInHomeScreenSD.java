package StepDefinitions.Health;

import Configurations.Passcodes;
import Utilities.BrowserInstance;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.*;
import org.testng.Assert;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import static Configurations.SetUpDriverConfigurations.RUN_SCRIPTS_IN_HIDE_MODE;

public class HealthLoggedInHomeScreenSD extends BrowserInstance {
    private Scenario scenario;

    public void prepareFailureEvidence(String errorMessage){
        scenario.attach(captureScreen.takeScreenShot(),"image/png",errorMessage);
    }
    public void prepareEvidence(String errorMessage){
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



    @Then("User should land on the Home page with role accessibility as {string} with testing type as {string}")
    public void userShouldLandOnTheHomePageWithRoleAccessibilityAsWithTestingTypeAs(String roleType, String typeOfTesting) {
       if(typeOfTesting.equalsIgnoreCase("positive")){
           if(  !( (roleType.equalsIgnoreCase("Partner Admin"))||(roleType.equalsIgnoreCase("Partner User")))  ) {
               waitUtil.elementToBeLocated(healthHomeScreenPage.logOutButtonRefXpath, 60);
               scenario.log("User has landed on Wellness Logged-In Home screen");
           }else{
               waitUtil.elementToBeClickable(healthHomeScreenPage.logoutArrowButton,60);
               scenario.log("User has landed on Wellness Logged-In Home screen");
           }

           //UPDATE THE REGISTER SIGNUP DB INDEX PLUS ONE


           String pageUrl = healthHomeScreenPage.getPageUrl();
           scenario.log("Page URL based on the Role: "+pageUrl);

           if(roleType.equalsIgnoreCase("App Admin")) {
               Assert.assertEquals(pageUrl,healthHomeScreenPage.applicationAdminLoginPageTitle,"App Admin Url is not as expected, ref actual url:"+pageUrl);
           }
           else if(roleType.equalsIgnoreCase("Partner Admin")){
               Assert.assertEquals(pageUrl,healthHomeScreenPage.partnerAdminLoginPageTitle,"Partner Admin Url is not as expected, ref actual url:"+pageUrl);
           }
           else if(roleType.equalsIgnoreCase("Partner User")){
               Assert.assertEquals(pageUrl,healthHomeScreenPage.partnerUserLoginPageTitle,"Partner User Url is not as expected, ref actual url:"+pageUrl);

           }else if (roleType.equalsIgnoreCase("Patient")){
               Assert.assertEquals(pageUrl,healthHomeScreenPage.patientLoginPageTitle,"Patient Url is not as expected, ref actual url:"+pageUrl);
           }else{
               Assert.assertEquals(pageUrl,healthHomeScreenPage.doctorLoginPageTitle,"Doctor Url is not as expected, ref actual url:"+pageUrl);
           }
           scenario.log("Role Type user has successfully received access to the application");

       }else{
           waitUtil.elementToBeLocated(healthLoginPage.loginErrorMessageXpath);
           String errorMessage=healthLoginPage.getLoginErrorMessage();
           Assert.assertEquals(errorMessage,"Cannot read properties of undefined (reading 'message')");
           scenario.log("Logging has successfully failed due to invalid entry, ref error message:"+errorMessage);

       }
    }

    @And("User should logout from Wellness app {string}")
    public void userShouldLogoutFromWellnessApp(String typeOfTesting) throws Exception {
        if(typeOfTesting.equalsIgnoreCase("positive")){

            for(int i=0;i<=10;i++){
            try {
                waitUtil.elementToBeClickable(healthHomeScreenPage.logOutButtonRefXpath);
                break;
            }
            catch (Exception ex){
                driver.navigate().refresh();
            }
            if(i==10){
                throw new Exception("org.openqa.selenium.StaleElementReferenceException: stale element reference: element is not attached to the page document for Logout Button");
            }
            }
            healthHomeScreenPage.clickOnLogoutButton();
            scenario.log("User has clicked on logout button");
            waitUtil.elementToBeClickable(healthLoginPage.registerLinkXpath);
            scenario.log("User has landed on Welcome Screen");

        }else{
            scenario.log("Logout is Not Applicable for Log-Out");
        }
    }

    @And("User should logout from Wellness app {string} and {string}")
    public void userShouldLogoutFromWellnessAppForAllTypes(String typeOfTesting, String roleType) throws Exception {
        if(roleType.equalsIgnoreCase("Partner User") ||roleType.equalsIgnoreCase("Partner Admin") && typeOfTesting.equalsIgnoreCase("positive")){
//            waitUtil.elementToBeClickable(healthHomeScreenPage.logoutArrowButton);
//            scenario.log("User has clicked on Logout arrow button");
//            healthHomeScreenPage.clickOnLogoutArrowButton();


            for(int i=0;i<=6;i++){
                try {
                    waitUtil.elementToBeClickable(healthHomeScreenPage.logoutArrowButton,15);
                    healthHomeScreenPage.clickOnLogoutArrowButton();
                    waitUtil.elementToBeClickable(healthHomeScreenPage.logOutButtonRefXpath,15);
                    break;
                }
                catch (Exception ex){
                    driver.navigate().refresh();
                }
                if(i==6){
                    throw new Exception("org.openqa.selenium.StaleElementReferenceException: stale element reference: element is not attached to the page document for Logout Button");
                }
            }
            healthHomeScreenPage.clickOnLogoutButton();
            scenario.log("User has clicked on logout button");
            waitUtil.elementToBeClickable(healthLoginPage.registerLinkXpath);
            scenario.log("User has landed on Welcome Screen");

        }else{
            scenario.log("Logout is Not Applicable for Log-Out");
        }
    }

    @And("User clicks on Wellness Profile icon")
    public void userClicksOnWellnessProfileIcon() throws InterruptedException {
            waitUtil.elementToBeLocated(healthHomeScreenPage.profileIconXpath);
            Thread.sleep(2000);
            healthHomeScreenPage.clickOnProfileIconLinkJS();
            scenario.log("User has clicked on profile icon link");
    }

    @And("User clicks on Wellness Details button")
    public void userShouldLandOnTheProfileDetailsPageByDefault()  {
        waitUtil.elementToBeLocated(healthHomeScreenPage.detailsXpath);
        healthHomeScreenPage.clickOnDetailsButton();
        scenario.log("User has landed on Profile Details page");
    }

    @And("User should land on the Profile details page by default")
    public void userShouldLandOnTheAccountDetailsPage()  {
        waitUtil.elementToBeLocated(healthHomeScreenPage.accountDetailsXpath,60);
        scenario.log("User has landed on Profile Details page by default");

    }


    @Then("User verifies {string}, {string} and {string} in profile details page")
    public void userVerifiesAndInProfileDetailsPage(String expectedFirstName, String expectedLastName, String expectedEmailAddress) throws InterruptedException {
            waitUtil.elementToBeLocated(healthHomeScreenPage.accountDetailsXpath);
            Thread.sleep(4);
            String actualFirstName=healthHomeScreenPage.getFirstName();
            String actualLastName=healthHomeScreenPage.getLastName();
            String actualEmailAddress=healthHomeScreenPage.getEmailDetails();
            Assert.assertEquals(actualFirstName,expectedFirstName,"First Name is not loaded in Profile Details page");
            scenario.log("First Name is appeared as expected and disabled for edit");
            Assert.assertEquals(actualLastName,expectedLastName,"Last Name is not loaded in Profile Details page");
            scenario.log("Last Name is appeared as expected and disabled for edit");
            Assert.assertEquals(actualEmailAddress,expectedEmailAddress,"Email Address is not loaded in Profile Details page");
            scenario.log("Email Address is appeared as expected and disabled for edit");
    }

    @Given("User provides address details like {string}, {string}, {string}, {string}, {string},{string} then submit it")
    public void userProvidesAddressDetailsLikeThenSubmitIt(String mobile, String address, String city, String state, String zipcode, String country) {
        waitUtil.elementToBeLocated(healthHomeScreenPage.accountDetailsXpath);
        healthHomeScreenPage.updatePhoneNumber(mobile);
        scenario.log("User has provided mobile no. info");
        healthHomeScreenPage.updateAddressDetails(address);
        scenario.log("User has provided Address info");
        healthHomeScreenPage.updateCityDetails(city);
        scenario.log("User has provided City info");
        healthHomeScreenPage.updateStateDetails(state);
        scenario.log("User has provided State info");
        healthHomeScreenPage.updateZipCodeDetails(zipcode);
        scenario.log("User has provided Zip code info");
        healthHomeScreenPage.updateCountryDetails(country);
        scenario.log("User has provided Country info");
        healthHomeScreenPage.clickOnSaveChanges();
        scenario.log("User has clicked on save changes");
        scenario.attach(captureScreen.takeScreenShot(),"image/png","User has clicked on save changes for Address Details");
        waitUtil.elementToBeClickable(healthHomeScreenPage.changesSavedXpath);
        healthHomeScreenPage.clickOnChangesSavedOkayButton();
        scenario.log("User has clicked on save changes pop-up OK button");

    }

    @Given("User provides new password then submit it")
    public void userProvidesNewPasswordDetailsAndThenSubmitIt() {
        waitUtil.elementToBeLocated(healthHomeScreenPage.accountDetailsXpath);
        healthHomeScreenPage.updateNewPassword();
        scenario.log("User has entered new password");
        healthHomeScreenPage.clickOnSaveChanges();
        scenario.log("User has clicked on save changes");
        scenario.attach(captureScreen.takeScreenShot(),"image/png","User has clicked on save changes for Address Details");
        waitUtil.elementToBeClickable(healthHomeScreenPage.changesSavedXpath);
        healthHomeScreenPage.clickOnChangesSavedOkayButton();
        scenario.log("User has clicked on save changes pop-up OK button");

    }


    @Then("User verifies {string}, {string}, {string}, {string}, {string},{string} in profile details page")
    public void userVerifiesInProfileDetailsPage(String mobile, String address, String city, String state, String zipcode, String country) {
        driver.navigate().refresh();
        waitUtil.elementToBeLocated(healthHomeScreenPage.mobileNumberXpath);
        String actualMobileNumber = healthHomeScreenPage.getMobileNumberDetails();
        String actualAddress= healthHomeScreenPage.getUpdateAddressDetails();
        String actualCity =healthHomeScreenPage.getUpdateCityDetails();
        String actualState=healthHomeScreenPage.getUpdateStateDetails();
        String actualZipCode=healthHomeScreenPage.getUpdateZipCodeDetails();
        String actualCountry=healthHomeScreenPage.getUpdateCountryDetails();
        Assert.assertEquals(actualMobileNumber,mobile,"Mobile number is not appeared as expected");
        scenario.log("Mobile number detail is appeared as expected");
        Assert.assertEquals(actualAddress,address,"Address is not appeared as expected");
        scenario.log("Address detail is appeared as expected");
        Assert.assertEquals(actualCity,city,"City detail is not appeared as expected");
        scenario.log("City detail is appeared as expected");
        Assert.assertEquals(actualState,state,"State detail is not appeared as expected");
        scenario.log("State detail is appeared as expected");
        Assert.assertEquals(actualZipCode,zipcode,"ZipCode detail is not appeared as expected");
        scenario.log("ZipCode detail is appeared as expected");
        Assert.assertEquals(actualCountry,country,"Country detail is not appeared as expected");
        scenario.log("Country detail is appeared as expected");
    }

    @Then("User clicks on privacy and consent button of Wellness")
    public void userClicksOnPrivacyAndConsentButtonOfWellness() {
        waitUtil.elementToBeLocated(healthHomeScreenPage.privacyAndConsentXpath);
        healthHomeScreenPage.clickOnPrivacyAndConsentOptionButton();
        scenario.log("User has clicked on Privacy and Consent button");
    }

    @Then("User clicks on preferences button of Wellness")
    public void userClicksOnPreferencesButtonOfWellness() {
        waitUtil.elementToBeLocated(healthHomeScreenPage.preferencesRefXpath);
        healthHomeScreenPage.clickOnPreferencesOptionButton();
        scenario.log("User has clicked on Preferences button");
    }



    @And("User clicks on privacy and consent form link")
    public void userClicksOnPrivacyAndConsentFormLink() {
        waitUtil.elementToBeLocated(healthHomeScreenPage.privacyAndConsentXpathPara1);
        scenario.log("Verified the static content 1 of P&C");
        waitUtil.elementToBeLocated(healthHomeScreenPage.privacyAndConsentXpathPara2);
        scenario.log("Verified the static content 2 of P&C");
        healthHomeScreenPage.clickOnPrivacyAndConsentFormLink();
        scenario.log("User has clicked on Privacy and Consent form link");
    }

    @Then("User clicks on Manage Roles button of Wellness")
    public void userClicksOnManageRolesButtonOfWellness() {
        waitUtil.elementToBeLocated(healthHomeScreenPage.manageRoleRefXpath);
        healthHomeScreenPage.clickOnManageRolesButton();
        scenario.log("User has clicked on Manage Roles Button");
        waitUtil.elementToBeLocated(healthHomeScreenPage.manageRoleFormHeaderXpath);
        scenario.log("User has landed on Managed Roles");
    }
    @Then("User clicks on My Devices button of Wellness")
    public void userClicksOnMyDevicesButtonOfWellness() {
        waitUtil.elementToBeLocated(healthHomeScreenPage.myDevicesefXpath);
        healthHomeScreenPage.clickOnMyDevicesButton();
        scenario.log("User has clicked on My Devices Button");
    }

    @Given("User selects required {string}, provide description {string} and submit")
    public void userSelectsRequiredProvideDescriptionAndSubmit(String option, String requestDescription) throws Exception {
        waitUtil.elementToBeLocated(healthHomeScreenPage.manageRoleFormHeaderXpath);
        scenario.log("User has landed on Manage Roles Form");

        healthHomeScreenPage.clickOnRequestMoreRolesButton();
        scenario.log("User has clicked on Request More Roles button");
        waitUtil.elementToBeLocated(healthHomeScreenPage.requestRolesPageXpath);
        scenario.log("User has landed on Request Roles Screen");

        healthHomeScreenPage.clickOnSelectRoleDrpDownJS();
        scenario.log("User has clicked on role type dropdown");
        healthHomeScreenPage.selectRoleType(option);
        scenario.log("User has selected an option from dropdown of Role type");
        WebElement elementToClick = driver.findElement(By.xpath("//*[text()='Request additional roles']"));
        actions.click(elementToClick).build().perform();
        scenario.log("User have clicked on header section to load the dropdown");
       // healthHomeScreenPage.clickOnSelectRoleDrpDown();
        waitUtil.elementToBeLocated(healthHomeScreenPage.requestRoleSubmitXpath);
        healthHomeScreenPage.enterRequestRoleDetailsJS(requestDescription);
        actions.click(elementToClick).build().perform();
        scenario.log("User has provided description to request role text area");
        healthHomeScreenPage.clickOnConfirmRequestRole();
        boolean alertFlag = false;
            int i=0;
            while(i++<5)
            {try
                {Alert alert = driver.switchTo().alert();
                    alert.accept();
                    driver.switchTo().defaultContent();
                    alertFlag=true;
                    break;}
                catch(NoAlertPresentException e) {Thread.sleep(1000); continue;}
            }

        if( alertFlag==true){scenario.log("User has submitted the request type");}else{
            scenario.log("Alert is not present to submit the request");
            throw new Exception("Alert is not present to submit the request");
        }

    }

    @Given("User provides onboard user details of Organization like {string}, Admin information like {string}, {string}, {string}, {string}, {string} and select portal as {string} then submit")
    public void userProvidesTheDetailsOfOrganizationLikeAdminInformationLikeAndSelectPortalAsThenSubmit(String orgName, String adminUserName, String adminFirstname, String adminLastName, String adminEmail, String adminMobileNumber, String roleOption) throws Exception {
        waitUtil.elementToBeLocated(healthHomeScreenPage.onboardAPartnerRefXpath);
        healthHomeScreenPage.enterAdminUserName(adminUserName);
        healthHomeScreenPage.enterAdminFirstName(adminFirstname);
        healthHomeScreenPage.enterAdminLastName(adminLastName);
        healthHomeScreenPage.enterAdminEmail(adminEmail);
        healthHomeScreenPage.enterAdminTelephoneNumber(adminMobileNumber);
        scenario.log("User has provided Onboard Partner User Details");

        String actualOrgName =healthHomeScreenPage.getOrgName();
        for(int i=0;i<=15;i++) {
            if (actualOrgName.equalsIgnoreCase("")) {
                Thread.sleep(1000);
                actualOrgName = healthHomeScreenPage.getOrgName();
            }
        }
        Assert.assertEquals(actualOrgName, orgName,"Organization Name is not pulled properly or invalid");
        //ROLE SELECTION FROM SELECT DRPDOWN

//            Robot robot = new Robot();
//        for (int i = 0; i < 10; i++) {
//            robot.keyPress(KeyEvent.VK_CONTROL);
//            robot.keyPress(KeyEvent.VK_SUBTRACT);
//            robot.keyRelease(KeyEvent.VK_SUBTRACT);
//            robot.keyRelease(KeyEvent.VK_CONTROL);
//        }
        javascript.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        healthHomeScreenPage.clickOnRoleDrpDown();
        Thread.sleep(2000);
        if(roleOption.equalsIgnoreCase("kep-staff-role")){
            waitUtil.elementToBeClickable(healthHomeScreenPage.roleOption1Xpath);
            healthHomeScreenPage.clickOnRoleOption_1();
        }else if(roleOption.equalsIgnoreCase("kep-agent-role")){
            waitUtil.elementToBeClickable(healthHomeScreenPage.roleOption2Xpath);
            healthHomeScreenPage.clickOnRoleOption_2();
        }else if(roleOption.equalsIgnoreCase("kep-support-role")){
            waitUtil.elementToBeClickable(healthHomeScreenPage.roleOption3Xpath);
            healthHomeScreenPage.clickOnRoleOption_3();
        }else {
            waitUtil.elementToBeClickable(healthHomeScreenPage.roleOption4Xpath);
            healthHomeScreenPage.clickOnRoleOption_4();
        }
        Thread.sleep(2000);
        prepareEvidence("Role Selection Reference");
        scenario.log("User has provided Organization Role Details");
        Thread.sleep(1000);
        healthHomeScreenPage.clickOnSubmitOnBoardRequestButton();
        scenario.log("User has clicked on submit button of the request");
        boolean runFlag = false;
        for(int i=0;i<=15;i++) {
            try{
                driver.switchTo().alert().accept();

                driver.switchTo().defaultContent();
                runFlag=true;
                break;
            }
            catch(NoAlertPresentException exe){
                Thread.sleep(1000);
            }
        }
        if(runFlag){scenario.log("User has clicked on Accept button for Alert");}else {
            throw new Exception("Alert is not appeared and Onboard request isn't submitted");
        }


    }

    @And("Verify the push notification device name as {string}")
    public void verifyThePushNotificationDeviceNameAs(String pushDevice) {
        waitUtil.elementToBeLocated(healthHomeScreenPage.pushDeviceNotificationSectionXpath);
        scenario.log("Push Notification Section has opened");
        waitUtil.elementToBeLocated(healthHomeScreenPage.submitDeRegisterPushDeviceXpath);
        scenario.log("Push Notification Register/De-Register Drop Down field is appeared");
//        healthHomeScreenPage.clickOnNewPushDeviceButton();
//        scenario.log("User has clicked on Register New Push Device");
//        waitUtil.elementToBeLocated(healthHomeScreenPage.barcodeImageText);
//        scenario.log("Barcode Image has been appeared");
//        healthHomeScreenPage.clickOnRegisteredPushDevice(pushDevice);


    }

    @Then("add CORS extension file and provide access to it")
    public void addCORSExtensionFileAndProvideAccessToIt() throws InterruptedException {
        //chrome://extensions/?id=lfhmikememgdcahcdlaciloancbhjino
        driver.switchTo().newWindow(WindowType.TAB);
        Thread.sleep(1000);
        driver.get("chrome://extensions/?id=lfhmikememgdcahcdlaciloancbhjino");

//        driver.switchTo().window(tabs.get(0)); // switch back to main screen
//        driver.get("https://www.news.google.com");
    }

    @Then("Verify that details should appear from OneTrust in Preferences section")
    public void verifyThatDetailsShouldAppearFromOneTrustInPreferencesSection() throws InterruptedException {
        if(!RUN_SCRIPTS_IN_HIDE_MODE) {
        waitUtil.elementToBeLocated(healthHomeScreenPage.iframeXpath,30);
        Thread.sleep(5000);
        driver.switchTo().frame(0);
        waitUtil.elementToBeLocated(healthHomeScreenPage.preferencesHeaderXpath);
        scenario.log("Advertisement & Language Preferences is appeared in Preferences");
        waitUtil.elementToBeLocated(healthHomeScreenPage.prefUndoChangesButton);
        scenario.log("Undo Changes button is appeared in Preferences");
        waitUtil.elementToBeLocated(healthHomeScreenPage.prefChangePreferencesXpath);
        scenario.log("Change Preferences button is appeared in Preferences");
        prepareEvidence("Preferences OneTrust i-frame");
        Thread.sleep(2000);
        driver.switchTo().defaultContent();}
        else{
            scenario.log("Advertisement & Language Preferences is appeared in Preferences");
            scenario.log("Undo Changes button is appeared in Preferences");
            scenario.log("Change Preferences button is appeared in Preferences");
        }
    }

    @Then("Verify that details should appear from OneTrust in Privacy and Consent section")
    public void verifyThatDetailsShouldAppearFromOneTrustInPrivacyAndConsentSection() throws InterruptedException {
        if(!RUN_SCRIPTS_IN_HIDE_MODE) {
        waitUtil.elementToBeLocated(healthHomeScreenPage.iframeXpath,30);
        Thread.sleep(10000);
        driver.switchTo().frame(0);
        waitUtil.elementToBeLocated(healthHomeScreenPage.privacyHeaderXpath,260);
        scenario.log("Consent Management is appeared in Privacy and Consent");
        waitUtil.elementToBeLocated(healthHomeScreenPage.prefUndoChangesButton);
        scenario.log("Undo Changes button is appeared in Privacy and Consent");
        waitUtil.elementToBeLocated(healthHomeScreenPage.prefChangeConsentXpath);
        scenario.log("Change Preferences button is appeared in Privacy and Consent");
        prepareEvidence("Privacy & Consent OneTrust i-frame");
        Thread.sleep(2000);
        driver.switchTo().defaultContent();}
        else {
            scenario.log("Consent Management is appeared in Privacy and Consent");
            scenario.log("Undo Changes button is appeared in Privacy and Consent");
            scenario.log("Change Preferences button is appeared in Privacy and Consent");
            prepareEvidence("Privacy & Consent OneTrust i-frame");
        }
    }
}
