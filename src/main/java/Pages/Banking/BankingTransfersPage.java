package Pages.Banking;

import Utilities.BrowserInstance;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BankingTransfersPage extends BrowserInstance {
    public String transferPageRefXpath="//p[text()='I want to transfer money...']";
    public String inHouseTransferInfoTextBoxXpath="//p[text()='I want to transfer money...']//following::*[text()='Inhouse Transfers']//following::*[text()='Send or Receive money within Bank accounts instantly']";
    public String startTransferInHouseRefXpath="//p[text()='Enter below details and start transfer']";
    public String addAccountInHouseRefXpath="//p[text()='Enter below details and start transfer']";
    public String inTheUSXpath="//p[text()='In the U.S.']";
    public String outsideTheUSXpath="//p[text()='Outside the U.S.']";

    //To Someone Else
    public String toSomeoneElseLinkXpath="//*[text()='To Someone else']";


    public String threeDaysTransferRefBoxUI="//p[text()='3-day transfer']//following::*[text()='Regular transfers between banks usually take 48-72 hrs to transfer out of network']";
    public String twentyFourTransferRefBoxUI="//p[text()='24 hour transfer']//following::*[text()='Take care of your emergency needs and transfer with a small transaction fees']";
    public String wireTransferRefBoxUI="//p[text()='Wire trasnfer']//following::*[text()='Transfer to people or network in a sacure manner']";


    public String threeDaysTransferDetailsXpath="//p[text()='3 Day Transfer Details']";
    public String twentyFourDaysTransferDetailsXpath="//p[text()='Enter Details to transfer']";
    public String wireTransferDetailsXpath="//p[text()='Wire Trasnfer Details']";

    public String backButtonXpath="//p[text()='back']";

    public String enterWiringInstructionDetailsXpath="//p[text()='Enter Wiring Instructions below']";
    public String transferToABusinessOrOrganizationXpath="//p[text()='Transfer to a business or Organization']";




    @FindBy(xpath = "//p[text()='I want to transfer money...']")
    WebElement cursorRefForTransferInHouse;

    @FindBy(xpath = "//p[text()='I want to transfer money...']//following::*[text()='Inhouse Transfers']")
    WebElement inHouseTransferLink;
    @FindBy(xpath = "//p[text()='I want to transfer money...']//following::*[text()='To/from accounts at other banks']")
    WebElement toOrFromAccountsAtOtherBanksTransferLink;
    @FindBy(xpath = "//p[text()='I want to transfer money...']//following::*[text()='To Someone else']")
    WebElement toSomeoneElseTransferLink;
    @FindBy(xpath = "//p[text()='We provide our customers with lightning quick transfers keeping your safety and security as a priority.']//following::*[text()='Get Started']")
    WebElement getStartedForInHouseTransferButton;

    //Start Transfer-In House
    @FindBy(xpath = "//label[text()='Transfer To']//following::input[1]")
    WebElement transferToInHouseTransferTF;
    @FindBy(xpath = "//label[text()='Select Account']//following::input[1]")
    WebElement selectAccountInHouseTransferTF;
    @FindBy(xpath = "//label[text()='Amount']//following::input[1]")
    WebElement amountInHouseTransferTF;
    @FindBy(xpath = "//p[text()='Enter below details and start transfer']//following::button[text()='Confirm']")
    WebElement confirmInHouseTransferButton;

    //Add Account-IN House
    @FindBy(xpath = "//label[text()='Add New Account']//following::input[1]")
    WebElement addNewAccountInHouseAddAccTF;
    @FindBy(xpath = "//label[text()='Account Nickname']//following::input[1]")
    WebElement accountNickNameInHouseAddAccTF;
    @FindBy(xpath = "//label[text()='One Time Code']//following::input[1]")
    WebElement oneTimeCodeInHouseAddAccTF;
    @FindBy(xpath = "//p[text()='Add new account to transfer money']//following::button[text()='Add Account']")
    WebElement AddAccInHouseAddAccountTFButton;

    //To/From Accounts at Other Banks
    @FindBy(xpath = "//p[text()='In the U.S.']")
    WebElement inTheUSButton;
    @FindBy(xpath = "//p[text()='Outside the U.S.']")
    WebElement outsideUSButton;

    @FindBy(xpath = "//p[text()='3-day transfer']")
    WebElement threeDaysTransferButton;
    @FindBy(xpath = "//p[text()='24 hour transfer']")
    WebElement twentyFourDaysTransferButton;
    @FindBy(xpath = "//p[text()='Wire trasnfer']")
    WebElement wireTransferButton;

    @FindBy(xpath = "//p[text()='back']")
    WebElement backButton;

    //Outside US Transfer Text Fields
    @FindBy(xpath = "//label[text()='Account Holder Name']//following::input[1]")
    WebElement accountHolderNameTF;
    @FindBy(xpath = "//label[text()='Routing Number']//following::input[1]")
    WebElement routingNumberTF;
    @FindBy(xpath = "//label[text()='Wire Number']//following::input[1]")
    WebElement wireNumberTF;
    @FindBy(xpath = "//label[text()='Country']//following::input[1]")
    WebElement countryTF;
    @FindBy(xpath = "//label[text()='Amount']//following::input[1]")
    WebElement amountTF;
    @FindBy(xpath = "//button[text()='Confirm']")
    WebElement confirmButtonForOusideTheUS;





    /*
    String b = Keys.BACK_SPACE.toString();
        String space =Keys.SPACE.toString();
        String tab_space =Keys.TAB.toString();
       lastNameTextField.sendKeys(b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b);
        lastNameTextField.sendKeys(lastName+space+b+tab_space);
        actions.click(cursorPlacementRef).build().perform();

    @FindBy(xpath = "aaaaaaaaa")
    WebElement aaaa;
    */

    public BankingTransfersPage(){
        PageFactory.initElements(driver, this);
    }

    //Transfer Types
    public void clickOnInHouseTransferLink(){inHouseTransferLink.click();}
    public void clickOnToOrFromAccountAtOtherBanksTransferLink(){toOrFromAccountsAtOtherBanksTransferLink.click();}
    public void clickOnToSomeoneElseLink(){toSomeoneElseTransferLink.click();}

    public void clickOnGetStartedInHouseTransfers(){getStartedForInHouseTransferButton.click();}

    //Start Transfer-In House
    public void enterTransferToDetailsInHouseTransferType(String transferToDetails){
        String b = Keys.BACK_SPACE.toString();
        String space = Keys.SPACE.toString();
        String tab_space =Keys.TAB.toString();
        transferToInHouseTransferTF.sendKeys(b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b);
        transferToInHouseTransferTF.sendKeys(transferToDetails+space+b+tab_space);
        actions.click(cursorRefForTransferInHouse).build().perform();
    }
    public void enterSelectAccountDetailsInHouseTransferType(String selectAccountDetails){
        String b = Keys.BACK_SPACE.toString();
        String space = Keys.SPACE.toString();
        String tab_space =Keys.TAB.toString();
        selectAccountInHouseTransferTF.sendKeys(b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b);
        selectAccountInHouseTransferTF.sendKeys(selectAccountDetails+space+b+tab_space);
        actions.click(cursorRefForTransferInHouse).build().perform();
    }
    public void enterAmountDetailsInHouseTransferType(String amountDetails){
        String b = Keys.BACK_SPACE.toString();
        String space = Keys.SPACE.toString();
        String tab_space =Keys.TAB.toString();
        amountInHouseTransferTF.sendKeys(b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b);
        amountInHouseTransferTF.sendKeys(amountDetails+space+b+tab_space);
        actions.click(cursorRefForTransferInHouse).build().perform();
    }
    public void clickOnConfirmButtonOfInHouseTransferType(){confirmInHouseTransferButton.click();}


    //Add Account-IN House
    public void enterAddNewAccountDetailsInHouseAddAccountType(String addAccountDetails){
        String b = Keys.BACK_SPACE.toString();
        String space = Keys.SPACE.toString();
        String tab_space =Keys.TAB.toString();
        addNewAccountInHouseAddAccTF.sendKeys(b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b);
        addNewAccountInHouseAddAccTF.sendKeys(addAccountDetails+space+b+tab_space);
        actions.click(cursorRefForTransferInHouse).build().perform();
    }
    public void enterAccountNicknameDetailsInHouseAddAccountType(String accountNicknameDetails){
        String b = Keys.BACK_SPACE.toString();
        String space = Keys.SPACE.toString();
        String tab_space =Keys.TAB.toString();
        accountNickNameInHouseAddAccTF.sendKeys(b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b);
        accountNickNameInHouseAddAccTF.sendKeys(accountNicknameDetails+space+b+tab_space);
        actions.click(cursorRefForTransferInHouse).build().perform();
    }
    public void enterOneTimeCodeDetailsInHouseAddAccountType(String oneTimeCodeDetails){
        String b = Keys.BACK_SPACE.toString();
        String space = Keys.SPACE.toString();
        String tab_space =Keys.TAB.toString();
        oneTimeCodeInHouseAddAccTF.sendKeys(b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b);
        oneTimeCodeInHouseAddAccTF.sendKeys(oneTimeCodeDetails+space+b+tab_space);
        actions.click(cursorRefForTransferInHouse).build().perform();
    }
    public void clickOnAddAccountButtonOfInHouseAddAccountType(){AddAccInHouseAddAccountTFButton.click();}

    //To/From Accounts at other banks
    public void clickOnInTheUSButton(){inTheUSButton.click();}
    public void clickOnOutsideTheUSButton(){outsideUSButton.click();}

    public void clickOn3DaysTransferButton(){threeDaysTransferButton.click();}
    public void clickOn24DaysTransferButton(){twentyFourDaysTransferButton.click();}
    public void clickOnWireTransferButton(){wireTransferButton.click();}
    public void clickOnBackButton(){backButton.click();}


    //Outside the US Transfer Fields
    public void enterAccountHolderNameDetails(String accountHolderName){
        String b = Keys.BACK_SPACE.toString();
        String space = Keys.SPACE.toString();
        String tab_space =Keys.TAB.toString();
        accountHolderNameTF.sendKeys(b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b);
        accountHolderNameTF.sendKeys(accountHolderName+space+b+tab_space);
        actions.click(cursorRefForTransferInHouse).build().perform();
    }
    public void enterRoutingNumberDetails(String routingNumber){
        String b = Keys.BACK_SPACE.toString();
        String space = Keys.SPACE.toString();
        String tab_space =Keys.TAB.toString();
        routingNumberTF.sendKeys(b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b);
        routingNumberTF.sendKeys(routingNumber+space+b+tab_space);
        actions.click(cursorRefForTransferInHouse).build().perform();

    }
    public void enterWireNumberDetails(String wireNumber){
        String b = Keys.BACK_SPACE.toString();
        String space = Keys.SPACE.toString();
        String tab_space =Keys.TAB.toString();
        wireNumberTF.sendKeys(b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b);
        wireNumberTF.sendKeys(wireNumber+space+b+tab_space);
        actions.click(cursorRefForTransferInHouse).build().perform();

    }
    public void enterCountryDetails(String countryName){
        String b = Keys.BACK_SPACE.toString();
        String space = Keys.SPACE.toString();
        String tab_space =Keys.TAB.toString();
        countryTF.sendKeys(b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b);
        countryTF.sendKeys(countryName+space+b+tab_space);
        actions.click(cursorRefForTransferInHouse).build().perform();

    }
    public void enterAmountDetails(String amount){
        String b = Keys.BACK_SPACE.toString();
        String space = Keys.SPACE.toString();
        String tab_space =Keys.TAB.toString();
        amountTF.sendKeys(b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b+b);
        amountTF.sendKeys(amount+space+b+tab_space);
        actions.click(cursorRefForTransferInHouse).build().perform();

    }
    public void clickOnConfirmButtonForOutsideTheUS(){confirmButtonForOusideTheUS.click();}





}
