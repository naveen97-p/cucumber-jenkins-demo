package Utilities;

import Configurations.FilePaths;
import Configurations.SetUpDriverConfigurations;
import Pages.Banking.*;
import Pages.CommonPages.*;
import Pages.Health.*;
import Pages.NewBank.*;
import Pages.Retail.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SessionNotCreatedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class BrowserInstance {
    public static WebDriver driver = null;

    //Explicitly Declare all Pages information and Declaration should be done here
    protected static WaitUtil waitUtil;
    protected static CustomExceptions customExceptions;
    protected static CaptureScreen captureScreen;
    protected static OctaSignInPage octaSignInPage;
    protected static SoftAssert softAssert ;
    protected static JavascriptExecutor javascript ;
    protected static Actions actions;
    public static ReadAndWriteTextFiles readAndWriteTextFiles;
    protected static File cors_file = new File(FilePaths.CORS_PLUGIN_PATH);
    protected static RandomStrings randomStrings;



    //START: ---------------RETAIL PAGES-----------------------//
    protected static RetailLoginPage retailLoginPage;
    protected static RetailWelcomePage retailWelcomePage;
    protected static RetailSignUpWithEmailPage retailSignUpWithEmailPage;
    protected static CookiesPopUpPage cookiesPopUpPage;
    protected static GoogleOktaPage googleOktaPage;
    protected static FacebookOktaPage facebookOktaPage;
    protected static RetailSignUpPage retailSignUpPage;
    protected static RetailProfileOptionsPage retailProfileOptionsPage;
    protected static RetailPrivacyWebFormPage retailPrivacyWebFormPage;
    protected static DeloitteSecurityLayerPage deloitteSecurityLayerPage;
    //END: ---------------RETAIL PAGES-----------------------//


    //START: ---------------HEALTH PAGES-----------------------//
    protected static HealthWelcomePage healthWelcomePage;
    protected static HealthRegistrationPage healthRegistrationPage;
    protected static HealthLoginPage healthLoginPage;
    protected static HealthHomeScreenPage healthHomeScreenPage;
    protected static HealthConfigureRegistrationPage healthConfigureRegistrationPage;
    static DesiredCapabilities capabilities = new DesiredCapabilities();
    static ChromeOptions chromeOptions = new ChromeOptions();

    //END  : ---------------HEALTH PAGES-----------------------//



    //START: ---------------BANK PAGES-----------------------//
    protected static BankingWelcomePage bankingWelcomePage;
    protected static BankingLoginPage bankingLoginPage;
    protected static BankingSignUpPage bankingSignUpPage;
    protected static BankingSignUpEmailPage bankingSignUpEmailPage;
    protected static BankingLoggedInHomePage bankingLoggedInHomePage;
    protected static BankingProfileOptionsPage bankingProfileOptionsPage;
    protected static BankingTransfersPage bankingTransfersPage;
    protected static BankingBrokerageAccountPage bankingBrokerageAccountPage;
    //END: ---------------BANK PAGES-----------------------//

    //START:---------------NEW BANK PAGES------------------//
    protected static NewBankOpenAnAccountPage newBankOpenAnAccountPage;
    protected static NewBankWelcomePage newBankWelcomePage;
    protected static NewBankHomePage newBankHomePage;
    protected static NewBankProfileOptionsPage newBankProfileOptionsPage;
    protected static NewBankSignUpPage newBankSignUpPage;
    protected static NewBankTransferPage newBankTransferPage;
    protected static NewBankUtilitiesPage newBankUtilitiesPage;
    //END:---------------NEW BANK PAGES------------------//




    public static WebDriver getDriver(String nameOfTheBrowser, String testEnvironmentUrl) throws InterruptedException {




        if (nameOfTheBrowser.equalsIgnoreCase("CHROME")) {
            //incognito window START
            runInIncognitoMode(SetUpDriverConfigurations.RUN_SCRIPTS_IN_INCOGNITO_MODE);


            //incognito window END
            chromeOptions.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking","enable-automation"));
            chromeOptions.addArguments("--start-maximized");
            chromeOptions.addArguments("--disable-web-security");
            chromeOptions.addArguments("--no-proxy-server");
            chromeOptions.addArguments("test-type");
            chromeOptions.addArguments("disable-popup-blocking");

            //Save or Disable Passwords Alert in Chrome START
            Map<String, Object> prefs = new HashMap<String, Object>();
            prefs.put("credentials_enable_service", SetUpDriverConfigurations.ENABLE_SAVE_PASSWORDS_ALERT_EVERYTIME);
            prefs.put("profile.password_manager_enabled", SetUpDriverConfigurations.ENABLE_SAVE_PASSWORDS_ALERT_EVERYTIME);
            chromeOptions.setExperimentalOption("prefs", prefs);
            //Save or Disable Passwords Alert in Chrome END
           //chromeOptions.setExperimentalOption("debuggerAddress", "127.0.0.1:2100");
            chromeOptions.addArguments("--disable-gpu");



            //Using accept insecure cert method with true as parameter to accept the untrusted certificate
            chromeOptions.setAcceptInsecureCerts(true);
            if(SetUpDriverConfigurations.ENABLE_CORS_CHROME_PLUGIN) {
                chromeOptions.addArguments("–load-extension="+FilePaths.CORS_PLUGIN_PATH);
                chromeOptions.addExtensions(cors_file);

            }
//            chromeOptions.addArguments("--user-data-dir=/Users/navepilla/Library/Application Support/Google/Chrome");
//            chromeOptions.addArguments("--start-maximized");

            //chromeOptions.addArguments("--disable-web-security", "--user-data-dir=true", "--allow-running-insecure-content");
            // Mozilla/5.0 (X11; CrOS x86_64 14816.99.0) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/103.0.0.0 Safari/537.36
            //chromeOptions.addArguments("Mozilla/5.0 (X11; CrOS x86_64 14816.99.0) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/104.0.0.0 Safari/537.36");
            chromeOptions.setHeadless(SetUpDriverConfigurations.RUN_SCRIPTS_IN_HIDE_MODE);
           System.setProperty(FilePaths.chromeProperty, FilePaths.getDriverPath());

            //CORS Plugin integration below


            driver = new ChromeDriver(chromeOptions);
//            for(int i=0;i<=9;i++){
//            try {
//                driver = new ChromeDriver(chromeOptions);
//                break;
//                }
//            catch (SessionNotCreatedException sessionException){
//                Thread.sleep(2000);
//                System.out.println("Session is not created! Re-Trying..");
//                }
//            }

        } else if (nameOfTheBrowser.equalsIgnoreCase("FIREFOX")) {
            System.setProperty(FilePaths.firefoxProperty, FilePaths.FIREFOX_DRIVER_PATH);
            driver = new FirefoxDriver();
        } else if (nameOfTheBrowser.equalsIgnoreCase("SAFARI")) {
            //System.setProperty(FilePaths.safariProperty, FilePaths.SAFARI_DRIVER_PATH);
            driver = new SafariDriver();
        } else {
            //Making Default Browser as CHROME if Automation Developer makes mistake to provide accepted browser name by the script
            System.setProperty(FilePaths.chromeProperty, FilePaths.getDriverPath());
            driver = new ChromeDriver(chromeOptions);
        }
        driver.manage().getCookies();
        driver.manage().window().maximize();
        driver.get(testEnvironmentUrl);

        //START: ---------------UTILITY PAGES-----------------------//
        waitUtil = new WaitUtil();
        customExceptions = new CustomExceptions();
        octaSignInPage = new OctaSignInPage();
        softAssert = new SoftAssert();
        javascript =  (JavascriptExecutor)driver;
        actions = new Actions(driver);
        readAndWriteTextFiles = new ReadAndWriteTextFiles();
        randomStrings = new RandomStrings();
        //END: ---------------UTILITY PAGES-----------------------//


        //START: ---------------RETAIL PAGES-----------------------//
        retailLoginPage = new RetailLoginPage();
        retailWelcomePage = new RetailWelcomePage();
        cookiesPopUpPage = new CookiesPopUpPage();
        captureScreen = new CaptureScreen();
        googleOktaPage = new GoogleOktaPage();
        facebookOktaPage = new FacebookOktaPage();
        retailSignUpWithEmailPage = new RetailSignUpWithEmailPage();
        retailSignUpPage = new RetailSignUpPage();
        retailProfileOptionsPage = new RetailProfileOptionsPage();
        retailPrivacyWebFormPage = new RetailPrivacyWebFormPage();
        deloitteSecurityLayerPage = new DeloitteSecurityLayerPage();
        //END: ---------------RETAIL PAGES-----------------------//


        //START: ---------------HEALTH PAGES-----------------------//
        healthWelcomePage = new HealthWelcomePage();
        healthRegistrationPage = new HealthRegistrationPage();
        healthLoginPage = new HealthLoginPage();
        healthHomeScreenPage = new HealthHomeScreenPage();
        healthConfigureRegistrationPage = new HealthConfigureRegistrationPage();
        //END: ---------------HEALTH PAGES-----------------------//



        //START: ---------------BANK PAGES-----------------------//
        bankingWelcomePage = new BankingWelcomePage();
        bankingLoginPage = new BankingLoginPage();
        bankingSignUpPage = new BankingSignUpPage();
        bankingSignUpEmailPage = new BankingSignUpEmailPage();
        bankingLoggedInHomePage = new BankingLoggedInHomePage();
        bankingSignUpPage = new BankingSignUpPage();
        bankingProfileOptionsPage = new BankingProfileOptionsPage();
        bankingTransfersPage = new BankingTransfersPage();
        bankingBrokerageAccountPage = new BankingBrokerageAccountPage();
        //END: ---------------BANK PAGES-----------------------//


        //START: ---------------NEW BANK PAGES-----------------//
        newBankOpenAnAccountPage = new NewBankOpenAnAccountPage();
        newBankWelcomePage = new NewBankWelcomePage();

        newBankHomePage = new NewBankHomePage();
        newBankProfileOptionsPage = new NewBankProfileOptionsPage();
        newBankSignUpPage = new NewBankSignUpPage();
        newBankTransferPage = new NewBankTransferPage();
        newBankUtilitiesPage = new NewBankUtilitiesPage();
        //END: -----------------NEW BANK PAGES----------------//

        return driver;
    }

    public static WebDriver getDriver(String nameOfTheBrowser, String testEnvironmentUrl, boolean corsUnblockEnable) throws InterruptedException {


        if (nameOfTheBrowser.equalsIgnoreCase("CHROME")) {
            //incognito window START
            runInIncognitoMode(SetUpDriverConfigurations.RUN_SCRIPTS_IN_INCOGNITO_MODE);


            //incognito window END
            chromeOptions.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking","enable-automation"));
            chromeOptions.addArguments("--start-maximized");
            chromeOptions.addArguments("--disable-web-security");
            chromeOptions.addArguments("--no-proxy-server");
            chromeOptions.addArguments("test-type");
            chromeOptions.addArguments("disable-popup-blocking");
            chromeOptions.addArguments("--remote-allow-origins=*");

            //Save or Disable Passwords Alert in Chrome START
            Map<String, Object> prefs = new HashMap<String, Object>();
            prefs.put("credentials_enable_service", SetUpDriverConfigurations.ENABLE_SAVE_PASSWORDS_ALERT_EVERYTIME);
            prefs.put("profile.password_manager_enabled", SetUpDriverConfigurations.ENABLE_SAVE_PASSWORDS_ALERT_EVERYTIME);
            chromeOptions.setExperimentalOption("prefs", prefs);
            //Save or Disable Passwords Alert in Chrome END
            //chromeOptions.setExperimentalOption("debuggerAddress", "127.0.0.1:2100");
//            chromeOptions.addArguments("--disable-gpu");
//            chromeOptions.addArguments("--disable-blink-features=AutomationControlled");
//            chromeOptions.addArguments("--disable-extensions");
//            chromeOptions.setExperimentalOption("useAutomationExtension", false);
            //chromeOptions.setExperimentalOption("excludeSwitches",false);



            //Using accept insecure cert method with true as parameter to accept the untrusted certificate
            chromeOptions.setAcceptInsecureCerts(true);
            if(corsUnblockEnable) {
                chromeOptions.addArguments("–load-extension="+FilePaths.CORS_PLUGIN_PATH);
                chromeOptions.addExtensions(cors_file);

            }
//            chromeOptions.addArguments("--user-data-dir=/Users/navepilla/Library/Application Support/Google/Chrome");
//            chromeOptions.addArguments("--start-maximized");

            //chromeOptions.addArguments("--disable-web-security", "--user-data-dir=true", "--allow-running-insecure-content");
            // Mozilla/5.0 (X11; CrOS x86_64 14816.99.0) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/103.0.0.0 Safari/537.36
            //chromeOptions.addArguments("Mozilla/5.0 (X11; CrOS x86_64 14816.99.0) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/104.0.0.0 Safari/537.36");

            if(SetUpDriverConfigurations.RUN_SCRIPTS_IN_HIDE_MODE) {
                chromeOptions.setHeadless(true);
                chromeOptions.addArguments("window-size=1920,1080");
            }


            System.setProperty(FilePaths.chromeProperty, FilePaths.getDriverPath());

            driver = new ChromeDriver(chromeOptions);


        } else if (nameOfTheBrowser.equalsIgnoreCase("FIREFOX")) {
            System.setProperty(FilePaths.firefoxProperty, FilePaths.FIREFOX_DRIVER_PATH);
            driver = new FirefoxDriver();
        } else if (nameOfTheBrowser.equalsIgnoreCase("SAFARI")) {
            //System.setProperty(FilePaths.safariProperty, FilePaths.SAFARI_DRIVER_PATH);
            driver = new SafariDriver();
        } else {
            //Making Default Browser as CHROME if Automation Developer makes mistake to provide accepted browser name by the script
            System.setProperty(FilePaths.chromeProperty, FilePaths.getDriverPath());
            driver = new ChromeDriver(chromeOptions);
        }
        driver.manage().getCookies();
        driver.manage().window().maximize();
        driver.get(testEnvironmentUrl);

        //START: ---------------UTILITY PAGES-----------------------//
        waitUtil = new WaitUtil();
        customExceptions = new CustomExceptions();
        octaSignInPage = new OctaSignInPage();
        softAssert = new SoftAssert();
        javascript =  (JavascriptExecutor)driver;
        actions = new Actions(driver);
        readAndWriteTextFiles = new ReadAndWriteTextFiles();
        randomStrings = new RandomStrings();
        //END: ---------------UTILITY PAGES-----------------------//


        //START: ---------------RETAIL PAGES-----------------------//
        retailLoginPage = new RetailLoginPage();
        retailWelcomePage = new RetailWelcomePage();
        cookiesPopUpPage = new CookiesPopUpPage();
        captureScreen = new CaptureScreen();
        googleOktaPage = new GoogleOktaPage();
        facebookOktaPage = new FacebookOktaPage();
        retailSignUpWithEmailPage = new RetailSignUpWithEmailPage();
        retailSignUpPage = new RetailSignUpPage();
        retailProfileOptionsPage = new RetailProfileOptionsPage();
        retailPrivacyWebFormPage = new RetailPrivacyWebFormPage();
        deloitteSecurityLayerPage = new DeloitteSecurityLayerPage();
        //END: ---------------RETAIL PAGES-----------------------//


        //START: ---------------HEALTH PAGES-----------------------//
        healthWelcomePage = new HealthWelcomePage();
        healthRegistrationPage = new HealthRegistrationPage();
        healthLoginPage = new HealthLoginPage();
        healthHomeScreenPage = new HealthHomeScreenPage();
        healthConfigureRegistrationPage = new HealthConfigureRegistrationPage();
        //END: ---------------HEALTH PAGES-----------------------//

        //START: ---------------BANK PAGES-----------------------//
        bankingWelcomePage = new BankingWelcomePage();
        bankingLoginPage = new BankingLoginPage();
        bankingSignUpPage = new BankingSignUpPage();
        bankingSignUpEmailPage = new BankingSignUpEmailPage();
        bankingLoggedInHomePage = new BankingLoggedInHomePage();
        bankingSignUpPage = new BankingSignUpPage();
        bankingProfileOptionsPage = new BankingProfileOptionsPage();
        bankingTransfersPage = new BankingTransfersPage();
        bankingBrokerageAccountPage = new BankingBrokerageAccountPage();
        //END: ---------------BANK PAGES-----------------------//

        //START: ---------------NEW BANK PAGES-----------------//
        newBankOpenAnAccountPage = new NewBankOpenAnAccountPage();
        newBankWelcomePage = new NewBankWelcomePage();

        newBankHomePage = new NewBankHomePage();
        newBankProfileOptionsPage = new NewBankProfileOptionsPage();
        newBankSignUpPage = new NewBankSignUpPage();
        newBankTransferPage = new NewBankTransferPage();
        newBankUtilitiesPage = new NewBankUtilitiesPage();
        //END: -----------------NEW BANK PAGES----------------//

        return driver;
    }

    public static WebDriver getDriver(String nameOfTheBrowser, String testEnvironmentUrl, String corsPluginPath) throws InterruptedException {


        if (nameOfTheBrowser.equalsIgnoreCase("CHROME")) {
            //incognito window START
            runInIncognitoMode(SetUpDriverConfigurations.RUN_SCRIPTS_IN_INCOGNITO_MODE);


            //incognito window END
            chromeOptions.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking","enable-automation"));
            chromeOptions.addArguments("--start-maximized");
            chromeOptions.addArguments("--disable-web-security");
            chromeOptions.addArguments("--no-proxy-server");
            chromeOptions.addArguments("test-type");
            chromeOptions.addArguments("disable-popup-blocking");

            //Save or Disable Passwords Alert in Chrome START
            Map<String, Object> prefs = new HashMap<String, Object>();
            prefs.put("credentials_enable_service", SetUpDriverConfigurations.ENABLE_SAVE_PASSWORDS_ALERT_EVERYTIME);
            prefs.put("profile.password_manager_enabled", SetUpDriverConfigurations.ENABLE_SAVE_PASSWORDS_ALERT_EVERYTIME);
            chromeOptions.setExperimentalOption("prefs", prefs);
            //Save or Disable Passwords Alert in Chrome END
            //chromeOptions.setExperimentalOption("debuggerAddress", "127.0.0.1:2100");
//            chromeOptions.addArguments("--disable-gpu");
//            chromeOptions.addArguments("--disable-blink-features=AutomationControlled");
//            chromeOptions.addArguments("--disable-extensions");
//            chromeOptions.setExperimentalOption("useAutomationExtension", false);
            //chromeOptions.setExperimentalOption("excludeSwitches",false);



            //Using accept insecure cert method with true as parameter to accept the untrusted certificate
            chromeOptions.setAcceptInsecureCerts(true);

                chromeOptions.addArguments("–load-extension="+corsPluginPath);
                chromeOptions.addExtensions(cors_file);


//            chromeOptions.addArguments("--user-data-dir=/Users/navepilla/Library/Application Support/Google/Chrome");
//            chromeOptions.addArguments("--start-maximized");

            //chromeOptions.addArguments("--disable-web-security", "--user-data-dir=true", "--allow-running-insecure-content");
            // Mozilla/5.0 (X11; CrOS x86_64 14816.99.0) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/103.0.0.0 Safari/537.36
            //chromeOptions.addArguments("Mozilla/5.0 (X11; CrOS x86_64 14816.99.0) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/104.0.0.0 Safari/537.36");

            if(SetUpDriverConfigurations.RUN_SCRIPTS_IN_HIDE_MODE) {
                chromeOptions.setHeadless(true);
                chromeOptions.addArguments("window-size=1920,1080");
            }


            System.setProperty(FilePaths.chromeProperty, FilePaths.getDriverPath());

            driver = new ChromeDriver(chromeOptions);


        } else if (nameOfTheBrowser.equalsIgnoreCase("FIREFOX")) {
            System.setProperty(FilePaths.firefoxProperty, FilePaths.FIREFOX_DRIVER_PATH);
            driver = new FirefoxDriver();
        } else if (nameOfTheBrowser.equalsIgnoreCase("SAFARI")) {
            //System.setProperty(FilePaths.safariProperty, FilePaths.SAFARI_DRIVER_PATH);
            driver = new SafariDriver();
        } else {
            //Making Default Browser as CHROME if Automation Developer makes mistake to provide accepted browser name by the script
            System.setProperty(FilePaths.chromeProperty, FilePaths.getDriverPath());
            driver = new ChromeDriver(chromeOptions);
        }
        driver.manage().getCookies();
        driver.manage().window().maximize();
        driver.get(testEnvironmentUrl);

        //START: ---------------UTILITY PAGES-----------------------//
        waitUtil = new WaitUtil();
        customExceptions = new CustomExceptions();
        octaSignInPage = new OctaSignInPage();
        softAssert = new SoftAssert();
        javascript =  (JavascriptExecutor)driver;
        actions = new Actions(driver);
        readAndWriteTextFiles = new ReadAndWriteTextFiles();
        randomStrings = new RandomStrings();
        //END: ---------------UTILITY PAGES-----------------------//


        //START: ---------------RETAIL PAGES-----------------------//
        retailLoginPage = new RetailLoginPage();
        retailWelcomePage = new RetailWelcomePage();
        cookiesPopUpPage = new CookiesPopUpPage();
        captureScreen = new CaptureScreen();
        googleOktaPage = new GoogleOktaPage();
        facebookOktaPage = new FacebookOktaPage();
        retailSignUpWithEmailPage = new RetailSignUpWithEmailPage();
        retailSignUpPage = new RetailSignUpPage();
        retailProfileOptionsPage = new RetailProfileOptionsPage();
        retailPrivacyWebFormPage = new RetailPrivacyWebFormPage();
        deloitteSecurityLayerPage = new DeloitteSecurityLayerPage();
        //END: ---------------RETAIL PAGES-----------------------//


        //START: ---------------HEALTH PAGES-----------------------//
        healthWelcomePage = new HealthWelcomePage();
        healthRegistrationPage = new HealthRegistrationPage();
        healthLoginPage = new HealthLoginPage();
        healthHomeScreenPage = new HealthHomeScreenPage();
        healthConfigureRegistrationPage = new HealthConfigureRegistrationPage();
        //END: ---------------HEALTH PAGES-----------------------//

        //START: ---------------BANK PAGES-----------------------//
        bankingWelcomePage = new BankingWelcomePage();
        bankingLoginPage = new BankingLoginPage();
        bankingSignUpPage = new BankingSignUpPage();
        bankingSignUpEmailPage = new BankingSignUpEmailPage();
        bankingLoggedInHomePage = new BankingLoggedInHomePage();
        bankingSignUpPage = new BankingSignUpPage();
        bankingProfileOptionsPage = new BankingProfileOptionsPage();
        bankingTransfersPage = new BankingTransfersPage();
        bankingBrokerageAccountPage = new BankingBrokerageAccountPage();
        //END: ---------------BANK PAGES-----------------------//

        //START: ---------------NEW BANK PAGES-----------------//
        newBankOpenAnAccountPage = new NewBankOpenAnAccountPage();
        newBankWelcomePage = new NewBankWelcomePage();

        newBankHomePage = new NewBankHomePage();
        newBankProfileOptionsPage = new NewBankProfileOptionsPage();
        newBankSignUpPage = new NewBankSignUpPage();
        newBankTransferPage = new NewBankTransferPage();
        newBankUtilitiesPage = new NewBankUtilitiesPage();
        //END: -----------------NEW BANK PAGES----------------//

        return driver;
    }


    private static void runInIncognitoMode(boolean runflag) {
        if (runflag){
        chromeOptions.addArguments("--incognito");
        capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
            System.out.println("Opening the driver in Incognito Mode");
        }
        else{
            System.out.println("Opening the driver in Normal Mode");
        }

    }

    public static void getDriver(String testEnvironmentUrl) {
        driver.get(testEnvironmentUrl);
    }

}
