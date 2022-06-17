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
    HomePage homePage = new HomePage();
    AboutPage aboutPage = new AboutPage();
    TopSellers topSellers = new TopSellers();
    GamePage gamePage = new GamePage();

    @BeforeMethod
    public void setUp(){
        TestBase.initialize().get(JsonReader.returnFromJson("link"));
    }
    @Test(priority = 1)
    public void mainPageCheckTest(){
        //step1
        Assert.assertTrue(homePage.HomePageIsOpen(),"main page did not load");

        //step2
        homePage.clickOnAbout();
        Assert.assertTrue(aboutPage.aboutPageIsOpen(),"about page did not load");

        //step3
        Assert.assertTrue(TextToInteger.filteredToInteger(aboutPage.inGameStatElementText())< TextToInteger.filteredToInteger(aboutPage.onlineStatElementText()),"in game players count is not lower than online count");

        //step4
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
        Assert.assertTrue(topSellers.areThreeChecked(),"not all checkboxes are checked");
        Assert.assertEquals(topSellers.listSize(), TextToInteger.filteredToInteger(topSellers.resultsCountText()), "filtered game number returned by steam and its list size do not match");

        //step4
        String listGameName=topSellers.getGameName();
        String listGameDate=topSellers.getGameDate();
        int listGamePrice= TextToInteger.filteredToInteger(topSellers.getGamePrice());

        //step5
        topSellers.clickOnGameInList();
        Assert.assertTrue(gamePage.checkIfGamePageIsOpen(),"game page is not open");

        Assert.assertEquals(gamePage.getGameName(), listGameName, "game names do not match");
        Assert.assertEquals(gamePage.getGameDate(), listGameDate, "game release dates do not match");
        Assert.assertEquals(TextToInteger.filteredToInteger(gamePage.getGamePrice()), listGamePrice, "game prices do not match");
    }

    @AfterMethod()
    public void tearDown(){
        TestBase.quit();
    }
}
