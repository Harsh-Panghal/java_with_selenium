package practice.webdriver;
 
import java.time.Duration;
 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
 
public class PracticeCSSselector {
 
	public static void main(String[] args) throws InterruptedException {
		 WebDriver driver = new ChromeDriver();
	        driver.manage().window().maximize();
 
	        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
//	        driver.get("http://zero.webappsecurity.com/login.html");
//	        driver.findElement(By.linkText("Forgot your password ?")).click();
//	        driver.findElement(By.partialLinkText("Forgot your")).click();
	        //css selector1.id 2.class 3.attribute  4.multiple attribute  5.parent child
	        
	        driver.get("https://demoqa.com/automation-practice-form");
	        Thread.sleep(2000);
//	        // css by id==syntax==>(node[id="id value"])
//	        driver.findElement(By.cssSelector("input[id=\"firstName\"]")).click();
//	        driver.findElement(By.cssSelector("input[id=\"firstName\"]")).sendKeys("Neeva");
//	        //css by class=== syntax==>(node[class="class value"])
//	        driver.findElement(By.cssSelector("input[class=\" mr-sm-2 form-control\"]")).click();
//	        driver.findElement(By.cssSelector("input[class=\" mr-sm-2 form-control\"]")).sendKeys("Sharma");
//	        //css by attribute=== syntax==>(node[any unique attribute="attribute value"])
//	        driver.findElement(By.cssSelector("input[placeholder=\"name@example.com\"]")).click();
//	        driver.findElement(By.cssSelector("input[placeholder=\"name@example.com\"]")).sendKeys("abc@gmail.com");
//	        //css by multiple attribute=== syntax==>(node#other attribute value[attribute="attribute value"])
//	        driver.findElement(By.cssSelector("input#gender-radio-2[name=\"gender\"]")).click();
	        
	        // css by parent-child ==syntax==> (parentnode>childnode[childnode attribute="value"])
	        driver.findElement(By.cssSelector("input[id=\"dateOfBirthInput\"]")).click();
	        driver.findElement(By.cssSelector("select>option[value=\"2017\"]")).click();
	        driver.findElement(By.cssSelector("select>option[value=\"5\"]")).click();
	        driver.findElement(By.cssSelector("div[class=\"react-datepicker__day react-datepicker__day--020\"]")).click();
//	        class="react-datepicker__day react-datepicker__day--020 react-datepicker__day--selected"
	        
	}
 
}