package com.blazej.reportportal2.utils.methodsModuleGui;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.blazej.reportportal2.utils.methodsModuleGui.Main.driver;

public class WaitMethods {

    public static void waitForElement(WebElement webElement, Duration duration){
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }
}
