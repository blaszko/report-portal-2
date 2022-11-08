package com.blazej.reportportal2.tests;

import com.blazej.reportportal2.components.common.LoginPage;
import com.blazej.reportportal2.components.dashboard.DashboardPage;
import org.junit.jupiter.api.Test;

public class LoginTest extends BaseTest{
    String pageUrl = "http://localhost:8080/ui/#login";
    String login = "default";
    String password = "1q2w3e";
    @Test
    public void loginToReportPortal(){
        driver.navigate().to(this.pageUrl);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillLogin(properties.getProperty("LOGIN"));
        loginPage.fillPassword(properties.getProperty("PASSWORD"));
        loginPage.clickSubmitButton();
        DashboardPage dashboardPage = new DashboardPage(driver);
        dashboardPage.verifyLoadedDashboardPage();

//        FluentWait<WebDriver> wait = new FluentWait<>(driver);
//        wait.ignoring(NoSuchElementException.class);
//        wait.withTimeout(Duration.ofSeconds(10));
//        wait.pollingEvery(Duration.ofSeconds(1));
//        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".p")));
    }
    @Test
    public void loginToReportPortalCopy(){
        driver.navigate().to(this.pageUrl);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillLogin(properties.getProperty("LOGIN"));
        loginPage.fillPassword(properties.getProperty("PASSWORD"));
        loginPage.clickSubmitButton();
        DashboardPage dashboardPage = new DashboardPage(driver);
        dashboardPage.verifyLoadedDashboardPage();
    }

}
