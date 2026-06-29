package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage {

    private WebDriver driver;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    private By maleGender = By.id("gender-male");

    private By firstName = By.id("FirstName");

    private By lastName = By.id("LastName");
    private By email = By.id("Email");
    private By password = By.id("Password");
    private By confirmPassword = By.id("ConfirmPassword");
    private By registerButton = By.id("register-button");

    private By successMessage = By.className("result");

    private By duplicateEmailError = By.cssSelector(".message-error");

    private By passwordValidationError = By.cssSelector("span[data-valmsg-for='Password']");

    private By confirmPasswordValidationError = By.cssSelector("span[data-valmsg-for='ConfirmPassword']");

    public void enterFirstName(String value) {
        driver.findElement(firstName).sendKeys(value);
    }

    public void enterLastName(String value) {
        driver.findElement(lastName).sendKeys(value);
    }

    public void selectGender() {
        driver.findElement(maleGender).click();
    }

    public void enterEmail(String value) {
        driver.findElement(email).clear();
        driver.findElement(email).sendKeys(value);
    }

    public void enterPassword(String value) {
        driver.findElement(password).clear();
        driver.findElement(password).sendKeys(value);

        driver.findElement(confirmPassword).clear();
        driver.findElement(confirmPassword).sendKeys(value);
    }

    public void clickRegister() {
        driver.findElement(registerButton).click();
    }

    public String getSuccessMessage() {
        return driver.findElement(successMessage).getText();
    }

    public String getDuplicateEmailMessage() {
        return driver.findElement(duplicateEmailError).getText();
    }

    public boolean isRegistrationSuccessful() {

        try {
            return driver.findElement(successMessage)
                    .isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isDuplicateEmailErrorDisplayed() {

        try {
            return driver.findElement(duplicateEmailError)
                    .isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public String getPasswordValidationMessage() {
        return driver.findElement(passwordValidationError)
                .getText();
    }

    public String getConfirmPasswordValidationMessage() {
        return driver.findElement(confirmPasswordValidationError)
                .getText();
    }
}