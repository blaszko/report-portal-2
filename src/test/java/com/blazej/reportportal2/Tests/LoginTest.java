package com.blazej.reportportal2.Tests;

import com.blazej.reportportal2.components.common.LoginPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {

    String pageUrl = "http://localhost:8080/ui/#login";
    String login = "default";
    String password = "1q2w3e";
    private WebDriver driver;

    @BeforeEach
    public void setUp(){
        driver = new ChromeDriver();
        driver.navigate().to(this.pageUrl);
    }

    @Test
    public void loginToReportPortal(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillLogin(this.login);
        loginPage.fillPassword(this.password);
        loginPage.clickSubmitButton();
    }
    @AfterEach
    public void tearDown(){
        driver.quit();
    }
}
