package generatedtests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.RegistrationPage;

public class RegistrationTests {

    @Test
    public void registerWithValidEmail() {
        String email = "valid@example.com";
        String password = "Password123!";
        String confirmPassword = "Password123!";

        RegistrationPage page = new RegistrationPage(driver);

        page.enterEmail(email);
        page.enterPassword(password);
        page.enterConfirmPassword(confirmPassword);
        page.clickRegisterButton();

    }

}
