package hooks;

import java.util.Properties;
import org.openqa.selenium.WebDriver;
import base.DriverFactory;
import utilities.ConfigReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class ApplicationHooks {

    private DriverFactory driverFactory;
    private WebDriver driver;
    Properties prop;

    @Before(order = 0)
    public void getProperty() {
        prop = ConfigReader.init_prop();
    }

    @Before(order = 1)
    public void launchBrowser() {
        String browserName = prop.getProperty("browser");
        driverFactory = new DriverFactory();
        driver = driverFactory.init_driver(browserName);
    }

    @After(order = 0)
    public void quitBrowser() {
        if(driver != null) {
            driver.quit();
            DriverFactory.removeDriver(); 
        }
    }
    @AfterStep
    public void tearDown(Scenario scenario) {
        try {
            String screenshotName = scenario.getName().replaceAll(" ", "_") + "_" + System.currentTimeMillis();
            byte[] sourcePath = ((TakesScreenshot) driverFactory.getDriver()).getScreenshotAs(OutputType.BYTES);
            
            // PDF Requirement: Capture screenshots on Pass, Fail, and Skipped
            if (scenario.isFailed()) {
                System.out.println("Step Failed! Capturing Screenshot...");
                scenario.attach(sourcePath, "image/png", "FAILED: " + screenshotName);
            } else {
                // Agar pass hua toh bhi screenshot attach karo (Grasshopper adapter automatically handle kar lega)
                scenario.attach(sourcePath, "image/png", "PASSED/SKIPPED: " + screenshotName);
            }
        } catch (Exception e) {
            System.out.println("Screenshot capture failed: " + e.getMessage());
        }
    }
}