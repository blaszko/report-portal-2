package com.blazej.reportportal2.utils.methodsModuleGui;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ClickMethods {
    private static final Logger logger = LogManager.getLogger(ClickMethods.class.getName());

    public static void clickOnElement(WebDriver driver, WebElement webElement) {

        logger.info("Click on element: " + webElement.toString());
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(webElement)).click();
    }

    public static void clickOnElement(WebDriver driver, By locator) {
        logger.info("Wait for locator" + locator.toString());
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

}
