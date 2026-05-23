package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage {

    WebDriver driver;
    
    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }
    By btnAddToCart = By.id("button-cart");
    By msgSuccess = By.xpath("//div[contains(@class,'alert-success')]");
    
    public void clickAddToCart() {
        driver.findElement(btnAddToCart).click();
    }
    
    public String getSuccessMessage() {
        try {
            return driver.findElement(msgSuccess).getText();
        } catch (Exception e) {
            return (e.getMessage());
        }
    }
}