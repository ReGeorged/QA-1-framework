package pages;

import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    private By HomeMainCap = By.xpath("//div[@id =  \"home_maincap_v7\"]");
    private By aboutButton = By.xpath("//div[@class=\"supernav_container\"]//a[@class=\"menuitem\"][1]");
    private By StoreButtonElement = By.xpath("//div[@class=\"supernav_container\"]//a[@data-tooltip-content=\".submenu_store\"]");
    private By newAndNoteworthy = By.xpath("//div[@id=\"noteworthy_tab\"]//span//a[@class=\"pulldown_desktop\"]");
    private By topSellersFlyout = By.xpath("//div[@id=\"noteworthy_flyout\"]//div//a[1]");

    public void clickOnAbout(){
        TestBase.initialize().findElement( aboutButton).click();
    }
    public Boolean HomePageIsOpen(){
        return TestBase.initialize().findElement(HomeMainCap).isDisplayed();
    }

    public void hoverAndClickOnNew(){
        Actions action = new Actions(TestBase.initialize());
        WebDriverWait wait = new WebDriverWait(TestBase.initialize(), Duration.ofSeconds(10));

        action.moveToElement(TestBase.initialize().findElement(newAndNoteworthy)).perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(topSellersFlyout));
        TestBase.initialize().findElement(topSellersFlyout).click();
    }
    public void clickOnStore(){
        TestBase.initialize().findElement(StoreButtonElement).click();
    }

}
