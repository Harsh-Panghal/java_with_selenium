package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage {

    WebDriver driver;
    WebDriverWait wait;
    
    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    
    By cartMenu = By.id("cart");
    By btnCheckoutMenu = By.xpath("//strong[normalize-space()='Checkout']");    
    By btnBillingContinue = By.id("button-payment-address");    
    By btnDeliveryContinue = By.id("button-shipping-address");    
    By btnDeliveryMethodContinue = By.id("button-shipping-method");
    By chkTerms = By.name("agree");
    By btnPaymentMethodContinue = By.id("button-payment-method");
    By btnConfirmOrder = By.id("button-confirm");
    By msgOrderSuccess = By.xpath("//div[@id='content']/h1");
    
    // 2. Actions
    public void navigateToCheckout() {
        driver.findElement(cartMenu).click();
        driver.findElement(btnCheckoutMenu).click();
    }
    
    public boolean processCheckoutSteps() {
        try {
            WebDriverWait shortWait = new WebDriverWait(driver, Duration.ofSeconds(3));
            shortWait.until(ExpectedConditions.elementToBeClickable(btnBillingContinue)).click();
            
            wait.until(ExpectedConditions.elementToBeClickable(btnDeliveryContinue)).click();
            wait.until(ExpectedConditions.elementToBeClickable(btnDeliveryMethodContinue)).click();
            wait.until(ExpectedConditions.elementToBeClickable(chkTerms)).click();
            wait.until(ExpectedConditions.elementToBeClickable(btnPaymentMethodContinue)).click();
            wait.until(ExpectedConditions.elementToBeClickable(btnConfirmOrder)).click();
            
            return true; 
            
        } catch (org.openqa.selenium.TimeoutException e) {
            System.out.println(" Warning: Checkout blocked. Likely due to 'Out of Stock' issue on the demo site.");
            return false; 
        }
    }
    
    public String getOrderConfirmationMessage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(msgOrderSuccess));
        return driver.findElement(msgOrderSuccess).getText();
    }
}