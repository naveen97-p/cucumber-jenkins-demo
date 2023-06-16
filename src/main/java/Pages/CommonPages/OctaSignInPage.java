package Pages.CommonPages;

import Utilities.BrowserInstance;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OctaSignInPage extends BrowserInstance {

    public String signInScreenRefXpath="(//*[contains(text(),'Username')])[1]";
    public String signInPasswordScreenXpath = "//*[text()='Verify with your password']";
    public String signInOTPTriggerScreenXpath ="//*[contains(text(),'Send a verification email to ')]/following::input[1]";
    public String waitForOTPFieldToOpenXpath ="//*[text()='Enter a verification code instead']";
    public String mailBoxEmptyMessage="//*[contains(text(),'[ This Inbox is Currently Empty ]')]";
    public String checkRecetOTPMessageJustNow ="//table[@class='table-striped jambo_table']/tbody/tr[1]/td[contains(text(),'just now')]";
    public String checkRecetOTPMessageOneMin ="//table[@class='table-striped jambo_table']/tbody/tr[1]/td[contains(text(),'1 min')]";
    public String checkRecetOTPMessageTwoMin ="//table[@class='table-striped jambo_table']/tbody/tr[1]/td[contains(text(),'2 min')]";
    public String waitForOtp = "//span[text()=' Sign In ']//following::b";
    public String waitForHereLink = "//a[text()='here']";
    public String mailinatorSearchFieldXpath ="//input[@id='search']";
    public String waitForMagicLinkXpath="//a[text()='Email verification link']";


    public String waitForMFAChangeAddressOtp="//span[@id='verification-code']";
    public String waitForChangeForgetPasswordOTPForNewBank="//*[text()=\"Your PingOne Password Reset Code is: \"]/b";
    public String waitForMFADeviceOtp="//body[contains(text(),\"To finish pairing your device, enter this code:\")]";
    @FindBy(xpath = "//span[@id='verification-code']")
    WebElement mfaChangeAddressOtpText;

    @FindBy(xpath = "//a[text()='here']")
    WebElement authorizeSubscriptionHereLink;

    @FindBy(xpath = "//a[text()='Email verification link']")
    WebElement magicLinkForRegistrationLink;

    @FindBy(xpath = "//input[@name='identifier']")
    WebElement userNameTextField;

    @FindBy(xpath = "//input[@type='submit']")
    WebElement nextButton;

    @FindBy(xpath = "//input[@type='password']")
    WebElement passwordTextField;

    @FindBy(xpath = "//*[@value='Verify']")
    WebElement verifyButton;

    @FindBy(xpath = "//*[text()='Enter a verification code instead']")
    WebElement codeEnterButton;

    @FindBy(xpath = "//*[contains(text(),'Enter Code')]//following::input[1]")
    WebElement otpInputField;

    @FindBy(xpath = "//*[contains(text(),'Send a verification email to ')]/following::input[1]")
    WebElement sendMeAnEmailButton;

    @FindBy(xpath = "//input[@id='search']")
    WebElement mailinatorSearchField;

    @FindBy(xpath = "//button[text()='GO']")
    WebElement mailinatorSearchButton;

    @FindBy(xpath = "//table[@class='table-striped jambo_table']/tbody/tr[1]/td[2]")
    WebElement otpInboxMessageToOpenButton;

    @FindBy(xpath = "//span[text()=' Sign In ']//following::b")
    WebElement getOtpTextElement;

    @FindBy(xpath = "//*[text()=\"Your PingOne Password Reset Code is: \"]/b")
    WebElement getOtpTextForForgetPasswordNewBank;

    @FindBy(xpath = "//body[contains(text(),\"To finish pairing your device, enter this code:\")]")
    WebElement getMfaOtpText;

    /*
        @FindBy(xpath = "aaaa")
        WebElement aaaa;
    */
    public OctaSignInPage(){PageFactory.initElements(driver, this);}
    public void enterUserName(String email){userNameTextField.clear();userNameTextField.sendKeys(email);}
    public void clickOnNextButton(){nextButton.click();}
    public void enterPasswordToOcta(String password){passwordTextField.clear();passwordTextField.sendKeys(password);}
    public void clickOnVerifyButton(){verifyButton.click();}
    public void clickOnEnterCodeButton(){codeEnterButton.click();}
    public void enterOTPReceivedFromMailinator(String otp){otpInputField.clear();otpInputField.sendKeys(otp);}
    public void clickOnSendAnEmailButton(){sendMeAnEmailButton.click();}
    public void searchMailToOpenInbox(String email){mailinatorSearchField.clear();mailinatorSearchField.sendKeys(email);}
    public void clickOnGoButton(){mailinatorSearchButton.click();}

    public void clickOnOpenInboxMessage(){otpInboxMessageToOpenButton.click();}
    public String getActualOTP(){return getOtpTextElement.getText();}
    public String getMfaChangeAddressOTP(){return mfaChangeAddressOtpText.getText();}
    public String getForgetPasswordOTP(){return getOtpTextForForgetPasswordNewBank.getText();}
    public String getMfaDeviceOtp(){return getMfaOtpText.getText();}
    public void clickOnAuthorizeHereLink(){authorizeSubscriptionHereLink.click();}
    public void clickOnRegistrationMagicLink(){magicLinkForRegistrationLink.click();}



}
