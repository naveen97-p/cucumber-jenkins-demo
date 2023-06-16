package StepDefinitions.CommonDefinitions;

import Configurations.FilePaths;
import Configurations.Passcodes;
import Utilities.BrowserInstance;
import Utilities.WriteToCSV;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Then;

import java.io.IOException;

public class FeedTestDataToFilesSD extends BrowserInstance {

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
    //Demo
    @Then("User feeds the test data of Retail {string}, {string}, {string},{string},{string} to csv file")
    public void userFeedsTheTestDataToCsvFile(String userName, String firstName, String lastName, String termsAndConditions, String receiveEmails) throws IOException {
        //Username,Password, FirstName, LastName, Email, NewsLetters
        //Get the Index and Create Email and Username
        String data =readAndWriteTextFiles.readTextFile(FilePaths.RETAIL_SIGNUP_INDEX_PATH);
        String myEmail = readAndWriteTextFiles.createAnUniqueEmailEntry(userName,data);
        //Update if the data is used
        readAndWriteTextFiles.updateTextFile(data, FilePaths.RETAIL_SIGNUP_INDEX_PATH);

        String receiveEmailsDecision;
        if(receiveEmails.equalsIgnoreCase("True")){receiveEmailsDecision = "YES";} else{receiveEmailsDecision = "NO";}
        String feedDataFormat = myEmail+","+ Passcodes.STANDARD_PASSWORD+","+firstName+","+lastName+","+userName+","+receiveEmailsDecision;
        try {
            WriteToCSV.feedDataToCSVFile(feedDataFormat, true, FilePaths.RETAIL_TEST_SIGN_UP_DATA_PATH);
            scenario.log("Test Data is loaded to CSV file in this path:"+ FilePaths.RETAIL_TEST_SIGN_UP_DATA_PATH);
        }
        catch (IOException exception){
            scenario.log("Kindly create or keep the file with name as: \"RetailSignUpInputData.csv\" in this path: "+ FilePaths.RETAIL_TEST_SIGN_UP_DATA_PATH);
            scenario.log("Error Details:"+exception);
        }

    }
    //Demo
    @Then("User feeds the test data of new Bank {string}, {string}, {string}, {string} to csv file")
    public void userFeedsTheNewBankTestDataToCsvFile(String email, String firstName, String lastName, String typeOfTesting) throws IOException {
        //Username,Password, FirstName, LastName, Email, NewsLetters
        //Get the Index and Create Email and Username
        if (typeOfTesting.equalsIgnoreCase("positive")) {
            String data = readAndWriteTextFiles.readTextFile(FilePaths.NEW_BANK_REGISTER_EMAIL_INDEX_PATH);
            String myEmail = readAndWriteTextFiles.createAnUniqueEmailEntry(email, data);
            String usernameIndex = readAndWriteTextFiles.getUsernameFromEmailAndIndex(email, data);
            //Update if the data is used
            readAndWriteTextFiles.updateTextFile(data, FilePaths.NEW_BANK_REGISTER_EMAIL_INDEX_PATH);

            String feedDataFormat = usernameIndex + "," + Passcodes.NEW_BANKING_PASSWORD + "," + firstName + "," + lastName + "," + myEmail;
            try {
                WriteToCSV.feedDataToCSVFile(feedDataFormat, true, FilePaths.NEW_BANKING_TEST_SIGN_UP_EMAIL_MFA_DATA_PATH);
                scenario.log("Test Data is loaded to CSV file in this path:" + FilePaths.NEW_BANKING_TEST_SIGN_UP_EMAIL_MFA_DATA_PATH);
            } catch (IOException exception) {
                scenario.log("Kindly create or keep the file with name as: \"RetailSignUpInputData.csv\" in this path: " + FilePaths.NEW_BANKING_TEST_SIGN_UP_EMAIL_MFA_DATA_PATH);
                scenario.log("Error Details:" + exception);
            }
        }else {
                scenario.log("Skipping the Test as it falls under Negative testing");
            }
    }

    //DemoUpdatePassword
    //Demo
    @Then("User feeds the test data of Retail {string}, {string}, {string},{string},{string} to csv file demo update password")
    public void userFeedsTheTestDataToCsvFileUpdatePasswordDemo(String userName, String firstName, String lastName, String typeOfTesting, String receiveEmails) throws IOException {
        //Username,Password, FirstName, LastName, Email, NewsLetters
        //Get the Index and Create Email and Username
        String data =readAndWriteTextFiles.readTextFile(FilePaths.RETAIL_DEMO_UPDATE_PASSWORD_INDEX);
        String myEmail = readAndWriteTextFiles.createAnUniqueEmailEntry(userName,data);
        //Update if the data is used
        readAndWriteTextFiles.updateTextFile(data, FilePaths.RETAIL_DEMO_UPDATE_PASSWORD_INDEX);

        String receiveEmailsDecision;
        if(receiveEmails.equalsIgnoreCase("True")){receiveEmailsDecision = "YES";} else{receiveEmailsDecision = "NO";}
        String feedDataFormat = myEmail+","+ Passcodes.STANDARD_PASSWORD+","+firstName+","+lastName+","+userName+","+receiveEmailsDecision;
        try {
            WriteToCSV.feedDataToCSVFile(feedDataFormat, true, FilePaths.RETAIL_TEST_SIGN_UP_DATA_PATH);
            scenario.log("Test Data is loaded to CSV file in this path:"+ FilePaths.RETAIL_TEST_SIGN_UP_DATA_PATH);
        }
        catch (IOException exception){
            scenario.log("Kindly create or keep the file with name as: \"RetailSignUpInputData.csv\" in this path: "+ FilePaths.RETAIL_TEST_SIGN_UP_DATA_PATH);
            scenario.log("Error Details:"+exception);
        }

    }
//Dev update password
    @Then("User feeds the test data of Retail {string}, {string}, {string},{string},{string} to csv file dev update password")
    public void userFeedsTheTestDataToCsvFileUpdatePasswordDev(String userName, String firstName, String lastName, String termsAndConditions, String receiveEmails) throws IOException {
        //Username,Password, FirstName, LastName, Email, NewsLetters
        //Get the Index and Create Email and Username
            String data = readAndWriteTextFiles.readTextFile(FilePaths.RETAIL_DEV_UPDATE_PASSWORD_INDEX);
            String myEmail = readAndWriteTextFiles.createAnUniqueEmailEntry(userName, data);
            //Update if the data is used
            readAndWriteTextFiles.updateTextFile(data, FilePaths.RETAIL_DEV_UPDATE_PASSWORD_INDEX);

            String receiveEmailsDecision;
            if (receiveEmails.equalsIgnoreCase("True")) {
                receiveEmailsDecision = "YES";
            } else {
                receiveEmailsDecision = "NO";
            }
            String feedDataFormat = myEmail + "," + Passcodes.STANDARD_PASSWORD + "," + firstName + "," + lastName + "," + userName + "," + receiveEmailsDecision;
            try {
                WriteToCSV.feedDataToCSVFile(feedDataFormat, true, FilePaths.RETAIL_DEV_SIGNUP_DATA_PATH);
                scenario.log("Test Data is loaded to CSV file in this path:" + FilePaths.RETAIL_DEV_SIGNUP_DATA_PATH);
            } catch (IOException exception) {
                scenario.log("Kindly create or keep the file with name as: \"RetailSignUpInputData.csv\" in this path: " + FilePaths.RETAIL_DEV_SIGNUP_DATA_PATH);
                scenario.log("Error Details:" + exception);
            }
    }

    //Dev Work On
    @Then("User feeds the test data of Retail Dev {string}, {string}, {string},{string},{string} to csv file for sign-up")
    public void userFeedsTheTestDataToCsvFileDevForSignUp(String userName, String firstName, String lastName, String termsAndConditions, String receiveEmails) throws IOException {
        //Username,Password, FirstName, LastName, Email, NewsLetters
        //Get the Index and Create Email and Username
        String data =readAndWriteTextFiles.readTextFile(FilePaths.RETAIL_DEV_SIGNUP_INDEX_PATH);
        String myEmail = readAndWriteTextFiles.createAnUniqueEmailEntry(userName,data);
        //Update if the data is used
        readAndWriteTextFiles.updateTextFile(data, FilePaths.RETAIL_DEV_SIGNUP_INDEX_PATH);

        String receiveEmailsDecision;
        if(receiveEmails.equalsIgnoreCase("True")){receiveEmailsDecision = "YES";} else{receiveEmailsDecision = "NO";}
        String feedDataFormat = myEmail+","+ Passcodes.STANDARD_PASSWORD+","+firstName+","+lastName+","+userName+","+receiveEmailsDecision;
        try {
            WriteToCSV.feedDataToCSVFile(feedDataFormat, true, FilePaths.RETAIL_DEV_SIGNUP_DATA_PATH);
            scenario.log("Test Data is loaded to CSV file in this path:"+ FilePaths.RETAIL_DEV_SIGNUP_DATA_PATH);
        }
        catch (IOException exception){
            scenario.log("Kindly create or keep the file with name as: \"RetailSignUpInputDataDev.csv\" in this path: "+ FilePaths.RETAIL_DEV_SIGNUP_DATA_PATH);
            scenario.log("Error Details:"+exception);
        }

    }

    //Demo
    @Then("User feeds the test data of Retail demo {string}, {string}, {string} to csv file")
    public void userFeedsTheTestDataToCsvFileDemo(String userName, String termsAndConditions, String receiveEmails) throws IOException {
        //Username,Password, FirstName, LastName, Email, NewsLetters
        //Get the Index and Create Email and Username
        String data =readAndWriteTextFiles.readTextFile(FilePaths.RETAIL_DEMO_PROGRESSIVE_PROFILING_INDEX_PATH);
        System.out.println("Index Current Value:"+data);
        String myEmail = readAndWriteTextFiles.createAnUniqueEmailEntry(userName,data);
        //Update if the data is used
        readAndWriteTextFiles.updateTextFile(data, FilePaths.RETAIL_DEMO_PROGRESSIVE_PROFILING_INDEX_PATH);
        data =readAndWriteTextFiles.readTextFile(FilePaths.RETAIL_DEMO_PROGRESSIVE_PROFILING_INDEX_PATH);
        System.out.println("Index Updated Value:"+data);
        String receiveEmailsDecision;
        if(receiveEmails.equalsIgnoreCase("True")){receiveEmailsDecision = "YES";} else{receiveEmailsDecision = "NO";}
        String feedDataFormat = myEmail+","+ Passcodes.STANDARD_PASSWORD+","+userName+","+receiveEmailsDecision;
        try {
            WriteToCSV.feedDataToCSVFile(feedDataFormat, true, FilePaths.RETAIL_TEST_SIGN_UP_DATA_PATH);
            scenario.log("Test Data is loaded to CSV file in this path:"+ FilePaths.RETAIL_TEST_SIGN_UP_DATA_PATH);
        }
        catch (IOException exception){
            scenario.log("Kindly create or keep the file with name as: \"RetailSignUpInputData.csv\" in this path: "+ FilePaths.RETAIL_TEST_SIGN_UP_DATA_PATH);
            scenario.log("Error Details:"+exception);
        }

    }

//Dev
@Then("User feeds the test data of Retail demo {string}, {string}, {string} to csv file for Dev")
public void userFeedsTheTestDataToCsvFileDev(String userName, String termsAndConditions, String receiveEmails) throws IOException {
    //Username,Password, FirstName, LastName, Email, NewsLetters
    //Get the Index and Create Email and Username
    String data =readAndWriteTextFiles.readTextFile(FilePaths.RETAIL_DEV_PROGRESSIVE_PROFILING_INDEX_PATH);
    System.out.println("Index Current Value:"+data);
    String myEmail = readAndWriteTextFiles.createAnUniqueEmailEntry(userName,data);
    //Update if the data is used
    readAndWriteTextFiles.updateTextFile(data, FilePaths.RETAIL_DEV_PROGRESSIVE_PROFILING_INDEX_PATH);
    data =readAndWriteTextFiles.readTextFile(FilePaths.RETAIL_DEV_PROGRESSIVE_PROFILING_INDEX_PATH);
    System.out.println("Index Updated Value:"+data);
    String receiveEmailsDecision;
    if(receiveEmails.equalsIgnoreCase("True")){receiveEmailsDecision = "YES";} else{receiveEmailsDecision = "NO";}
    String feedDataFormat = myEmail+","+ Passcodes.STANDARD_PASSWORD+","+userName+","+receiveEmailsDecision;
    try {
        WriteToCSV.feedDataToCSVFile(feedDataFormat, true, FilePaths.RETAIL_DEV_SIGNUP_DATA_PATH);
        scenario.log("Test Data is loaded to CSV file in this path:"+ FilePaths.RETAIL_DEV_SIGNUP_DATA_PATH);
    }
    catch (IOException exception){
        scenario.log("Kindly create or keep the file with name as: \"RetailSignUpInputData.csv\" in this path: "+ FilePaths.RETAIL_DEV_SIGNUP_DATA_PATH);
        scenario.log("Error Details:"+exception);
    }

}



    @Then("User feeds the test data of Wellness {string}, {string}, {string}, {string}, {string}, {string},{string}, {string} to csv file")
    public void userFeedsTheTestDataOfWellnessToCsvFile(String roleType, String email, String firstName, String lastName, String userName, String termsAndConditions, String receiveEmails, String typeOfTesting) throws IOException {
        //Get the Index and Create Email and Username
        String data =readAndWriteTextFiles.readTextFile(FilePaths.HEALTH_SIGNUP_INDEX_PATH);
        String myEmail = readAndWriteTextFiles.createAnUniqueEmailEntry(email,data);
        String usernameFromEmail = readAndWriteTextFiles.getUsernameFromEmail(myEmail);
        //Update if the data is used
        readAndWriteTextFiles.updateTextFile(data, FilePaths.HEALTH_SIGNUP_INDEX_PATH);

        if(typeOfTesting.equalsIgnoreCase("positive")){
               String receiveEmailsDecision;
               if(receiveEmails.equalsIgnoreCase("True")){receiveEmailsDecision = "YES";} else{receiveEmailsDecision = "NO";}
               String feedDataFormat = roleType+","+myEmail+","+firstName+","+lastName+","+usernameFromEmail+","+termsAndConditions+","+receiveEmailsDecision;
               try {
                   WriteToCSV.feedDataToCSVFile(feedDataFormat, true, FilePaths.WELLNESS_TEST_SIGN_UP_DATA_PATH);
                   scenario.log("Test Data is loaded to CSV file in this path:"+ FilePaths.WELLNESS_TEST_SIGN_UP_DATA_PATH);
               }
               catch (IOException exception){
                   scenario.log("Kindly create or keep the file with name as: \"WellnessRegistrationInputData.csv\" in this path: "+ FilePaths.WELLNESS_TEST_SIGN_UP_DATA_PATH);
                   scenario.log("Error Details:"+exception);
               }
           }else{
               scenario.log("IGNORE: Loading the data into the CSV file as the test is with Invalid data");
           }
        }


    @Then("User feeds the test data of Banking {string}, {string}, {string}, {string},{string} to csv file {string}")
    public void userFeedsTheTestDataOfBankingToCsvFile(String email, String userName, String firstName, String lastName, String termsAndConditions, String typeOfTesting) {
        // Email,Username,Password, FirstName, LastName, T&C
        if (typeOfTesting.equalsIgnoreCase("Positive")) {

            String termsAndCondiDecision;
            if (termsAndConditions.equalsIgnoreCase("True")) {
                termsAndCondiDecision = "YES";
            } else {
                termsAndCondiDecision = "NO";
            }
            String feedDataFormat = email + "," + userName + "," + Passcodes.BANKING_PASSWORD + "," + firstName + "," + lastName + "," + termsAndCondiDecision;
            try {
                WriteToCSV.feedDataToCSVFile(feedDataFormat, true, FilePaths.BANKING_TEST_SIGN_UP_DATA_PATH);
                scenario.log("Test Data is loaded to CSV file in this path:" + FilePaths.BANKING_TEST_SIGN_UP_DATA_PATH);
            } catch (IOException exception) {
                scenario.log("Kindly create or keep the file with name as: \"BankingSignUpInputData.csv\" in this path: " + FilePaths.BANKING_TEST_SIGN_UP_DATA_PATH);
                scenario.log("Error Details:" + exception);
            }

        }else{
            scenario.log("Negative Test Case: User Data doesn't store for Invalid Test Data Test");
        }
    }
}
