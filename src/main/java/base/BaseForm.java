package base;


import utils.Log4jUtil;

public abstract class BaseForm {

    public BaseForm(BaseElement uniqueElem, String pageName) {
        uniqueElement = uniqueElem;
        name = pageName;
    }

    private BaseElement uniqueElement;
    private String name;

    public boolean isPageOpen() {
        Log4jUtil.log4J.info("Check if " + name + " page is open");
        return uniqueElement.isDisplayed();
    }

}
