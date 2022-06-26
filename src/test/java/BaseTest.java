import base.TestBase;
import data.JsonReader;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    @BeforeMethod
    public void setUp(){
        TestBase.initialize().get(JsonReader.returnFromJson("link"));
    }
    @AfterMethod()
    public void tearDown(){
        TestBase.quit();
    }
}
