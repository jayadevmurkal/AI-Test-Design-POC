package framework;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties = new Properties();

    static {
        try {
            FileInputStream fis = new FileInputStream("generated-output/config/config.properties");
            properties.load(fis);
        } catch (Exception e) {
            throw new RuntimeException("Unable to load config.properties", e);
        }
    }

    public static String get(String key) {
        return properties.getProperty(key);
    }
}
