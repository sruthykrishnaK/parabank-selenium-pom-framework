package mavenproject.maven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import org.openqa.selenium.WebElement;

public class Swaglabs_login {
		public static void main(String[]args) throws InterruptedException {
		
			WebDriver driver=new ChromeDriver();
			driver.get("https://www.saucedemo.com/v1/");
			String url= driver.getTitle();
			System.out.println("Title is "+url);
			driver.findElement(By.id("user-name")).sendKeys("standard_user");
			driver.findElement(By.id("password")).sendKeys("secret_sauce");
			driver.findElement(By.id("login-button")).click();
		driver.manage().window().maximize();
		
		
		// Locate the filter dropdown
	        WebElement filterDropdown = driver.findElement(By.className("product_sort_container"));
	        
	        // Use Select class to choose sorting option
	        Select select = new Select(filterDropdown);
	        
	        // Filter options (you can use any one below):
	        // select.selectByVisibleText("Name (A to Z)");
	        // select.selectByVisibleText("Name (Z to A)");
	        // select.selectByVisibleText("Price (low to high)");
	        select.selectByVisibleText("Price (high to low)");
	        
	        // Optional: Verify the filter worked
	        System.out.println("Filter applied successfully!");
	        
			
	     //Click "Add to cart" for Sauce Labs Backpack
	        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
	        System.out.println("Clicked 'Add to Cart' successfully!");

	        //Wait briefly to ensure cart icon updates
	        Thread.sleep(2000); // Add this only for testing (not recommended for real automation)

	        //Check if cart icon updated
	        WebElement cartBadge = driver.findElement(By.className("shopping_cart_badge"));
	        String cartCount = cartBadge.getText();
	        System.out.println("Items in cart: " + cartCount);

			
			driver.quit();
		}
		}




