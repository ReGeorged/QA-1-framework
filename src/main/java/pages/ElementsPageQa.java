package pages;

import base.BaseButton;
import base.BaseElement;
import base.BaseForm;
import base.BaseImage;
import org.openqa.selenium.By;
import utils.ElementUtils;

public class ElementsPageQa extends BaseForm {
    public ElementsPageQa() {
        super(new BaseImage(By.xpath("//div[@class=\"main-header\" and contains(text(),'Elements')]"),"Elements page banner"), "Elements page");
    }
    private BaseButton webTableBtn = new BaseButton(By.xpath("//li[@id=\"item-3\"]//span[contains(text(),'Web Tables')]"),"dropdown web table button");
    public void clickOnWebTabeBtn(){
        ElementUtils.scrollToElement(webTableBtn.findElement());
        webTableBtn.click();
    }
}
