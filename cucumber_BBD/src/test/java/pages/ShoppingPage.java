package pages;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShoppingPage {

    WebDriver driver;

    public ShoppingPage(WebDriver driver) {
        this.driver = driver;
    }

    // Search Locators
    By txtSearchBox = By.name("search");
    By btnSearchIcon = By.xpath("//div[@id='search']//button");

    // Product Action Locators (First item from search results)
    By btnAddToCartFirst = By.xpath("(//span[text()='Add to Cart']/parent::button)[1]");
    By btnAddToWishlistFirst = By.xpath("(//button[@data-original-title='Add to Wish List'])[1]");

    // Common Alert Locators
    By alertSuccess = By.cssSelector("div.alert.alert-success");
    By alertDanger = By.cssSelector("div.alert.alert-danger");

    // Navigation & View Locators
    By lnkShoppingCart = By.linkText("Shopping Cart");
    By lnkWishlist = By.partialLinkText("Wish List");
    By lnkCheckout = By.linkText("Checkout");

    // Remove Item Locators
    By btnRemoveFromCart = By.xpath("//button[@data-original-title='Remove']");
    By btnRemoveFromWishlist = By.xpath("(//a[@data-original-title='Remove'])[1]");

    // Search Actions
    public void enterSearchProduct(String productName) {
        driver.findElement(txtSearchBox).clear();
        driver.findElement(txtSearchBox).sendKeys(productName);
    }

    public void clickSearchIcon() {
        driver.findElement(btnSearchIcon).click();
    }

    // Cart Actions
    public void clickAddToCartFirstProduct() {
        driver.findElement(btnAddToCartFirst).click();
    }

    public void clickShoppingCartLink() {
        driver.findElement(lnkShoppingCart).click();
    }

    public void clickRemoveFromCart() {
        driver.findElement(btnRemoveFromCart).click();
    }

    // Wishlist Actions
    public void clickAddToWishlistFirstProduct() {
        driver.findElement(btnAddToWishlistFirst).click();
    }

    public void clickWishlistLink() {
        driver.findElement(lnkWishlist).click();
    }

    public void clickRemoveFromWishlist() {
        driver.findElement(btnRemoveFromWishlist).click();
    }

    // Checkout Actions
    public void clickCheckoutLink() {
        driver.findElement(lnkCheckout).click();
    }

    // Alert Verification Helpers
    public boolean isSuccessBannerDisplayed() {
        return driver.findElement(alertSuccess).isDisplayed();
    }

    public String getSuccessBannerText() {
        return driver.findElement(alertSuccess).getText();
    }

    public boolean hasStockErrorBanner() {
        List<WebElement> stockErrorBanner = driver.findElements(alertDanger);
        return stockErrorBanner.size() > 0;
    }

    public String getStockErrorBannerText() {
        return driver.findElement(alertDanger).getText();
    }
}