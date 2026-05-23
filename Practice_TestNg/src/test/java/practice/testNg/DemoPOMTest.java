package practice.testNg;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.RegisterPage;
import pages.SearchPage;

public class DemoPOMTest {
    
    WebDriver driver;
    JavascriptExecutor jsExecutor;
    
    @BeforeTest
    public void setupEnvironment() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(12));
        driver.manage().window().maximize();
        jsExecutor = (JavascriptExecutor) driver;
        driver.get("https://demowebshop.tricentis.com/");
    }
    
    @DataProvider(name = "ProductSearchData")
    public Object[][] provideSearchKeywords() throws Exception {
     FileInputStream file =new FileInputStream("D:\\java_with_selenium\\Practice_TestNg\\TestData\\searchDataForDemoWebShop.xlsx");

   	 XSSFWorkbook workbook =new XSSFWorkbook(file);

   	 XSSFSheet sheet =workbook.getSheet("Sheet1");

   	int rows = sheet.getPhysicalNumberOfRows();// total row
   	int cols = sheet.getRow(0).getLastCellNum();

   	 Object[][] data = new Object[rows - 1][cols];

   	for (int i = 1; i < rows; i++) {

   	for (int j = 0; j < cols; j++) {

   	 data[i - 1][j] = sheet.getRow(i).getCell(j).toString();
   	 }
   	 }

   	 workbook.close();

   	return data;
    }
    
    @DataProvider(name = "UserRegistrationData")
    public Object[][] provideRegistrationDetails() throws Exception {
    	FileInputStream file =new FileInputStream("D:\\java_with_selenium\\Practice_TestNg\\TestData\\registrationDataForDemoWebShop.xlsx");

      	 XSSFWorkbook workbook =new XSSFWorkbook(file);

      	 XSSFSheet sheet =workbook.getSheet("Sheet1");

      	int rows = sheet.getPhysicalNumberOfRows();// total row
      	int cols = sheet.getRow(0).getLastCellNum();

      	 Object[][] data = new Object[rows - 1][cols];

      	for (int i = 1; i < rows; i++) {

      	for (int j = 0; j < cols; j++) {

      	 data[i - 1][j] = sheet.getRow(i).getCell(j).toString();
      	 }
      	 }

      	 workbook.close();

      	return data;
    }
    
    @Test(priority = 1, dataProvider = "ProductSearchData")
    public void validateProductSearch(String searchKeyword) throws InterruptedException {
        SearchPage searchPage = new SearchPage(driver);
        
        searchPage.searchForProduct(searchKeyword);       
        Thread.sleep(1000); 
    }
    
    @Test(priority = 2, dataProvider = "UserRegistrationData")
    public void validateUserRegistration(String fname, String lname, String email, String pass, String cpass) throws InterruptedException {
        RegisterPage regPage = new RegisterPage(driver);
        
        regPage.clickLogoutIfLoggedIn();
        regPage.navigateToRegister();
        regPage.fillRegistrationForm(fname, lname, email, pass, cpass);
        regPage.submitRegistration();
        Thread.sleep(2000);
        
        String currentPageSource = driver.getPageSource();

        if (fname.isEmpty() || email.isEmpty()) {
            Assert.assertTrue(currentPageSource.contains("is required") || currentPageSource.contains("required"));
            System.out.println("Validation Passed - Empty Fields");
            
        } else if (!pass.equals(cpass)) {
            Assert.assertTrue(currentPageSource.contains("do not match"));
            System.out.println("Validation Passed - Password Mismatch");
            
        } else if (!email.contains("@") || !email.contains(".")) {
            Assert.assertTrue(currentPageSource.contains("Wrong email") || currentPageSource.contains("Invalid email"));
            System.out.println(" Validation Passed - Invalid Email");
            
        } else {
            if (currentPageSource.contains("already exists")) {
                System.out.println(" Email already registered");
            } else {
                Assert.assertTrue(currentPageSource.contains("Your registration completed"));
                System.out.println(" Registration Successful");
            }
        }
    }

    @AfterTest
    public void tearDownEnvironment() {
        if (driver != null) {
            driver.quit();
        }
    }
}
