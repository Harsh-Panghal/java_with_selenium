package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;

public class ConfirmationPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By successHeading = By.xpath("//h1[contains(text(), 'Thank you for your purchase today!')]");
    private By bookingIdLocator = By.xpath("//td[text()='Id']/following-sibling::td");

    public ConfirmationPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void verifySuccess() {
        try {
            Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(successHeading)).isDisplayed(), "Confirmation text missing!");
            String bookingId = driver.findElement(bookingIdLocator).getText();
            System.out.println("[SUCCESS] BOOKING CONFIRMED!");
            System.out.println("[TICKET INFO] Confirmation ID is: " + bookingId);
            System.out.println("=======================================================\n");
        } catch (Exception e) {
            Assert.fail("Failed to verify booking confirmation: " + e.getMessage());
        }
    }
}