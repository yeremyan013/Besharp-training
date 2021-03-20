package Tests.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;

public class BaseTest {
    private static final String SCREENSHOT_DIR = "target/screenshots";
    final private Logger LOGGER = LoggerFactory.getLogger(getClass());
    private WebDriver driver;

    @BeforeClass
    public void setupBase() {
        getDriver();
    }

    //@AfterClass
    //public void tearDown() {
        //quitDriver();
   //}

    private void quitDriver() {
        getDriver().quit();
    }

    @AfterMethod
    public void screenshotListener(ITestResult testResult) {
        String fullTestName = testResult.getClass().getName() + "." + testResult.getName();
        if (testResult.isSuccess()) {
            LOGGER.info("===== {} test has passed =====", fullTestName);
        } else {
            LOGGER.info("===== {} test has failed =====", fullTestName);
            File screenshotFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
            try {
                FileUtils.copyFile(screenshotFile, new File(SCREENSHOT_DIR + fullTestName + ".png"));
                LOGGER.info("===== Screenshot is added in /{} =====", SCREENSHOT_DIR);
            } catch (IOException e) {
                LOGGER.info(e.getMessage());
            }
        }
    }

    public WebDriver getDriver() {
        if (null == driver) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(new ChromeOptions().addArguments("--start-maximized"));
        }
        return driver;
    }
}
