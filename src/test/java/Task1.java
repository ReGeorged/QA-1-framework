import base.TestBase;
import data.JsonReader;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.AboutPage;
import pages.HomePage;
import pages.TopSellers;
import utils.TextToInteger;

import java.io.IOException;

public class Task1  {
    HomePage homePage = new HomePage();
    AboutPage aboutPage = new AboutPage();
    TopSellers topSellers = new TopSellers();
    TextToInteger textToInteger = new TextToInteger();;



    @BeforeMethod
    public void setUp() throws IOException, ParseException {

        TestBase.initialize();

    }
    @Test(priority = 2)
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
        System.out.println();




    }
    @Test
    public void TestCase2() throws InterruptedException {
        //step1
        Assert.assertTrue(homePage.HomePageIsOpen());

        //step2
        homePage.hoverAndClickOnNew();
        Assert.assertTrue(topSellers.checkTopSellersPage());

        //step3
        topSellers.clickCheckBoxes();
        //step3assertion

        Assert.assertTrue(topSellers.areAllThreeChecked());



    }

    @AfterMethod
    public void tearDown(){
        TestBase.quit();
    }

}
