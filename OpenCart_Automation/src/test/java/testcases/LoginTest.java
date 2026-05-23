package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.HomePage;
import pages.LoginPage;

public class LoginTest extends BaseClass {
    
    @Test
    public void verifyLogin() {
        
        try {
            System.out.println("Test Started: Validating Login");
            HomePage hp = new HomePage(driver);
            hp.clickMyAccount();
            hp.clickLogin();
            
            System.out.println("Navigated to Login Page");
            LoginPage lp = new LoginPage(driver);
            
            lp.setEmail(prop.getProperty("email")); 
            lp.setPassword(prop.getProperty("password"));
            
            lp.clickLogin();
            System.out.println("Login details submitted");
            
            boolean targetPage = lp.isMyAccountPageExists();
            
            Assert.assertTrue(targetPage, "Login failed! Invalid credentials ya page load nahi hua.");
            System.out.println("Test Passed: Successfully Logged In!");
            Thread.sleep(1000);
            hp.clickLogout();
            
        } catch (Exception e) {
            Assert.fail("Test crash ho gaya: " + e.getMessage());
        }
    }
}