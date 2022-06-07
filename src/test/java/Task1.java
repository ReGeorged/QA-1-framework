import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.AboutPage;
import pages.HomePage;
import utils.TextToInteger;

public class Task1  {
    HomePage homePage = new HomePage();
    AboutPage aboutPage = new AboutPage();
    TextToInteger textToInteger = new TextToInteger();





    @BeforeTest
    public void setUp(){

        TestBase.initialize();

    }
    @Test(priority = 1)
    public void mainPageCheckTest(){

        //step1
        Assert.assertTrue(homePage.HomePageIsOpen());

        //step2
        homePage.clickOnAbout();
        Assert.assertTrue(aboutPage.aboutPageIsOpen());

        //step3
        //this compares two numbers to each other
        Assert.assertTrue(textToInteger.filteredToInteger(aboutPage.inGameStatElementText())< textToInteger.filteredToInteger(aboutPage.onlineStatElementText()));

        //step4
        //this was copy pasted from first test case because basically they both check that unique background poster is displayed :)
        homePage.clickOnStore();
        Assert.assertTrue(homePage.HomePageIsOpen());



    }

    @AfterTest
    public void tearDown(){
        TestBase.quit();
    }

}
