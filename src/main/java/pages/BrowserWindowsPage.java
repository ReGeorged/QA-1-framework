package pages;

import base.BaseButton;
import base.BaseForm;
import base.BaseImage;
import org.openqa.selenium.By;

public class BrowserWindowsPage extends BaseForm {
    public BrowserWindowsPage() {
        super(new BaseImage(By.xpath("//div[@class=\"main-header\" and contains(text(),'Browser Windows')]"), "browser windows banner"), "browser windows");
    }

    private BaseButton newBtn = new BaseButton(By.xpath("//button[@id=\"tabButton\"]"), "new button");

    public void clickOnNewBtn() {
        newBtn.click();
    }


}
