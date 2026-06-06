package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;

public class HomePage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By departureDropdown = By.name("fromPort");
    private By destinationDropdown = By.name("toPort");
    private By findFlightsBtn = By.xpath("//input[@value='Find Flights']");

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void searchFlight(String departure, String destination) {
        try {
            System.out.println("\n=======================================================");
            System.out.println("[STEP] Initiating Flight Search: " + departure + " -> " + destination);
            
            WebElement depElem = wait.until(ExpectedConditions.visibilityOfElementLocated(departureDropdown));
            new Select(depElem).selectByVisibleText(departure); 
            
            WebElement destElem = wait.until(ExpectedConditions.visibilityOfElementLocated(destinationDropdown));
            new Select(destElem).selectByVisibleText(destination);
            
            wait.until(ExpectedConditions.elementToBeClickable(findFlightsBtn)).click();
            System.out.println("[STEP] Clicked on 'Find Flights' button.");
        } catch (Exception e) {
            Assert.fail("Failed to search flights! Exception: " + e.getMessage());
        }
    }
}