package Pages.Retail;

import Utilities.BrowserInstance;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RetailPrivacyWebFormPage extends BrowserInstance {
    JavascriptExecutor js = (JavascriptExecutor) driver;

    public String privacyWebFormRefXpath ="//*[text()='Welcome to the Retail Privacy Webform!']";
    public String privacyWebFormDevRefXpathNew="//*[text()='Welcome to Climb!']";
    public String privacyWebFormDevRefXpath ="//*[text()='Welcome to the Retail Privacy Webform!']";
    public String healthPrivacyFormXpathPara1 = "//*[text()='Welcome to the Wellness Privacy Webform!']";

    //Page Factory Objects
    @FindBy(xpath = "//*[text()=' Country ']/following::input[1]")
    WebElement countryInputField;

    @FindBy(xpath = "//*[text()=' Customer ']")
    WebElement iAmACustomerButton;

    @FindBy(xpath = "//*[text()=' Contractor ']")
    WebElement iAmAContractorButton;

    @FindBy(xpath = "//*[text()=' Employee ']")
    WebElement iAmAnEmployeeButton;

    @FindBy(xpath = "//*[text()=' State ']/following::input[1]")
    WebElement stateInputField;

    @FindBy(xpath = "//*[text()=' Info Request ']")
    WebElement reqTypeInfoRequestButton;

    @FindBy(xpath = "//*[text()=' Data Deletion ']")
    WebElement reqTypeDataDeletionButton;

    @FindBy(xpath = "//*[text()=' Do Not Sell My Information ']")
    WebElement reqTypeDoNottSellMyDataButton;

    @FindBy(xpath = "//*[text()=' First Name ']/following::input[1]")
    WebElement firstNameInputField;

    @FindBy(xpath = "//*[text()=' Last Name ']/following::input[1]")
    WebElement lastNameInputField;

    @FindBy(xpath = "//*[text()=' Email ']/following::input[1]")
    WebElement emailInputField;

    @FindBy(xpath = "//*[text()=' Loyalty ID ']/following::input[1]")
    WebElement loyaltyIdInputField;

    @FindBy(xpath = "//*[text()=' Request Details ']/following::textarea[1]")
    WebElement reqDetailsInputField;

    @FindBy(xpath = "//input[@type='file']")
    WebElement sendFilesHereInputField;

    @FindBy(xpath = "//*[text()=' Submit ']")
    WebElement submitButton;

     /*
    @FindBy(xpath = "aaaaaaaaa")
    WebElement aaaa;
    */

    public RetailPrivacyWebFormPage(){
        PageFactory.initElements(driver, this);
    }//Constructor
    public void enterCountryName(String countryName){countryInputField.clear(); countryInputField.sendKeys(countryName); }
    public void clickOnIAmACustomerButton(){iAmACustomerButton.click();}
    public void clickOnIAmAContractorButton(){iAmAContractorButton.click();}
    public void clickOnIAmAnEmployeeButton(){iAmAnEmployeeButton.click();}
    public void enterStateName(String stateName){stateInputField.clear();stateInputField.sendKeys(stateName);}
    public void selectReqTypeAsInfoRequestButton(){reqTypeInfoRequestButton.click();}
    public void selectReqTypeAsDataDeletionRequestButton(){reqTypeDataDeletionButton.click();}
    public void selectReqTypeAsDoNotSellMyDataRequestButton(){reqTypeDoNottSellMyDataButton.click();}
    public void enterFirstName(String firstName){firstNameInputField.clear(); firstNameInputField.sendKeys(firstName); }
    public String getFirstName(){
        return (String) js.executeScript("return arguments[0].value",firstNameInputField);}
    public void enterLastName(String lastName){lastNameInputField.clear(); lastNameInputField.sendKeys(lastName); }
    public String getLastName(){
        return (String) js.executeScript("return arguments[0].value",lastNameInputField);}
    public void enterEmail(String email){emailInputField.clear(); emailInputField.sendKeys(email); }
    public String getEmail(){
        return (String) js.executeScript("return arguments[0].value",emailInputField);}
    public void enterLoyaltyID(String loyaltyID){loyaltyIdInputField.clear(); loyaltyIdInputField.sendKeys(loyaltyID); }
    public void enterRequestDetails(String requestDetails){reqDetailsInputField.clear(); reqDetailsInputField.sendKeys(requestDetails); }
    public void uploadFiles(String filePath){sendFilesHereInputField.sendKeys(filePath); }
    public void clickOnSubmitButton(){submitButton.click();}

}
