package Pages.Banking;

import Utilities.BrowserInstance;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BankingBrokerageAccountPage extends BrowserInstance {

    public String brokerageTermsAndConditionsHeaderXpath="//*[text()='Brokerage Account']//following::*[text()='Terms and Conditions']";
    public String brokerageTermsAndConditionsContentHeaderXpath="//p[text()='Brokerage Account Subsciption will provide you additional offerings to your existing Construct account.You will now be able to enjoy the following benefits Allow us to have your consent before we make the change.']";
    public String brokerageBenefitsText_1_Xpath="//*[text()='Buy and sell stocks']";
    public String brokerageBenefitsText_2_Xpath="//*[text()='No minimum account balances']";
    public String brokerageBenefitsText_3_Xpath="//*[text()='Zero monthly service fees']";
    public String brokerageAccountHeaderXpath="//p[text()='Current Balance']";
    public String brokerageAccountBalanceTextVerificationXpath="//*[text()=\"Your brokerage account balance is: $50,000.00\"]";

    public String premiumCustomerTagRefXpath="//*[text()='Premium Member']";
    public String addMoneyToYourAccountButtonAvailabilityXpath="//button[text()=\"Add Money To Your Account\"]";

    public String brokerageAccountsSectionXpath="//p[text()=\"Accounts\"]";
    public String brokerageSpendingSectionXpath="//p[text()=\"Spending\"]";
    public String brokerageFinancialGoalsSectionXpath="//p[text()=\"Financial Goals\"]";
    public String brokerageInvestmentsSectionXpath="//p[text()=\"Investments\"]";

    @FindBy(xpath = "//button[text()=\"Add Money To Your Account\"]")
    WebElement addMoneyToYourAccountButton;
    @FindBy(xpath = "//button[text()=\"Invest in stocks\"]")
    WebElement investInStocksButton;
    @FindBy(xpath = "//button[text()=\"Invest in Mutual Funds\"]")
    WebElement investInMutualFundsButton;

    @FindBy(xpath = "//button[text()='Agree']")
    WebElement brokerageAccountAgreeButton;


    public BankingBrokerageAccountPage(){
        PageFactory.initElements(driver, this);
    }
    public void clickOnAddMoneyToYourAccountButton(){addMoneyToYourAccountButton.click();}
    public void clickOnInvestInStocksButton(){investInStocksButton.click();}
    public void clickOnInvestInMutualFundsButton(){investInMutualFundsButton.click();}

    public void clickOnBrokerageAccountAgreeButton(){brokerageAccountAgreeButton.click();}


}
