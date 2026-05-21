package practice.webdriver;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PracticeWait {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();//represent whole browser
		driver.get("https://www.amazon.in/");// open a specific page
		driver.manage().window().maximize();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));//maximum expected wait
		
		WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("twotabsearchtextbox")));
		
//		Wait<WebDriver> wait01 = new FluentWait<WebDriver>(driver)
//        	    .withTimeout(Duration.ofSeconds(30))    // Max wait time
//        	    .pollingEvery(Duration.ofSeconds(5))   // Check every 5 seconds
//        	    .ignoring(NoSuchElementException.class); // Ignore this error during wait
// 
//        	WebElement element = wait.until(new Function<WebDriver, WebElement>() {
//        	    public WebElement apply(WebDriver driver) {
//        	        return driver.findElement(By.id("dynamicElement"));

	}

}
