package stepdefinitions;

import org.testng.Assert;
import base.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.BookingWorkflowPage;
import pages.LoginPage;

public class E2EBookingSteps {

    private BookingWorkflowPage bookingPage = new BookingWorkflowPage(DriverFactory.getDriver());
    private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());

    @When("user enters {string} and {string}")
    public void user_enters_and(String username, String password) {

        loginPage.enterUsername(username);     
        loginPage.enterPassword(password);  

    }
    @And("user selects a hotel from the search results")
    public void user_selects_a_hotel_from_the_search_results() {
        bookingPage.selectFirstHotel();
    }

    @And("books the hotel room")
    public void books_the_hotel_room() {
        bookingPage.clickBookNow();
    }

    @And("enters traveller details and confirms booking")
    public void enters_traveller_details_and_confirms_booking() {
        bookingPage.enterTravellerDetailsAndConfirm();
    }

    @Then("validate booking confirmation message")
    public void validate_booking_confirmation_message() {
        boolean isConfirmed = bookingPage.isBookingConfirmed();
        Assert.assertTrue(isConfirmed, "Booking confirmation message not displayed!");
    }

    @And("user logs out")
    public void user_logs_out() {
        bookingPage.logout();
    }
}