package Pages.CommonPages;

import Utilities.BrowserInstance;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CookiesPopUpPage extends BrowserInstance {

    //button[text()='Accept All Cookies']


    @FindBy(xpath = "//button[text()='Accept All Cookies']")
    WebElement acceptAllCookies;

    @FindBy(xpath = "(//button[@aria-label='Close'])[1]")
    WebElement closeCookiesPopUp;


    public CookiesPopUpPage(){
        PageFactory.initElements(driver, this);
    }

    public void clickOnAcceptAllCookies(){
        waitUtil.elementToBeClickable("//button[text()='Accept All Cookies']",80);
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();",acceptAllCookies);
    }

}
