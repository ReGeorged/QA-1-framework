package utils;

import base.TestBase;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class ElementUtils {
    public static void scrollToElement(WebElement whereToScroll){
        JavascriptExecutor je = (JavascriptExecutor) TestBase.initialize();
        je.executeScript("arguments[0].scrollIntoView(true);",whereToScroll);

    }
}
