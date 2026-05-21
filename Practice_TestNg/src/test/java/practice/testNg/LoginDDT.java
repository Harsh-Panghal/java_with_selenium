package practice.testNg;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginDDT {
    WebDriver driver;
    WebDriverWait wait;
    
    @BeforeTest
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @DataProvider(name = "LoginCredentials")
    public Object[][] getLoginData() {
        return new Object[][] { 
            {"invalid", "password"},    
            {"username", ""},
            {"username", "12345678"},
            {"username", "12345678"},
            {"", "null"},
            {"null", ""},
            {"username", "password"}
        };
    }
    
    @Test(dataProvider = "LoginCredentials")
    public void testLogin(String email, String password) {
        driver.get("http://zero.webappsecurity.com/login.html");
        System.out.println("\nTrying Login With -> Email: " + email + " | Password: " + password);
        
        WebElement userField = driver.findElement(By.id("user_login"));
        userField.clear(); 
        userField.sendKeys(email);
        
        WebElement passField = driver.findElement(By.id("user_password"));
        passField.clear();
        passField.sendKeys(password);
        
        driver.findElement(By.name("submit")).click();
        
    }
    
    @AfterTest
    public void teardown() {
        if (driver != null) {
            driver.quit(); 
            System.out.println("All executions done. Browser closed.");
        }
    }
}