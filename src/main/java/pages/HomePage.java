package pages;

import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


import static base.TestBase.driver;

public class HomePage {
    By HomeMainCap = By.xpath("//div[@id =  \"home_maincap_v7\"]");
    By aboutButton = By.xpath("//div[@class=\"supernav_container\"]//a[@class=\"menuitem\"][1]");
    By StoreButtonElement = By.xpath("//div[@class=\"supernav_container\"]//a[@data-tooltip-content=\".submenu_store\"]");
    By newAndNoteworthy = By.xpath("//div[@id=\"noteworthy_tab\"]//span//a[@class=\"pulldown_desktop\"]");
    By topSellersFlyout = By.xpath("//div[@id=\"noteworthy_flyout\"]//div//a[1]");

    public void clickOnAbout(){
        driver.findElement( aboutButton).click();
    }
    public Boolean HomePageIsOpen(){
        return driver.findElement(HomeMainCap).isDisplayed();
    }

    public void hoverAndClickOnNew(){
        Actions action = new Actions(TestBase.driver);
        WebDriverWait wait = new WebDriverWait(TestBase.driver, Duration.ofSeconds(10));

        action.moveToElement(driver.findElement(newAndNoteworthy)).perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(topSellersFlyout));
        driver.findElement(topSellersFlyout).click();
    }
    public void clickOnStore(){
        driver.findElement(StoreButtonElement).click();
    }

}
