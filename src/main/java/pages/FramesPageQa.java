package pages;

import base.*;
import org.openqa.selenium.By;

public class FramesPageQa extends BaseForm {
    public FramesPageQa() {
        super(new BaseImage(By.xpath("//div[@class=\"main-header\" and contains(text(),'Frames')]"),"Frames Page Banner"), "Frames Page");
    }

    private BaseFrame  firstFrameField = new BaseFrame(By.xpath("//iframe[@id=\"frame1\"]"),"Parent Iframe");
    private BaseFrame  secondFrameField = new BaseFrame(By.xpath("//iframe[@id=\"frame2\"]"),"Parent Iframe");

    public void switchToFirstFrame(){
        TestBase.initialize().switchTo().frame(firstFrameField.findElement());}
    public void switchToSecondFrame(){TestBase.initialize().switchTo().frame(secondFrameField.findElement());}




}
