package pages;

import helpers.Waiters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver, String serverUrl, String pagePath) {
        super(driver, serverUrl, pagePath);
    }

    @FindBy (css = "div.page-header__right > div:nth-child(2) > a > span")
    private WebElement myPage;

    public String getMyPageText(){
        Waiters.waitForVisibilityOfElement(getDriver(), myPage);
        return myPage.getText();
    }
}
