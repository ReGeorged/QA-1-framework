import base.BrowserBase;
import data.JsonReader;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    @BeforeMethod
    public void setUp() {
        BrowserBase.initialize().get(JsonReader.returnFromJson("link"));
    }

    @AfterMethod()
    public void tearDown() {
        BrowserBase.quit();
    }
}
