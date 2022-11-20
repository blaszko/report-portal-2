package com.blazej.reportportal2.components.dashboard;

//import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import static com.blazej.reportportal2.utils.methodsModuleGui.ClickMethods.clickOnElement;
import static com.blazej.reportportal2.utils.methodsModuleGui.WaitMethods.waitForVisible;

public class DashboardPage {
    private final WebDriver driver;

    public DashboardPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(css = "[title=\"All Dashboards\"]")
    public WebElement dropdownAllDashboard;

    @FindBy(css = "[href=\"#default_personal/launches\"]")
    public WebElement buttonLaunches;

    public void verifyLoadedDashboardPage() {
        waitForVisible(this.driver, dropdownAllDashboard);
        Assert.assertTrue(this.dropdownAllDashboard.isDisplayed());
    }

    public void clickButtonLaunches(){
        clickOnElement(this.driver, buttonLaunches);
    }
}