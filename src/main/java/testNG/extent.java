package testNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class extent {

    WebDriver driver;
    ExtentReports extent;
   ExtentTest  test;
    @SuppressWarnings("deprecation")
	ExtentHtmlReporter htmlReporter;

    @SuppressWarnings("deprecation")
	@BeforeSuite
    public void setupReport() {
        htmlReporter = new ExtentHtmlReporter("test-output/TestNG_Extent_Report.html");
        htmlReporter.config().setDocumentTitle("Ammu's Automation Report");
        htmlReporter.config().setReportName("Selenium + TestNG");
        htmlReporter.config().setTheme(Theme.DARK);

        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("Tester", "Ammu");
    }

    @BeforeMethod
    public void setupBrowser() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void googleSearchTest() {
        test = extent.createTest("Google Search Test");
        driver.get("https://www.google.com");

        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("Ammu TestNG Extent Reporting");
        searchBox.submit();

        test.pass("Search executed successfully.");
    }

    @AfterMethod
    public void tearDownBrowser() {
        driver.quit();
    }

    @AfterSuite
    public void flushReport() {
        extent.flush();
    }
}
	 


