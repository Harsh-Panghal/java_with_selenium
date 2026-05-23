package practice.testNg;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginDDT {
    WebDriver driver;
    WebDriverWait wait;
    
    @BeforeTest
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @DataProvider(name = "LoginCredentials")
    public Object[][] getLoginData() throws Exception {
    	FileInputStream file =new FileInputStream("D:\\java_with_selenium\\Practice_TestNg\\TestData\\LoginData.xlsx");

    	 XSSFWorkbook workbook =new XSSFWorkbook(file);

    	 XSSFSheet sheet =workbook.getSheet("Sheet1");

    	int rows = sheet.getPhysicalNumberOfRows();// total row
    	int cols = sheet.getRow(0).getLastCellNum();// 0....4

    	 Object[][] data = new Object[rows - 1][cols];

    	for (int i = 1; i < rows; i++) {

    	for (int j = 0; j < cols; j++) {

    	 data[i - 1][j] = sheet.getRow(i).getCell(j).toString();
    	 }
    	 }

    	 workbook.close();

    	return data;
    }
    
    @Test(dataProvider = "LoginCredentials")
    public void testLogin(String email, String password) {
        driver.get("http://zero.webappsecurity.com/login.html");
        System.out.println("\nTrying Login With -> Email: " + email + " | Password: " + password);
        
        LoginPageZeroBankPOM loginPage = new LoginPageZeroBankPOM(driver);
        loginPage.login(email, password);
        
    }
    
    @AfterTest
    public void teardown() {
        if (driver != null) {
            driver.quit(); 
            System.out.println("All executions done. Browser closed.");
        }
    }
}