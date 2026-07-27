package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import framework.BaseTest;
import framework.LoggerUtil;
import pages.RegistrationPage;

public class RegistrationTests extends BaseTest {

    private RegistrationPage page;

    @BeforeMethod
    public void initialize() {
        page = new RegistrationPage(getDriver());
    }

    @Test
    public void registerWithValidEmail() {

        LoggerUtil.info("Executing Scenario : Register with valid email");

        String email = "valid@example.com";
        String password = "Password123!";
        String confirmPassword = "Password123!";

        page.enterEmailInput(email);
        page.enterPasswordInput(password);
        page.enterConfirmPasswordInput(confirmPassword);
        page.clickRegisterButton();

        Assert.assertEquals(
                page.getSuccessMessage(),
                "Registration Successful");


    }

    @Test
    public void registerWithExistingEmail() {

        LoggerUtil.info("Executing Scenario : Register with existing email");

        String email = "existing@example.com";
        String password = "Password123!";
        String confirmPassword = "Password123!";

        page.enterEmailInput(email);
        page.enterPasswordInput(password);
        page.enterConfirmPasswordInput(confirmPassword);
        page.clickRegisterButton();

        Assert.assertEquals(
                page.getEmailExistsErrorMessage(),
                "Email already exists");


    }

    @Test
    public void registerWithInvalidEmailFormat() {

        LoggerUtil.info("Executing Scenario : Register with invalid email format");

        String email = "invalid-email";
        String password = "Password123!";
        String confirmPassword = "Password123!";

        page.enterEmailInput(email);
        page.enterPasswordInput(password);
        page.enterConfirmPasswordInput(confirmPassword);
        page.clickRegisterButton();

        Assert.assertEquals(
                page.getInvalidEmailFormatErrorMessage(),
                "Invalid email format");


    }

    @Test
    public void registerWithPasswordLessThan8Characters() {

        LoggerUtil.info("Executing Scenario : Register with password less than 8 characters");

        String email = "boundary@example.com";
        String password = "Pass1!";
        String confirmPassword = "Pass1!";

        page.enterEmailInput(email);
        page.enterPasswordInput(password);
        page.enterConfirmPasswordInput(confirmPassword);
        page.clickRegisterButton();

        Assert.assertEquals(
                page.getPasswordLengthErrorMessage(),
                "Password should contain minimum 8 characters");


    }

    @Test
    public void registerWithPasswordMismatch() {

        LoggerUtil.info("Executing Scenario : Register with password mismatch");

        String email = "mismatch@example.com";
        String password = "Password123!";
        String confirmPassword = "Password321!";

        page.enterEmailInput(email);
        page.enterPasswordInput(password);
        page.enterConfirmPasswordInput(confirmPassword);
        page.clickRegisterButton();

        Assert.assertEquals(
                page.getPasswordMismatchErrorMessage(),
                "Passwords do not match");


    }

}
