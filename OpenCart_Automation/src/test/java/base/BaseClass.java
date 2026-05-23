package base;
import java.io.FileReader;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClass {
    public WebDriver driver;
    public Properties prop;
    
    @BeforeClass
    public void setup() {
        
        try {
            String configFilePath = System.getProperty("user.dir") + "//src//test//resources//config//config.properties";
            FileReader file = new FileReader(configFilePath);
            prop = new Properties();
            prop.load(file);
        } catch (Exception e) {
            System.out.println("Error: Config file not load" + e.getMessage());
        }
        
        String browserName = prop.getProperty("browser");
        
        if (browserName.equalsIgnoreCase("chrome")) {
            org.openqa.selenium.chrome.ChromeOptions options = new org.openqa.selenium.chrome.ChromeOptions();
            options.addArguments("--disable-blink-features=AutomationControlled");
            options.setExperimentalOption("excludeSwitches", java.util.Collections.singletonList("enable-automation"));
            options.setExperimentalOption("useAutomationExtension", false);
            
            driver = new ChromeDriver(options);
            
        } else if (browserName.equalsIgnoreCase("edge")) {
            org.openqa.selenium.edge.EdgeOptions options = new org.openqa.selenium.edge.EdgeOptions();
            options.addArguments("--disable-blink-features=AutomationControlled");
            options.setExperimentalOption("excludeSwitches", java.util.Collections.singletonList("enable-automation"));
            options.setExperimentalOption("useAutomationExtension", false);
            
            driver = new EdgeDriver(options);
        }else if (browserName.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        }else {
            System.out.println(" Warning: Defaulting to Chrome");
            driver = new ChromeDriver();
        }
        
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        
        driver.get(prop.getProperty("baseURL"));
        try {
            System.out.println(" Waiting for website verification...");
            Thread.sleep(2000); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}