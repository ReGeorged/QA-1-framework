package pages;

import base.BaseField;
import base.BaseForm;
import base.BrowserBase;
import org.openqa.selenium.By;
import utils.DriverUtils;

public class SamplePage extends BaseForm {
    public SamplePage() {
        super(new BaseField(By.xpath("//h1[@id=\"sampleHeading\"]"), "sample page text field"), "sample page");
    }

    public void switchNCloseSamplePage() {
        DriverUtils.switchToTabByInt(1);
        BrowserBase.close();
        DriverUtils.switchToMainWindow();
    }

}
