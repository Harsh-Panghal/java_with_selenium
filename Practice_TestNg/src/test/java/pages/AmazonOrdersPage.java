package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

public class AmazonOrdersPage {
    WebDriver driver;
    WebDriverWait wait;
    JavascriptExecutor js;

    By ordersHeading = By.xpath("//h1[contains(text(), 'Your Orders')] | //h1[contains(text(), 'Orders')]");
    By cancelledTab = By.xpath("//a[contains(translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), 'cancelled')] | //a[contains(text(), 'Cancelled Orders')]");

    public AmazonOrdersPage(WebDriver driver, WebDriverWait wait, JavascriptExecutor js) {
        this.driver = driver;
        this.wait = wait;
        this.js = js;
    }

    public boolean navigateAndCheckOrdersHeading() throws InterruptedException {
        driver.navigate().to("https://www.amazon.in/your-orders/orders");
        Thread.sleep(3000);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(ordersHeading)).isDisplayed();
    }

    public boolean applyCancelledFilter() throws InterruptedException {
        List<WebElement> tabs = driver.findElements(cancelledTab);
        if (tabs.size() > 0) {
            WebElement tab = tabs.get(0);
            js.executeScript("arguments[0].scrollIntoView({block: 'center'});", tab);
            Thread.sleep(1000);
            tab.click();
            Thread.sleep(3000); 
            return true;
        }
        return false;
    }
}