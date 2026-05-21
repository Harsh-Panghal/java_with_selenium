package practice.webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TiraBeautySearchButton {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();		
		driver.get("https://www.tirabeauty.com/");
		Thread.sleep(3000);
//		by id
		driver.findElement(By.id("search")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("search")).sendKeys("Face wash");
		driver.findElement(By.id("search")).sendKeys(Keys.ENTER);

	}

}
