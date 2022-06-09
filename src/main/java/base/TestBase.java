package base;

import data.JsonReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class TestBase {

    public static WebDriver driver = null;

    static JsonReader jsonReader = new JsonReader();
    static String link;
    static {
        try {
            link = jsonReader.returnFromJson("link");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }




    public static void initialize(){

        //singleton pattern

        if (driver==null){
            WebDriverManager.chromedriver().setup();

            ChromeOptions options = new ChromeOptions();
            options.addArguments("--incognito");
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability(ChromeOptions.CAPABILITY, options);
            options.merge(capabilities);



            driver = new ChromeDriver(options);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);



            driver.get(link);

            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();


        }
        else{
            System.out.println("whats with so many drivers my friend!?");
        }



    }

    public static void quit(){
        System.out.println("quitting the browser");

        driver.quit();
        driver = null;

    }
}
