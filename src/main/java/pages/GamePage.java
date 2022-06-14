package pages;

import org.openqa.selenium.By;

import static base.TestBase.driver;

public class GamePage {

    By gameName= By.xpath("//div[@id=\"appHubAppName\"]");
    By gamePageChecker = By.xpath("//img[@class=\"game_header_image_full\"]");
    By gameDate = By.xpath("//div[@class=\"date\"]");
    By gameFinalPrice = By.xpath("//div[@class=\"game_purchase_action_bg\"]//div[@data-price-final]");

    public boolean checkIfGamePageIsOpen(){
        return driver.findElement(gamePageChecker).isDisplayed();
    }
    public String getGameName(){
        String name = driver.findElement(gameName).getText();
        return name;
    }
    public String getGameDate(){
        String date = driver.findElement(gameDate).getText();
        return date;
    }
    public String getGamePrice(){
        String price = driver.findElement(gameFinalPrice).getText();
        return price;
    }

}
