package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {    
    WebDriver driver;
    
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
    By myAccountMenu = By.xpath("//span[text()='My Account']");
    By registerLink = By.linkText("Register");
    By loginLink = By.linkText("Login");    
    By searchBox = By.name("search");
    By searchButton = By.xpath("//div[@id='search']//button");
    By logoutLink = By.linkText("Logout");
    By continueLogout = By.xpath("//a[text()='Continue']");
    
    public void clickMyAccount() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(myAccountMenu)).click();
    }
    
    public void clickRegister() {
        driver.findElement(registerLink).click();
    }
    
    public void clickLogin() {
        driver.findElement(loginLink).click();
    }
    
    public void enterSearchItem(String productName) {
        driver.findElement(searchBox).clear();
        driver.findElement(searchBox).sendKeys(productName);
    }
    
    public void clickSearch() {
        driver.findElement(searchButton).click();
    }
    public void clickLogout() {
        driver.findElement(myAccountMenu).click();
        driver.findElement(logoutLink).click();
        driver.findElement(continueLogout).click(); 
    }
}