package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountPage {

    WebDriver driver;
    public AccountPage(WebDriver driver) {
        this.driver = driver;
    }
    By txtEmail = By.id("input-email");
    By txtPassword = By.id("input-password");
    By btnLogin = By.xpath("//input[@value='Login']");
    By txtFirstName = By.id("input-firstname");
    By txtLastName = By.id("input-lastname");
    By txtTelephone = By.id("input-telephone");
    By txtConfirmPassword = By.id("input-confirm");
    By chkPrivacyPolicy = By.name("agree");
    By btnContinue = By.xpath("//input[@value='Continue']");
    By drpMyAccount = By.xpath("//span[text()='My Account']");
    By lnkLogout = By.linkText("Logout");
    
    public void enterEmail(String email) {
        driver.findElement(txtEmail).clear();
        driver.findElement(txtEmail).sendKeys(email);
    }

    public void enterPassword(String pwd) {
        driver.findElement(txtPassword).clear();
        driver.findElement(txtPassword).sendKeys(pwd);
    }

    public void clickLoginButton() {
        driver.findElement(btnLogin).click();
    }

    public void enterFirstName(String fName) {
        driver.findElement(txtFirstName).sendKeys(fName);
    }

    public void enterLastName(String lName) {
        driver.findElement(txtLastName).sendKeys(lName);
    }

    public void enterTelephone(String phone) {
        driver.findElement(txtTelephone).sendKeys(phone);
    }

    public void enterConfirmPassword(String confirmPwd) {
        driver.findElement(txtConfirmPassword).sendKeys(confirmPwd);
    }

    public void clickPrivacyPolicy() {
        driver.findElement(chkPrivacyPolicy).click();
    }

    public void clickContinueButton() {
        driver.findElement(btnContinue).click();
    }

    public void clickMyAccountMenu() {
        driver.findElement(drpMyAccount).click();
    }

    public void clickLogoutOption() {
        driver.findElement(lnkLogout).click();
    }
}