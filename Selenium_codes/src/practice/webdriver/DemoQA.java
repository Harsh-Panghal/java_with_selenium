package practice.webdriver;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

// xpath syntax -> //node[@attributeName = "attributeValue"]
public class DemoQA {

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriver driver = new ChromeDriver();//represent whole browser
		driver.get("https://demoqa.com/automation-practice-form\r\n"
				+ " ");// open a specific page
		driver.manage().window().maximize();//for full screen
		Thread.sleep(2000);
		
		WebElement firstName = driver.findElement(By.id("firstName"));//represent specific element
		WebElement lastName = driver.findElement(By.id("lastName"));		
		WebElement userEmail = driver.findElement(By.id("userEmail"));
		WebElement userNumber = driver.findElement(By.id("userNumber"));
		WebElement dateOfBirthInput = driver.findElement(By.id("dateOfBirthInput"));
		WebElement subjectContainer = driver.findElement(By.xpath("//*[@id=\"subjectsContainer\"]/div/div[1]/div[2]"));
		WebElement subjectsInput = driver.findElement(By.id("subjectsInput"));//we can directly with input field as well
		WebElement uploadPicture = driver.findElement(By.id("uploadPicture"));
		WebElement currentAddress = driver.findElement(By.id("currentAddress"));
		WebElement stateInput = driver.findElement(By.id("react-select-3-input"));
		WebElement cityInput = driver.findElement(By.id("react-select-4-input"));
		WebElement submitButton = driver.findElement(By.id("submit"));
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
//		text fields
		firstName.sendKeys("Harsh");
		Thread.sleep(1000);
		lastName.sendKeys("Choudhary");
		Thread.sleep(1000);
		userEmail.sendKeys("harsh.choudhary.glb@gmail.com");
		Thread.sleep(1000);
//		radio buttons
		driver.findElement(By.id("gender-radio-1")).click();
		
//		mobile number
		userNumber.sendKeys("7017750128");
		Thread.sleep(1000);
		
//		DOB
//		System.out.println(dateOfBirthInput.getText());
		dateOfBirthInput.click();
		
//		find yearDropDown
		WebElement yearDropdownElement = driver.findElement(By.className("react-datepicker__year-select"));
		Select yearSelect = new Select(yearDropdownElement);
		yearSelect.selectByVisibleText("2006");
		Thread.sleep(1000);
		
//		find monthDropDown		
		WebElement monthDropdownElement = driver.findElement(By.className("react-datepicker__month-select"));
		Select monthSelect = new Select(monthDropdownElement);
		monthSelect.selectByValue("5");
		Thread.sleep(1000);
		
//		select date
		driver.findElement(By.xpath("//*[@id=\"dateOfBirth\"]/div[2]/div[2]/div/div/div/div/div[2]/div[2]/div[1]/div[5]")).click();
		Thread.sleep(1000);
		
		js.executeScript("window.scrollBy(0, 900)");
		Thread.sleep(2000);
		
//		subject field
//		subjectContainer.click();
		subjectsInput.click();
		Thread.sleep(1000);
		subjectsInput.sendKeys("Math");
		subjectsInput.sendKeys(Keys.ENTER);	
		Thread.sleep(1000);
		subjectsInput.sendKeys("chemistry");
		subjectsInput.sendKeys(Keys.ENTER);	
		Thread.sleep(1000);
		subjectsInput.sendKeys("com");
		subjectsInput.sendKeys(Keys.ARROW_DOWN);	
		subjectsInput.sendKeys(Keys.ENTER);	
		Thread.sleep(1000);
		
		
//		hobbies field
		driver.findElement(By.id("hobbies-checkbox-3")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("hobbies-checkbox-1")).click();
		Thread.sleep(1000);
//		file upload field
		uploadPicture.sendKeys("D:\\Pictures\\Screenshots\\Screenshot 2026-05-16 115000.png");
		Thread.sleep(1000);
		
//		current address
		currentAddress.sendKeys("Hapur, U.P, 245101");
		Thread.sleep(1000);
		
//		state input
//		stateInput.click();
//		Thread.sleep(1000);
		stateInput.sendKeys("Uttar");
		stateInput.sendKeys(Keys.ENTER);
		
//		city input
//		cityInput.click();
//		Thread.sleep(1000);
		cityInput.sendKeys("Ag");
		cityInput.sendKeys(Keys.ENTER);	
		Thread.sleep(1000);
		
//		submit button
		submitButton.click();
		Thread.sleep(2000);
		
//		take screenshot
		TakesScreenshot screenShot = (TakesScreenshot) driver;
		File sc = screenShot.getScreenshotAs(OutputType.FILE);
		
		File destination = new File("DemoQAForm.png");
		FileHandler.copy(sc, destination);
//		close button
//		driver.findElement(By.id("closeLargeModal")).click();
		
		List<WebElement> items = driver.findElements(By.tagName("input"));
		for(WebElement item: items) {
			System.out.println(item.getAttribute("type"));
		}
		
		
		
		Thread.sleep(4000);
//		driver.close();

	}

}
