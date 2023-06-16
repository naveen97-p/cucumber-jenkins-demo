package Pages.NewBank;

import Utilities.BrowserInstance;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewBankSignUpPage extends BrowserInstance {

        //START:  ---------Title Verification-----------
        public String registrationScreenRef ="//*[text()='Welcome onboard!']//following::*[contains(text(),\"We are delighted to have you join our family. Let's get started.\")]";
        public String registerUserPageUrl="https://bank.ciam.sandbox.ciamsgo.com/signup";
        public String emailAlreadyRegisteredErrorMsgXpath="//*[text()='email: is unique but a non-unique value is provided']";

        //MFA Setup Page
        public String selectMfaRefScreenXpath="//*[text()='Select MFA Method']//following::*[contains(text(),'Select the authentication method you want to pair with your account.')]";
        public String selectMfaRefPageUrl="https://bank.ciam.sandbox.ciamsgo.com/signup";


    @FindBy(xpath = "//input[@name='email']")
    WebElement emailTF;

    @FindBy(xpath = "//input[@name='firstName']")
    WebElement firstNameTF;

    @FindBy(xpath = "//input[@name='lastName']")
    WebElement lastNameTF;

    @FindBy(xpath = "//input[@name='username']")
    WebElement userNameTF;

    @FindBy(xpath = "//input[@name='password']")
    WebElement passwordTF;

    @FindBy(xpath = "//input[@name='confirmpassword']")
    WebElement confirmPasswordTF;

    @FindBy(xpath = "//*[contains(text(),'I agree to the')]")
    WebElement termsAndConditionsOfOnBoardCheckBox;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement registerButton;

    @FindBy(xpath = "//*[text()='Welcome onboard!']//following::*[contains(text(),\"We are delighted to have you join our family. Let's get started.\")]")
    WebElement cursorRestRef;

    //Select MFA Page Items
    @FindBy(xpath = "//*[text()='Email']//following::*[contains(text(),'Receive an email with a passcode to')]")
    WebElement emailMfaOption;

    @FindBy(xpath = "//*[text()='I will do it later']")
    WebElement iWillDoItLaterLink;



     /*
        @FindBy(xpath = "aaaaaaaaa")
        WebElement aaaa;
    */

    public NewBankSignUpPage(){
        PageFactory.initElements(driver, this);
    }//Constructor
    public String getPageUrl(){return driver.getCurrentUrl();}

    public void enterEmail(String email){
        String b = Keys.BACK_SPACE.toString();
        String space =Keys.SPACE.toString();
        String tab_space =Keys.TAB.toString();
        actions.click(emailTF).build().perform();
        emailTF.sendKeys(b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b);
        emailTF.sendKeys(email+space+b+tab_space);
        actions.click(cursorRestRef).build().perform();
    }
    public void enterFirstname(String firstname){
        String b = Keys.BACK_SPACE.toString();
        String space =Keys.SPACE.toString();
        String tab_space =Keys.TAB.toString();
        actions.click(firstNameTF).build().perform();
        firstNameTF.sendKeys(b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b);
        firstNameTF.sendKeys(firstname+space+b+tab_space);
        actions.click(cursorRestRef).build().perform();
    }
    public void enterLastname(String lastname){
        String b = Keys.BACK_SPACE.toString();
        String space =Keys.SPACE.toString();
        String tab_space =Keys.TAB.toString();
        actions.click(lastNameTF).build().perform();
        lastNameTF.sendKeys(b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b);
        lastNameTF.sendKeys(lastname+space+b+tab_space);
        actions.click(cursorRestRef).build().perform();
    }

    public void enterUsername(String username){
        String b = Keys.BACK_SPACE.toString();
        String space =Keys.SPACE.toString();
        String tab_space =Keys.TAB.toString();
        actions.click(userNameTF).build().perform();
        userNameTF.sendKeys(b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b);
        userNameTF.sendKeys(username+space+b+tab_space);
        actions.click(cursorRestRef).build().perform();
    }

    public void enterPassword(String password){
        String b = Keys.BACK_SPACE.toString();
        String space =Keys.SPACE.toString();
        String tab_space =Keys.TAB.toString();
        actions.click(passwordTF).build().perform();
        passwordTF.sendKeys(b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b);
        passwordTF.sendKeys(password+space+b+tab_space);
        actions.click(cursorRestRef).build().perform();
    }
    public void enterConfirmPassword(String password){
        String b = Keys.BACK_SPACE.toString();
        String space =Keys.SPACE.toString();
        String tab_space =Keys.TAB.toString();
        actions.click(confirmPasswordTF).build().perform();
        confirmPasswordTF.sendKeys(b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b);
        confirmPasswordTF.sendKeys(password+space+b+tab_space);
        actions.click(cursorRestRef).build().perform();
    }

    public void enableTermsAndConditionsCheckBoxForOnBoardUser(){
        javascript.executeScript("arguments[0].click();",termsAndConditionsOfOnBoardCheckBox);
        //termsAndConditionsOfOnBoardCheckBox.click();
    }
    public void clickOnRegisterButton(){javascript.executeScript("arguments[0].click();",registerButton);}
    public void clickOnEmailMfaSetupOption(){javascript.executeScript("arguments[0].click();",emailMfaOption);}
    public void clickOnIWillDoItLaterLink(){javascript.executeScript("arguments[0].click();",iWillDoItLaterLink);}


}
