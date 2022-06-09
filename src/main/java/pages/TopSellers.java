package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static base.TestBase.driver;

public class TopSellers {
    By topSellersUnique = By.xpath("//form[@id='advsearchform']");
    By actionsCheckBox = By.xpath("//span[@data-loc=\"Action\"]//span//span[@class='tab_filter_control_checkbox']");
    By openDropDownMenuForLan = By.xpath("//div[@data-collapse-name='category3']//div[@class='block_header']");
    By lanCoOpCheckBox = By.xpath("//span[@data-loc=\"LAN Co-op\"]//span//span[@class='tab_filter_control_checkbox']");
    By steamOsLinux = By.xpath("//span[@data-loc=\"SteamOS + Linux\"]//span//span[@class='tab_filter_control_checkbox']");

    By actionsChecked = By.xpath("//div[@class='tab_filter_control_row checked' and @data-loc=\"Action\"]");
    By lanChecked = By.xpath("//div[@class=\"tab_filter_control_row checked\" and @data-loc=\"LAN Co-op\"]");
    By linuxChecked = By.xpath("//div[@class=\"tab_filter_control_row  checked\" and @data-value=\"linux\"]");

    By gamesList = By.xpath("//div[@id=\"search_resultsRows\"]//a");
    By searchResultsCOunt = By.xpath("//div[@class='search_results_count']");
    public Boolean checkTopSellersPage(){
        return driver.findElement(topSellersUnique).isDisplayed();
    }

    public void clickCheckBoxes(){
        driver.findElement(actionsCheckBox).click();
        driver.findElement(openDropDownMenuForLan).click();
        driver.findElement(lanCoOpCheckBox).click();
        driver.findElement(steamOsLinux).click();
    }

    public boolean areAllThreeChecked(){
        Boolean aretheySelected = driver.findElement(actionsChecked).isDisplayed()&&driver.findElement(lanChecked).isDisplayed()&&driver.findElement(linuxChecked).isDisplayed();


        return aretheySelected;



    }
    public int listSize(){


        return driver.findElements(gamesList).size();
    }

}
