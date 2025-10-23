package com.OHRM.drivers;

import com.OHRM.config.ConfigManager;
import com.OHRM.enums.BrowserType;
import com.OHRM.factory.DriverFactory;
import com.OHRM.utils.LoggerUtil;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class DriverManager {
    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private static final ThreadLocal<BrowserType> browserType = new ThreadLocal<>();

    public static void initializeDriver() {
        if (driver.get() == null) {
            BrowserType browser = browserType.get() != null ?
                    browserType.get() :
                    BrowserType.valueOf(ConfigManager.getInstance().getBrowser().toUpperCase());

            WebDriver webDriver = DriverFactory.createDriver(browser);
            webDriver.manage().timeouts()
                    .implicitlyWait(Duration.ofSeconds(ConfigManager.getInstance().getImplicitWait()))
                    .pageLoadTimeout(Duration.ofSeconds(ConfigManager.getInstance().getPageLoadTimeout()));
            webDriver.manage().window().maximize();
            driver.set(webDriver);

            LoggerUtil.info("✅ Driver initialisé pour le navigateur: " + browser);
        }
    }

    public static WebDriver getDriver() {
        if (driver.get() == null) {
            initializeDriver();
        }
        return driver.get();
    }

    public static void setBrowserType(BrowserType browser) {
        browserType.set(browser);
    }

    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
            browserType.remove();
            LoggerUtil.info("🧹 Driver fermé proprement");
        }
    }
}
