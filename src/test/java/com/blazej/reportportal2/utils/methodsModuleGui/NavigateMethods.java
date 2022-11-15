package com.blazej.reportportal2.utils.methodsModuleGui;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class NavigateMethods {

    private static final Logger logger = LogManager.getLogger(NavigateMethods.class.getName());

    public static void navigateTo(WebDriver driver, String url) {
        logger.info("Navigate to " + url);
        driver.navigate().to(url);
    }
}
