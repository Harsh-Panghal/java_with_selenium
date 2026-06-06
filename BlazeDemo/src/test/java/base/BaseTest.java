package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.ConfigReader;
import java.util.Properties;

public class BaseTest {
    
    public DriverFactory driverFactory;
    public WebDriver driver;
    public ConfigReader configReader;
    public Properties prop;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        configReader = new ConfigReader();
        prop = configReader.init_prop();
        
        String browserName = prop.getProperty("browser");
        driverFactory = new DriverFactory();
        driver = driverFactory.init_driver(browserName);
        
        // Launch the BlazeDemo URL
        driver.get(prop.getProperty("url"));
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            DriverFactory.removeDriver(); 
            System.out.println("Browser closed successfully.");
        }
    }
}