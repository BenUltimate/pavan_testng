package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
	}

	// Home page login button (top right corner)
	@FindBy(xpath = "//button[contains(@class, 'login-btn')]")
	WebElement btnLogin;

	public void clickLoginButton() {
		btnLogin.click();
	}

	// Label that appears after login
	@FindBy(xpath = "//h3[@class='profile-name' and contains(text(), 'Super Admin')]")
	WebElement lblSuperAdmin;

	public WebElement getProfileNameElement() {
		return lblSuperAdmin;
	}

	public boolean isUserLoggedIn() {
		try {
			return getProfileNameElement().isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}
}
