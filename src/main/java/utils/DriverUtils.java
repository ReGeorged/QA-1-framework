package utils;

import base.TestBase;

import java.util.ArrayList;
import java.util.Set;

public class DriverUtils {
    public static String getWindowHandle() {
        String handle = TestBase.initialize().getWindowHandle();
        return handle;
    }

    public static void switchToNewWindow() {
        String rootHandle = TestBase.initialize().getWindowHandle();
        Set<String> allHandles = TestBase.initialize().getWindowHandles();
        int count = allHandles.size();
        for (String i : allHandles) {
            if (!rootHandle.equalsIgnoreCase(i) && count < 3) {
                TestBase.initialize().switchTo().window(i);
            }
        }
    }

    public static void switchToMainWindow() {
        ArrayList<String> tabs = new ArrayList<String>(TestBase.initialize().getWindowHandles());
        TestBase.initialize().switchTo().window(tabs.get(0));
    }

    public static void switchToTabByInt(int whichTabToSwitchTo) {
        ArrayList<String> tabs = new ArrayList<String>(TestBase.initialize().getWindowHandles());
        TestBase.initialize().switchTo().window(tabs.get(whichTabToSwitchTo));
    }


}
