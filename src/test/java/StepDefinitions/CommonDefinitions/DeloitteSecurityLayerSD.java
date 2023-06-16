package StepDefinitions.CommonDefinitions;

import Configurations.FilePaths;
import Configurations.Passcodes;
import Configurations.UrlRepo;
import Utilities.BrowserInstance;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;

import java.nio.file.Files;

import static Configurations.SetUpDriverConfigurations.RUN_SCRIPTS_IN_HIDE_MODE;

public class DeloitteSecurityLayerSD extends BrowserInstance {
    //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>COMMON CODE FOR ALL SDs<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
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
    //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>COMMON CODE FOR ALL SDs<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<




    @Given("Setup the Test Environment as {string} and User opens the given URL {string}")
    public void setup_the_test_environment_as_and_user_opens_the_given_url(String nameOfTheBrowser, String typeOfUrl) throws Exception {
        String testUrl = new UrlRepo().getUrl(typeOfUrl);
        //BrowserInstance browserInstance = new BrowserInstance();
        //BrowserInstance.getDriver(nameOfTheBrowser, testUrl);
        driver = BrowserInstance.getDriver(nameOfTheBrowser, testUrl, false);
        System.out.println(driver);
        scenario.log("User has opened the link:" + testUrl + " on " + nameOfTheBrowser + " browser.");
    }

    @Given("Setup the Test Environment as {string} and User opens the given direct URL {string}")
    public void setup_the_test_environment_as_and_user_opens_the_given_direct_url(String nameOfTheBrowser, String typeOfUrl) throws Exception
    {
        //BrowserInstance browserInstance = new BrowserInstance();
        //BrowserInstance.getDriver(nameOfTheBrowser, testUrl);
        driver= BrowserInstance.getDriver(nameOfTheBrowser, typeOfUrl, false);
        System.out.println(driver);
        scenario.log("User has opened the link:"+typeOfUrl+" on "+nameOfTheBrowser+" browser.");
    }

    @Given("Setup the Test Environment as {string} and User opens the given URL {string} with CORS Unblock Plugin {string}")
    public void setup_the_test_environment_as_and_user_opens_the_given_url_cors_unblock(String nameOfTheBrowser, String typeOfUrl,String typeOfPlugin) throws Exception {
        String testUrl = new UrlRepo().getUrl(typeOfUrl);
        String path="";
        if(typeOfPlugin.equalsIgnoreCase("HEALTH_PREF")){
            path= FilePaths.CORS_PLUGIN_PATH_Health_Pref;
        } else if (typeOfPlugin.equalsIgnoreCase("HEALTH_PRIVACY")) {
            path= FilePaths.CORS_PLUGIN_PATH_Health_Privacy;
        }else if (typeOfPlugin.equalsIgnoreCase("BANK_PRIVACY")) {
            path= FilePaths.CORS_PLUGIN_PATH_Bank_Privacy;
        }else{
            path= FilePaths.CORS_PLUGIN_PATH_Bank_Pref;
        }
        if(!RUN_SCRIPTS_IN_HIDE_MODE) {
            driver = BrowserInstance.getDriver(nameOfTheBrowser, testUrl, path);
        }else{
            driver = BrowserInstance.getDriver(nameOfTheBrowser,testUrl, false);
        }
        System.out.println(driver);
        scenario.log("User has opened the link:"+testUrl+" on "+nameOfTheBrowser+" browser.");
    }

    @And("User opens the given URL {string}")
    public void userOpensTheGivenURL(String typeOfUrl) throws Exception {
        String testUrl = new UrlRepo().getUrl(typeOfUrl);
        BrowserInstance.getDriver(testUrl);
        driver.navigate().refresh();
        scenario.log("User has opened the link:"+testUrl);

    }


    @Given("User provides access token to Deloitte security page")
    public void userProvidesAccessTokenOfDeloitte() {
        waitUtil.elementToBeClickable(deloitteSecurityLayerPage.accessThroughEntryTokenXpath);
        deloitteSecurityLayerPage.clickOnAccessThroughEntryToken();
        scenario.log("User is clicked on AccessThroughEntryToken");
        waitUtil.elementToBeClickable(deloitteSecurityLayerPage.enterTokenXpath);
        deloitteSecurityLayerPage.enterAccessToken(Passcodes.ENTRY_TOKEN);
        scenario.log("User has provided Access Token");
        deloitteSecurityLayerPage.clickOnSubmitButton();
        scenario.log("User has received the Access to Deloitte");
    }
    @Given("User provides access token to Deloitte security page for Banking App")
    public void userProvidesAccessTokenOfDeloitteForBankingApp() {
        waitUtil.elementToBeLocated(deloitteSecurityLayerPage.accessThroughEntryTokenXpath);
        deloitteSecurityLayerPage.clickOnAccessThroughEntryToken();
        scenario.log("User is clicked on AccessThroughEntryToken");
        waitUtil.elementToBeClickable(deloitteSecurityLayerPage.enterTokenXpath);
        deloitteSecurityLayerPage.enterAccessToken(Passcodes.ENTRY_TOKEN_FOR_BANKING);
        scenario.log("User has provided Access Token");
        deloitteSecurityLayerPage.clickOnSubmitButton();
        scenario.log("User has received the Access to Deloitte");
    }
    @Given("User provides access token to Deloitte security page for New Banking App")
    public void userProvidesAccessTokenOfDeloitteForNewBankingApp() {
        waitUtil.elementToBeLocated(deloitteSecurityLayerPage.accessThroughEntryTokenXpath);
        deloitteSecurityLayerPage.clickOnAccessThroughEntryToken();
        scenario.log("User is clicked on AccessThroughEntryToken");
        waitUtil.elementToBeClickable(deloitteSecurityLayerPage.enterTokenXpath);
        deloitteSecurityLayerPage.enterAccessToken(Passcodes.ENTRY_TOKEN_FOR_NEW_BANKING);
        scenario.log("User has provided Access Token");
        deloitteSecurityLayerPage.clickOnSubmitButton();
        scenario.log("User has received the Access to Deloitte");
    }

    @Given("User provides access token to Deloitte security page for Wellness")
    public void userProvidesAccessTokenOfDeloitteForWellness() {
        waitUtil.elementToBeLocated(deloitteSecurityLayerPage.accessThroughEntryTokenXpath,60);
        deloitteSecurityLayerPage.clickOnAccessThroughEntryToken();
        scenario.log("User is clicked on AccessThroughEntryToken");
        waitUtil.elementToBeClickable(deloitteSecurityLayerPage.enterTokenXpath);
        deloitteSecurityLayerPage.enterAccessToken(Passcodes.ENTRY_TOKEN_FOR_WELLNESS);
        scenario.log("User has provided Access Token");
        deloitteSecurityLayerPage.clickOnSubmitButton();
        scenario.log("User has received the Access to Deloitte");
    }

    @Then("User gets all redirecting URLs")
    public void userGetsAllRedirectingURLs() {
        for(int i=0;i<=300; i++){
            System.out.println(driver.getCurrentUrl());
        }
    }

}
