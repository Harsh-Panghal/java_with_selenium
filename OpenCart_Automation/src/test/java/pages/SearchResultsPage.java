package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResultsPage {
    
    WebDriver driver;
    
    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
    }
    
    public void clickProduct(String productName) {
        driver.findElement(By.linkText(productName)).click();
    }
}