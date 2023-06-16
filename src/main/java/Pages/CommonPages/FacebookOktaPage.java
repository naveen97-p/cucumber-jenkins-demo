package Pages.CommonPages;

import Utilities.BrowserInstance;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FacebookOktaPage extends BrowserInstance {

    public String facebookEmailXpath = "//input[@id='email']";
    public String facebookPasswordXpath = "//input[@id='pass']";
    public String facebookProfileIconXpath = "//*[@aria-label='Your profile']";
    public String facebookLogoutXpath ="//*[text()='Log Out']";


    @FindBy(xpath = "//input[@id='email']")
    WebElement usernameField;


    @FindBy(xpath = "//input[@id='pass']")
    WebElement passwordField;


    @FindBy(xpath = "//button[@id='loginbutton']")
    WebElement loginButton;


    @FindBy(xpath = "//*[@aria-label='Your profile']")
    WebElement facebookProfileIcon;


    @FindBy(xpath = "//*[text()='Log Out']")
    WebElement logoutButton;



    public FacebookOktaPage(){
        PageFactory.initElements(driver, this);
    }

    public void enterFacebookEmailId(String username){
        usernameField.clear();
        usernameField.sendKeys(username);
    }
    public void enterFacebookPassword(String password){
        passwordField.sendKeys(password);
    }
    public void clickOnLoginButton( ){
        loginButton.click();
    }
    public void clickOnProfileIcon(){facebookProfileIcon.click();}
    public void clickOnLogoutButton( ){
        logoutButton.click();
    }

















}
