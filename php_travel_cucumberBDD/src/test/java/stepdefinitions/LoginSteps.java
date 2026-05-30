package stepdefinitions;

import java.util.List;
import java.util.Map;

import org.testng.Assert;
import base.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import utilities.ExcelReader;

public class LoginSteps {
    private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
    private boolean isLoginAttemptedWithValidData;
    

    @Given("user launches browser")
    public void user_launches_browser() {
        // 1. Fetch base URL
        String baseUrl = utilities.ConfigReader.init_prop().getProperty("base_url");
        // 2. Add endpoint and navigate
        DriverFactory.getDriver().get(baseUrl + "/login");
        // 3. Handle popup
        loginPage.closeDemoPopupIfPresent();
        System.out.println("Navigated to Login Page successfully.");
    }

    @When("user enters login credentials from sheet {string} and rownumber {int}")
    public void user_enters_login_credentials_from_sheet_and_rownumber(String sheetName, Integer rowNumber) {
        
        ExcelReader reader = new ExcelReader();
        List<Map<String, String>> testData = reader.getData("src/test/resources/testdata/LoginData.xlsx", sheetName);
        
        String userName = testData.get(rowNumber).get("username");
        String password = testData.get(rowNumber).get("password");
        
        System.out.println("Reading from Excel -> Username: " + userName + " | Password: " + password);
        
        if ("user@phptravels.com".equals(userName) && "demouser".equals(password)) {
            isLoginAttemptedWithValidData = true;
        } else {
            isLoginAttemptedWithValidData = false;
        }
        
        loginPage.enterUsername(userName);
        loginPage.enterPassword(password);
    }


    @And("clicks on login button")
    public void clicks_on_login_button() {
        loginPage.clickLogin();
    }

    @Then("validate login result")
    public void validate_login_result() {
        if (isLoginAttemptedWithValidData) {
            Assert.assertTrue(loginPage.isDashboardDisplayed(), "Dashboard not found after valid login!");
            System.out.println("Valid Login Successful!");
        } else {
            boolean isErrorVisible = loginPage.isErrorMessageDisplayed();
            boolean isDashboardHidden = !loginPage.isDashboardDisplayed();
            
            Assert.assertTrue(isErrorVisible || isDashboardHidden, "Invalid login validation failed!");
            System.out.println("Invalid/Blank Login Rejected Successfully!");
        }
    }
}