package utils;

import base.TestBase;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AlertsUtil {
    public static void acceptAlert(){
        TestBase.initialize().switchTo().alert().accept();
    }
    public static void sendToPrompt(String whatToSendToAlert){
        TestBase.initialize().switchTo().alert().sendKeys(whatToSendToAlert);
    }

//    public static boolean checkAlertPresence(){
//        return ExpectedConditions.alertIsPresent();
//    }
    public static boolean isAlertPresent(){
        boolean foundAlert = false;
        try {
            ExpectedConditions.alertIsPresent();
            foundAlert = true;
        } catch (TimeoutException eTO) {
            foundAlert = false;
        }
        return foundAlert;
    }

    public static boolean isAlertGone(){
        try{
            TestBase.initialize().switchTo().alert();
            return false;
        }catch (NoAlertPresentException e){
            return true;
        }
    }


}
