package com.blazej.reportportal2.tests;

import com.blazej.reportportal2.utils.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.time.Duration;

public class BaseTest {
    public WebDriver driver;

    @BeforeMethod
    public void setup() throws IOException {
        this.driver = DriverFactory.getDriver();
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        this.driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() {
        this.driver.quit();
    }
}
