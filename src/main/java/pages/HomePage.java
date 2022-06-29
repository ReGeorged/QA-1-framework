package pages;

import base.*;
import org.openqa.selenium.By;

import java.util.ArrayList;

public class HomePage extends BaseForm {
    public HomePage() {
        super(new BaseImage(By.xpath("//img[@alt=\"Selenium Online Training\"]"), "image class on main page"), "Home Page on DemoQa");
    }

    private BaseButton alertsButton = new BaseButton(By.xpath("//h5[contains(text(),'Alerts, Frame & Windows')]"), "alertsButton");
    private BaseButton elementsButton = new BaseButton(By.xpath("//h5[contains(text(),'Elements')]"), "elements Button");


    public void clickOnAlertsBtn() {
        alertsButton.scrollToElement();
        alertsButton.click();
    }

    public void clickOnElementsBtn() {
        elementsButton.scrollToElement();
        elementsButton.click();
    }

    public void goBackTo1stPage() {
        TestBase.initialize().getWindowHandles().forEach(tab -> TestBase.initialize().switchTo().window(tab));

    }

    public void switchTab() {
        ArrayList<String> tabs2 = new ArrayList<String>(TestBase.initialize().getWindowHandles());
        TestBase.initialize().switchTo().window(tabs2.get(1));
    }

    public void switchTabAndClose() {
        ArrayList<String> tabs2 = new ArrayList<String>(TestBase.initialize().getWindowHandles());
        TestBase.initialize().close();
        TestBase.initialize().switchTo().window(tabs2.get(0));

    }

}
