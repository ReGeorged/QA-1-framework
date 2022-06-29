package pages;

import base.*;
import org.openqa.selenium.By;

public class NestedFramesPage extends BaseForm {
    public NestedFramesPage() {
        super(new BaseImage(By.xpath("//div[@class=\"main-header\" and contains(text(),'Nested Frames')]"), "Nested Frames Banner Image"), "Nested Frames Page");
    }

    private BaseFrame childFrame = new BaseFrame(By.xpath("//iframe[contains(@srcdoc,\"Child Iframe\")]"), "child Iframe");
    private BaseFrame parentFrame = new BaseFrame(By.xpath("//iframe[@id=\"frame1\"]"), "Parent Iframe");
    private BaseField childframeTextField = new BaseField(By.xpath("//body//p[contains(text(),'Child Iframe')]"), "Child iframe text field");
    private BaseField parentFrameTextField = new BaseField(By.xpath("//body[contains(text(),'Parent frame')]"), "Parent IFrame text field");

    public void switchToParentFrame() {
        parentFrame.switchToFrame();
    }

    public void switchToChildFrame() {
        childFrame.switchToFrame();
    }

    public boolean checkChildIframe() {
        switchToChildFrame();
        return childframeTextField.isDisplayed();
    }

    public boolean checkParentFrame() {
        switchToParentFrame();
        return parentFrameTextField.isDisplayed();
    }
}
