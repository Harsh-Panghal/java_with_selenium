package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.WaitUtils;

public class LoginPage {
    
    private WebDriver driver;

    // 1. Locators
    private By emailField = By.name("email");
    private By passwordField = By.name("password");
    private By loginButton = By.cssSelector("button[type='submit']");
    private By dashboardHeader = By.xpath("//h1[contains(text(), 'Dashboard')]");
    private By errorMessage = By.xpath("//div[contains(@class, 'alert-danger')]");
 // popup close karne ke liye
    private By understandButton = By.xpath("//button[contains(text(), 'I Understand')]");

    // 2. Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // 3. Page Actions using WaitUtils
    public void enterUsername(String username) {
        WebElement emailEle = WaitUtils.waitForVisible(driver, emailField, 20);
        emailEle.clear(); 
        
        if(username != null) {
            emailEle.sendKeys(username);
        }
    }

    public void enterPassword(String password) {
        WebElement passEle = WaitUtils.waitForVisible(driver, passwordField, 10);
        passEle.clear();
        
        if(password != null) {
            passEle.sendKeys(password);
        }
    }

    public void clickLogin() {
        WebElement btn = WaitUtils.waitForClickable(driver, loginButton, 10);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", btn);
    }

    public boolean isDashboardDisplayed() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(10));
            return wait.until(org.openqa.selenium.support.ui.ExpectedConditions.urlContains("dashboard"));
        } catch (Exception e) {
            System.out.println("Dashboard URL validation failed. Current URL: " + driver.getCurrentUrl());
            return false;
        }
    }
    
    public boolean isErrorMessageDisplayed() {
        try {
            return WaitUtils.waitForVisible(driver, errorMessage, 5).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    public void closeDemoPopupIfPresent() {
        try {
            WebElement btn = WaitUtils.waitForClickable(driver, understandButton, 4);
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", btn);
            System.out.println("Demo popup closed successfully!");
            Thread.sleep(1000);
        } catch (Exception e) {
            System.out.println("No demo popup appeared.");
        }
    }
}