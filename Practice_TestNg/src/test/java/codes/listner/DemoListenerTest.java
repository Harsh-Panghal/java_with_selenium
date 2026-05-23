package codes.listner;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DemoListenerTest {
    
    WebDriver driver;

    @BeforeTest
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }
    
    @Test(priority = 1)
    public void testGoogleTitle() {
        driver.get("https://www.google.com");
        String title = driver.getTitle();
        System.out.println("Page Title is: " + title);
        
        Assert.assertEquals(title, "Google", "Title not match"); 
    }

    @Test(priority = 2)
    public void testFailedLogin() {
        driver.get("https://demowebshop.tricentis.com/login");
        
        driver.findElement(By.id("Email")).sendKeys("wrong_user@gmail.com");
        driver.findElement(By.id("Password")).sendKeys("wrongpass");
        driver.findElement(By.xpath("//input[@value='Log in']")).click();
        
        Assert.assertTrue(driver.getCurrentUrl().contains("info"), "test case fail because currentURL not contain the 'info' ");
    }

    @AfterTest
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}