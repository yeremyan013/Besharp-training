package pages;

import net.bytebuddy.asm.Advice;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
    @FindBy (className = "js-btn-open-modal")
    private WebElement clickOnLoginButton;

    @FindBy(name = "USER_LOGIN")
    private WebElement fillEmailInput;

    @FindBy(name = "USER_PASSWORD")
    private WebElement fillPasswordInput;

    @FindBy(css = ".small-form__action .btn")
    private  WebElement clickOnSubmitButton;

    public LoginPage(WebDriver driver, String serverUrl) {
        super(driver, serverUrl, "");
    }

    public void setClickOnLoginButton() {
        clickOnLoginButton.click();
    }

    public void setFillEmailInput(String emailInput) {
        fillEmailInput.sendKeys(emailInput);
    }

    public void setFillPasswordInput(String passwordInput) {
        fillPasswordInput.sendKeys(passwordInput);
    }

    public void setClickOnSubmitButton() {
        clickOnSubmitButton.click();
    }

}
