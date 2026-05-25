package stepDefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps extends BaseClass {
    By emailInput = By.id("Email");
    By passInput = By.id("Password");
    By loginBtn = By.xpath("//input[@value='Log in']");
        
    @Given("login page should be open in default browser")
    public void login_page_should_be_open_in_default_browser() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://demowebshop.tricentis.com/login");
    }
    
    @When("click on email field and enter valid email {string}")
    public void click_on_email_field_and_enter_valid_email(String emailText) {
        driver.findElement(emailInput).click();
        driver.findElement(emailInput).sendKeys(emailText);
    }
    
    @And("then click on password field and enter valid password {string}")
    public void then_click_on_password_field_and_enter_valid_password(String passText) {
        driver.findElement(passInput).sendKeys(passText); 
    }

    @And("now click on login button")
    public void now_click_on_login_button() {
        driver.findElement(loginBtn).click();
    }

    @Then("user login successfully and redirect to home page")
    public void user_login_successfully_and_redirect_to_home_page() {
        boolean isLogoutVisible = driver.findElement(By.linkText("Log out")).isDisplayed();
        Assert.assertTrue(isLogoutVisible, "Login fail ho gaya ya dashboard nahi khula!");
        
        System.out.println("Demo Web Shop successfully Login!");
        driver.quit();

    }
}