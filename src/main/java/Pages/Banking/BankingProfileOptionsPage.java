package Pages.Banking;

import Utilities.BrowserInstance;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BankingProfileOptionsPage extends BrowserInstance {
    //START:  ---------Title Verification-----------
    public String bankingDashboardPageUrl="https://services.ciamsgo.com/bank/profile/dashboard";
    public String accountDetailsRefXpath="//p[text()='Account Details']";
    public String communicationsPrefencesRefXpath="//p[text()='Communication Preferences']";
    public String privacyAndConsentRefXpath="//p[text()='Privacy & Consent']";
    public String myDevicesRefXpath="//p[text()='Trusted Devices']";
    public String securitySettingsRefXpath="//p[text()='Security']";
    public String updateAddressConfirmationAlertRefXpath="//*[text()=\"Changes made successfully\"]//following::*[text()='User Changes have been made. Click Ok to Continue']";

    //Preferences
    public String preferencesButtonXpath="//button[text()='Preferences']";
    public String privacyAndConsentButtonXpath="//button[text()='Privacy & Consent']";
    public String myDevicesButtonXpath="//button[text()='My Devices']";
    public String pushNotificationDeviceStaticTextWithoutRegistrationXpath="//p[text()='Push Notification Device']//following::*[text()='You do not have a registered Mobile App Notification device']//following::button[text()='Setup Push Notification']";
    public String authenticationDeviceStaticTextWithoutRegistrationXpath="//p[text()='Authenticator App Device']//following::*[text()='You do not have a registered Authenticator App Device']//following::button[text()='Setup Authenticator App']";


    @FindBy(xpath = "//p[text()='Dashboard']")
    WebElement dashboardLink;

    @FindBy(xpath = "//p[text()='Profile']")
    WebElement profileLink;

    @FindBy(xpath = "//p[text()='Payments']")
    WebElement paymentsLink;

    @FindBy(xpath = "//p[text()='Transfers']")
    WebElement transfersLink;

    @FindBy(xpath = "//p[text()='Brokerage Account']")
    WebElement brokerageAccountLink;

    @FindBy(xpath = "//p[text()='Passwordless Devices'] Devices")
    WebElement passwordlessDevicesLink;

    @FindBy(xpath = "//button[text()='Logout']")
    WebElement logoutButton;

    @FindBy(xpath = "//*[@data-testid='AccountCircleIcon']//parent::button")
    WebElement profileIconLink;

    //TabList of Profile Options

    @FindBy(xpath = "//*[@role='tablist']/*[text()='Account Details']")
    WebElement accountDetailsProfileOption_1;
    @FindBy(xpath = "//*[@role='tablist']/*[text()='Preferences']")
    WebElement preferencesProfileOption_2;
    @FindBy(xpath = "//*[@role='tablist']/*[text()='Privacy & Consent']")
    WebElement privacyAndConsentProfileOption_3;
    @FindBy(xpath = "//*[@role='tablist']/*[text()='My Devices']")
    WebElement myDevicesProfileOption_4;
    @FindBy(xpath = "//*[@role='tablist']/following::*[@data-testid='KeyboardArrowRightIcon']")
    WebElement rightArrowButtonProfileOptions;
    @FindBy(xpath = "//*[@data-testid='KeyboardArrowLeftIcon']")
    WebElement leftArrowButtonProfileOptions;

    @FindBy(xpath = "//*[@role='tablist']/*[text()='Security Settings']")
    WebElement securitySettingsProfileOption_5;

    //AccountDetails
        //>>Personal Info
            @FindBy(xpath = "//*[text()='Personal Information']//following::input[1]")
            WebElement firstNameTF;
            @FindBy(xpath = "//*[text()='Personal Information']//following::input[2]")
            WebElement lastNameTF;
            @FindBy(xpath = "//*[text()='Personal Information']//following::input[3]")
            WebElement emailTF;
            @FindBy(xpath = "//*[text()='Personal Information']//following::input[4]")
            WebElement mobileTF;
            @FindBy(xpath = "//*[text()='Personal Information']//following::input[5]")
            WebElement passwordTF;
        //>> Location Info
            @FindBy(xpath = "//*[text()='Location']//following::input[1]")
            WebElement addressTF;
            @FindBy(xpath = "//*[text()='Location']//following::input[2]")
            WebElement addressOptionalTF;
            @FindBy(xpath = "//*[text()='Location']//following::input[3]")
            WebElement cityTF;
            @FindBy(xpath = "//*[text()='Location']//following::input[4]")
            WebElement stateTF;
            @FindBy(xpath = "//*[text()='Location']//following::input[5]")
            WebElement zipCodeTF;
            @FindBy(xpath = "//*[text()='Location']//following::input[6]")
            WebElement countryTF;

    @FindBy(xpath = "//button[text()='Save Changes']")
    WebElement saveChangesAccountDetailsButton;
    @FindBy(xpath = "(//button[text()='Cancel'])[1]")
    WebElement cancelAccountDetailsButton;

    @FindBy(xpath = "//p[text()='Account Details']")
    WebElement mouseClickCursorRefOnAccountDetailsPara;


    @FindBy(xpath = "//*[text()=\"Changes made successfully\"]//following::*[text()='User Changes have been made. Click Ok to Continue']//following::button[text()='Ok']")
    WebElement updatedConfirmationAlertOkButton;



    //Preferences
    @FindBy(xpath = "//button[text()='Preferences']")
    WebElement preferencesTabButton;

    //Privacy&Consent
    //My Devices
    @FindBy(xpath = "//p[text()='Push Notification Device']//following::*[text()='You do not have a registered Mobile App Notification device']//following::button[text()='Setup Push Notification']")
    WebElement pushNotificationWithoutRegistrationButton;
    @FindBy(xpath = "//p[text()='Authenticator App Device']//following::*[text()='You do not have a registered Authenticator App Device']//following::button[text()='Setup Authenticator App']")
    WebElement authenticatorAppWithoutRegistrationButton;
    //SecuritySettings





       //Constructor
       public BankingProfileOptionsPage(){
        PageFactory.initElements(driver, this);
    }

    public void verifyLoggedInUserName(String firstname, String lastname){
        String loggedInUserXpath="//h4[text()='"+firstname+"' and text()='"+lastname+"']";
        waitUtil.elementToBeLocated(loggedInUserXpath,30);
    }
    public void verifyLoggedInUserName(String firstname){
        String loggedInUserXpath="//p[text()='Hi, ' and text()='"+firstname+"']";
        waitUtil.elementToBeLocated(loggedInUserXpath,30);
    }

    public String getDashboardPageUrl(){return driver.getCurrentUrl();}

    //DashBoardLinks
    public void clickOnDashboardLink(){dashboardLink.click();}
    public void clickOnProfileLink(){profileLink.click();}
    public void clickOnPaymentsLink(){paymentsLink.click();}
    public void clickOnTransfersLink(){transfersLink.click();}
    public void clickOnBrokerageAccountLink(){brokerageAccountLink.click();}
    public void clickOnPasswordlessDevicesLink(){passwordlessDevicesLink.click();}

    //Header Items
    public void clickOnLogoutButton(){logoutButton.click();}
    public void clickOnProfileIconLink(){profileIconLink.click();}

    //AccountDetails Action Methods
    public String getFirstName(){
           return (String) javascript.executeScript("return arguments[0].value",firstNameTF);}
    public String getLastName(){
        return (String) javascript.executeScript("return arguments[0].value",lastNameTF);}
    public String getEmail(){
        return (String) javascript.executeScript("return arguments[0].value",emailTF);}
    public String getMobile(){
        return (String) javascript.executeScript("return arguments[0].value",mobileTF);}
    public String getAddress(){
        return (String) javascript.executeScript("return arguments[0].value",addressTF);}
    public String getAddressOptional(){
        return (String) javascript.executeScript("return arguments[0].value",addressOptionalTF);}
    public String getCity(){
        return (String) javascript.executeScript("return arguments[0].value",cityTF);}
    public String getState(){
        return (String) javascript.executeScript("return arguments[0].value",stateTF);}
    public String getZipCode(){
        return (String) javascript.executeScript("return arguments[0].value",zipCodeTF);}
    public String getCountry(){
        return (String) javascript.executeScript("return arguments[0].value",countryTF);}


    public void enterNewPassword(String newPassword) throws InterruptedException {
        String b = Keys.BACK_SPACE.toString();
        passwordTF.sendKeys(b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b);
        actions.click(mouseClickCursorRefOnAccountDetailsPara).build().perform();
        passwordTF.sendKeys(newPassword);
       }
    public void updatePhoneNumber(String mobileNumber) throws InterruptedException {
        String b = Keys.BACK_SPACE.toString();
        mobileTF.sendKeys(b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b);
        actions.click(mouseClickCursorRefOnAccountDetailsPara).build().perform();
        mobileTF.sendKeys(mobileNumber);
       }
    public void updateAddressDetails(String address) throws InterruptedException {

        String b = Keys.BACK_SPACE.toString();
        addressTF.sendKeys(b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b);
        actions.click(mouseClickCursorRefOnAccountDetailsPara).build().perform();
        addressTF.sendKeys( address);
           }
    public void updateOptionalAddressDetails(String optAddress) throws InterruptedException {
        String b = Keys.BACK_SPACE.toString();
        addressOptionalTF.sendKeys(b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b);
        actions.click(mouseClickCursorRefOnAccountDetailsPara).build().perform();
        addressOptionalTF.sendKeys(optAddress);
       }
    public void updateCityDetails(String city) throws InterruptedException {
        String b = Keys.BACK_SPACE.toString();
        cityTF.sendKeys(b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b);
        actions.click(mouseClickCursorRefOnAccountDetailsPara).build().perform();
        cityTF.sendKeys(city);}
    public void updateStateDetails(String state) throws InterruptedException {
        String b = Keys.BACK_SPACE.toString();
        stateTF.sendKeys(b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b);
        actions.click(mouseClickCursorRefOnAccountDetailsPara).build().perform();
        stateTF.sendKeys(state);}
    public void updateZipCodeDetails(String zipCode) throws InterruptedException {
        String b = Keys.BACK_SPACE.toString();
        zipCodeTF.sendKeys(b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b);
        actions.click(mouseClickCursorRefOnAccountDetailsPara).build().perform();
        zipCodeTF.sendKeys(zipCode);}
    public void updateCountryDetails(String country) throws InterruptedException {
        String b = Keys.BACK_SPACE.toString();
        countryTF.sendKeys(b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b);
        actions.click(mouseClickCursorRefOnAccountDetailsPara).build().perform();
        countryTF.sendKeys(country);}
    public void clickOnAccountDetailsTab(){accountDetailsProfileOption_1.click();}
    public void clickOnPreferencesTab(){preferencesProfileOption_2.click();}
    public void clickOnPrivacyAndConsentTab(){privacyAndConsentProfileOption_3.click();}
    public void clickOnMyDevicesTab(){myDevicesProfileOption_4.click();}
    public void clickOnSecuritySettingsTab(){securitySettingsProfileOption_5.click();}
    public void clickOnLeftArrowTab(){leftArrowButtonProfileOptions.click();}
    public void clickOnRightArrowTab(){rightArrowButtonProfileOptions.click();}

    public void clickOnSaveChangesButton(){saveChangesAccountDetailsButton.click();}

    public void clickOnCancelSaveChangesButton(){cancelAccountDetailsButton.click();}
    public void clickOnConfirmationAlertOkButton(){updatedConfirmationAlertOkButton.click();}

    //My Devices
    public void clickOnPushNotificationRegistrationButton(){pushNotificationWithoutRegistrationButton.click();}
    public void clickOnAuthenticationAppRegistrationButton(){authenticatorAppWithoutRegistrationButton.click();}



}
