package mavenproject.maven;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
public class project2 {
public static void main(String[]args) throws InterruptedException { 
	
WebDriver driver=new ChromeDriver();
driver.get("https://www.google.com/");

Thread.sleep(2000);
driver.quit();
}
}
