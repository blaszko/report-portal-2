package com.blazej.reportportal2.components.dashboard;

//import org.junit.jupiter.api.Assertions;
import com.blazej.reportportal2.components.common.LoginPage;
import com.blazej.reportportal2.utils.PropertiesLoader;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

import static com.blazej.reportportal2.utils.methodsModuleGui.ClickMethods.clickOnElement;
import static com.blazej.reportportal2.utils.methodsModuleGui.NavigateMethods.navigateTo;
import static com.blazej.reportportal2.utils.methodsModuleGui.SyncMethods.sleep;
import static com.blazej.reportportal2.utils.methodsModuleGui.WaitMethods.waitForNotVisible;
import static com.blazej.reportportal2.utils.methodsModuleGui.WaitMethods.waitForVisible;

public class LaunchesPage {
    private final WebDriver driver;
    private static final Logger logger = LogManager.getLogger(LoginPage.class.getName());
    String url;

    public LaunchesPage(WebDriver driver) throws IOException {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.url = PropertiesLoader.loadProperty("BASE_URI")
                + PropertiesLoader.loadProperty("LAUNCHES_PATH");
    }

    @FindBy(css = "[class^=\"allLatestDropdown__value\"]:first-child")
    WebElement dropDownAllLaunches;

    @FindBy(css = "div[class^=\"spinningPreloader__preloader\"]:nth-child(2)")
    WebElement loaderManage;

    @FindBy(css = "[class^=\"paginationToolbar\"]")
    WebElement labelPaginator;


    @FindBy(css = "[class^=\"launchFiltersToolbar__add-filter-button\"]")
    WebElement buttonAddFilter;

    @FindBy(css = "input[class^=\"inputConditional__input\"]")
    WebElement inputEnterName;

    @FindBy(css = "[class^=\"entitiesSelector__toggler\"]")
    WebElement dropDownMoreFilters;

    @FindBy(css = "[class^=\"entitiesGroup__entity-item\"]:nth-child(2) [class^=\"inputConditional__condition-selected\"]:first-child")
    WebElement dropDownLaunchNumber;

    @FindBy(css = "input[placeholder=\"Enter number\"]")
    WebElement inputEnterNumber;

    @FindBy(css = "[class^=\"entitiesGroup__entity-item\"]:nth-child(2) [class^=\"inputConditional__conditions-list\"] " +
            "[class^=\"inputConditional__condition\"]:nth-child(1)")
    WebElement optionEqualsLaunchNumber;


    private WebElement optionFilterMore(String optionName){
        return driver.findElement(By.xpath("*//span[text()=\"" + optionName + "\"]"));
    }

    private WebElement optionFilterLaunchNumber(String optionName){
        return driver.findElement(By.xpath("//div[contains(@class, 'entitiesGroup__entity-item')][2]//div[text()=\"" + optionName + "\"]"));
    }

    private WebElement labelStatisticsOnGrid(int number){
        return driver.findElement(By.cssSelector("[class^=\"launchSuiteGrid\"]:nth-child(" + number + ")"));
    }


    @Step("Waiting for Launches page to load")
    public void waitForLoadedLaunchesPage() {
        logger.info("Wait for Loaded Launches Page");
        waitForVisible(this.driver, this.dropDownAllLaunches);
        waitForVisible(this.driver, this.labelPaginator);
//        waitForNotVisible(this.driver, this.loaderManage);
    }

    @Step("Navigate to Launches Page")
    public void navigateToLaunchesPage() {
        navigateTo(this.driver, this.url);
    }

    @Step("Click button add filter")
    public void clickButtonAddFilter() {
        clickOnElement(driver, buttonAddFilter);
    }

    @Step("Fill in launch name")
    public void fillInLaunchName(String name) {
        inputEnterName.sendKeys(name);
    }

    @Step("Click drop down add more filters")
    public void clickDropDownAddMoreFilters() {
        clickOnElement(driver, dropDownMoreFilters);
    }

    @Step("Click option add more filters")
    public void clickOptionAddMoreFilters() {
        clickOnElement(driver, optionFilterMore("Launch number"));
    }

    @Step("Click drop down launch number")
    public void clickDropDownLaunchNumber() {
        clickOnElement(driver, dropDownLaunchNumber);
    }

    @Step("Click option add more filters")
    public void clickOptionLaunchNumberFilters(String filter) {
//        clickOnElement(driver, optionFilterMore(filter));
        clickOnElement(driver, optionEqualsLaunchNumber);
    }

    @Step("Fill in lunch number")
    public void fillInLunchNumber(String number) {
        inputEnterNumber.sendKeys(number);
    }


    @Step("Grab statistic")
    public String grabLaunchStatistics(int number) throws Exception {
        Integer timeout2sec = 2;
        sleep(timeout2sec);
        return labelStatisticsOnGrid(number).getText();
    }

}