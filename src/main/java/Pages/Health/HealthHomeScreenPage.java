package Pages.Health;

import Configurations.Passcodes;
import Utilities.BrowserInstance;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HealthHomeScreenPage extends BrowserInstance {


    public String loginFailureXpath ="//*[text()='Authentication failed']";

    //START:  ---------Title Verification-----------
    public String partnerUserLoginPageTitle ="https://services.ciamsgo.com/wellness/my-portal/partner/home";
    public String partnerAdminLoginPageTitle ="https://services.ciamsgo.com/wellness/my-portal/partner-admin/home";
    public String patientLoginPageTitle ="https://services.ciamsgo.com/wellness/my-portal/patient-home";
    public String doctorLoginPageTitle ="https://services.ciamsgo.com/wellness/my-portal/doctor-home";
    public String applicationAdminLoginPageTitle ="https://services.ciamsgo.com/wellness/my-portal/admin/home";
    //END  :  ---------Title Verification-----------
    public String logoutArrowButton="//*[@class=\"MuiSvgIcon-root MuiSvgIcon-fontSizeMedium css-vubbuv\" and @data-testid=\"KeyboardArrowDownIcon\"]";
    public String logOutButtonRefXpath="//*[text()='Logout']";
    public String onboardAPartnerXpath="//*[text()='Onboard a User']";
    public String onboardAPartnerRefXpath="//*[text()='Partner User Registration']//following::*[text()='User Information']";
     public String profileIconXpath ="(//*[@data-testid='PersonIcon'])[1]";
    public String accountDetailsXpath="//h5[text()='Account']";
    public String detailsXpath="//*[text()='Details']";


    public String incorrectPhoneNumberXpath ="//p[text()='Incorrect Phone Number format']";
    public String mobileNumberXpath="//*[text()='Phone Number']/following::input[1]";
    public String changesSavedXpath="//*[text()='User Changes have been made. Click Ok to Continue']/following::button[1]";
    public String privacyAndConsentXpath="//*[text()='Privacy & Consent']";
    public String preferencesRefXpath="//*[text()='Preferences']";
    public String iframeXpath="//iframe";
    public String iframeBankPreferencesXpath="(//iframe)[1]";
    public String iframeBankPrivacyXpath="(//iframe)[2]";
    public String privacyAndConsentXpathPara1="//p[text()='Wellness uses data to offer you personal product information for optimal performance. To find out more details about how your information is being used, you can view our Privacy Policy.']";
    public String privacyAndConsentXpathPara2="//p[text()='For more detailed information about how your information is being used you may click on']/a[text()='this link']";
    public String manageRoleRefXpath="//*[text()='Managed Roles']";
    public String myDevicesefXpath="//*[text()='My Devices']";
    public String pushDeviceNotificationSectionXpath ="//*[text()='Push Notification Device']";
    public String barcodeImageText="//p[text()='Scan the barcode image below with the ForgeRock Authenticator app to register your device with your login.']";

    public String manageRoleFormHeaderXpath="//*[text()='NEW ROLE REQUEST']";
    public String requestRolesPageXpath="//*[text()='Request additional roles']";

    public String partnerAdminRoleTextXpath="//*[text()='partner-admin-role']/following::*[text()='Role given to all admins that are a part of a any organization']";
    public String portalDropDownXpath="//*[text()='Select a portal']/following::*[text()='HealthCare']";
    public String healthCareDrpDownXpath="//*[@data-value='sirona' and text()='HealthCare']";
    public String pushDeviceDrpDownXpath="//*[@class='MuiInputBase-root MuiFilledInput-root MuiFilledInput-underline MuiInputBase-colorPrimary MuiInputBase-formControl css-idlxa2']";
    public String submitDeRegisterPushDeviceXpath="//*[text()='Submit Request']";


    public String roleOption1Xpath="//ul[@role='listbox']/li[1]";
    public String roleOption2Xpath="//ul[@role='listbox']/li[2]";
    public String roleOption3Xpath="//ul[@role='listbox']/li[3]";
    public String roleOption4Xpath="//ul[@role='listbox']/li[4]";
    public String requestRoleSubmitXpath="//*[text()='Request additional roles']/following::textarea[1]";

    public String preferencesHeaderXpath="//*[text()=' Advertisement & Language Preferences ']";
    public String privacyHeaderXpath="//*[text()=' Consent Management ']";
    public String prefUndoChangesButton="//button[text()=' Undo Changes ']";

    public String prefChangeConsentXpath="//button[text()=' Change Consent ']";
    public String prefChangePreferencesXpath="//button[text()=' Change Preferences ']";

    //Page Factory Objects

    //Partner On Board Admin User

    @FindBy(xpath = "//*[text()='kep-staff-role']")
    WebElement roleOptionStaffRole;
    @FindBy(xpath = "//*[text()='kep-agent-role']")
    WebElement roleOptionAgentRole;
    @FindBy(xpath = "//*[text()='kep-support-role']")
    WebElement roleOptionSupportRole;
    @FindBy(xpath = "//*[text()='kep-support-role-2']")
    WebElement roleOptionSupportRole2;
    @FindBy(xpath = "//*[text()='Onboard a User']")
    WebElement onboardAUserButton;
    @FindBy(xpath = "//*[text()='Organization role information']/following::input[1]")
    WebElement orgName;

    @FindBy(xpath = "//*[text()='Organization information']/following::input[2]")
    WebElement orgAddress;


    @FindBy(xpath = "//*[text()='User Information']/following::input[1]")
    WebElement adminUserNameTextField;

    @FindBy(xpath = "//*[text()='User Information']/following::input[2]")
    WebElement adminFirstNameTextField;

    @FindBy(xpath = "//*[text()='User Information']/following::input[3]")
    WebElement adminLastNameTextField;

    @FindBy(xpath = "//*[text()='User Information']/following::input[4]")
    WebElement adminEmailTextField;

    @FindBy(xpath = "//*[text()='User Information']/following::input[5]")
    WebElement adminMobileTextField;

    @FindBy(xpath = "//*[text()='Select a portal']/following::*[text()='HealthCare']")
    WebElement selectAPortal;

    @FindBy(xpath = "//*[@data-value='sirona' and text()='HealthCare']")
    WebElement healthCarePortalLink;

    @FindBy(xpath = "//*[text()='Confirm']")
    WebElement submitOnBoardRequestButton;

    @FindBy(xpath = "//*[text()='My Devices']")
    WebElement myDevicesButton;


    /*
   @FindBy(xpath = "aaaaaaaaa")
   WebElement aaaa;
   */
    @FindBy(xpath = "//*[text()='Logout']")
    WebElement logoutButton;
    @FindBy(xpath = "(//*[@data-testid='PersonIcon'])[1]")
    WebElement profileIconLink;

    @FindBy(xpath = "//*[text()='First name']/following::input[1]")
    WebElement firstNameDisabledInputField;

    @FindBy(xpath = "//*[text()='Last Name']/following::input[1]")
    WebElement lastNameDisabledInputField;

    @FindBy(xpath = "//*[text()='Email Address']/following::input[1]")
    WebElement emailAddressInputField;

    @FindBy(xpath = "//*[@type='password']")
    WebElement passwordField;

    @FindBy(xpath = "//*[@placeholder='For receiving notifications']")
    WebElement phoneNumberField;

    @FindBy(xpath = "//*[text()='Address']/following::input[1]")
    WebElement addressDetailsInputField;

    @FindBy(xpath = "//*[text()='Address']/following::input[2]")
    WebElement cityDetailsInputField;

    @FindBy(xpath = "//*[text()='Address']/following::input[3]")
    WebElement stateDetailsInputField;

    @FindBy(xpath = "//*[text()='Address']/following::input[4]")
    WebElement zipCodeDetailsInputField;

    @FindBy(xpath = "//*[text()='Address']/following::input[5]")
    WebElement countryDetailsInputField;

    @FindBy(xpath = "//*[text()='Save Changes']")
    WebElement saveChangesButton;

    @FindBy(xpath = "//*[text()='Delete']")
    WebElement deleteButton;

    @FindBy(xpath = "//p[text()='Incorrect Phone Number format']")
    WebElement incorrectPhoneNumberInfo;

    @FindBy(xpath = "//*[text()='Phone Number']/following::input[1]")
    WebElement mobileNumberInputField;

    @FindBy(xpath = "//*[text()='Details']")
    WebElement detailsOptionButton;

    @FindBy(xpath = "//*[text()='Preferences']")
    WebElement preferencesOptionButton;

    @FindBy(xpath = "//*[text()='Privacy & Consent']")
    WebElement privacyAndConsentOptionButton;


    @FindBy(xpath = "//*[text()='My Devices']")
    WebElement myDevicesOptionButton;

    @FindBy(xpath = "//*[text()='Managed Roles']")
    WebElement manageRoleOptionsButton;

    @FindBy(xpath = "//button[text()='Request more roles']")
    WebElement requestMoreRolesButton;

    @FindBy(xpath = "//*[@id='select-roles']")
    WebElement selectRolesDropdown;

    @FindBy(xpath = "//*[text()='Request additional roles']/following::textarea[1]")
    WebElement reasonTextAreaForRequestRole;

    @FindBy(xpath = "//*[text()='Confirm']")
    WebElement confirmRequestRoleButton;

    @FindBy(xpath = "//*[text()='Cancel']")
    WebElement cancelRequestRoleButton;
    @FindBy(xpath = "//*[text()='Passwordless Devices']")
    WebElement passwordLessDevicesOptionButton;

    @FindBy(xpath = "//*[text()='User Changes have been made. Click Ok to Continue']/following::button[1]")
    WebElement changesSavedOkButton;

    @FindBy(xpath = "//p[text()='For more detailed information about how your information is being used you may click on']/a[text()='this link']")
    WebElement privacyAndConsentFormLink;

  @FindBy(xpath = "//*[text()='Organization role information']/following::div[4]")
  WebElement roleDrpDown;
    @FindBy(xpath = "//ul[@role='listbox']/li[1]")
    WebElement roleOption_1;

    @FindBy(xpath = "//ul[@role='listbox']/li[2]")
    WebElement roleOption_2;

    @FindBy(xpath = "//ul[@role='listbox']/li[3]")
    WebElement roleOption_3;

    @FindBy(xpath = "//ul[@role='listbox']/li[4]")
    WebElement roleOption_4;

    @FindBy(xpath = "//*[@class='MuiInputBase-root MuiFilledInput-root MuiFilledInput-underline MuiInputBase-colorPrimary MuiInputBase-formControl css-idlxa2']")
    WebElement pushDeviceDrpDown;

    @FindBy(xpath = "//*[text()='Submit Request']")
    WebElement pushDeviceDeRegisterRequestButton;

    @FindBy(xpath = "//*[@class=\"MuiSvgIcon-root MuiSvgIcon-fontSizeMedium css-vubbuv\" and @data-testid=\"KeyboardArrowDownIcon\"]")
    WebElement logoutArrowSpecialButton;

    @FindBy(xpath = "//iframe")
    WebElement iframeAppearance;

    @FindBy(xpath = "//*[text()='Details']")
    WebElement detailsButton;

    @FindBy(xpath = "//button[text()='Setup Push Notification']")
    WebElement newPushDeviceRegisterButton;





    public HealthHomeScreenPage(){PageFactory.initElements(driver, this);}//Constructor

    public String getPageUrl(){return driver.getCurrentUrl();}
    public void clickOnLogoutButton(){
            try {
                javascript.executeScript("arguments[0].click();", logoutButton);
            }
            catch (JavascriptException exception){
                for (int i=0; i<=3;i++) {
                    try {
                        logoutButton.click();
                        break;
                    } catch (StaleElementReferenceException staleExe) {
                        driver.navigate().refresh();
                    }
                }
            }
        }
    public void clickOnProfileIconLink(){profileIconLink.click();}
    public void clickOnProfileIconLinkJS(){
        try {
            javascript.executeScript("arguments[0].click();", profileIconLink);
        }
    catch (JavascriptException exception){
            for (int i=0; i<=7;i++) {
                try {
                    profileIconLink.click();
                    break;
                } catch (StaleElementReferenceException staleExe) {
                    driver.navigate().refresh();
                    profileIconLink.click();
                }
            }
        }
    }
    public void clickOnMyDevicesButton(){myDevicesButton.click();}

    public void clickOnChangesSavedOkayButton(){changesSavedOkButton.click();}
    public void updateNewPassword(){
        //
        passwordField.sendKeys(Passcodes.UPDATE_PASSWORD);
    }
    public String getMobileNumberDetails() {
        waitUtil.elementToBeLocated("//*[text()='Phone Number']/following::input[1]");
        return (String) javascript.executeScript("return arguments[0].value",mobileNumberInputField );
    }

    public String getFirstName(){
        return (String) javascript.executeScript("return arguments[0].value",firstNameDisabledInputField );}
    public String getLastName(){
        return (String) javascript.executeScript("return arguments[0].value",lastNameDisabledInputField );}
    public String getEmailDetails(){
        return (String) javascript.executeScript("return arguments[0].value",emailAddressInputField);}
    public void enterNewPassword(String newPassword){passwordField.click();passwordField.clear(); passwordField.sendKeys(newPassword);}
    public void updatePhoneNumber(String mobileNumber){phoneNumberField.click();phoneNumberField.clear(); phoneNumberField.sendKeys(mobileNumber);}
    public void updateAddressDetails(String address){addressDetailsInputField.click();addressDetailsInputField.clear(); addressDetailsInputField.sendKeys(address);}
    public void updateCityDetails(String city){cityDetailsInputField.click();cityDetailsInputField.clear(); cityDetailsInputField.sendKeys(city);}
    public void updateStateDetails(String state){stateDetailsInputField.click();stateDetailsInputField.clear(); stateDetailsInputField.sendKeys(state);}
    public void updateZipCodeDetails(String zipCode){zipCodeDetailsInputField.click(); zipCodeDetailsInputField.clear();zipCodeDetailsInputField.sendKeys(zipCode);}
    public void updateCountryDetails(String country){countryDetailsInputField.click();countryDetailsInputField.clear(); countryDetailsInputField.sendKeys(country);}

    public String getUpdateAddressDetails(){
        return (String) javascript.executeScript("return arguments[0].value",addressDetailsInputField );}
    public String getUpdateCityDetails(){
        return (String) javascript.executeScript("return arguments[0].value",cityDetailsInputField );}
    public String getUpdateStateDetails(){
        return (String) javascript.executeScript("return arguments[0].value",stateDetailsInputField );}
    public String getUpdateZipCodeDetails(){
        return (String) javascript.executeScript("return arguments[0].value",zipCodeDetailsInputField );}
    public String getUpdateCountryDetails(){
        return (String) javascript.executeScript("return arguments[0].value",countryDetailsInputField );}
    public void clickOnSaveChanges(){saveChangesButton.click();}
    public void clickOnDeleteButton(){deleteButton.click();}
    public void clickOnDetailsOptionButton(){detailsOptionButton.click();}
    public void clickOnPreferencesOptionButton(){preferencesOptionButton.click();}
    public void clickOnPrivacyAndConsentOptionButton(){privacyAndConsentOptionButton.click();}
    public void clickOnMyDevicesOptionButton(){myDevicesOptionButton.click();}
    public void clickOnPasswordLessDevicesOptionButton(){passwordLessDevicesOptionButton.click();}


    public void clickOnPrivacyAndConsentFormLink(){privacyAndConsentFormLink.click();}
    public void clickOnManageRolesButton(){manageRoleOptionsButton.click();}

    public void clickOnRequestMoreRolesButton(){
        javascript.executeScript("arguments[0].click();",requestMoreRolesButton);}
    public void clickOnSelectRoleDrpDownJS(){
        selectRolesDropdown.click();
        //javascript.executeScript("arguments[0].click();",selectRolesDropdown);
    }

    public void clickOnSelectRoleDrpDown(){
        selectRolesDropdown.click();}

    public void selectRoleType(String option){


        if (option.equalsIgnoreCase("kep-staff-role")){
            waitUtil.elementToBeLocated("//*[text()='kep-staff-role']");
            javascript.executeScript("arguments[0].click();",roleOptionStaffRole);

        }else if (option.equalsIgnoreCase("kep-agent-role")){
            waitUtil.elementToBeLocated("//*[text()='kep-agent-role']");
            javascript.executeScript("arguments[0].click();",roleOptionAgentRole);

        }else if(option.equalsIgnoreCase("kep-support-role")){
            waitUtil.elementToBeLocated("//*[text()='kep-support-role']");
            javascript.executeScript("arguments[0].click();",roleOptionSupportRole);
         }
        else{
            waitUtil.elementToBeLocated("//*[text()='kep-support-role-2']");
            javascript.executeScript("arguments[0].click();",roleOptionSupportRole2);
        }
    }

    public void enterRequestRoleDetailsJS(String requestRoleDescription){
        actions.click(reasonTextAreaForRequestRole).build().perform();
//        String jsFormat = "arguments[0].value='"+requestRoleDescription+"';";
//        javascript.executeScript(jsFormat,reasonTextAreaForRequestRole);
        reasonTextAreaForRequestRole.sendKeys(requestRoleDescription);
    }
    public void enterRequestRoleDetails(String requestRoleDescription){reasonTextAreaForRequestRole.sendKeys(requestRoleDescription);}
    public void clickOnConfirmRequestRole(){
        javascript.executeScript("arguments[0].click();",confirmRequestRoleButton);}
    public void clickOnCancelRequestRoleButton(){cancelRequestRoleButton.click();}


    public String getOrgName(){ return (String) javascript.executeScript("return arguments[0].value",orgName);}
    public void enterOrgAddress(String orgAddressInp){orgAddress.clear();orgAddress.sendKeys(orgAddressInp);}
    public void enterAdminUserName(String adminUserName){adminUserNameTextField.clear();adminUserNameTextField.sendKeys(adminUserName);}
    public void enterAdminFirstName(String firstName){adminFirstNameTextField.clear();adminFirstNameTextField.sendKeys(firstName);}
    public void enterAdminLastName(String lastName){adminLastNameTextField.clear();adminLastNameTextField.sendKeys(lastName);}
    public void enterAdminEmail(String email){adminEmailTextField.clear();adminEmailTextField.sendKeys(email);}
    public void enterAdminTelephoneNumber(String telephoneNumber){adminMobileTextField.clear();adminMobileTextField.sendKeys(telephoneNumber);}

    public void clickOnSelectAPortal(){selectAPortal.click();}
    public void selectHealthCareOption(){healthCarePortalLink.click();}
    public void clickOnSubmitOnBoardRequestButton(){
        javascript.executeScript("arguments[0].click();", submitOnBoardRequestButton);
       // submitOnBoardRequestButton.click();
    }
    public void clickOnOnBoardPartnerButton(){
        javascript.executeScript("arguments[0].click();", onboardAUserButton);
        // onboardAUserButton.click();
    }
    public void clickOnRoleDrpDown(){
        roleDrpDown.click();
       // javascript.executeScript("arguments[0].click();", roleDrpDown);
        }
    public void clickOnRoleOption_1(){
        actions.moveToElement(roleOption_1).click().perform();
       // javascript.executeScript("arguments[0].click();", roleOption_1);
    }
    public void clickOnRoleOption_2(){
      //  actions.moveToElement(roleOption_2).click().perform();
        javascript.executeScript("arguments[0].click();", roleOption_2);
    }
    public void clickOnRoleOption_3(){
        actions.moveToElement(roleOption_3).click().perform();
       // javascript.executeScript("arguments[0].click();", roleOption_3);
    }
    public void clickOnRoleOption_4(){
        actions.moveToElement(roleOption_4).click().perform();
        //javascript.executeScript("arguments[0].click();", roleOption_4);
    }

    public void clickOnRegisteredPushDevice(String deviceName){
        String pushDeviceXpath ="//li[text()='"+deviceName +"']";
        waitUtil.elementToBeClickable(pushDeviceXpath);
        driver.findElement(By.xpath(pushDeviceXpath)).click();
    }

    public void clickOnPushDeviceDropDown(){pushDeviceDrpDown.click();}
    public void clickOnNewPushDeviceButton(){newPushDeviceRegisterButton.click();}
    public void clickOnSubmitRequestForDeRegisterPushDevice(){pushDeviceDeRegisterRequestButton.click();}
    public void clickOnLogoutArrowButton(){actions.click(logoutArrowSpecialButton).build().perform();}
    public void clickOnDetailsButton(){actions.click(detailsButton).build().perform();}







}
