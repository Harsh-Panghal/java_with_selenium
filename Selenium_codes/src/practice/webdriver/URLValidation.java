package practice.webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class URLValidation {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();		
		driver.get("https://www.selenium.dev/");
		Thread.sleep(3000);
		String expectedUrl = "https://www.selenium.dev/downloads";        
        String actualUrl = driver.getCurrentUrl();//it's help to get the current page url.
        
        if(expectedUrl.equals(actualUrl)) {
        	System.out.println("URL validation pass");
        }else {
        	System.out.println("URL validation fail because actualURL = " + actualUrl + " but expectedURL = " +expectedUrl);
        }
        Thread.sleep(3000);
		driver.close();

	}

}
