package pages;

import base.BaseButton;
import base.BaseElement;
import base.BaseForm;
import base.BaseImage;
import org.openqa.selenium.By;
import utils.ElementUtils;

import javax.swing.text.Element;

public class BrowserWindowsPageQa extends BaseForm {
    public BrowserWindowsPageQa() {
        super(new BaseImage(By.xpath("//div[@class=\"main-header\" and contains(text(),'Browser Windows')]"),"browser windows banner"), "browser windows");
    }

    private BaseButton newBtn = new BaseButton(By.xpath("//button[@id=\"tabButton\"]"),"new button");
    private BaseButton elementsBtn = new BaseButton(By.xpath("//span[@class=\"pr-1\"][1]"),"elements dropdown");
    private BaseButton linksBtn = new BaseButton(By.xpath("//div[@class=\"element-list collapse show\"]//li[@id=\"item-5\"]"),"Links Btn");
    public void clickOnNewBtn(){
        newBtn.click();
    }

    public void clickOnLinksBtn(){
        ElementUtils.scrollToElement(elementsBtn.findElement());
        elementsBtn.click();
        ElementUtils.scrollToElement(linksBtn.findElement());
        linksBtn.click();
    }
    //public void clickOnElements(){
      //  elementsBtn.click();}


}
