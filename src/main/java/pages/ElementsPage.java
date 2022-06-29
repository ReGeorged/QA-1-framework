package pages;

import base.BaseForm;
import base.BaseImage;
import org.openqa.selenium.By;


public class ElementsPage extends BaseForm {
    public ElementsPage() {
        super(new BaseImage(By.xpath("//div[@class=\"main-header\" and contains(text(),'Elements')]"), "Elements page banner"), "Elements page");
    }

}
