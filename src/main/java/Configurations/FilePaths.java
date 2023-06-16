package Configurations;

public class FilePaths {
    private static final String currentDirectory = System.getProperty("user.dir");
    public static String CHROME_DRIVER_PATH = currentDirectory + "/Drivers/chromedriver114";
    public static String CHROME_DRIVER_PATH_LINUX = currentDirectory + "/Drivers/chromedriverlinux";
    public static String CHROME_DRIVER_PATH_WINDOWS= currentDirectory+"Drivers/chromedriverwindows.exe";
    public static String FIREFOX_DRIVER_PATH = currentDirectory + "/Drivers/geckodriver";
    public static String SAFARI_DRIVER_PATH = currentDirectory + "/Drivers/safaridriver";

    //INDEX FILES FOR UNIQUE TEST DATA PARAMETERS
    public static String BANK_SIGNUP_INDEX_PATH = currentDirectory + "/Resources/BankSignUpIndex.txt";
    public static String HEALTH_SIGNUP_INDEX_PATH = currentDirectory + "/Resources/HealthSignUpIndex.txt";
    public static String RETAIL_SIGNUP_INDEX_PATH = currentDirectory + "/Resources/RetailSignUpIndex.txt";
    public static String RETAIL_DEV_SIGNUP_INDEX_PATH=currentDirectory+"/Resources/RetailDevSignUpIndex.txt";
    public static String NEW_BANK_REGISTER_GOVT_INDEX_PATH = currentDirectory + "/Resources/NewBankRegisterGovtIndex.txt";
    public static String NEW_BANK_REGISTER_EMAIL_INDEX_PATH = currentDirectory + "/Resources/NewBankRegisterEmailIndex.txt";

    public static String RETAIL_DEMO_PROGRESSIVE_PROFILING_INDEX_PATH = currentDirectory + "/Resources/RetailDemoProgressiveProfilingIndex.txt";
    public static String RETAIL_DEV_PROGRESSIVE_PROFILING_INDEX_PATH = currentDirectory + "/Resources/RetailDevProgressiveProfilingIndex.txt";


    public static String CORS_PLUGIN_PATH = currentDirectory + "/Drivers/cors_unblock.crx";
    //Health
    public static String CORS_PLUGIN_PATH_Health_Pref = currentDirectory + "/Drivers/cors_unblock_health_pref.crx";
    public static String CORS_PLUGIN_PATH_Health_Privacy = currentDirectory + "/Drivers/cors_unblock_health_privacy.crx";
    //Bank
    public static String CORS_PLUGIN_PATH_Bank_Pref = currentDirectory + "/Drivers/cors_unblock_bank_pref.crx";
    public static String CORS_PLUGIN_PATH_Bank_Privacy = currentDirectory + "/Drivers/cors_unblock_bank_privacy.crx";

    public static String RETAIL_TEST_SIGN_UP_DATA_PATH = currentDirectory + "/TestData/RetailSignUpInputData.csv";
    public static String RETAIL_DEV_SIGNUP_DATA_PATH = currentDirectory + "/TestData/RetailSignUpInputDataDev.csv";
    public static String BANKING_TEST_SIGN_UP_DATA_PATH = currentDirectory + "/TestData/BankingSignUpInputData.csv";
    public static String NEW_BANKING_TEST_SIGN_UP_GOVT_DATA_PATH = currentDirectory + "/TestData/NewBankRegisterGovtIDData.csv";
    public static String NEW_BANKING_TEST_SIGN_UP_EMAIL_MFA_DATA_PATH = currentDirectory + "/TestData/NewBankRegisterEmailMFAData.csv";


    public static String RETAIL_DEMO_UPDATE_PASSWORD_INDEX = currentDirectory+ "/Resources/RetailDemoUpdatePassword.txt";
    public static String RETAIL_DEV_UPDATE_PASSWORD_INDEX = currentDirectory+ "/Resources/RetailDevUpdatePassword.txt";

    public static String WELLNESS_TEST_SIGN_UP_DATA_PATH = currentDirectory + "/TestData/WellnessRegistrationInputData.csv";

    public static String chromeProperty = "webdriver.chrome.driver";
    public static String firefoxProperty = "webdriver.gecko.driver";
    public static String safariProperty = "webdriver.safari.driver";




    public static String getDriverPath() {
        String osName=System.getProperty("os.name");
        String driverPath;
        if (osName.equalsIgnoreCase("Mac OS X")) {
            driverPath = FilePaths.CHROME_DRIVER_PATH;
            System.out.println("Operating System Info: MAC OS");
        }
        else if(osName.equalsIgnoreCase("Windows 10")){
                driverPath= FilePaths.CHROME_DRIVER_PATH_WINDOWS;
                System.out.println("Operating System Info: WINDOWS 10");
        }
        else{
            driverPath= FilePaths.CHROME_DRIVER_PATH_LINUX;
            System.out.println("Operating System Info: LINUX");
        }
        return driverPath;
    }

//    public static void main(String chec[]){
//        String memIDDummy = map.toString();
//        String memID= memIDDummy.substring(0,memIDDummy.indexOf("."));
//        System.out.println(res);
//    }
}
