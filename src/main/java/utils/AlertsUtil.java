package utils;

import base.TestBase;
import org.openqa.selenium.NoAlertPresentException;
public class AlertsUtil {
    public static void acceptAlert() {
        TestBase.initialize().switchTo().alert().accept();
    }

    public static void sendToPrompt(String whatToSendToAlert) {
        TestBase.initialize().switchTo().alert().sendKeys(whatToSendToAlert);
    }

    public static boolean isAlertPresent() {
        try {
            TestBase.initialize().switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }


}
