package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.WaitUtils;

public class RegistrationPage {

    private WebDriver driver;

    // 1. Popup Locator
    private By understandButton = By.xpath("//button[contains(text(), 'I Understand')]");

    // 2. Form Locators
    private By firstNameField = By.name("first_name");
    private By lastNameField = By.name("last_name");
    private By emailField = By.name("email"); 
    private By passwordField = By.name("password");
    private By confirmPasswordField = By.xpath("//input[@placeholder='Confirm Password']"); 

    // 3. Captcha, Checkbox & Button Locators
    private By captchaLabel = By.xpath("//label[contains(text(), 'Security Check')]");
    private By captchaInput = By.xpath("//input[@placeholder='Enter the answer']");
    private By termsCheckbox = By.xpath("//input[@type='checkbox']");
    private By signupButton = By.cssSelector("button[type='submit']");

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    // Popup Handler
    public void closeDemoPopupIfPresent() {
        try {
            WebElement btn = WaitUtils.waitForClickable(driver, understandButton, 3);
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", btn);
            System.out.println("Demo popup closed successfully!");
            Thread.sleep(1000);
        } catch (Exception e) {
            System.out.println("No demo popup appeared.");
        }
    }

    public void enterPersonalDetails(String fname, String lname) {
        WaitUtils.waitForVisible(driver, firstNameField, 10).sendKeys(fname);
        driver.findElement(lastNameField).sendKeys(lname);
    }

    public void enterAccountDetails(String email, String password) {
        // Checking if email field uses 'email' or 'user_email'
        try {
            driver.findElement(emailField).sendKeys(email);
        } catch (Exception e) {
            driver.findElement(By.name("user_email")).sendKeys(email);
        }
        
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(confirmPasswordField).sendKeys(password); // Entering confirm password
    }

    public void waitForManualCaptchaSolve() {
        System.out.println("Alert: Solve Captcha manually, u have 30 seconds...");
        try {
            WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(30));
            
            wait.until(d -> {
                String val = d.findElement(captchaInput).getAttribute("value");
                return val != null && !val.trim().isEmpty();
            });
            
            System.out.println("Captcha value detected! Proceeding to submit...");
            
            Thread.sleep(1000); 
        } catch (Exception e) {
            System.out.println("Manual Captcha entry timeout!");
        }
    }

    public void clickSignup() {
        WebElement checkbox = WaitUtils.waitForPresence(driver, termsCheckbox, 5);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", checkbox);
        
        WebElement btn = WaitUtils.waitForClickable(driver, signupButton, 5);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", btn);
    }
}