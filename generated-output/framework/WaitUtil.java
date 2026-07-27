package framework;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtil {

    private WebDriver driver;
    private WebDriverWait wait;

    public WaitUtil(WebDriver driver) {

        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public WebElement waitForVisibility(WebElement element) {

        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public WebElement waitForClickable(WebElement element) {

        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public boolean waitForText(WebElement element, String text) {

        return wait.until(ExpectedConditions.textToBePresentInElement(element, text));
    }

    public boolean waitForInvisibility(WebElement element) {

        return wait.until(ExpectedConditions.invisibilityOf(element));
    }

}
