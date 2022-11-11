package com.blazej.reportportal2.components.common;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private final String url = "http://localhost:8080/ui/#login";
    private WebDriver driver;
    private static final Logger logger = LogManager.getLogger(LoginPage.class.getName());

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(name = "login")
    public WebElement loginInput;

    @FindBy(name = "password")
    public WebElement passwordInput;

    @FindBy(css = "[type=\"submit\"]")
    public WebElement loginButton;

    public void fillLogin(String login) {
        logger.info("Fill in login");
        this.loginInput.sendKeys(login);
    }

    public void fillPassword(String password) {
        logger.info("Fill in password");
        this.passwordInput.sendKeys(password);
    }

    public void clickSubmitButton() {
        logger.info("Click submit button");
        this.loginButton.click();
    }

    public void waitForLoadedLoginPage() {
        logger.info("Wait for Loaded Login Page");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(this.loginButton));
    }
}