package com.blazej.reportportal2.tests;

import com.blazej.reportportal2.components.common.LoginPage;
import com.blazej.reportportal2.components.dashboard.DashboardPage;
import com.blazej.reportportal2.components.dashboard.LaunchesPage;
import com.blazej.reportportal2.components.dashboard.SuitsPage;
import com.blazej.reportportal2.utils.PropertiesLoader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class SuitsTest extends BaseTest {
    String login = PropertiesLoader.loadProperty("LOGIN");
    String password = PropertiesLoader.loadProperty("PASSWORD");

    private static final Logger logger = LogManager.getLogger(LoginPage.class.getName());

    public SuitsTest() throws IOException {
    }

    @Test(dataProvider = "data")
    public void verifyTestSuitesInLaunches(String launchName, String launchNumber, String suitName, String label, int columnNumber, String expectedValue) throws Exception {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.navigateToLoginPage();
        loginPage.waitForLoadedLoginPage();
        loginPage.fillLogin(this.login);
        loginPage.fillPassword(this.password);
        loginPage.clickSubmitButton();
        DashboardPage dashboardPage = new DashboardPage(driver);
        dashboardPage.verifyLoadedDashboardPage();

        LaunchesPage launchesPage = new LaunchesPage(driver);
        launchesPage.navigateToLaunchesPage();
        launchesPage.waitForLoadedLaunchesPage();
        launchesPage.clickButtonAddFilter();
        launchesPage.fillInLaunchName(launchName);
        launchesPage.waitForLoadedLaunchesPage();
        launchesPage.clickDropDownAddMoreFilters();
        launchesPage.clickOptionAddMoreFilters();

        launchesPage.clickDropDownLaunchNumber();
        launchesPage.clickOptionLaunchNumberFilters("equals");
        launchesPage.fillInLunchNumber(launchNumber);
        launchesPage.waitForLoadedLaunchesPage();
        launchesPage.clickFirstLaunch();

        SuitsPage suitsPage = new SuitsPage(driver);
        suitsPage.fillInSuitName(suitName);
        suitsPage.waitForLoadedSuitsPage();
        Assert.assertEquals(suitsPage.grabSuitStatistics(columnNumber), expectedValue);
    }

    @DataProvider(name = "data")
    public Object[][] dataProvider() {
        return new Object[][]{
                {"Demo Api Tests", "2", "Filtering Launch Tests", "TOTAL", 3, "8"},
                {"Demo Api Tests", "2", "Filtering Launch Tests", "PASSED", 4, "5"},
                {"Demo Api Tests", "2", "Filtering Launch Tests", "FAILED", 5, "3"},
                {"Demo Api Tests", "2", "Filtering Launch Tests", "SKIPPED", 6, ""},
                {"Demo Api Tests", "2", "Filtering Launch Tests", "PRODUCT_BUG", 7, ""},
                {"Demo Api Tests", "2", "Filtering Launch Tests", "AUTO_BUG", 8, ""},
                {"Demo Api Tests", "2", "Filtering Launch Tests", "SYSTEM_ISSUE", 9, "3"},
                {"Demo Api Tests", "2", "Filtering Launch Tests", "TO_INVESTIGATE", 10, "3"},
        };
    }
}

