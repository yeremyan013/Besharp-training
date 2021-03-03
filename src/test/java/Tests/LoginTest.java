package Tests;

import helpers.Waiters;
import org.testng.annotations.Test;
import pages.InputFormPage;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test
    public void getLoginPage() throws InterruptedException {
        LoginPage loginPage = new LoginPage(getDriver(), "https://www.sas.am/");
        loginPage.get();
        Waiters.waitForVisibilityOfElement(getDriver(), );
        loginPage.setClickOnLoginButton();
        Thread.sleep(2000);
        loginPage.setFillEmailInput("azateremyan@gmail.com");
        loginPage.setFillPasswordInput("a12345678");
        loginPage.setClickOnSubmitButton();
        Thread.sleep(5000);
    }
}
