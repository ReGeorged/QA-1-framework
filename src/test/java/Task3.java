import data.JsonReader;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utils.*;


public class Task3 extends BaseTest {


    @Test
    public void testAlerts() {
        HomePage homePage = new HomePage();
        DropDownFrame dropDownFrame = new DropDownFrame();
        AlertsPage alertsPage = new AlertsPage();
        AlertsAndOthersPage alertsAndOthersPage = new AlertsAndOthersPage();

        Log4jUtil.log4J.info("Step 1 -- Navigate to main page --");

        Assert.assertTrue(homePage.isPageOpen(), "Home page is not open");
        Log4jUtil.log4J.info("Step 2 -- Click on Alerts, Frame & Windows button, In a menu click Alerts button --");
        homePage.clickOnAlertsBtn();
        Assert.assertTrue(alertsAndOthersPage.isPageOpen(), "Alerts and others page is not open");
        dropDownFrame.clickOnDropDownAlertsBtn();
        Assert.assertTrue(alertsPage.isPageOpen(), "Alerts page is not open");
        Log4jUtil.log4J.info("Step 3 -- Click on Click Button to see alert button --");
        alertsPage.clickOnAlertBtn();
        Assert.assertTrue(AlertsUtil.isAlertPresent(), "Alert did not appear");
        Log4jUtil.log4J.info("Step 4 -- Click OK button -- ");
        AlertsUtil.acceptAlert();
        Assert.assertFalse(AlertsUtil.isAlertPresent(), "Alert didnt Disappear");
        Log4jUtil.log4J.info("Step 5 -- Click on On button click, confirm box will appear button --");
        alertsPage.clickOnConfirmBtn();
        Assert.assertTrue(AlertsUtil.isAlertPresent());
        Log4jUtil.log4J.info("Step 6 -- Click on OK button --");
        AlertsUtil.acceptAlert();
        Assert.assertFalse(AlertsUtil.isAlertPresent(), "Alert is gone");
        Assert.assertTrue(alertsPage.checkConfirmMessage(), "You selected Ok - Did not appear");
        Log4jUtil.log4J.info("Step 7 -- Click on On button click, prompt box will appear button --");
        alertsPage.clickOnPromptBtn();
        Assert.assertTrue(AlertsUtil.isAlertPresent(), "Alert didnt appear");
        Log4jUtil.log4J.info("Step 8 -- Enter randomly generated text, click OK button --");
        String randomText = StringUtils.getAlphaNumericString();
        AlertsUtil.sendToPrompt(randomText);
        AlertsUtil.acceptAlert();
        Assert.assertFalse(AlertsUtil.isAlertPresent(), "Alert is not gone");
        Assert.assertEquals(alertsPage.getTextFromPrompt(), "You entered " + randomText, "entered text and result dont match");
    }

    @Test
    public void testIframe() {
        HomePage homePage = new HomePage();
        DropDownFrame dropDownFrame = new DropDownFrame();
        AlertsAndOthersPage alertsAndOthersPage = new AlertsAndOthersPage();
        NestedFramesPage nestedFramesPage = new NestedFramesPage();

        Log4jUtil.log4J.info("Step 1 -- Navigate to main page --");
        Assert.assertTrue(homePage.isPageOpen(), "Home page is not open");
        Log4jUtil.log4J.info("Step 2 -- Click on Alerts, Frame & Windows button, In a menu click Nested Frames button --");
        homePage.clickOnAlertsBtn();
        Assert.assertTrue(alertsAndOthersPage.isPageOpen(), "Alerts and others page is not open");
        dropDownFrame.clickOnIframesBtn();
        Assert.assertTrue(nestedFramesPage.isPageOpen());
        Assert.assertTrue(nestedFramesPage.checkParentFrame());
        Assert.assertTrue(nestedFramesPage.checkChildIframe());
        //TODO i can not create xpath with iframe as root element why just why...
    }

    @Test
    public void testTables() {
        HomePage homePage = new HomePage();
        DropDownFrame dropDownFrame = new DropDownFrame();
        ElementsPage elementsPage = new ElementsPage();
        WebTablesPage webTablesPage = new WebTablesPage();

        Log4jUtil.log4J.info("Step 1 -- Navigate to main page --");
        Assert.assertTrue(homePage.isPageOpen());

        Log4jUtil.log4J.info("Step 2 -- Click on Elements button, In the menu click a Web Tables button --");
        homePage.clickOnElementsBtn();
        Assert.assertTrue(elementsPage.isPageOpen());
        dropDownFrame.clickOnWebTableBtn();
        Assert.assertTrue(webTablesPage.isPageOpen());
        Log4jUtil.log4J.info("Step 3 -- Click on Add button --");
        webTablesPage.clickOnAddBtn();
        Assert.assertTrue(webTablesPage.checkRegForm());
        Log4jUtil.log4J.info("Step 4 -- Enter data for User № from the table and then click Submit button --");
        webTablesPage.fillInfoUniversal("N1");
        webTablesPage.clickOnAddBtn();
        webTablesPage.fillInfoUniversal("N2");
        Log4jUtil.log4J.info("Step 5 -- Click Delete button in a row which contains data of User №  --");
        webTablesPage.clickOn5thBtn();
        webTablesPage.clickOn4thBtn();
        Assert.assertFalse(webTablesPage.check4thBtn());
    }

    @Test
    public void testHandles() {
        HomePage homePage = new HomePage();
        DropDownFrame dropDownFrame = new DropDownFrame();
        BrowserWindowsPage browserWindowsPage = new BrowserWindowsPage();
        SamplePage samplePage = new SamplePage();
        LinksPage linksPage = new LinksPage();

        Log4jUtil.log4J.info("Step 1 -- Navigate to main page --");
        Assert.assertTrue(homePage.isPageOpen());
        Log4jUtil.log4J.info("Step 2 -- Click on Alerts, Frame & Windows button, In the menu click a Browser Windows button --");
        homePage.clickOnAlertsBtn();
        dropDownFrame.clickOnBrowserWindowsBtn();
        Assert.assertTrue(browserWindowsPage.isPageOpen());
        Log4jUtil.log4J.info("Step 3 -- Click on New Tab button --");
        browserWindowsPage.clickOnNewBtn();
        samplePage.isPageOpen();
        Log4jUtil.log4J.info("Step 4 -- Close current tab --");
        samplePage.switchNCloseSamplePage();
        Assert.assertTrue(browserWindowsPage.isPageOpen());
        Log4jUtil.log4J.info("Step 5 -- In the menu on the left click Elements → Links button --");
        dropDownFrame.clickOnLinksBtn();
        Assert.assertTrue(linksPage.isPageOpen());
        Log4jUtil.log4J.info("Step 6 -- Click on Home link --");
        linksPage.clickOnHomeBtn();
        DriverUtils.switchToNewWindow();
        Assert.assertTrue(homePage.isPageOpen());
        Log4jUtil.log4J.info("Step 7 -- Resume to previous tab --");
        homePage.switchTabAndClose();
        Assert.assertTrue(linksPage.isPageOpen());
    }

    @Test
    public void testUploadNDownload() {
        HomePage homePage = new HomePage();
        DropDownFrame dropDownFrame = new DropDownFrame();
        ElementsPage elementsPage = new ElementsPage();
        UpAndDownloadPage upAndDownloadPage = new UpAndDownloadPage();
        Log4jUtil.log4J.info("Step 1 -- Navigate to main page --");
        Assert.assertTrue(homePage.isPageOpen());
        Log4jUtil.log4J.info("Step 2 -- Click on Elements button, In the left menu click Upload and Download button --");
        homePage.clickOnElementsBtn();
        Assert.assertTrue(elementsPage.isPageOpen());
        dropDownFrame.clickOnUpAndDownloadBtn();
        Assert.assertTrue(upAndDownloadPage.isPageOpen());
        Log4jUtil.log4J.info("Step 3 -- Click Download button, wait until file is downloaded --");
        upAndDownloadPage.clickOnDownloadBtn();
        Assert.assertFalse(FileUtils.isEmpty(JsonReader.returnFromJson("download")));
        Log4jUtil.log4J.info("Step 4 -- Upload file which was downloaded on step #3 --");
        upAndDownloadPage.uploadFiles();
        Assert.assertTrue(upAndDownloadPage.checkUploadedField());
    }
}
