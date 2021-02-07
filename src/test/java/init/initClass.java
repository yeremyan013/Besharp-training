package init;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class initClass {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.auto.am/");
        Thread.sleep(10000);

        //Choose Make
        driver.findElement(By.id("select2-filter-make-container")).click();
        driver.findElement(By.cssSelector("input[class='select2-search__field']")).sendKeys("BMW");
        driver.findElement(By.id("select2-filter-make-results")).click();
        Thread.sleep(2000);

        //Choose Model
        driver.findElement(By.id("select2-v-model-container")).click();
        driver.findElement(By.cssSelector("input[class='select2-search__field']")).sendKeys("X5");
        driver.findElement(By.id("select2-v-model-results")).click();
        Thread.sleep(2000);

        //Select Year
        driver.findElement(By.xpath("(//span[@class='select2-selection select2-selection--single'])[3]")).click();
        driver.findElement(By.cssSelector("input[class='select2-search__field']")).sendKeys("2007");
        driver.findElement(By.className("select2-results__options")).click();
        driver.findElement(By.xpath("(//span[@class='select2-selection select2-selection--single'])[4]")).click();
        driver.findElement(By.cssSelector("input[class='select2-search__field']")).sendKeys("2013");
        driver.findElement(By.className("select2-results__options")).click();

        //Choose Price
        driver.findElement(By.xpath("(//span[@class='select2-selection select2-selection--single'])[5]")).click();
        driver.findElement(By.cssSelector("input[class='select2-search__field']")).sendKeys("11000");
        driver.findElement(By.className("select2-results__options")).click();
        driver.findElement(By.xpath("(//span[@class='select2-selection select2-selection--single'])[6]")).click();
        driver.findElement(By.cssSelector("input[class='select2-search__field']")).sendKeys("15000");
        driver.findElement(By.className("select2-results__options")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("(//span[@class='lever'])[1]")).click();
        Thread.sleep(2000);

        driver.findElement(By.id("search-btn")).click();
        Thread.sleep(3000);

        String element = driver.findElement(By.id("research-btn")).getText();
        System.out.println(element);
    }
}
