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
    By aboutButton = By.xpath("//a[contains(text(),'ABOUT')]");
    By StoreButtonElement = By.xpath("//a[contains(text(),'STORE')]");
    By newAndNoteworthy = By.xpath("//div[@id=\"noteworthy_tab\"]//span//a[@class=\"pulldown_desktop\"]");
    By topSellersFlyout = By.xpath("//div[@id=\"noteworthy_flyout\"]//div//a[@class=\"popup_menu_item\"][contains(text(),'Top Sellers')]");

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
