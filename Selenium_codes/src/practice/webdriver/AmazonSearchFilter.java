package practice.webdriver;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AmazonSearchFilter {

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriver driver = new ChromeDriver();//represent whole browser
		driver.get("https://www.amazon.in/ap/signin?openid.pape.max_auth_age=900&openid.return_to=https%3A%2F%2Fwww.amazon.in%2Fgp%2Fyourstore%2Fhome%3Fpath%3D%252Fgp%252Fyourstore%252Fhome%26useRedirectOnSuccess%3D1%26signIn%3D1%26action%3Dsign-out%26ref_%3Dnav_AccountFlyout_signout&openid.assoc_handle=inflex&openid.mode=checkid_setup&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0");// open a specific page
		driver.manage().window().maximize();//for full screen
		Thread.sleep(2000);
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));//maximum expected wait
		
		JavascriptExecutor script = (JavascriptExecutor)driver;
//		signIN
		WebElement email = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ap_email_login")));
		email.click();
		email.sendKeys("7017750128");
		email.sendKeys(Keys.ENTER);
		
//		password
		WebElement pass = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ap_password")));
		pass.click();
		pass.sendKeys("Harsh@210192");
		pass.sendKeys(Keys.ENTER);
		
//		search-laptop
		WebElement searchField = driver.findElement(By.id("twotabsearchtextbox"));
		searchField.click();
		searchField.sendKeys("Laptop");
		Thread.sleep(1000);
	
		WebElement searchbtn = driver.findElement(By.id("nav-search-submit-button"));
		searchbtn.click();
		Thread.sleep(1000);
	
		script.executeScript("window.scrollBy(0,400)");
		
		
		
//		filter by brand
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"p_123/308445\"]/span/a/span"))).click();
		
		script.executeScript("window.scrollBy(0,100)");
		Thread.sleep(1000);
		WebElement firstItemAddToCart = wait.until(ExpectedConditions.elementToBeClickable(
		    By.xpath("(//div[@data-component-type='s-search-result']//button[contains(text(),'Add to cart') or contains(text(),'Add to Cart')])[1]")
		));
		firstItemAddToCart.click();
		Thread.sleep(2000);
		
		WebElement cartBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("nav-cart")));
		cartBtn.click();
		Thread.sleep(2000);
		
		WebElement proceedToBuyBtn = wait.until(ExpectedConditions.elementToBeClickable(By.name("proceedToRetailCheckout")));
		proceedToBuyBtn.click();
		Thread.sleep(2000);
		
		TakesScreenshot screenShot04 = (TakesScreenshot) driver;
		File sc04 = screenShot04.getScreenshotAs(OutputType.FILE);
		
		File destination04 = new File("ss04.png");
		FileHandler.copy(sc04, destination04);
		

		Thread.sleep(4000);
		driver.close();

	}

}
