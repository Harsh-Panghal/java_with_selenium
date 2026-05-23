package practice.testNg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPageZeroBankPOM {
	WebDriver driver;
	//locators
	By userInput = By.id("user_login");
	By passInput = By.id("user_password");
	By submitBtn = By.name("submit");
	
	
	public LoginPageZeroBankPOM(WebDriver driver) {
		this.driver = driver;
	}
	
	public void login(String email, String pass) {
		driver.findElement(userInput).click();
		driver.findElement(userInput).sendKeys(email);
		driver.findElement(passInput).sendKeys(pass);
		driver.findElement(submitBtn).click();
		
	}

}
