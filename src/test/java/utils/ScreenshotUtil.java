package utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtil {

    public static String captureScreenshot(
            WebDriver driver,
            String testName) {

        try {

            File source = ((TakesScreenshot) driver)
                    .getScreenshotAs(OutputType.FILE);

            String destination = "reports/screenshots/"
                    + testName
                    + ".png";

            File destFile = new File(destination);

            destFile.getParentFile().mkdirs();

            Files.copy(
                    source.toPath(),
                    destFile.toPath(),
                    StandardCopyOption.REPLACE_EXISTING);

            return destination;

        } catch (IOException e) {

            e.printStackTrace();

            return null;
        }
    }
}