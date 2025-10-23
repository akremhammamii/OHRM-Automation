package com.OHRM.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import com.OHRM.exceptions.FrameworkException;

public class PropertyReader {
    private static Properties properties;

    public static Properties loadProperties(String filePath) {
        properties = new Properties();
        try (FileInputStream fis = new FileInputStream(filePath)) {
            properties.load(fis);
        } catch (IOException e) {
            throw new FrameworkException("Failed to load properties file: " + filePath, e);
        }
        return properties;
    }

    public static String getProperty(String key) {
        if (properties == null) {
            throw new FrameworkException("Properties not loaded. Call loadProperties() first.");
        }
        return properties.getProperty(key);
    }
}
