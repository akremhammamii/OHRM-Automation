package com.OHRM.config;

import com.OHRM.utils.PropertyReader;
import java.util.Properties;

public class ConfigManager {
    private static final String CONFIG_FILE = "src/main/resources/config/config.properties";
    private static Properties properties;
    private static ConfigManager instance;

    private ConfigManager() {
        properties = PropertyReader.loadProperties(CONFIG_FILE);
    }

    public static ConfigManager getInstance() {
        if (instance == null) {
            instance = new ConfigManager();
        }
        return instance;
    }

    public String get(String key) {
        return properties.getProperty(key);
    }

    public String getBrowser() {
        return get("browser");
    }

    public String getBaseUrl() {
        return get("baseUrl");
    }

    public String getDashboardUrl() {
        return get("dashboardUrl");
    }

    public int getImplicitWait() {
        return Integer.parseInt(get("implicit.wait"));
    }

    public int getExplicitWait() {
        return Integer.parseInt(get("explicit.wait"));
    }

    public int getPageLoadTimeout() {
        return Integer.parseInt(get("page.load.timeout"));
    }


    public boolean isHeadless() {
        return Boolean.parseBoolean(get("headless"));
    }

    public String getValidUsername() {
        return get("validUsername");
    }

    public String getValidPassword() {
        return get("validPassword");
    }

    public String getInvalidUsername() {
        return get("invalidUsername");
    }

    public String getInvalidPassword() {
        return get("invalidPassword");
    }

    public String getScreenshotDirectory() {
        return get("screenshotDirectory");
    }
}
