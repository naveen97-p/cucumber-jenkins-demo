package StepDefinitions.Banking;

import Utilities.BrowserInstance;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class BankingLoggedInScreenSD extends BrowserInstance {
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

    @Given("User Should able to login with {string} approach and should land on Banking home page and pass firstname {string}, {string}")
    public void userShouldAbleToLoginWithApproachAndShouldLandOnBankingHomePageAndPassFirstname(String typeOfTesting, String expectedFirstname, String expectedLastname) throws Exception {
        if (typeOfTesting.equalsIgnoreCase("positive")){
           bankingLoggedInHomePage.verifyLoggedInUserName(expectedFirstname);
           scenario.log("User Firstname is appeared in the ProfileIcon section");
            bankingLoggedInHomePage.verifyLoggedInUserName(expectedFirstname, expectedLastname);
            scenario.log("Firstname and Lastname appeared as expected in ProfileOptions Section");

        }
        else{
            waitUtil.elementToBeLocated(bankingSignUpEmailPage.failedSignUpXpath,45);
            scenario.log("Something went wrong... User email is already existed in Database");
        }

    }

    @Given("User should able to login with {string} approach and should land on Banking home page and pass firstname {string}, {string} for Login")
    public void userShouldAbleToLoginWithApproachAndShouldLandOnBankingHomePageAndPassFirstnameLogin(String typeOfTesting, String expectedFirstname, String expectedLastname) throws Exception {
        if (typeOfTesting.equalsIgnoreCase("positive")){
            bankingLoggedInHomePage.verifyLoggedInUserName(expectedFirstname);
            scenario.log("User Firstname is appeared in the ProfileIcon section");
            bankingLoggedInHomePage.verifyLoggedInUserName(expectedFirstname, expectedLastname);
            scenario.log("Firstname and Lastname appeared as expected in ProfileOptions Section");

        }
        else{
            waitUtil.elementToBeLocated(bankingLoginPage.loginErrorMessageXpath,45);
            scenario.log("Failed to Register as the data is invalid...");
        }

    }

    @Then("User logs out from Banking app {string}")
    public void userLogsOutFromBankingApp(String typeOfTesting) throws InterruptedException {
        if (typeOfTesting.equalsIgnoreCase("positive")){
            Thread.sleep(3000);
            waitUtil.elementToBeLocated(bankingLoggedInHomePage.logoutButtonXpath,20);
            bankingLoggedInHomePage.clickOnLogoutButton();
            waitUtil.elementToBeLocated(bankingLoginPage.bankLoginScreenRef);
            scenario.log("User has logged-out from the banking app and landed on Login page by default");
        }
        else{
            scenario.log("Negative Test Case: Hence, script is skipping this line....");
        }
    }


    @And("User clicks on Profile link of bank app")
    public void userClicksOnProfileLinkOfBankApp() {
        waitUtil.elementToBeLocated(bankingLoggedInHomePage.profileOptionLink);
        bankingLoggedInHomePage.clickOnProfileLink();
        scenario.log("User has clicked on Profile details link");
    }
    @And("User clicks on Dashboard link of bank app")
    public void userClicksOnDashboardLinkOfBankApp() {
        waitUtil.elementToBeLocated(bankingLoggedInHomePage.bankingDashboardPageRefXpath);
        bankingLoggedInHomePage.clickOnDashboardLink();
        scenario.log("User has clicked on Dashboard details link");
    }

    @And("User clicks on Payments link of bank app")
    public void userClicksOnPaymentsLinkOfBankApp() {
        waitUtil.elementToBeLocated(bankingLoggedInHomePage.bankingDashboardPageRefXpath);
        bankingLoggedInHomePage.clickOnPaymentsLink();
        scenario.log("User has clicked on Payments details link");
    }

    @And("User clicks on Transfers link of bank app")
    public void userClicksOnTransfersLinkOfBankApp() {
        waitUtil.elementToBeLocated(bankingLoggedInHomePage.bankingDashboardPageRefXpath);
        bankingLoggedInHomePage.clickOnTransfersLink();
        scenario.log("User has clicked on Transfers details link");
    }
    @And("User clicks on Brokerage Account link of bank app")
    public void userClicksOnBrokerageAccLinkOfBankApp() {
        waitUtil.elementToBeLocated(bankingLoggedInHomePage.profileOptionLink);
        bankingLoggedInHomePage.clickOnBrokerageAccountLink();
        scenario.log("User has clicked on Brokerage Account details link");
    }
    @And("User clicks on Passwordless Devices link of bank app")
    public void userClicksOnPasswordLessDevicesLinkOfBankApp() {
        waitUtil.elementToBeLocated(bankingLoggedInHomePage.profileOptionLink);
        bankingLoggedInHomePage.clickOnPasswordlessDevicesLink();
        scenario.log("User has clicked on Passwordless Devices details link");
    }

    @Then("Verify Premium Customer tag should not be appeared for Normal Users of Banking app")
    public void verifyPremiumCustomerTagShouldNotBeAppearedForNormalUsersOfBankingApp() throws Exception {

        boolean premiumCustomerTagAvailability =false;
        try {
            waitUtil.elementToBeLocated(bankingLoggedInHomePage.premiumCustomerTagRefXpath, 10);
            scenario.log("Normal User should not be Premium Customer for Retail Application, please check the Test Data or Journey");
            premiumCustomerTagAvailability=true;
        }catch (Exception ex){
            scenario.log("Premium Customer tag isn't appeared for Normal User as Expected");
        }
        if(premiumCustomerTagAvailability) {
            throw new Exception("Platform is showing Normal User as Premium User in Profile details section, which is not expected");
        }
    }

    @Then("Verify Premium Customer tag should be appeared for Premium Users of Banking app")
    public void verifyPremiumCustomerTagShouldBeAppearedForPremiumUsersOfBankingApp() {
        waitUtil.elementToBeLocated(bankingLoggedInHomePage.premiumCustomerTagRefXpath, 40);
        scenario.log("Premium Customer Tag is appeared as expected...");
    }
}
