package com.OHRM.context;


import com.OHRM.config.ConfigManager;
import com.OHRM.drivers.DriverManager;
import com.OHRM.pages.HomePage;
import com.OHRM.pages.LoginPage;
import com.OHRM.utils.SeleniumUtils;

public class TestContext {
    private LoginPage loginPage;
    private HomePage homePage;
    private SeleniumUtils seleniumUtils;
    
    public static TestContext getInstance() {
        return new TestContext();
    }
    
    
    public static String getBaseUrlStatic() {
        return ConfigManager.getInstance().getBaseUrl();
    }

    
    public LoginPage getLoginPage() {
        if (loginPage == null) {
            loginPage = new LoginPage();
        }
        return loginPage;
    }
    
    public HomePage getHomePage() {
        if (homePage == null) {
            homePage = new HomePage();
        }
        return homePage;
    }
    
    public SeleniumUtils getSeleniumUtils() {
        if (seleniumUtils == null) {
            seleniumUtils = new SeleniumUtils();
        }
        return seleniumUtils;
    }
    
    public ConfigManager getConfig() {
        return ConfigManager.getInstance();
    }
    
    public String getBaseUrl() {
        return getConfig().getBaseUrl();
    }
    
    public String getDashboardUrl() {
        return getConfig().getDashboardUrl();
    }
    
    public void reset() {
        loginPage = null;
        homePage = null;
        seleniumUtils = null;
    }
}
