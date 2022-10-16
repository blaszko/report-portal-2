package com.blazej.reportportal2.components.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

// page_url = http://localhost:8080/ui/#login
public class LoginPage {
    private final String url = "http://localhost:8080/ui/#login";

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "login")
    public WebElement loginInput;

    @FindBy(name = "password")
    public WebElement passwordInput;

    @FindBy(css = "[type=\"submit\"]")
    public WebElement loginButton;

    public void fillLogin(String login) {
        this.loginInput.sendKeys(login);
    }

    public void fillPassword(String password) {
        this.passwordInput.sendKeys(password);
    }

    public void clickSubmitButton(){
        this.loginButton.click();
    }

}