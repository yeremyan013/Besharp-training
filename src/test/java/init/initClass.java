package init;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class initClass {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.sas.am/");
        String element = driver.findElement(By.className("item-menu_2")).getText();
        System.out.println(element);
        String hr = driver.findElement(By.className("item-menu_3")).getAttribute("href");
        System.out.println(hr);

    }
}
