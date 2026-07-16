package utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LoggerUtil {

        private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        public static void info(String message) {

                System.out.println(
                                "[INFO] "
                                                + LocalDateTime.now().format(formatter)
                                                + " - "
                                                + message);
        }

        public static void success(String message) {

                System.out.println(
                                "[SUCCESS] "
                                                + LocalDateTime.now().format(formatter)
                                                + " - "
                                                + message);
        }

        public static void error(String message) {

                System.out.println(
                                "[ERROR] "
                                                + LocalDateTime.now().format(formatter)
                                                + " - "
                                                + message);
        }
}