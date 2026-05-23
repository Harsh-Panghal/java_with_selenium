package tests;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.time.Duration;

import pages.AmazonAuthPage;
import pages.AmazonProductPage;
import pages.AmazonCheckoutPage;
import pages.AmazonOrdersPage;

public class AmazonPOMTest {
    
    WebDriver driver;
    WebDriverWait wait;
    JavascriptExecutor js;
    AmazonAuthPage authPage;
    AmazonProductPage productPage;
    AmazonCheckoutPage checkoutPage;
    AmazonOrdersPage ordersPage;

    @BeforeTest(alwaysRun = true) 
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));        
        js = (JavascriptExecutor) driver;
        driver.get("https://www.amazon.in/");
        
        authPage = new AmazonAuthPage(driver, wait);
        productPage = new AmazonProductPage(driver, wait, js);
        checkoutPage = new AmazonCheckoutPage(driver, wait, js);
        ordersPage = new AmazonOrdersPage(driver, wait, js);
    }

    @Test(priority = 1, groups = {"regression"})
    public void registration() throws InterruptedException {
        System.out.println("\n-> Test 1: Registration");
        authPage.navigateToRegistration();
        authPage.fillRegistrationInitial("harsh.choudhary.socialmedia@gmail.com");
        authPage.fillRegistrationDetails("Harsh", "8077166493", "Harsh@123");
        Thread.sleep(5000); 
    }

    @Test(priority = 2, groups = {"smoke", "regression"})
    public void login() throws InterruptedException {
        System.out.println("\nRunning Test 2: Login");
        authPage.navigateToLogin();
        authPage.doLogin("7017750128", "Harsh@210192");
        System.out.println("Login credentials entered.");
        Thread.sleep(10000);
    }
    
    @DataProvider(name = "AmazonSearchData")
    public Object[][] getSearchItems() {
        return new Object[][] {
            {"Oneplus"},           
            {"4 star mobiles"},  
            {"Shoes under 1000"}, 
            {"578589534534"},     
            {"!@#$%^&*()_+"},  
            {"FaceWash"}        
        };
    }

    @Test(priority = 3, dataProvider = "AmazonSearchData", groups = {"smoke", "regression"})
    public void validateSearch(String searchInput) throws InterruptedException {
        System.out.println("\n-> Test 3: Search Validation for: '" + searchInput + "'");
        
        Assert.assertTrue(productPage.isSearchButtonDisplayed(), "Search button not clickable");
        productPage.searchItem(searchInput);
        Thread.sleep(3000);
        
        Assert.assertTrue(driver.getTitle().toLowerCase().contains(searchInput.toLowerCase()), "Search failed for: " + searchInput);
        System.out.println("Search successfully validated.");
    }

    @Test(priority = 4, groups = {"regression"})
    public void productDetail() throws InterruptedException {
        System.out.println("\nTest 4: Product Detail");
        productPage.clickFirstProductAndSwitchWindow();
        Thread.sleep(3000);
        System.out.println(" Product Detail Page opened.");
    }

    @Test(priority = 5, groups = {"regression"})
    public void addToCart() throws InterruptedException {
        System.out.println("\nTest 5: Add To Cart");
        productPage.addItemToCart();
        Thread.sleep(3000);
        System.out.println(" Item added to cart.");
    }

    @Test(priority = 6, dependsOnMethods = {"addToCart"}, groups = {"regression"})
    public void deleteCartItem() throws InterruptedException {
        System.out.println("\nTest 6: Delete Cart Item");
        checkoutPage.deleteItemFromCart();
        Thread.sleep(2000);
        System.out.println(" Item deleted from cart.");
    }

    @Test(priority = 7, groups = {"regression"})
    public void changeAddress() {
        System.out.println("\n-> Running Test 7: Checkout & Change Address");
        try {
            checkoutPage.processCheckoutAndChangeAddress("Harsh@210192");
            System.out.println(" Successfully changed the delivery address.");
        } catch (Exception e) {
            System.out.println(" Checkout issue. Error: " + e.getMessage());
        }
    }
    
    @Test(priority = 8, groups = {"regression"})
    public void checkYourOrdersPage() {
        System.out.println("\n-> Running Test 8: Check 'Your Orders' Page");
        try {
            Assert.assertTrue(ordersPage.navigateAndCheckOrdersHeading());
            System.out.println("Navigated to 'Your Orders'.");
        } catch (Exception e) {
            Assert.fail("Orders page did not load"); 
        }
    }

    @Test(priority = 9, dependsOnMethods = {"checkYourOrdersPage"}, groups = {"regression"})
    public void applyOrdersFilter() {
        System.out.println("\n-> Running Test 9: Apply Filter (Cancelled Orders)");
        try {
            boolean filterApplied = ordersPage.applyCancelledFilter();
            if (filterApplied) {
                Assert.assertTrue(driver.getCurrentUrl().contains("cancelled"));
                System.out.println(" Filter applied successfully.");
            } else {
                System.out.println(" No cancelled orders tab found (Empty State handled).");
            }
        } catch (Exception e) {
            Assert.fail("Failed to apply order filter");
        }
    }

    @AfterTest(alwaysRun = true)
    public void afterTest() {
        if(driver != null) {
            driver.quit();
            System.out.println(" Browser closed.");
        }
    }
}