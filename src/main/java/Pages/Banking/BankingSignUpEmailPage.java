package Pages.Banking;

import Configurations.Passcodes;
import Utilities.BrowserInstance;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BankingSignUpEmailPage extends BrowserInstance {

    public String emailXpathOnSignUpPage="//*[text()='Sign Up with Email']/following::*[text()='Enter your information to create an account']";
    public String failedSignUpXpath ="//p[text()='Something went wrong...']";

    @FindBy(xpath = "//input[@name='username']")
    WebElement usernameField;

    @FindBy(xpath = "//input[@name='firstName']")
    WebElement firstnameField;

    @FindBy(xpath = "//input[@name='lastName']")
    WebElement lastnameField;

    @FindBy(xpath = "//*[@name='password']")
    WebElement passwordField;

    @FindBy(xpath = "//*[@name='termsandconditions']")
    WebElement iAgreeToTermsAndConditionsCheckBox;

//    @FindBy(xpath = "//*[@name='offersconsent']")
//    WebElement iAgreeToReceiveNewsLettersCheckBox;

//    @FindBy(xpath = "//a[text()='Terms and Conditions']")
//    WebElement termsAndConditionsLink;

//    @FindBy(xpath ="(//a[text()='Privacy Policy'])[1]")
//    WebElement privacyPolicyLink;

    @FindBy(xpath = "//button[text()='Create your account']")
    WebElement createYourAccountButton;

    @FindBy(xpath = "//*[text()='Failed to register']")
    WebElement signUpError;

//    @FindBy(xpath = "//*[@name='confirmPassword']")
//    WebElement confirmPasswordField;


    /*
    @FindBy(xpath = "aaaaaaaaa")
    WebElement aaaa;
    */

    public BankingSignUpEmailPage(){
        PageFactory.initElements(driver, this);
    }

    public void enterUsername(String username){
        usernameField.clear();
        usernameField.sendKeys(username);
    }
    public void enterFirstName(String firstname){
        firstnameField.clear();
        firstnameField.sendKeys(firstname);
    }
    public void enterLastName(String lastname){
        lastnameField.clear();
        lastnameField.sendKeys(lastname);
    }

    public void enterPassword(){
        passwordField.clear();
        passwordField.sendKeys(Passcodes.BANKING_PASSWORD);
    }
    public void clickOnCreateYourAccount(){createYourAccountButton.click();}

    public void enableTermsAndConditionsCheckBox(String booleanFlagForTermsAndConditionsCheckBox){
        if(booleanFlagForTermsAndConditionsCheckBox.equalsIgnoreCase("True"))
            iAgreeToTermsAndConditionsCheckBox.click();
        else
            System.out.println("User has opted out for T&C");

    }


    public String getSignUpFailedMessage(){
        return signUpError.getText();}

}
