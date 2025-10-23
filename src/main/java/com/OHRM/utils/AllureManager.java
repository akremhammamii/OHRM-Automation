package com.OHRM.utils;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import java.io.ByteArrayInputStream;

public class AllureManager {
    
    @Step("{0}")
    public static void logStep(String step) {
        // Ajouter des étapes personnalisées dans le rapport Allure
    }
    
    public static void setScenarioName(String scenarioName) {
        Allure.getLifecycle().updateTestCase(testResult -> 
            testResult.setName(scenarioName));
    }
    
    public static void attachScreenshot(byte[] screenshot) {
        Allure.addAttachment("Screenshot", new ByteArrayInputStream(screenshot));
    }
    
    public static void attachText(String title, String content) {
        Allure.addAttachment(title, "text/plain", content);
    }
}
