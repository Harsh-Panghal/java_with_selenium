package practice.webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TextField {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();		
		driver.get("https://www.selenium.dev/downloads/");
		Thread.sleep(3000);
		String expectedTitle = "Selenium Download";
		String actualTitle = driver.getTitle();//it helps to get current page title
		
		if(expectedTitle.equals(actualTitle)) {
			System.out.println("Title validation pass");
		}else {
			System.out.println("Title validation fail because Actual title = "+actualTitle + "but Expected Title = " + expectedTitle);
		}
		
		Thread.sleep(3000);
		driver.close();

	}

}
