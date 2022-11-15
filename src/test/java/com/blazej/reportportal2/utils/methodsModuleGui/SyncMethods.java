package com.blazej.reportportal2.utils.methodsModuleGui;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class SyncMethods {

    private static final Logger logger = LogManager.getLogger(SyncMethods.class.getName());

    public static void sleep(Integer seconds) throws Exception {
        long realSeconds = (long) seconds * 1000;
        try {
            logger.info("Wait for: " + realSeconds);
            Thread.sleep(realSeconds);
        } catch (Exception ex) {
            throw new Exception(ex);
        }
    }
}
