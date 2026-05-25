package stepDefinitions;

import org.openqa.selenium.By;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchSteps extends BaseClass {

    @Given("user is on the Demo Web Shop dashboard")
    public void user_is_on_the_demo_web_shop_dashboard() {
        System.out.println("User logged in successfully. Ready to search on dashboard.");
    }

    @When("user enters {string} in the search box")
    public void user_enters_in_the_search_box(String productName) {
        driver.findElement(By.id("small-searchterms")).sendKeys(productName);
    }

    @And("clicks on the search button")
    public void clicks_on_the_search_button() {
        driver.findElement(By.xpath("//input[@value='Search']")).click();
    }

    @Then("search results should be displayed successfully")
    public void search_results_should_be_displayed_successfully() {
        boolean isResultDisplayed = driver.findElement(By.className("search-results")).isDisplayed();
        
        Assert.assertTrue(isResultDisplayed, "Search results load nahi hue!");
        System.out.println("Search functionality working perfectly for the product!");
        driver.quit();
        
    }
}