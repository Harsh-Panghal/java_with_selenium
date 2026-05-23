package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterPage {
    WebDriver driver;

    // 1. Locators
    By genderMale = By.id("gender-male");
    By firstNameInput = By.id("FirstName");
    By lastNameInput = By.id("LastName");
    By emailInput = By.id("Email");
    By passwordInput = By.id("Password");
    By confirmPasswordInput = By.id("ConfirmPassword");
    By registerBtn = By.id("register-button");
    By logoutLink = By.linkText("Log out");

    // 2. Constructor
    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    // 3. Actions
    public void navigateToRegister() {
        driver.get("https://demowebshop.tricentis.com/register");
    }

    public void clickLogoutIfLoggedIn() {
        try {
            WebElement logout = driver.findElement(logoutLink);
            if (logout.isDisplayed()) {
                logout.click();
            }
        } catch (Exception ignored) {}
    }

    public void fillRegistrationForm(String fname, String lname, String email, String pass, String cpass) {
        driver.findElement(genderMale).click();
        driver.findElement(firstNameInput).sendKeys(fname);
        driver.findElement(lastNameInput).sendKeys(lname);
        driver.findElement(emailInput).sendKeys(email);
        driver.findElement(passwordInput).sendKeys(pass);
        driver.findElement(confirmPasswordInput).sendKeys(cpass);
    }

    public void submitRegistration() {
        driver.findElement(registerBtn).click();
    }
}
