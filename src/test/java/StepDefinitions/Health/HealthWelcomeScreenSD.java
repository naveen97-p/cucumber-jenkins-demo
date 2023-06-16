package StepDefinitions.Health;

import Utilities.BrowserInstance;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class HealthWelcomeScreenSD extends BrowserInstance {
    private Scenario scenario;

    public void prepareFailureEvidence(String errorMessage){
        scenario.attach(captureScreen.takeScreenShot(),"image/png",errorMessage);
    }

    @Before
    public void beforeTest(Scenario scenario){
        this.scenario = scenario;
    }

    @After
    public void testScenarioCondition(){
        if (scenario.isFailed()){
            prepareFailureEvidence("Above scenario has been failed. Ref: Attachment");
            scenario.log("PageURL: "+driver.getCurrentUrl());
            scenario.log("Terminated the browser as a failure noticed in above scenario");
            driver.quit();
        }
    }



    @And("User clicks on login button of Health welcome screen and login as {string}")
    public void userClicksOnLoginButtonOfHealthWelcomeScreenAndLoginAs(String roleType) throws Exception {
       waitUtil.elementToBeLocated(healthWelcomePage.welcomeScreenXpath);
       scenario.log("User has landed on Wellness welcome screen");
       healthWelcomePage.clickOnLoginButton();
       Thread.sleep(2000);
       if(roleType.equalsIgnoreCase("App Admin")) {
           waitUtil.elementToBeLocated(healthWelcomePage.applicationAdminXpath);
           healthWelcomePage.clickOnApplicationAdminLoginButton();
           scenario.log("User has clicked on >Application Admin< Login type");
       }
       else if(roleType.equalsIgnoreCase("Partner Admin")){
           waitUtil.elementToBeLocated(healthWelcomePage.partnerAdminXpath);
           healthWelcomePage.clickOnPartnerAdminLoginButton();
           scenario.log("User has clicked on >Partner Admin< Login type");
       }
       else if(roleType.equalsIgnoreCase("Partner User")){
           waitUtil.elementToBeLocated(healthWelcomePage.partnerUserXpath);
           healthWelcomePage.clickOnPartnerUserLoginButton();
           scenario.log("User has clicked on >Partner User< Login type");
       }else if (roleType.equalsIgnoreCase("Patient")){
           waitUtil.elementToBeLocated(healthWelcomePage.patientXpath);
           healthWelcomePage.clickOnPatientLoginButton();
           scenario.log("User has clicked on >Patient< Login type");
       }else if (roleType.equalsIgnoreCase("Doctor")){
           waitUtil.elementToBeLocated(healthWelcomePage.doctorXpath);
           healthWelcomePage.clickOnDoctorLoginButton();
           scenario.log("User has clicked on >Doctor< Login type");
       }else{
           String errorInfo="Please provide the RoleType as 'Patient' or 'Doctor' or 'Partner User' or 'Partner Admin' or 'App Admin' in the feature file";
           scenario.log(errorInfo);
           throw new Exception("Invalid RoleType has provided! >>>>>>>"+errorInfo+"<<<<<<<<");
       }

    }

    @And("User logins as {string} on Wellness App")
    public void userLoginAs(String roleType) throws Exception {

        healthWelcomePage.clickOnLoginButton();
        Thread.sleep(2000);
        if(roleType.equalsIgnoreCase("App Admin")) {
            waitUtil.elementToBeLocated(healthWelcomePage.applicationAdminXpath);
            healthWelcomePage.clickOnApplicationAdminLoginButton();
            scenario.log("User has clicked on >Application Admin< Login type");
        }
        else if(roleType.equalsIgnoreCase("Partner Admin")){
            waitUtil.elementToBeLocated(healthWelcomePage.partnerAdminXpath);
            healthWelcomePage.clickOnPartnerAdminLoginButton();
            scenario.log("User has clicked on >Partner Admin< Login type");
        }
        else if(roleType.equalsIgnoreCase("Partner User")){
            waitUtil.elementToBeLocated(healthWelcomePage.partnerUserXpath);
            healthWelcomePage.clickOnPartnerUserLoginButton();
            scenario.log("User has clicked on >Partner User< Login type");
        }else if (roleType.equalsIgnoreCase("Patient")){
            waitUtil.elementToBeLocated(healthWelcomePage.patientXpath);
            healthWelcomePage.clickOnPatientLoginButton();
            scenario.log("User has clicked on >Patient< Login type");
        }else if (roleType.equalsIgnoreCase("Doctor")){
            waitUtil.elementToBeLocated(healthWelcomePage.doctorXpath);
            healthWelcomePage.clickOnDoctorLoginButton();
            scenario.log("User has clicked on >Doctor< Login type");
        }else{
            String errorInfo="Please provide the RoleType as 'Patient' or 'Doctor' or 'Partner User' or 'Partner Admin' or 'App Admin' in the feature file";
            scenario.log(errorInfo);
            throw new Exception("Invalid RoleType has provided! >>>>>>>"+errorInfo+"<<<<<<<<");
        }

    }


    @And("User clicks on Enroll Partner Admin")
    public void userClicksOnEnrolPartnerAdmin() {
        waitUtil.elementToBeClickable(healthWelcomePage.enrollPartnerRefXpath);
        healthWelcomePage.clickOnEnrolPartnerButton();
        scenario.log("User has clicked on Enroll Partner Button");
    }

    @And("User clicks on Onboard A Partner User")
    public void userClicksOnOnboardAPartnerUser() {
        waitUtil.elementToBeClickable(healthHomeScreenPage.onboardAPartnerXpath,60);
        healthHomeScreenPage.clickOnOnBoardPartnerButton();
        scenario.log("User has clicked on Onboard a Partner Button");
    }

    @Then("User provides Registration Code to Wellness app")
    public void userProvidesRegistrationCodeToWellnessApp() {
        waitUtil.elementToBeLocated(healthWelcomePage.haveARegistrationCodeParaXpath);
        healthWelcomePage.enterRegisterCode();
        scenario.log("User has provided Registration Code");
        healthWelcomePage.clickOnCodeSubmitButton();
        scenario.log("User has submitted the Registration Code");
    }

    @Given("User provides the details of Organization like {string}, {string}, Admin information like {string}, {string}, {string}, {string}, {string} and select portal as {string} then submit")
    public void userProvidesTheDetailsOfOrganizationLikeAdminInformationLikeAndSelectPortalAsThenSubmit(String orgName, String orgAddress, String adminUserName, String adminFirstname, String adminLastName, String adminEmail, String adminMobileNumber, String portalOption) {
        waitUtil.elementToBeLocated(healthWelcomePage.onBoardAPartnerRegistrationXpath);
        healthWelcomePage.enterOrgName(orgName);
        healthWelcomePage.enterOrgAddress(orgAddress);
        healthWelcomePage.enterAdminUserName(adminUserName);
        scenario.log("User has provided Organization Details");
        healthWelcomePage.enterAdminFirstName(adminFirstname);
        healthWelcomePage.enterAdminLastName(adminLastName);
        healthWelcomePage.enterAdminEmail(adminEmail);
        healthWelcomePage.enterAdminTelephoneNumber(adminMobileNumber);
        scenario.log("User has provided Admin Details");
        healthWelcomePage.clickOnSelectAPortal();

        if(portalOption.equalsIgnoreCase("Health Care")){
            waitUtil.elementToBeLocated(healthWelcomePage.healthCarePortalDropDownOptionXpath);
            healthWelcomePage.selectHealthCareOption();
        }else{waitUtil.elementToBeLocated(healthWelcomePage.healthCarePortalDropDownOptionXpath);
            healthWelcomePage.selectHealthCareOption();}

        scenario.log("User has selected Health Care Option");
        healthWelcomePage.clickOnSubmitOnBoardRequestButton();
        scenario.log("User has clicked on submit button of the request");


    }

    @And("User should verify the submit request of Onboard Partner Admin request on Wellness app {string}")
    public void userShouldVerifyTheSubmitRequestOfOnboardPartnerAdminRequestOnWellnessApp(String typeOfTesting) throws Exception {
        if(typeOfTesting.equalsIgnoreCase("Positive")) {
            waitUtil.elementToBeLocated(healthWelcomePage.onboardAPartnerRequestSubmitInfoXpath);
            scenario.log("User has successfully submitted the Onboard A Partner Admin Request");
        }else{
            throw new Exception("Enrolling a partner request has failed due to invalid data");
        }

    }

}
