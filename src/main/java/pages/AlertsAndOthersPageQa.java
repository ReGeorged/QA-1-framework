package pages;

import base.BaseButton;
import base.BaseForm;
import base.BaseImage;
import org.openqa.selenium.By;
import utils.ElementUtils;

public class AlertsAndOthersPageQa extends BaseForm {
    public AlertsAndOthersPageQa() {
        super(new BaseImage(By.xpath("//div[@class=\"main-header\" and contains(text(),'Alerts, Frame & Windows')]"),"alertsBanner"), "alertsPage");
    }

    private BaseButton dropDownAlertsButton = new BaseButton(By.xpath("//li[@class=\"btn btn-light \"]//span[contains(text(),'Alerts')]"),"dropDown alertsButton");
    private BaseButton nestedFramesBtn = new BaseButton(By.xpath("//li[@class=\"btn btn-light \"]//span[contains(text(),'Nested Frames')]"),"dropDown Nested Iframes Button");
    private BaseButton browserWindowsBtn = new BaseButton(By.xpath("//li[@class=\"btn btn-light \"]//span[contains(text(),'Browser Windows')]"),"dropDown browser Windows");

    public void clickOnDropDownAlertsBtn(){
        ElementUtils.scrollToElement(dropDownAlertsButton.findElement());
        dropDownAlertsButton.click();
    }
    public void clickOnIframesBtn(){
        ElementUtils.scrollToElement(nestedFramesBtn.findElement());
        nestedFramesBtn.click();
    }
    public void clickOnBrowserWindowsBtn(){
        ElementUtils.scrollToElement(browserWindowsBtn.findElement());
        browserWindowsBtn.click();
    }
}
