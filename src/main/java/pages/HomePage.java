package pages;

import base.TestBase;
import org.openqa.selenium.By;

import static base.TestBase.driver;

public class HomePage {




    By HomeMainCap = By.xpath("//div[@id =  \"home_maincap_v7\"]");
    By aboutButton = By.xpath("//a[contains(text(),'ABOUT')]");
    By StoreButtonElement = By.xpath("//a[contains(text(),'STORE')]");

    public void clickOnAbout(){
        driver.findElement( aboutButton).click();
    }
    public Boolean HomePageIsOpen(){
        Boolean homePageStatus = driver.findElement(HomeMainCap).isDisplayed();
        return homePageStatus;
    }
    public void clickOnStore(){
        driver.findElement(StoreButtonElement).click();
    }

}
