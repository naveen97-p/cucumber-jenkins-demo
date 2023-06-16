package Pages.CommonPages;

import Utilities.BrowserInstance;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class GoogleOktaPage extends BrowserInstance {

    public String googleEmailXpath = "//input[@type='email']";
    public String googlePasswordXpath = "//input[@type='password']";

    @FindBy(xpath = "//input[@type='email']")
    WebElement usernameField;


    @FindBy(xpath = "//input[@type='password']")
    WebElement passwordField;


    @FindBy(xpath = "//span[text()='Next']")
    WebElement nextButton;


    public GoogleOktaPage(){
        PageFactory.initElements(driver, this);
    }

    public void enterGoogleUsername(String userName){
        usernameField.sendKeys(userName);
    }
    public void enterGooglePassword(String password){
        passwordField.sendKeys(password);
    }
    public void clickOnNextButton(){
        nextButton.click();
    }




}
