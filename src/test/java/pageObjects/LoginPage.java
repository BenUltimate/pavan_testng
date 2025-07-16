package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    // Email field
    @FindBy(xpath = "//input[@type='email' and @formcontrolname='email']")
    WebElement txtEmail;

    // Password field
    @FindBy(xpath = "//input[@type='password' and @formcontrolname='password']")
    WebElement txtPassword;

    // Login Button on form
    @FindBy(xpath = "//button[contains(@class, 'btn') and contains(@class, 'btn-primary') and text()=' Login ']")
    WebElement btnLogin;

    public void setEmail(String email) {
        txtEmail.sendKeys(email);
    }

    public void setPassword(String password) {
        txtPassword.sendKeys(password);
    }

    public void clickLogin() {
        btnLogin.click();
    }

    public void login(String email, String password) {
        setEmail(email);
        setPassword(password);
        clickLogin();
    }
}

