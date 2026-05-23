package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    
    // 2. Locators
    By txtEmailAddress = By.id("input-email");
    By txtPassword = By.id("input-password");
    By btnLogin = By.xpath("//input[@value='Login']");
    By msgMyAccountHeading = By.xpath("//h2[text()='My Account']");
    
    public void setEmail(String email) {
        driver.findElement(txtEmailAddress).sendKeys(email);
    }
    
    public void setPassword(String pwd) {
        driver.findElement(txtPassword).sendKeys(pwd);
    }
    
    public void clickLogin() {
        driver.findElement(btnLogin).click();
    }
    
    public boolean isMyAccountPageExists() {
        try {
            return driver.findElement(msgMyAccountHeading).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}