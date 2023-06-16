package StepDefinitions.Retail;

import Configurations.FilePaths;
import Configurations.Passcodes;
import Configurations.UrlRepo;
import Utilities.BrowserInstance;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.net.UrlChecker;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

public class RetailOctaSignInSceenSD extends BrowserInstance {
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

    @And("User should provide {string} to Octa Page, get the OTP from Mailinator and then authorize the sign-in")
    public void userShouldProvideToOctaPageGetTheOTPFromMailinatorAndThenAuthorizeTheSignIn(String email) throws InterruptedException {
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
                scenario.log("User has switched to Deloitte-SignIn > Octa Window");
                break;
            }
        }

        for(int i = 0; i<=3;i++) {
            try {
                waitUtil.elementToBeLocated(octaSignInPage.signInScreenRefXpath, 40);
                break;
            }catch (Exception ex){
                continue;
            }
        }
        octaSignInPage.enterUserName(email);
        octaSignInPage.clickOnNextButton();
        waitUtil.elementToBeLocated(octaSignInPage.signInPasswordScreenXpath);
        octaSignInPage.enterPasswordToOcta(Passcodes.WELLNESS_PASSWORD);
        octaSignInPage.clickOnNextButton();
        waitUtil.elementToBeLocated(octaSignInPage.signInOTPTriggerScreenXpath);
        octaSignInPage.clickOnSendAnEmailButton();
        scenario.log("User has triggered the Mailinator OTP to access Web Privacy Form");
        waitUtil.elementToBeLocated(octaSignInPage.waitForOTPFieldToOpenXpath);
        octaSignInPage.clickOnEnterCodeButton();


        //Launch mailinator in new window

        driver.switchTo().newWindow(WindowType.TAB);
        driver.navigate().to(UrlRepo.MAILINATOR_LINK);
        octaSignInPage.searchMailToOpenInbox(email);
        octaSignInPage.clickOnGoButton();
        scenario.log("User has opened inbox for the registered email");
        try {
            waitUtil.elementToBeLocated(octaSignInPage.checkRecetOTPMessageJustNow, 10);
            octaSignInPage.clickOnOpenInboxMessage();
            scenario.log("User has received the Magic Link - JUST NOW");
        }
        catch (TimeoutException ex1){
            try {
                driver.navigate().refresh();
                waitUtil.elementToBeLocated(octaSignInPage.checkRecetOTPMessageOneMin, 10);
                octaSignInPage.clickOnOpenInboxMessage();
                scenario.log("User has received the Magic Link - 1 MIN");
            }catch (TimeoutException ex2){
                //2 mins
                waitUtil.elementToBeLocated(octaSignInPage.checkRecetOTPMessageTwoMin, 10);
                octaSignInPage.clickOnOpenInboxMessage();
                scenario.log("User has received the Magic Link - 2 MIN");

            }

        }

        driver.switchTo().frame(0);

        waitUtil.elementToBeLocated(octaSignInPage.waitForOtp);
        String realOTP = octaSignInPage.getActualOTP();
        driver.switchTo().defaultContent();
        scenario.log("OTP has been received: "+realOTP);
        Thread.sleep(3);
        //driver.close(); //closing the mailinator window


        //Switch to Mailinator site
        // open "Username" Inbox and get OTP
        //switch back to Octa Screen and pass OTP and Verify
        driver.switchTo().window(child_window);
        octaSignInPage.enterOTPReceivedFromMailinator(realOTP);
        Thread.sleep(3);
        octaSignInPage.clickOnVerifyButton();
        Thread.sleep(3);

    }


    @And("User should provide {string} to Octa Page, get the OTP from Mailinator and then authorize the sign-in for Retail")
    public void userShouldProvideToOctaPageGetTheOTPFromMailinatorAndThenAuthorizeTheSignInRetail(String email) throws InterruptedException {
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
                scenario.log("User has switched to Deloitte-SignIn > Octa Window");
                break;
            }
        }

        for(int i = 0; i<=3;i++) {
            try {
                waitUtil.elementToBeLocated(octaSignInPage.signInScreenRefXpath, 40);
                break;
            }catch (Exception ex){
                continue;
            }
        }

        octaSignInPage.enterUserName(email);
        octaSignInPage.clickOnNextButton();
        waitUtil.elementToBeLocated(octaSignInPage.signInPasswordScreenXpath,30);
        octaSignInPage.enterPasswordToOcta(Passcodes.STANDARD_PASSWORD);
        octaSignInPage.clickOnNextButton();


        waitUtil.elementToBeLocated(octaSignInPage.signInOTPTriggerScreenXpath,30);
        octaSignInPage.clickOnSendAnEmailButton();
        scenario.log("User has triggered the Mailinator OTP to access Web Privacy Form");
        waitUtil.elementToBeLocated(octaSignInPage.waitForOTPFieldToOpenXpath,40);
        octaSignInPage.clickOnEnterCodeButton();


        //Launch mailinator in new window

        driver.switchTo().newWindow(WindowType.TAB);
        driver.navigate().to(UrlRepo.MAILINATOR_LINK);
        octaSignInPage.searchMailToOpenInbox(email);
        octaSignInPage.clickOnGoButton();

        scenario.log("User has opened inbox for the registered email");
        try {
            waitUtil.elementToBeLocated(octaSignInPage.checkRecetOTPMessageJustNow, 10);
            octaSignInPage.clickOnOpenInboxMessage();
            scenario.log("User has received the Magic Link - JUST NOW");
        }
        catch (TimeoutException ex1){
            try {
                driver.navigate().refresh();
                waitUtil.elementToBeLocated(octaSignInPage.checkRecetOTPMessageOneMin, 10);
                octaSignInPage.clickOnOpenInboxMessage();
                scenario.log("User has received the Magic Link - 1 MIN");
            }catch (TimeoutException ex2){
                //2 mins
                waitUtil.elementToBeLocated(octaSignInPage.checkRecetOTPMessageTwoMin, 10);
                octaSignInPage.clickOnOpenInboxMessage();
                scenario.log("User has received the Magic Link - 2 MIN");

            }

        }

        driver.switchTo().frame(0);

        waitUtil.elementToBeLocated(octaSignInPage.waitForOtp);
        String realOTP = octaSignInPage.getActualOTP();
        driver.switchTo().defaultContent();
        scenario.log("OTP has been received: "+realOTP);
        Thread.sleep(3);
        //driver.close(); //closing the mailinator window


        //Switch to Mailinator site
        // open "Username" Inbox and get OTP
        //switch back to Octa Screen and pass OTP and Verify
        driver.switchTo().window(child_window);
        octaSignInPage.enterOTPReceivedFromMailinator(realOTP);
        Thread.sleep(3);
        octaSignInPage.clickOnVerifyButton();
        Thread.sleep(3);

    }



    //Dev

    @And("User should provide {string} to Octa Page, get the OTP from Mailinator and then authorize the sign-in for Retail-Dev")
    public void userShouldProvideToOctaPageGetTheOTPFromMailinatorAndThenAuthorizeTheSignInRetailDev(String email) throws InterruptedException {
       Thread.sleep(2000);
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
                scenario.log("User has switched to Deloitte-SignIn > Octa Window");
                break;
            }
        }

//        for(int i = 0; i<=3;i++) {
//            try {
//                waitUtil.elementToBeLocated(octaSignInPage.signInScreenRefXpath, 40);
//                break;
//            }catch (Exception ex){
//                continue;
//            }
//        }

//        octaSignInPage.enterUserName(email);
//        octaSignInPage.clickOnNextButton();
//        waitUtil.elementToBeLocated(octaSignInPage.signInPasswordScreenXpath);
//        octaSignInPage.enterPasswordToOcta(Passcodes.STANDARD_PASSWORD);
//        octaSignInPage.clickOnNextButton();


        waitUtil.elementToBeLocated(octaSignInPage.signInOTPTriggerScreenXpath,40);
        octaSignInPage.clickOnSendAnEmailButton();
        scenario.log("User has triggered the Mailinator OTP to access Web Privacy Form");
        waitUtil.elementToBeLocated(octaSignInPage.waitForOTPFieldToOpenXpath,30);
        octaSignInPage.clickOnEnterCodeButton();


        //Launch mailinator in new window

        driver.switchTo().newWindow(WindowType.TAB);
        driver.navigate().to(UrlRepo.MAILINATOR_LINK);
        octaSignInPage.searchMailToOpenInbox(email);
        octaSignInPage.clickOnGoButton();

        scenario.log("User has opened inbox for the registered email");
        try {
            waitUtil.elementToBeLocated(octaSignInPage.checkRecetOTPMessageJustNow, 10);
            octaSignInPage.clickOnOpenInboxMessage();
            scenario.log("User has received the Magic Link - JUST NOW");
        }
        catch (TimeoutException ex1){
            try {
                driver.navigate().refresh();
                waitUtil.elementToBeLocated(octaSignInPage.checkRecetOTPMessageOneMin, 10);
                octaSignInPage.clickOnOpenInboxMessage();
                scenario.log("User has received the Magic Link - 1 MIN");
            }catch (TimeoutException ex2){
                //2 mins
                waitUtil.elementToBeLocated(octaSignInPage.checkRecetOTPMessageTwoMin, 10);
                octaSignInPage.clickOnOpenInboxMessage();
                scenario.log("User has received the Magic Link - 2 MIN");

            }

        }

        driver.switchTo().frame(0);

        waitUtil.elementToBeLocated(octaSignInPage.waitForOtp);
        String realOTP = octaSignInPage.getActualOTP();
        driver.switchTo().defaultContent();
        scenario.log("OTP has been received: "+realOTP);
        Thread.sleep(3);
        //driver.close(); //closing the mailinator window


        //Switch to Mailinator site
        // open "Username" Inbox and get OTP
        //switch back to Octa Screen and pass OTP and Verify
        driver.switchTo().window(child_window);
        octaSignInPage.enterOTPReceivedFromMailinator(realOTP);
        Thread.sleep(3);
        octaSignInPage.clickOnVerifyButton();
        Thread.sleep(3);

    }


//Demo
    @And("User should open Mailinator site and provide {string}, and then authorize the subscription for Progressive Profiling")
    public void userShouldOpenMailinatorSiteAndProvideEmailThenAuthorizeTheSubscriptionForProgressive(String email) throws InterruptedException, IOException {


        String data =readAndWriteTextFiles.readTextFile(FilePaths.RETAIL_DEMO_PROGRESSIVE_PROFILING_INDEX_PATH);
        String myEmail = readAndWriteTextFiles.createAnUniqueEmailEntry(email,data);

        driver.switchTo().newWindow(WindowType.TAB);
        Thread.sleep(1000);
        driver.navigate().to(UrlRepo.MAILINATOR_LINK);
        scenario.log("User has opened Mailinator link in new tab");
        octaSignInPage.searchMailToOpenInbox(myEmail);

        octaSignInPage.clickOnGoButton();
        scenario.log("User has opened inbox for the registered email");
        try {
            waitUtil.elementToBeLocated(octaSignInPage.checkRecetOTPMessageJustNow, 10);
            octaSignInPage.clickOnOpenInboxMessage();
            scenario.log("User has received the Magic Link - JUST NOW");
        }
        catch (TimeoutException ex1){
            try {
                driver.navigate().refresh();
                waitUtil.elementToBeLocated(octaSignInPage.checkRecetOTPMessageOneMin, 10);
                octaSignInPage.clickOnOpenInboxMessage();
                scenario.log("User has received the Magic Link - 1 MIN");
            }catch (TimeoutException ex2){
                //2 mins
                waitUtil.elementToBeLocated(octaSignInPage.checkRecetOTPMessageTwoMin, 10);
                octaSignInPage.clickOnOpenInboxMessage();
                scenario.log("User has received the Magic Link - 2 MIN");

            }

        }
        scenario.log("User has received the Magic Link - JUST NOW");
        driver.switchTo().frame(0);

        waitUtil.elementToBeLocated(octaSignInPage.waitForHereLink);
        String parent=driver.getWindowHandle();
        octaSignInPage.clickOnAuthorizeHereLink();
        scenario.log("User has clicked on Magic Link to complete the Loyalty Enrolment");

        //Navigate to Deloitte Access Token Page
        Thread.sleep(2000);

        //Switch to new window
        ArrayList<String> tab_3rd = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tab_3rd.get(2));//Update if the idex is not proper
        waitUtil.elementToBeLocated(deloitteSecurityLayerPage.accessThroughEntryTokenXpath,30);
        scenario.log("User is landed on Deloitte Security Token Page");


    }

    //Dev
    @And("User should open Mailinator site and provide {string}, and then authorize the subscription for Progressive Profiling for Dev")
    public void userShouldOpenMailinatorSiteAndProvideEmailThenAuthorizeTheSubscriptionForProgressiveDev(String email) throws InterruptedException, IOException {


        String data =readAndWriteTextFiles.readTextFile(FilePaths.RETAIL_DEV_PROGRESSIVE_PROFILING_INDEX_PATH);
        String myEmail = readAndWriteTextFiles.createAnUniqueEmailEntry(email,data);

        driver.switchTo().newWindow(WindowType.TAB);
        Thread.sleep(1000);
        driver.navigate().to(UrlRepo.MAILINATOR_LINK);
        scenario.log("User has opened Mailinator link in new tab");
        octaSignInPage.searchMailToOpenInbox(myEmail);

        octaSignInPage.clickOnGoButton();
        scenario.log("User has opened inbox for the registered email");
        try {
            waitUtil.elementToBeLocated(octaSignInPage.checkRecetOTPMessageJustNow, 10);
            octaSignInPage.clickOnOpenInboxMessage();
            scenario.log("User has received the Magic Link - JUST NOW");
        }
        catch (TimeoutException ex1){
            try {
                driver.navigate().refresh();
                waitUtil.elementToBeLocated(octaSignInPage.checkRecetOTPMessageOneMin, 10);
                octaSignInPage.clickOnOpenInboxMessage();
                scenario.log("User has received the Magic Link - 1 MIN");
            }catch (TimeoutException ex2){
                //2 mins
                waitUtil.elementToBeLocated(octaSignInPage.checkRecetOTPMessageTwoMin, 10);
                octaSignInPage.clickOnOpenInboxMessage();
                scenario.log("User has received the Magic Link - 2 MIN");

            }

        }
        scenario.log("User has received the Magic Link - JUST NOW");
        driver.switchTo().frame(0);

        waitUtil.elementToBeLocated(octaSignInPage.waitForHereLink);
        String parent=driver.getWindowHandle();
        octaSignInPage.clickOnAuthorizeHereLink();
        scenario.log("User has clicked on Magic Link to complete the Loyalty Enrolment");

        //Navigate to Deloitte Access Token Page
        Thread.sleep(2000);

        //Switch to new window
        ArrayList<String> tab_3rd = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tab_3rd.get(2));//Update if the idex is not proper
        waitUtil.elementToBeLocated(deloitteSecurityLayerPage.accessThroughEntryTokenXpath,30);
        scenario.log("User is landed on Deloitte Security Token Page");


    }



    //Banking SDs
    @And("Open Mailinator and provide {string} then complete signup through magic link")
    public void userShouldOpenMailinatorSiteAndProvideEmailThenClickOnMagicLink(String email) throws InterruptedException {

        driver.switchTo().newWindow(WindowType.TAB);
        Thread.sleep(1000);
        driver.navigate().to(UrlRepo.MAILINATOR_LINK);
        scenario.log("User has opened Mailinator link in new tab");
        waitUtil.elementToBeLocated(octaSignInPage.mailinatorSearchFieldXpath,50);
        octaSignInPage.searchMailToOpenInbox(email);

        octaSignInPage.clickOnGoButton();
        scenario.log("User has opened inbox for the registered email");
        try {
            waitUtil.elementToBeLocated(octaSignInPage.checkRecetOTPMessageJustNow, 10);
            octaSignInPage.clickOnOpenInboxMessage();
            scenario.log("User has received the Magic Link - JUST NOW");
        }
        catch (TimeoutException ex1){
            try {
                driver.navigate().refresh();
                waitUtil.elementToBeLocated(octaSignInPage.checkRecetOTPMessageOneMin, 10);
                octaSignInPage.clickOnOpenInboxMessage();
                scenario.log("User has received the Magic Link - 1 MIN");
            }catch (TimeoutException ex2){
                //2 mins
                waitUtil.elementToBeLocated(octaSignInPage.checkRecetOTPMessageTwoMin, 10);
                octaSignInPage.clickOnOpenInboxMessage();
                scenario.log("User has received the Magic Link - 2 MIN");

            }

        }
//        Thread.sleep(1000);
//        octaSignInPage.clickOnOpenInboxMessage();

        driver.switchTo().frame(0);

        waitUtil.elementToBeLocated(octaSignInPage.waitForMagicLinkXpath);
        String parent=driver.getWindowHandle();
        octaSignInPage.clickOnRegistrationMagicLink();
        scenario.log("User has clicked on Magic Link to complete the Registration");

        //Navigate to Deloitte Access Token Page
        Thread.sleep(2000);

        //Switch to new window
        ArrayList<String> tab_3rd = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tab_3rd.get(2));//Update if the index is not proper

    }


    //Dev ChangeAddress MFA Verification

    //Dev

    @And("User should provide {string} to Mailinator, get the OTP from Mailinator and then authorize Change Address for Retail-Dev")
    public void userShouldProvideToOctaPageGetTheOTPFromMailinatorAndThenAuthorizeTheChangeAddressInRetailDev(String email) throws InterruptedException, IOException {
        String data =readAndWriteTextFiles.readTextFile(FilePaths.RETAIL_DEV_PROGRESSIVE_PROFILING_INDEX_PATH);
        String myEmail = readAndWriteTextFiles.getPreviouslyCreatedEmail(email,data);

        Thread.sleep(2000);
        String climbWindow=driver.getWindowHandle();//climb

        //Launch mailinator in new window
        driver.switchTo().newWindow(WindowType.TAB);
        driver.navigate().to(UrlRepo.MAILINATOR_LINK);
        scenario.log("User has switched from Climb portal -> Mailinator");
        octaSignInPage.searchMailToOpenInbox(myEmail);
        octaSignInPage.clickOnGoButton();

        scenario.log("User has opened inbox for the registered email");
        try {
            waitUtil.elementToBeLocated(octaSignInPage.checkRecetOTPMessageJustNow, 10);
            octaSignInPage.clickOnOpenInboxMessage();
            scenario.log("User has received the Magic Link - JUST NOW");
        }
        catch (TimeoutException ex1){
            try {
                driver.navigate().refresh();
                waitUtil.elementToBeLocated(octaSignInPage.checkRecetOTPMessageOneMin, 10);
                octaSignInPage.clickOnOpenInboxMessage();
                scenario.log("User has received the Magic Link - 1 MIN");
            }catch (TimeoutException ex2){
                //2 mins
                waitUtil.elementToBeLocated(octaSignInPage.checkRecetOTPMessageTwoMin, 10);
                octaSignInPage.clickOnOpenInboxMessage();
                scenario.log("User has received the Magic Link - 2 MIN");

            }

        }

        driver.switchTo().frame(0);

        waitUtil.elementToBeLocated(octaSignInPage.waitForMFAChangeAddressOtp);
        String realOTP = octaSignInPage.getMfaChangeAddressOTP();
        driver.switchTo().defaultContent();
        scenario.log("OTP has been received: "+realOTP);
        Thread.sleep(30);
        //driver.close(); //closing the mailinator window


        //Switch to Mailinator site
        // open "Username" Inbox and get OTP
        //switch back to Octa Screen and pass OTP and Verify
        driver.switchTo().window(climbWindow);
        scenario.log("User has switched from Mailinator -> Climb portal");
        waitUtil.elementToBeLocated(retailProfileOptionsPage.enterCodeInputBoxDevXpath);
        retailProfileOptionsPage.enterOTPToChangeAddressOrPhoneNumber(realOTP);
        scenario.log("User has entered the OTP to do change of address, OTP: "+realOTP);
        retailProfileOptionsPage.clickOnVerifyButton();
        scenario.log("User has clicked on Verify button");
        waitUtil.elementToBeLocated(retailProfileOptionsPage.verificationSuccessfulXpathRef);
        scenario.log("MFA verification is passed.");
//        waitUtil.elementToBeLocated(retailProfileOptionsPage.detailsUpdatedRefXpath,40);
        scenario.log("Profile Details have been updated.");

    }


    //New Bank
    @And("User should check inbox of {string}, get the OTP from Mailinator and provide the OTP to Setup Password page")
    public void userShouldGetTheOTPFromMailinatorAndProvideItToSetupPassword(String email) throws InterruptedException {
        Thread.sleep(2000);
        String setupPasswordWindow=driver.getWindowHandle();//climb

        //Launch mailinator in new window
        driver.switchTo().newWindow(WindowType.TAB);
        driver.navigate().to(UrlRepo.MAILINATOR_LINK);
        scenario.log("User has switched from Setup New Password Page -> Mailinator site");
        octaSignInPage.searchMailToOpenInbox(email);
        octaSignInPage.clickOnGoButton();

        scenario.log("User has opened inbox for the registered email");
        try {
            waitUtil.elementToBeLocated(octaSignInPage.checkRecetOTPMessageJustNow, 10);
            octaSignInPage.clickOnOpenInboxMessage();
            scenario.log("User has received the Magic Link - JUST NOW");
        }
        catch (TimeoutException ex1){
            try {
                driver.navigate().refresh();
                waitUtil.elementToBeLocated(octaSignInPage.checkRecetOTPMessageOneMin, 10);
                octaSignInPage.clickOnOpenInboxMessage();
                scenario.log("User has received the Magic Link - 1 MIN");
            }catch (TimeoutException ex2){
                //2 mins
                waitUtil.elementToBeLocated(octaSignInPage.checkRecetOTPMessageTwoMin, 10);
                octaSignInPage.clickOnOpenInboxMessage();
                scenario.log("User has received the Magic Link - 2 MIN");
            }
        }
        driver.switchTo().frame(0);

        waitUtil.elementToBeLocated(octaSignInPage.waitForChangeForgetPasswordOTPForNewBank);
        String realOTP = octaSignInPage.getForgetPasswordOTP();
        driver.switchTo().defaultContent();//Quit the I-frame
        driver.switchTo().window(setupPasswordWindow);;//Quit the Mailinator window

        scenario.log("OTP has been received: "+realOTP);
        Thread.sleep(300);

        //Enter OTP to Recover Code to Setup Password Page

        waitUtil.elementToBeLocated(newBankWelcomePage.setupNewPasswordRefScreenXpath);
        scenario.log("User has switched from Mailinator site -> Setup New Password Page");
        newBankWelcomePage.enterRecoveryCodeForForgetPassword(realOTP);
        scenario.log("User has provide the Recovery code to setup new password page");

    }

    //New Bank
    @And("User should check inbox of {string}, get the OTP from Mailinator and provide the OTP to Transfer an amount")
    public void userShouldGetTheOTPFromMailinatorAndProvideItToTransferAnAmount(String email) throws InterruptedException {
        Thread.sleep(2000);
        String setupPasswordWindow=driver.getWindowHandle();//climb

        //Launch mailinator in new window
        driver.switchTo().newWindow(WindowType.TAB);
        driver.navigate().to(UrlRepo.MAILINATOR_LINK);
        scenario.log("User has switched from Transfer Page -> Mailinator site");
        octaSignInPage.searchMailToOpenInbox(email);
        octaSignInPage.clickOnGoButton();

        scenario.log("User has opened inbox for the registered email");
        try {
            waitUtil.elementToBeLocated(octaSignInPage.checkRecetOTPMessageJustNow, 10);
            octaSignInPage.clickOnOpenInboxMessage();
            scenario.log("User has received the Magic Link - JUST NOW");
        }
        catch (TimeoutException ex1){
            try {
                driver.navigate().refresh();
                waitUtil.elementToBeLocated(octaSignInPage.checkRecetOTPMessageOneMin, 10);
                octaSignInPage.clickOnOpenInboxMessage();
                scenario.log("User has received the Magic Link - 1 MIN");
            }catch (TimeoutException ex2){
                //2 mins
                waitUtil.elementToBeLocated(octaSignInPage.checkRecetOTPMessageTwoMin, 10);
                octaSignInPage.clickOnOpenInboxMessage();
                scenario.log("User has received the Magic Link - 2 MIN");
            }
        }
        driver.switchTo().frame(0);

        waitUtil.elementToBeLocated(octaSignInPage.waitForChangeForgetPasswordOTPForNewBank);
        String realOTP = octaSignInPage.getForgetPasswordOTP();
        driver.switchTo().defaultContent();//Quit the I-frame
        driver.switchTo().window(setupPasswordWindow);;//Quit the Mailinator window

        scenario.log("OTP has been received: "+realOTP);
        Thread.sleep(300);

        //Enter OTP to Recover Code to Setup Password Page

        waitUtil.elementToBeLocated(newBankTransferPage.otpScreenRefXpath);
        scenario.log("User has switched from Mailinator site -> OTP Section of Transfer Page");
        newBankTransferPage.enterPasscode(realOTP);
        scenario.log("User has provide the Recovery code to Transfer an amount");

    }

    //New Bank
    @And("User should check inbox of {string}, get the OTP from Mailinator and provide the OTP to add MFA device and click on finish")
    public void userShouldGetTheOTPFromMailinatorAndProvideItToAddMfaDevice(String email) throws InterruptedException, IOException {
        String data =readAndWriteTextFiles.readTextFile(FilePaths.NEW_BANK_REGISTER_EMAIL_INDEX_PATH);
        String myEmail = readAndWriteTextFiles.getPreviouslyCreatedEmail(email,data);

        Thread.sleep(2000);
        String addMfaDeviceWindow=driver.getWindowHandle();//climb

        //Launch mailinator in new window
        driver.switchTo().newWindow(WindowType.TAB);
        driver.navigate().to(UrlRepo.MAILINATOR_LINK);
        scenario.log("User has switched from MFA Page -> Mailinator site");
        octaSignInPage.searchMailToOpenInbox(myEmail);
        octaSignInPage.clickOnGoButton();

        scenario.log("User has opened inbox for the registered email");
        try {
            waitUtil.elementToBeLocated(octaSignInPage.checkRecetOTPMessageJustNow, 10);
            octaSignInPage.clickOnOpenInboxMessage();
            scenario.log("User has received the Magic Link - JUST NOW");
        }
        catch (TimeoutException ex1){
            try {
                driver.navigate().refresh();
                waitUtil.elementToBeLocated(octaSignInPage.checkRecetOTPMessageOneMin, 10);
                octaSignInPage.clickOnOpenInboxMessage();
                scenario.log("User has received the Magic Link - 1 MIN");
            }catch (TimeoutException ex2){
                //2 mins
                waitUtil.elementToBeLocated(octaSignInPage.checkRecetOTPMessageTwoMin, 10);
                octaSignInPage.clickOnOpenInboxMessage();
                scenario.log("User has received the Magic Link - 2 MIN");
            }
        }
        driver.switchTo().frame(0);

        waitUtil.elementToBeLocated(octaSignInPage.waitForMFADeviceOtp);
        String realOTP = octaSignInPage.getMfaDeviceOtp();
        driver.switchTo().defaultContent();//Quit the I-frame
        driver.switchTo().window(addMfaDeviceWindow);;//Quit the Mailinator window
        realOTP =realOTP.substring(realOTP.indexOf(": ")+2);

        scenario.log("OTP has been received: "+realOTP);
        Thread.sleep(300);

        //Enter OTP to Recover Code to Setup Password Page

        waitUtil.elementToBeLocated(newBankTransferPage.otpScreenRefXpath);
        scenario.log("User has switched from Mailinator site -> OTP Section of Add MFA device");
        newBankTransferPage.enterPasscode(realOTP);
        scenario.log("User has provide the Recovery code to Add MFA device");
        newBankTransferPage.clickOnFinishButton();
        scenario.log("User has clicked on finish button");

    }








}
