package pages;

import base.TestBase;
import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;

import static base.TestBase.driver;

public class AboutPage {
    By aboutSteam = By.xpath("//div[contains(@class,\"about_subtitle\")]");


    //created better selector without indexes
    By onlineStatElement = By.xpath("//div[@class='online_stat_label gamers_online']/..");
    By inGameStatElement = By.xpath("//div[@class='online_stat_label gamers_in_game']/..");




    public Boolean aboutPageIsOpen(){
        return TestBase.driver.findElement(aboutSteam).isDisplayed();
    }
    public String onlineStatElementText(){
        return TestBase.driver.findElement(onlineStatElement).getText();
    }

    //this converts WebElements to string
    public String inGameStatElementText(){
        return TestBase.driver.findElement(inGameStatElement).getText();
    }
}
