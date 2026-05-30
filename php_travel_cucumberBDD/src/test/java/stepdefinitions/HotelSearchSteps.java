package stepdefinitions;

import org.testng.Assert;
import base.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HotelSearchPage;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
import pages.HotelSearchResultsPage;

public class HotelSearchSteps {

    private HotelSearchPage searchPage = new HotelSearchPage(DriverFactory.getDriver());
    private HotelSearchResultsPage resultsPage = new HotelSearchResultsPage(DriverFactory.getDriver());

    @Given("user is on the PHPTravels home page")
    public void user_is_on_the_php_travels_home_page() {
        // 1. Fetch base URL
        String baseUrl = utilities.ConfigReader.init_prop().getProperty("base_url");
        // 2. Navigate to Home Page (No extra endpoint needed)
        DriverFactory.getDriver().get(baseUrl);
        searchPage.closeDemoPopupIfPresent();
        System.out.println("Navigated to Home Page successfully.");
    }

    @When("user enters destination {string}")
    public void user_enters_destination(String destination) {
        searchPage.searchCity(destination);
    }

    @And("selects check-in and check-out dates")
    public void selects_check_in_and_check_out_dates() {
        searchPage.selectDates();
    }

    @And("selects travellers count")
    public void selects_travellers_count() {
        searchPage.selectTravellers();
    }
    
    @And("selects nationality {string}")
    public void selects_nationality(String nationality) {
        searchPage.selectNationality(nationality);
    }

    @And("clicks on the hotel search button")
    public void clicks_on_the_hotel_search_button() {
        searchPage.clickSearch();
    }

    @Then("validate hotel search results are displayed")
    public void validate_hotel_search_results_are_displayed() {
        try {
            org.openqa.selenium.support.ui.WebDriverWait wait = new org.openqa.selenium.support.ui.WebDriverWait(base.DriverFactory.getDriver(), java.time.Duration.ofSeconds(20));
            
            boolean isSuccess = wait.until(org.openqa.selenium.support.ui.ExpectedConditions.urlContains("stays"));
            
            Assert.assertTrue(isSuccess, "Search results page did not load.");
            System.out.println("Hotel Search Successful! Result URL: " + base.DriverFactory.getDriver().getCurrentUrl());
            
        } catch (Exception e) {
            String failedUrl = base.DriverFactory.getDriver().getCurrentUrl();
            System.out.println("Validation Timeout! The URL at failure was: " + failedUrl);
            Assert.fail("Hotel search validation failed due to timeout.");
        }
    }
    @And("fetch and validate dynamic hotel prices")
    public void fetch_and_validate_dynamic_hotel_prices() {
        resultsPage.fetchAndValidateHotelData();
    }
}