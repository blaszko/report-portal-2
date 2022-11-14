package com.blazej.reportportal2.components.common;

import com.blazej.reportportal2.utils.PropertiesLoader;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

import static com.blazej.reportportal2.utils.methodsModuleGui.NavigateMethods.navigateTo;
import static com.blazej.reportportal2.utils.methodsModuleGui.SyncMethods.sleep;
import static com.blazej.reportportal2.utils.methodsModuleGui.WaitMethods.waitForVisible;

public class LoginPage {
    private final WebDriver driver;
    private static final Logger logger = LogManager.getLogger(LoginPage.class.getName());
    String url;
    int timeout2sec;

    public LoginPage(WebDriver driver) throws IOException {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.url = PropertiesLoader.loadProperty("BASE_URI") + PropertiesLoader.loadProperty("LOGIN_PATH");
    }

    @FindBy(name = "login")
    public WebElement loginInput;

    @FindBy(name = "password")
    public WebElement passwordInput;

    @FindBy(css = "[type=\"submit\"]")
    public WebElement loginButton;

    @FindBy(css = "[class*=\"notificationItem__error\"]")
    public WebElement errorMessage;

    @Step("Fill login")
    public void fillLogin(String login) throws Exception {
        logger.info("Fill in login");
        sleep(this.timeout2sec);
        this.loginInput.sendKeys(login);
    }

    @Step("Fill password")
    public void fillPassword(String password) throws Exception {
        logger.info("Fill in password");
        sleep(this.timeout2sec);
        this.passwordInput.sendKeys(password);
    }

    @Step("Click submit button")
    public void clickSubmitButton() throws Exception {
        logger.info("Click submit button");
        sleep(this.timeout2sec);
        this.loginButton.click();
    }

    @Step("Waiting for page to load")
    public void waitForLoadedLoginPage() {
        logger.info("Wait for Loaded Login Page");
        waitForVisible(this.driver, this.loginButton);
    }

    @Step("Navigate to Login Page")
    public void navigateToLoginPage() {
        navigateTo(this.driver, this.url);
    }

    @Step("Verify is error message appear")
    public void verifyLoginErrorMessage() {
        waitForVisible(this.driver, this.errorMessage);
        Assertions.assertTrue(this.errorMessage.isDisplayed());
    }
}