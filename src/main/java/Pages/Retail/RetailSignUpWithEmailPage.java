package Pages.Retail;

import Configurations.Passcodes;
import Utilities.BrowserInstance;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RetailSignUpWithEmailPage extends BrowserInstance {

public String emailXpathOnSignUpPage="//*[@name='email']";
public String failedSignUpXpath ="//*[text()='Failed to register']";
public String capchaVerifyXpath="//*[@class='recaptcha-checkbox-border']";

    @FindBy(xpath = "//*[@name='username']")
    WebElement usernameField;

    @FindBy(xpath = "//*[@name='firstName']")
    WebElement firstnameField;

    @FindBy(xpath = "//*[@name='lastName']")
    WebElement lastnameField;

    @FindBy(xpath = "//*[@name='email']")
    WebElement emailField;

    @FindBy(xpath = "//*[@name='password']")
    WebElement passwordField;

    @FindBy(xpath = "//*[@name='termsandconditions']")
    WebElement iAgreeToTermsAndConditionsCheckBox;

    @FindBy(xpath = "//*[@name='offersconsent']")
    WebElement iAgreeToReceiveNewsLettersCheckBox;

    @FindBy(xpath = "//a[text()='Terms and Conditions']")
    WebElement termsAndConditionsLink;

    @FindBy(xpath ="(//a[text()='Privacy Policy'])[1]")
    WebElement privacyPolicyLink;

    @FindBy(xpath = "(//*[text()='Sign Up'])[2]")
    WebElement signUpButton;

    @FindBy(xpath = "//*[text()='Failed to register']")
    WebElement signUpError;

    @FindBy(xpath = "//*[@name='confirmPassword']")
    WebElement confirmPasswordField;

    @FindBy(xpath = "//*[@class='recaptcha-checkbox-border']")
    WebElement capchaVerify;

    /*
    @FindBy(xpath = "aaaaaaaaa")
    WebElement aaaa;
    */

    public RetailSignUpWithEmailPage(){
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
    public void enterEmail(String email){
        emailField.clear();
        emailField.sendKeys(email);
    }
    public void enterPassword(){
        passwordField.clear();
        passwordField.sendKeys(Passcodes.STANDARD_PASSWORD);
    }
    public void enterConfirmPassword(){
        confirmPasswordField.clear();
        confirmPasswordField.sendKeys(Passcodes.STANDARD_PASSWORD);
    }
    public void enableTermsAndConditionsCheckBox(String booleanFlagForTermsAndConditionsCheckBox){
        if(booleanFlagForTermsAndConditionsCheckBox.equalsIgnoreCase("True"))
        iAgreeToTermsAndConditionsCheckBox.click();
        else
            System.out.println("User has opted out for T&C");

    }
    public void enableReceiveEmailsCheckBox(String booleanFlagForTReceiveEmailsCheckBox){
        if(booleanFlagForTReceiveEmailsCheckBox.equalsIgnoreCase("True"))
            iAgreeToReceiveNewsLettersCheckBox.click();
        else
            System.out.println("User has opted out for receiving emails");
    }
    public void clickOnSignUpButton(){
        signUpButton.click();
    }
    public String getSignUpFailedMessage(){
        String signUpFailedMessage = signUpError.getText();
        return signUpFailedMessage;
    }

    public void clickOnCapchaVerify(){
        capchaVerify.click();
    }


    public void clickOnTermsAndConditionsHyperLink(){
        termsAndConditionsLink.click();
    }
    public void clickOnPrivacyPolicyHyperLink(){
        privacyPolicyLink.click();
    }

}
