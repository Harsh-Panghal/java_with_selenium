package practice.webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SearchButton {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();		
		driver.get("https://www.google.com/");
		Thread.sleep(3000);
//		by id
//		driver.findElement(By.id("APjFqb")).click();
//		driver.findElement(By.id("APjFqb")).sendKeys("csk vs srh");
//		driver.findElement(By.id("APjFqb")).sendKeys(Keys.ENTER);
		
//		by Name
		driver.findElement(By.name("q")).click();
		driver.findElement(By.name("q")).sendKeys("csk vs srh");
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		

	}

}
