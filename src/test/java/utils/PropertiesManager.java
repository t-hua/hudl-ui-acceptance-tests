package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesManager {

    private final static String DEFAULT_PROPERTIES_FILE = "src/test/resources" + File.separator + "environment.properties";

    private static Properties defaultProps = new Properties();

    static {
        Properties systemProps = System.getProperties();
        defaultProps.putAll(systemProps);
        try {
            FileInputStream fileInputStream = new FileInputStream(DEFAULT_PROPERTIES_FILE);
            defaultProps.load(fileInputStream);
            fileInputStream.close();
        } catch (IOException e) {
            System.err.println("Error loading properties file: " + e.getMessage());
        }
    }

    public static String getProperty(String key) {
        String value = System.getProperty(key);

        if (value != null) {
            return value;
        }
        // Otherwise, return the default value from the properties file
        return defaultProps.getProperty(key);
    }
}
