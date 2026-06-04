package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.time.Duration;

public class DriverFactory {

    private static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

    public WebDriver init_driver(String browser) {
        System.out.println("Browser value is: " + browser);

        if (browser.equalsIgnoreCase("chrome")) {
            System.out.println("🚀 Running in Headless Mode (Docker Safe)!");
            ChromeOptions options = new ChromeOptions();
            
            options.addArguments("--headless=new"); 
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            
            tlDriver.set(new ChromeDriver(options));
            
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