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
import pages.ProductPage;
import pages.SearchResultsPage;
import utilities.ExcelUtils;

public class SearchAndCartTest extends BaseClass {

	@DataProvider(name = "ProductData")
    public Object[][] getProductData() {
        return ExcelUtils.getExcelData("SearchData.xlsx", "Sheet1");
    }
   
	@Test(dataProvider = "ProductData")
    public void verifyProductSearchAndAddToCart(String productName) {
        try {
            System.out.println("Test Started: Search & Add to Cart for - " + productName);            
            HomePage hp = new HomePage(driver);
            
            driver.findElement(By.xpath("//a[text()='Qafox.com']")).click();
                       
            hp.enterSearchItem(productName); 
            hp.clickSearch();
            System.out.println("Searched for: " + productName);
            
            SearchResultsPage searchPage = new SearchResultsPage(driver);
            searchPage.clickProduct(productName); 
            System.out.println("Clicked on product: " + productName);
            
            ProductPage prodPage = new ProductPage(driver);
            prodPage.clickAddToCart();
            
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'alert-success')]")));
            
            String successMsg = prodPage.getSuccessMessage();
            System.out.println("Message on screen: " + successMsg);
            
            Assert.assertTrue(successMsg.contains("Success: You have added " + productName), "Add to cart failed!");
            
            System.out.println("Test Passed: " + productName + " successfully added to cart!");
            
        } catch (Exception e) {
            Assert.fail("Test crash ho gaya for " + productName + ": " + e.getMessage());
        }
    }
}