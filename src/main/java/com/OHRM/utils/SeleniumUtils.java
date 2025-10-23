package com.OHRM.utils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import com.OHRM.drivers.DriverManager;
import com.OHRM.utils.LoggerUtil;

public class SeleniumUtils {
    
    public void clearAndWriteText(WebElement element, String text) {
        try {
            element.clear();
            element.sendKeys(text);
            LoggerUtil.debug("Texte saisi: " + text);
        } catch (Exception e) {
            LoggerUtil.error("Erreur lors de la saisie de texte: " + e.getMessage());
            throw e;
        }
    }
    
    public void click(WebElement element) {
        try {
            element.click();
            LoggerUtil.debug("Clic sur l'élément");
        } catch (Exception e) {
            LoggerUtil.error("Erreur lors du clic: " + e.getMessage());
            throw e;
        }
    }
    
    public void clickWithJS(WebElement element) {
        try {
            org.openqa.selenium.JavascriptExecutor js = 
                (org.openqa.selenium.JavascriptExecutor) DriverManager.getDriver();
            js.executeScript("arguments[0].click();", element);
            LoggerUtil.debug("Clic avec JavaScript sur l'élément");
        } catch (Exception e) {
            LoggerUtil.error("Erreur lors du clic avec JavaScript: " + e.getMessage());
            throw e;
        }
    }
    
    public void hover(WebElement element) {
        try {
            Actions actions = new Actions(DriverManager.getDriver());
            actions.moveToElement(element).perform();
            LoggerUtil.debug("Survol de l'élément");
        } catch (Exception e) {
            LoggerUtil.error("Erreur lors du survol: " + e.getMessage());
            throw e;
        }
    }
    
    public void navigateTo(String url) {
        try {
            DriverManager.getDriver().get(url);
            LoggerUtil.info("Navigation vers: " + url);
        } catch (Exception e) {
            LoggerUtil.error("Erreur lors de la navigation: " + e.getMessage());
            throw e;
        }
    }
}