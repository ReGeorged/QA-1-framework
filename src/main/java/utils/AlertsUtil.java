package utils;

import base.BrowserBase;
import org.openqa.selenium.NoAlertPresentException;
public class AlertsUtil {
    public static void acceptAlert() {
        Log4jUtil.log4J.info("Accept alert");
        BrowserBase.initialize().switchTo().alert().accept();
    }

    public static void sendToPrompt(String whatToSendToAlert) {
        Log4jUtil.log4J.info("Send to prompt: "+whatToSendToAlert);
        BrowserBase.initialize().switchTo().alert().sendKeys(whatToSendToAlert);
    }

    public static boolean isAlertPresent() {
        Log4jUtil.log4J.info("Check if alert is present");
        try {
            BrowserBase.initialize().switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }


}
