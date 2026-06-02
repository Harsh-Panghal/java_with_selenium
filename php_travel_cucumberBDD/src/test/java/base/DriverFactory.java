package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver; 
import java.net.URL; 
import java.time.Duration;

public class DriverFactory {

    private static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

    public WebDriver init_driver(String browser) {
        System.out.println("Browser value is: " + browser);

        if (browser.equalsIgnoreCase("chrome")) {
            try {
                ChromeOptions options = new ChromeOptions();
                URL gridUrl = new URL("http://localhost:4444/wd/hub"); 
                
                // RemoteWebDriver se connection
                tlDriver.set(new RemoteWebDriver(gridUrl, options));
                System.out.println("Docker Selenium Grid Connected Successfully!");
                
            } catch (Exception e) {
                System.out.println("Grid connection failed: " + e.getMessage());
            }
            
        } else if (browser.equalsIgnoreCase("firefox")) {
            tlDriver.set(new FirefoxDriver());
        } else if (browser.equalsIgnoreCase("edge")) {
            tlDriver.set(new EdgeDriver());
        } else {
            System.out.println("Please pass the correct browser value: " + browser);
        }

        getDriver().manage().deleteAllCookies();
        getDriver().manage().window().maximize();
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        
        return getDriver();
    }

    public static synchronized WebDriver getDriver() {
        return tlDriver.get();
    }
    
    public static synchronized void removeDriver() {
        tlDriver.remove();
    }
}