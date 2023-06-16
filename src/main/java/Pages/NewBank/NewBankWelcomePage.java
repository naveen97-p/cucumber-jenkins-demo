package Pages.NewBank;

import Utilities.BrowserInstance;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewBankWelcomePage extends BrowserInstance {

    //START:  ---------Title Verification-----------
    public String welcomeScreenRef ="//*[text()='Safe & Secure Banking for you']";
    public String welcomeScreenPageUrl="https://bank.ciam.sandbox.ciamsgo.com/";
    public String openAnAccountRefXpath="//button[text()='Open an account']";
    public String invalidUsernameOrPasswordAttemptErrorInfoXpath="//*[text()='Unauthorized!']";
    public String emptyUsernameErrorXpath="//*[text()='Username is mandatory']";
    public String emptyPasswordErrorXpath="//*[text()='Password is mandatory']";
    public String firstNameInvalidError="//*[text()=\"identifer must be a uuid. \"]";
    public String passwordInvalidError="//*[text()=\"Username or password is invalid\"]";
    public String forgetPasswordLinkXpath="//a[text()='Password']";
    public String errorMessageForForgetPasswordText="//*[text()=\"Unauthorized!\"]";
    public String errorMessageForInvalidErrorCode="//*[text()=\"recoveryCode: The provided password recovery code was invalid or expired\"]";
    public String errorMessageForInvalidPasswordPolicy="//*[text()=\"newPassword: New password did not satisfy password policy requirements\"]";

    //Login Section
    public String loginSectionScreenRef ="//*[text()='Login to your account']";

    //Forget password
    public String forgetPasswordRefScreenXpath="//*[text()='Forgot Password?']//following::*[text()=\"Enter your username, and we'll send password reset\"]//following::*[text()=\"instructions to your email address\"]";
    public String forgetPasswordPageUrl="https://bank.ciam.sandbox.ciamsgo.com/recoverPassword";
    public String setupForgetPasswordPageUrl="https://bank.ciam.sandbox.ciamsgo.com/recoverPassword";
    //Setup Password
    public String setupNewPasswordRefScreenXpath="//*[text()=\"Set New Password\"]//following::*[text()=\" If you have an active account with a valid email address,\"]//following::*[text()=\"you will receive an email with a recovery code which you may enter here,\"]//following::*[text()=\"along with a new password.\"]";


    @FindBy(xpath = "//*[text()='Safe & Secure Banking for you']")
    WebElement welcomeScreeCursorReference;

    @FindBy(xpath = "//button[text()='Open an account']")
    WebElement openAnAccountButton;

    @FindBy(xpath = "//*[text()='Login to your account']//following::input[@name='username']")
    WebElement usernameTF;

    @FindBy(xpath = "//*[text()='Login to your account']//following::input[@name='password']")
    WebElement passwordTF;

    @FindBy(xpath = "//*[text()='Login to your account']//following::button[@type='submit']")
    WebElement signOnButton;

    //Forget Password
    @FindBy(xpath = "//a[text()='Password']")
    WebElement forgetPassword;

    @FindBy(xpath = "//*[text()='Forgot Password?']//following::*[text()=\"Enter your username, and we'll send password reset\"]//following::*[text()=\"instructions to your email address\"]")
    WebElement forgetPasswordCursorRestRef;

    @FindBy(xpath = "//input[@id=\"username\"]")
    WebElement usernameForForgetPasswordTF;

    @FindBy(xpath = "//button[@type=\"submit\"]")
    WebElement submitForgetPasswordButton;

    //Setup password
    @FindBy(xpath = "//*[text()=\"Set New Password\"]//following::*[text()=\" If you have an active account with a valid email address,\"]//following::*[text()=\"you will receive an email with a recovery code which you may enter here,\"]//following::*[text()=\"along with a new password.\"]")
    WebElement setupForgetPasswordCursorRestRef;

    @FindBy(xpath = "//input[@id=\"recoveryCode\"]")
    WebElement recoveryMailinatorCodeTF;

    @FindBy(xpath = "//input[@id=\"newPassword\"]")
    WebElement newPasswordForForgetPasswordTF;

    @FindBy(xpath = "//input[@id=\"confirmPassword\"]")
    WebElement confirmNewPasswordForForgetPasswordTF;

    @FindBy(xpath = "//button[@type=\"submit\"]")
    WebElement submitChangePasswordButton;




     /*
        @FindBy(xpath = "aaaaaaaaa")
        WebElement aaaa;
    */

    public NewBankWelcomePage(){
        PageFactory.initElements(driver, this);
    }//Constructor
    public String getPageUrl(){return driver.getCurrentUrl();}

    public void clickOnOpenAnAccountButton(){javascript.executeScript("arguments[0].click();",openAnAccountButton);}
    public void enterUsername(String username){
        String b = Keys.BACK_SPACE.toString();
        String space =Keys.SPACE.toString();
        String tab_space =Keys.TAB.toString();
        actions.click(usernameTF).build().perform();
        usernameTF.sendKeys(b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b);
        usernameTF.sendKeys(username+space+b+tab_space);
        actions.click(welcomeScreeCursorReference).build().perform();
    }
    public void enterPassword(String password){
        String b = Keys.BACK_SPACE.toString();
        String space =Keys.SPACE.toString();
        String tab_space =Keys.TAB.toString();
        actions.click(passwordTF).build().perform();
        passwordTF.sendKeys(b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b);
        passwordTF.sendKeys(password+space+b+tab_space);
        actions.click(welcomeScreeCursorReference).build().perform();
    }
    public void clickOnSignOnButton(){javascript.executeScript("arguments[0].click();",signOnButton);}
    public void clickOnForgetPasswordLink(){
        actions.click(forgetPassword).build().perform();
        //javascript.executeScript("arguments[0].click();",forgetPassword);
    }


    //Forget Password
    public void enterUsernameForgetPassword(String usernameForForgetPassword){
        String b = Keys.BACK_SPACE.toString();
        String space =Keys.SPACE.toString();
        String tab_space =Keys.TAB.toString();
        actions.click(usernameForForgetPasswordTF).build().perform();
        usernameForForgetPasswordTF.sendKeys(b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b);
        usernameForForgetPasswordTF.sendKeys(usernameForForgetPassword+space+b+tab_space);
        actions.click(forgetPasswordCursorRestRef).build().perform();
    }

    public void clickOnSubmitForgetPassword(){
        actions.click(submitForgetPasswordButton).build().perform();
        //javascript.executeScript("arguments[0].click();",submitForgetPasswordButton);
    }

    //Setup Forget Password
    public void enterRecoveryCodeForForgetPassword(String recoveryCode){
        String b = Keys.BACK_SPACE.toString();
        String space =Keys.SPACE.toString();
        String tab_space =Keys.TAB.toString();
        actions.click(recoveryMailinatorCodeTF).build().perform();
        recoveryMailinatorCodeTF.sendKeys(b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b);
        recoveryMailinatorCodeTF.sendKeys(recoveryCode+space+b+tab_space);
        actions.click(setupForgetPasswordCursorRestRef).build().perform();
    }
    public void enterNewPasswordForForgetPassword(String newPassword){
        String b = Keys.BACK_SPACE.toString();
        String space =Keys.SPACE.toString();
        String tab_space =Keys.TAB.toString();
        actions.click(newPasswordForForgetPasswordTF).build().perform();
        newPasswordForForgetPasswordTF.sendKeys(b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b);
        newPasswordForForgetPasswordTF.sendKeys(newPassword+space+b+tab_space);
        actions.click(setupForgetPasswordCursorRestRef).build().perform();
    }
    public void enterConfirmNewPasswordForForgetPassword(String newPassword){
        String b = Keys.BACK_SPACE.toString();
        String space =Keys.SPACE.toString();
        String tab_space =Keys.TAB.toString();
        actions.click(confirmNewPasswordForForgetPasswordTF).build().perform();
        confirmNewPasswordForForgetPasswordTF.sendKeys(b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b);
        confirmNewPasswordForForgetPasswordTF.sendKeys(newPassword+space+b+tab_space);
        actions.click(setupForgetPasswordCursorRestRef).build().perform();
    }
    public void clickOnSubmitSetupForgetPassword(){
        actions.click(submitChangePasswordButton).build().perform();
        //javascript.executeScript("arguments[0].click();",submitChangePasswordButton);
    }




}
