package framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import framework.WaitUtil;

public class BasePage {

    protected WebDriver driver;
    protected WaitUtil waitUtil;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.waitUtil = new WaitUtil(driver);
    }

    protected void type(WebElement element, String text) {
        waitUtil.waitForVisibility(element);
        element.clear();
        element.sendKeys(text);
    }

    protected void click(WebElement element) {
        waitUtil.waitForClickable(element);
        element.click();
    }

    protected String getText(WebElement element) {
        waitUtil.waitForVisibility(element);
        return element.getText();
    }

    protected boolean isDisplayed(WebElement element) {
        return element.isDisplayed();
    }

}
