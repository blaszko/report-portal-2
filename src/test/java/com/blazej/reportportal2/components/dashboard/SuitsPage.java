package com.blazej.reportportal2.components.dashboard;

//import org.junit.jupiter.api.Assertions;

import com.blazej.reportportal2.components.common.LoginPage;
import com.blazej.reportportal2.utils.PropertiesLoader;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

import static com.blazej.reportportal2.utils.methodsModuleGui.SyncMethods.sleep;
import static com.blazej.reportportal2.utils.methodsModuleGui.WaitMethods.waitForVisible;

public class SuitsPage {
    private final WebDriver driver;
    private static final Logger logger = LogManager.getLogger(LoginPage.class.getName());

    public SuitsPage(WebDriver driver) throws IOException {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(css = "[class^=\"paginationToolbar\"]")
    WebElement labelPaginator;

    @FindBy(css = "input[type=\"text\"]")
    WebElement inputEnterSuitName;

    @FindBy(css = " [class^=\"gridRow__grid-ro\"]:nth-child(2) span")
    WebElement buttonFirstLaunchOnGrid;

    private WebElement labelStatisticsOnGrid(int number) {
        return driver.findElement(By.cssSelector("[class^=\"launchSuiteGrid\"]:nth-child(" + number + ")"));
    }

    @Step("Waiting for Launches page to load")
    public void waitForLoadedSuitsPage() {
        logger.info("Wait for Loaded Launches Page");
        waitForVisible(this.driver, this.labelPaginator);
        waitForVisible(this.driver, this.buttonFirstLaunchOnGrid);
    }

    @Step("Fill in suit name")
    public void fillInSuitName(String name) {
        inputEnterSuitName.sendKeys(name);
    }

    @Step("Grab suit statistic")
    public String grabSuitStatistics(int number) throws Exception {
        Integer timeout2sec = 2;
        sleep(timeout2sec);
        return labelStatisticsOnGrid(number).getText();
    }
}