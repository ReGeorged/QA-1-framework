import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.*;

public class Task1  {
    WebDriver driver;





    @BeforeTest
    public void setUp(){

        TestBase.initialize();

    }
    @Test(priority = 1)
    public void mainPageCheckTest(){

        //step1
        WebElement FullscreenBG = TestBase.driver.findElement(By.xpath("//div[@class = 'fullscreen-bg']"));
        Assert.assertTrue(FullscreenBG.isDisplayed());

        //step2
        WebElement aboutButton = TestBase.driver.findElement(By.xpath("//a[contains(text(),'ABOUT')]"));
        aboutButton.click();
        WebElement aboutSteam = TestBase.driver.findElement(By.xpath("//div[contains(@class,\"about_subtitle\")]"));

        Assert.assertTrue(aboutSteam.isDisplayed());

        //step3
        WebElement onlineStatElement = TestBase.driver.findElement(By.xpath("//div[@class='online_stat'][1]"));
        WebElement inGameStatElement = TestBase.driver.findElement(By.xpath("//div[contains(@class,'gamers_in_game')]//parent::div[@class ='online_stat']"));

        //this converts webelements to string
        String onlineStatString = onlineStatElement.getText();
        String inGameStatString= inGameStatElement.getText();

        //this removes text from string and leaves only integers
        String onlineNumberString = onlineStatString.replaceAll("[^0-9]", "");
        String inGameNumberString = inGameStatString.replaceAll("[^0-9]", "");

        //this converts filtered Strings to integers

        int onlineInt = Integer.parseInt(onlineNumberString);
        int inGameInt = Integer.parseInt(inGameNumberString);

        //this compares two numbers to each other

        Assert.assertTrue(inGameInt<onlineInt);

        //step4
        WebElement StoreButtonElement = TestBase.driver.findElement(By.xpath("//a[contains(text(),'STORE')]"));
        StoreButtonElement.click();
        //this was copy pasted from first test case because basically they both check that unique background poster is displayed :)
         FullscreenBG = TestBase.driver.findElement(By.xpath("//div[@class = 'fullscreen-bg']"));
        Assert.assertTrue(FullscreenBG.isDisplayed());



    }

    @AfterTest
    public void tearDown(){
        TestBase.quit();
    }

}
