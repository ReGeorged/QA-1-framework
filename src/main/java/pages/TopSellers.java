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

    By actionsChecked = By.xpath("//div[@class=\"tab_filter_control_row  checked\" and @data-loc=\"Action\"]");
    By lanChecked = By.xpath("//div[@class=\"tab_filter_control_row  checked\" and @data-loc=\"LAN Co-op\"]");
    By linuxChecked = By.xpath("//div[@class=\"tab_filter_control_row  checked\" and @data-loc=\"SteamOS + Linux\"]");

    By gamesList = By.xpath("//div[@id=\"search_resultsRows\"]//a[*]");
    By searchResultsCount = By.xpath("//div[@class='search_results_count']");

    By inListTitle = By.xpath("//div[@class=\"responsive_search_name_combined\"]//div[@class=\"col search_name ellipsis\"]//span[@class=\"title\"]");
    By inListPrice = By.xpath("//a[1]//div[@class=\"responsive_search_name_combined\"]//div[@class=\"col search_price  responsive_secondrow\"]");
    By inListDate = By.xpath("//div[@class=\"responsive_search_name_combined\"]//div[@class=\"col search_released responsive_secondrow\"]");
    public Boolean checkTopSellersPage(){
        return driver.findElement(topSellersUnique).isDisplayed();
    }

    public void clickCheckBoxes(){
        driver.findElement(steamOsLinux).click();
        driver.findElement(openDropDownMenuForLan).click();
        driver.findElement(lanCoOpCheckBox).click();
        driver.findElement(actionsCheckBox).click();
    }

    private boolean isItChecked(By checkIfCheckedBy){
        return !driver.findElements(checkIfCheckedBy).isEmpty();
    }

    public boolean areThreeChecked(){
        return isItChecked(linuxChecked)&&isItChecked(lanChecked)&&isItChecked(actionsChecked);
    }
    public int listSize(){
        return driver.findElements(gamesList).size();
    }


    public void clickOnGameInList(){
        driver.findElements(gamesList).get(0).click();
    }
    public WebElement getGameFromList(){

        return driver.findElements(gamesList).get(0);
    }
    public String getGameName(){
        String GameName = getGameFromList().findElement(inListTitle).getText();
        return GameName;
    }

    public String getGameDate(){
        String date = getGameFromList().findElement(inListDate).getText();
        return date;
    }

    public String getGamePrice(){
        String price =getGameFromList().findElement(inListPrice).getText();
        return price;
    }
    public String resultsCountText(){
        return driver.findElement(searchResultsCount).getText();
    }

}
