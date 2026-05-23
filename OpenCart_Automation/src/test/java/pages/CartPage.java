package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
    
    WebDriver driver;
    
    public CartPage(WebDriver driver) {
        this.driver = driver;
    }
    
    // 1. Locators
    By lnkShoppingCart = By.xpath("//a[@title='Shopping Cart']"); // Top header mein shopping cart ka link
    By btnRemove = By.xpath("//button[@data-original-title='Remove']"); // Lal rang (Red) ka delete button
    By msgEmptyCart = By.xpath("//div[@id='content']/p[contains(text(),'Your shopping cart is empty!')]");
    
    // 2. Actions
    public void goToCartPage() {
        driver.findElement(lnkShoppingCart).click();
    }
    
    public void clickRemoveProduct() {
        driver.findElement(btnRemove).click();
    }
    
    public boolean isCartEmptyMessageDisplayed() {
        try {
            return driver.findElement(msgEmptyCart).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}