package pages;

import base.*;
import data.JsonReader;
import org.openqa.selenium.By;
import utils.FileUtils;
import utils.Log4jUtil;
import utils.WaitUtils;

public class UpAndDownloadPage extends BaseForm {
    public UpAndDownloadPage() {
        super(new BaseImage(By.xpath("//div[@class=\"main-header\" and contains(text(),'Upload and Download')]"), "upload and download image banner"), "upload and download page");
    }

    private BaseButton downloadBtn = new BaseButton(By.xpath("//a[@id=\"downloadButton\"]"), "Download button");
    private BaseTextField uploadBtn = new BaseTextField(By.xpath("//input[@id=\"uploadFile\"]"), "uploadButton");
    private BaseField uploadedFilePath = new BaseField(By.xpath("//p[@id=\"uploadedFilePath\"]"),"uploaded file path");
    public void clickOnDownloadBtn() {
        FileUtils.deleteIfNotEmpty(JsonReader.returnFromJson("download"));
        downloadBtn.click();

        WaitUtils.fluentDownloadCheck(JsonReader.returnFromJson("download")+"/sampleFile.jpeg");
    }
    public boolean checkUploadedField(){
        return uploadedFilePath.isDisplayed();
    }

    public void uploadFiles() {
        uploadBtn.sendText(FileUtils.getAbsolutePath(JsonReader.returnFromJson("download")+"/sampleFile.jpeg"));
    }
}
