package practice.testNg;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.time.Duration;

public class DataProviderCrossBrowser {
	
    @DataProvider(name = "browserList")
    public Object[][] getBrowserData() {
        return new Object[][] {
            {"chrome"},
            {"edge"},
            {"FireFox"}
        };
    }

    @Test(dataProvider = "browserList")
    public void verifyGoogleTitle(String browserName) throws InterruptedException {
        
        WebDriver driver = null;
        System.out.println("-> Starting test on: " + browserName);
        if (browserName.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        }
        else if (browserName.equalsIgnoreCase("firefox")) {
            driver = new EdgeDriver();
        }else {
        	System.out.println("invalid browser");
        }

        // Browser setup
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
        // Test Logic
        driver.get("https://www.google.com");
        System.out.println("✅ Title on " + browserName + " is: " + driver.getTitle());
        Thread.sleep(1000);
        driver.quit();
    }
}