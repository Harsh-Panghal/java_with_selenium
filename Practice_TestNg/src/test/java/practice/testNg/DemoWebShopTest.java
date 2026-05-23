package practice.testNg;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DemoWebShopTest {
    
    WebDriver driver;
    JavascriptExecutor jsExecutor;

    @BeforeTest
    public void setupEnvironment() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        jsExecutor = (JavascriptExecutor) driver;
        driver.get("https://demowebshop.tricentis.com/");
    }
    
    @DataProvider(name = "ProductSearchData")
    public Object[][] provideSearchKeywords() {
        return new Object[][] {
            {"Skin Products"},
            {"HP"},
            {"Product under 100"},
            {"3.8 Star products"},
            {"+,.@$#%#"},
            {"Bluetooth"},
            {"Microoven"}
        };
    }
    
    @DataProvider(name = "UserRegistrationData")
    public Object[][] provideRegistrationDetails() {
        return new Object[][] {
            {"Sam", "Choudhary", "samhey654@gmail.com", "sam@123", "sam@123"},
            {"harry", "Wilson", "harry.com", "harry@123", "harry@123"},
            {"Rahul", "Sharma", "rahul@gmail.com", "Rahul@123", "Rahul123"},
            {"", "", "", "", ""}
        };
    }
    
    
    @Test(priority = 1, dataProvider = "ProductSearchData")
    public void validateProductSearch(String searchKeyword) throws InterruptedException {
        System.out.println("\n[INFO] Validating Search for: " + searchKeyword);
        
        WebElement searchInput = driver.findElement(By.id("small-searchterms"));
        
        searchInput.click();        
        searchInput.sendKeys(searchKeyword);
        searchInput.sendKeys(Keys.ENTER);
        
        jsExecutor.executeScript("window.scrollBy(0, 400)");
        Thread.sleep(1500); 
    }
    
    @Test(priority = 2, dataProvider = "UserRegistrationData")
    public void validateUserRegistration(String firstName, String lastName, String emailId, String password, String confirmPassword) throws InterruptedException {
        
        System.out.println("\n[INFO] Testing Registration for User: " + (firstName.isEmpty() ? "Empty User" : firstName));
        
        driver.get("https://demowebshop.tricentis.com/register");
        
        try {
            WebElement logoutLink = driver.findElement(By.linkText("Log out"));
            if (logoutLink.isDisplayed()) {
                logoutLink.click();
                driver.get("https://demowebshop.tricentis.com/register");
            }
        } catch (Exception ignored) {
            
        }

        driver.findElement(By.id("gender-male")).click();
        driver.findElement(By.id("FirstName")).sendKeys(firstName);
        driver.findElement(By.id("LastName")).sendKeys(lastName);
        driver.findElement(By.id("Email")).sendKeys(emailId);
        driver.findElement(By.id("Password")).sendKeys(password);
        driver.findElement(By.id("ConfirmPassword")).sendKeys(confirmPassword);

        // Submit form
        driver.findElement(By.id("register-button")).click();
        Thread.sleep(2000); 

        // --- VALIDATION LOGIC ---
        String currentPageSource = driver.getPageSource();

        if (firstName.isEmpty() || lastName.isEmpty() || emailId.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            Assert.assertTrue(currentPageSource.contains("is required") || currentPageSource.contains("required"), "Expected required error missing");
            System.out.println("  Caught Empty Fields Validation.");
            
        } else if (!password.equals(confirmPassword)) {
            Assert.assertTrue(currentPageSource.contains("do not match"), "Expected password mismatch error missing");
            System.out.println(" Caught Password Mismatch Validation.");
            
        } else if (!emailId.contains("@")) {
            Assert.assertTrue(currentPageSource.contains("Wrong email"), "Expected wrong email error missing");
            System.out.println(" Caught Invalid Email Format Validation.");
            
        } else {
            // Handling the valid scenario gracefully
            if (currentPageSource.contains("already exists")) {
                System.out.println("Email already registered (System behaved correctly).");
            } else {
                Assert.assertTrue(currentPageSource.contains("Your registration completed"), "Registration did not complete");
                System.out.println("New Registration Successful.");
            }
        }
    }

    // --- TEARDOWN ---
    @AfterTest
    public void tearDownEnvironment() {
        if (driver != null) {
            driver.quit();
            System.out.println("\n Test Execution Completed. Browser Terminated.");
        }
    }
}