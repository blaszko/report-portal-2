package com.blazej.reportportal2.tests;

import com.blazej.reportportal2.components.common.LoginPage;
import com.blazej.reportportal2.components.dashboard.DashboardPage;
import com.blazej.reportportal2.components.dashboard.LaunchesPage;
import com.blazej.reportportal2.utils.PropertiesLoader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class LaunchTests extends BaseTest{
    String login = PropertiesLoader.loadProperty("LOGIN");
    String password = PropertiesLoader.loadProperty("PASSWORD");

    private static final Logger logger = LogManager.getLogger(LoginPage.class.getName());

    public LaunchTests() throws IOException {
    }

    @Test
    public void verifyLaunches() throws Exception {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.navigateToLoginPage();
        loginPage.waitForLoadedLoginPage();
        loginPage.fillLogin(this.login);
        loginPage.fillPassword(this.password);
        loginPage.clickSubmitButton();
        DashboardPage dashboardPage = new DashboardPage(driver);
        dashboardPage.verifyLoadedDashboardPage();
        dashboardPage.clickButtonLaunches();

        LaunchesPage launchesPage = new LaunchesPage(driver);
        launchesPage.navigateToLaunchesPage();
        launchesPage.waitForLoadedLaunchesPage();
        launchesPage.clickButtonAddFilter();
        launchesPage.fillInLaunchName("Demo Api Tests");
        launchesPage.waitForLoadedLaunchesPage();
        launchesPage.clickDropDownAddMoreFilters();
        launchesPage.clickOptionAddMoreFilters();

        launchesPage.clickDropDownLaunchNumber();
        launchesPage.clickOptionLaunchNumberFilters("equals");
        launchesPage.fillInLunchNumber("2");
        launchesPage.waitForLoadedLaunchesPage();

        Assert.assertEquals(launchesPage.grabLaunchStatistics(5), "5");

        System.out.println("");
    }
}
