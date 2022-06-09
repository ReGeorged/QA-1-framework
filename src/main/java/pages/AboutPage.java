package pages;

import base.TestBase;
import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;

import static base.TestBase.driver;

public class AboutPage {
    By aboutSteam = By.xpath("//div[contains(@class,\"about_subtitle\")]");
    By onlineStatElement = By.xpath("//div[@class='online_stat'][1]");
    By inGameStatElement = By.xpath("//div[@class='online_stat'][2]");




    public Boolean aboutPageIsOpen(){
        Boolean aboutPageStatus = TestBase.driver.findElement(aboutSteam).isDisplayed();
        return  aboutPageStatus;

    }
    public String onlineStatElementText(){
        String onlineToText = TestBase.driver.findElement(onlineStatElement).getText();
        return onlineToText;
    }

    //this converts WebElements to string
    public String inGameStatElementText(){
        String inGameToText = TestBase.driver.findElement(inGameStatElement).getText();
        return inGameToText;
    }
}
