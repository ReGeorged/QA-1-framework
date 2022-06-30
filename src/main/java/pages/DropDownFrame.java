package pages;

import base.BaseButton;
import base.BaseField;
import base.BaseForm;
import org.openqa.selenium.By;


public class DropDownFrame extends BaseForm {
    public DropDownFrame() {
        super(new BaseField(By.xpath("//div[@class=\"left-pannel\"]"), "left dropDown Form"), "universal navigation dropdown frame on left");
    }

    private BaseButton dropDownAlertsButton = new BaseButton(By.xpath("//li[@class=\"btn btn-light \"]//span[contains(text(),'Alerts')]"), "dropDown alertsButton");
    private BaseButton nestedFramesBtn = new BaseButton(By.xpath("//li[@class=\"btn btn-light \"]//span[contains(text(),'Nested Frames')]"), "dropDown Nested Iframes Button");
    private BaseButton webTableBtn = new BaseButton(By.xpath("//li[@id=\"item-3\"]//span[contains(text(),'Web Tables')]"), "dropdown web table button");
    private BaseButton browserWindowsBtn = new BaseButton(By.xpath("//li[@class=\"btn btn-light \"]//span[contains(text(),'Browser Windows')]"), "dropDown browser Windows");
    private BaseButton elementsBtn = new BaseButton(By.xpath("//span[@class=\"pr-1\"][1]"), "elements dropdown");
    private BaseButton linksBtn = new BaseButton(By.xpath("//div[@class=\"element-list collapse show\"]//li[@id=\"item-5\"]"), "Links Btn");
    private BaseButton upAndDownloadBtn = new BaseButton(By.xpath("//li[@class=\"btn btn-light \"]//span[contains(text(),'Upload and Download')]"),"upload and download button");
    public void clickOnUpAndDownloadBtn(){
        upAndDownloadBtn.scrollToElement();
        upAndDownloadBtn.click();
    }
    public void clickOnDropDownAlertsBtn() {
        dropDownAlertsButton.scrollToElement();
        dropDownAlertsButton.click();
    }

    public void clickOnIframesBtn() {
        nestedFramesBtn.scrollToElement();
        nestedFramesBtn.click();
    }

    public void clickOnBrowserWindowsBtn() {
        browserWindowsBtn.scrollToElement();
        browserWindowsBtn.click();
    }

    public void clickOnWebTableBtn() {
        webTableBtn.scrollToElement();
        webTableBtn.click();
    }

    public void clickOnLinksBtn() {
        elementsBtn.scrollToElement();
        elementsBtn.click();
        linksBtn.scrollToElement();
        linksBtn.click();
    }

}
