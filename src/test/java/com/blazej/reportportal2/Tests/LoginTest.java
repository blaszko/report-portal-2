package com.blazej.reportportal2.Tests;

import com.blazej.reportportal2.components.common.LoginPage;
import com.blazej.reportportal2.components.dashboard.DashboardPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

public class LoginTest extends BaseTest{
    String pageUrl = "http://localhost:8080/ui/#login";
    String login = "default";
    String password = "1q2w3e";
    @Test
    public void loginToReportPortal(){
        driver.navigate().to(this.pageUrl);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillLogin(this.login);
        loginPage.fillPassword(this.password);
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
        loginPage.fillLogin(this.login);
        loginPage.fillPassword(this.password);
        loginPage.clickSubmitButton();
        DashboardPage dashboardPage = new DashboardPage(driver);
        dashboardPage.verifyLoadedDashboardPage();
    }

}
