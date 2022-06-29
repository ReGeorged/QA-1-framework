package base;

import org.openqa.selenium.By;

public class BaseFrame extends BaseElement {
    public BaseFrame(By currentLocator, String elementName) {
        super(currentLocator, elementName);
    }
}
