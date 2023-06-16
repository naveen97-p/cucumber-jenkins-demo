package Pages.Retail;

import Utilities.BrowserInstance;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class RetailProfileOptionsPage extends BrowserInstance {

    public String passwordSettingXpath ="//*[text()='Password Settings']";
    public String passwordUpdateStatusXpath ="//*[text()='Password changed Successfully!']";
    public String changePasswordRefXpath="//*[text()='Change Your Password']";
    public String communicationPreferencesOneTrustXpath="//*[text()=' Your Preferences ']";
    public String emailCommunicationPrefXpath="//h2[text()=' New Section ']//following::section[1]";
    public String phoneCommunicationPrefXpath="//h2[text()=' New Section ']//following::section[3]";
    public String communicationChangesUpdatedNotificationBoxXpath="//*[contains(text(),\"Thank you! Your preferences have been submitted. Please allow a few minutes for these to be updated.\")]";
    public String emailCommunicationPrefToggleButtonXpath="(//span[@class='ot-toggle-slider'])[1]";
    public String mobileCommunicationPrefToggleButtonXpath="(//span[@class='ot-toggle-slider'])[2]";

    public String doNotSellMyDataXpath="(//*[text()='For more detailed information about how your information is being used you may submit a data request form with the link below:']/following::*[text()='Do Not Sell My Data'])[1]";

    //Start: Profile Option->Account Details
    public String personalDetailsRefXpath="//*[text()='Personal Information']";
    public String detailsUpdatedRefXpath="//*[text()='Profile updated.']";
    public String detialsUpdatedRefNewXpath="//*[text()='Profile Updated']";
    public String premiumCustomerTagOnProfileOptionsXpath="//*[text()='(Premium Customer)']";
    public String cursorPlacementCreditCardRef="//*[text()='Apply for the Climb Credit Card!']//following::*[text()='Please enter your information below to begin the application process']";
    public String ssnUITextXpath="//*[text()='Apply for the Climb Credit Card!']//following::*[text()='Please enter your information below to begin the application process']";
    public String ssnTextFieldAvailabilityXpath="//input[@name='ssn']";
    public String climbCreditCardXpath="//*[text()='Climb Credit Card']";
    public String virtualCreditCardXpath="//*[text()='Climb Credit Card']//following::*[text()='Your credit card at a glance']";

    //START-----Updated Xpaths on 20-10-2022 at 5:58PM for MFA in change of Address
    public String verifyIdentityUITextDevXpathRef="//*[text()='Verify Identity']//following::*[text()='If you update your phone number you will have to ' and text()=' again.']";
    public String otpEmailDetailsXpathDev="//*[text()='Verify Identity']//following::input[1]";
    public String enterCodeInputBoxDevXpath="//*[text()='Verify Identity']//following::*[text()='If you update your phone number you will have to ' and text()=' again.']//following::input[1]";
    public String verificationSuccessfulXpathRef="//*[text()='Verification Successfull']";
    public String invalidOTPVerificationXpathRef="//*[text()='Invalid Passcode/Answer']";
    //End: Profile Options->Acc Details

    @FindBy(xpath = "//*[text()='Verify Identity']//following::input[1]")
    WebElement otpRegisteredEmailInfoDisabledField;

    @FindBy(xpath = "//*[text()='Verify Identity']//following::button[1]")
    WebElement nextButton;

    @FindBy(xpath = "//*[text()='Verify Identity']//following::*[text()='Enter Code ']//following::input[1]")
    WebElement enterOTPInputField;

    @FindBy(xpath = "//*[text()='Verify Identity']//following::button[1]")
    WebElement verifyButton;

    @FindBy(xpath = "//*[text()='Personal Information']//following::input[3]")
    WebElement getRegisteredEmailInNonEditableFormInpField;



   //END------Updated Xpaths on 20-10-2022 at 5:58PM for MFA in change of Address



    @FindBy(xpath = "//*[text()='Password Settings']")
    WebElement passwordSettingsButton;

    @FindBy(xpath = "//*[text()='Please enter your old password:']/following::input[1]")
    WebElement oldPasswordTextField;

    @FindBy(xpath = "//*[text()='Enter and confirm your new password:']/following::input[1]")
    WebElement newPasswordTextField;

    @FindBy(xpath = "//*[text()='Enter and confirm your new password:']/following::input[2]")
    WebElement reEnterPasswordTextField;

    @FindBy(xpath = "//button[text()='Submit']")
    WebElement submitButton;

    @FindBy(xpath = "//*[text()='Password changed Successfully!']")
    WebElement passwordUpdateMessageInfo;

    @FindBy(xpath = "//p[text()='Privacy & Consent']")
    WebElement privacyAndConsentButton;

    @FindBy(xpath = "//*[text()='Communication Preferences']")
    WebElement communicationPreferencesButton;

    @FindBy(xpath = "(//*[text()='For more detailed information about how your information is being used you may submit a data request form with the link below:']/following::*[text()='Do Not Sell My Data'])[1]")
    WebElement doNotSellMyDataButton;


    //Start: Profile Option->Account Details
    @FindBy(xpath = "//*[text()='Personal Information']//following::input[1]")
    WebElement firstNameTextField;

    @FindBy(xpath = "//*[text()='Personal Information']//following::input[2]")
    WebElement lastNameTextField;

    @FindBy(xpath = "//*[text()='Personal Information']//following::input[4]")
    WebElement mobileTextField;

    @FindBy(xpath = "//*[text()='Location']//following::input[1]")
    WebElement addressTextField;

    @FindBy(xpath = "//*[text()='Location']//following::input[2]")
    WebElement countryTextField;

    @FindBy(xpath = "//*[text()='Location']//following::input[3]")
    WebElement stateTextField;

    @FindBy(xpath = "//*[text()='Location']//following::input[4]")
    WebElement cityTextField;

    @FindBy(xpath = "//*[text()='Location']//following::input[5]")
    WebElement zipCodeTextField;

    @FindBy(xpath = "//*[text()='Birthday']//following::input[1]")
    WebElement dobDateTextField;

    @FindBy(xpath = "//*[text()='Birthday']//following::input[2]")
    WebElement dobMonthTextField;

    @FindBy(xpath = "//button[text()='Apply Updates']")
    WebElement applyUpdatesButton;


    @FindBy(xpath = "//p[text()='Personal Information']")
    WebElement cursorPlacementRef;

    @FindBy(xpath = "//*[text()='Climb Credit Card']")
    WebElement climbCreditCardButton;

    @FindBy(xpath = "//input[@name='ssn']")
    WebElement ssnInputField;

    @FindBy(xpath = "//button[@id='submit']")
    WebElement ssnSubmitButton;
    @FindBy(xpath = "//*[text()='Apply for the Climb Credit Card!']//following::*[text()='Please enter your information below to begin the application process']")
    WebElement cursorPlacementCreditCard;
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @FindBy(xpath = "//h2[text()=' New Section ']//following::section[1]")
    public WebElement emailPreferencesSection;
    @FindBy(xpath = "//h2[text()=' New Section ']//following::section[3]")
    public WebElement phonePreferencesSection;

    @FindBy(xpath = "//span[text()=' Marketing Emails  ']")
    public WebElement marketingEmailsCheckBox;
    @FindBy(xpath = "//span[text()=' News Letters ']")
    public WebElement newsLettersCheckBox;
    @FindBy(xpath = "//span[text()=' Promotion codes  ']")
    public WebElement promotionCodesCheckBox;
    @FindBy(xpath = "//span[text()=' Company Updates ']")
    public WebElement companyUpdatesCheckBox;
    @FindBy(xpath = "//span[text()=' New Product launch ']")
    public WebElement newProductLaunchCheckBox;




    @FindBy(xpath = "//span[text()=' Marketing Messages  ']")
    public WebElement marketingMessagesCheckBox;
    @FindBy(xpath = "//span[text()=' Company Newsletter  ']")
    public WebElement companyNewsLettersCheckBox;
    @FindBy(xpath = "//span[text()=' Promotion Codes  ']")
    public WebElement promotionCodesForMobileCheckBox;
    @FindBy(xpath = "//span[text()=' Other Company Notifications  ']")
    public WebElement otherCompanyNotificationsCheckBox;


    @FindBy(xpath = "//button[text()=' Change Preferences ']")
    public WebElement changePreferencesButton;

    @FindBy(xpath = "(//span[@class='ot-toggle-slider'])[1]")
    public WebElement emailCommunicationToggleButton;

    @FindBy(xpath = "(//span[@class='ot-toggle-slider'])[2]")
    WebElement mobileCommunicationToggleButton;

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //End: Profile Option->Account Details

    public RetailProfileOptionsPage(){
        PageFactory.initElements(driver, this);
    }

    public void clickOnPrivacyAndConsentButton(){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();",privacyAndConsentButton);
    }
    public void clickOnDoNotSellMyDataButton(){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();",doNotSellMyDataButton);
    }

    public void clickOnCommunicationPreferencesButton(){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();",communicationPreferencesButton);
    }

    public void clickOnPasswordSettingButton(){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();",passwordSettingsButton );
        //passwordSettingsButton.click();
    }
    public void enterYourOldPassword(String oldPassword){
        oldPasswordTextField.sendKeys(oldPassword);
    }
    public void enterYourNewPassword(String newPassword){
        newPasswordTextField.sendKeys(newPassword);
    }
    public void enterReEnterYourNewPassword(String newPassword){
        reEnterPasswordTextField.sendKeys(newPassword);
    }
    public void clickOnSubmitButton(){
        submitButton.click();
    }
    public String getPasswordUpdateMsg(){
        String getMsg = passwordUpdateMessageInfo.getText();
        return getMsg;}

    //Start: Profile Option->Account Details
public void enterFirstName(String firstName) throws InterruptedException {
    String b = Keys.BACK_SPACE.toString();
    String space =Keys.SPACE.toString();
    String tab_space =Keys.TAB.toString();
    firstNameTextField.sendKeys(b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b);
    firstNameTextField.sendKeys(firstName+space+b+tab_space);
    actions.click(cursorPlacementRef).build().perform();


//
//    actions.click(firstNameTextField).build().perform();
////        firstNameTextField.click();
//    //javascript.executeScript("arguments[0].value='"+firstName+"';", firstNameTextField);
//       firstNameTextField.clear();firstNameTextField.sendKeys(firstName);
//     firstNameTextField.sendKeys(Keys.SPACE);
//    firstNameTextField.sendKeys(Keys.TAB);


    }
    public void enterLastName(String lastName) throws InterruptedException {
        String b = Keys.BACK_SPACE.toString();
        String space =Keys.SPACE.toString();
        String tab_space =Keys.TAB.toString();
       lastNameTextField.sendKeys(b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b);
        lastNameTextField.sendKeys(lastName+space+b+tab_space);
        actions.click(cursorPlacementRef).build().perform();
//
//        actions.click(lastNameTextField).build().perform();
//        Thread.sleep(1000);lastNameTextField.clear();lastNameTextField.sendKeys(lastName);
//        firstNameTextField.sendKeys(Keys.SPACE);
//        firstNameTextField.sendKeys(Keys.TAB);
    }
    public void enterMobileNumber(String mobileNum) throws InterruptedException {mobileTextField.click();
        String b = Keys.BACK_SPACE.toString();
        String space =Keys.SPACE.toString();
        String tab_space =Keys.TAB.toString();
        mobileTextField.sendKeys(b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b);
        mobileTextField.sendKeys(mobileNum+space+b+tab_space);
        actions.click(cursorPlacementRef).build().perform();


//        Thread.sleep(1000);mobileTextField.clear();mobileTextField.sendKeys(mobileNum);
    }

    public void enterPhoneNumber(String mobileNum) throws InterruptedException {mobileTextField.click();
        String b = Keys.BACK_SPACE.toString();
        String space =Keys.SPACE.toString();
        String tab_space =Keys.TAB.toString();
        mobileTextField.sendKeys(b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b);
        mobileTextField.sendKeys(mobileNum+tab_space);
        actions.click(cursorPlacementRef).build().perform();


//        Thread.sleep(1000);mobileTextField.clear();mobileTextField.sendKeys(mobileNum);
    }

    public void enterAddress(String address) throws InterruptedException {addressTextField.click();
        Thread.sleep(1000);
        addressTextField.clear();addressTextField.sendKeys(address);}
    public void enterCountryName(String country) throws InterruptedException {
        countryTextField.click();
        countryTextField.clear();
        countryTextField.sendKeys(country);

        waitUtil.elementToBeLocated("//*[text()='Location']//following::*[text()='United States']");
WebElement autoCompleteDropDownItem=driver.findElement(By.xpath("//*[text()='Location']//following::*[text()='United States']"));
actions.click(autoCompleteDropDownItem).build().perform();


//        List<WebElement> optionsToSelect = driver.findElements(By.xpath("//div[@class='sbqs_c']"));
//
//        for(WebElement option : optionsToSelect){
//            System.out.println(option);
//            if(option.getText().equals(country)) {
//                option.click();
//                break;
//            }
//        }
       // actions.click(partnerAdminLoginButton).build().perform();
    }
    public void enterStateName(String state){stateTextField.click();stateTextField.clear();stateTextField.sendKeys(state);}
    public void enterCityName(String city){cityTextField.click();cityTextField.clear();cityTextField.sendKeys(city);}
    public void enterZipCode(String zipCode){zipCodeTextField.click();zipCodeTextField.clear();zipCodeTextField.sendKeys(zipCode);}

    public void enterDobMonth(String dobMonth){dobMonthTextField.click();dobMonthTextField.clear();dobMonthTextField.sendKeys(dobMonth);}
    public void enterDobDay(String dobDay){dobDateTextField.click();dobDateTextField.clear();dobDateTextField.sendKeys(dobDay);}

    public void clickOnApplyChangesButton(){applyUpdatesButton.click();}
    //End: Profile Option->Account Details
    public void clickOnClimbCreditButton(){
        actions.click(climbCreditCardButton).build().perform();
       // climbCreditCardButton.click();
    }
    public void enterSSNDetails(String SSN_ID){
        String b = Keys.BACK_SPACE.toString();
        String space =Keys.SPACE.toString();
        String tab_space =Keys.TAB.toString();
        ssnInputField.sendKeys(b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b);
        ssnInputField.sendKeys(SSN_ID+space+b+tab_space);
        actions.click(cursorPlacementCreditCard).build().perform();
        }
    public void clickOnSSNSubmitButton(){
        ssnSubmitButton.click();}

    public String getRegisteredEmailInNonEditableForm(){
        return (String) javascript.executeScript("return arguments[0].value",getRegisteredEmailInNonEditableFormInpField);}

    public String getRegisteredEmailFromOTPConfirmation(){
        return (String) javascript.executeScript("return arguments[0].value",otpRegisteredEmailInfoDisabledField);}

    public void clickOnNextButton(){nextButton.click();}
    public void clickOnVerifyButton(){verifyButton.click();}

    public void enterOTPToChangeAddressOrPhoneNumber(String otp){
        enterOTPInputField.sendKeys(otp);
    }


    public void clickOnEmailCommunicationPrefButton() {
        actions.click(emailPreferencesSection).build().perform();
    }
    public void clickOnMobileCommunicationPrefButton() {
        actions.click(phonePreferencesSection).build().perform();
    }
    public void clickOnEmailMarketingEmails() {
        javascript.executeScript("arguments[0].click();", marketingEmailsCheckBox);
        //actions.click(marketingEmailsCheckBox).build().perform();
    }
    public void clickOnEmailNewsLetters() {
        javascript.executeScript("arguments[0].click();", newsLettersCheckBox);
//        actions.click(newsLettersCheckBox).build().perform();
    }
    public void clickOnEmailPromotionCodes() {
        javascript.executeScript("arguments[0].click();", promotionCodesCheckBox);
//        actions.click(promotionCodesCheckBox).build().perform();
    }
    public void clickOnEmailCompanyUpdates() {
        javascript.executeScript("arguments[0].click();", companyUpdatesCheckBox);
//        actions.click(companyUpdatesCheckBox).build().perform();
    }
    public void clickOnEmailNewProductLaunch() {
        javascript.executeScript("arguments[0].click();", newProductLaunchCheckBox);
//        actions.click(newProductLaunchCheckBox).build().perform();
    }
    public void clickOnMobileMarketingMessages() {
        //actions.click(marketingMessagesCheckBox).build().perform();
       // marketingMessagesCheckBox.click();
        javascript.executeScript("arguments[0].click();", marketingMessagesCheckBox);
    }
    public void clickOnMobileCompanyNewsLetters() {
        //actions.click(companyNewsLettersCheckBox).build().perform();
        javascript.executeScript("arguments[0].click();", companyNewsLettersCheckBox);
       // companyNewsLettersCheckBox.click();
    }
    public void clickOnMobilePromotionCodes() {
        //actions.click(promotionCodesForMobileCheckBox).build().perform();
        javascript.executeScript("arguments[0].click();", promotionCodesForMobileCheckBox);
        //promotionCodesForMobileCheckBox.click();
    }
    public void clickOnMobileOtherCompanyNotifications() {
       // actions.click(otherCompanyNotificationsCheckBox).build().perform();
        javascript.executeScript("arguments[0].click();", otherCompanyNotificationsCheckBox);
//        otherCompanyNotificationsCheckBox.click();
    }
    public void clickOnChangePreferencesButton(){
        //actions.click(changePreferencesButton).build().perform();
        javascript.executeScript("arguments[0].click();", changePreferencesButton);
//        changePreferencesButton.click();
    }

    public void clickOnEmailCommunicationToggleButton(){
        actions.click(emailCommunicationToggleButton).build().perform();
    }
    public void clickOnMobileCommunicationToggleButton(){
        actions.click(mobileCommunicationToggleButton).build().perform();
    }

    public boolean emailToggleButtonIsSelected(){
        return emailCommunicationToggleButton.isSelected();
    }
    public boolean mobileToggleButtonIsSelected(){
        return mobileCommunicationToggleButton.isSelected();
    }





}
