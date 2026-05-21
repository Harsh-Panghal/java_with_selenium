package practice.testNg;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class PracticeAssertions {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeTest
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://www.selenium.dev/");
    }

    @Test(priority = 1)
    public void titlevalidation() {
        SoftAssert soft = new SoftAssert();
        
        String expectedtitle = "Selenium dev";
        String actualtitle = driver.getTitle();
        soft.assertEquals(actualtitle, expectedtitle, "Title validation failed");
        
        String expectedurl = "https://www.selenium.dev/";
        String actualurl = driver.getCurrentUrl();
        soft.assertEquals(actualurl, expectedurl, "URL validation failed");
        
        soft.assertAll();
    }

    @AfterTest
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

