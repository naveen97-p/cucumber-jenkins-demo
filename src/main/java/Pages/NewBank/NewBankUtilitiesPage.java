package Pages.NewBank;

import Utilities.BrowserInstance;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class NewBankUtilitiesPage extends BrowserInstance {

        //START:  ---------Title Verification-----------
        public String servicePaymentsScreenRefXpath ="//*[text()='Service Payments']//following::*[text()=\"Select a service to initiate payment\"]";
        public String utilitiesPageUrl="https://bank.ciam.sandbox.ciamsgo.com/profile/payments";
        public String qrCodeTextVerificationTextRefXpath="//*[contains(text(),\"Scan this QR Code with your mobile phone and follow the instructions.\")]//following::*[contains(text(),\"Check that your phone shows the same Verification code as below:\")]//following::*[contains(text(),\"Verification Code\")]";

    @FindBy(xpath = "//*[text()=\"Select a service to initiate payment\"]/following::select[1]")
    WebElement chooseAProviderSelectDrpDown;

    @FindBy(xpath = "//*[text()=\"Select a service to initiate payment\"]/following::select[2]")
    WebElement selectYouAccountDrpDown;

    @FindBy(xpath = "//*[text()=\"Select a service to initiate payment\"]/following::input[1]")
    WebElement amountToTransferTF;

    @FindBy(xpath = "//*[text()=\"Select a service to initiate payment\"]/following::button[1]")
    WebElement confirmPaymentButton;

    @FindBy(xpath = "//*[text()=\"Select a service to initiate payment\"]")
    WebElement cursorRestRef;

    @FindBy(xpath = "//*[contains(text(),\"Verification Code\")]/following::button[1]")
    WebElement verificationCodeText;


     /*
        @FindBy(xpath = "aaaaaaaaa")
        WebElement aaaa;
    */

    public NewBankUtilitiesPage(){
        PageFactory.initElements(driver, this);}

    public String getPageUrl(){return driver.getCurrentUrl();}


    public void selectAProviderDropDown(String listItem){
        Select dropDown = new Select(driver.findElement(By.xpath("//*[text()=\"Select a service to initiate payment\"]/following::select[1]")));
        dropDown.selectByVisibleText(listItem);
    }

    public void selectYourAccountDropDown(String listItem){
        Select dropDown = new Select(driver.findElement(By.xpath("//*[text()=\"Select a service to initiate payment\"]/following::select[2]")));
        dropDown.selectByVisibleText(listItem);
    }

    public void enterAmountToTransfer(String amount){
        String b = Keys.BACK_SPACE.toString();
        String space =Keys.SPACE.toString();
        String tab_space =Keys.TAB.toString();
        actions.click(amountToTransferTF).build().perform();
        amountToTransferTF.sendKeys(b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b);
        amountToTransferTF.sendKeys(amount+space+b+tab_space);
        actions.click(cursorRestRef).build().perform();
    }
    public void clickOnChooseAProviderDrpDwn(){
        //javascript.executeScript("arguments[0].click();",confirmPaymentButton);
        actions.click(chooseAProviderSelectDrpDown).build().perform();
    }
    public void clickOnSelectYourAccountDrpDwn(){
        //javascript.executeScript("arguments[0].click();",confirmPaymentButton);
        actions.click(selectYouAccountDrpDown).build().perform();
    }

    public void clickOnConfirmPayment(){
        //javascript.executeScript("arguments[0].click();",confirmPaymentButton);
        actions.click(confirmPaymentButton).build().perform();
    }

    public String getVerificationCode(){
        return verificationCodeText.getText();
    }




}
