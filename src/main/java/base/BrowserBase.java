package base;

import data.JsonReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class BrowserBase {
    private static WebDriver driver = null;
    static JsonReader jsonReader = new JsonReader();

    public static WebDriver initialize() {
        //singleton pattern
        if (driver == null) {
            String browser = jsonReader.returnFromJson("browser");
            //TODO Upgrade to jdk 16+ to use enums
            switch (browser) {

                case "chrome":
                    WebDriverManager.chromedriver().setup();

                    Map<String, Object> prefs = new HashMap<String, Object>();
                    prefs.put("download.default_directory", System.getProperty("user.dir") + File.separator + "ChromeDriver" + File.separator + "BrowserDownloadedFiles");
                    ChromeOptions options = new ChromeOptions();
                    options.setExperimentalOption("prefs", prefs);

                    options.addArguments("--incognito");
                    DesiredCapabilities capabilities = new DesiredCapabilities();
                    capabilities.setBrowserName("chrome");
                    capabilities.setCapability(ChromeOptions.CAPABILITY, options);
                    options.merge(capabilities);


                    try {
                        driver = new ChromeDriver( options);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }

                    driver.manage().window().maximize();
                    driver.manage().deleteAllCookies();
                    break;


                case "FF":
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
