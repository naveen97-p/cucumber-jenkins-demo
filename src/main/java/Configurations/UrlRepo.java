package Configurations;

import org.openqa.selenium.InvalidArgumentException;

public class UrlRepo {

    // Dev URLs list for all applications
    public static final String BANKING_DEV_URL="https://services.ciamsgodev.com/bank";
    public static final String HEALTH_DEV_URL="https://services.ciamsgodev.com/wellness";
    public static final String RETAIL_DEV_URL="https://climb-dev.ciam.sandbox.ciamsgo.com/";
    public static final String B2B_DEV_URL="";

    // Demo URLs list for all applications
    public static final String BANKING_DEMO_URL="https://services.ciamsgo.com/bank";
    public static final String HEALTH_DEMO_URL="https://services.ciamsgo.com/wellness";
    public static final String RETAIL_DEMO_URL="https://climb.ciam.sandbox.ciamsgo.com/";
    public static final String B2B_DEMO_URL ="https://climb.ciam.sandbox.ciamsgo.com/";

    //Interim URL list for all applications
    public static final String RETAIL_UAT_URL="https://climb-uat.ciam.sandbox.ciamsgo.com/";


    //Social Network Accounts Management Links
    public static final String GOOGLE_ACCOUNT_LOGOUT_URL ="https://accounts.google.com/Logout";
    public static final String FACEBOOK_ACCOUNT_LOGOUT_URL ="https://www.facebook.com/log.out#";
    public static final String MAILINATOR_LINK ="https://www.mailinator.com/";


    //New Bank URL Link
    public static final String NEW_BANK_URL="https://bank.ciam.sandbox.ciamsgo.com/";



    public String getUrl(String optionUrl) throws Exception {
        String requiredUrl= null;
//        requiredUrl = switch (optionUrl) {
//            case "RETAIL_DEMO" -> RETAIL_DEMO_URL;
//            case "HEALTH_DEMO" -> HEALTH_DEMO_URL;
//            case "BANKING_DEMO" -> BANKING_DEMO_URL;
//            case "B2B_DEMO" -> B2B_DEMO_URL;
//            case "RETAIL_DEV" -> RETAIL_DEV_URL;
//            case "BANKING_DEV" -> BANKING_DEV_URL;
//            case "HEALTH_DEV" -> HEALTH_DEV_URL;
//            case "B2B_DEV" -> B2B_DEV_URL;
//            case "RETAIL_UAT" -> RETAIL_UAT_URL;
//            case "GOOGLE_ACCOUNTS_REMOVER" -> GOOGLE_ACCOUNT_LOGOUT_URL;
//            case "FACEBOOK_ACCOUNTS_REMOVER"->FACEBOOK_ACCOUNT_LOGOUT_URL;
//            default -> throw new InvalidArgumentException("Check the Calling URL Name Error: Invalid Url Name Provided");
//        };

        switch (optionUrl) {
            case "RETAIL_DEMO":  requiredUrl = RETAIL_DEMO_URL;
                break;
            case "HEALTH_DEMO":  requiredUrl = HEALTH_DEMO_URL;
                break;
            case "BANKING_DEMO":  requiredUrl = BANKING_DEMO_URL;
                break;
            case "B2B_DEMO":  requiredUrl = B2B_DEMO_URL;
                break;
            case "RETAIL_DEV":  requiredUrl = RETAIL_DEV_URL;
                break;
            case "BANKING_DEV":  requiredUrl = BANKING_DEV_URL;
                break;
            case "HEALTH_DEV":  requiredUrl = HEALTH_DEV_URL;
                break;
            case "B2B_DEV":  requiredUrl = B2B_DEV_URL;
                break;
            case "RETAIL_UAT":  requiredUrl = RETAIL_UAT_URL;
                break;
            case "NEW_BANK":  requiredUrl = NEW_BANK_URL;
                break;
            case "GOOGLE_ACCOUNTS_REMOVER":  requiredUrl = GOOGLE_ACCOUNT_LOGOUT_URL;
                break;
            case "FACEBOOK_ACCOUNTS_REMOVER":  requiredUrl = FACEBOOK_ACCOUNT_LOGOUT_URL;
                break;
            default: throw new InvalidArgumentException("Check the Calling URL Name Error: Invalid Url Name Provided");
        }

        System.out.println("URL opted by the Script :"+ requiredUrl);
        return requiredUrl;
    }
}

