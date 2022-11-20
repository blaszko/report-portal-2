package com.blazej.reportportal2.tests;

import com.blazej.reportportal2.components.common.LoginPage;
import com.blazej.reportportal2.components.dashboard.DashboardPage;
import com.blazej.reportportal2.utils.PropertiesLoader;
import com.github.javafaker.Faker;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Locale;

public class LoginNGTest{
    String login = PropertiesLoader.loadProperty("LOGIN");
    String password = PropertiesLoader.loadProperty("PASSWORD");
    private static final Logger logger = LogManager.getLogger(LoginNGTest.class.getName());

    public LoginNGTest() throws IOException {
    }

    @BeforeMethod
    public void setup(){
        WebDriverFactoryStaticThreadLocal.setDriver();
    }

    @AfterMethod
    public void tearDown(){
        WebDriverFactoryStaticThreadLocal.closeBrowser();
    }
    @Test
    public void loginToReportPortal() throws Exception {
        WebDriver driver = WebDriverFactoryStaticThreadLocal.getDriver();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.navigateToLoginPage();
        loginPage.waitForLoadedLoginPage();
        loginPage.fillLogin(this.login);
        loginPage.fillPassword(this.password);
        loginPage.clickSubmitButton();
        DashboardPage dashboardPage = new DashboardPage(driver);
        dashboardPage.verifyLoadedDashboardPage();
    }

    //    @Description("Login to report portal with not valid login ")
    @Test
    public void loginToReportPortalWithNotValidLoginTest() throws Exception {
        WebDriver driver = WebDriverFactoryStaticThreadLocal.getDriver();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.navigateToLoginPage();
        loginPage.waitForLoadedLoginPage();
        Faker faker = new Faker(new Locale("en-US"));
        loginPage.fillLogin(faker.regexify("[a-z]{6}"));
        loginPage.fillPassword(this.password);
        loginPage.clickSubmitButton();
        loginPage.verifyLoginErrorMessage();
    }

    @Test
    void loginToReportPortalWithNotValidPasswordTest() throws Exception {
        WebDriver driver = WebDriverFactoryStaticThreadLocal.getDriver();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.navigateToLoginPage();
        loginPage.waitForLoadedLoginPage();
        Faker faker = new Faker(new Locale("en-US"));
        loginPage.fillLogin(this.login);
        loginPage.fillPassword(faker.regexify("[a-z]{6}"));
        loginPage.clickSubmitButton();
        loginPage.verifyLoginErrorMessage();
    }
}
