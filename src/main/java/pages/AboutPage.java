package pages;

import base.TestBase;

import org.openqa.selenium.By;



public class AboutPage {
    private By aboutSteam = By.xpath("//div[contains(@class,\"about_subtitle\")]");

    //created better selector without indexes
    private By onlineStatElement = By.xpath("//div[@class='online_stat_label gamers_online']/..");
    private By inGameStatElement = By.xpath("//div[@class='online_stat_label gamers_in_game']/..");


    public Boolean aboutPageIsOpen(){
        return TestBase.initialize().findElement(aboutSteam).isDisplayed();
    }
    public String onlineStatElementText(){
        return TestBase.initialize().findElement(onlineStatElement).getText();
    }

    //this converts WebElements to string
    public String inGameStatElementText(){
        return TestBase.initialize().findElement(inGameStatElement).getText();
    }
}
