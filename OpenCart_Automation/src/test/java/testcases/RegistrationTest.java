package testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseClass; 
import pages.HomePage;
import pages.RegistrationPage;
import utilities.ExcelUtils; 

public class RegistrationTest extends BaseClass {  
	
	@DataProvider(name = "RegisterData")
    public Object[][] provideData() {
        return ExcelUtils.getExcelData("RegisterData.xlsx", "Sheet1");
    }
	@Test(dataProvider = "RegisterData")
    public void verifyAccountRegistration(String fname, String lname, String tel, String pwd) {
        
		try {
            System.out.println("Test Started for user: " + fname);
            
            HomePage hp = new HomePage(driver);
            hp.clickMyAccount();
            hp.clickRegister();
            
            RegistrationPage regPage = new RegistrationPage(driver);
            
            regPage.setFirstName(fname);
            regPage.setLastName(lname);
            String randomEmail = fname.toLowerCase() + System.currentTimeMillis() + "@gmail.com";
            regPage.setEmail(randomEmail);            
            regPage.setTelephone(tel);
            regPage.setPassword(pwd);
            regPage.setConfirmPassword(pwd);            
            regPage.setPrivacyPolicy();
            regPage.clickContinue();
            
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='content']/h1")));
            
            String confmsg = regPage.getConfirmationMessage();
            Assert.assertEquals(confmsg, "Your Account Has Been Created!", "Registration failed!");
            System.out.println("Test Passed for user: " + fname);
            hp.clickLogout(); 
            System.out.println("Logged out successfully, ready for next user.");
            
        } catch (Exception e) {
            Assert.fail("Test crash ho gaya: " + e.getMessage());
        }
    }
}