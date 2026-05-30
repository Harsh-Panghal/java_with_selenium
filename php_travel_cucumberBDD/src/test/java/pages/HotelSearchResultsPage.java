package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.WaitUtils;
import java.util.*;

public class HotelSearchResultsPage {

    private WebDriver driver;

    private By hotelNamesList = By.xpath("//h3[contains(@class, 'font-bold') and contains(@class, 'line-clamp-1')]");
    private By hotelPricesList = By.xpath("//p[contains(@class, 'text-2xl') and contains(@class, 'font-bold')]");

    public HotelSearchResultsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void fetchAndValidateHotelData() {
        try {
            System.out.println("Waiting for hotels to load on the results page...");
            
            // List load hone ka wait karega (Max 15 seconds)
            WaitUtils.waitForVisible(driver, hotelNamesList, 15); 
            Thread.sleep(2000); 

            List<WebElement> names = driver.findElements(hotelNamesList);
            List<WebElement> prices = driver.findElements(hotelPricesList);

            if (names.isEmpty() || prices.isEmpty()) {
                System.out.println("No hotels found on the page! Please check locators.");
                return;
            }

            // 1. Mandatory Requirement: HashMap
            HashMap<String, Integer> hotelDataMap = new HashMap<>();
            
            // Extra collections duplicate handle karne ke liye
            List<Integer> allPrices = new ArrayList<>();
            Set<String> uniqueNames = new HashSet<>();
            List<String> duplicateHotels = new ArrayList<>();

            // 2. Mandatory Requirement: Loops
            int size = Math.min(names.size(), prices.size()); 
            
            for (int i = 0; i < size; i++) {
                String hotelName = names.get(i).getText().trim();
                String priceText = prices.get(i).getText().trim(); // Example: "USD 1545.00"

                String cleanPrice = priceText.split("\\.")[0]; // "USD 1545.00" -> "USD 1545"
                String numericPrice = cleanPrice.replaceAll("[^0-9]", ""); // "USD 1545" -> "1545"
                
                int price = numericPrice.isEmpty() ? 0 : Integer.parseInt(numericPrice);

                hotelDataMap.put(hotelName, price);
                allPrices.add(price);

                // Duplicate check logic
                if (!uniqueNames.add(hotelName)) {
                    duplicateHotels.add(hotelName);
                }
            }

            // 3. Mandatory Requirement: Collections
            int highestPrice = Collections.max(allPrices);
            int lowestPrice = Collections.min(allPrices);
            
            double sum = 0;
            for (int p : allPrices) {
                sum += p;
            }
            double averagePrice = sum / allPrices.size();

            // Print the final validated data
            System.out.println("\n====== HOTEL PRICE VALIDATION REPORT ======");
            System.out.println("Total Hotels Scraped: " + size);
            System.out.println("Highest Hotel Price: " + highestPrice);
            System.out.println("Lowest Hotel Price: " + lowestPrice);
            System.out.println("Average Hotel Price: " + averagePrice);
            
            if (duplicateHotels.isEmpty()) {
                System.out.println("Duplicate Hotel Names: None! All names are unique.");
            } else {
                System.out.println("Duplicate Hotel Names: " + duplicateHotels);
            }
            System.out.println("===========================================\n");

        } catch (Exception e) {
            System.out.println("Error fetching hotel data: " + e.getMessage());
        }
    }
}