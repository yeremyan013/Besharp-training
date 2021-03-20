package Tests.tests;

import Tests.tests.BaseTest;
import org.testng.annotations.Test;
import pages.InputFormPage;

public class SimpleTest extends BaseTest {
    @Test
    public void getInputFormPage() throws InterruptedException {
        InputFormPage inputFormPage = new InputFormPage(getDriver(), "https://www.seleniumeasy.com/");
        inputFormPage.get();
        Thread.sleep(5000);
        inputFormPage.setFirstName("Azat");
    }
}
