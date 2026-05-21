package practice.webdriver;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PracticeAlerts {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();//represent whole browser
		driver.manage().window().maximize();
		
		driver.get("https://demoqa.com/alerts");// open a specific page
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));
		
		driver.findElement(By.id("alertButton")).click();
		Thread.sleep(2000);
		
		wait.until(ExpectedConditions.alertIsPresent());
		//simpleAlert
		Alert simpleAlert = driver.switchTo().alert();
		System.out.println(simpleAlert.getText());
		Thread.sleep(1000);
		simpleAlert.accept();
		
		//wait alert
		driver.findElement(By.id("timerAlertButton")).click();
//		Thread.sleep(2000);
		
		wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();
		
//		confirmation alert
		driver.findElement(By.id("confirmButton")).click();
		Thread.sleep(2000);
		
		wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();
		Thread.sleep(1000);
		
//		prompt alert
		driver.findElement(By.id("promtButton")).click();
		Thread.sleep(2000);
		
		wait.until(ExpectedConditions.alertIsPresent());
		Alert promptAlert = driver.switchTo().alert();
		promptAlert.sendKeys("Harsh Choudhary");
		Thread.sleep(2000);
		promptAlert.accept();
		
		Thread.sleep(4000);
		driver.close();
		
		
	}

}
