package pages;

import base.BaseElement;
import base.BaseField;
import base.BaseForm;
import base.TestBase;
import data.JsonReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WindowType;

import java.util.ArrayList;

public class SamplePageQa extends BaseForm {
    public SamplePageQa() {
        super(new BaseField(By.xpath("//h1[@id=\"sampleHeading\"]"),"sample page text field"), "sample page");
    }

    public void closeSamplePage(){
//        TestBase.initialize().getWindowHandles().forEach(tab->TestBase.initialize().switchTo().window(tab));
//        TestBase.initialize().close();
//        TestBase.initialize().navigate().to(JsonReader.returnFromJson("link"));
        ArrayList<String> tabs2 = new ArrayList<String> (TestBase.initialize().getWindowHandles());
        TestBase.initialize().switchTo().window(tabs2.get(1));
        TestBase.initialize().close();
        TestBase.initialize().switchTo().window(tabs2.get(0));



    }

}
