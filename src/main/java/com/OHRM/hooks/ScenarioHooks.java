package com.OHRM.hooks;

import com.OHRM.context.TestContext;
import com.OHRM.drivers.DriverManager;
import com.OHRM.utils.AllureManager;
import com.OHRM.utils.LoggerUtil;
import com.OHRM.utils.ScreenshotUtil;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class ScenarioHooks {

    private final TestContext context;

    public ScenarioHooks(TestContext context) {
        this.context = context;
    }

    @Before
    public void setup(Scenario scenario) {
        LoggerUtil.info("🚀 Démarrage du scénario: " + scenario.getName());
        DriverManager.initializeDriver();
        DriverManager.getDriver().get(context.getBaseUrl());
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            LoggerUtil.error("❌ Échec du scénario: " + scenario.getName());
            byte[] screenshot = ScreenshotUtil.getScreenshot();
            scenario.attach(screenshot, "image/png", "screenshot");
            try {
                AllureManager.attachScreenshot(screenshot);
            } catch (Exception e) {
                LoggerUtil.warn("Erreur attachement Allure : " + e.getMessage());
            }
            ScreenshotUtil.takeScreenshot("failed_" + scenario.getName().replace(" ", "_"));
        }
        DriverManager.quitDriver();
        context.reset();
        LoggerUtil.info("✅ Fin du scénario: " + scenario.getName());
    }
}
