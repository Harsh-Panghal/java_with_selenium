package practice.testNg;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

public class Amazon {
    
    WebDriver driver;
    WebDriverWait wait;
    JavascriptExecutor js;

    @BeforeTest(alwaysRun = true) 
    public void beforeTest() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));        
        driver.get("https://www.amazon.in/");
        js = (JavascriptExecutor) driver;
    }

    @Test(priority = 1, groups = {"regression"})
    public void registration() throws InterruptedException {
        driver.get("https://www.amazon.in/ap/signin?openid.return_to=https%3A%2F%2Fwww.amazon.in%2F%3Fref_%3Dnav_ya_signin&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=inflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0");
 
        WebElement email = driver.findElement(By.id("ap_email_login"));
        email.sendKeys("harsh.choudhary.socialmedia@gmail.com");
        email.sendKeys(Keys.ENTER);
        
        driver.findElement(By.xpath("//*[@id=\"intention-submit-button\"]/span/input")).click();      
        // 3. Name Field
        WebElement yourName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ap_customer_name")));
        yourName.sendKeys("Harsh");
        
        // 4. Mobile Number
        WebElement mobileNumber = driver.findElement(By.id("ap_phone_number"));
        mobileNumber.sendKeys("8077166493");
        try {
            WebElement password = driver.findElement(By.id("ap_password"));
            if (password.isDisplayed()) {
                password.sendKeys("Harsh@123");
            }
        } catch (Exception e) {
               System.out.println("Password field not displayed");
        }
        
        WebElement verifyMobileBtn = driver.findElement(By.id("continue"));
        verifyMobileBtn.click();
        
        try {
            WebDriverWait longWait = new WebDriverWait(driver, Duration.ofSeconds(15));
            longWait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.name("cvf_captcha_input")), 
                ExpectedConditions.visibilityOfElementLocated(By.id("cvf-page-title"))
            ));
            Thread.sleep(30000); 
            
        } catch (Exception e) {
            System.out.println("❌ Error: OTP/Captcha screen nahi aayi ya timeout ho gaya.");
        }
    }

    @Test(priority = 2, groups = {"smoke", "regression"})
    public void login() throws InterruptedException {
        System.out.println("\nRunning Test 2: Login");
        driver.get("https://www.amazon.in/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.in%2F%3Fref_%3Dnav_signin&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=inflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0");
        
        WebElement email = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ap_email_login")));
        email.sendKeys("7017750128" + Keys.ENTER);
        
        WebElement pass = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ap_password")));
        pass.sendKeys("Harsh@210192" + Keys.ENTER);
        System.out.println("✅ Login credentials entered.");
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
        
        WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("twotabsearchtextbox")));
        WebElement searchBtn = driver.findElement(By.id("nav-search-submit-button"));

        Assert.assertTrue(searchBtn.isDisplayed(), "Search button not clickable");
        searchBox.clear();
        searchBox.sendKeys(searchInput);
        searchBtn.click();
        
        Thread.sleep(3000);
        String actualTitle = driver.getTitle().toLowerCase();
        Assert.assertTrue(actualTitle.contains(searchInput.toLowerCase()), 
            "Search execute nahi hua for: " + searchInput);
            
        System.out.println("✅ Search successfully validated.");
    }

    @Test(priority = 4, groups = {"regression"})
    public void productDetail() throws InterruptedException {
        System.out.println("\nTest 4: Product Detail");
        Thread.sleep(2000); 
        WebElement firstProductImage = wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("(//div[@data-component-type='s-search-result']//img)[1]/ancestor::a")
        ));
        
        js.executeScript("window.scrollBy(0,400)");
        Thread.sleep(1000);
        
        firstProductImage.click();
        String mainWindow = driver.getWindowHandle();
        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(mainWindow)) {
                driver.switchTo().window(handle);
                Thread.sleep(3000);
                System.out.println("✅ Product Detail Page opened.");
                break;
            }
        }
    }

    @Test(priority = 5, groups = {"regression"})
    public void addToCart() throws InterruptedException {
        Thread.sleep(2000);
        js.executeScript("window.scrollBy(0,500)");
        Thread.sleep(1000);
        
        System.out.println("\nTest 5: Add To Cart");
        WebElement addToCartBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("add-to-cart-button")));
        addToCartBtn.click();
        Thread.sleep(3000);
        System.out.println("✅ Item added to cart.");
    }

    @Test(priority = 6, dependsOnMethods = {"addToCart"}, groups = {"regression"})
    public void deleteCartItem() throws InterruptedException {
        System.out.println("\nTest 6: Delete Cart Item");
        driver.navigate().to("https://www.amazon.in/gp/cart/view.html");        
        WebElement deleteBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Delete']")));
        deleteBtn.click();
        Thread.sleep(2000);
        System.out.println("✅ Item deleted from cart.");
    }

    @Test(priority = 7, groups = {"regression"})
    public void changeAddress() throws InterruptedException {
        System.out.println("\n-> Running Test 7: Checkout & Change Address");
        Thread.sleep(2000);

        try {
            WebElement proceedToBuyBtn = wait.until(ExpectedConditions.elementToBeClickable(By.name("proceedToRetailCheckout")));
            proceedToBuyBtn.click();
            Thread.sleep(3000);
            
            try {
                WebElement pass = driver.findElement(By.id("ap_password"));
                if (pass.isDisplayed()) {
                    pass.sendKeys("Harsh@210192");
                    pass.sendKeys(Keys.ENTER);
                    Thread.sleep(4000);
                }
            } catch (Exception e) {}
            
            WebElement changeAddressLink = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//a[contains(translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), 'change')] | //a[@id='addressChangeLinkId']")
            ));
            changeAddressLink.click();
            Thread.sleep(3000);
            
            java.util.List<WebElement> allAddressRadios = driver.findElements(By.xpath("//div[contains(@id, 'select-destination')]//input[@type='radio']"));
            
            if(allAddressRadios.size() >= 2) {
                WebElement secondAddressBtn = allAddressRadios.get(1);
                WebElement clickableLabel = secondAddressBtn.findElement(By.xpath("./ancestor::label"));
                clickableLabel.click();
                Thread.sleep(2000); 
            }

            WebElement useThisAddressBtn = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//input[contains(@id, 'checkout-primary-continue-button')] | //*[@id='checkout-primary-continue-button-id']//input")
            ));
            
            js.executeScript("arguments[0].scrollIntoView({block: 'center'});", useThisAddressBtn);
            Thread.sleep(1000);
            useThisAddressBtn.click();
            System.out.println("✅ Successfully changed the delivery address.");

        } catch (Exception e) {
            System.out.println("❌ Checkout issue. Error: " + e.getMessage());
        }
    }
    
    @Test(priority = 8, groups = {"regression"})
    public void checkYourOrdersPage() {
        System.out.println("\n-> Running Test 8: Check 'Your Orders' Page");
        try {
            driver.navigate().to("https://www.amazon.in/your-orders/orders");
            Thread.sleep(3000);
            WebElement ordersHeading = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//h1[contains(text(), 'Your Orders')] | //h1[contains(text(), 'Orders')]")
            ));
            Assert.assertTrue(ordersHeading.isDisplayed());
            System.out.println("✅ Navigated to 'Your Orders'.");
        } catch (Exception e) {
            Assert.fail(); 
        }
    }

    @Test(priority = 9, dependsOnMethods = {"checkYourOrdersPage"}, groups = {"regression"})
    public void applyOrdersFilter() {
        System.out.println("\n-> Running Test 9: Apply Filter (Cancelled Orders)");
        try {
            java.util.List<WebElement> cancelledTabList = driver.findElements(
                By.xpath("//a[contains(translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), 'cancelled')] | //a[contains(text(), 'Cancelled Orders')]")
            );

            if (cancelledTabList.size() > 0) {
                WebElement cancelledOrdersTab = cancelledTabList.get(0);
                js.executeScript("arguments[0].scrollIntoView({block: 'center'});", cancelledOrdersTab);
                Thread.sleep(1000);
                cancelledOrdersTab.click();
                Thread.sleep(3000); 
                Assert.assertTrue(driver.getCurrentUrl().contains("cancelled"));
                System.out.println("✅ Filter applied successfully.");
            }
        } catch (Exception e) {
            Assert.fail();
        }
    }

    @AfterTest(alwaysRun = true)
    public void afterTest() {
        if(driver != null) {
            driver.quit();
            System.out.println("✅ Browser closed.");
        }
    }
}