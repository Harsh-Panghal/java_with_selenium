package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

public class AmazonCheckoutPage {
    WebDriver driver;
    WebDriverWait wait;
    JavascriptExecutor js;

    By deleteBtn = By.xpath("//input[@value='Delete']");
    By proceedToBuyBtn = By.name("proceedToRetailCheckout");
    By passInput = By.id("ap_password");
    By changeAddressLink = By.xpath("//a[contains(translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), 'change')] | //a[@id='addressChangeLinkId']");
    By addressRadios = By.xpath("//div[contains(@id, 'select-destination')]//input[@type='radio']");
    By useThisAddressBtn = By.xpath("//input[contains(@id, 'checkout-primary-continue-button')] | //*[@id='checkout-primary-continue-button-id']//input");

    public AmazonCheckoutPage(WebDriver driver, WebDriverWait wait, JavascriptExecutor js) {
        this.driver = driver;
        this.wait = wait;
        this.js = js;
    }

    public void deleteItemFromCart() {
        driver.navigate().to("https://www.amazon.in/gp/cart/view.html");        
        wait.until(ExpectedConditions.elementToBeClickable(deleteBtn)).click();
    }

    public void processCheckoutAndChangeAddress(String password) throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(proceedToBuyBtn)).click();
        Thread.sleep(3000);
        
        try {
            WebElement pass = driver.findElement(passInput);
            if (pass.isDisplayed()) {
                pass.sendKeys(password + Keys.ENTER);
                Thread.sleep(4000);
            }
        } catch (Exception e) {}
        
        wait.until(ExpectedConditions.elementToBeClickable(changeAddressLink)).click();
        Thread.sleep(3000);
        
        List<WebElement> allAddressRadios = driver.findElements(addressRadios);
        if(allAddressRadios.size() >= 2) {
            WebElement secondAddressBtn = allAddressRadios.get(1);
            secondAddressBtn.findElement(By.xpath("./ancestor::label")).click();
            Thread.sleep(2000); 
        }

        WebElement useBtn = wait.until(ExpectedConditions.elementToBeClickable(useThisAddressBtn));
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", useBtn);
        Thread.sleep(1000);
        useBtn.click();
    }
}