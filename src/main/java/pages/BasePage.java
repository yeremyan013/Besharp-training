package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.slf4j.LoggerFactory;
import org.testng.Assert;


import java.util.logging.Logger;

public abstract class BasePage<T extends LoadableComponent<T>> extends LoadableComponent<T> {
    private final String serverUrl;
    private WebDriver driver;
    private final String pagePath;

    protected BasePage(WebDriver driver, String serverUrl, String pagePath) {
        this.driver = driver;
        this.serverUrl = serverUrl;
        this.pagePath = pagePath;
        PageFactory.initElements(driver, this);
    }

    @Override
    protected void load() {
        driver.get(serverUrl + pagePath);
    }

    @Override
    protected void isLoaded() throws Error {
        Assert.assertTrue(isOnPage());
    }

    private boolean isOnPage() {
        return driver.getCurrentUrl().equals(serverUrl + pagePath);
    }

    public WebDriver getDriver() {
        return driver;
    }

    public String getServerUrl() {
        return serverUrl;
    }

    public String getPagePath() {
        return pagePath;
    }

}

