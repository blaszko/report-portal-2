package com.blazej.reportportal2.tests;

import com.blazej.reportportal2.components.common.LoginPage;
import com.blazej.reportportal2.components.dashboard.DashboardPage;
import com.blazej.reportportal2.components.dashboard.LaunchesPage;
import com.blazej.reportportal2.utils.PropertiesLoader;
import com.blazej.reportportal2.utils.WebDriverFactoryStaticThreadLocal;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class LaunchTests {
    String login = PropertiesLoader.loadProperty("LOGIN");
    String password = PropertiesLoader.loadProperty("PASSWORD");

    private static final Logger logger = LogManager.getLogger(LoginPage.class.getName());

    public LaunchTests() throws IOException {
    }

    @BeforeMethod
    public void setUp() {
        WebDriverFactoryStaticThreadLocal.setDriver();
    }

    @AfterMethod
    public void tearDown() {
        WebDriverFactoryStaticThreadLocal.closeBrowser();
    }

    @Test(dataProvider = "data")
    public void verifyLaunches(String launchName, String launchNumber, String label, int columnNumber, String expectedValue) throws Exception {
        LoginPage loginPage = new LoginPage(WebDriverFactoryStaticThreadLocal.getDriver());
        loginPage.navigateToLoginPage();
        loginPage.waitForLoadedLoginPage();
        loginPage.fillLogin(this.login);
        loginPage.fillPassword(this.password);
        loginPage.clickSubmitButton();
        DashboardPage dashboardPage = new DashboardPage(WebDriverFactoryStaticThreadLocal.getDriver());
        dashboardPage.verifyLoadedDashboardPage();
        dashboardPage.clickButtonLaunches();

        LaunchesPage launchesPage = new LaunchesPage(WebDriverFactoryStaticThreadLocal.getDriver());
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

        Assert.assertEquals(launchesPage.grabLaunchStatistics(columnNumber), expectedValue);
    }

    @DataProvider(name = "data", parallel = true)
    public Object[][] dataProvider() {
        return new Object[][]{
                {"Demo Api Tests", "2", "TOTAL", 4, "15"},
                {"Demo Api Tests", "2", "PASSED", 5, "5"},
                {"Demo Api Tests", "2", "FAILED", 6, "9"},
                {"Demo Api Tests", "2", "SKIPPED", 7, "1"},
                {"Demo Api Tests", "2", "PRODUCT_BUG", 8, "1"},
                {"Demo Api Tests", "2", "AUTO_BUG", 9, "5"},
                {"Demo Api Tests", "2", "SYSTEM_ISSUE", 10, "4"},
                {"Demo Api Tests", "2", "TO_INVESTIGATE", 11, "8"},
                {"Demo Api Tests", "1", "TOTAL", 4, "10"},
                {"Demo Api Tests", "1", "PASSED", 5, "1"},
                {"Demo Api Tests", "1", "FAILED", 6, "9"},
                {"Demo Api Tests", "1", "SKIPPED", 7, ""},
                {"Demo Api Tests", "1", "PRODUCT_BUG", 8, ""},
                {"Demo Api Tests", "1", "AUTO_BUG", 9, "1"},
                {"Demo Api Tests", "1", "SYSTEM_ISSUE", 10, "8"},
                {"Demo Api Tests", "1", "TO_INVESTIGATE", 11, "5"}
        };
    }
}

