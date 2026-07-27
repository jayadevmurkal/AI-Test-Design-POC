package framework;

import java.util.logging.Logger;
import java.util.logging.Level;

public class LoggerUtil {

    private static final Logger logger = Logger.getLogger(LoggerUtil.class.getName());

    public static void info(String message) {
        logger.info(message);
    }

    public static void warning(String message) {
        logger.warning(message);
    }

    public static void error(String message) {
        logger.log(Level.SEVERE, message);
    }

}
