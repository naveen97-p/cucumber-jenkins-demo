package StepDefinitions.Banking;

import Configurations.Passcodes;
import Utilities.BrowserInstance;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;

import static Configurations.SetUpDriverConfigurations.RUN_SCRIPTS_IN_HIDE_MODE;

public class BankingProfileOptionsSD extends BrowserInstance {
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

    @And("Verify the registered details should be populated in Account details section {string}, {string}, {string}, {string}")
    public void verifyTheRegisteredDetailsShouldBePopulatedInAccountDetailsSection(String typeOfTesting,String email, String firstname, String lastname) throws InterruptedException {
        if (typeOfTesting.equalsIgnoreCase("positive")){
            waitUtil.elementToBeLocated(bankingLoggedInHomePage.profileOptionLink,45);
            bankingProfileOptionsPage.clickOnProfileLink();
            scenario.log("User has clicked on Profile Option");
            waitUtil.elementToBeLocated(bankingProfileOptionsPage.accountDetailsRefXpath,40);
            Thread.sleep(4000);
            String actualFirstname= bankingProfileOptionsPage.getFirstName();
            String actualLastname= bankingProfileOptionsPage.getLastName();
            String actualEmail= bankingProfileOptionsPage.getEmail();
            Assert.assertEquals(actualEmail,email,"Email isn't appeared as expected, actual:"+actualEmail);
            Assert.assertEquals(actualFirstname,firstname,"Firstname isn't appeared as expected, actual:"+actualFirstname);
            Assert.assertEquals(actualLastname,lastname,"Lastname isn't appeared as expected, actual:"+lastname);
            scenario.log("Firstname, Lastname and Email details are correct");
        }
        else{
            scenario.log("Negative Test Case: Hence, script is skipping this line....");
        }
    }

   // add or update the password for bank app
   @Given("add or update the password for bank app")
   public void addOrUpdateThePassword() throws InterruptedException {
       waitUtil.elementToBeLocated(bankingProfileOptionsPage.accountDetailsRefXpath, 40);
       bankingProfileOptionsPage.enterNewPassword(Passcodes.UPDATE_PASSWORD);
       scenario.log("User has entered new password");
       Thread.sleep(2000);
       bankingProfileOptionsPage.clickOnSaveChangesButton();
       scenario.log("User has clicked on save changes button");


       waitUtil.elementToBeLocated(bankingProfileOptionsPage.updateAddressConfirmationAlertRefXpath,40);
       scenario.log("Confirmation alert appeared");
       Thread.sleep(4000);
       bankingProfileOptionsPage.clickOnConfirmationAlertOkButton();
       scenario.log("Password has been changed");
       waitUtil.elementToBeLocated(bankingProfileOptionsPage.accountDetailsRefXpath,40);
   }


    @Given("add or update the address details like {string}, {string}, {string} {string}, {string}, {string},{string} in account details page of bank app")
    public void addOrUpdateTheAddressDetailsLikeInAccountDetailsPageOfBankApp(String mobile, String address, String optAddress, String city, String state, String zipCode, String country) throws InterruptedException {
        waitUtil.elementToBeLocated(bankingProfileOptionsPage.accountDetailsRefXpath,40);
        Thread.sleep(4000);
        if (!mobile.equalsIgnoreCase("")){
        bankingProfileOptionsPage.updatePhoneNumber(mobile);}

        if (!address.equalsIgnoreCase("")){
        bankingProfileOptionsPage.updateAddressDetails(address);}
        if (!optAddress.equalsIgnoreCase("")){
        bankingProfileOptionsPage.updateOptionalAddressDetails(optAddress);}
        if (!city.equalsIgnoreCase("")){
        bankingProfileOptionsPage.updateCityDetails(city);}
        if (!state.equalsIgnoreCase("")){
        bankingProfileOptionsPage.updateStateDetails(state);}
        if (!zipCode.equalsIgnoreCase("")){
        bankingProfileOptionsPage.updateZipCodeDetails(zipCode);}
        if (!country.equalsIgnoreCase("")){
        bankingProfileOptionsPage.updateCountryDetails(country);}

        scenario.attach(captureScreen.takeScreenShot(),"image/png","Ref: Change of Address Details");
        bankingProfileOptionsPage.clickOnSaveChangesButton();
        scenario.log("Address details have been updated");

        waitUtil.elementToBeLocated(bankingProfileOptionsPage.updateAddressConfirmationAlertRefXpath,40);
        scenario.log("Confirmation alert appeared");
        Thread.sleep(2000);
        bankingProfileOptionsPage.clickOnConfirmationAlertOkButton();
        waitUtil.elementToBeLocated(bankingProfileOptionsPage.accountDetailsRefXpath,40);


    }


    @Then("Verify the address details are updated as expected {string}, {string}, {string}, {string}, {string}, {string},{string} of bank app")
    public void verifyTheAddressDetailsAreUpdatedAsExpectedOfBankApp(String mobile, String address,String optAddress, String city, String state, String zipCode, String country) throws InterruptedException {
        waitUtil.elementToBeLocated(bankingProfileOptionsPage.accountDetailsRefXpath,40);
        Thread.sleep(4000);

        String actualAddress = bankingProfileOptionsPage.getAddress();
        String actualOptAddress = bankingProfileOptionsPage.getAddressOptional();
        String actualMobile = bankingProfileOptionsPage.getMobile();
        String actualCity = bankingProfileOptionsPage.getCity();
        String actualState = bankingProfileOptionsPage.getState();
        String actualZipCode = bankingProfileOptionsPage.getZipCode();
        String actualCountry = bankingProfileOptionsPage.getCountry();

        if (!address.equalsIgnoreCase("")){
        Assert.assertEquals(actualAddress,address,"Address isn't appeared as expected, actual:"+actualAddress);}
        if (!optAddress.equalsIgnoreCase("")){
        Assert.assertEquals(actualOptAddress,optAddress,"Optional Address isn't appeared as expected, actual:"+actualOptAddress);}
        if (!mobile.equalsIgnoreCase("")){
        Assert.assertEquals(actualMobile,mobile,"Mobile number isn't appeared as expected, actual:"+actualMobile);}
        if (!city.equalsIgnoreCase("")){
        Assert.assertEquals(actualCity,city,"City name isn't appeared as expected, actual:"+actualCity);}
        if (!state.equalsIgnoreCase("")){
        Assert.assertEquals(actualState,state,"State name isn't appeared as expected, actual:"+actualState);}
        if (!zipCode.equalsIgnoreCase("")){
        Assert.assertEquals(actualZipCode,zipCode,"ZipCode isn't appeared as expected, actual:"+actualZipCode);}
        if (!country.equalsIgnoreCase("")){
        Assert.assertEquals(actualCountry,country,"Country isn't appeared as expected, actual:"+actualCountry);}

        scenario.log("CHANGE OF ADDRESS DETAILS ARE APPEARED/UPDATED AS EXPECTED");

    }

    @And("User clicks on Preferences tab in account details of Bank app")
    public void userClicksOnPreferencesTabInAccountDetailsOfBankApp() {
        waitUtil.elementToBeLocated(bankingProfileOptionsPage.preferencesButtonXpath);
        scenario.log("User has landed on AccountDetails Screen");
        bankingProfileOptionsPage.clickOnPreferencesTab();
        scenario.log("User has clicked on Preferences Tab");
    }
    @And("User clicks on Privacy and Consent tab in account details of Bank app")
    public void userClicksOnPrivacyAndConsentTabInAccountDetailsOfBankApp() {
        waitUtil.elementToBeLocated(bankingProfileOptionsPage.privacyAndConsentButtonXpath);
        scenario.log("User has landed on AccountDetails Screen");
        bankingProfileOptionsPage.clickOnPrivacyAndConsentTab();
        scenario.log("User has clicked on Privacy&Consent Tab");
    }

    @And("User clicks on MyDevices tab in account details of Bank app")
    public void userClicksOnMyDevicesTabInAccountDetailsOfBankApp() {
        waitUtil.elementToBeLocated(bankingProfileOptionsPage.myDevicesButtonXpath);
        scenario.log("User has landed on AccountDetails Screen");
        bankingProfileOptionsPage.clickOnMyDevicesTab();
        scenario.log("User has clicked on MyDevices Tab");
    }

    @Then("User verifies preferences i-frame for Banking app")
    public void userProvidesToPreferencesIFrameClickOnSend() throws InterruptedException {

        if(!RUN_SCRIPTS_IN_HIDE_MODE) {

            waitUtil.elementToBeLocated(bankingProfileOptionsPage.communicationsPrefencesRefXpath);
            scenario.log("Communication Preferences header is appeared as expected");
            waitUtil.elementToBeLocated(healthHomeScreenPage.iframeBankPreferencesXpath, 50);
            Thread.sleep(7000);
            driver.switchTo().frame(0);
            waitUtil.elementToBeLocated(healthHomeScreenPage.preferencesHeaderXpath);
            scenario.log("Advertisement & Language Preferences is appeared in Preferences");
            waitUtil.elementToBeLocated(healthHomeScreenPage.prefUndoChangesButton);
            scenario.log("Undo Changes button is appeared in Preferences");
            waitUtil.elementToBeLocated(healthHomeScreenPage.prefChangePreferencesXpath);
            scenario.log("Change Preferences button is appeared in Preferences");
            prepareFailureEvidence("Preferences OneTrust i-frame");
            Thread.sleep(2000);
            driver.switchTo().defaultContent();
        }
        else{
            waitUtil.elementToBeLocated(bankingProfileOptionsPage.communicationsPrefencesRefXpath);
            scenario.log("Communication Preferences header is appeared as expected");
            scenario.log("Advertisement & Language Preferences is appeared in Preferences");
            scenario.log("Undo Changes button is appeared in Preferences");
            scenario.log("Change Preferences button is appeared in Preferences");

        }
    }

    @Then("User verifies privacy and consent i-frame for Banking app")
    public void userProvidesToPrivacyAndConsentIFrameClickOnSend() throws InterruptedException {
        if(!RUN_SCRIPTS_IN_HIDE_MODE) {

        waitUtil.elementToBeLocated(bankingProfileOptionsPage.privacyAndConsentRefXpath);
        scenario.log("Privacy And Consent header is appeared as expected");
        waitUtil.elementToBeLocated(healthHomeScreenPage.iframeBankPrivacyXpath,50);
        Thread.sleep(7000);
        driver.switchTo().frame(1);
        waitUtil.elementToBeLocated(healthHomeScreenPage.privacyHeaderXpath,260);
        scenario.log("Consent Management is appeared in Privacy and Consent");
        waitUtil.elementToBeLocated(healthHomeScreenPage.prefUndoChangesButton);
        scenario.log("Undo Changes button is appeared in Privacy and Consent");
        waitUtil.elementToBeLocated(healthHomeScreenPage.prefChangeConsentXpath);
        scenario.log("Change Preferences button is appeared in Privacy and Consent");
        prepareFailureEvidence("Privacy & Consent OneTrust i-frame");
        Thread.sleep(2000);
        driver.switchTo().defaultContent();
        }
        else {
            waitUtil.elementToBeLocated(bankingProfileOptionsPage.privacyAndConsentRefXpath);
            scenario.log("Privacy And Consent header is appeared as expected");
            scenario.log("Consent Management is appeared in Privacy and Consent");
            scenario.log("Undo Changes button is appeared in Privacy and Consent");
            scenario.log("Change Preferences button is appeared in Privacy and Consent");
            prepareFailureEvidence("Privacy & Consent OneTrust i-frame");
        }
    }

    @Then("User verifies the push notification and authentication app sections for Non-Registered Devices of Bank app")
    public void userVerifiesThePushNotificationAndAuthenticationAppSectionsOfBankApp() {
        waitUtil.elementToBeLocated(bankingProfileOptionsPage.myDevicesRefXpath);
        scenario.log("Trusted Devices header is appeared as expected");
        waitUtil.elementToBeLocated(bankingProfileOptionsPage.pushNotificationDeviceStaticTextWithoutRegistrationXpath);
        scenario.log("Static Text Verification: Push Notification Device Section-PASSED");
        waitUtil.elementToBeLocated(bankingProfileOptionsPage.authenticationDeviceStaticTextWithoutRegistrationXpath);
        scenario.log("Static Text Verification: Authentication App Section-PASSED");
    }


}
