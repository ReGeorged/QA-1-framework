package base;

import org.openqa.selenium.By;

public class BaseTextField extends BaseElement{
    public BaseTextField(By currentLocator, String currentName) {
        super(currentLocator, currentName);
    }
    public void sendText(By locator,String whatToSend){
        TestBase.initialize().findElement(locator).sendKeys(whatToSend);

    }

}
