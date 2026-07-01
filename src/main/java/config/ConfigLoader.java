package config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigLoader {

    private static final Properties properties = new Properties();

    static {
        try (InputStream input = ConfigLoader.class.getClassLoader()
                .getResourceAsStream(FrameworkConstants.CONFIG_FILE)) {

            if (input == null) {
                throw new RuntimeException("config.properties not found.");
            }

            properties.load(input);

        } catch (IOException e) {
            throw new RuntimeException("Unable to load config.properties", e);
        }
    }

    private ConfigLoader() {
        // Prevent instantiation
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}