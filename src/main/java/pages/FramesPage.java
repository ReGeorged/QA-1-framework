package pages;

import base.*;
import org.openqa.selenium.By;

public class FramesPage extends BaseForm {
    public FramesPage() {
        super(new BaseImage(By.xpath("//div[@class=\"main-header\" and contains(text(),'Frames')]"), "Frames Page Banner"), "Frames Page");
    }


    //TODO i will create method in BaseElement - check if its where it should Go - i mean switching frames
    private BaseFrame firstFrameField = new BaseFrame(By.xpath("//iframe[@id=\"frame1\"]"), "Parent Iframe");
    private BaseFrame secondFrameField = new BaseFrame(By.xpath("//iframe[@id=\"frame2\"]"), "Parent Iframe");

    public void switchToFirstFrame() {
        firstFrameField.switchToFrame();
    }

    public void switchToSecondFrame() {
        secondFrameField.switchToFrame();
    }


}
