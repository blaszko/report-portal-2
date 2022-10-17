package com.blazej.reportportal2.components.dashboard;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

// page_url = http://localhost:8080/ui/#default_personal/dashboard
public class DashboardPage {
    @FindBy(css = "[title=\"All Dashboards\"]")
    public WebElement dropdownAllDashboard;

    // No page elements added

    public DashboardPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void verifyLoadedDashboardPage(){
        Assertions.assertTrue(this.dropdownAllDashboard.isDisplayed());
    }
}