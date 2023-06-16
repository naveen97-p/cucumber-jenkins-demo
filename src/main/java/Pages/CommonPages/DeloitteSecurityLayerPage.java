package Pages.CommonPages;

import Utilities.BrowserInstance;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeloitteSecurityLayerPage extends BrowserInstance {

    public String accessThroughEntryTokenXpath ="//*[text()='Or Access Through Entry Token']";
    public String enterTokenXpath ="//*[@id='token']";


    //Page Factory Objects
    @FindBy(xpath = "//button[text()='Accept All Cookies']")
    WebElement acceptCookiesPolicy;


    @FindBy(xpath = "//*[text()='Or Access Through Entry Token']")
    WebElement accessThroughEntryToken;


    @FindBy(xpath = "//input[@id='token']")
    WebElement enterToken;


    @FindBy(xpath = "//button[text()='Submit']")
    WebElement submitButton;

    /*
    @FindBy(xpath = "aaa")
    WebElement aaaa;
    */

    //Constructor to load Driver
    public DeloitteSecurityLayerPage(){
            PageFactory.initElements(driver, this);
        }


    public void clickOnAcceptCookies(){
        acceptCookiesPolicy.click();
    }

    public void clickOnAccessThroughEntryToken(){
        accessThroughEntryToken.click();
    }

    public void enterAccessToken(String entryDummyToken){
        enterToken.sendKeys(entryDummyToken);
    }

    public void clickOnSubmitButton(){
        submitButton.click();
    }

}
