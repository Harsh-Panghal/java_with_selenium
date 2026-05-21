package practice.testNg;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

public class FirstTestNG {
	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor script;
	
	
	  @BeforeTest
public void setup() {
		  driver = new ChromeDriver();
		  driver.manage().window().maximize();
		  
		  wait = new WebDriverWait(driver, Duration.ofSeconds(8));
		  driver.get("https://testautomationpractice.blogspot.com/");
		  script = (JavascriptExecutor)driver;
}
  @Test(priority = 2)
  public void unit1() throws InterruptedException {
	  	WebElement name = driver.findElement(By.id("name"));
		WebElement email = driver.findElement(By.id("email"));	
		WebElement phone = driver.findElement(By.id("phone"));
		
//		name field
		name.sendKeys("Harsh Choudhary");
		Thread.sleep(1000);
		
//		email field
		email.sendKeys("harsh.choudhary.glb@gmail.com");
		Thread.sleep(1000);
		
//		phone
		phone.sendKeys("7017750128");
		Thread.sleep(1000);
	  
  }
  
  @Test(priority = 1)
  public void unit2() throws InterruptedException {
	  WebElement address = driver.findElement(By.id("textarea"));
//	  	scroll page-up
		script.executeScript("window.scrollBy(0,900)");
		
//		address
		address.sendKeys("Hapur, U.P., 245101");
		Thread.sleep(1000);
		
//		gender
		driver.findElement(By.id("male")).click();
		Thread.sleep(1000);
		
//		days:
		driver.findElement(By.id("sunday")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("tuesday")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("thursday")).click();
		Thread.sleep(1000);
	  
}
  @Test(priority = 3)
  public void unit3() throws InterruptedException {
	  	script.executeScript("window.scrollBy(0,500)");
		
//		country
		WebElement countryDropdown = driver.findElement(By.id("country"));
		Select countrySelect = new Select(countryDropdown);
		
		countrySelect.selectByVisibleText("India");
		Thread.sleep(1000);
		
//		colors
		WebElement colourDropdown = driver.findElement(By.id("colors"));
		Select colorSelect = new Select(colourDropdown);
		
		colorSelect.selectByVisibleText("Green");
		Thread.sleep(1000);
		
//		animal
		WebElement animalDropdown = driver.findElement(By.id("animals"));
		Select animalSelect = new Select(animalDropdown);
		
		animalSelect.selectByVisibleText("Cat");
		Thread.sleep(1000);
	  
}

  @AfterTest
  public void afterTest() {
	  System.out.println("Successfully done!");
	  driver.quit();
  }

}
