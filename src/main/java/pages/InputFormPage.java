package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InputFormPage extends BasePage {

    @FindBy (name = "first_name")
    private WebElement firstName;

    public InputFormPage(WebDriver driver, String serverUrl) {
        super(driver, serverUrl, "/test/input-form-demo.html");
    }

    public void setFirstName(String text){
        firstName.sendKeys(text);
    }
}
