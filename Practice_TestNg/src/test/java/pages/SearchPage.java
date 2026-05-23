package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchPage {
    WebDriver driver;
    // 1. Locators
    By searchBox = By.id("small-searchterms");

    // 2. Constructor
    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }

    // 3. Actions
    public void searchForProduct(String item) {
        WebElement searchInput = driver.findElement(searchBox);
        searchInput.click();
        searchInput.sendKeys(item);
        searchInput.sendKeys(Keys.ENTER);
    }
}
