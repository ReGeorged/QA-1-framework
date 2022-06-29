package pages;

import base.*;
import org.openqa.selenium.By;
import utils.WaitUtils;


public class AlertsPage extends BaseForm {
    public AlertsPage() {
        super(new BaseImage(By.xpath("//div[@class=\"main-header\" and contains(text(),'Alerts')]"), "Alerts Banner"), "Alerts Page");
    }

    private BaseButton alertBtn = new BaseButton(By.xpath("//button[@id=\"alertButton\"]"), "Click Button to see alert");
    private BaseButton confirmBtn = new BaseButton(By.xpath("//button[@id=\"confirmButton\"]"), "confirm button");
    private BaseButton promptBtn = new BaseButton(By.xpath("//button[@id=\"promtButton\"]"), "open prompt button");
    private BaseField resultPrompt = new BaseField(By.xpath("//span[@id=\"promptResult\"]"), "entered data prompt");
    private BaseField successConfirmMessage = new BaseField(By.xpath("//span[@id=\"confirmResult\" and @class=\"text-success\"]"), "clicked ok and confirm message appeared");

    public void clickOnAlertBtn() {
        alertBtn.click();
    }

    public void clickOnConfirmBtn() {
        confirmBtn.waitUntilClickable();
        confirmBtn.click();
    }

    public void clickOnPromptBtn() {
        promptBtn.scrollToElement();
        promptBtn.click();
    }

    public String getTextFromPrompt() {
        return resultPrompt.getText();
    }

    public boolean checkConfirmMessage() {
        return successConfirmMessage.isDisplayed();
    }


}