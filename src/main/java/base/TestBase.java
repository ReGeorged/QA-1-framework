package base;

import data.JsonReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import utils.StringUtils;

import java.util.concurrent.TimeUnit;

public class TestBase {
    private static WebDriver driver = null;
    static JsonReader jsonReader = new JsonReader();

    public static WebDriver initialize() {
        //singleton pattern
        if (driver == null) {
            if (jsonReader.returnFromJson("browser").equalsIgnoreCase("chrome")) {
                WebDriverManager.chromedriver().setup();

                ChromeOptions options = new ChromeOptions();
                options.addArguments("--incognito");
                DesiredCapabilities capabilities = new DesiredCapabilities();
                capabilities.setCapability(ChromeOptions.CAPABILITY, options);
                options.merge(capabilities);

                driver = new ChromeDriver(options);
                driver.manage().timeouts().implicitlyWait(StringUtils.filteredToInteger(JsonReader.returnFromJson("wait")), TimeUnit.SECONDS);
                driver.manage().window().maximize();
                driver.manage().deleteAllCookies();
            } else if (jsonReader.returnFromJson("browser").equalsIgnoreCase("FF") || jsonReader.returnFromJson("browser").equalsIgnoreCase("firefox")) {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            }
        }
        return driver;
    }

    public static void quit() {
        driver.quit();
        driver = null;
    }

    public static void close() {
        driver.close();
    }
}
