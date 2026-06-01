package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.WaitUtils;
import java.util.List;

public class HotelSearchPage {

    private WebDriver driver;
    // City Dropdown container
    private By destinationInput = By.cssSelector("input[placeholder='Search By City']");
    // Dynamic list items matching city name
    private String dynamicCityResult = "//*[contains(text(),'%s')]";
    private By staysTab = By.xpath("//button[@role='tab' and .//span[text()='Stays']]");
    // Dates & Travellers
    private By checkInInput = By.name("checkin_date");
    private By checkOutInput = By.name("checkout_date");
    private By travellersDropdown = By.xpath("//*[contains(text(), 'Traveler') or contains(@class, 'traveller')]");
    
    private By searchBtn = By.xpath("//button[@title='Search Hotels' or @aria-label='Search Hotels']");
    
    private By nationalityDropdownClickable = By.xpath("//div[@x-data='nationalityDropdown()']//div[contains(@class, 'cursor-pointer')]");
    private By nationalitySearchBox = By.xpath("//div[contains(@class, 'input-dropdown-content')]//input[@type='text']");
    private String dynamicNationalityResult = "//div[contains(@class, 'input-dropdown-content')]//li[contains(text(), '%s')]";
    private By understandButton = By.xpath("//button[contains(text(), 'I Understand')]");
    
    public HotelSearchPage(WebDriver driver) {
        this.driver = driver;
    }
    
    // Popup Handler Method
    public void closeDemoPopupIfPresent() {
        try {
            WebElement btn = WaitUtils.waitForClickable(driver, understandButton, 3);
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", btn);
            System.out.println("Demo popup closed successfully on Home Page!");
            Thread.sleep(1000); 
        } catch (Exception e) {
            System.out.println("No demo popup appeared on Home Page.");
        }
    }

    public void clickStaysTab() {
        try {
            WebElement tab = WaitUtils.waitForPresence(driver, staysTab, 10);

            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", tab);
            
            System.out.println("Switched to 'Stays' tab successfully!");
            Thread.sleep(2000); 
            
        } catch (Exception e) {
            System.out.println("Could not switch to 'Stays' tab: " + e.getMessage());
            org.testng.Assert.fail("Stays tab switch fail ho gaya: " + e.getMessage());
        }
    }
    
    public void searchCity(String cityName) {
        try {
            List<WebElement> destInputs = driver.findElements(destinationInput);
            WebElement activeInput = null;
            for(WebElement input : destInputs) {
                if(input.isDisplayed()) {
                    activeInput = input;
                    break; 
                }
            }
            
            if(activeInput != null) {
                activeInput.clear();
                activeInput.sendKeys(cityName);
                System.out.println("Typed city: " + cityName);
                Thread.sleep(2500);

                By exactCity = By.xpath(String.format(dynamicCityResult, cityName));
                WebElement cityOption = WaitUtils.waitForClickable(driver, exactCity, 10);
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", cityOption);
                System.out.println("City selected from auto-suggest: " + cityName);
            } else {
                System.out.println(" Koi bhi visible destination input nahi mila!");
                org.testng.Assert.fail("Destination input visible nahi hai.");
            }
            
        } catch (Exception e) {
            System.out.println("City search failed: " + e.getMessage());
            org.testng.Assert.fail("City search error: " + e.getMessage());
        }
    }

    public void selectDates() {
        System.out.println("⚡ Using Boss-Level JS Injection for Dates...");
        try {
            WebElement checkIn = WaitUtils.waitForPresence(driver, checkInInput, 5);
            WebElement checkOut = WaitUtils.waitForPresence(driver, checkOutInput, 5);
            
            JavascriptExecutor js = (JavascriptExecutor) driver;
            String checkinDate = "15-06-2026"; 
            String checkoutDate = "20-06-2026";
            js.executeScript("arguments[0].value='" + checkinDate + "';", checkIn);
            js.executeScript("arguments[0].dispatchEvent(new Event('input', { bubbles: true }));", checkIn);
            js.executeScript("arguments[0].dispatchEvent(new Event('change', { bubbles: true }));", checkIn);
            js.executeScript("arguments[0].value='" + checkoutDate + "';", checkOut);
            js.executeScript("arguments[0].dispatchEvent(new Event('input', { bubbles: true }));", checkOut);
            js.executeScript("arguments[0].dispatchEvent(new Event('change', { bubbles: true }));", checkOut);
            
            System.out.println("Dates injected successfully: " + checkinDate + " to " + checkoutDate);
            
        } catch(Exception e) {
             System.out.println("Date pickers handling failed: " + e.getMessage());
        }
    }

    public void selectTravellers() {
        try {
            WebElement dropdown = WaitUtils.waitForPresence(driver, travellersDropdown, 5);
            
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", dropdown);
            
            System.out.println("Travellers dropdown clicked successfully using JS!");
            
        } catch (Exception e) {
            System.out.println("Travellers dropdown click failed: " + e.getMessage());
        }
    }
    
    public void selectNationality(String countryName) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;

            WebElement hiddenInput = WaitUtils.waitForPresence(driver, By.name("nationality"), 5);
            String countryCode = countryName.substring(0, 2).toUpperCase(); 

            js.executeScript("arguments[0].value='" + countryCode + "';", hiddenInput);
            
            js.executeScript("arguments[0].dispatchEvent(new Event('input', { bubbles: true }));", hiddenInput);
            js.executeScript("arguments[0].dispatchEvent(new Event('change', { bubbles: true }));", hiddenInput);
            
            System.out.println("Nationality perfectly set to: " + countryCode);
            
        } catch (Exception e) {
            System.out.println("JS Injection failed: " + e.getMessage());
        }
    }

    public void clickSearch() {
        System.out.println("Trying to click Search Button...");
        try {
            WebElement btn = WaitUtils.waitForPresence(driver, searchBtn, 10);
            
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", btn);
            Thread.sleep(1000); 
            
            js.executeScript("arguments[0].click();", btn);
            System.out.println("Search button clicked successfully using JS!");
            
        } catch (Exception e) {
            System.out.println("Search button click failed: " + e.getMessage());
            org.testng.Assert.fail("Jenkins execution me search button nahi mila: " + e.getMessage());
        }
    }
}