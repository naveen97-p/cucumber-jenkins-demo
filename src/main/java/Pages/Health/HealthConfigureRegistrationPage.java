package Pages.Health;

import Utilities.BrowserInstance;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HealthConfigureRegistrationPage extends BrowserInstance {
    //START:  ---------Title Verification-----------
    public String wouldYouLikeToConfigureRefXpath ="//*[text()=\"Would you like to configure any of these now?\"]";
    //END  :  ---------Title Verification-----------

    @FindBy(xpath = "//*[text()=\"Email Me a One Time Passcode\"]")
    WebElement emailOneTimePasscodeButton;

    @FindBy(xpath = "//*[text()=\"Skip for now\"]")
    WebElement skipForNowButton;

    @FindBy(xpath = "//*[text()='Submit']")
    WebElement submitButton;

    public HealthConfigureRegistrationPage(){
        PageFactory.initElements(driver, this);
    }//Constructor
    public String getPageUrl(){return driver.getCurrentUrl();}
    public void clickOnEmailOneTimePasscodeButton(){emailOneTimePasscodeButton.click();}
    public void clickOnSkipForNow(){skipForNowButton.click();}
    public void clickOnSubmitButton(){submitButton.click();}

}
