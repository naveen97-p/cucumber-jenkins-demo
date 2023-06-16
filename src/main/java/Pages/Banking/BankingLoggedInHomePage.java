package Pages.Banking;

import Utilities.BrowserInstance;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BankingLoggedInHomePage extends BrowserInstance {
    public String bankingDashboardPageUrl="https://services.ciamsgo.com/bank/profile/dashboard";
    public String bankingDashboardPageRefXpath="//*[text()='Refer Friends. Get Rewarded']//following::*[text()='Balance History']";
    public String profileOptionLink="//p[text()='Profile']";
    public String premiumCustomerTagRefXpath="//*[text()='Premium Member']";
    public String logoutButtonXpath="//button[text()='Logout']";

    @FindBy(xpath = "//p[text()='Dashboard']")
    WebElement dashboardLink;

    @FindBy(xpath = "//p[text()='Profile']")
    WebElement profileLink;

    @FindBy(xpath = "//p[text()='Payments']")
    WebElement paymentsLink;

    @FindBy(xpath = "//p[text()='Transfers']")
    WebElement transfersLink;

    @FindBy(xpath = "//p[text()='Brokerage Account']")
    WebElement brokerageAccountLink;

    @FindBy(xpath = "//p[text()='Passwordless Devices']")
    WebElement passwordlessDevicesLink;

    @FindBy(xpath = "//button[text()='Logout']")
    WebElement logoutButton;

    @FindBy(xpath = "//*[@data-testid='AccountCircleIcon']//parent::button")
    WebElement profileIconLink;


    /*
    @FindBy(xpath = "aaaaaaaaa")
    WebElement aaaa;
    */

    public void verifyLoggedInUserName(String firstname, String lastname){
        String loggedInUserXpath="//h4[text()='"+firstname+"' and text()='"+lastname+"']";
        waitUtil.elementToBeLocated(loggedInUserXpath,30);
    }
    public void verifyLoggedInUserName(String firstname){
        String loggedInUserXpath="//p[text()='Hi, ' and text()='"+firstname+"']";
        waitUtil.elementToBeLocated(loggedInUserXpath,30);
    }

    public BankingLoggedInHomePage(){
        PageFactory.initElements(driver, this);
    }
    public String getDashboardPageUrl(){return driver.getCurrentUrl();}

    //DashBoardLinks
    public void clickOnDashboardLink(){dashboardLink.click();}
    public void clickOnProfileLink(){profileLink.click();}
    public void clickOnPaymentsLink(){paymentsLink.click();}
    public void clickOnTransfersLink(){transfersLink.click();}
    public void clickOnBrokerageAccountLink(){brokerageAccountLink.click();}
    public void clickOnPasswordlessDevicesLink(){passwordlessDevicesLink.click();}

    //Header Items
    public void clickOnLogoutButton(){
        for(int i=0;i<=5;i++) {
            try {
                actions.click(logoutButton).build().perform();
            } catch (ElementNotInteractableException exe) {
                driver.navigate().refresh();
            }
        }
        //logoutButton.click();
        }
    public void clickOnProfileIconLink(){profileIconLink.click();}



}
