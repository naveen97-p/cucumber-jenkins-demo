package StepDefinitions.Retail;

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
import java.util.concurrent.TimeoutException;

public class RetailProfileOptionsScreenSD extends BrowserInstance {

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

    @And("User clicks on password settings")
    public void userClicksOnPasswordSettings() {
        waitUtil.elementToBeClickable(retailProfileOptionsPage.passwordSettingXpath);
        retailProfileOptionsPage.clickOnPasswordSettingButton();
        scenario.log("User has clicked on Password Settings option");
    }
    @And("User clicks on privacy and consent")
    public void userClicksOnPrivacyAndConsent() {
        waitUtil.elementToBeClickable(retailProfileOptionsPage.passwordSettingXpath,40);
        retailProfileOptionsPage.clickOnPrivacyAndConsentButton();
        scenario.log("User has clicked on Privacy and Consent option");
    }
    //clickOnCommunicationPreferencesButton
    @And("User clicks on Communication Preferences")
    public void userClicksOnCommunicationPreferences() {
        waitUtil.elementToBeClickable(retailProfileOptionsPage.passwordSettingXpath,40);
        retailProfileOptionsPage.clickOnCommunicationPreferencesButton();
        scenario.log("User has clicked on Communication Preferences option");
    }

    //Demo
    @And("User verifies the One Trust I-frame for Communication Preferences for Email, Mobile and enable all preferences")
    public void userVerifiesTheOneTrustIFrameForCommunicationPreferences() throws InterruptedException {
        waitUtil.elementToBeLocated(healthHomeScreenPage.iframeXpath,40);
        scenario.log("One-Trust Communication preferences screen has been appeared");
        Thread.sleep(5000);
        driver.switchTo().frame(0);

        waitUtil.elementToBeLocated(retailProfileOptionsPage.communicationPreferencesOneTrustXpath,30);
        scenario.log("Communication Preferences Header text Has been verified");
        waitUtil.elementToBeLocated(retailProfileOptionsPage.emailCommunicationPrefXpath,30);
        scenario.log("Email Communication Preferences Header text Has been verified");
        waitUtil.elementToBeLocated(retailProfileOptionsPage.phoneCommunicationPrefXpath,30);
        scenario.log("Mobile Communication Preferences Header text Has been verified");

        //Check if the Email Comm Pref Toggle button is enabled
        if(!(retailProfileOptionsPage.emailToggleButtonIsSelected())){
            retailProfileOptionsPage.clickOnEmailCommunicationToggleButton();
        }
        Thread.sleep(500);
        //Check if the Mobile Comm Pref Toggle button is enabled
        if(!(retailProfileOptionsPage.mobileToggleButtonIsSelected())){
            retailProfileOptionsPage.clickOnMobileCommunicationToggleButton();
        }

        Thread.sleep(2000);
        //Enable All Email Pref
         retailProfileOptionsPage.clickOnEmailMarketingEmails();
        retailProfileOptionsPage.clickOnEmailNewsLetters();
        retailProfileOptionsPage.clickOnEmailPromotionCodes();
        retailProfileOptionsPage.clickOnEmailCompanyUpdates();
        retailProfileOptionsPage.clickOnEmailNewProductLaunch();

        prepareFailureEvidence("Email Preferences OneTrust i-frame");
        scenario.log("Email Communication Pref options have been enabled");

        //Enable All Mobile Pref
        javascript.executeScript("arguments[0].scrollIntoView();", retailProfileOptionsPage.phonePreferencesSection);
       Thread.sleep(2000);
        retailProfileOptionsPage.clickOnMobileMarketingMessages();
       // javascript.executeScript("arguments[0].scrollIntoView();", retailProfileOptionsPage.companyNewsLettersCheckBox);
        retailProfileOptionsPage.clickOnMobileCompanyNewsLetters();
       // javascript.executeScript("arguments[0].scrollIntoView();", retailProfileOptionsPage.promotionCodesForMobileCheckBox);
        retailProfileOptionsPage.clickOnMobilePromotionCodes();
       // javascript.executeScript("arguments[0].scrollIntoView();", retailProfileOptionsPage.otherCompanyNotificationsCheckBox);
        retailProfileOptionsPage.clickOnMobileOtherCompanyNotifications();


        prepareFailureEvidence("Mobile Preferences OneTrust i-frame");
        scenario.log("Mobile Communication Pref options have been enabled");

        //Save Comm Pref
        retailProfileOptionsPage.clickOnChangePreferencesButton();

        //verify the notif/pop-up
        waitUtil.elementToBeLocated(retailProfileOptionsPage.communicationChangesUpdatedNotificationBoxXpath,40);
        scenario.log("Communication Preferences have been saved and notification appeared as expected");
        prepareFailureEvidence("Communication Preferences Confirmation Notification");

        Thread.sleep(2000);
        driver.switchTo().defaultContent();

    }

    //Demo
    @And("User reverts all preferences back to normal and save")
    public void userVerifiesRevertingFacilityOnCommPref() throws Exception {

        waitUtil.elementToBeLocated(healthHomeScreenPage.iframeXpath,40);
        scenario.log("One-Trust Communication preferences screen has been appeared");
        Thread.sleep(5000);
        driver.switchTo().frame(0);

        waitUtil.elementToBeLocated(retailProfileOptionsPage.communicationPreferencesOneTrustXpath,30);
        scenario.log("Communication Preferences Header text Has been verified");
        waitUtil.elementToBeLocated(retailProfileOptionsPage.emailCommunicationPrefXpath,30);
        scenario.log("Email Communication Preferences Header text Has been verified");
        waitUtil.elementToBeLocated(retailProfileOptionsPage.phoneCommunicationPrefXpath,30);
        scenario.log("Mobile Communication Preferences Header text Has been verified");

        //CHECk: JS to Scroll
        javascript.executeScript("arguments[0].scrollIntoView();", retailProfileOptionsPage.emailPreferencesSection);

        retailProfileOptionsPage.clickOnEmailCommunicationToggleButton();
        retailProfileOptionsPage.clickOnMobileCommunicationToggleButton();

        /*
        //Check if the Email Comm Pref Toggle button is enabled
        if(retailProfileOptionsPage.emailToggleButtonIsSelected()){
            scenario.log("Email Communication Pref have been disabled");
            retailProfileOptionsPage.clickOnEmailCommunicationToggleButton();
        }
        else {
            throw new Exception("Email Communication Pref haven't been saved");
        }

        Thread.sleep(500);
        //CHECk: JS to Scroll
        javascript.executeScript("arguments[0].scrollIntoView();", retailProfileOptionsPage.phonePreferencesSection);
        Thread.sleep(500);
        //Check if the Mobile Comm Pref Toggle button is enabled
        if(retailProfileOptionsPage.mobileToggleButtonIsSelected()){
            scenario.log("Mobile Communication Pref have been disabled");
            retailProfileOptionsPage.clickOnMobileCommunicationToggleButton();
        }else{
            throw new Exception("Mobile Communication Pref haven't  been saved");
        }

         */

        Thread.sleep(2000);

        prepareFailureEvidence("Communication Preferences OneTrust i-frame");
        scenario.log("Communication Pref options have been reverted");

        //Save Comm Pref
        javascript.executeScript("arguments[0].scrollIntoView();", retailProfileOptionsPage.changePreferencesButton);
        retailProfileOptionsPage.clickOnChangePreferencesButton();

        //verify the notif/pop-up
        waitUtil.elementToBeLocated(retailProfileOptionsPage.communicationChangesUpdatedNotificationBoxXpath,30);
        scenario.log("Communication Preferences have been saved and notification appeared as expected");
        prepareFailureEvidence("Communication Preferences Confirmation Notification");

        Thread.sleep(2000);
        driver.switchTo().defaultContent();

    }



    @Given("User provides old password, new password and update it")
    public void userProvidesOldPasswordNewPasswordAndUpdateIt() {
        waitUtil.elementToBeLocated(retailProfileOptionsPage.changePasswordRefXpath);
        retailProfileOptionsPage.enterYourOldPassword(Passcodes.STANDARD_PASSWORD);
        scenario.log("User has entered Old Password");
        retailProfileOptionsPage.enterYourNewPassword(Passcodes.UPDATE_PASSWORD);
        scenario.log("User has entered New Password");
        retailProfileOptionsPage.enterReEnterYourNewPassword(Passcodes.UPDATE_PASSWORD);
        scenario.log("User has re-entered New Password");
        retailProfileOptionsPage.clickOnSubmitButton();
        scenario.log("User has submitted the password update details");
    }

    @Then("User verifies the password update status as updated")
    public void userVerifiesThePasswordUpdateStatusAsUpdated() {
        waitUtil.elementToBeClickable(retailProfileOptionsPage.passwordUpdateStatusXpath);
        String updateStatusMsg=retailProfileOptionsPage.getPasswordUpdateMsg();
        Assert.assertEquals(updateStatusMsg,"Password changed Successfully!");
    }


    @Then("User clicks on Do Not Sell My Data option")
    public void userClicksOnDoNotSellMyDataOption() throws InterruptedException {
        waitUtil.elementToBeClickable(retailProfileOptionsPage.doNotSellMyDataXpath);
        Thread.sleep(1000);
        retailProfileOptionsPage.clickOnDoNotSellMyDataButton();
        scenario.log("User has clicked on Do Not Send My Data button");
    }
    //Demo
    @Given("Go to Account Details and Update the {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string} details and submit the changes")
    public void clickOnProfileIconAndUpdateTheDetailsAndSubmitTheChanges(String firstName, String lastName, String mobile,String address, String country, String state, String city, String zipCode, String month, String day) throws InterruptedException {
        waitUtil.elementToBeClickable(retailProfileOptionsPage.personalDetailsRefXpath);
        retailProfileOptionsPage.enterMobileNumber(mobile);

        retailProfileOptionsPage.enterLastName(lastName);
        scenario.log("User has provided LastName info");

        retailProfileOptionsPage.enterFirstName(firstName);
        scenario.log("User has provided FirstName info");
        retailProfileOptionsPage.enterMobileNumber(mobile);
        scenario.log("User has provided Mobile Number info");


        retailProfileOptionsPage.enterAddress(address);
        scenario.log("User has provided Address info");
        retailProfileOptionsPage.enterCountryName(country);

        scenario.log("User has provided Country info");
        retailProfileOptionsPage.enterCityName(city);
        scenario.log("User has provided City info");
        retailProfileOptionsPage.enterStateName(state);
        scenario.log("User has provided State info");
        retailProfileOptionsPage.enterZipCode(zipCode);
        scenario.log("User has provided Zip code info");
        retailProfileOptionsPage.enterDobMonth(month);
        scenario.log("User has provided DOB Month info");
        retailProfileOptionsPage.enterDobDay(day);
        scenario.log("User has provided DOB Day info");
        retailProfileOptionsPage.clickOnApplyChangesButton();
        scenario.log("User has clicked on save changes");

        waitUtil.elementToBeLocated(retailProfileOptionsPage.detailsUpdatedRefXpath);
        //scenario.attach(captureScreen.takeScreenShot(),"image/png","User has clicked on save changes for Address Details");

    }

//Dev
    @Given("Go to Account Details and Update the {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string} details and submit the changes for Dev")
    public void clickOnProfileIconAndUpdateTheDetailsAndSubmitTheChangesDev(String firstName, String lastName, String mobile,String address, String country, String state, String city, String zipCode, String month, String day) throws InterruptedException {
        waitUtil.elementToBeClickable(retailProfileOptionsPage.personalDetailsRefXpath);
        retailProfileOptionsPage.enterPhoneNumber(mobile);

        retailProfileOptionsPage.enterLastName(lastName);
        scenario.log("User has provided LastName info");

        retailProfileOptionsPage.enterFirstName(firstName);
        scenario.log("User has provided FirstName info");

        String registeredEmailAddress= retailProfileOptionsPage.getRegisteredEmailInNonEditableForm();

        retailProfileOptionsPage.enterPhoneNumber(mobile);
        scenario.log("User has provided Mobile Number info");


        retailProfileOptionsPage.enterAddress(address);
        scenario.log("User has provided Address info");
        retailProfileOptionsPage.enterCountryName(country);

        scenario.log("User has provided Country info");
        retailProfileOptionsPage.enterCityName(city);
        scenario.log("User has provided City info");
        retailProfileOptionsPage.enterStateName(state);
        scenario.log("User has provided State info");
        retailProfileOptionsPage.enterZipCode(zipCode);
        scenario.log("User has provided Zip code info");
        retailProfileOptionsPage.enterDobMonth(month);
        scenario.log("User has provided DOB Month info");
        retailProfileOptionsPage.enterDobDay(day);
        scenario.log("User has provided DOB Day info");
        retailProfileOptionsPage.clickOnApplyChangesButton();
        scenario.log("User has clicked on save changes");

        waitUtil.elementToBeLocated(retailProfileOptionsPage.verifyIdentityUITextDevXpathRef);
        scenario.log("MFA verification has appeared for Change of Address/Phone Number");

        String actualMFAEmailAddress = retailProfileOptionsPage.getRegisteredEmailFromOTPConfirmation();
        Assert.assertEquals(actualMFAEmailAddress, registeredEmailAddress,"Email Is Appeared differently for MFA verification");
        scenario.log("Email is appeared as expected");
        retailProfileOptionsPage.clickOnNextButton();
        Thread.sleep(2000);
        retailProfileOptionsPage.clickOnNextButton();
        scenario.log("User has clicked on Next button");

        waitUtil.elementToBeLocated(retailProfileOptionsPage.enterCodeInputBoxDevXpath);
        scenario.log("User is about to enter OTP to do the changes to Account Details");

        //User has to jump to Mailinator and get the OTP
    }

    @And("User verifies Premium Customer Tag should be appeared for premium user as the user has opted for Credit card")
    public void userVerifiesPremiumCustomerTagShouldBeAppearedForPremiumUserAsTheUserHasOptedForCreditCard() {
        waitUtil.elementToBeLocated(retailProfileOptionsPage.premiumCustomerTagOnProfileOptionsXpath,20);
        scenario.log("Current User is Premium Customer for Retail Application");
    }

    @Then("User clicks on Climb Credit Card")
    public void userClicksOnClimbCreditCard() throws InterruptedException {
        waitUtil.elementToBeClickable(retailProfileOptionsPage.climbCreditCardXpath,25);
        scenario.log("Credit Card Link is appeared");
        Thread.sleep(3000);
        retailProfileOptionsPage.clickOnClimbCreditButton();
        scenario.log("User has clicked on Climb Credit Card");
    }

    @And("User verifies Premium Customer Tag should not be appeared for normal user")
    public void userVerifiesPremiumCustomerTagShouldNotBeAppearedForNormalUser() throws Exception {
        boolean premiumUserTagAvailability =false;
        try {
            waitUtil.elementToBeLocated(retailProfileOptionsPage.premiumCustomerTagOnProfileOptionsXpath, 10);
            scenario.log("Normal User should not be Premium Customer for Retail Application, please check the Test Data or Journey");
            premiumUserTagAvailability=true;
        }catch (Exception ex){
            scenario.log("Premium User tag isn't appeared for Normal User as Expected");
        }
        if(premiumUserTagAvailability) {
            throw new Exception("Platform is showing Normal User as Premium User in Profile details section, which is not expected");
        }
    }

    @Given("User agrees for T&C and provides SSN {string} for credit card")
    public void userAgreesForTCAndProvidesSSNForCreditCard(String ssnID) {
        waitUtil.elementToBeLocated(retailProfileOptionsPage.ssnUITextXpath, 35);
        scenario.log("User has landed on Apply For Climb Credit Card Page and UI text verified..");
        waitUtil.elementToBeLocated(retailProfileOptionsPage.ssnTextFieldAvailabilityXpath, 25);
        retailProfileOptionsPage.enterSSNDetails(ssnID);
        scenario.log("User has provided SSN details");
        retailProfileOptionsPage.clickOnSSNSubmitButton();
        scenario.log("User has clicked on Submit button for Apply credit card");
    }

    @Then("Verify the card details parameters")
    public void verifyTheCardDetailsParameters() {
        waitUtil.elementToBeLocated(retailProfileOptionsPage.virtualCreditCardXpath, 25);
        scenario.log("Credit Card is successfully created...");
        driver.navigate().refresh();
    }

    @And("Update the user data in Retail data")
    public void updateTheUserDataInRetailData() throws IOException {
        String data =readAndWriteTextFiles.readTextFile(FilePaths.RETAIL_SIGNUP_INDEX_PATH);
        //Update if the data is used
        readAndWriteTextFiles.updateTextFile(data, FilePaths.RETAIL_SIGNUP_INDEX_PATH);
    }
}
