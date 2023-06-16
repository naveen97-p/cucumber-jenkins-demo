package Pages.NewBank;

import Utilities.BrowserInstance;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewBankOpenAnAccountPage extends BrowserInstance {

        //START:  ---------Title Verification-----------
        public String openAnAccScreenRef ="//*[text()='Open an account']//following::*[text()='How would you like to sign up?']";
        public String continueButtonRefXpathForOpenAnAccDecision="//*[text()='How would you like to sign up?']//following::button[@type='button']";
        public String openAnAccScreenPageUrl="https://bank.ciam.sandbox.ciamsgo.com/#";
        public String welcomeOnBoardPageRefXpath="//*[text()='Welcome onboard!']//following::*[contains(text(),\"We are delighted to have you join our family. Let's get started.\")]";
        public String termsAndConditionsForWelcomeOnBoardPageXpath="//a[text()='Terms and Conditions']";
        public String onBoardSignUpVerifyURL="https://bank.ciam.sandbox.ciamsgo.com/signup-verify";
        public String onBoardRegSignUpVerifyURL="https://bank.ciam.sandbox.ciamsgo.com/signup";
        public String verifyYourIdentityScreenRef="//*[text()='Verify your Identity']//following::*[contains(text(),'We need to verify your identity.')]//following::*[contains(text(),\"This will require scanning your government issued ID such as a Driver License or Passport.\")]//following::*[contains(text(),\"Please have your ID ready before proceeding and in a well lit environment for best results. \")]";
        public String verifyMFACodeScreenRef="//*[contains(text(),\"Scan this QR Code with your mobile phone and follow the instructions.\")]//following::*[contains(text(),\"Check that your phone shows the same Verification code as below:\")]//following::*[contains(text(),\"Waiting for you to complete verification:\")]";
        public String existingUserErrorMsgForOnBoardGovtVerificationUserErrorMsg="//*[text()='This address is already registered']";
        public String termsAndConditionsPageURLforWelcomeOnBoard="https://bank.ciam.sandbox.ciamsgo.com/termsAndConditions";

        public String termsAndConditionUiTextXpath="//*[contains(text(),\"Terms and Conditions\")]//following::*[contains(text(),\"CCPA Terms and Conditions Template\") and contains(text(),\"This template provides a suggested structure for a CCPA Privacy Notice. It is for informational purposes only and not for the purpose of providing legal advice. You should edit\") and contains(text(),\"the content and sections to meet your requirements, and if in doubt, contact your attorney to obtain advice with respect to any particular issue.\") ]";
        //WelcomeOnBoard Page


    @FindBy(xpath = "//*[text()=\"With a valid Government issued ID (Driver License/Passport)\"]")
    WebElement govtIDVerificationRadioButton;

    @FindBy(xpath = "//*[text()=\"Using a registration form\"]")
    WebElement registrationFormRadioButton;

    @FindBy(xpath = "//*[text()='How would you like to sign up?']//following::button[@type='button']")
    WebElement registrationDecisionSubmitButton;



    //START: OnBoard User GovtID

    @FindBy(xpath = "//input[@name='email']")
    WebElement emailOnBoardTF;

    @FindBy(xpath = "//*[contains(text(),'I agree to the')]")
    WebElement termsAndConditionsOfOnBoardCheckBox;

    @FindBy(xpath = "//a[text()='Terms and Conditions']")
    WebElement termsAndConditionsHyperLink;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement submitOnBoardButton;

    @FindBy(xpath = "//*[text()='Welcome onboard!']//following::*[contains(text(),\"We are delighted to have you join our family. Let's get started.\")]")
    WebElement onBoardCursorRefButton;


    //END: OnBoard User GovtID

    //START: Verify Identity
    @FindBy(xpath = "//button[@type='submit']")
    WebElement continueButton;
    //END: Verify Identity

     /*
        @FindBy(xpath = "aaaaaaaaa")
        WebElement aaaa;
    */

    public NewBankOpenAnAccountPage(){
        PageFactory.initElements(driver, this);
    }//Constructor
    public String getPageUrl(){return driver.getCurrentUrl();}

    public void clickOnGovtIdVerificationRadioButton(){
        javascript.executeScript("arguments[0].click();",govtIDVerificationRadioButton);
        //govtIDVerificationRadioButton.click();
    }
    public void clickOnRegistrationFormRadioButton(){
        javascript.executeScript("arguments[0].click();",registrationFormRadioButton);
        //registrationFormRadioButton.click();
    }
    public void clickOnDecisionSignUpButton(){
//        for(int i=0;i<=6;i++) {
//            try {
//                javascript.executeScript("arguments[0].click();", registrationDecisionSubmitButton);
//                break;
//            } catch (StaleElementReferenceException staleEx) {
//                if(i==6){
//                    System.out.println("Stale Element Exception for SignUp Decision Button");
//                }
//            }
//        }
        registrationDecisionSubmitButton.click();
    }

    public void provideEmailToOnBoardNewUser(String email) throws InterruptedException {
        String b = Keys.BACK_SPACE.toString();
        String space =Keys.SPACE.toString();
        String tab_space =Keys.TAB.toString();
        actions.click(emailOnBoardTF).build().perform();
        Thread.sleep(1500);
        emailOnBoardTF.sendKeys(b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b);
        emailOnBoardTF.sendKeys(email+space+b+tab_space);
        actions.click(onBoardCursorRefButton).build().perform();
    }

    public void enableTermsAndConditionsCheckBoxForOnBoardUser(){
        javascript.executeScript("arguments[0].click();",termsAndConditionsOfOnBoardCheckBox);
        //termsAndConditionsOfOnBoardCheckBox.click();
    }
    public void clickOnContinueButtonForWelcomeOnboard(){
        javascript.executeScript("arguments[0].click();",submitOnBoardButton);
        //submitOnBoardButton.click();
    }

    public void clickOnContinueButtonForVerifyIdentity(){
        javascript.executeScript("arguments[0].click();",continueButton);
        //continueButton.click();
    }

    public void clickOnTermsAndConditionsLinkOnWelcomeOnBoardPage(){
        javascript.executeScript("arguments[0].click();",termsAndConditionsHyperLink);
        //termsAndConditionsHyperLink.click();
    }


}
