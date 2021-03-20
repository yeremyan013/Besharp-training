package Tests.tests;

import Tests.tests.BaseTest;
import helpers.ConfigHelper;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test
    public void getLoginPage() throws InterruptedException {
        String serverUrl = ConfigHelper.get("serverUrl");
        LoginPage loginPage = new LoginPage(getDriver(), serverUrl);
        loginPage.get();
        loginPage.setClickOnLoginButton();
        loginPage.setFillEmailInput("azateremyan@gmail.com");
        loginPage.setFillPasswordInput("a12345678");
        HomePage homePage = loginPage.setClickOnSubmitButton();
        String actualResult = homePage.getMyPageText();
        Assert.assertEquals(actualResult, "Անձնական էջ4");
    }
}
