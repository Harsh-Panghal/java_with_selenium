package practice.webdriver;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DemoQA01 {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();//represent whole browser
		driver.manage().window().maximize();//for full screen
		driver.get("https://testautomationpractice.blogspot.com/");// open a specific page
		
		Thread.sleep(2000);
		
		JavascriptExecutor script = (JavascriptExecutor)driver;
		
		WebElement name = driver.findElement(By.id("name"));//represent specific element
		WebElement email = driver.findElement(By.id("email"));	
		WebElement phone = driver.findElement(By.id("phone"));
		WebElement address = driver.findElement(By.id("textarea"));
		WebElement datePicker1 = driver.findElement(By.id("datepicker"));
		WebElement datePicker2 = driver.findElement(By.xpath("//*[@id=\"txtDate\"]"));
		WebElement startDate = driver.findElement(By.id("start-date"));
		WebElement endDate = driver.findElement(By.id("end-date"));
		WebElement dateSubmitbtn = driver.findElement(By.xpath("//*[@id=\"post-body-1307673142697428135\"]/div[8]/button"));
		WebElement singleFileInput = driver.findElement(By.id("singleFileInput"));
		WebElement multipleFilesInput = driver.findElement(By.id("multipleFilesInput"));
		
		
		
//		name field
		name.sendKeys("Harsh Choudhary");
		Thread.sleep(1000);
		
//		email field
		email.sendKeys("harsh.choudhary.glb@gmail.com");
		Thread.sleep(1000);
		
//		phone
		phone.sendKeys("7017750128");
		Thread.sleep(1000);
		
//		scroll page-up
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
		
//		Date Picker 1 (mm/dd/yyyy):
		datePicker1.sendKeys("06/01/2025");
		Thread.sleep(1000);
		
//		Date Picker 2 (dd/mm/yyyy) :
		datePicker2.click();
 
		WebElement yearDropdown = driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/div/select[2]"));
		Select yearSelect = new Select(yearDropdown);		
		yearSelect.selectByVisibleText("2025");
		Thread.sleep(1000);
		
		WebElement monthDropdown = driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/div/select[1]"));
		Select monthSelect = new Select(monthDropdown);		
		monthSelect.selectByVisibleText("May");
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[2]/td[4]/a")).click();
		Thread.sleep(1000);
		
		
//		start date
		startDate.sendKeys("16-05-2025");
		Thread.sleep(1000);
		
//		end date
		endDate.sendKeys("16-05-2026");
		Thread.sleep(1000);
		
//		submit date
		dateSubmitbtn.click();
		
//		scroll up
		script.executeScript("window.scrollBy(0,500)");
		
//		single file
		singleFileInput.sendKeys("D:\\Pictures\\20250519_OHR.HoneyBeeLavender_EN-GB1571293701_UHD_bing.jpg");
		Thread.sleep(1000);
		
//		multiple files
		multipleFilesInput.sendKeys("D:\\Pictures\\20250519_OHR.HoneyBeeLavender_EN-GB1571293701_UHD_bing.jpg" + "\n" + "D:\\Pictures\\20250603_OHR.CalaLuna_EN-GB1693826190_UHD_bing.jpg");
		Thread.sleep(1000);
		
		script.executeScript("window.scrollBy(0,-500)");
		Thread.sleep(2000);
		
//		alerts
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));
		
//		simple
		driver.findElement(By.id("alertBtn")).click();
		Thread.sleep(1000);
		
		wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();
		Thread.sleep(1000);
		
//		confirmation
		driver.findElement(By.id("confirmBtn")).click();
		Thread.sleep(1000);
		
		wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();
		Thread.sleep(1000);
		
//		prompt
		driver.findElement(By.id("promptBtn")).click();
		Thread.sleep(1000);
		
		wait.until(ExpectedConditions.alertIsPresent());
		Alert promptAlert = driver.switchTo().alert();
		promptAlert.sendKeys("Harsh");
		Thread.sleep(1000);
		promptAlert.accept();
		Thread.sleep(1000);
		
//		new tab
		String mainWindowHandle = driver.getWindowHandle();
		WebElement newTabBtn = driver.findElement(By.xpath("//button[normalize-space()='New Tab']")); 
		newTabBtn.click();
		Thread.sleep(2000);

		Set<String> allHandles = driver.getWindowHandles();

		for (String handle : allHandles) {
		    if (!handle.equals(mainWindowHandle)) {
		        driver.switchTo().window(handle);
		        System.out.println("Switched to New Tab! URL: " + driver.getCurrentUrl());
		        Thread.sleep(2000);
		        
		        driver.close();
		        System.out.println("New Tab Closed!");
		        break;
		    }
		}

		driver.switchTo().window(mainWindowHandle);
		Thread.sleep(1000);
		
//		popup
		WebElement popupBtn = driver.findElement(By.xpath("//*[@id=\"PopUp\"]"));
		popupBtn.click();
		Thread.sleep(2000);
		
		allHandles = driver.getWindowHandles();

		for (String handle : allHandles) {
		    if (!handle.equals(mainWindowHandle)) {
		        driver.switchTo().window(handle);
		        System.out.println("Switched to Popup Window! Title: " + driver.getTitle());
		        driver.manage().window().maximize();
		        Thread.sleep(2000);
	
		        driver.close();
		        System.out.println("Popup Window Closed!");
		        break;
		    }
		}
		
		driver.switchTo().window(mainWindowHandle);
		System.out.println("Back to Main Window.");
		
		script.executeScript("window.scrollBy(0,400)");
		Thread.sleep(2000);
		
//		Action buttons
		Actions action = new Actions(driver);
		WebElement pointMe = driver.findElement(By.cssSelector(".dropdown>.dropbtn"));
		
		action.moveToElement(pointMe).perform();
		Thread.sleep(1000);
		
		WebElement copyText = driver.findElement(By.xpath("//*[@id=\"HTML10\"]/div[1]/button"));		
		action.doubleClick(copyText).perform();
		
		script.executeScript("window.scrollBy(0,500)");
		Thread.sleep(2000);
		
		WebElement sourceBox = driver.findElement(By.id("draggable"));
		WebElement targetBox = driver.findElement(By.id("droppable"));	
		action.dragAndDrop(sourceBox, targetBox).perform();
		Thread.sleep(2000);
		
		WebElement sliderLeft = driver.findElement(By.xpath("//*[@id=\"slider-range\"]/span[1]"));		
		action.dragAndDropBy(sliderLeft, 30, 0).perform();
		
		WebElement sliderRight = driver.findElement(By.xpath("//*[@id=\"slider-range\"]/span[2]"));		
		action.dragAndDropBy(sliderRight, -20, 0).perform();		

		script.executeScript("window.scrollBy(0,400)");
		Thread.sleep(2000);
		
		driver.findElement(By.id("comboBox")).click();
		Thread.sleep(1000);

		WebElement targetItem = driver.findElement(By.xpath("//div[text()='Item 5']"));
		targetItem.click();		
		
		
		
		Thread.sleep(4000);
		driver.quit();

	}

}
