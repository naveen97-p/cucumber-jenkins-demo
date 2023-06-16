package Pages.Retail;

import Utilities.BrowserInstance;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RetailSignUpPage extends BrowserInstance {
    public String signUpThroughEmailXpath = "//*[text()='Sign Up with Email']";
    public String signUpThroughFacebookXpath = "//*[text()='SIGN UP With Facebook']";
    public String signUpThroughGoogleXpath = "//*[text()='SIGN UP With Google']";


    @FindBy(xpath = "//*[text()='Sign Up with Email']")
    WebElement getSignUpWithEmailButton;


    @FindBy(xpath = "//*[text()='SIGN UP With Google']")
    WebElement getSignUpWithGoogleButton;


    @FindBy(xpath = "//*[text()='SIGN UP With Facebook']")
    WebElement getSignUpWithFacebookButton;


    @FindBy(xpath = "//*[text()='SIGN UP TO PASSWORDLESS']")
    WebElement getSignUpWithPasswordLessButton;


    @FindBy(xpath = "//*[text()='Checkout as Guest']")
    WebElement checkOutAsGuestButton;


    @FindBy(xpath = "(//*[text()='Login'])[2]")
    WebElement loginButton;

    //------Text Related WebElements------
    //h1[text()='Sign Up']     header-title
    //p[text()='Select an option to create an account or checkout as a guest']    guest-info-comment
    //*[text()='Checkout as Guest']//following::div/p[text()='Already have an account?']     already-have-an-acc-comment


    @FindBy(xpath = "//h1[text()='Sign Up']")
    WebElement signUpHeaderText;


    @FindBy(xpath = "//p[text()='Select an option to create an account or checkout as a guest']")
    WebElement signUpInfoText;


    @FindBy(xpath = "//*[text()='Checkout as Guest']//following::div/p[text()='Already have an account?']")
    WebElement alreadyHaveAnAccountText;

    public RetailSignUpPage(){
        PageFactory.initElements(driver, this);
    }
    public void clickOnSignUpViaEmail(){
        getSignUpWithEmailButton.click();
    }
    public void clickOnSignUpViaGoogle(){
        getSignUpWithGoogleButton.click();
    }
    public void clickOnSignUpViaFacebook(){
        getSignUpWithFacebookButton.click();
    }
    public void clickOnSignUpWithPasswordLess(){
        getSignUpWithPasswordLessButton.click();
    }
    public void clickOnCheckOutAsGuest(){
        checkOutAsGuestButton.click();
    }
    public void clickOnLoginButton(){
        loginButton.click();
    }
    public String getSignUpHeaderTitle(){
        return signUpHeaderText.getText();
    }
    public String getSignUpInfoTitle(){
        return signUpInfoText.getText();
    }
    public String getAlreadyHaveAnAccountTitle(){
        return alreadyHaveAnAccountText.getText();
    }


}
