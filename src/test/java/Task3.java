import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utils.AlertsUtil;
import utils.StringUtils;


public class Task3 extends BaseTest{
    HomePageQa homePageQa = new HomePageQa();
    AlertsAndOthersPageQa alertsAndOthersPageQa = new AlertsAndOthersPageQa();
    AlertsPageQa alertsPageQa = new AlertsPageQa();
    NestedFramesPageQa nestedFramesPageQa = new NestedFramesPageQa();
    ElementsPageQa elementsPageQa = new ElementsPageQa();
    WebTablesPageQa webTablesPageQa = new WebTablesPageQa();
    BrowserWindowsPageQa browserWindowsPageQa = new BrowserWindowsPageQa();
    SamplePageQa samplePageQa = new SamplePageQa();
    LinksPageQa linksPageQa = new LinksPageQa();

    @Test
    public void case1() {
        //Step1
        Assert.assertTrue(homePageQa.isPageOpen(),"home page is not open");
        //Step2
        homePageQa.clickOnAlertsBtn();
        Assert.assertTrue(alertsAndOthersPageQa.isPageOpen(),"Alerts and others page is not open");
        alertsAndOthersPageQa.clickOnDropDownAlertsBtn();
        Assert.assertTrue(alertsPageQa.isPageOpen(),"Alerts page is not open");
        //Step3
        alertsPageQa.clickOnAlertBtn();
        Assert.assertTrue(AlertsUtil.isAlertPresent(),"alert did not appear");
        //Step4
        AlertsUtil.acceptAlert();
        Assert.assertTrue(AlertsUtil.isAlertGone(),"alert didnt Disappear");
        //Step5
        alertsPageQa.clickOnConfirmBtn();
        Assert.assertTrue(AlertsUtil.isAlertPresent());
        //Step6
        AlertsUtil.acceptAlert();
        Assert.assertTrue(AlertsUtil.isAlertGone(),"alert is gone");
        Assert.assertTrue(alertsPageQa.checkConfirmMessage(),"You selected Ok - Did not appear");
        //Step7
        alertsPageQa.clickOnPromptBtn();
        Assert.assertTrue(AlertsUtil.isAlertPresent(),"alert didnt appear");
        //Step8
        String randomText = StringUtils.getAlphaNumericString();
        AlertsUtil.sendToPrompt(randomText);
        AlertsUtil.acceptAlert();
        Assert.assertTrue(AlertsUtil.isAlertGone(),"alert is not gone");
        Assert.assertEquals(alertsPageQa.getTextFromPrompt(),"You entered "+randomText,"entered text and result dont match");
    }
    @Test
    public void case2(){
        //Step1
        Assert.assertTrue(homePageQa.isPageOpen(),"home page is not open");
        //Step2
        homePageQa.clickOnAlertsBtn();
        Assert.assertTrue(alertsAndOthersPageQa.isPageOpen(),"Alerts and others page is not open");
        alertsAndOthersPageQa.clickOnIframesBtn();
        Assert.assertTrue(nestedFramesPageQa.isPageOpen());
        Assert.assertTrue(nestedFramesPageQa.checkParentFrame());
        Assert.assertTrue(nestedFramesPageQa.checkChildIframe());
        //TODO i can not create xpath with iframe as root element why just why...
    }

    @Test
    public void case3() throws InterruptedException {
        //Step1
        Assert.assertTrue(homePageQa.isPageOpen());
        //Step2
        homePageQa.clickOnElementsBtn();
        Assert.assertTrue(elementsPageQa.isPageOpen());
        elementsPageQa.clickOnWebTabeBtn();
        Assert.assertTrue(webTablesPageQa.isPageOpen());
        //Step3

        webTablesPageQa.clickOnAddBtn();
        Assert.assertTrue(webTablesPageQa.checkRegForm());
        //Step4
        webTablesPageQa.fillInfo1();
        webTablesPageQa.clickOnAddBtn();
        webTablesPageQa.fillInfo2();
        //Step5
        webTablesPageQa.clickOn5thBtn();
        webTablesPageQa.clickOn4thBtn();
        Assert.assertFalse(webTablesPageQa.check4thBtn());
    }
    @Test
    public void case4() throws InterruptedException {
        //Step1
        Assert.assertTrue(homePageQa.isPageOpen());

        //Step2
        homePageQa.clickOnAlertsBtn();
        alertsAndOthersPageQa.clickOnBrowserWindowsBtn();
        Assert.assertTrue(browserWindowsPageQa.isPageOpen());
        //Step3
        browserWindowsPageQa.clickOnNewBtn();
        samplePageQa.isPageOpen();
        //Step4
        samplePageQa.closeSamplePage();
        Assert.assertTrue(browserWindowsPageQa.isPageOpen());
        //Step5
        browserWindowsPageQa.clickOnLinksBtn();
        Assert.assertTrue(linksPageQa.isPageOpen());
        //Step6
        linksPageQa.clickOnHomeBtn();
        homePageQa.switchTab();
        Assert.assertTrue(homePageQa.isPageOpen());
        //Step7
        homePageQa.switchTabAndClose();
        Assert.assertTrue(linksPageQa.isPageOpen());

    }
}
