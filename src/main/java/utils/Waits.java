package utils;

import base.BaseButton;
import base.BaseElement;
import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Waits{

    public static void waitForElement (WebElement whatToWaitFor){

        //TODO  - if i pass in webelement it doesnt work - if i pass in By - it doesnt work anyway
        //change 10 to be passed in from testconfig
        WebDriverWait wait = new WebDriverWait(TestBase.initialize(), Duration.ofSeconds(10));
       //TODO
        // wait.until(ExpectedConditions.visibilityOfElementLocated(whatToWaitFor));
    }

    public static void waitForElementToBeClickable (WebElement whatToWaitFor){

        //TODO
        //change 10 to be passed in from testconfig
        WebDriverWait wait = new WebDriverWait(TestBase.initialize(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(whatToWaitFor));
    }
}
