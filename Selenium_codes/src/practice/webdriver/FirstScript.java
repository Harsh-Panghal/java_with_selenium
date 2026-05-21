package practice.webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;

public class FirstScript {

	public static void main(String[] args) throws InterruptedException {
		//steps: 1- paste url in the default browser.
//		         2. verify after click on logo this will redirect to home page.
		
//		setup browser
//		System.setProperty("webdriver.chrome.driver", "D:\\setup_file_sele\\chromedriver-win64\\chromedriver-win64");
		
		//create webdriver object
		WebDriver driver = new ChromeDriver();
		
		//navigate to url
		driver.get("https://www.selenium.dev/downloads/");
		Thread.sleep(3000);
		
		//find element
		driver.findElement(By.id("Layer_1")).click();
		Thread.sleep(3000);
		
		driver.close();
		

	}

}
