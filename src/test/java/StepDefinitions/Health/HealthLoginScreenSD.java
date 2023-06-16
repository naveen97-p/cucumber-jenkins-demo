package StepDefinitions.Health;

import Configurations.FilePaths;
import Configurations.Passcodes;
import Utilities.BrowserInstance;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class HealthLoginScreenSD extends BrowserInstance {
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

    @Then("User verifies the login page role as {string}")
    public void userVerifiesTheLoginPageRoleAs(String roleType) throws Exception {
        waitUtil.elementToBeLocated(healthLoginPage.userNameLandRefXpath,60);
        scenario.log("User has landed on Wellness Login screen");
        String pageUrl = healthLoginPage.getPageUrl();
        scenario.log("Page URL based on the Role: "+pageUrl);
        if(roleType.equalsIgnoreCase("App Admin")) {
            softAssert.assertEquals(pageUrl,healthLoginPage.loginAsAnApplicationAdmin,"App Admin Url is not as expected, ref actual url:"+pageUrl);
        }
        else if(roleType.equalsIgnoreCase("Partner Admin")){
            softAssert.assertEquals(pageUrl,healthLoginPage.loginAsAPartnerAdmin,"Partner Admin Url is not as expected, ref actual url:"+pageUrl);
        }
        else if(roleType.equalsIgnoreCase("Partner User")){
            softAssert.assertEquals(pageUrl,healthLoginPage.loginAsAPartnerUser,"Partner User Url is not as expected, ref actual url:"+pageUrl);

        }else if (roleType.equalsIgnoreCase("Patient")){
            softAssert.assertEquals(pageUrl,healthLoginPage.loginAsAPatient,"Patient Url is not as expected, ref actual url:"+pageUrl);
        }else{
            softAssert.assertEquals(pageUrl,healthLoginPage.loginAsADoctor,"Doctor Url is not as expected, ref actual url:"+pageUrl);
        }

    }




    @And("User provides username as {string} and password to Wellness App")
    public void userProvidesUsernameAsAndPasswordToWellnessApp(String userName) {
        healthLoginPage.enterUsername(userName);
        scenario.log("User has provided UserName");
        healthLoginPage.enterPassword(Passcodes.WELLNESS_PASSWORD);
        scenario.log("User has provided PassWord");
        healthLoginPage.clickOnSubmitButton();
        scenario.log("User has clicked on submit button");
    }
    @And("User provides previous username as {string} and password to Wellness App")
    public void userProvidesUsernameAsAndPreviousPasswordToWellnessApp(String userName) throws IOException {

        String data =readAndWriteTextFiles.readTextFile(FilePaths.HEALTH_SIGNUP_INDEX_PATH);
        String usernameFromCode = readAndWriteTextFiles.getPreviouslyCreatedUsername(userName,data);

        healthLoginPage.enterUsername(usernameFromCode);
        scenario.log("User has provided UserName");
        healthLoginPage.enterPassword(Passcodes.WELLNESS_PASSWORD);
        scenario.log("User has provided PassWord");
        healthLoginPage.clickOnSubmitButton();
        scenario.log("User has clicked on submit button");
    }

    @And("User provides username as {string} and new password to Wellness App")
    public void userProvidesUsernameAsAndNewPasswordToWellnessApp(String userName) {
        healthLoginPage.enterUsername(userName);
        scenario.log("User has provided UserName");
        healthLoginPage.enterPassword(Passcodes.UPDATE_PASSWORD);
        scenario.log("User has provided PassWord");
        healthLoginPage.clickOnSubmitButton();
        scenario.log("User has clicked on submit button");
    }

    @Given("User clicks on Register button of Health Application")
    public void userClicksOnRegisterButtonOfHealthApplication() {
        waitUtil.elementToBeClickable(healthLoginPage.registerLinkXpath);
        healthLoginPage.clickOnRegisterButton();
        scenario.log("User has clicked on Register Button");
    }


}
