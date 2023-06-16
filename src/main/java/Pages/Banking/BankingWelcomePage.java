package Pages.Banking;

import Utilities.BrowserInstance;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BankingWelcomePage extends BrowserInstance {

        //START:  ---------Title Verification-----------
        public String bankWelcomeScreenRef ="//*[text()='Safe and Secure banking']//following::*[text()='Providing our customers with the best of our services']";
        public String bankWelcomeScreenPageUrl="https://services.ciamsgo.com/bank";

    @FindBy(xpath = "//*[text()='Providing our customers with the best of our services']//following::a[text()='Login']")
    WebElement loginButton;

    @FindBy(xpath = "//*[text()='Providing our customers with the best of our services']//following::a[text()='Sign Up']")
    WebElement signUpButton;

    @FindBy(xpath = "//*[text()='Open a new account and gain instant rewards of']//following::a[text()='Open New Account']")
    WebElement openNewAccountButton;

    /*
        @FindBy(xpath = "aaaaaaaaa")
        WebElement aaaa;
    */

    public BankingWelcomePage(){
        PageFactory.initElements(driver, this);
    }//Constructor

    public void clickOnSignUpButton(){signUpButton.click();}
    public void clickOnLoginButton(){loginButton.click();}
    public void clickOnOpenNewAccountButton(){openNewAccountButton.click();}
    public void waitForBankingWelcomePage(){waitUtil.elementToBeLocated(bankWelcomeScreenRef);}
   public String getWelcomePageUrl(){return driver.getCurrentUrl();}

}
