import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utils.AlertsUtil;
import utils.DriverUtils;
import utils.StringUtils;


public class Task3 extends BaseTest {


    @Test
    public void case1() {
        HomePage homePage = new HomePage();
        DropDownFrame dropDownFrame = new DropDownFrame();
        AlertsPage alertsPage = new AlertsPage();
        AlertsAndOthersPage alertsAndOthersPage = new AlertsAndOthersPage();

        //Step1
        Assert.assertTrue(homePage.isPageOpen(), "Home page is not open");
        //Step2
        homePage.clickOnAlertsBtn();
        Assert.assertTrue(alertsAndOthersPage.isPageOpen(), "Alerts and others page is not open");
        dropDownFrame.clickOnDropDownAlertsBtn();
        Assert.assertTrue(alertsPage.isPageOpen(), "Alerts page is not open");
        //Step3
        alertsPage.clickOnAlertBtn();
        Assert.assertTrue(AlertsUtil.isAlertPresent(), "Alert did not appear");
        //Step4
        AlertsUtil.acceptAlert();
        Assert.assertFalse(AlertsUtil.isAlertPresent(), "Alert didnt Disappear");
        //Step5
        alertsPage.clickOnConfirmBtn();
        Assert.assertTrue(AlertsUtil.isAlertPresent());
        //Step6
        AlertsUtil.acceptAlert();
        Assert.assertFalse(AlertsUtil.isAlertPresent(), "Alert is gone");
        Assert.assertTrue(alertsPage.checkConfirmMessage(), "You selected Ok - Did not appear");
        //Step7
        alertsPage.clickOnPromptBtn();
        Assert.assertTrue(AlertsUtil.isAlertPresent(), "Alert didnt appear");
        //Step8
        String randomText = StringUtils.getAlphaNumericString();
        AlertsUtil.sendToPrompt(randomText);
        AlertsUtil.acceptAlert();
        Assert.assertFalse(AlertsUtil.isAlertPresent(), "Alert is not gone");
        Assert.assertEquals(alertsPage.getTextFromPrompt(), "You entered " + randomText, "entered text and result dont match");
    }

    @Test
    public void case2() {
        HomePage homePage = new HomePage();
        DropDownFrame dropDownFrame = new DropDownFrame();
        AlertsAndOthersPage alertsAndOthersPage = new AlertsAndOthersPage();
        NestedFramesPage nestedFramesPage = new NestedFramesPage();

        //Step1
        Assert.assertTrue(homePage.isPageOpen(), "Home page is not open");
        //Step2
        homePage.clickOnAlertsBtn();
        Assert.assertTrue(alertsAndOthersPage.isPageOpen(), "Alerts and others page is not open");
        dropDownFrame.clickOnIframesBtn();
        Assert.assertTrue(nestedFramesPage.isPageOpen());
        Assert.assertTrue(nestedFramesPage.checkParentFrame());
        Assert.assertTrue(nestedFramesPage.checkChildIframe());
        //TODO i can not create xpath with iframe as root element why just why...
    }

    @Test
    public void case3() {
        HomePage homePage = new HomePage();
        DropDownFrame dropDownFrame = new DropDownFrame();
        ElementsPage elementsPage = new ElementsPage();
        WebTablesPage webTablesPage = new WebTablesPage();

        //Step1
        Assert.assertTrue(homePage.isPageOpen());

        //Step2
        homePage.clickOnElementsBtn();
        Assert.assertTrue(elementsPage.isPageOpen());
        dropDownFrame.clickOnWebTableBtn();
        Assert.assertTrue(webTablesPage.isPageOpen());
        //Step3
        webTablesPage.clickOnAddBtn();
        Assert.assertTrue(webTablesPage.checkRegForm());
        //Step4
        webTablesPage.fillInfoUniversal("firstData");
        webTablesPage.clickOnAddBtn();
        webTablesPage.fillInfoUniversal("secondData");
        //Step5
        webTablesPage.clickOn5thBtn();
        webTablesPage.clickOn4thBtn();
        Assert.assertFalse(webTablesPage.check4thBtn());
    }

    @Test
    public void case4() {
        HomePage homePage = new HomePage();
        DropDownFrame dropDownFrame = new DropDownFrame();
        BrowserWindowsPage browserWindowsPage = new BrowserWindowsPage();
        SamplePage samplePage = new SamplePage();
        LinksPage linksPage = new LinksPage();

        //Step1
        Assert.assertTrue(homePage.isPageOpen());
        //Step2
        homePage.clickOnAlertsBtn();
        dropDownFrame.clickOnBrowserWindowsBtn();
        Assert.assertTrue(browserWindowsPage.isPageOpen());
        //Step3
        browserWindowsPage.clickOnNewBtn();
        samplePage.isPageOpen();
        //Step4
        samplePage.switchNCloseSamplePage();
        Assert.assertTrue(browserWindowsPage.isPageOpen());
        //Step5
        dropDownFrame.clickOnLinksBtn();
        Assert.assertTrue(linksPage.isPageOpen());
        //Step6
        linksPage.clickOnHomeBtn();
        DriverUtils.switchToNewWindow();
        Assert.assertTrue(homePage.isPageOpen());
        //Step7
        homePage.switchTabAndClose();
        Assert.assertTrue(linksPage.isPageOpen());
    }
}
