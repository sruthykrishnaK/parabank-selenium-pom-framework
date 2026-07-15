package mavenproject.maven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Swaglabs {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\chromedriver-win64\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/v1/");

        String url = driver.getTitle();
        System.out.println("Title is: " + url);

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        WebElement filter = driver.findElement(By.className("product_sort_container"));
        Select select = new Select(filter);
        select.selectByValue("lohi");

        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        Thread.sleep(2000);

        driver.findElement(By.id("remove-sauce-labs-backpack")).click();
        Thread.sleep(2000);

        driver.findElement(By.className("shopping_cart_link")).click();
        Thread.sleep(2000);

        driver.findElement(By.id("checkout")).click();
        Thread.sleep(2000);

        driver.findElement(By.id("first-name")).sendKeys("Sruthy");
        driver.findElement(By.id("last-name")).sendKeys("K");
        driver.findElement(By.id("postal-code")).sendKeys("123456");
        Thread.sleep(2000);

        driver.findElement(By.id("continue")).click();
        Thread.sleep(2000);

        driver.findElement(By.id("finish")).click();
        Thread.sleep(2000);

        driver.findElement(By.id("back-to-products")).click();
        Thread.sleep(2000);

        driver.quit();
    }
}