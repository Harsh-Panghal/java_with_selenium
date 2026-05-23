package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage {
    
    WebDriver driver;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }
    
    By txtFirstName = By.id("input-firstname");
    By txtLastName = By.id("input-lastname");
    By txtEmail = By.id("input-email");
    By txtTelephone = By.id("input-telephone");
    By txtPassword = By.id("input-password");
    By txtConfirmPassword = By.id("input-confirm");
    By chkdPolicy = By.name("agree");
    By btnContinue = By.xpath("//input[@value='Continue']");
    By msgConfirmation = By.xpath("//div[@id='content']/h1");
    
    public void setFirstName(String fname) {
        driver.findElement(txtFirstName).sendKeys(fname);
    }
    
    public void setLastName(String lname) {
        driver.findElement(txtLastName).sendKeys(lname);
    }
    
    public void setEmail(String email) {
        driver.findElement(txtEmail).sendKeys(email);
    }
    
    public void setTelephone(String tel) {
        driver.findElement(txtTelephone).sendKeys(tel);
    }
    
    public void setPassword(String pwd) {
        driver.findElement(txtPassword).sendKeys(pwd);
    }
    
    public void setConfirmPassword(String cpwd) {
        driver.findElement(txtConfirmPassword).sendKeys(cpwd);
    }
    
    public void setPrivacyPolicy() {
        driver.findElement(chkdPolicy).click();
    }
    
    public void clickContinue() {
        driver.findElement(btnContinue).click();
    }
    
    public String getConfirmationMessage() {
        try {
            return driver.findElement(msgConfirmation).getText();
        } catch (Exception e) {
            return (e.getMessage());
        }
    }
}