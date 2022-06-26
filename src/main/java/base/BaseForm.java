package base;


import utils.Log4jUtil;

import java.util.ArrayList;

public abstract class BaseForm {
    private  BaseElement uniqueElement;
    private String name;



    public BaseForm(BaseElement uniqueElem,String pageName) {
        uniqueElement = uniqueElem;
        name=pageName;
    }

    public boolean isPageOpen(){

        Log4jUtil.log4J.info("check if "+name +" page is open");
        return uniqueElement.isDisplayed();
    }

}
