package practice.testNg;

import java.io.FileInputStream;
import java.io.FileOutputStream; 
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

public class PracticeReadWriteFromExcel {
    
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
        FileInputStream file = new FileInputStream("D:\\java_with_selenium\\Practice_TestNg\\TestData\\searchDataForDemoWebShop.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        XSSFSheet sheet = workbook.getSheet("Sheet1");

        int rows = sheet.getPhysicalNumberOfRows();
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
        FileInputStream file = new FileInputStream("D:\\java_with_selenium\\Practice_TestNg\\TestData\\registrationDataForDemoWebShop.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        XSSFSheet sheet = workbook.getSheet("Sheet1");

        int rows = sheet.getPhysicalNumberOfRows();
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
        String testStatus = ""; 

        if (fname.isEmpty() || email.isEmpty()) {
            Assert.assertTrue(currentPageSource.contains("is required") || currentPageSource.contains("required"));
            System.out.println("Validation Passed - Empty Fields");
            testStatus = "PASS";
            
        } else if (!pass.equals(cpass)) {
            Assert.assertTrue(currentPageSource.contains("do not match"));
            System.out.println("Validation Passed - Password Mismatch");
            testStatus = "PASS";
            
        } else if (!email.contains("@") || !email.contains(".")) {
            Assert.assertTrue(currentPageSource.contains("Wrong email") || currentPageSource.contains("Invalid email"));
            System.out.println("Validation Passed - Invalid Email");
            testStatus = "PASS";
            
        } else {
            if (currentPageSource.contains("already exists")) {
                System.out.println("Email already registered");
                testStatus = "PASS";
            } else {
                Assert.assertTrue(currentPageSource.contains("Your registration completed"));
                System.out.println("Registration Successful");
                testStatus = "PASS";
            }
        }


        try {
            FileInputStream file = new FileInputStream("D:\\java_with_selenium\\Practice_TestNg\\TestData\\registrationDataForDemoWebShop.xlsx");
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet sheet = workbook.getSheet("Sheet1");

            int totalRows = sheet.getPhysicalNumberOfRows();
            
            for (int i = 1; i < totalRows; i++) {
                String excelEmail = sheet.getRow(i).getCell(2).toString();
                
                if (excelEmail.equals(email)) {
                    if (sheet.getRow(i).getCell(5) == null) {
                        sheet.getRow(i).createCell(5);
                    }
                    sheet.getRow(i).getCell(5).setCellValue(testStatus);
                }
            }

            file.close();
            
            FileOutputStream fos = new FileOutputStream("D:\\java_with_selenium\\Practice_TestNg\\TestData\\registrationDataForDemoWebShop.xlsx");
            workbook.write(fos);
            
            workbook.close();
            fos.close();
            
        } catch (Exception e) {
            System.out.println("Excel write karne me error aaya: " + e.getMessage());
        }
    }

    @AfterTest
    public void tearDownEnvironment() {
        if (driver != null) {
            driver.quit();
        }
    }
}