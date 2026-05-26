package stepDefinitions;

import java.time.Duration;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks extends BaseClass {

    @Before
    public void setup() {
        System.out.println("Hook: Starting Browser Setup...");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() {
        System.out.println("Hook: Closing Browser...");
        if (driver != null) {
            driver.quit();
        }
    }
}