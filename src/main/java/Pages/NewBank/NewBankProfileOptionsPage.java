package Pages.NewBank;

import Utilities.BrowserInstance;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewBankProfileOptionsPage extends BrowserInstance {

        //START:  ---------Title Verification-----------
        public String registrationScreenRef ="//*[text()='Welcome onboard!']//following::*[contains(text(),\"We are delighted to have you join our family. Let's get started.\")]";
        public String profilePageUrl="https://bank.ciam.sandbox.ciamsgo.com/profile/details";
        public String personalDetailsRefXpath="//*[text()=\"Account Details\"]/following::*[text()=\"PERSONAL INFORMATION\"]";
        public String locationDetailsRefXpath="//*[text()=\"Account Details\"]/following::*[text()=\"LOCATION\"]";
        public String dashboardPageUrl="https://bank.ciam.sandbox.ciamsgo.com/profile/dashboard";
        public String logoutArrowButton="//*[@data-testid='KeyboardArrowDownIcon']";
        public String logoutButtonXpath="//*[text()='Logout']";

        //DashBoard Items
        public String homeRefXpathOnDashboard="//*[text()='HOME']";
        public String accountDetailsTextXpath="//*[text()='YOUR ACCOUNT DETAILS']//following::*[text()='Available Balance']//following::*[text()='Last Month Credit']//following::*[text()='Last Month Debit']";
        public String accountNumberAndBranchCodeXpath="//*[text()='BAN876497']//following::*[text()='Account Number']//following::*[text()='ZC0091E']//following::*[text()='Branch Code']";

        public String creditCard_1_text ="//*[text()='YOUR CARDS']//following::*[text()='1111 5555 4444 8989']//following::*[text()=\"$90,000\"]";
        public String creditCard_2_text ="//*[text()='YOUR CARDS']//following::*[text()='2212 3333 7777 0000']//following::*[text()=\"$56,000\"]";
        public String creditCard_3_text ="//*[text()='YOUR CARDS']//following::*[text()='8888 7777 9999 1111']//following::*[text()=\"$38,139\"]";

        public String paymentsSection="(//*[text()=\"PAYMENTS\"])[2]//following::*[text()='Send Money']//following::*[text()='Pay a Bill']";
        public String investmentsSection="//*[text()=\"YOUR INVESTMENTS\"]//following::*[text()='Invested in Mutual Funds']//following::*[text()='Invested in Stocks']//following::*[text()='Invested in Cryptocurrency']";

        public String updateDetailsPopUpXpath ="//*[contains(text(),'Update Details')]/following::*[text()=\"Are you sure you want to update the details?\"]";
        public String detailsUpdatedSuccessfullyMessageXpath="//*[contains(text(),'Details Updated Successfully !!')]";

        //Preferences
        public String preferencesPageUrl="https://bank.ciam.sandbox.ciamsgo.com/profile/details#preferences";
        public String preferencesRefScreenXpath="//*[text()=\"Manage your Preferences\"]";
        public String preferencesIframeRefText="//*[text()=\" Advertisement & Language Preferences \"]";

        //PrivacyAndConsent
        public String privacyAndConsentPageUrl="https://bank.ciam.sandbox.ciamsgo.com/profile/details#privacy";
    public String privacyAndConsentRefScreenXpath="//*[text()=\"Manage your Privacy & Consent\"]";
    //MyDevice
    public String myDevicesPageUrl="https://bank.ciam.sandbox.ciamsgo.com/profile/details#myDevices";
    public String myDevicesRefScreenXpath="//*[text()=\"Authentication Methods\"]/following::*[text()=\"These devices are paired with your account for Multi factor authentication\"]";
    public String noDeviceHasBeenRegisteredText="//*[text()=\"There are no Multi-factor Authentication (MFA) devices registered. Click on the add button to continue adding a new device\"]";
    public String mfaDeviceEmailButtonRef="//*[text()=\"Click on the authentication method you want to pair with your account.\"]/following::button[@data-skbuttonvalue=\"EMAIL\"]";
    public String mfaDeviceTextMessageButtonRef="//*[text()=\"Click on the authentication method you want to pair with your account.\"]/following::button[@data-skbuttonvalue=\"SMS\"]";
    public String mfaDeviceVoiceButtonRef="//*[text()=\"Click on the authentication method you want to pair with your account.\"]/following::button[@data-skbuttonvalue=\"VOICE\"]";
    public String mfaDeviceUnauthenticatorAppButtonRef="//*[text()=\"Click on the authentication method you want to pair with your account.\"]/following::button[@data-skbuttonvalue=\"TOTP\"]";
    public String mfaDeviceBiometricButtonRef="//*[text()=\"Click on the authentication method you want to pair with your account.\"]/following::button[@data-skbuttonvalue=\"PLATFORM\"]";

    public String addedEmailMFAdeviceRefXpath="//*[text()=\"Email\"]/following::*[text()=\"Receive an email with a passcode to authenticate\"]";
    public String availableMfaDeviceRef="//*[text()=\"Receive an email with a passcode to authenticate\"]";
    public String deleteMfaDeviceRefLink="//*[text()=\"Delete\"]";

    public String nickNameTextFiledBoxRef="//*[text()=\"Set Device nickname\"]/following::input[1]";


    //DelegateAccess
    public String delegateAccessPageUrl="https://bank.ciam.sandbox.ciamsgo.com/profile/details#dependant";
    public String delegateAccessPageRef="//p[text()=\"Delegate Access\"]";
    public String delegateAccessSectionOpenedRefXpath="//h1[text()=\"Delegate Access\"]/following::*[contains(text(),\"An authorized user can transfer a limited amount of money using your card information\")]";
    public String addDelegateUserSectionAppearedXpath="//*[contains(text(),\"Add Authorized User\")]/following::*[contains(text(),\"Enter the required information below.\")]";
    public String successMessageXpathRef="//*[text()=\"Success\"]";

    @FindBy(xpath = "//*[text()='PERSONAL INFORMATION']//following::input[1]")
    WebElement firstNameTF;

    @FindBy(xpath = "//*[text()='PERSONAL INFORMATION']//following::input[2]")
    WebElement lastNameTF;

    @FindBy(xpath = "//*[text()='PERSONAL INFORMATION']//following::input[3]")
    WebElement emailTF;

    @FindBy(xpath = "//*[text()='PERSONAL INFORMATION']//following::input[4]")
    WebElement mobileTF;

    @FindBy(xpath="//*[text()='LOCATION']//following::input[1]")
    WebElement streetAddressTF;

    @FindBy(xpath="//*[text()='LOCATION']//following::input[2]")
    WebElement countryTF;

    @FindBy(xpath="//*[text()='LOCATION']//following::input[3]")
    WebElement stateTF;

    @FindBy(xpath="//*[text()='LOCATION']//following::input[4]")
    WebElement cityTF;

    @FindBy(xpath="//*[text()='LOCATION']//following::input[5]")
    WebElement zipCodeTF;

    @FindBy(xpath = "//*[text()='HOME']")
    WebElement cursorRestRef;

    @FindBy(xpath = "//*[@data-testid='KeyboardArrowDownIcon']")
    WebElement logoutArrowDownButton;

    @FindBy(xpath = "//*[text()='Logout']")
    WebElement logoutButton;

    @FindBy(xpath = "//button[text()='Update your Information']")
    WebElement updateYourInformationButton;

    @FindBy(xpath = "//*[text()='Account Details']")
    WebElement accountDetailsLink;

    @FindBy(xpath = "//*[text()='Preferences']")
    WebElement preferencesLink;

    @FindBy(xpath = "//*[text()='Privacy & Consent']")
    WebElement privacyAndConsentLink;

    @FindBy(xpath = "//*[text()='My Devices']")
    WebElement myDevicesLink;

    @FindBy(xpath = "//*[text()='Delegate Access']")
    WebElement delegateAccessLink;

    @FindBy(xpath = "//*[@data-testid=\"ArrowForwardIosIcon\"]")
    WebElement creditCardListArrowButton;

    //DashBoard Items
    @FindBy(xpath = "//*[text()='HOME']/following::*[text()='Account']")
    WebElement accountOption;

    @FindBy(xpath = "//*[text()='HOME']/following::*[text()='Profile']")
    WebElement profileOption;

    @FindBy(xpath = "//*[text()='PAYMENTS']/following::*[text()='Utilities']")
    WebElement utilitiesOption;

    @FindBy(xpath = "//*[text()='TRANSFER']/following::*[text()='Transfer']")
    WebElement transferOption;

    @FindBy(xpath = "//*[text()='PAYMENTS']/following::*[text()='Send Money']")
    WebElement sendMoneyOption;

    @FindBy(xpath = "//*[text()='PAYMENTS']/following::*[text()='Pay a Bill']")
    WebElement payABillOption;

    //Profile -> Account Details
    @FindBy(xpath = "//*[contains(text(),'Update Details')]/following::*[text()=\"Are you sure you want to update the details?\"]/following::button[text()='NO']")
    WebElement updateDetailsNoButton;

    @FindBy(xpath = "//*[contains(text(),'Update Details')]/following::*[text()=\"Are you sure you want to update the details?\"]/following::button[text()='YES']")
    WebElement updateDetailsYesButton;


    //Preferences
    @FindBy(xpath = "//*[text()=\" Advertisement & Language Preferences \"]//following::*[text()=\" Ads and Language Preference \"]/following::span[1]")
    WebElement advertisementAndLanguagePreferenceToggleButton;

    @FindBy(xpath = "//*[text()=\" Advertisement & Language Preferences \"]//following::*[text()=\" Third Party Data Sharing \"]/following::span[1]")
    WebElement thirdPartyDataSharingPreferenceToggleButton;

    @FindBy(xpath = "//*[text()=\" Advertisement & Language Preferences \"]//following::*[text()=\" App Tracking Transparency \"]/following::span[1]")
    WebElement appTrackingTransparencyPreferenceToggleButton;

    @FindBy(xpath = "//*[text()=\" Advertisement & Language Preferences \"]//following::*[text()=\" Targeting Cookies \"]/following::span[1]")
    WebElement targetingCookiesPreferenceToggleButton;

    @FindBy(xpath = "//*[text()=\" Communication Preference \"]//following::*[text()=\"Provide your preferences for Email alerts & SMS\"]/following::span[1]")
    WebElement communicationPreferenceToggleButton;

    //MyDevices
    @FindBy(xpath = "//button[text()=\"+ Add New MFA Device\"]")
    WebElement addNewMfaDeviceButton;

    @FindBy(xpath = "//*[text()=\"Click on the authentication method you want to pair with your account.\"]/following::button[@data-skbuttonvalue=\"EMAIL\"]")
    WebElement emailMFAdeviceButton;

    @FindBy(xpath = "//*[@data-testid=\"MoreVertIcon\"]")
    WebElement mfaAddedDeviceHamburgerButton;

    @FindBy(xpath = "//*[text()=\"Delete\"]")
    WebElement deleteAddedEmailMfaDeviceLink;

    @FindBy(xpath = "//*[text()=\"Add a Nickname\"]")
    WebElement addANickNameForEmailMfaDeviceLink;

    @FindBy(xpath = "//*[text()=\"Set Device nickname\"]/following::input[1]")
    WebElement nickNameTF;

    @FindBy(xpath = "//*[text()=\"Set Device nickname\"]/following::button[1]")
    WebElement setNickNameButton;

    @FindBy(xpath = "//*[text()=\"Set Device nickname\"]")
    WebElement nickNameCursorRef;

    //Delegate User

    @FindBy(xpath = "//*[contains(text(),\"Add Authorized User\")]")
    WebElement addAuthorizedUserButton;

    @FindBy(xpath = "//input[@name=\"firstname\"]")
    WebElement firstnameAuthorizedUserTF;

    @FindBy(xpath = "//input[@name=\"lastname\"]")
    WebElement lastnameAuthorizedUserTF;

    @FindBy(xpath = "//input[@name=\"email\"]")
    WebElement emailAuthorizedUserTF;

    @FindBy(xpath = "//input[@name=\"limit\"]")
    WebElement limitAuthorizedUserTF;

    @FindBy(xpath = "//button[@data-skbuttonvalue=\"submit\"]")
    WebElement addDelegateAccessButton;

    @FindBy(xpath = "//*[text()=\"Add Authorized User\"]")
    WebElement addAuthorizeCursorRef;

    @FindBy(xpath = "//*[text()=\" Back to Delegate Access\"]")
    WebElement backToDelegateAccessButton;















     /*
        @FindBy(xpath = "aaaaaaaaa")
        WebElement aaaa;
    */

    public NewBankProfileOptionsPage(){
        PageFactory.initElements(driver, this);
    }//Constructor

    public String getPageUrl(){return driver.getCurrentUrl();}

    public String getEmail(){
        return (String) javascript.executeScript("return arguments[0].value",emailTF);}

    public String getFirstName(){
        return (String) javascript.executeScript("return arguments[0].value",firstNameTF);}

    public String getLastName(){
        return (String) javascript.executeScript("return arguments[0].value",lastNameTF);}

    public String getMobileNumber(){
        return (String) javascript.executeScript("return arguments[0].value",mobileTF);}

    //Location Attributes
    public String getCountryName(){
        return (String) javascript.executeScript("return arguments[0].value",countryTF);}

    public String getStateName(){
        return (String) javascript.executeScript("return arguments[0].value",stateTF);}

    public String getStreetAddress(){
        return (String) javascript.executeScript("return arguments[0].value",streetAddressTF);}

    public String getCityName(){
        return (String) javascript.executeScript("return arguments[0].value",cityTF);}

    public String getZipCode(){
        return (String) javascript.executeScript("return arguments[0].value",zipCodeTF);}


    public void enterFirstname(String firstName){
        String b = Keys.BACK_SPACE.toString();
        String space =Keys.SPACE.toString();
        String tab_space =Keys.TAB.toString();
        actions.click(firstNameTF).build().perform();
        firstNameTF.sendKeys(b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b);
        firstNameTF.sendKeys(firstName+space+b+tab_space);
        actions.click(cursorRestRef).build().perform();
    }

    public void enterLastname(String lastname){
        String b = Keys.BACK_SPACE.toString();
        String space =Keys.SPACE.toString();
        String tab_space =Keys.TAB.toString();
        actions.click(lastNameTF).build().perform();
        lastNameTF.sendKeys(b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b);
        lastNameTF.sendKeys(lastname+space+b+tab_space);
        actions.click(cursorRestRef).build().perform();
    }
    public void enterEmail(String email){
        String b = Keys.BACK_SPACE.toString();
        String space =Keys.SPACE.toString();
        String tab_space =Keys.TAB.toString();
        actions.click(emailTF).build().perform();
        emailTF.sendKeys(b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b);
        emailTF.sendKeys(email+space+b+tab_space);
        actions.click(cursorRestRef).build().perform();
    }

    public void clearEmail(){
        String b = Keys.BACK_SPACE.toString();
        emailTF.sendKeys(b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b);
        actions.click(cursorRestRef).build().perform();
    }
    public void enterMobile(String mobile){
        String b = Keys.BACK_SPACE.toString();
        String space =Keys.SPACE.toString();
        String tab_space =Keys.TAB.toString();
        actions.click(mobileTF).build().perform();
        mobileTF.sendKeys(b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b);
        mobileTF.sendKeys(mobile+space+b+tab_space);
        actions.click(cursorRestRef).build().perform();
    }

    public void enterStreetAddress(String address){
        String b = Keys.BACK_SPACE.toString();
        String space =Keys.SPACE.toString();
        String tab_space =Keys.TAB.toString();
        actions.click(streetAddressTF).build().perform();
        streetAddressTF.sendKeys(b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b);
        streetAddressTF.sendKeys(address+space+b+tab_space);
        actions.click(cursorRestRef).build().perform();
    }

    public void enterCityDetails(String city){
        String b = Keys.BACK_SPACE.toString();
        String space =Keys.SPACE.toString();
        String tab_space =Keys.TAB.toString();
        actions.click(cityTF).build().perform();
        cityTF.sendKeys(b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b);
        cityTF.sendKeys(city+space+b+tab_space);
        actions.click(cursorRestRef).build().perform();
    }

    public void enterZipCodeDetails(String zipcode){
        String b = Keys.BACK_SPACE.toString();
        String space =Keys.SPACE.toString();
        String tab_space =Keys.TAB.toString();
        actions.click(zipCodeTF).build().perform();
        zipCodeTF.sendKeys(b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b);
        zipCodeTF.sendKeys(zipcode+space+b+tab_space);
        actions.click(cursorRestRef).build().perform();
    }

    public void clickOnCountryDropDown(){
        actions.click(countryTF).build().perform();
//        javascript.executeScript("arguments[0].click();",countryTF);
    }

    public void clickOnStateDropDown(){
        actions.click(stateTF).build().perform();
//        javascript.executeScript("arguments[0].click();",stateTF);
    }

    public void clickOnCreditCardViewRightArrowButton(){
        actions.click(creditCardListArrowButton).build().perform();
        //javascript.executeScript("arguments[0].click();",creditCardListArrowButton);
    }
    public WebElement getDropDownListWebElement(String listItem){
        return driver.findElement(By.xpath("//li[text()='"+listItem+"']"));
//        return "//li[text()='"+listItem+"']";
    }

    public String getDropDownListXpath(String listItem){
        return "//li[text()='"+listItem+"']";
    }

    public void clickOnDropDownListItem(String listItem){
        javascript.executeScript("arguments[0].click();",getDropDownListWebElement(listItem));
//        actions.click(getDropDownListWebElement(listItem)).build().perform();
    }

    public String getLoggedInUsernameXpath(String username){
        String startingCharacter=username.substring(0,1).toUpperCase();
        String fullName =username.substring(1).toLowerCase();
        return "//*[text()='"+startingCharacter+fullName+"']";
    }



    public void clickOnUpdateYourInformationButton(){javascript.executeScript("arguments[0].click();",updateYourInformationButton);}

    public void clickOnAccountDetailsLink(){actions.click(accountDetailsLink).build().perform();}

    public void clickOnPreferencesLink(){actions.click(preferencesLink).build().perform();}

    public void clickOnPrivacyAndConsentLink(){actions.click(privacyAndConsentLink).build().perform();}

    public void clickOnMyDevicesLink(){actions.click(myDevicesLink).build().perform();}

    public void clickOnDelegateAccessLink(){actions.click(delegateAccessLink).build().perform();}

    public void clickOnLogoutArrowButton(){
        actions.click(logoutArrowDownButton).build().perform();
        //javascript.executeScript("arguments[0].click();",logoutArrowDownButton);
    }

    public void clickOnLogoutButton(){actions.click(logoutButton).build().perform();}

    //Dashboard Items
    public void clickOnSendMoneyOption() {
        actions.click(sendMoneyOption).build().perform();
        //javascript.executeScript("arguments[0].click();",sendMoneyOption);
    }

    public void clickOnPayABillOption() {
        actions.click(payABillOption).build().perform();
        //javascript.executeScript("arguments[0].click();",payABillOption);
    }

    public void clickOnAccountOptions() {
        actions.click(accountOption).build().perform();
        //javascript.executeScript("arguments[0].click();",accountOption);
    }
    public void clickOnProfileOptions() {
        actions.click(profileOption).build().perform();
        //javascript.executeScript("arguments[0].click();",profileOption);
    }
    public void clickOnUtilitiesOptions() {
        actions.click(utilitiesOption).build().perform();
        //javascript.executeScript("arguments[0].click();",utilitiesOption);
    }
    public void clickOnTransferOptions() {
        actions.click(transferOption).build().perform();
        //javascript.executeScript("arguments[0].click();",transferOption);
    }


    // Profile -> Account Details
    public void clickOnUpdateDetailsYesButton() {
        actions.click(updateDetailsYesButton).build().perform();
        //javascript.executeScript("arguments[0].click();",updateDetailsYesButton);
    }
    public void clickOnUpdateDetailsNoButton() {
        actions.click(updateDetailsNoButton).build().perform();
        //javascript.executeScript("arguments[0].click();",updateDetailsNoButton);
    }

    //MyDevices
    public void clickOnAddANewMfaDevice() {
        actions.click(addNewMfaDeviceButton).build().perform();
        //javascript.executeScript("arguments[0].click();",addNewMfaDeviceButton);
    }

    public void clickOnEmailMfaDeviceButton() {
        actions.click(emailMFAdeviceButton).build().perform();
        //javascript.executeScript("arguments[0].click();",emailMFAdeviceButton);
    }

    public void clickOnEmailMfaDeviceHamburgerOption() {
        actions.click(mfaAddedDeviceHamburgerButton).build().perform();
        //javascript.executeScript("arguments[0].click();",mfaAddedDeviceHamburgerButton);
    }
    public void clickOnDeleteEmailMFADevice() {
        actions.click(deleteAddedEmailMfaDeviceLink).build().perform();
        //javascript.executeScript("arguments[0].click();",deleteAddedEmailMfaDeviceLink);
    }
    public void clickOnAddNickNameForAddedMFAdevice() {
        actions.click(addANickNameForEmailMfaDeviceLink).build().perform();
        //javascript.executeScript("arguments[0].click();",addANickNameForEmailMfaDeviceLink);
    }

    public void enterNickName(String nickname){
        String b = Keys.BACK_SPACE.toString();
        String space =Keys.SPACE.toString();
        String tab_space =Keys.TAB.toString();
        actions.click(nickNameTF).build().perform();
        nickNameTF.sendKeys(b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b);
        nickNameTF.sendKeys(nickname+tab_space);
        actions.click(nickNameCursorRef).build().perform();
    }

    public void clickOnSetNickNameButton() {
        actions.click(setNickNameButton).build().perform();
        //javascript.executeScript("arguments[0].click();",setNickNameButton);
    }

    public String waitForNickNameToBeUpdatedXpath(String nickname){
        return "//p[text()='"+nickname+"']";
    }

    //Delegate User
    public void clickOnAddAuthorizedUserButton() {
        actions.click(addAuthorizedUserButton).build().perform();
        //javascript.executeScript("arguments[0].click();",addAuthorizedUserButton);
    }

//Implement
    public void enterFirstnameAuthorizedUser(String firstname){
        String b = Keys.BACK_SPACE.toString();
        String space =Keys.SPACE.toString();
        String tab_space =Keys.TAB.toString();
        actions.click(firstnameAuthorizedUserTF).build().perform();
        firstnameAuthorizedUserTF.sendKeys(b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b);
        firstnameAuthorizedUserTF.sendKeys(firstname+tab_space);
        actions.click(addAuthorizeCursorRef).build().perform();
    }
    public void enterLastnameAuthorizedUser(String lastname){
        String b = Keys.BACK_SPACE.toString();
        String space =Keys.SPACE.toString();
        String tab_space =Keys.TAB.toString();
        actions.click(lastnameAuthorizedUserTF).build().perform();
        lastnameAuthorizedUserTF.sendKeys(b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b);
        lastnameAuthorizedUserTF.sendKeys(lastname+tab_space);
        actions.click(addAuthorizeCursorRef).build().perform();
    }
    public void enterEmailAuthorizedUser(String email){
        String b = Keys.BACK_SPACE.toString();
        String space =Keys.SPACE.toString();
        String tab_space =Keys.TAB.toString();
        actions.click(emailAuthorizedUserTF).build().perform();
        emailAuthorizedUserTF.sendKeys(b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b);
        emailAuthorizedUserTF.sendKeys(email+tab_space);
        actions.click(addAuthorizeCursorRef).build().perform();
    }
    public void enterTransferLimitAuthorizedUser(String transferLimit){
        String b = Keys.BACK_SPACE.toString();
        String space =Keys.SPACE.toString();
        String tab_space =Keys.TAB.toString();
        actions.click(limitAuthorizedUserTF).build().perform();
        limitAuthorizedUserTF.sendKeys(b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b);
        limitAuthorizedUserTF.sendKeys(transferLimit+tab_space);
        actions.click(addAuthorizeCursorRef).build().perform();
    }
    public void clickOnAddDelegateUser() {
        actions.click(addDelegateAccessButton).build().perform();
        //javascript.executeScript("arguments[0].click();",addAuthorizedUserButton);
    }

    public String getAuthorizedUserFirstName(String firstname){
        return "//*[text()=\"Success\"]/following::*[text()=\"Your authorized user \"]/following::b[contains(text(),\""+firstname+"\")]";
    }
    public String getAuthorizedUserEmail(String email){
        return "//*[text()=\"Success\"]//following::*[contains(text(),\"An email is sent to\")]//following::b[contains(text(),\""+email+"\")]";
    }

    public void clickOnBackToDelegateAccessButton() {
        actions.click(backToDelegateAccessButton).build().perform();
        //javascript.executeScript("arguments[0].click();",backToDelegateAccessButton);
    }

    public String waitForTheDelegateUserAddedInfo(String firstname, String lastname, String email, String transferLimit){
        return "//*[contains(text(),\""+firstname+" "+lastname+"\")]//following::*[contains(text(),\""+email+"\")]//following::*[contains(text(),\""+transferLimit+"\")]";
    }










}
