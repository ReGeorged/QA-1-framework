package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.log.Log;
import utils.Log4jUtil;

public abstract class BaseElement {
    private By locator;
    private String name;
    public BaseElement(By currentLocator,String elementName) {
        locator = currentLocator;
        name = elementName;
    }

    public void click(){
        Log4jUtil.log4J.info("click on "+name);
        TestBase.initialize().findElement(locator).click();
    }

    public String getText(){
        Log4jUtil.log4J.info("get text from "+name);
        return TestBase.initialize().findElement(locator).getText();
    }
    public boolean isDisplayed(){
        Log4jUtil.log4J.info("check if element: "+name+" is present");
        boolean isDisplayed=false;
        if(TestBase.initialize().findElements(locator).size()!=0){
            isDisplayed=true;
        }
        return isDisplayed;
    }

    //TODO cant access it in child classes when its protected
    public WebElement findElement() {
        Log4jUtil.log4J.info("Find Element: " + name);
        return TestBase.initialize().findElement(locator);
    }
    //TODO pretty sure this is not okay - ask Nikita - but i couldnt find other way to pass element in explicit wait
    public By getElementLocator(){
        return locator;
    }


}
