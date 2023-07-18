import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Random;

public class Task1 {
    WebDriver driver;


    @BeforeTest
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--user-data-dir=/path/to/new/profile");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        driver.get("https://store.steampowered.com/");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

    }

    @Test(priority = 1)
    public void mainPageCheckTest() {
        WebElement FullscreenBG = driver.findElement(By.xpath("//div[@class='logo']"));
        Assert.assertTrue(FullscreenBG.isDisplayed());
    }

    @Test(priority = 2)
    public void aboutPageCheckTest() throws InterruptedException {
        WebElement aboutButton = driver.findElement(By.xpath("//a[contains(text(),'About')]"));
        aboutButton.click();
        WebElement aboutSteam = driver.findElement(By.xpath("//div[contains(@class,\"about_subtitle\")]"));

        Assert.assertTrue(aboutSteam.isDisplayed());


    }

    @Test(priority = 3)
    public void compareOnlineAndActive() {
        WebElement onlineStatElement = driver.findElement(By.xpath("//div[@class='online_stat'][1]"));
        WebElement inGameStatElement = driver.findElement(By.xpath("//div[contains(@class,'gamers_in_game')]//parent::div[@class ='online_stat']"));

        //this converts webelements to string
        String onlineStatString = onlineStatElement.getText();
        String inGameStatString = inGameStatElement.getText();

        //this removes text from string and leaves only integers
        String onlineNumberString = onlineStatString.replaceAll("[^0-9]", "");
        String inGameNumberString = inGameStatString.replaceAll("[^0-9]", "");

        //this converts filtered Strings to integers

        int onlineInt = Integer.parseInt(onlineNumberString);
        int inGameInt = Integer.parseInt(inGameNumberString);

        //this compares two numbers to each other

        Assert.assertTrue(inGameInt < onlineInt);

    }

    @Test(priority = 4)
    public void StorePageCheckTest() {
        WebElement StoreButtonElement = driver.findElement(By.xpath("//a[contains(text(),'STORE')]"));
        StoreButtonElement.click();
        //this was copy pasted from first test case because basically they both check that unique background poster is displayed :)
        WebElement FullscreenBG = driver.findElement(By.xpath("//div[@class='carousel_container maincap']"));
        Assert.assertTrue(FullscreenBG.isDisplayed());
        if (generateRandomInt(1, 4) == 3) {
            Assert.fail("some bugs found :)");
        }


    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }


    public static int generateRandomInt(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }

}
