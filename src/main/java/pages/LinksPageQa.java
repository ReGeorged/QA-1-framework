package pages;

import base.BaseButton;
import base.BaseForm;
import base.BaseImage;
import org.openqa.selenium.By;

public class LinksPageQa extends BaseForm {
    public LinksPageQa() {
        super(new BaseImage(By.xpath("//div[@class=\"main-header\" and contains(text(),'Links')]"),"Links Banner"), "links Page");
    }
    private BaseButton homeBtn = new BaseButton(By.xpath("//a[@id=\"simpleLink\"]"),"home button");

    public void clickOnHomeBtn(){
        homeBtn.click();
    }

}
