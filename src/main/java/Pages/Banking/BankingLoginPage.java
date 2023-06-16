package Pages.Banking;

import Utilities.BrowserInstance;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BankingLoginPage extends BrowserInstance {

    //START:  ---------Title Verification-----------
    public String bankLoginScreenRef ="//*[text()='Login']//following::*[text()='Please enter your email and password or select another option below.']";
    public String bankLoginScreenPageUrl="https://services.ciamsgo.com/bank/login";
    public String bankLoginUsernameFieldRefXpath="//input[@name='username']";
    public String loginErrorMessageXpath="//*[text()=\"Cannot read properties of undefined (reading 'message')\"]";

    @FindBy(xpath = "//input[@name='username']")
    WebElement userNameTextField;

    @FindBy(xpath = "//input[@name='password']")
    WebElement passwordTextField;

    @FindBy(xpath = "//button[text()='Login']")
    WebElement loginButton;

    @FindBy(xpath = "//a[text()='Forgot Username?']")
    WebElement forgotUsernameLink;

    @FindBy(xpath = "//a[text()='Forgot Password?']")
    WebElement forgotPasswordLink;

    @FindBy(xpath = "//p[text()=\"Don't have an account?\"]/following::a[text()='Register']")
    WebElement registerLink;

    @FindBy(xpath = "//button[text()=' SMS One Time Code']")
    WebElement smsOneTimeCodeButton;

    @FindBy(xpath = "//button[text()=' Passwordless Login']")
    WebElement passwordLessLoginButton;

    @FindBy(xpath = "//button[text()= ' Device Native Passwordless']")
    WebElement deviceNativePasswordLessButton;


    /*
        @FindBy(xpath = "aaaaaaaaa")
        WebElement aaaa;
    */
    public BankingLoginPage(){
        PageFactory.initElements(driver, this);
    }
    public String getLoginPageUrl(){return driver.getCurrentUrl();}
    public void enterUsername(String username){userNameTextField.click();userNameTextField.clear();userNameTextField.sendKeys(username);}
    public void enterPassword(String password){passwordTextField.click();passwordTextField.clear();passwordTextField.sendKeys(password);}
    public void clickOnLoginButton(){loginButton.click();}
    public void clickOnForgotUsername(){forgotUsernameLink.click();}
    public void clickOnForgotPassword(){forgotPasswordLink.click();}
    public void clickOnSmsOneTimeCode(){smsOneTimeCodeButton.click();}
    public void clickOnDeviceNativePasswordless(){deviceNativePasswordLessButton.click();}
    public void clickOnPasswordlessLogin(){passwordLessLoginButton.click();}
    public void clickOnRegisterButton(){registerLink.click();}

}
