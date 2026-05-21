package practice.testNg;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

public class PracticeCrossWebBrowsering {
	 WebDriver driver;
	 WebDriverWait wait;
	 
	 @BeforeTest
	  public void beforeTest() {
	  }
  @Test
  public void chrome() {
	  driver = new ChromeDriver();
      driver.manage().window().maximize();
      wait = new WebDriverWait(driver, Duration.ofSeconds(10));
      driver.get("https://www.selenium.dev/");
  }
  @Test
  public void edge() {
	  driver = new EdgeDriver();
      driver.manage().window().maximize();
      wait = new WebDriverWait(driver, Duration.ofSeconds(10));
      driver.get("https://www.selenium.dev/");
  }
  @Test
  public void fireFox() {
	  driver = new FirefoxDriver();
      driver.manage().window().maximize();
      wait = new WebDriverWait(driver, Duration.ofSeconds(10));
      driver.get("https://www.selenium.dev/");
  }

  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}
