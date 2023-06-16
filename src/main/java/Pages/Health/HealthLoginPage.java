package Pages.Health;

import Utilities.BrowserInstance;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HealthLoginPage extends BrowserInstance {

    //START:  ---------Title Verification-----------
    public String loginAsAPatient ="https://services.ciamsgo.com/wellness/login?role=patient";
    public String loginAsADoctor ="https://services.ciamsgo.com/wellness/login?role=doctor";
    public String loginAsAPartnerUser ="https://services.ciamsgo.com/wellness/login?role=partner";
    public String loginAsAPartnerAdmin ="https://services.ciamsgo.com/wellness/login?role=partner-admin";
    public String loginAsAnApplicationAdmin ="https://services.ciamsgo.com/wellness/login?role=admin";
    //END  :  ---------Title Verification-----------
    public String userNameLandRefXpath ="//input[@name='username']";
    public String registerLinkXpath="//p[text()=\"Don't have an account?\"]/following::a[text()='Register']";
    public String loginErrorMessageXpath="//*[text()=\"Cannot read properties of undefined (reading 'message')\"]";


    @FindBy(xpath = "//h1[text()='Login']")
    WebElement headerTextLoginText;

    @FindBy(xpath = "//*[text()='Please provide your username and password to authenticate.']")
    WebElement loginInfoText;

    @FindBy(xpath = "//input[@name='username']")
    WebElement usernameInputTextField;

    @FindBy(xpath = "//input[@name='password']")
    WebElement passwordInputTextField;

    @FindBy(xpath = "//button[@id='submit']")
    WebElement submitButton;

    @FindBy(xpath = "//a[text()='Forgot Password?']")
    WebElement forgetPasswordLink;

    @FindBy(xpath = "//p[text()=\"Don't have an account?\"]/following::a[text()='Register']")
    WebElement registerLink;

    @FindBy(xpath = "//a[text()='Passwordless Login']")
    WebElement passwordLessLoginButton;

    @FindBy(xpath = "//*[text()=\"Cannot read properties of undefined (reading 'message')\"]")
    WebElement loginErrorMessage;



     /*
    @FindBy(xpath = "aaaaaaaaa")
    WebElement aaaa;
    */

    public HealthLoginPage(){
        PageFactory.initElements(driver, this);
    }//Constructor
    public String getPageUrl(){return driver.getCurrentUrl();}
    public void enterUsername(String username){usernameInputTextField.clear(); usernameInputTextField.sendKeys(username);}
    public void enterPassword(String password){passwordInputTextField.clear(); passwordInputTextField.sendKeys(password);}
    public void clickOnSubmitButton(){submitButton.click();}
    public void clickOnForgetPasswordButton(){forgetPasswordLink.click();}
    public String getLoginHeaderMessage(){return headerTextLoginText.getText();} //Should Return: Login
    public String getLoginErrorMessage(){return loginErrorMessage.getText();}
    public String getLoginInfoMessage(){return loginInfoText.getText();} //Should Return: Please provide your username and password to authenticate.
    public void clickOnRegisterButton(){registerLink.click();}
}
