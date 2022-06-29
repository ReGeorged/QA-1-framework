package utils;

import base.TestBase;
import data.JsonReader;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtils {
    static WebDriverWait wait = new WebDriverWait(TestBase.initialize(), Duration.ofSeconds(StringUtils.filteredToInteger(JsonReader.returnFromJson("wait"))));

    public static void waitForElement(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static void waitUntilClickable(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
}
