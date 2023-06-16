package StepDefinitions.Retail;

import Utilities.BrowserInstance;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;

import java.util.Iterator;
import java.util.Set;

public class RetailPrivacyWebFormScreenSD extends BrowserInstance {
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
//Demo
    @And("User should fill the Privacy Web Form with the details like {string}, {string}, {string},{string},{string},{string},{string},{string},{string} then submit")
    public void userShouldFillThePrivacyWebFormWithTheDetailsLikeThenSubmit(String countryName, String iAmAorAn, String stateName, String selectRequestType, String webFirstName, String webLastName, String webEmail, String loyaltyID, String requestDetails) throws InterruptedException {

        waitUtil.elementToBeLocated(retailPrivacyWebFormPage.privacyWebFormRefXpath, 25);
//        retailPrivacyWebFormPage.enterCountryName(countryName);
//        if(iAmAorAn.equalsIgnoreCase("Customer")){retailPrivacyWebFormPage.clickOnIAmACustomerButton();}else if(iAmAorAn.equalsIgnoreCase("Contractor")){retailPrivacyWebFormPage.clickOnIAmAContractorButton();}else if(iAmAorAn.equalsIgnoreCase("Employee")){retailPrivacyWebFormPage.clickOnIAmAnEmployeeButton();}
//        retailPrivacyWebFormPage.enterStateName(stateName);
//        if(selectRequestType.equalsIgnoreCase("Do Not Sell My Information")){retailPrivacyWebFormPage.selectReqTypeAsDoNotSellMyDataRequestButton();}else if(selectRequestType.equalsIgnoreCase("Data Deletion")){retailPrivacyWebFormPage.selectReqTypeAsDataDeletionRequestButton();}else if(selectRequestType.equalsIgnoreCase("Info Request")){retailPrivacyWebFormPage.selectReqTypeAsInfoRequestButton();}
       Thread.sleep(4000);
//        String actualFirstName = retailPrivacyWebFormPage.getFirstName();
//        String actualLastName = retailPrivacyWebFormPage.getLastName();
        String actualEmail = retailPrivacyWebFormPage.getEmail();

//        Assert.assertEquals(actualFirstName,webFirstName,"First name is not appeared as expected");
//        scenario.log("FirstName has been pulled from Octa is Verified :"+actualFirstName);
//        Assert.assertEquals(actualLastName,webLastName, "Last name is not appeared as expected");
//        scenario.log("LastName has been pulled from Octa is Verified :"+actualLastName);
        Assert.assertEquals(actualEmail,webEmail,"Email is not appeared as expected");
        scenario.log("Email has been pulled from Octa is Verified :"+actualEmail);

//        retailPrivacyWebFormPage.clickOnSubmitButton();


    }

    //Dev
    @And("User should fill the Privacy Web Form with the details like {string}, {string}, {string},{string},{string},{string},{string},{string},{string} then submit for Dev")
    public void userShouldFillThePrivacyWebFormWithTheDetailsLikeThenSubmitForDev(String countryName, String iAmAorAn, String stateName, String selectRequestType, String webFirstName, String webLastName, String webEmail, String loyaltyID, String requestDetails) throws InterruptedException {

        waitUtil.elementToBeLocated(retailPrivacyWebFormPage.privacyWebFormDevRefXpathNew, 25);
//        retailPrivacyWebFormPage.enterCountryName(countryName);
//        if(iAmAorAn.equalsIgnoreCase("Customer")){retailPrivacyWebFormPage.clickOnIAmACustomerButton();}else if(iAmAorAn.equalsIgnoreCase("Contractor")){retailPrivacyWebFormPage.clickOnIAmAContractorButton();}else if(iAmAorAn.equalsIgnoreCase("Employee")){retailPrivacyWebFormPage.clickOnIAmAnEmployeeButton();}
//        retailPrivacyWebFormPage.enterStateName(stateName);
//        if(selectRequestType.equalsIgnoreCase("Do Not Sell My Information")){retailPrivacyWebFormPage.selectReqTypeAsDoNotSellMyDataRequestButton();}else if(selectRequestType.equalsIgnoreCase("Data Deletion")){retailPrivacyWebFormPage.selectReqTypeAsDataDeletionRequestButton();}else if(selectRequestType.equalsIgnoreCase("Info Request")){retailPrivacyWebFormPage.selectReqTypeAsInfoRequestButton();}
        Thread.sleep(4000);
//        String actualFirstName = retailPrivacyWebFormPage.getFirstName();
//        String actualLastName = retailPrivacyWebFormPage.getLastName();
        String actualEmail = retailPrivacyWebFormPage.getEmail();

//        Assert.assertEquals(actualFirstName,webFirstName,"First name is not appeared as expected");
//        scenario.log("FirstName has been pulled from Octa is Verified :"+actualFirstName);
//        Assert.assertEquals(actualLastName,webLastName, "Last name is not appeared as expected");
//        scenario.log("LastName has been pulled from Octa is Verified :"+actualLastName);
        Assert.assertEquals(actualEmail,webEmail,"Email is not appeared as expected");
        scenario.log("Email has been pulled from Octa is Verified :"+actualEmail);

//        retailPrivacyWebFormPage.clickOnSubmitButton();


    }
    @And("User verifies the Privacy Web Form with the email {string}")
    public void userVerifyThePrivacyWebFormWithTheEmailIDForDSAR( String webEmail) throws InterruptedException {
        String climbWindow=driver.getWindowHandle();//climb
        String child_window=null;
        Set<String> s=driver.getWindowHandles();//2
        // Now iterate using Iterator
        Iterator<String> I1= s.iterator();
        while(I1.hasNext())
        {
            child_window = I1.next();
            if (!climbWindow.equals(child_window)) {
                driver.switchTo().window(child_window);
                scenario.log("User has switched to Deloitte-SignIn > Octa Window");
                break;
            }

        }
        waitUtil.elementToBeLocated(retailPrivacyWebFormPage.privacyWebFormRefXpath, 20);
        scenario.log("Privacy Form has been appeared.");
//        retailPrivacyWebFormPage.enterCountryName(countryName);
//        if(iAmAorAn.equalsIgnoreCase("Customer")){retailPrivacyWebFormPage.clickOnIAmACustomerButton();}else if(iAmAorAn.equalsIgnoreCase("Contractor")){retailPrivacyWebFormPage.clickOnIAmAContractorButton();}else if(iAmAorAn.equalsIgnoreCase("Employee")){retailPrivacyWebFormPage.clickOnIAmAnEmployeeButton();}
//        retailPrivacyWebFormPage.enterStateName(stateName);
//        if(selectRequestType.equalsIgnoreCase("Do Not Sell My Information")){retailPrivacyWebFormPage.selectReqTypeAsDoNotSellMyDataRequestButton();}else if(selectRequestType.equalsIgnoreCase("Data Deletion")){retailPrivacyWebFormPage.selectReqTypeAsDataDeletionRequestButton();}else if(selectRequestType.equalsIgnoreCase("Info Request")){retailPrivacyWebFormPage.selectReqTypeAsInfoRequestButton();}
       // Thread.sleep(7);
//        String actualFirstName = retailPrivacyWebFormPage.getFirstName();
//        String actualLastName = retailPrivacyWebFormPage.getLastName();
        //String actualEmail = retailPrivacyWebFormPage.getEmail();

//        Assert.assertEquals(actualFirstName,webFirstName,"First name is not appeared as expected");
//        scenario.log("FirstName has been pulled from Octa is Verified :"+actualFirstName);
//        Assert.assertEquals(actualLastName,webLastName, "Last name is not appeared as expected");
//        scenario.log("LastName has been pulled from Octa is Verified :"+actualLastName);
       // Assert.assertEquals(actualEmail,webEmail,"Email is not appeared as expected");
       // scenario.log("Email has been pulled from Octa is Verified :"+actualEmail);

//        retailPrivacyWebFormPage.clickOnSubmitButton();


    }


    @And("User verifies the Privacy Web Form of Dev")
    public void userVerifyThePrivacyWebFormWithTheEmailIDForDSARofDev() throws InterruptedException {
        String climbWindow=driver.getWindowHandle();//climb
        String child_window=null;
        Set<String> s=driver.getWindowHandles();//2
        // Now iterate using Iterator
        Iterator<String> I1= s.iterator();
        while(I1.hasNext())
        {
                child_window = I1.next();
                if (!climbWindow.equals(child_window)) {
                    driver.switchTo().window(child_window);
                    scenario.log("User has switched to Deloitte-SignIn > Octa Window");
                    break;
                }

        }


        waitUtil.elementToBeLocated(retailPrivacyWebFormPage.privacyWebFormDevRefXpath, 20);
        scenario.log("Privacy Form has been appeared.");
//        retailPrivacyWebFormPage.enterCountryName(countryName);
//        if(iAmAorAn.equalsIgnoreCase("Customer")){retailPrivacyWebFormPage.clickOnIAmACustomerButton();}else if(iAmAorAn.equalsIgnoreCase("Contractor")){retailPrivacyWebFormPage.clickOnIAmAContractorButton();}else if(iAmAorAn.equalsIgnoreCase("Employee")){retailPrivacyWebFormPage.clickOnIAmAnEmployeeButton();}
//        retailPrivacyWebFormPage.enterStateName(stateName);
//        if(selectRequestType.equalsIgnoreCase("Do Not Sell My Information")){retailPrivacyWebFormPage.selectReqTypeAsDoNotSellMyDataRequestButton();}else if(selectRequestType.equalsIgnoreCase("Data Deletion")){retailPrivacyWebFormPage.selectReqTypeAsDataDeletionRequestButton();}else if(selectRequestType.equalsIgnoreCase("Info Request")){retailPrivacyWebFormPage.selectReqTypeAsInfoRequestButton();}
//        Thread.sleep(7);
//        String actualFirstName = retailPrivacyWebFormPage.getFirstName();
//        String actualLastName = retailPrivacyWebFormPage.getLastName();
//        String actualEmail = retailPrivacyWebFormPage.getEmail();

//        Assert.assertEquals(actualFirstName,webFirstName,"First name is not appeared as expected");
//        scenario.log("FirstName has been pulled from Octa is Verified :"+actualFirstName);
//        Assert.assertEquals(actualLastName,webLastName, "Last name is not appeared as expected");
//        scenario.log("LastName has been pulled from Octa is Verified :"+actualLastName);
//        Assert.assertEquals(actualEmail,webEmail,"Email is not appeared as expected");
//        scenario.log("Email has been pulled from Octa is Verified :"+actualEmail);

//        retailPrivacyWebFormPage.clickOnSubmitButton();


    }




    @Then("User should verify the auto-populated details like {string}, {string}, {string} and static content from Privacy and Consent Form of Wellness")
    public void userShouldVerifyTheAutoPopulatedDetailsLikeAndStaticContentFromPrivacyAndConsentFormOfWellness(String firstName, String lastName, String email) throws InterruptedException {

//        retailPrivacyWebFormPage.enterCountryName(countryName);
//        if(iAmAorAn.equalsIgnoreCase("Customer")){retailPrivacyWebFormPage.clickOnIAmACustomerButton();}else if(iAmAorAn.equalsIgnoreCase("Contractor")){retailPrivacyWebFormPage.clickOnIAmAContractorButton();}else if(iAmAorAn.equalsIgnoreCase("Employee")){retailPrivacyWebFormPage.clickOnIAmAnEmployeeButton();}
//        retailPrivacyWebFormPage.enterStateName(stateName);
//        if(selectRequestType.equalsIgnoreCase("Do Not Sell My Information")){retailPrivacyWebFormPage.selectReqTypeAsDoNotSellMyDataRequestButton();}else if(selectRequestType.equalsIgnoreCase("Data Deletion")){retailPrivacyWebFormPage.selectReqTypeAsDataDeletionRequestButton();}else if(selectRequestType.equalsIgnoreCase("Info Request")){retailPrivacyWebFormPage.selectReqTypeAsInfoRequestButton();}


        String climbWindow=driver.getWindowHandle();//climb
        String child_window=null;
        Set<String> s=driver.getWindowHandles();//2
        // Now iterate using Iterator
        Iterator<String> I1= s.iterator();
        while(I1.hasNext())
        {
            child_window=I1.next();
            if(!climbWindow.equals(child_window)) {
                driver.switchTo().window(child_window);
                scenario.log("User has switched to Privacy and Consent Form");
                break;
            }
        }
        waitUtil.elementToBeLocated(retailPrivacyWebFormPage.healthPrivacyFormXpathPara1, 20);
        Thread.sleep(4);

        String actualFirstName = retailPrivacyWebFormPage.getFirstName();
        String actualLastName = retailPrivacyWebFormPage.getLastName();
        String actualEmail = retailPrivacyWebFormPage.getEmail();

        Assert.assertEquals(actualFirstName,firstName,"First name is not appeared as expected");
        scenario.log("FirstName has been pulled from Octa is Verified :"+actualFirstName);
        Assert.assertEquals(actualLastName,lastName, "Last name is not appeared as expected");
        scenario.log("LastName has been pulled from Octa is Verified :"+actualLastName);
        Assert.assertEquals(actualEmail,email,"Email is not appeared as expected");
        scenario.log("Email has been pulled from Octa is Verified :"+actualEmail);
        driver.switchTo().defaultContent();

    }
}
