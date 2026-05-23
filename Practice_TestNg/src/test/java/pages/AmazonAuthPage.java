package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class AmazonAuthPage {
    WebDriver driver;
    WebDriverWait wait;

    // Locators
    By emailInput = By.id("ap_email_login");
    By continueBtn = By.xpath("//*[@id=\"intention-submit-button\"]/span/input");
    By nameInput = By.id("ap_customer_name");
    By phoneInput = By.id("ap_phone_number");
    By passInput = By.id("ap_password");
    By verifyBtn = By.id("continue");

    public AmazonAuthPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void navigateToRegistration() {
        driver.get("https://www.amazon.in/ap/signin?openid.return_to=https%3A%2F%2Fwww.amazon.in%2F%3Fref_%3Dnav_ya_signin&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=inflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0");
    }

    public void fillRegistrationInitial(String email) {
        WebElement emailField = driver.findElement(emailInput);
        emailField.sendKeys(email);
        emailField.sendKeys(Keys.ENTER);
        driver.findElement(continueBtn).click();
    }

    public void fillRegistrationDetails(String name, String phone, String pass) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(nameInput)).sendKeys(name);
        driver.findElement(phoneInput).sendKeys(phone);
        try {
            WebElement passwordField = driver.findElement(passInput);
            if (passwordField.isDisplayed()) {
                passwordField.sendKeys(pass);
            }
        } catch (Exception e) {}
        driver.findElement(verifyBtn).click();
    }

    public void navigateToLogin() {
        driver.get("https://www.amazon.in/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.in%2F%3Fref_%3Dnav_signin&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=inflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0");
    }

    public void doLogin(String email, String pass) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailInput)).sendKeys(email + Keys.ENTER);
        wait.until(ExpectedConditions.visibilityOfElementLocated(passInput)).sendKeys(pass + Keys.ENTER);
    }
}
