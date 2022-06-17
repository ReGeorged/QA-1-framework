package pages;

import base.TestBase;
import org.openqa.selenium.By;



public class GamePage {

    private By gameName= By.xpath("//div[@id=\"appHubAppName\"]");
    private By gamePageChecker = By.xpath("//img[@class=\"game_header_image_full\"]");
    private By gameDate = By.xpath("//div[@class=\"date\"]");
    private By gameFinalPrice = By.xpath("//div[@class=\"game_purchase_action_bg\"]//div[@data-price-final]");

    public boolean checkIfGamePageIsOpen(){
        return TestBase.initialize().findElement(gamePageChecker).isDisplayed();
    }
    public String getGameName(){
        String name = TestBase.initialize().findElement(gameName).getText();
        return name;
    }
    public String getGameDate(){
        String date = TestBase.initialize().findElement(gameDate).getText();
        return date;
    }
    public String getGamePrice(){
        String price = TestBase.initialize().findElement(gameFinalPrice).getText();
        return price;
    }

}
