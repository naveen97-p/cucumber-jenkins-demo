package Pages.Health;

import Configurations.Passcodes;
import Utilities.BrowserInstance;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HealthWelcomePage extends BrowserInstance {
    public String welcomeScreenXpath ="//*[text()='Lorem ipsum dolor sit amet, consectetur adipiscing elit. Eget sit justo, senectus tempor nec tellus consectetur. Accumsan aenean convallis aliquam vitae ac adipiscing.']";
    public String wellnessWelcomeScreenPageTitle="Wellness";
    //START:  ---------Title Verification-----------
    public String loginAsAPatient ="https://services.ciamsgo.com/wellness/login?role=patient";
    public String loginAsADoctor ="https://services.ciamsgo.com/wellness/login?role=doctor";
    public String loginAsAPartnerUser ="https://services.ciamsgo.com/wellness/login?role=partner";
    public String loginAsAPartnerAdmin ="https://services.ciamsgo.com/wellness/login?role=partner-admin";
    public String loginAsAnApplicationAdmin ="https://services.ciamsgo.com/wellness/login?role=admin";
    public String enrollPartnerRefXpath="//a[text()='Enroll Partner']";
    public String applicationAdminXpath="//*[text()='Application Admin']";
    public String partnerAdminXpath="//*[text()='Partner Admin']";
    public String partnerUserXpath="//*[text()='Partner User']";
    public String patientXpath="//*[text()='Patient']";
    public String doctorXpath="//*[text()='Doctor']";
    public String haveARegistrationCodeParaXpath ="//*[text()='Have a Registration Code?']/following::p[text()='If you have been provided a registration code by your Client Admin, enter the code below:']";
    public String onBoardAPartnerRegistrationXpath="//*[text()='Onboard a Partner']/following::p[text()='Enter the information to enroll your organization as a partner']";
    public String healthCarePortalDropDownOptionXpath="//*[@data-value='Healthcare']";
    public String onboardAPartnerRequestSubmitInfoXpath="//p[text()='Your request has been submitted for review. You will receive a response shortly.']";
    //END  :  ---------Title Verification-----------

    //Page Factory Objects
    @FindBy(xpath = "//a[text()='Enroll Partner']")
    WebElement enrolPartnerButton;

    @FindBy(xpath = "//*[text()='Login']")
    WebElement loginButton;

    @FindBy(xpath = "//*[text()='Patient']")
    WebElement patientLoginButton;

    @FindBy(xpath = "//*[text()='Doctor']")
    WebElement doctorLoginButton;

    @FindBy(xpath = "//*[text()='Partner User']")
    WebElement partnerUserLoginButton;

    @FindBy(xpath = "//*[text()='Partner Admin']")
    WebElement partnerAdminLoginButton;

    @FindBy(xpath = "//*[text()='Application Admin']")
    WebElement applicationAdminLoginButton;

    @FindBy(xpath = "//*[text()='Pay My Bill']")
    WebElement payMyBillButton;


    @FindBy(xpath = "//input[@placeholder='Enter the registration code']")
    WebElement registerCodeInputField;

    @FindBy(xpath = "//button[text()='Continue']")
    WebElement continueButtonForRegCodeButton;

//Partner On Board Admin User
    @FindBy(xpath = "//input[@name='organization.name']")
    WebElement orgName;
    //*[text()='Organization information']/following::input[1]
    @FindBy(xpath = "//input[@name='organization.address']")
    WebElement orgAddress;
    //*[text()='Organization information']/following::input[2]

    @FindBy(xpath = "//input[@name='userName']")
    WebElement adminUserNameTextField;
    //*[text()='Admin Information']/following::input[1]
    @FindBy(xpath = "//input[@name='firstName']")
    WebElement adminFirstNameTextField;
    //*[text()='Admin Information']/following::input[2]
    @FindBy(xpath = "//input[@name='lastName']")
    WebElement adminLastNameTextField;
    //*[text()='Admin Information']/following::input[3]
    @FindBy(xpath = "//input[@name='email']")
    WebElement adminEmailTextField;
    //input[@type='email']

    @FindBy(xpath = "//input[@name='telephoneNumber']")
    WebElement adminMobileTextField;
    //input[@type='phone']


    @FindBy(xpath = "//*[text()='Select a portal']/following::*[@id='portal']")
    WebElement selectAPortal;
    //*[text()='Select a portal']/following::*[text()='HealthCare']

    @FindBy(xpath = "//*[@data-value='Healthcare']")
    WebElement healthCarePortalLink;
    //*[@data-value='sirona' and text()='HealthCare']


    @FindBy(xpath = "//*[text()='Submit']")
    WebElement submitOnBoardRequestButton;



     /*
    @FindBy(xpath = "aaaaaaaaa")
    WebElement aaaa;
    */

    public HealthWelcomePage(){
        PageFactory.initElements(driver, this);
    }//Constructor

    public void enterRegisterCode(){registerCodeInputField.clear();registerCodeInputField.sendKeys(Passcodes.WELLNESS_REG_CODE);}
    public void clickOnCodeSubmitButton(){continueButtonForRegCodeButton.click();}

    public void enterOrgName(String orgNameInp){orgName.clear();orgName.sendKeys(orgNameInp);}
    public void enterOrgAddress(String orgAddressInp){orgAddress.clear();orgAddress.sendKeys(orgAddressInp);}
    public void enterAdminUserName(String adminUserName){adminUserNameTextField.clear();adminUserNameTextField.sendKeys(adminUserName);}
    public void enterAdminFirstName(String firstName){adminFirstNameTextField.clear();adminFirstNameTextField.sendKeys(firstName);}
    public void enterAdminLastName(String lastName){adminLastNameTextField.clear();adminLastNameTextField.sendKeys(lastName);}
    public void enterAdminEmail(String email){adminEmailTextField.clear();adminEmailTextField.sendKeys(email);}
    public void enterAdminTelephoneNumber(String telephoneNumber){adminMobileTextField.clear();adminMobileTextField.sendKeys(telephoneNumber);}

    public void clickOnSelectAPortal(){selectAPortal.click();}
    public void selectHealthCareOption(){healthCarePortalLink.click();}
    public void clickOnSubmitOnBoardRequestButton(){submitOnBoardRequestButton.click();}
    public void clickOnEnrolPartnerButton(){
        javascript.executeScript("arguments[0].click();", enrolPartnerButton);
       // enrolPartnerButton.click();
        }
    public void clickOnLoginButton(){
        actions.click(loginButton).build().perform();
        // loginButton.click();
    }
    public void clickOnPayMyBillButton(){payMyBillButton.click();}
    public void clickOnPatientLoginButton(){
        actions.click(patientLoginButton).build().perform();
       // patientLoginButton.click();
    }
    public void clickOnDoctorLoginButton(){
        actions.click(doctorLoginButton).build().perform();
       // doctorLoginButton.click();
    }
    public void clickOnPartnerAdminLoginButton(){
        actions.click(partnerAdminLoginButton).build().perform();
       // partnerAdminLoginButton.click();
    }
    public void clickOnApplicationAdminLoginButton(){
      //  actions.click(applicationAdminLoginButton).build().perform();
        applicationAdminLoginButton.click();
    }
    public void clickOnPartnerUserLoginButton(){
        actions.click(partnerUserLoginButton).build().perform();
        //partnerUserLoginButton.click();
    }

}
