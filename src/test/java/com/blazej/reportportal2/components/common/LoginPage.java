package com.blazej.reportportal2.components.common;

import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

import static com.blazej.reportportal2.utils.methodsModuleGui.WaitMethods.waitForVisible;
import static org.junit.jupiter.api.Assertions.fail;

public class LoginPage {
    private final WebDriver driver;
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

    @Step("Fill login")
    public void fillLogin(String login) {
        logger.info("Fill in login");
        this.loginInput.sendKeys(login);
    }

    @Step("Fill password")
    public void fillPassword(String password) {
        logger.info("Fill in password");
        this.passwordInput.sendKeys(password);
    }

    @Step("Click Submit button")
    public void clickSubmitButton() {
        logger.info("Click submit button");
        this.loginButton.click();
    }

    public void waitForLoadedLoginPage() {
        logger.info("Wait for Loaded Login Page");
        waitForVisible(driver, this.loginButton);
    }
}