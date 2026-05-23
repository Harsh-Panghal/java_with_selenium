package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AmazonProductPage {
    WebDriver driver;
    WebDriverWait wait;
    JavascriptExecutor js;

    // Locators
    By searchBox = By.id("twotabsearchtextbox");
    By searchBtn = By.id("nav-search-submit-button");
    By firstProductImg = By.xpath("(//div[@data-component-type='s-search-result']//img)[1]/ancestor::a");
    By addToCartBtn = By.id("add-to-cart-button");

    public AmazonProductPage(WebDriver driver, WebDriverWait wait, JavascriptExecutor js) {
        this.driver = driver;
        this.wait = wait;
        this.js = js;
    }

    public boolean isSearchButtonDisplayed() {
        return driver.findElement(searchBtn).isDisplayed();
    }

    public void searchItem(String item) {
        WebElement sBox = wait.until(ExpectedConditions.visibilityOfElementLocated(searchBox));
        sBox.clear();
        sBox.sendKeys(item);
        driver.findElement(searchBtn).click();
    }

    public void clickFirstProductAndSwitchWindow() throws InterruptedException {
        WebElement firstImg = wait.until(ExpectedConditions.elementToBeClickable(firstProductImg));
        js.executeScript("window.scrollBy(0,400)");
        Thread.sleep(1000);
        firstImg.click();

        String mainWindow = driver.getWindowHandle();
        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(mainWindow)) {
                driver.switchTo().window(handle);
                break;
            }
        }
    }

    public void addItemToCart() throws InterruptedException {
        js.executeScript("window.scrollBy(0,500)");
        Thread.sleep(1000);
        wait.until(ExpectedConditions.elementToBeClickable(addToCartBtn)).click();
    }
}