package base;

import org.openqa.selenium.By;

public class BaseTextField extends BaseElement {
    public BaseTextField(By currentLocator, String currentName) {
        super(currentLocator, currentName);
    }

    public void sendText(String whatToSend) {
        findElement().sendKeys(whatToSend);

    }

}
