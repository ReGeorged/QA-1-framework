package base;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import utils.Log4jUtil;
import utils.WaitUtils;

public abstract class BaseElement {
    public BaseElement(By currentLocator, String elementName) {
        locator = currentLocator;
        name = elementName;
    }

    private By locator;
    private String name;

    public void click() {
        Log4jUtil.log4J.info("Click on " + name);
        TestBase.initialize().findElement(locator).click();
    }

    public String getText() {
        Log4jUtil.log4J.info("Get text from " + name);
        return TestBase.initialize().findElement(locator).getText();
    }

    public boolean isDisplayed() {
        Log4jUtil.log4J.info("Check if element: " + name + " is present");
        boolean isDisplayed = false;
        if (TestBase.initialize().findElements(locator).size() != 0) {
            isDisplayed = true;
        }
        return isDisplayed;
    }

    //TODO cant access it in child classes when its protected
    private WebElement findElement() {
        Log4jUtil.log4J.info("Find Element: " + name);
        return TestBase.initialize().findElement(locator);
    }

    public void waitForElement() {
        Log4jUtil.log4J.info("Wait for: " + name);
        WaitUtils.waitForElement(locator);
    }

    public void waitUntilClickable() {
        Log4jUtil.log4J.info("Wait until clickable: " + name);
        WaitUtils.waitUntilClickable(locator);

    }


    public By getElementLocator() {
        return locator;
    }

    public void scrollToElement() {
        Log4jUtil.log4J.info("Scroll to: " + name);
        JavascriptExecutor je = (JavascriptExecutor) TestBase.initialize();
        je.executeScript("arguments[0].scrollIntoView(true);", findElement());
    }

    public void switchToFrame() {
        Log4jUtil.log4J.info("Switch to: " + name + " elements frame");
        TestBase.initialize().switchTo().frame(findElement());
    }
}



