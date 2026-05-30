package stepdefinitions;

import org.testng.Assert;
import base.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.RegistrationPage;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
import java.util.Random;

public class RegistrationSteps {

    private RegistrationPage regPage = new RegistrationPage(DriverFactory.getDriver());

    @Given("user is on the registration page")
    public void user_is_on_the_registration_page() {
        // 1. Fetch base URL
        String baseUrl = utilities.ConfigReader.init_prop().getProperty("base_url");
        // 2. Add endpoint and navigate
        DriverFactory.getDriver().get(baseUrl + "/signup");
        // 3. Handle popup
        regPage.closeDemoPopupIfPresent();
        System.out.println("Navigated to Registration Page successfully.");
    }

    @When("user enters personal details {string} {string}")
    public void user_enters_personal_details(String fname, String lname) {
        regPage.enterPersonalDetails(fname, lname);
    }

    @And("enters a randomly generated email and password {string}")
    public void enters_a_randomly_generated_email_and_password(String password) {
        Random random = new Random();
        int randomInt = random.nextInt(100000);
        String randomEmail = "harsh.test." + randomInt + "@gmail.com";
        
        System.out.println("Generated Email: " + randomEmail);
        regPage.enterAccountDetails(randomEmail, password);
    }

    @And("clicks on the signup button")
    public void clicks_on_the_signup_button() {
        regPage.waitForManualCaptchaSolve();; 
        regPage.clickSignup(); 
    }

    @Then("validate successful registration")
    public void validate_successful_registration() {
        try {
            WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(15));
            
            boolean isSuccess = wait.until(
                ExpectedConditions.or(
                    ExpectedConditions.urlContains("signup_success"),
                    ExpectedConditions.urlContains("dashboard"),
                    ExpectedConditions.urlContains("login")
                )
            );
            
            Assert.assertTrue(isSuccess, "Registration failed, URL did not change as expected.");
            System.out.println("Registration Successful! Redirected perfectly.");
            
        } catch (Exception e) {
            Assert.fail("Registration validation failed due to timeout.");
        }
    }
}