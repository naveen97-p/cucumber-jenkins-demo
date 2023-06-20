package StepDefinitions.Retail;

import Configurations.FilePaths;
import Utilities.BrowserInstance;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;

import java.io.IOException;

public class RetailWelcomeScreenSD extends BrowserInstance {

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
                        // scenario.attach(captureScreen.takeScreenShot(), "image/png", "Above step has been failed. Ref: Attachment");
                }
        }

        @Given("User verifies the accessibility to Retail App")
        public void user_verifies_the_accessibility_to_retailer_app() {
                String title = retailWelcomePage.getRetailerWelcomePageTitle();
                customExceptions.validateMessage(title,"Climb","User has landed on Retail Welcome Page", "Actual String:"+title+" and Expected String:Climb");

        }

    @Then("User Accepts Cookies for Retail App")
    public void user_accepts_cookies_for_retail_app() {
        cookiesPopUpPage.clickOnAcceptAllCookies();
        scenario.log("Clicked on Accept all cookies");
    }

    @Then("User Accepts Cookies for Banking App")
    public void user_accepts_cookies_for_banking_app() {
        cookiesPopUpPage.clickOnAcceptAllCookies();
        scenario.log("Clicked on Accept all cookies");
    }

    @Given("User clicks on signup button of welcome screen")
    public void user_clicks_on_signup_button_of_welcome_screen() {
  waitUtil.elementToBeLocated(retailWelcomePage.closePopUpIconXpath,30);
        retailWelcomePage.closeThePopUpWindow();
        scenario.log("Clicked on close pop-up window");

        waitUtil.elementToBeLocated(retailWelcomePage.signUpXpath,30);
        retailWelcomePage.clickOnSignUpButton();
        scenario.log("Clicked on SignUp Button");
    }


        @Then("User provides {string} to join for the loyalty program of the Retail App")
        public void user_provides_email_to_join_for_loyalty_program_of_retail_app(String email) throws IOException {
            String data =readAndWriteTextFiles.readTextFile(FilePaths.RETAIL_SIGNUP_INDEX_PATH);
            String myEmail = readAndWriteTextFiles.createAnUniqueEmailEntry(email,data);

            waitUtil.elementToBeLocated(retailWelcomePage.closePopUpIconXpath);
            scenario.log("Subscription pop-up has appeared");
            retailWelcomePage.enterEmailForSubscription(myEmail);
            scenario.log("User has provided email address for subscription");
            retailWelcomePage.clickOnSubscribeButton();
            scenario.log("User has clicked on subscription button");
        }

    @Then("User provides {string} to join for the loyalty program of the Retail App for Progressive Profiling")
    public void user_provides_email_to_join_for_loyalty_program_of_retail_app_for_pp(String email) throws IOException {
        String data =readAndWriteTextFiles.readTextFile(FilePaths.RETAIL_DEMO_PROGRESSIVE_PROFILING_INDEX_PATH);
        String myEmail = readAndWriteTextFiles.createAnUniqueEmailEntry(email,data);

        waitUtil.elementToBeLocated(retailWelcomePage.closePopUpIconXpath);
        scenario.log("Subscription pop-up has appeared");
        retailWelcomePage.enterEmailForSubscription(myEmail);
        scenario.log("User has provided email address for subscription");
        retailWelcomePage.clickOnSubscribeButton();
        scenario.log("User has clicked on subscription button");
    }
    @Then("User provides {string} to join for the loyalty program of the Retail Dev App for Progressive Profiling")
    public void user_provides_email_to_join_for_loyalty_program_of_retail_app_for_pp_dev(String email) throws IOException {
        String data =readAndWriteTextFiles.readTextFile(FilePaths.RETAIL_DEV_PROGRESSIVE_PROFILING_INDEX_PATH);
        String myEmail = readAndWriteTextFiles.createAnUniqueEmailEntry(email,data);

        waitUtil.elementToBeLocated(retailWelcomePage.closePopUpIconXpath);
        scenario.log("Subscription pop-up has appeared");
        retailWelcomePage.enterEmailForSubscription(myEmail);
        scenario.log("User has provided email address for subscription");
        retailWelcomePage.clickOnSubscribeButton();
        scenario.log("User has clicked on subscription button");
    }

        @Given("User clicks on login button of Retail welcome screen")
        public void user_clicks_on_login_button_of_Retail_welcome_screen() {
            waitUtil.elementToBeLocated(retailWelcomePage.closePopUpIconXpath,60);
            scenario.log("Subscription pop-up has appeared");

            retailWelcomePage.closeThePopUpWindow();
            scenario.log("Clicked on close pop-up window");

            retailWelcomePage.clickOnLoginButton();
            scenario.log("Clicked on Login Button");

//            for(int i=0; i<4;i++){
//                try{
//                    //driver.findElement(By.xpath("//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeMedium css-1yxmbwk']")).click();
//                   retailWelcomePage.closeThePopUpWindow();
//                    scenario.log("Clicked on close pop-up window");
//                    break;
//                }catch (StaleElementReferenceException staleException){
//                    scenario.log("Attempt_"+(i+1)+": Trying to close pop-up");
//                }
//                if(i==3){
//                    scenario.log("Script is unable to close the pop-up");
//                }
//            }

//            for(int i=0; i<4;i++){
//                try{
//                    //driver.findElement(By.xpath("//*[text()='Login']")).click();
//                   retailWelcomePage.clickOnLoginButton();
//                    scenario.log("Clicked on Login Button");
//                    break;
//                }catch (StaleElementReferenceException staleException){
//                    scenario.log("Attempt_"+(i+1)+": Trying to click on Login Button");
//                }
//                if(i==3){
//                    scenario.log("Script is unable to click on Login button");
//                }
//            }

        }


    @And("User should logout from Retail app")
    public void userShouldLogoutFromRetailApp() {
                waitUtil.elementToBeClickable(retailWelcomePage.logoutButtonXpath,35);
                //Stale Element Reference Exception
             for(int i=0; i<3;i++){
            try{
                retailWelcomePage.clickOnLogoutButton();
                break;
                }catch (StaleElementReferenceException staleException){
                scenario.log("Stale Exception for above step");
                 }
            }


                scenario.log("User has logged out from Retail Application");
                waitUtil.elementToBeClickable(retailWelcomePage.closePopUpIconXpath,35);
            for(int i=0; i<3;i++){
                try{
                    retailWelcomePage.closeThePopUpWindow();
                    break;
                    }catch (StaleElementReferenceException staleException){
                    scenario.log("Stale Exception for above step");
                    }
                 }

                scenario.log("User has closed the pop-up screen");
    }



    @Then("User clicks on profile icon on welcome screen")
    public void userClicksOnProfileIconOnWelcomeScreen() throws Exception {
            String pageTitle = driver.getTitle();
            for(int i=0; i<=9000;i++){
                pageTitle=driver.getTitle();
                if(pageTitle.equalsIgnoreCase("Redirect")){
                    scenario.log("Redirected to Logged-In Screen");
                    break;
                }
                if(i==9000){
                    throw new Exception("Site is not redirected to Logged-In Screen");
                }
            }
            Thread.sleep(4000);

            waitUtil.elementToBeClickable(retailWelcomePage.profileButtonXpath);
            retailWelcomePage.clickOnProfileButton();
    }

    @And("User should logout from Retail app {string}")
    public void userShouldLogoutFromRetailApp(String typeOfTest) throws InterruptedException {
            if(typeOfTest.equalsIgnoreCase("positive")){
                userShouldLogoutFromRetailApp();
            }
            else{
                scenario.log("Logout Test is not applicable as the user login data is not valid");
            }
    }


    @And("User closes the pop-up screen")
    public void userClosesThePopUpScreen() {
        waitUtil.elementToBeLocated(retailWelcomePage.closePopUpIconXpath);
        scenario.log("Subscription pop-up has appeared");

        retailWelcomePage.closeThePopUpWindow();
        scenario.log("Clicked on close pop-up window");
    }

    @Then("User click on Do Not Sell My Data on Home page")
    public void userClickOnDoNotSellMyDataOnHomePage() {
        waitUtil.elementToBeLocated(retailWelcomePage.doNotSellMyDataDSARLinkXpath,30);
        scenario.log("Do Not Sell My Data link has appeared");

        retailWelcomePage.clickOnDSARlink();
        scenario.log("Clicked on Do Not Sell My Data link");

    }

    @And("get the title of the Page as {string}")
    public void getTheTitleOfThePageAs(String pageTitle) {
            waitUtil.elementToBeLocated(retailWelcomePage.googleHomePageRefXpath,30);
            scenario.log("Google Search button has appeared as expected");
            Assert.assertEquals("Google Page Title isn't appeared as expected", pageTitle, driver.getTitle());
    }
}
