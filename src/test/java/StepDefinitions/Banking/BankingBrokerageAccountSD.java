package StepDefinitions.Banking;

import Utilities.BrowserInstance;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class BankingBrokerageAccountSD extends BrowserInstance {
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

    @And("Verify all sections, services of Brokerage account of Banking App")
    public void verifyAllSectionsServicesOfBrokerageAccountOfBankingApp() {
        waitUtil.elementToBeLocated(bankingBrokerageAccountPage.brokerageAccountsSectionXpath);
        scenario.log("Accounts Section is Appeared");
        waitUtil.elementToBeLocated(bankingBrokerageAccountPage.brokerageSpendingSectionXpath);
        scenario.log("Spending's Section is Appeared");
        waitUtil.elementToBeLocated(bankingBrokerageAccountPage.brokerageFinancialGoalsSectionXpath);
        scenario.log("Financial Goals Section is Appeared");
        waitUtil.elementToBeLocated(bankingBrokerageAccountPage.brokerageInvestmentsSectionXpath);
        scenario.log("Investments Section is Appeared");

        //Click On All Services of Brokerage Account
        waitUtil.elementToBeLocated(bankingBrokerageAccountPage.addMoneyToYourAccountButtonAvailabilityXpath);
        bankingBrokerageAccountPage.clickOnAddMoneyToYourAccountButton();
        scenario.log("User is clicked on Add Money to Your Account button");
        bankingBrokerageAccountPage.clickOnInvestInStocksButton();
        scenario.log("User is clicked on Invest In Stocks button");
        bankingBrokerageAccountPage.clickOnInvestInMutualFundsButton();
        scenario.log("User is clicked on Invest Mutual Funds button");
        driver.navigate().refresh();

    }


    @Then("Verify the Brokerage Account should be created")
    public void verifyTheBrokerageAccountShouldBeCreated() {
        waitUtil.elementToBeLocated(bankingBrokerageAccountPage.brokerageAccountHeaderXpath);
        scenario.log("User is successfully created Brokerage Account");
    }

    @And("User agrees for T&C, and check the account subscription details")
    public void userAgreesForTCAndCheckTheAccountSubscriptionDetails() {
        waitUtil.elementToBeLocated(bankingBrokerageAccountPage.brokerageTermsAndConditionsHeaderXpath,30);
        scenario.log("User has landed on Brokerage Account T&C Page");
        waitUtil.elementToBeLocated(bankingBrokerageAccountPage.brokerageTermsAndConditionsContentHeaderXpath,30);
        scenario.log("Verified Text appearance on T&C Brokerage Account page");
        waitUtil.elementToBeLocated(bankingBrokerageAccountPage.brokerageBenefitsText_1_Xpath,30);
        scenario.log("Brokerage Account Benefit Text 1:Buy and sell stocks , Verified");
        waitUtil.elementToBeLocated(bankingBrokerageAccountPage.brokerageBenefitsText_2_Xpath,30);
        scenario.log("Brokerage Account Benefit Text 2:No minimum account balances , Verified");
        waitUtil.elementToBeLocated(bankingBrokerageAccountPage.brokerageBenefitsText_3_Xpath,30);
        scenario.log("Brokerage Account Benefit Text 3:Zero monthly service fees , Verified");

        bankingBrokerageAccountPage.clickOnBrokerageAccountAgreeButton();
        scenario.log("User has clicked on AGREE button for Brokerage T&C.");

    }

    @Then("User check the stepdefinition creation")
    public void userCheckTheStepdefinitionCreation() {

    }
}
