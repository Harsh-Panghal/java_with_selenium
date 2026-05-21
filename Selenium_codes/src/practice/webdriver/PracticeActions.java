package practice.webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class PracticeActions {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
//		driver.get("https://demoqa.com/buttons");
//		driver.get("https://demoqa.com/droppable");
		driver.get("https://demoqa.com/slider");
		Thread.sleep(2000);
		
		Actions action = new Actions(driver);
		
//		WebElement doubleClick = driver.findElement(By.id("doubleClickBtn"));
//		action.doubleClick(doubleClick).perform();
//		Thread.sleep(1000);
//		
//		WebElement rightClick = driver.findElement(By.id("rightClickBtn"));
//		action.contextClick(rightClick).perform();
//		Thread.sleep(1000);
//		
//		WebElement hover = driver.findElement(By.xpath("(//button[@class=\"btn btn-primary\"])[3]"));
//		action.moveToElement(hover).click().perform();
		
//		drag and drop
//		WebElement sourceBox = driver.findElement(By.id("draggable"));
//		WebElement targetBox = driver.findElement(By.id("droppable"));
//		
//		action.dragAndDrop(sourceBox, targetBox).perform();
		
//		slider
		WebElement slider = driver.findElement(By.id("slider"));
		
		action.dragAndDropBy(slider, 50, 0).perform();
		
		
		
		Thread.sleep(4000);
		driver.quit();

	}

}
