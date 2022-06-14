import base.TestBase;
import data.JsonReader;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.AboutPage;
import pages.GamePage;
import pages.HomePage;
import pages.TopSellers;
import utils.TextToInteger;

public class Task2 {
    TestBase testBase = new TestBase();
    TextToInteger textToInteger = new TextToInteger();
    static JsonReader jsonReader = new JsonReader();
    HomePage homePage = new HomePage();
    AboutPage aboutPage = new AboutPage();
    TopSellers topSellers = new TopSellers();
    GamePage gamePage = new GamePage();


    @BeforeMethod
    public void setUp(){
        TestBase.initialize();
        testBase.driver.get(jsonReader.returnLink());
    }
    @Test(priority = 1)
    public void mainPageCheckTest(){
        //step1
        Assert.assertTrue(homePage.HomePageIsOpen(),"main page did not load");

        //step2
        homePage.clickOnAbout();
        Assert.assertTrue(aboutPage.aboutPageIsOpen(),"about page did not load");

        //step3
        //this compares two numbers to each other
        Assert.assertTrue(textToInteger.filteredToInteger(aboutPage.inGameStatElementText())< textToInteger.filteredToInteger(aboutPage.onlineStatElementText()),"in game players count is not lower than online count");

        //step4
        //this was copy - pasted from first test case because basically they both check that unique background poster is displayed :)
        homePage.clickOnStore();
        Assert.assertTrue(homePage.HomePageIsOpen(), "main page did not load");
        System.out.println();
    }
    @Test(priority = 2)
    public void TestCase2(){
        //step1
        Assert.assertTrue(homePage.HomePageIsOpen(),"home page did not load");

        //step2
        homePage.hoverAndClickOnNew();
        Assert.assertTrue(topSellers.checkTopSellersPage(),"top sellers page did not load");

        //step3
        topSellers.clickCheckBoxes();
        //step3assertions
        Assert.assertTrue(topSellers.areThreeChecked(),"not all checkboxes are checked");
        Assert.assertTrue(textToInteger.filteredToInteger(topSellers.resultsCountText())== topSellers.listSize(),"filtered game number returned by steam and its list size do not match");

        //step4
        String listGameName=topSellers.getGameName();
        String listGameDate=topSellers.getGameDate();
        int listGamePrice= textToInteger.filteredToInteger(topSellers.getGamePrice());

        //step5
        topSellers.clickOnGameInList();
        Assert.assertTrue(gamePage.checkIfGamePageIsOpen(),"game page is not open");

        Assert.assertTrue(listGameName.equals( gamePage.getGameName()),"game names do not match");
        Assert.assertTrue(listGameDate.equals(gamePage.getGameDate()),"game release dates do not match");
        Assert.assertTrue(listGamePrice== textToInteger.filteredToInteger(gamePage.getGamePrice()),"game prices do not match");
    }

    @AfterMethod()
    public void tearDown(){
        TestBase.quit();
    }
}
