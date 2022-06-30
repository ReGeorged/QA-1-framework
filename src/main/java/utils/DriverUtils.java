package utils;

import base.BrowserBase;

import java.util.ArrayList;
import java.util.Set;

public class DriverUtils {
    public static String getWindowHandle() {
        String handle = BrowserBase.initialize().getWindowHandle();
        return handle;
    }

    public static void switchToNewWindow() {
        Log4jUtil.log4J.info("Switch to new window");
        String rootHandle = BrowserBase.initialize().getWindowHandle();
        Set<String> allHandles = BrowserBase.initialize().getWindowHandles();
        int count = allHandles.size();
        for (String i : allHandles) {
            if (!rootHandle.equalsIgnoreCase(i) && count < 3) {
                BrowserBase.initialize().switchTo().window(i);
            }
        }
    }

    public static void switchToMainWindow() {
        Log4jUtil.log4J.info("Switch to main window");
        ArrayList<String> tabs = new ArrayList<String>(BrowserBase.initialize().getWindowHandles());
        BrowserBase.initialize().switchTo().window(tabs.get(0));
    }

    public static void switchToTabByInt(int whichTabToSwitchTo) {
        Log4jUtil.log4J.info("Switch to window N"+whichTabToSwitchTo+" -1");
        ArrayList<String> tabs = new ArrayList<String>(BrowserBase.initialize().getWindowHandles());
        BrowserBase.initialize().switchTo().window(tabs.get(whichTabToSwitchTo));
    }


}
