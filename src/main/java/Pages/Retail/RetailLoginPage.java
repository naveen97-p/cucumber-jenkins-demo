package Pages.Retail;

import Utilities.BrowserInstance;
import Utilities.WaitUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RetailLoginPage extends BrowserInstance {

//    WebDriver driver;
    public String loginViaGoogleXpath ="//a[text()='Continue With Google']";
    public String loginViaFacebookXpath ="//a[text()='Continue With Facebook']";
    public String loginFailureXpath ="//*[text()='Failed to Authenticate']";//Failed to Authenticate
    public String loginPageRefUsernameXpath="//input[@name='username']";
    //Page Factory Objects
    @FindBy(xpath = "//input[@name='username']")
    WebElement usernameTextField;


    @FindBy(xpath = "//input[@name='password']")
    WebElement passwordTextField;


    @FindBy(xpath = "//a[text()='Forgot Username?']")
    WebElement forgetUsernameLink;

    @CacheLookup
    @FindBy(xpath = "//a[text()='Forgot Password?']")
    WebElement forgetPasswordLink;

    @FindBy(xpath = "//a[text()='Continue With Google']")
    WebElement continueLoginWithGoogle;


    @FindBy(xpath = "//a[text()='Continue With Facebook']")
    WebElement continueLoginWithFacebook;


    @FindBy(xpath = "//a[text()='Passwordless Login']")
    WebElement passwordLessLogin;


    @FindBy(xpath = "//button[text()='Login']")
    WebElement loginButton;


    @FindBy(xpath = "//*[text()='Register']")
    WebElement registerNow;


    @FindBy(xpath = "//h1[text()='Login']")
    WebElement loginHeaderText;


    @FindBy(xpath = "//p[text()='Please enter your email and password or select another option below.']")
    WebElement loginPageInfoText;


    @FindBy(xpath = "//*[text()='Failed to Authenticate']")
    WebElement loginFailureMessage;

    /*
    @CacheLookup
    @FindBy(xpath = "aaaaaaaaa")
    WebElement aaaa;
    */

    public RetailLoginPage(){
        PageFactory.initElements(driver, this);
    }

    //Login with standard email and password
    public void enterUsername(String username){
        usernameTextField.clear();usernameTextField.click();usernameTextField.sendKeys(username);
    }

    public void enterPassword(String password){
        passwordTextField.clear();passwordTextField.click();passwordTextField.sendKeys(password);
    }

    public void clickOnLoginButton(){
        loginButton.click();
    }

    public void loginWithUsernameAndPasswordViaStandardLogin(String username, String password){
        usernameTextField.clear();usernameTextField.click();
        usernameTextField.sendKeys(username);
        passwordTextField.clear();passwordTextField.click();
        usernameTextField.sendKeys(password);
        loginButton.click();
    }


    //Login via social network sites
    public void clickOnLoginViaGoogle(){
        continueLoginWithGoogle.click();
    }

    public void clickOnLoginViaFacebook(){
        continueLoginWithFacebook.click();
    }

    public void clickOnLoginViaPasswordLessFeature(){
        passwordLessLogin.click();
    }


    //Forget Username and Password
    public void clickOnForgetUsername(){
        forgetUsernameLink.click();
    }

    public void clickOnForgetPassword(){
        forgetPasswordLink.click();
    }

    public String getLoginFailureMessage(){
        return loginFailureMessage.getText();
    }






}
