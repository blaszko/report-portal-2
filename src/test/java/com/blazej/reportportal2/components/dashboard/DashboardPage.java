package com.blazej.reportportal2.components.dashboard;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.blazej.reportportal2.utils.methodsModuleGui.WaitMethods.waitForVisible;

public class DashboardPage {
    private final WebDriver driver;

    public DashboardPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(css = "[title=\"All Dashboards\"]")
    public WebElement dropdownAllDashboard;

    public void verifyLoadedDashboardPage() {
        waitForVisible(this.driver, dropdownAllDashboard);
        Assertions.assertTrue(this.dropdownAllDashboard.isDisplayed());
    }
}