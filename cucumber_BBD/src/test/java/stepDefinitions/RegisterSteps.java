package stepDefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class RegisterSteps extends BaseClass {


    @Given("user is on the Demo Web Shop registration page")
    public void user_is_on_the_demo_web_shop_registration_page() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://demowebshop.tricentis.com/register");
    }

    @When("user selects gender as male")
    public void user_selects_gender_as_male() {
        driver.findElement(By.id("gender-male")).click();
    }

    @And("enters first name {string}")
    public void enters_first_name(String firstName) {
        driver.findElement(By.id("FirstName")).sendKeys(firstName);
    }

    @And("enters last name {string}")
    public void enters_last_name(String lastName) {
        driver.findElement(By.id("LastName")).sendKeys(lastName);
    }

    @And("enters email {string}")
    public void enters_email(String email) {
        driver.findElement(By.id("Email")).sendKeys(email);
    }

    @And("enters password {string}")
    public void enters_password(String password) {
        driver.findElement(By.id("Password")).sendKeys(password);
    }

    @And("enters confirm password {string}")
    public void enters_confirm_password(String confirmPassword) {
        driver.findElement(By.id("ConfirmPassword")).sendKeys(confirmPassword);
    }

    @And("clicks on the register button")
    public void clicks_on_the_register_button() {
        driver.findElement(By.id("register-button")).click();
    }

    @Then("user should see the registration completed message")
    public void user_should_see_the_registration_completed_message() {
        String currentPageSource = driver.getPageSource();
        Assert.assertTrue(currentPageSource.contains("Your registration completed"), "Registration fail ho gaya ya email already exist karti hai!");
        
        System.out.println("Registration successful verified by Cucumber!");
        driver.quit();
    }
}