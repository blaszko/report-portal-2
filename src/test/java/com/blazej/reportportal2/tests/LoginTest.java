package com.blazej.reportportal2.tests;

import com.blazej.reportportal2.components.common.LoginPage;
import com.blazej.reportportal2.components.dashboard.DashboardPage;
import com.blazej.reportportal2.utils.PropertiesLoader;
import io.qameta.allure.Description;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class LoginTest extends BaseTest {
    String pageUrl = PropertiesLoader.loadProperty("BASE_URI") + "/#login";
    String login = PropertiesLoader.loadProperty("LOGIN");
    String password = PropertiesLoader.loadProperty("PASSWORD");

    private static final Logger logger = LogManager.getLogger(LoginPage.class.getName());

    public LoginTest() throws IOException {
    }


    @Test
    @Description("Login to report portal with valid login and password")
    void loginToReportPortal() {
        driver.navigate().to(this.pageUrl);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.waitForLoadedLoginPage();

        loginPage.fillLogin(this.login);
        loginPage.fillPassword(this.password);
        loginPage.clickSubmitButton();
        DashboardPage dashboardPage = new DashboardPage(driver);
        dashboardPage.verifyLoadedDashboardPage();
    }

    @Test
    void loginToReportPortalCopy() {
        driver.navigate().to(this.pageUrl);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillLogin(this.login);
        loginPage.fillPassword(this.password);
        loginPage.clickSubmitButton();
        DashboardPage dashboardPage = new DashboardPage(driver);
        dashboardPage.verifyLoadedDashboardPage();
    }
}
