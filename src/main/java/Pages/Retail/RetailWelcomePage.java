package Pages.Retail;

import Utilities.BrowserInstance;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RetailWelcomePage extends BrowserInstance {

    public String logoutButtonXpath ="//*[text()='Logout']";
    //public String closePopUpIconXpath = "//*[@data-testid='CloseIcon']";
    public String closePopUpIconXpath = "//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeMedium css-1yxmbwk']";

   public String profileButtonXpath="//button[@aria-label='account']";
   public String doNotSellMyDataDSARLinkXpath="//a[text()='Do Not Sell My Data']";
   public String googleHomePageRefXpath="(//input[@type='submit' and @aria-label='Google Search'])[2]";
   public String signUpXpath="//*[text()='Sign Up']";


    //Page Factory Objects

    @FindBy(xpath = "//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeMedium css-1yxmbwk']")
    WebElement closePopUpScreen;


    @FindBy(xpath = "//*[text()='Login']")
    WebElement loginButton;


    @FindBy(xpath = "//*[text()='Sign Up']")
    WebElement signUpButton;


    @FindBy(xpath = "(//div[@class='MuiBox-root css-1k46eso']/p)[1]")
    WebElement userNameTextInWelcomeScreen;


    @FindBy(xpath = "//*[text()='Logout']")
    WebElement logOutButton;

    @FindBy(xpath = "//button[@aria-label='account']")
    WebElement profileButton;

    @FindBy(xpath = "//*[@type='email']")
    WebElement emailSubscribeInputField;

    @FindBy(xpath = "//*[@type='email']/following::*[text()='Subscribe']")
    WebElement subscribeButton;

    @FindBy(xpath = "//a[text()='Do Not Sell My Data']")
    WebElement doNotSellMyDataDSARLink;




    public RetailWelcomePage(){
        PageFactory.initElements(driver, this);
    }
    public void closeThePopUpWindow() {
        closePopUpScreen.click();
    }
    public void clickOnDSARlink() {
        doNotSellMyDataDSARLink.click();
    }

    public void clickOnLoginButton(){
        loginButton.click();

    }
    public void clickOnSignUpButton(){
        signUpButton.click();


    }
    public String getRetailerWelcomePageTitle(){return driver.getTitle();}
    public String getLoggedInUserNameFirstName() throws InterruptedException {
        waitUtil.elementToBeLocated("(//div[@class='MuiBox-root css-1k46eso']/p)[1]",110);
        Thread.sleep(2);
        return userNameTextInWelcomeScreen.getText();
    }
    public String getUsernameXpath(String username){
        return "//*[text()='"+username+"']";
    }
    public void enterEmailForSubscription(String email){
        emailSubscribeInputField.clear();
        emailSubscribeInputField.sendKeys(email);
    }
    public void clickOnSubscribeButton(){
        subscribeButton.click();
    }

    public void verifyTheLoginUserName(String usernameForXpathPreparation) throws InterruptedException {
        String loggedInUserNameXpath ="//*[text()='"+usernameForXpathPreparation+"']";
        waitUtil.elementToBeLocated("//*[text()='Dont Use First name']",25);
        Thread.sleep(2);
        driver.findElement(By.xpath(loggedInUserNameXpath)).click();
    }

    public void clickOnLogoutButton(){
        logOutButton.click();
    }
    public void clickOnProfileButton(){
        //actions.click(profileButton).build().perform();
        for(int i=0;i<=3;i++){
            try{
                profileButton.click();
                break;
            }
            catch (Exception ex){
                continue;
            }
        }
       // profileButton.click();
    }




}
