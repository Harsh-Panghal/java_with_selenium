package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.WaitUtils;

import java.util.*;

public class BookingTablePage {

    private WebDriver driver;

    // Locators
    private By tableHeaders = By.xpath("//table//thead//th");
    private By tableRows = By.xpath("//table//tbody//tr");

    public BookingTablePage(WebDriver driver) {
        this.driver = driver;
    }

    // 1. Fetch entire table and convert to List of HashMaps
    public List<Map<String, String>> getTableData() {
        List<Map<String, String>> tableData = new ArrayList<>();
        
        // Headers fetch karo
        List<WebElement> headerElements = WaitUtils.waitForAllVisible(driver, tableHeaders, 10);
        List<String> headers = new ArrayList<>();
        for (WebElement header : headerElements) {
            headers.add(header.getText().trim());
        }

        // Rows fetch karo
        List<WebElement> rowElements = driver.findElements(tableRows);

        for (WebElement row : rowElements) {
            List<WebElement> columns = row.findElements(By.tagName("td"));
            Map<String, String> rowData = new LinkedHashMap<>(); // Insert order maintain karne ke liye

            for (int i = 0; i < columns.size(); i++) {
                // Ignore empty or mismatching columns
                if (i < headers.size()) { 
                    rowData.put(headers.get(i), columns.get(i).getText().trim());
                }
            }
            if(!rowData.isEmpty()) {
                tableData.add(rowData);
            }
        }
        return tableData;
    }

    // 2. Logic to find Duplicates (Assuming 'Booking ID' is the unique column)
    public void findDuplicateBookings(List<Map<String, String>> tableData) {
        Set<String> uniqueIds = new HashSet<>();
        boolean duplicateFound = false;

        System.out.println("Checking for duplicate invoices...");
        for (Map<String, String> row : tableData) {
            // Updated key to "INVOICE"
            String invoiceId = row.get("INVOICE"); 
            
            if (invoiceId != null && !uniqueIds.add(invoiceId)) {
                System.out.println("Duplicate Invoice Found! ID: " + invoiceId);
                duplicateFound = true;
            }
        }
        
        if (!duplicateFound) {
            System.out.println("✅ No duplicate invoices found in the table.");
        }
    }

    // 3. Logic to find Highest and Lowest Price
    public void printHighestAndLowestPrice(List<Map<String, String>> tableData) {
        double maxPrice = Double.MIN_VALUE;
        double minPrice = Double.MAX_VALUE;
        String maxBookingInfo = "";
        String minBookingInfo = "";

        for (Map<String, String> row : tableData) {
            // Updated keys to "PRICE" and "INVOICE"
            String priceString = row.get("PRICE"); 
            String invoiceId = row.get("INVOICE");
            
            if (priceString != null && !priceString.isEmpty()) {
                try {
                    // Removes USD, $, commas, etc. (e.g., "USD 1,200.50" -> "1200.50")
                    double price = Double.parseDouble(priceString.replaceAll("[^0-9.]", ""));

                    if (price > maxPrice) {
                        maxPrice = price;
                        maxBookingInfo = invoiceId + " (" + priceString + ")";
                    }
                    if (price < minPrice) {
                        minPrice = price;
                        minBookingInfo = invoiceId + " (" + priceString + ")";
                    }
                } catch (NumberFormatException e) {
                    // Ignore rows where price cannot be parsed
                }
            }
        }

        System.out.println("Highest Booking Amount: " + maxBookingInfo);
        System.out.println("Lowest Booking Amount: " + minBookingInfo);
    }
}