import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class Task1  {
    WebDriver driver;





    @BeforeTest
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://store.steampowered.com/");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

    }
    @Test(priority = 1)
    public void mainPageCheckTest(){
        WebElement FullscreenBG = driver.findElement(By.xpath("//div[@class = 'fullscreen-bg']"));
        Assert.assertTrue(FullscreenBG.isDisplayed());
    }

    @Test(priority = 2)
    public void aboutPageCheckTest() throws InterruptedException {
        WebElement aboutButton = driver.findElement(By.xpath("//a[contains(text(),'ABOUT')]"));
        aboutButton.click();
        WebElement aboutSteam = driver.findElement(By.xpath("//div[contains(@class,\"about_subtitle\")]"));

        Assert.assertTrue(aboutSteam.isDisplayed());


    }

    @Test(priority = 3)
    public void compareOnlineAndActive(){
        WebElement onlineStatElement = driver.findElement(By.xpath("//div[@class='online_stat'][1]"));
        WebElement inGameStatElement = driver.findElement(By.xpath("//div[contains(@class,'gamers_in_game')]//parent::div[@class ='online_stat']"));

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

    }

    @Test(priority=4)
    public void StorePageCheckTest(){
        WebElement StoreButtonElement = driver.findElement(By.xpath("//a[contains(text(),'STORE')]"));
        StoreButtonElement.click();
        //this was copy pasted from first test case because basically they both check that unique background poster is displayed :)
        WebElement FullscreenBG = driver.findElement(By.xpath("//div[@class = 'fullscreen-bg']"));
        Assert.assertTrue(FullscreenBG.isDisplayed());


    }
    @AfterTest
    public void tearDown(){
        driver.quit();
    }

}
