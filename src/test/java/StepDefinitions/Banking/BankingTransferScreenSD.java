package StepDefinitions.Banking;

import Utilities.BrowserInstance;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class BankingTransferScreenSD extends BrowserInstance {

    private Scenario scenario;

    public void prepareFailureEvidence(String errorMessage){
        scenario.attach(captureScreen.takeScreenShot(),"image/png",errorMessage);
    }

    @Before
    public void beforeTest(Scenario scenario){
        this.scenario = scenario;
    }

    @After
    public void testScenarioCondition(){
        if (scenario.isFailed()){
            prepareFailureEvidence("Above scenario has been failed. Ref: Attachment");
            scenario.log("PageURL: "+driver.getCurrentUrl());
            scenario.log("Terminated the browser as a failure noticed in above scenario");
            driver.quit();
        }

    }

    @Then("User clicks on In-House Transfer category")
    public void userClicksOnInHouseTransferCategory() {
        waitUtil.elementToBeLocated(bankingTransfersPage.transferPageRefXpath, 30);
        scenario.log("User has landed on Transfer Money Screen");
        bankingTransfersPage.clickOnInHouseTransferLink();
        scenario.log("User has clicked on In-House Transfers link");
        waitUtil.elementToBeLocated(bankingTransfersPage.inHouseTransferInfoTextBoxXpath, 30);
        bankingTransfersPage.clickOnGetStartedInHouseTransfers();
        waitUtil.elementToBeLocated(bankingTransfersPage.startTransferInHouseRefXpath);
        scenario.log("User has landed on In-House AddAccount and Start Transfer section");
        
    }


    @Given("User provides the details like {string}, {string}, {string} to start transfer and confirm")
    public void userProvidesTheDetailsLikeToStartTransferAndConfirm(String transferToDetails, String selectAccountDetails, String amountDetails) {
        waitUtil.elementToBeLocated(bankingTransfersPage.startTransferInHouseRefXpath);
        bankingTransfersPage.enterTransferToDetailsInHouseTransferType(transferToDetails);
        scenario.log("User has provided Transfer to Details");
        bankingTransfersPage.enterSelectAccountDetailsInHouseTransferType(selectAccountDetails);
        scenario.log("User has provided Select Account Details");
        bankingTransfersPage.enterAmountDetailsInHouseTransferType(amountDetails);
        scenario.log("User has provided Amount Details");
        bankingTransfersPage.clickOnConfirmButtonOfInHouseTransferType();
        scenario.log("User has clicked on Confirm button for Transfer In house");
        
    }

    @Given("User provides the details like {string}, {string}, {string} to add new account to transfer money and confirm")
    public void userProvidesTheDetailsLikeToAddNewAccountToTransferMoneyAndConfirm(String addNewAccountDetails, String accountNicknameDetails, String oneTimeCodeDetails) {

        waitUtil.elementToBeLocated(bankingTransfersPage.addAccountInHouseRefXpath);
        bankingTransfersPage.enterAddNewAccountDetailsInHouseAddAccountType(addNewAccountDetails);
        scenario.log("User has provided Transfer to Details");
        bankingTransfersPage.enterAccountNicknameDetailsInHouseAddAccountType(accountNicknameDetails);
        scenario.log("User has provided Select Account Details");
        bankingTransfersPage.enterOneTimeCodeDetailsInHouseAddAccountType(oneTimeCodeDetails);
        scenario.log("User has provided Amount Details");
        bankingTransfersPage.clickOnAddAccountButtonOfInHouseAddAccountType();
        scenario.log("User has clicked Add Account button");
    }

    @Then("User clicks on To or From-accounts-at-other-banks Transfer category")
    public void userClicksOnToFromAccountsAtOtherBanksTransferCategory() {
        waitUtil.elementToBeLocated(bankingTransfersPage.transferPageRefXpath, 30);
        scenario.log("User has landed on Transfer Money Screen");
        bankingTransfersPage.clickOnToOrFromAccountAtOtherBanksTransferLink();
        scenario.log("User has clicked on On/Two Accounts AT the Other Banks Transfer Link");
    }

    @Then("User selects IN THE US options")
    public void userSelectsINTHEUSOptions() {
        waitUtil.elementToBeLocated(bankingTransfersPage.transferPageRefXpath, 30);
        scenario.log("User has landed on Transfer Money Screen");
        waitUtil.elementToBeLocated(bankingTransfersPage.inTheUSXpath,30);
        bankingTransfersPage.clickOnInTheUSButton();
        scenario.log("User has clicked on >In the U.S.< button");
    }

    @Then("User selects OUTSIDE THE US options")
    public void userSelectsOUTSIDETHEUSOptions() {
        waitUtil.elementToBeLocated(bankingTransfersPage.transferPageRefXpath, 30);
        scenario.log("User has landed on Transfer Money Screen");
        waitUtil.elementToBeLocated(bankingTransfersPage.outsideTheUSXpath,30);
        bankingTransfersPage.clickOnOutsideTheUSButton();
        scenario.log("User has clicked on >Outside the U.S.< button");
    }

    @And("User verifies all types of transfer modes for IN THE US category")
    public void userVerifiesAllTypesOfTransferModesForINTHEUSCategory() {
        waitUtil.elementToBeLocated(bankingTransfersPage.threeDaysTransferRefBoxUI, 30);
        scenario.log("3-Days Transfer Box UI text has been verified");
        waitUtil.elementToBeLocated(bankingTransfersPage.twentyFourTransferRefBoxUI, 30);
        scenario.log("24 hour Transfer Box UI text has been verified");
        waitUtil.elementToBeLocated(bankingTransfersPage.wireTransferRefBoxUI, 30);
        scenario.log("Wire Transfer Box UI text has been verified");

    }

    @Given("User provides the details like {string}, {string}, {string} to all types of transfer and confirm for all")
    public void userProvidesTheDetailsLikeToAllTypesOfTransferAndConfirmForAll(String transferToDetails, String selectAccountDetails, String amountDetails) {
        bankingTransfersPage.clickOn3DaysTransferButton();
        waitUtil.elementToBeLocated(bankingTransfersPage.threeDaysTransferDetailsXpath);
        scenario.log("3 Days Transfer Details Header is appeared");
        bankingTransfersPage.enterSelectAccountDetailsInHouseTransferType(selectAccountDetails);
        scenario.log("User has provided Select Account Details");
        bankingTransfersPage.enterTransferToDetailsInHouseTransferType(transferToDetails);
        scenario.log("User has provided Transfer to Details");
        bankingTransfersPage.enterAmountDetailsInHouseTransferType(amountDetails);
        scenario.log("User has provided Amount Details");
        bankingTransfersPage.clickOnConfirmButtonForOutsideTheUS();
        scenario.log("User has clicked on Confirm button for Transfer In house");


        bankingTransfersPage.clickOn24DaysTransferButton();
        waitUtil.elementToBeLocated(bankingTransfersPage.twentyFourDaysTransferDetailsXpath);
        scenario.log("24 Hour Transfer Details Header is appeared");
        bankingTransfersPage.enterSelectAccountDetailsInHouseTransferType(selectAccountDetails);
        scenario.log("User has provided Select Account Details");
        bankingTransfersPage.enterTransferToDetailsInHouseTransferType(transferToDetails);
        scenario.log("User has provided Transfer to Details");
        bankingTransfersPage.enterAmountDetailsInHouseTransferType(amountDetails);
        scenario.log("User has provided Amount Details");
        bankingTransfersPage.clickOnConfirmButtonForOutsideTheUS();
        scenario.log("User has clicked on Confirm button for Transfer In house");


        bankingTransfersPage.clickOnWireTransferButton();
        waitUtil.elementToBeLocated(bankingTransfersPage.wireTransferDetailsXpath);
        scenario.log("Wire Transfer Details Header is appeared");
        bankingTransfersPage.enterSelectAccountDetailsInHouseTransferType(selectAccountDetails);
        scenario.log("User has provided Select Account Details");
        bankingTransfersPage.enterTransferToDetailsInHouseTransferType(transferToDetails);
        scenario.log("User has provided Transfer to Details");
        bankingTransfersPage.enterAmountDetailsInHouseTransferType(amountDetails);
        scenario.log("User has provided Amount Details");
        bankingTransfersPage.clickOnConfirmButtonForOutsideTheUS();
        scenario.log("User has clicked on Confirm button for Transfer In house");


        waitUtil.elementToBeLocated(bankingTransfersPage.backButtonXpath,30);
        bankingTransfersPage.clickOnBackButton();
        scenario.log("User has clicked on back button");
        waitUtil.elementToBeLocated(bankingTransfersPage.inTheUSXpath,30);
        scenario.log("User has landed on InTheUS and OutsideTheUS page");

    }

    @Given("User provides the details like {string}, {string}, {string}, {string}, {string} to wiring instructions and confirm")
    public void userProvidesTheDetailsLikeToWiringInstructionsAndConfirm(String accountHolderName, String routingNumber, String wireNumber, String countryName, String amount) {
        waitUtil.elementToBeLocated(bankingTransfersPage.enterWiringInstructionDetailsXpath,30);
        scenario.log("User has landed on Wiring Instruction details");
        bankingTransfersPage.enterAccountHolderNameDetails(accountHolderName);
        scenario.log("User has entered account holder details");
        bankingTransfersPage.enterRoutingNumberDetails(routingNumber);
        scenario.log("User has entered routing number details");
        bankingTransfersPage.enterWireNumberDetails(wireNumber);
        scenario.log("User has entered Wire Number details");
        bankingTransfersPage.enterCountryDetails(countryName);
        scenario.log("User has entered Country details");
        bankingTransfersPage.enterAmountDetails(amount);
        scenario.log("User has entered amount");
        bankingTransfersPage.clickOnConfirmButtonForOutsideTheUS();
        scenario.log("User has clicked on confirm button");
        waitUtil.elementToBeLocated(bankingTransfersPage.backButtonXpath,30);
        bankingTransfersPage.clickOnBackButton();
        scenario.log("User has clicked on back button");
        waitUtil.elementToBeLocated(bankingTransfersPage.outsideTheUSXpath,30);
        scenario.log("User has landed on InTheUS and OutsideTheUS page");
    }

    @Then("User clicks on To-Someone-else Transfer category")
    public void userClicksOnToSomeoneElseTransferCategory() {
        waitUtil.elementToBeLocated(bankingTransfersPage.toSomeoneElseLinkXpath, 30);
        scenario.log("User has landed on Transfer Money Screen");
        bankingTransfersPage.clickOnToSomeoneElseLink();
        scenario.log("User has clicked on To-Someone-Else Transfer Link");
    }

    @Given("User provides the details like {string}, {string}, {string}, {string}, {string} to transfer to Business or Organization and confirm")
    public void userProvidesTheDetailsLikeToTransferToBusinessOrOrganizationAndConfirm(String accountHolderName, String routingNumber, String wireNumber, String countryName, String amount) {
        waitUtil.elementToBeLocated(bankingTransfersPage.transferToABusinessOrOrganizationXpath,30);
        scenario.log("User has landed on Transfer To Business or Organization Section");
        bankingTransfersPage.enterAccountHolderNameDetails(accountHolderName);
        scenario.log("User has entered account holder details");
        bankingTransfersPage.enterRoutingNumberDetails(routingNumber);
        scenario.log("User has entered routing number details");
        bankingTransfersPage.enterWireNumberDetails(wireNumber);
        scenario.log("User has entered Wire Number details");
        bankingTransfersPage.enterCountryDetails(countryName);
        scenario.log("User has entered Country details");
        bankingTransfersPage.enterAmountDetails(amount);
        scenario.log("User has entered amount");
        bankingTransfersPage.clickOnConfirmButtonForOutsideTheUS();
        scenario.log("User has clicked on confirm button");


    }


}
