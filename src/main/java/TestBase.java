import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class TestBase {

    protected static WebDriver driver = null;
    protected static void initialize(){

        //singleton pattern

        if (driver==null){
            WebDriverManager.chromedriver().setup();

            ChromeOptions options = new ChromeOptions();
            options.addArguments("--incognito");
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability(ChromeOptions.CAPABILITY, options);
            options.merge(capabilities);

            driver = new ChromeDriver(options);
        }
        else{
            System.out.println("whats with so many drivers my friend!?");
        }

        driver.get("https://store.steampowered.com/");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

    }

    protected static void quit(){
        System.out.println("quitting the browser");
        driver.quit();
        driver = null;

    }
}
