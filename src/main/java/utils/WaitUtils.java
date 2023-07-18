package utils;

import base.BrowserBase;
import data.JsonReader;
import org.openqa.selenium.By;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;

public class WaitUtils {
    static WebDriverWait wait = new WebDriverWait(BrowserBase.initialize(), Duration.ofSeconds(StringUtils.filteredToInteger(JsonReader.returnFromJson("wait"))));
    static FluentWait fluentWait = new FluentWait(BrowserBase.initialize()).withTimeout(Duration.ofSeconds(25)).pollingEvery(Duration.ofMillis(100));

    public static void waitForElement(By locator) {
        Log4jUtil.log4J.info("Wait for element");
    }

    public static void waitUntilClickable(By locator) {
        Log4jUtil.log4J.info("Wait for element to be clickable");
    }
    public static void fluentDownloadCheck(String filePath){
        Log4jUtil.log4J.info("Wait for file to be downloaded");
        File file = new File(filePath);
        fluentWait.until( x -> file.exists());
    }
}
