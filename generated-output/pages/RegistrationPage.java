package pages;

import framework.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage extends BasePage {

    @FindBy(name = "email")
    private WebElement emailInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(xpath = "//input[@id='confirmPassword']")
    private WebElement confirmPasswordInput;

    @FindBy(id = "registerButton")
    private WebElement registerButton;

    @FindBy(className = "success-message")
    private WebElement successMessage;

    @FindBy(id = "emailExistsError")
    private WebElement emailExistsErrorMessage;

    @FindBy(id = "invalidEmailFormatError")
    private WebElement invalidEmailFormatErrorMessage;

    @FindBy(id = "passwordLengthError")
    private WebElement passwordLengthErrorMessage;

    @FindBy(id = "passwordMismatchError")
    private WebElement passwordMismatchErrorMessage;

    public RegistrationPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void enterEmailInput(String value) {
        type(emailInput, value);
    }

    public void enterPasswordInput(String value) {
        type(passwordInput, value);
    }

    public void enterConfirmPasswordInput(String value) {
        type(confirmPasswordInput, value);
    }

    public void clickRegisterButton() {
        click(registerButton);
    }

    public String getSuccessMessage() {
        return getText(successMessage);
    }

    public String getEmailExistsErrorMessage() {
        return getText(emailExistsErrorMessage);
    }

    public String getInvalidEmailFormatErrorMessage() {
        return getText(invalidEmailFormatErrorMessage);
    }

    public String getPasswordLengthErrorMessage() {
        return getText(passwordLengthErrorMessage);
    }

    public String getPasswordMismatchErrorMessage() {
        return getText(passwordMismatchErrorMessage);
    }

}
