package com.OHRM.base;

import com.OHRM.drivers.DriverManager;
import com.OHRM.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class AbstractPage {
    protected WebDriver driver;

    public AbstractPage() {
        this.driver = DriverManager.getDriver();
    }

    protected WebElement findElement(By locator) {
        return WaitUtils.waitForElementToBeVisible(locator);
    }

    protected void click(By locator) {
        WaitUtils.waitForElementToBeClickable(locator).click();
    }

    protected void type(By locator, String text) {
        WebElement element = WaitUtils.waitForElementToBeVisible(locator);
        element.clear();
        element.sendKeys(text);
    }

    protected String getText(By locator) {
        return WaitUtils.waitForElementToBeVisible(locator).getText();
    }

    protected boolean isDisplayed(By locator) {
        try {
            return WaitUtils.waitForElementToBeVisible(locator).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    protected void waitForPageLoad() {
        WaitUtils.waitForPageToLoad();
    }
}
