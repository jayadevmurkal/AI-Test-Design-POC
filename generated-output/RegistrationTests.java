import org.testng.Assert;
import org.testng.annotations.Test;
import framework.BaseTest;
import pages.RegistrationPage;

public class RegistrationTests extends BaseTest {

    @Test
    public void registerWithValidEmail() {
        String email = "valid@example.com";
        String password = "Password123!";
        String confirmPassword = "Password123!";

        RegistrationPage page = new RegistrationPage(driver);

        page.enterEmailInput(email);
        page.enterPasswordInput(password);
        page.enterConfirmPasswordInput(confirmPassword);
        page.clickRegisterButton();

        Assert.assertEquals(
                page.getSuccessMessage(),
                "Registration Successful");

    }

}
