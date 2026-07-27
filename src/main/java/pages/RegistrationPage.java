package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {

    private WebDriver driver;

    @FindBy(id="email")
    private WebElement emailInput;

    @FindBy(id="password")
    private WebElement passwordInput;

    @FindBy(id="confirmPassword")
    private WebElement confirmPasswordInput;

    @FindBy(id="registerButton")
    private WebElement registerButton;

    @FindBy(id="successMessage")
    private WebElement successMessage;

    @FindBy(id="emailExistsError")
    private WebElement emailExistsErrorMessage;

    @FindBy(id="passwordLengthError")
    private WebElement passwordLengthErrorMessage;

    @FindBy(id="passwordUppercaseError")
    private WebElement passwordUppercaseErrorMessage;

    @FindBy(id="passwordLowercaseError")
    private WebElement passwordLowercaseErrorMessage;

    @FindBy(id="passwordSpecialCharError")
    private WebElement passwordSpecialCharErrorMessage;

    @FindBy(id="invalidEmailFormatError")
    private WebElement invalidEmailFormatErrorMessage;

    @FindBy(id="emptyEmailError")
    private WebElement emptyEmailErrorMessage;

    @FindBy(id="emptyPasswordError")
    private WebElement emptyPasswordErrorMessage;

    @FindBy(id="passwordMismatchError")
    private WebElement passwordMismatchErrorMessage;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterEmailInput(String value) {
        emailInput.sendKeys(value);
    }

    public void enterPasswordInput(String value) {
        passwordInput.sendKeys(value);
    }

    public void enterConfirmPasswordInput(String value) {
        confirmPasswordInput.sendKeys(value);
    }

    public void clickRegisterButton() {
        registerButton.click();
    }

    public String getSuccessMessage() {
        return successMessage.getText();
    }

    public String getEmailExistsErrorMessage() {
        return emailExistsErrorMessage.getText();
    }

    public String getPasswordLengthErrorMessage() {
        return passwordLengthErrorMessage.getText();
    }

    public String getPasswordUppercaseErrorMessage() {
        return passwordUppercaseErrorMessage.getText();
    }

    public String getPasswordLowercaseErrorMessage() {
        return passwordLowercaseErrorMessage.getText();
    }

    public String getPasswordSpecialCharErrorMessage() {
        return passwordSpecialCharErrorMessage.getText();
    }

    public String getInvalidEmailFormatErrorMessage() {
        return invalidEmailFormatErrorMessage.getText();
    }

    public String getEmptyEmailErrorMessage() {
        return emptyEmailErrorMessage.getText();
    }

    public String getEmptyPasswordErrorMessage() {
        return emptyPasswordErrorMessage.getText();
    }

    public String getPasswordMismatchErrorMessage() {
        return passwordMismatchErrorMessage.getText();
    }

}
