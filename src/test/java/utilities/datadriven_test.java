package utilities;


import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import utilities.ExcelUtils;
public class datadriven_test {

	
	    WebDriver driver;

	    @BeforeMethod
	    public void setUp() {
	        driver = new FirefoxDriver();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	        driver.get(" https://practicetestautomation.com/practice-test-login/"); // 👉 change this to your actual URL
	    }

	    @Test(dataProvider = "loginData")
	    public void loginTest(String username, String password) {
	    	driver.findElement(By.id("username")).sendKeys(username);
	    	driver.findElement(By.id("password")).sendKeys(password);
	    	driver.findElement(By.id("submit")).click();



	        System.out.println("✅ Logged in with: " + username + " / " + password);
	    }

	    @AfterMethod
	    public void tearDown() {
	        driver.quit();
	    }

	    @DataProvider(name = "loginData")
	    public Object[][] getData() {
	        return ExcelUtils.readExcel("testdata.xlsx", "Sheet1");
	    }
	}
