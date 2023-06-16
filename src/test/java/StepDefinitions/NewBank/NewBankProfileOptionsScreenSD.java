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

import static Configurations.SetUpDriverConfigurations.RUN_SCRIPTS_IN_HIDE_MODE;

public class NewBankProfileOptionsScreenSD extends BrowserInstance {
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

    @Then("User should able to login with {string} on new Bank app {string}")
    public void userShouldAbleToLoginWithOnNewBankApp(String firstname, String typeOfTesting) {
        if(typeOfTesting.equalsIgnoreCase("positive")) {
            try{
                waitUtil.elementToBeLocated(newBankProfileOptionsPage.getLoggedInUsernameXpath(firstname), 30);
            }
            catch(Exception ex){
                driver.navigate().refresh();
                waitUtil.elementToBeLocated(newBankProfileOptionsPage.getLoggedInUsernameXpath(firstname), 60);
            }
            scenario.log("User is registered an account on new Bank app and Firstname is appeared as expected");
            Assert.assertEquals(newBankProfileOptionsPage.getPageUrl(), newBankProfileOptionsPage.profilePageUrl);
            scenario.log("Profile Option page URL is verified");
        }else{
            scenario.log("Skipping the Test as it falls under Negative testing");
        }
    }

    @Then("User should able to login with {string} and land on dashboard of new Bank app {string}")
    public void userShouldAbleToLoginWithOnNewBankAppAndLandOnDashBoard(String firstname, String typeOfTesting) {
        if(typeOfTesting.equalsIgnoreCase("positive")) {
            try{
                waitUtil.elementToBeLocated(newBankProfileOptionsPage.getLoggedInUsernameXpath(firstname), 30);
            }
            catch(Exception ex){
                driver.navigate().refresh();
                waitUtil.elementToBeLocated(newBankProfileOptionsPage.getLoggedInUsernameXpath(firstname), 60);
            }

            scenario.log("User is registered an account on new Bank app and Firstname is appeared as expected");
            Assert.assertEquals(newBankProfileOptionsPage.getPageUrl(), newBankProfileOptionsPage.dashboardPageUrl);
            scenario.log("Dashboard page URL is verified");
        }else{
            scenario.log("Skipping the Test as it falls under Negative testing");
        }
    }


    @And("User logs out from new Bank app {string}")
    public void userLogsOutFromNewBankApp(String typeOfTesting) {
        if(typeOfTesting.equalsIgnoreCase("positive")) {
            waitUtil.elementToBeLocated(newBankProfileOptionsPage.logoutArrowButton);
            newBankProfileOptionsPage.clickOnLogoutArrowButton();
            scenario.log("User has clicked on Logout arrow button");
            waitUtil.elementToBeClickable(newBankProfileOptionsPage.logoutButtonXpath);
            newBankProfileOptionsPage.clickOnLogoutButton();
            scenario.log("User has clicked on Logout button");
            try {
                waitUtil.elementToBeLocated(newBankWelcomePage.welcomeScreenRef, 45);
            }
            catch(Exception ex){
                driver.navigate().refresh();
                waitUtil.elementToBeLocated(newBankWelcomePage.welcomeScreenRef, 45);
            }
            scenario.log("User has successfully logged-out from the new bank app and landed on welcome page");

        }else{
            scenario.log("Skipping the Test as it falls under Negative testing");
        }
        }

    @Then("Verify the {string}, {string}, {string} and {string} of logged-in user details on new bank app")
    public void verifyTheAndOfLoggedInUserDetailsOnNewBankApp(String email, String firstname, String lastname, String typeOfTesting) throws InterruptedException, IOException {
        if(typeOfTesting.equalsIgnoreCase("positive")) {
            String data =readAndWriteTextFiles.readTextFile(FilePaths.NEW_BANK_REGISTER_EMAIL_INDEX_PATH);
            String myEmail = readAndWriteTextFiles.getPreviouslyCreatedEmail(email,data);

            waitUtil.elementToBeLocated(newBankProfileOptionsPage.personalDetailsRefXpath,45);
            scenario.log("User has landed on Profile Options page in personal details section");
            Thread.sleep(3000);
            Assert.assertEquals(newBankProfileOptionsPage.getEmail(),myEmail);
            scenario.log("Email is appeared as expected");
            Assert.assertEquals(newBankProfileOptionsPage.getFirstName(),firstname);
            scenario.log("Firstname is appeared as expected");
            Assert.assertEquals(newBankProfileOptionsPage.getLastName(),lastname);
            scenario.log("Lastname is appeared as expected");

        }else{
            scenario.log("Skipping the Test as it falls under Negative testing");
        }
        }

    @Then("Verify the {string}, {string}, {string}, {string} and {string} of logged-in user details on new bank app")
    public void verifyTheAndOfLoggedInUserDetailsOnNewBankApp(String email, String firstname, String lastname,String mobileNumber, String typeOfTesting) throws InterruptedException, IOException {
        if(typeOfTesting.equalsIgnoreCase("positive")) {


            waitUtil.elementToBeLocated(newBankProfileOptionsPage.personalDetailsRefXpath,45);
            scenario.log("User has landed on Profile Options page in personal details section");
            Thread.sleep(3000);
            Assert.assertEquals(newBankProfileOptionsPage.getEmail(),email);
            scenario.log("Email is appeared as expected");
            Assert.assertEquals(newBankProfileOptionsPage.getFirstName(),firstname);
            scenario.log("Firstname is appeared as expected");
            Assert.assertEquals(newBankProfileOptionsPage.getLastName(),lastname);
            scenario.log("Lastname is appeared as expected");
            Assert.assertEquals(newBankProfileOptionsPage.getMobileNumber(),mobileNumber);
            scenario.log("Mobile number is appeared as expected");

        }else{
            scenario.log("Skipping the Test as it falls under Negative testing");
        }
    }
    @Then("Verify the {string}, {string}, {string} and {string} of logged-in user details except email on new bank app")
    public void verifyTheAndOfLoggedInUserDetailsOnNewBankAppExceptEmail( String firstname, String lastname,String mobileNumber, String typeOfTesting) throws InterruptedException, IOException {
        if(typeOfTesting.equalsIgnoreCase("positive")) {


            waitUtil.elementToBeLocated(newBankProfileOptionsPage.personalDetailsRefXpath,45);
            scenario.log("User has landed on Profile Options page in personal details section");
            Thread.sleep(3000);
            Assert.assertEquals(newBankProfileOptionsPage.getFirstName(),firstname);
            scenario.log("Firstname is appeared as expected");
            Assert.assertEquals(newBankProfileOptionsPage.getLastName(),lastname);
            scenario.log("Lastname is appeared as expected");
            Assert.assertEquals(newBankProfileOptionsPage.getMobileNumber(),mobileNumber);
            scenario.log("Mobile number is appeared as expected");

        }else{
            scenario.log("Skipping the Test as it falls under Negative testing");
        }
    }

    @Then("Verify the {string}, {string}, {string}, {string}, {string} and {string} of address details on new bank app")
    public void verifyTheAndOfAddressDetailsOnNewBankApp(String streetAddress, String country, String state,String city, String zipcode, String typeOfTesting) throws InterruptedException, IOException {
        if(typeOfTesting.equalsIgnoreCase("positive")) {

            String countryCode=country;
            String stateCode = state;
            waitUtil.elementToBeLocated(newBankProfileOptionsPage.personalDetailsRefXpath,45);
            scenario.log("User has landed on Profile Options page in personal details section");
            Thread.sleep(3000);
            Assert.assertEquals(newBankProfileOptionsPage.getStreetAddress(),streetAddress);
            scenario.log("Street Address is appeared as expected");
            if(country.equalsIgnoreCase("United States")){
                countryCode="US";
            }
            Assert.assertEquals(newBankProfileOptionsPage.getCountryName(),countryCode);
            scenario.log("Country name is appeared as expected");
            if(state.equalsIgnoreCase("California")){
                stateCode="CA";
            }
            Assert.assertEquals(newBankProfileOptionsPage.getStateName(),stateCode);
            scenario.log("State name is appeared as expected");
            Assert.assertEquals(newBankProfileOptionsPage.getCityName(),city);
            scenario.log("City name is appeared as expected");
            Assert.assertEquals(newBankProfileOptionsPage.getZipCode(),zipcode);
            scenario.log("Zipcode is appeared as expected");

        }else{
            scenario.log("Skipping the Test as it falls under Negative testing");
        }
    }

    @Then("User verifies the account details page in all sections")
    public void userVerifiesTheAccountDetailsPageInAllSections() {
        waitUtil.elementToBeLocated(newBankProfileOptionsPage.homeRefXpathOnDashboard,45);
        scenario.log("User has landed on logged-in Dashboard screen");
        Assert.assertEquals(newBankProfileOptionsPage.getPageUrl(), newBankProfileOptionsPage.dashboardPageUrl);
        scenario.log("Dashboard URL has been verified");
        waitUtil.elementToBeLocated(newBankProfileOptionsPage.accountDetailsTextXpath,45);
        scenario.log("Account Details Section has been verified.....");
        waitUtil.elementToBeLocated(newBankProfileOptionsPage.accountNumberAndBranchCodeXpath,45);
        scenario.log("Account Number and Branch Code have been verified.....");
        waitUtil.elementToBeLocated(newBankProfileOptionsPage.creditCard_1_text,45);
        scenario.log("Credit Card 1 has been verified.....");
        newBankProfileOptionsPage.clickOnCreditCardViewRightArrowButton();
        waitUtil.elementToBeLocated(newBankProfileOptionsPage.creditCard_2_text,45);
        scenario.log("Credit Card 2 has been verified.....");
        newBankProfileOptionsPage.clickOnCreditCardViewRightArrowButton();
        waitUtil.elementToBeLocated(newBankProfileOptionsPage.creditCard_3_text,45);
        scenario.log("Credit Card 3 has been verified.....");

        waitUtil.elementToBeLocated(newBankProfileOptionsPage.paymentsSection,45);
        scenario.log("Payments Section: Send Money and Pay a Bill Options have been verified.....");

        waitUtil.elementToBeLocated(newBankProfileOptionsPage.investmentsSection,45);
        scenario.log("Investments Section: Invested in Mutual Funds, Stocks and CryptoCurrency have been verified.....");
    }


    @And("User clicks on profile option on dashboard page of new Bank app")
    public void userClicksOnProfileOptionOnDashboardPageOfBankApp() {
        waitUtil.elementToBeLocated(newBankProfileOptionsPage.homeRefXpathOnDashboard,45);
        newBankProfileOptionsPage.clickOnProfileOptions();
        scenario.log("User has clicked on Profile option link on dashboard");
    }

    @And("User clicks on account option on dashboard page of new Bank app")
    public void userClicksOnAccountOptionOnDashboardPageOfBankApp() {
        waitUtil.elementToBeLocated(newBankProfileOptionsPage.homeRefXpathOnDashboard,45);
        newBankProfileOptionsPage.clickOnAccountOptions();
        scenario.log("User has clicked on Account option link on dashboard");
    }

    @And("User clicks on utilities option on dashboard page of new Bank app")
    public void userClicksOnUtilitiesOptionOnDashboardPageOfBankApp() {
        waitUtil.elementToBeLocated(newBankProfileOptionsPage.homeRefXpathOnDashboard,45);
        newBankProfileOptionsPage.clickOnUtilitiesOptions();
        scenario.log("User has clicked on Utilities option link on dashboard");
    }
    @And("User clicks on pay a bill option on dashboard page of new Bank app")
    public void userClicksOnPayABillOptionOnDashboardPageOfBankApp() {
        waitUtil.elementToBeLocated(newBankProfileOptionsPage.paymentsSection,45);
        newBankProfileOptionsPage.clickOnPayABillOption();
        scenario.log("User has clicked on Pay A Bill option link on dashboard");
    }

    @And("User clicks on transfer option on dashboard page of new Bank app")
    public void userClicksOnTransferOptionOnDashboardPageOfBankApp() {
        waitUtil.elementToBeLocated(newBankProfileOptionsPage.homeRefXpathOnDashboard,45);
        newBankProfileOptionsPage.clickOnTransferOptions();
        scenario.log("User has clicked on Transfer option link on dashboard");
    }
    @And("User clicks on send money option on dashboard page of new Bank app")
    public void userClicksOnSendMoneyOptionOnDashboardPageOfBankApp() {
        waitUtil.elementToBeLocated(newBankProfileOptionsPage.paymentsSection,45);
        newBankProfileOptionsPage.clickOnSendMoneyOption();
        scenario.log("User has clicked on Send Money option link on dashboard");
    }

    @Then("User updates {string}, {string}, {string}, {string} in personal details of new Bank app")
    public void userUpdatesInPersonalDetailsOfNewBankApp(String updateEmail, String updateFirstname, String updateLastname, String mobileNumber) throws InterruptedException {
        waitUtil.elementToBeLocated(newBankProfileOptionsPage.personalDetailsRefXpath,45);
        scenario.log("User has landed on Profile Options page in personal details section");
        Assert.assertEquals(newBankProfileOptionsPage.getPageUrl(), newBankProfileOptionsPage.profilePageUrl);
        scenario.log("Profile Details URL has been verified");
        newBankProfileOptionsPage.clearEmail();
        Thread.sleep(2000);
        newBankProfileOptionsPage.enterEmail(updateEmail);
        scenario.log("User has entered new email");
        Thread.sleep(1000);
        newBankProfileOptionsPage.enterFirstname(updateFirstname);
        scenario.log("User has entered new firstname");
        Thread.sleep(1000);
        newBankProfileOptionsPage.enterLastname(updateLastname);
        scenario.log("User has entered new lastname");
        Thread.sleep(1000);
        newBankProfileOptionsPage.enterMobile(mobileNumber);
        scenario.log("User has entered mobile number");
        Thread.sleep(1000);
    }

    @Then("User updates {string}, {string}, {string} in personal details of new Bank app")
    public void userUpdatesInPersonalDetailsOfNewBankApp(String updateFirstname, String updateLastname, String mobileNumber) throws InterruptedException {
        waitUtil.elementToBeLocated(newBankProfileOptionsPage.personalDetailsRefXpath,45);
        scenario.log("User has landed on Profile Options page in personal details section");
        Assert.assertEquals(newBankProfileOptionsPage.getPageUrl(), newBankProfileOptionsPage.profilePageUrl);
        scenario.log("Profile Details URL has been verified");
        Thread.sleep(2000);
        newBankProfileOptionsPage.enterFirstname(updateFirstname);
        scenario.log("User has entered new firstname");
        Thread.sleep(1000);
        newBankProfileOptionsPage.enterLastname(updateLastname);
        scenario.log("User has entered new lastname");
        Thread.sleep(1000);
        newBankProfileOptionsPage.enterMobile(mobileNumber);
        scenario.log("User has entered mobile number");
        Thread.sleep(1000);
    }

    @And("User clicks on update details and confirm as NO")
    public void userClicksOnUpdateDetailsAndConfirmAsNO() {
        waitUtil.elementToBeLocated(newBankProfileOptionsPage.personalDetailsRefXpath,45);
        scenario.log("User has landed on Profile Options page in personal details section");
        Assert.assertEquals(newBankProfileOptionsPage.getPageUrl(), newBankProfileOptionsPage.profilePageUrl);
        scenario.log("Profile Details URL has been verified");
        newBankProfileOptionsPage.clickOnUpdateYourInformationButton();
        scenario.log("User has clicked on UpdateYourInformationButton");
        waitUtil.elementToBeLocated(newBankProfileOptionsPage.updateDetailsPopUpXpath,45);
        scenario.log("Update Your Information Pop Up/Notification Box has been appeared");
        newBankProfileOptionsPage.clickOnUpdateDetailsNoButton();
        scenario.log("User has declined the Update Information details");
        waitUtil.elementToBeLocated(newBankProfileOptionsPage.personalDetailsRefXpath,45);
        scenario.log("User has landed again on Personal Details section as expected");
    }

    @And("User clicks on update details and confirm as YES and verifies the confirmation message")
    public void userClicksOnUpdateDetailsAndConfirmAsYESAndVerifiesTheConfirmationMessage() throws InterruptedException {
        waitUtil.elementToBeLocated(newBankProfileOptionsPage.personalDetailsRefXpath,45);
        scenario.log("User has landed on Profile Options page in personal details section");
        Assert.assertEquals(newBankProfileOptionsPage.getPageUrl(), newBankProfileOptionsPage.profilePageUrl);
        scenario.log("Profile Details URL has been verified");
        Thread.sleep(2000);
        newBankProfileOptionsPage.clickOnUpdateYourInformationButton();
        scenario.log("User has clicked on UpdateYourInformationButton");
        waitUtil.elementToBeLocated(newBankProfileOptionsPage.updateDetailsPopUpXpath,45);
        scenario.log("Update Your Information Pop Up/Notification Box has been appeared");
        Thread.sleep(2000);
        newBankProfileOptionsPage.clickOnUpdateDetailsYesButton();
        scenario.log("User has accepted the Update Information details");
        waitUtil.elementToBeLocated(newBankProfileOptionsPage.detailsUpdatedSuccessfullyMessageXpath,45);
        scenario.log("Details have been updated confirmation message has been verified");
        waitUtil.elementToBeLocated(newBankProfileOptionsPage.personalDetailsRefXpath,45);
        scenario.log("User has landed again on Personal Details section as expected");
    }

    @Then("User updates {string}, {string}, {string}, {string} and {string} address details in location section of new Bank app")
    public void userUpdatesAndAddressDetailsInLocationSectionOfNewBankApp(String streetAddress, String country, String state, String city, String zipcode) throws InterruptedException {
     waitUtil.elementToBeLocated(newBankProfileOptionsPage.locationDetailsRefXpath,45);
            scenario.log("User has landed on Profile Options page in location details section");
            Assert.assertEquals(newBankProfileOptionsPage.getPageUrl(), newBankProfileOptionsPage.profilePageUrl);
            scenario.log("Profile Details URL has been verified");

            Thread.sleep(1000);
            newBankProfileOptionsPage.enterStreetAddress(streetAddress);
            scenario.log("User has entered street address");
            Thread.sleep(500);
            newBankProfileOptionsPage.clickOnCountryDropDown();
            Thread.sleep(2000);
            newBankProfileOptionsPage.clickOnDropDownListItem(country);
            scenario.log("User has selected Country name from the list");
           Thread.sleep(1500);
            newBankProfileOptionsPage.clickOnStateDropDown();
            Thread.sleep(2000);
            newBankProfileOptionsPage.clickOnDropDownListItem(state);
            scenario.log("User has selected State name from the list");
            newBankProfileOptionsPage.enterCityDetails(city);
            scenario.log("User has entered city name");
            Thread.sleep(500);
            newBankProfileOptionsPage.enterZipCodeDetails(zipcode);
            scenario.log("User has entered zipcode detail");
            Thread.sleep(500);
    }

    @And("User provides the details of payments like {string}, {string}, {string} and click on confirm payment")
    public void userProvidesTheDetailsOfPaymentsLikeAndClickOnConfirmPayment(String chooseAProvider, String selectAccountType, String amountToTransfer) throws InterruptedException {
    waitUtil.elementToBeLocated(newBankUtilitiesPage.servicePaymentsScreenRefXpath,45);
    scenario.log("User has landed on Payments/Utilities page");
    Assert.assertEquals(newBankUtilitiesPage.getPageUrl(),newBankUtilitiesPage.utilitiesPageUrl);
    scenario.log("Utilities page URL has been verified");
    newBankUtilitiesPage.clickOnChooseAProviderDrpDwn();
    Thread.sleep(1500);
    newBankUtilitiesPage.selectAProviderDropDown(chooseAProvider);
        scenario.log("User has selected a service provider");
    newBankUtilitiesPage.clickOnSelectYourAccountDrpDwn();
    Thread.sleep(1500);
    newBankUtilitiesPage.selectYourAccountDropDown(selectAccountType);
        scenario.log("User has selected account type");
    newBankUtilitiesPage.enterAmountToTransfer(amountToTransfer);
    scenario.log("User has provided the amount to transfer");
    newBankUtilitiesPage.clickOnConfirmPayment();
    scenario.log("User has clicked on Confirm Payment button");
    }

    @Then("User gets the verification code and verify the QR code page UI text")
    public void userGetsTheVerificationCodeAndVerifyTheQRCodePageUIText() {
        waitUtil.elementToBeLocated(newBankUtilitiesPage.qrCodeTextVerificationTextRefXpath,45);
        scenario.log("QR Code Section has been appeared");
        Assert.assertEquals(newBankUtilitiesPage.getPageUrl(),newBankUtilitiesPage.utilitiesPageUrl);
        scenario.log("QR page URL has been verified");
        String verificationCode = newBankUtilitiesPage.getVerificationCode();
        scenario.log("Verification Code has been generated. CODE:"+verificationCode);
    }

    @Then("User clicks on make a new payment button")
    public void userClicksOnMakeANewPaymentButton() {
        waitUtil.elementToBeLocated(newBankTransferPage.transferScreenRef,45);
        scenario.log("Transfer Page has been appeared");
        newBankTransferPage.clickOnMakeAPayment();
        scenario.log("User has clicked on make a new payment");
    }

    @Then("User confirms the transaction risk")
    public void userConfirmsTheTransactionRisk() {
        waitUtil.elementToBeLocated(newBankTransferPage.transactionRiskRefXpath,45);
        scenario.log("Transaction Risk Page has been appeared");
        newBankTransferPage.clickOnTransactionButton();
        scenario.log("User has clicked on Transaction Risk Continue Button");
    }

    @Then("User gets the Success message for the transaction")
    public void userGetsTheSuccessMessageForTheTransaction() {
        waitUtil.elementToBeLocated(newBankTransferPage.successMsg,45);
        scenario.log("Success Message has been appeared");
    }

    @And("User clicks on make another payment")
    public void userClicksOnMakeAnotherPayment() {
        waitUtil.elementToBeLocated(newBankTransferPage.successMsg,45);
        newBankTransferPage.clickOnMakeAnotherPayment();
        scenario.log("User has clicked on make another payment");
    }

    @Given("User provides the transfer details like {string}, {string}, {string}, {string}, {string} and click on continue")
    public void userProvidesTheTransferDetailsLikeAndClickOnContinue(String payeeName, String accountNumber, String confirmAccNumber, String transferAmount, String typeOfTesting) {
        if(typeOfTesting.equalsIgnoreCase("positive")){
            waitUtil.elementToBeLocated(newBankTransferPage.sendMoneyHeaderRefXpath,45);
            scenario.log("User has landed on Send Money page");
            newBankTransferPage.enterPayeeName(payeeName);
            scenario.log("User has provided PayeeName");
            newBankTransferPage.enterPayeeAccountNumber(accountNumber);
            scenario.log("User has provided AccountNumber");
            newBankTransferPage.enterConfirmPayeeAccountNumber(confirmAccNumber);
            scenario.log("User has provided ConfirmAccountNumber");
            newBankTransferPage.enterAmountToTransfer(transferAmount);
            scenario.log("User has provided Transfer Amount");
            newBankTransferPage.clickOnConfirmPayment();
            scenario.log("User has clicked on Confirm Payment");
        }
        else{
            waitUtil.elementToBeLocated(newBankTransferPage.sendMoneyHeaderRefXpath,45);
            scenario.log("User has landed on Send Money page");
            newBankTransferPage.enterPayeeName(payeeName);
            scenario.log("User has provided PayeeName");
            newBankTransferPage.enterPayeeAccountNumber(accountNumber);
            scenario.log("User has provided AccountNumber");
            newBankTransferPage.enterConfirmPayeeAccountNumber(confirmAccNumber);
            scenario.log("User has provided different ConfirmAccountNumber");
            newBankTransferPage.enterAmountToTransfer(transferAmount);
            scenario.log("User has provided Transfer Amount");
            newBankTransferPage.clickOnConfirmPayment();
            scenario.log("User has clicked on Confirm Payment");
            waitUtil.elementToBeLocated(newBankTransferPage.accountAccNumAndConfirmAccNumAreNotMatchedError,45);
           scenario.log("Payee Account Number and Confirm Payee Account Number should be matched verification has been done");
        }
    }

    @Then("User clicks on Preferences tab in account details of new Bank app")
    public void userClicksOnPreferencesTabInAccountDetailsOfNewBankApp() {
        waitUtil.elementToBeLocated(newBankProfileOptionsPage.personalDetailsRefXpath,30);
        scenario.log("Preferences tab is appeared");
        newBankProfileOptionsPage.clickOnPreferencesLink();
        scenario.log("User has clicked on Preferences Link");
    }

    @Then("User clicks on Privacy and Consent tab in account details of new Bank app")
    public void userClicksOnPrivacyAndConsentTabInAccountDetailsOfNewBankApp() {
        waitUtil.elementToBeLocated(newBankProfileOptionsPage.personalDetailsRefXpath,30);
        scenario.log("Privacy And Consent tab is appeared");
        newBankProfileOptionsPage.clickOnPrivacyAndConsentLink();
        scenario.log("User has clicked on PrivacyAndConsent Link");
    }

    @Then("User clicks on MyDevices tab in account details of new Bank app")
    public void userClicksOnMyDevicesTabInAccountDetailsOfNewBankApp() {
        waitUtil.elementToBeLocated(newBankProfileOptionsPage.personalDetailsRefXpath,30);
        scenario.log("MyDevices tab is appeared");
        newBankProfileOptionsPage.clickOnMyDevicesLink();
        scenario.log("User has clicked on MyDevices Link");
    }

    @Then("User clicks on Delegate Access tab in account details of new Bank app")
    public void userClicksOnDelegateAccessTabInAccountDetailsOfNewBankApp() {
        waitUtil.elementToBeLocated(newBankProfileOptionsPage.personalDetailsRefXpath,30);
        scenario.log("Delegate Access tab is appeared");
        newBankProfileOptionsPage.clickOnDelegateAccessLink();
        scenario.log("User has clicked on Delegate Access Link");
    }

    @And("User waits until the Preferences i-frame appears and validate the details for new Bank app")
    public void userWaitsUntilThePreferencesIFrameAppearsAndValidateTheDetailsForNewBankApp() throws InterruptedException {

        if(!RUN_SCRIPTS_IN_HIDE_MODE){
            //UI Open
            waitUtil.elementToBeLocated(newBankProfileOptionsPage.preferencesRefScreenXpath,30);
            scenario.log("User has navigated to Preferences screen");

            waitUtil.elementToBeLocated(healthHomeScreenPage.iframeBankPreferencesXpath,50);
            Thread.sleep(7000);
            driver.switchTo().frame(0);
            waitUtil.elementToBeLocated(newBankProfileOptionsPage.preferencesIframeRefText);
            scenario.log("Advertisement & Language Preferences is appeared in Preferences");
            waitUtil.elementToBeLocated(healthHomeScreenPage.prefUndoChangesButton);
            scenario.log("Undo Changes button is appeared in Preferences");
            waitUtil.elementToBeLocated(healthHomeScreenPage.prefChangePreferencesXpath);
            scenario.log("Change Preferences button is appeared in Preferences");
            Thread.sleep(2000);
            driver.switchTo().defaultContent();
        }else{
            //UI Disable
            waitUtil.elementToBeLocated(newBankProfileOptionsPage.preferencesRefScreenXpath,30);
            scenario.log("User has navigated to Preferences screen");
            scenario.log("Advertisement & Language Preferences is appeared in Preferences");
            scenario.log("Undo Changes button is appeared in Preferences");
            scenario.log("Change Preferences button is appeared in Preferences");
        }
    }

    @And("User waits until the Privacy and Consent i-frame appears and validate the details for new Bank app")
    public void userWaitsUntilThePrivacyAndConsentIFrameAppearsAndValidateTheDetailsForNewBankApp() throws InterruptedException {

        if(!RUN_SCRIPTS_IN_HIDE_MODE){
            //UI Open
            waitUtil.elementToBeLocated(newBankProfileOptionsPage.privacyAndConsentRefScreenXpath,30);
            scenario.log("User has navigated to Privacy And Consent screen");
            waitUtil.elementToBeLocated(healthHomeScreenPage.iframeBankPreferencesXpath,50);
            Thread.sleep(7000);
            driver.switchTo().frame(0);
            waitUtil.elementToBeLocated(healthHomeScreenPage.privacyHeaderXpath,60);
            scenario.log("Consent Management is appeared in Privacy and Consent");
            waitUtil.elementToBeLocated(healthHomeScreenPage.prefUndoChangesButton);
            scenario.log("Undo Changes button is appeared in Privacy and Consent");
            waitUtil.elementToBeLocated(healthHomeScreenPage.prefChangeConsentXpath);
            scenario.log("Change Preferences button is appeared in Privacy and Consent");
            Thread.sleep(2000);
            driver.switchTo().defaultContent();
        }else{
            //UI Disable
            waitUtil.elementToBeLocated(newBankProfileOptionsPage.privacyAndConsentRefScreenXpath,30);
            scenario.log("User has navigated to Privacy And Consent screen");
            scenario.log("Consent Management is appeared in Privacy and Consent");
            scenario.log("Undo Changes button is appeared in Privacy and Consent");
            scenario.log("Change Preferences button is appeared in Privacy and Consent");
        }
    }

    @Then("User verifies the myDevices page and clicks on add new email as a MFA source")
    public void userVerifiesTheMyDevicesPageAndClicksOnAddNewEmailAsAMFASource() {
        waitUtil.elementToBeLocated(newBankProfileOptionsPage.myDevicesRefScreenXpath,30);
        scenario.log("User has navigated to MyDevices screen");
        waitUtil.elementToBeLocated(newBankProfileOptionsPage.noDeviceHasBeenRegisteredText,30);
        scenario.log("No Devices has been registered text appeared as expected");
        Assert.assertEquals(newBankProfileOptionsPage.getPageUrl(), newBankProfileOptionsPage.myDevicesPageUrl);
        scenario.log("MyDevices Page URL has been verified");
        newBankProfileOptionsPage.clickOnAddANewMfaDevice();
        scenario.log("User has clicked on add new MFA device");
        waitUtil.elementToBeLocated(newBankProfileOptionsPage.mfaDeviceEmailButtonRef,30);
        scenario.log("Add Email Device Text has been verified");

        waitUtil.elementToBeLocated(newBankProfileOptionsPage.mfaDeviceTextMessageButtonRef,30);
        scenario.log("Add Text Message Device Text has been verified");
        waitUtil.elementToBeLocated(newBankProfileOptionsPage.mfaDeviceVoiceButtonRef,30);
        scenario.log("Add Voice Device Text has been verified");
        waitUtil.elementToBeLocated(newBankProfileOptionsPage.mfaDeviceUnauthenticatorAppButtonRef,30);
        scenario.log("Add UnAuthenticator Device Text has been verified");
        waitUtil.elementToBeLocated(newBankProfileOptionsPage.mfaDeviceBiometricButtonRef,30);
        scenario.log("Add Biometric Device Text has been verified");

        newBankProfileOptionsPage.clickOnEmailMfaDeviceButton();
        scenario.log("User has clicked on Add Email MFA device button");

    }

    @Then("User verifies the availability of email MFA device")
    public void userVerifiesTheAvailabilityOfEmailMFADeviceAndClickOn() {
        waitUtil.elementToBeLocated(newBankProfileOptionsPage.addedEmailMFAdeviceRefXpath,50);
        scenario.log("MFA devices has been added and appeared as expected");

    }

    @And("User deletes the added MFA device")
    public void userDeletesTheAddedMFADevice() {
        waitUtil.elementToBeLocated(newBankProfileOptionsPage.addedEmailMFAdeviceRefXpath,20);
        scenario.log("MFA devices has been added and appeared as expected");
        newBankProfileOptionsPage.clickOnEmailMfaDeviceHamburgerOption();
        scenario.log("User has clicked on hamburger option on registered MFA email device");
        waitUtil.elementToBeLocated(newBankProfileOptionsPage.deleteMfaDeviceRefLink,20);
        newBankProfileOptionsPage.clickOnDeleteEmailMFADevice();
        scenario.log("User has clicked on Delete MFA device");
    }

    @Then("User verifies there should not be any MFA device listed")
    public void userVerifiesThereShouldNotBeAnyMFADeviceListed() {
        waitUtil.elementToBeLocated(newBankProfileOptionsPage.noDeviceHasBeenRegisteredText,30);
        scenario.log("No Devices has been registered text appeared as expected");
    }

    @Then("User verifies the Email MFA device should be available")
    public void userVerifiesTheEmailMFADeviceShouldBeAvailable() {
        waitUtil.elementToBeLocated(newBankProfileOptionsPage.availableMfaDeviceRef,50);
        scenario.log("MFA devices has been added already and appeared as expected");
    }

    @Then("User setup a random nick name and verifies the updated nick name")
    public void userSetupARandomNickNameAndVerifiesTheUpdatedNickName() {
        waitUtil.elementToBeLocated(newBankProfileOptionsPage.availableMfaDeviceRef,50);
        newBankProfileOptionsPage.clickOnEmailMfaDeviceHamburgerOption();
        scenario.log("User has clicked on hamburger option on registered MFA email device");
        waitUtil.elementToBeLocated(newBankProfileOptionsPage.deleteMfaDeviceRefLink,20);
        newBankProfileOptionsPage.clickOnAddNickNameForAddedMFAdevice();
        scenario.log("User has clicked on Add NickName for MFA device");
        waitUtil.elementToBeLocated(newBankProfileOptionsPage.nickNameTextFiledBoxRef,50);
        scenario.log("NickName Setup Section has been appeared as expected");
        String randomNickName =randomStrings.getRandomFormatOfPasscode(3,5,2);
        scenario.log("Random nickname :"+randomNickName);
        newBankProfileOptionsPage.enterNickName(randomNickName);
        scenario.log("User has entered the Nick name");
        newBankProfileOptionsPage.clickOnSetNickNameButton();
        scenario.log("User has clicked on setup Nick name button");
        waitUtil.elementToBeLocated(newBankProfileOptionsPage.waitForNickNameToBeUpdatedXpath(randomNickName),50);
        scenario.log("NickName has been updated as expected");



    }

    @And("User waits until the Delegate access section to be opened")
    public void userWaitsUntilTheDelegateAccessSectionToBeOpened() {
        waitUtil.elementToBeLocated(newBankProfileOptionsPage.delegateAccessPageRef,50);
        scenario.log("User has landed on Delegate Access Page");
        Assert.assertEquals(newBankProfileOptionsPage.getPageUrl(), newBankProfileOptionsPage.delegateAccessPageUrl);
        scenario.log("Delegate Access Page URL has been verified");
        waitUtil.elementToBeLocated(newBankProfileOptionsPage.delegateAccessSectionOpenedRefXpath,50);
        scenario.log("Delegate Access Section has appeared");
    }

    @Then("User adds a new member in delegate access section to transfer an amount")
    public void userAddsANewMemberInDelegateAccessSectionToTransferAnAmount() {
        waitUtil.elementToBeLocated(newBankProfileOptionsPage.delegateAccessSectionOpenedRefXpath,50);
        newBankProfileOptionsPage.clickOnAddAuthorizedUserButton();
        scenario.log("User has clicked on Add Authorized User Button");
    }

    @Given("User provides authorized user details like {string}, {string}, {string}, {string} and clicks on add button")
    public void userProvidesAuthorizedUserDetailsLikeAndClicksOnAddButton(String firstname, String lastname, String email, String transferlimit) {
        waitUtil.elementToBeLocated(newBankProfileOptionsPage.addDelegateUserSectionAppearedXpath,50);
        scenario.log("Add Delegate User Section has appeared");
        newBankProfileOptionsPage.enterFirstnameAuthorizedUser(firstname);
        scenario.log("User has provided Firstname");
        newBankProfileOptionsPage.enterLastnameAuthorizedUser(lastname);
        scenario.log("User has provided Lastname");
        newBankProfileOptionsPage.enterEmailAuthorizedUser(email);
        scenario.log("User has provided email");
        newBankProfileOptionsPage.enterTransferLimitAuthorizedUser(transferlimit);
        scenario.log("User has provided TransferLimit");
        newBankProfileOptionsPage.clickOnAddDelegateUser();
        scenario.log("User has clicked on Add Delegate User button");

    }

    @Then("User verifies the success message on Delegate access screen")
    public void userVerifiesTheSuccessMessageOnDelegateAccessScreen() {
        waitUtil.elementToBeLocated(newBankProfileOptionsPage.successMessageXpathRef,50);
        scenario.log("User has successfully added the delegate user details");
    }

    @Then("User clicks on back button of Delegate Access page")
    public void userClicksOnBackButtonOfDelegateAccessPage() {
        newBankProfileOptionsPage.clickOnBackToDelegateAccessButton();
        scenario.log("User has clicked on back button of Delegate Access page");
    }

    @Then("User verifies the availability of the Delegate user details like {string}, {string}, {string}, {string}")
    public void userVerifiesTheAvailabilityOfTheDelegateUserDetailsLike(String firstname, String lastname, String email, String transferamount) {
        waitUtil.elementToBeLocated(newBankProfileOptionsPage.waitForTheDelegateUserAddedInfo(firstname,lastname,email,transferamount),60);
        scenario.log("User has verified the details like firstname, lastname, email, transfer amount and delegate user details have been updated as expected");
    }
}


