package pages;


import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class TopSellers {
    private By topSellersUnique = By.xpath("//form[@id='advsearchform']");
    private By actionsCheckBox = By.xpath("//span[@data-loc=\"Action\"]//span//span[@class='tab_filter_control_checkbox']");
    private By openDropDownMenuForLan = By.xpath("//div[@data-collapse-name='category3']//div[@class='block_header']");
    private By lanCoOpCheckBox = By.xpath("//span[@data-loc=\"LAN Co-op\"]//span//span[@class='tab_filter_control_checkbox']");
    private By steamOsLinux = By.xpath("//span[@data-loc=\"SteamOS + Linux\"]//span//span[@class='tab_filter_control_checkbox']");

    private By actionsChecked = By.xpath("//div[@class=\"tab_filter_control_row  checked\" and @data-loc=\"Action\"]");
    private By lanChecked = By.xpath("//div[@class=\"tab_filter_control_row  checked\" and @data-loc=\"LAN Co-op\"]");
    private By linuxChecked = By.xpath("//div[@class=\"tab_filter_control_row  checked\" and @data-loc=\"SteamOS + Linux\"]");

    private By gamesList = By.xpath("//div[@id=\"search_resultsRows\"]//a[*]");
    private By searchResultsCount = By.xpath("//div[@class='search_results_count']");

    private By inListTitle = By.xpath("//div[@class=\"responsive_search_name_combined\"]//div[@class=\"col search_name ellipsis\"]//span[@class=\"title\"]");
    private By inListPrice = By.xpath("//a[1]//div[@class=\"responsive_search_name_combined\"]//div[@class=\"col search_price  responsive_secondrow\"]");
    private By inListDate = By.xpath("//div[@class=\"responsive_search_name_combined\"]//div[@class=\"col search_released responsive_secondrow\"]");
    public Boolean checkTopSellersPage(){
        return TestBase.initialize().findElement(topSellersUnique).isDisplayed();
    }

    public void clickCheckBoxes(){
        TestBase.initialize().findElement(steamOsLinux).click();
        TestBase.initialize().findElement(openDropDownMenuForLan).click();
        TestBase.initialize().findElement(lanCoOpCheckBox).click();
        TestBase.initialize().findElement(actionsCheckBox).click();
    }

    private boolean isItChecked(By checkIfCheckedBy){
        return !TestBase.initialize().findElements(checkIfCheckedBy).isEmpty();
    }

    public boolean areThreeChecked(){
        return isItChecked(linuxChecked)&&isItChecked(lanChecked)&&isItChecked(actionsChecked);
    }
    public int listSize(){
        return TestBase.initialize().findElements(gamesList).size();
    }


    public void clickOnGameInList(){
        TestBase.initialize().findElements(gamesList).get(0).click();
    }
    public WebElement getGameFromList(){

        return TestBase.initialize().findElements(gamesList).get(0);
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
        return TestBase.initialize().findElement(searchResultsCount).getText();
    }

}
