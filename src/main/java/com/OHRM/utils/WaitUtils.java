package com.OHRM.utils;

import com.OHRM.config.ConfigManager;
import com.OHRM.drivers.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtils {

    private static int EXPLICIT_WAIT = ConfigManager.getInstance().getExplicitWait();

    private static WebDriver getDriver() {
        return DriverManager.getDriver();
    }
    

    private static WebDriverWait getWait() {
        return new WebDriverWait(getDriver(), Duration.ofSeconds(EXPLICIT_WAIT));
    }

    public static WebElement waitForElementToBeVisible(By locator) {
        return getWait().until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static WebElement waitForElementToBeClickable(By locator) {
        return getWait().until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static boolean waitForElementToDisappear(By locator) {
        return getWait().until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public static void waitForPageToLoad() {
        getWait().until(webDriver ->
            "complete".equals(((org.openqa.selenium.JavascriptExecutor) webDriver)
                .executeScript("return document.readyState"))
        );
    }
}
