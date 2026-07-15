package mavenproject.maven;



import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ParabankAutomation {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        driver.get("https://parabank.parasoft.com/parabank/index.htm");

        //REGISTER
        driver.findElement(By.linkText("Register")).click();

        driver.findElement(By.id("customer.firstName")).sendKeys("Sruthy");
        driver.findElement(By.id("customer.lastName")).sendKeys("K");
        driver.findElement(By.id("customer.address.street")).sendKeys("Test Street");
        driver.findElement(By.id("customer.address.city")).sendKeys("TestCity");
        driver.findElement(By.id("customer.address.state")).sendKeys("TestState");
        driver.findElement(By.id("customer.address.zipCode")).sendKeys("123456");
        driver.findElement(By.id("customer.phoneNumber")).sendKeys("9876543210");
        driver.findElement(By.id("customer.ssn")).sendKeys("111222333");

        String username = "user" + System.currentTimeMillis();  // unique username
        driver.findElement(By.id("customer.username")).sendKeys(username);
        driver.findElement(By.id("customer.password")).sendKeys("test123");
        driver.findElement(By.id("repeatedPassword")).sendKeys("test123");

        driver.findElement(By.xpath("//input[@value='Register']")).click();
        Thread.sleep(2000);
        System.out.println("Successfully Registered!");
        //LOGIN
        driver.findElement(By.linkText("Log Out")).click();
        driver.findElement(By.name("username")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys("test123");
        driver.findElement(By.xpath("//input[@value='Log In']")).click();
        Thread.sleep(2000);
        System.out.println("Login successful!");

        //OPEN NEW ACCOUNT
        driver.findElement(By.linkText("Open New Account")).click();
        WebElement type=driver.findElement(By.id("type"));
        Select s=new Select(type);
        s.selectByValue("1");
        WebElement deposit=driver.findElement(By.id("fromAccountId"));
        Select s1=new Select(deposit);
        s1.selectByIndex(0);
        driver.findElement(By.xpath("//*[@id=\"openAccountForm\"]/form/div/input")).click();
        Thread.sleep(2000);
        String newAccountMsg = driver.findElement(By.xpath("//div[@id='rightPanel']/div/div/p[1]")).getText();
        System.out.println("Open New Account Message: " + newAccountMsg);
        Thread.sleep(2000);

        //TRANSFER FUNDS
        driver.findElement(By.linkText("Transfer Funds")).click();
        driver.findElement(By.id("amount")).sendKeys("50");
        WebElement fromAccount = driver.findElement(By.id("fromAccountId"));
        Select sFrom = new Select(fromAccount);
        Thread.sleep(1000);
        sFrom.selectByIndex(0);
        WebElement toAccount = driver.findElement(By.id("toAccountId"));
        Select sTo = new Select(toAccount);
        Thread.sleep(1000);
        sTo.selectByIndex(0);
        driver.findElement(By.xpath("//*[@id=\"transferForm\"]/div[2]/input")).click();
        Thread.sleep(1000);
        String transferMsg = driver.findElement(By.xpath("//*[@id=\"showResult\"]/h1")).getText();
        System.out.println("Fund Transfer Message: " + transferMsg);
        Thread.sleep(2000);
      
        //BILL PAY
        driver.findElement(By.linkText("Bill Pay")).click();

        driver.findElement(By.name("payee.name")).sendKeys("Electricity Board");
        driver.findElement(By.name("payee.address.street")).sendKeys("Street 1");
        driver.findElement(By.name("payee.address.city")).sendKeys("CityX");
        driver.findElement(By.name("payee.address.state")).sendKeys("StateX");
        driver.findElement(By.name("payee.address.zipCode")).sendKeys("543210");
        driver.findElement(By.name("payee.phoneNumber")).sendKeys("9000000000");
        driver.findElement(By.name("payee.accountNumber")).sendKeys("12345");
        driver.findElement(By.name("verifyAccount")).sendKeys("12345");
        driver.findElement(By.name("amount")).sendKeys("100");
        driver.findElement(By.xpath("//*[@id=\"billpayForm\"]/form/table/tbody/tr[13]/td[2]/select")).sendKeys("12345");
       Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"billpayForm\"]/form/table/tbody/tr[14]/td[2]/input")).click();
        Thread.sleep(1000);
        String paymentMsg = driver.findElement(By.xpath("//*[@id=\"billpayResult\"]/h1")).getText();
        System.out.println("Bill Payment Message: " + paymentMsg);
        Thread.sleep(2000);

        //FIND TRANSACTIONS
        driver.findElement(By.linkText("Find Transactions")).click();
        Thread.sleep(2000);

        WebElement acc = driver.findElement(By.id("accountId"));
        Select select = new Select(acc);
        select.selectByIndex(0); 
        Thread.sleep(1000);
        driver.findElement(By.id("transactionId")).sendKeys("12345");
        Thread.sleep(1000);
        driver.findElement(By.id("transactionDate")).sendKeys("12-04-2024");
        Thread.sleep(1000);
        driver.findElement(By.id("fromDate")).sendKeys("01-01-2024");
        Thread.sleep(1000);
        driver.findElement(By.id("toDate")).sendKeys("12-12-2024");
        Thread.sleep(1000);
        driver.findElement(By.id("amount")).sendKeys("100");
        Thread.sleep(1000);
        driver.findElement(By.id("findByDate")).click();
      Thread.sleep(1000);
      
      
      //UPDATE CONTACT INFO
        driver.findElement(By.linkText("Update Contact Info")).click();

        driver.findElement(By.id("customer.address.street")).clear();
        driver.findElement(By.id("customer.address.street")).sendKeys("Updated Street");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"updateProfileForm\"]/form/table/tbody/tr[8]/td[2]/input")).click();
        Thread.sleep(1000);
        WebElement updateMsg = driver.findElement(By.xpath("//*[@id=\"updateProfileResult\"]/h1"));
        Thread.sleep(1000);
        String msg = updateMsg.getText();
        System.out.println("Update Contact Info Message: " + msg);
        Thread.sleep(2000);
        
        //REQUEST LOAN 
        driver.findElement(By.linkText("Request Loan")).click();
        driver.findElement(By.id("amount")).sendKeys("1000");
        driver.findElement(By.id("downPayment")).sendKeys("100");
        driver.findElement(By.xpath("//*[@id=\"fromAccountId\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"requestLoanForm\"]/form/table/tbody/tr[4]/td[2]/input")).click();
        Thread.sleep(1000); 
        String loanMsg = driver.findElement(By.xpath("//*[@id=\"requestLoanResult\"]/h1")).getText();
        System.out.println("Loan Request Message: " + loanMsg);
        Thread.sleep(2000);
       

        //LOGOUT
        driver.findElement(By.linkText("Log Out")).click();
        System.out.println("Successfully logged out!");
        driver.quit();
    }
}

