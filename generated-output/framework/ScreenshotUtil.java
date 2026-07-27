package framework;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtil {

    public static String capture(WebDriver driver, String testName) {

        try {

            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss")
                    .format(new Date());

            String folder = "reports/screenshots";

            File directory = new File(folder);

            if (!directory.exists()) {
                directory.mkdirs();
            }

            File source = ((TakesScreenshot) driver)
                    .getScreenshotAs(OutputType.FILE);

            String destinationPath =
                    folder + "/" + testName + "_" + timestamp + ".png";

            File destination = new File(destinationPath);

            Files.copy(
                    source.toPath(),
                    destination.toPath(),
                    StandardCopyOption.REPLACE_EXISTING);

            return destination.getAbsolutePath();

        } catch (IOException e) {

            e.printStackTrace();

            return null;
        }

    }

}
