package Pages.NewBank;

import Utilities.BrowserInstance;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewBankTransferPage extends BrowserInstance {

        //START:  ---------Title Verification-----------
        public String transferScreenRef ="//*[text()='TRANSFER MONEY']/following::*[text()=\"Make a Payment\"]";
        public String transferPageUrl="https://bank.ciam.sandbox.ciamsgo.com/profile/transfers";
        public String sendMoneyHeaderRefXpath="//*[text()='Send Money']/following::*[text()=\"Safe and Secure Transaction!\"]";
        public String accountAccNumAndConfirmAccNumAreNotMatchedError="//*[text()=\"Account number and Confirm Account number do not match\"]";
        public String transactionRiskRefXpath="//*[text()='Transaction Risk Details']/following::button[1]";
        public String otpScreenRefXpath="//*[contains(text(),'Enter the passcode you received to complete email pairing.')]/following::button[2]";
        public String successMsg="//*[contains(text(),'Success')]/following::button[1]";

    @FindBy(xpath = "//*[text()='TRANSFER MONEY']/following::*[text()=\"Make a Payment\"]")
    WebElement makeAPaymentButton;

    @FindBy(xpath = "//*[text()='Send Money']/following::*[text()=\"Safe and Secure Transaction!\"]//following::input[1]")
    WebElement payeeNameTF;
    @FindBy(xpath = "//*[text()='Send Money']/following::*[text()=\"Safe and Secure Transaction!\"]//following::input[2]")
    WebElement payeeAccountNumberTF;
    @FindBy(xpath = "//*[text()='Send Money']/following::*[text()=\"Safe and Secure Transaction!\"]//following::input[3]")
    WebElement confirmAccountNumberTF;
    @FindBy(xpath = "//*[text()='Send Money']/following::*[text()=\"Safe and Secure Transaction!\"]//following::input[4]")
    WebElement amountToTransferTF;

    @FindBy(xpath = "//*[text()='Send Money']/following::*[text()=\"Safe and Secure Transaction!\"]//following::button[1]")
    WebElement confirmTransferButton;

    @FindBy(xpath = "//*[text()='Send Money']/following::*[text()=\"Safe and Secure Transaction!\"]")
    WebElement cursorRestRef;

    @FindBy(xpath = "//*[text()='Transaction Risk Details']/following::button[1]")
    WebElement transactionRiskContinueButton;



    @FindBy(xpath = "//*[contains(text(),'Enter the passcode you received to complete email pairing.')]/following::input[1]")
    WebElement passcodeTF;

    @FindBy(xpath = "//*[contains(text(),'Enter the passcode you received to complete email pairing.')]/following::button[2]")
    WebElement finishButton;

    @FindBy(xpath = "//*[contains(text(),'Enter the passcode you received to complete email pairing.')]")
    WebElement cursorRestRefOnOTP;

    @FindBy(xpath = "//*[contains(text(),'Success')]/following::button[1]")
    WebElement makeAnotherPaymentButton;









     /*
        @FindBy(xpath = "aaaaaaaaa")
        WebElement aaaa;
    */

    public NewBankTransferPage(){
        PageFactory.initElements(driver, this);
    }//Constructor
    public String getPageUrl(){return driver.getCurrentUrl();}

    public void clickOnMakeAPayment(){
        actions.click(makeAPaymentButton).build().perform();
        //javascript.executeScript("arguments[0].click();",makeAPaymentButton);
    }

    public void enterPayeeName(String payeeName){
        String b = Keys.BACK_SPACE.toString();
        String space =Keys.SPACE.toString();
        String tab_space =Keys.TAB.toString();
        actions.click(payeeNameTF).build().perform();
        payeeNameTF.sendKeys(b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b);
        payeeNameTF.sendKeys(payeeName+space+b+tab_space);
        actions.click(cursorRestRef).build().perform();
    }
    public void enterPayeeAccountNumber(String payeeAccountNumber){
        String b = Keys.BACK_SPACE.toString();
        String space =Keys.SPACE.toString();
        String tab_space =Keys.TAB.toString();
//        actions.click(payeeAccountNumberTF).build().perform();
        payeeAccountNumberTF.sendKeys(b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b);
        payeeAccountNumberTF.sendKeys(payeeAccountNumber+space+b+tab_space);
        actions.click(cursorRestRef).build().perform();
    }
    public void enterConfirmPayeeAccountNumber(String payeeAccountNumber){
        String b = Keys.BACK_SPACE.toString();
        String space =Keys.SPACE.toString();
        String tab_space =Keys.TAB.toString();
//        actions.click(confirmAccountNumberTF).build().perform();
        confirmAccountNumberTF.sendKeys(b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b);
        confirmAccountNumberTF.sendKeys(payeeAccountNumber+tab_space);
        actions.click(cursorRestRef).build().perform();
    }

    public void enterAmountToTransfer(String amountToTransfer){
        String b = Keys.BACK_SPACE.toString();
        String space =Keys.SPACE.toString();
        String tab_space =Keys.TAB.toString();
        actions.click(amountToTransferTF).build().perform();
        amountToTransferTF.sendKeys(b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b);
        amountToTransferTF.sendKeys(amountToTransfer+space+b+tab_space);
        actions.click(cursorRestRef).build().perform();
    }
    public void clickOnConfirmPayment(){
        actions.click(confirmTransferButton).build().perform();
        //javascript.executeScript("arguments[0].click();",confirmTransferButton);
    }

    public void clickOnTransactionButton(){
        actions.click(transactionRiskContinueButton).build().perform();
        //javascript.executeScript("arguments[0].click();",transactionRiskContinueButton);
    }

    public void enterPasscode(String passcode){
        String b = Keys.BACK_SPACE.toString();
        String space =Keys.SPACE.toString();
        String tab_space =Keys.TAB.toString();
        actions.click(passcodeTF).build().perform();
        passcodeTF.sendKeys(b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b);
        passcodeTF.sendKeys(passcode+tab_space);
        actions.click(cursorRestRefOnOTP).build().perform();
    }

    public void clickOnFinishButton(){
        actions.click(finishButton).build().perform();
        //javascript.executeScript("arguments[0].click();",finishButton);
    }

    public void clickOnMakeAnotherPayment(){
        actions.click(makeAnotherPaymentButton).build().perform();
        //javascript.executeScript("arguments[0].click();",makeAnotherPaymentButton);
    }






}
