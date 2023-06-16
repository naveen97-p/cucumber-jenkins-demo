package Utilities;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

public class CustomExceptions extends BrowserInstance {

    public void validateMessage(String actualString, String expectedString, String positiveValidationMessage, String negativeValidationMessage){
            if (actualString.contentEquals(expectedString)){
        System.out.println(positiveValidationMessage);
    }else {
        System.out.println(negativeValidationMessage);
        throw new RuntimeException(negativeValidationMessage);
    }

    }

//    public void avoidStaleExceptionUponClick(Object pageObject){
//        for(int i=0; i<3;i++){
//            try{
//                pageObject.;
//                retailWelcomePage.clickOnLogoutButton();
//                break;
//
//            }catch (StaleElementReferenceException staleException){
//                System.out.println("Stale Exception for above step");
//            }
//        }
//    }

}
