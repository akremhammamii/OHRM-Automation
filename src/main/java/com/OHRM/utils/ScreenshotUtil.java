package com.OHRM.utils;

import com.OHRM.config.ConfigManager;
import com.OHRM.drivers.DriverManager;
import com.OHRM.utils.LoggerUtil;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtil {
    
    public static String takeScreenshot(String screenshotName) {
        WebDriver driver = DriverManager.getDriver();
        
        // Créer le répertoire des captures d'écran s'il n'existe pas
        String screenshotDir = ConfigManager.getInstance().getScreenshotDirectory();
        File directory = new File(screenshotDir);
        if (!directory.exists()) {
            directory.mkdirs();
        }
        
        // Générer un nom de fichier avec un horodatage
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String fileName = screenshotName + "_" + timestamp + ".png";
        String filePath = screenshotDir + fileName;
        
        try {
            // Prendre la capture d'écran
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Path destination = Paths.get(filePath);
            Files.copy(screenshot.toPath(), destination);
            
            LoggerUtil.info("Capture d'écran enregistrée: " + filePath);
            return filePath;
        } catch (IOException e) {
            LoggerUtil.error("Erreur lors de la prise de capture d'écran: " + e.getMessage());
            return null;
        }
    }

    public static byte[] getScreenshot() {
        WebDriver driver = DriverManager.getDriver();
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}
