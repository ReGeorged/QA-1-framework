package pages;

import base.BaseForm;
import base.BaseImage;
import org.openqa.selenium.By;

public class AlertsAndOthersPage extends BaseForm {
    public AlertsAndOthersPage() {
        super(new BaseImage(By.xpath("//div[@class=\"main-header\" and contains(text(),'Alerts, Frame & Windows')]"), "alertsBanner"), "alertsPage");
    }

}
