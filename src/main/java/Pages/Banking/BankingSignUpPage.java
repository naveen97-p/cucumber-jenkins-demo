package Pages.Banking;

import Utilities.BrowserInstance;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BankingSignUpPage extends BrowserInstance {
    //START:  ---------Title Verification-----------
    public String bankSignUpScreenRef ="//*[text()='Sign Up']//following::*[text()='Select an option to create an account']";
    public String bankSignUpScreenPageUrl="https://services.ciamsgo.com/bank/register";
    public String bankSignUpEmailScreenRef="//*[text()='Enter your email']//following::*[text()=\"We'll send you an email to create an account\"]";
    public String bankSignUpEmailScreenPageUrl="https://services.ciamsgo.com/bank/register-email";
    public String emailSentToYourMailAddressRef="//*[text()=\"We've sent an email to the address you provided. Please click the link in the email to proceed.\"]";


    @FindBy(xpath = "//*[text()='Sign Up']//following::*[text()='Sign Up with Email']")
    WebElement emailSignUpLink;
    @FindBy(xpath = "//*[text()='Already have an account?']//following::*[text()='Login']")
    WebElement loginButton;
    @FindBy(xpath = "//input[@name='email']")
    WebElement emailTextField;
    @FindBy(xpath = "//button[text()='Next']")
    WebElement nextButton;


    /*
        @FindBy(xpath = "aaaaaaaaa")
        WebElement aaaa;
    */
    public BankingSignUpPage(){PageFactory.initElements(driver, this);}
    public String getSignUpPageUrl(){return driver.getCurrentUrl();}
    public String getSignUpEmailPageUrl(){return driver.getCurrentUrl();}
    public void clickOnEmailSignUp(){emailSignUpLink.click();}
    public void clickOnLoginButton(){loginButton.click();}
    public void enterEmail(String email){emailTextField.click();emailTextField.clear();emailTextField.sendKeys(email);}
    public void clickOnNext(){nextButton.click();}
    public void waitForEmailSentConfirmation(){waitUtil.elementToBeLocated(emailSentToYourMailAddressRef);}
}
