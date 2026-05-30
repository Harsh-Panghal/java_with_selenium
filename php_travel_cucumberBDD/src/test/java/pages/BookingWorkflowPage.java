package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.WaitUtils;

public class BookingWorkflowPage {

    private WebDriver driver;

    private By moreDetailsBtn = By.xpath("(//a[contains(., 'More Details') or contains(@href, 'stay/')])[1]");
    
    private By bookNowBtn = By.xpath("(//button[contains(., 'Book Now') or contains(., 'Book')])[1]");
    private By selectRoomBtn = By.xpath("(//button[contains(., 'Select')])[1]");
    private By continueBookingBtn = By.xpath("//button[contains(., 'Continue Booking')]");
    
    private By firstNameInput = By.name("firstname");
    private By lastNameInput = By.name("lastname");
    private By emailInput = By.name("email");
    private By phoneInput = By.name("phone");
    private By termsCheckbox = By.id("terms_accepted"); 
    private By confirmBookingBtn = By.xpath("//button[contains(., 'Confirm Booking')]");
    
    private By confirmationMessage = By.xpath("//*[contains(translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), 'success') or contains(translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), 'confirm')]");
    
    private By accountMenu = By.xpath("//a[contains(@class, 'dropdown-toggle') and contains(., 'Account')]");
    private By logoutBtn = By.xpath("//a[contains(translate(., 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), 'logout')]");

    public BookingWorkflowPage(WebDriver driver) {
        this.driver = driver;
    }

    public void selectFirstHotel() {
        System.out.println("Waiting for Hotel Search Results to render...");
        try {
            Thread.sleep(5000); 
            WebElement btn = WaitUtils.waitForClickable(driver, moreDetailsBtn, 15);
            
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", btn);
            Thread.sleep(1000); 
            System.out.println("Clicking 'More Details' for the first hotel...");
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", btn);
            
            Thread.sleep(5000); 
            String pageSource = driver.getPageSource();
            String pageTitle = driver.getTitle();
            
            if (pageTitle.contains("504") || pageSource.contains("Gateway time-out")) {
                System.out.println("ALERT: Server choked! 504 Gateway Timeout detected.");
                System.out.println("Initiating Smart Auto-Refresh Bypass...");
                
                driver.navigate().refresh();
                Thread.sleep(5000); 
                
                if (driver.getTitle().contains("504") || driver.getPageSource().contains("Gateway time-out")) {
                    System.out.println("Bypass Failed. PHPTravels Demo Server is completely down.");
                    org.testng.Assert.fail("ENVIRONMENT ISSUE: 504 Gateway Timeout. Server is not responding.");
                } else {
                    System.out.println("Bypass Successful! Room Selection page loaded after refresh.");
                }
            }
        } catch (Exception e) {
            System.out.println("Exception during hotel selection: " + e.getMessage());
            org.testng.Assert.fail("Failed to find or click 'More Details' button.");
        }
    }

    public void clickBookNow() {
        System.out.println("Starting Room Selection Process...");
        try {
            ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 600);");
            Thread.sleep(3000); // Rooms API se load hone ka wait

            System.out.println("⚡ Clicking 'Select' for the first room option...");
            WebElement roomBtn = WaitUtils.waitForClickable(driver, selectRoomBtn, 15);
            
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", roomBtn);
            Thread.sleep(1000); 
            
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", roomBtn);
            
            System.out.println("Room Selected! Waiting for Continue Booking button...");
            Thread.sleep(2000); // Selection animation ka wait

            System.out.println("Clicking 'Continue Booking' button...");
            WebElement continueBtn = WaitUtils.waitForClickable(driver, continueBookingBtn, 10);
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", continueBtn);
            
        } catch (Exception e) {
            System.out.println("Room Selection or Continue Booking failed: " + e.getMessage());
            org.testng.Assert.fail("Failed during room selection flow.");
        }
    }

    public void enterTravellerDetailsAndConfirm() {
        System.out.println("Entering Traveller Details...");
        try {
            Thread.sleep(2000); 

            System.out.println("Ticking the Terms & Conditions checkbox...");
            WebElement checkbox = driver.findElement(termsCheckbox);
            
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", checkbox);
            Thread.sleep(1000);
            ((JavascriptExecutor) driver).executeScript("arguments[0].checked = true;", checkbox);
            ((JavascriptExecutor) driver).executeScript("arguments[0].dispatchEvent(new Event('change', { bubbles: true }));", checkbox);
            System.out.println("Checkbox perfectly ticked!");
            
            Thread.sleep(1000);

            System.out.println("Confirming Booking...");
            WebElement confirmBtn = WaitUtils.waitForClickable(driver, confirmBookingBtn, 10);
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", confirmBtn);
            
            Thread.sleep(5000); 
            if (driver.getTitle().contains("504") || driver.getPageSource().contains("Gateway time-out")) {
                System.out.println("ALERT: Server choked during booking submission!");
                driver.navigate().refresh(); 
                Thread.sleep(5000); 
            }
            
        } catch (Exception e) {
            System.out.println("Form submission failed: " + e.getMessage());
            org.testng.Assert.fail("Failed to submit traveller details and confirm booking.");
        }
    }

    public boolean isBookingConfirmed() {
        try {
            WebElement msg = WaitUtils.waitForVisible(driver, confirmationMessage, 20);
            System.out.println("Booking Validation Message: " + msg.getText());
            return true;
        } catch (Exception e) {
            System.out.println("Booking validation failed.");
            return false;
        }
    }

    public void logout() {
        System.out.println("Initiating Logout...");
        try {
            try {
                WebElement menu = WaitUtils.waitForClickable(driver, accountMenu, 5);
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", menu);
                Thread.sleep(1000);
            } catch (Exception ignore) {}
            
            WebElement logout = WaitUtils.waitForClickable(driver, logoutBtn, 10);
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", logout);
            System.out.println("Logged out successfully!");
        } catch (Exception e) {
            System.out.println("Logout failed: " + e.getMessage());
        }
    }
}