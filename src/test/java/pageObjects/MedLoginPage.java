package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MedLoginPage extends BasePage {

	public MedLoginPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//input[@id='email']")
	private WebElement userName;

	@FindBy(xpath = "//input[@id='password']")
	private WebElement password;

	@FindBy(xpath = "//button[normalize-space(text())='Login']")
	private WebElement loginBtn;

	// Actions
	public void setEmail(String email) {
		userName.sendKeys(email);
	}

	public void setPassword(String pwd) {
		password.sendKeys(pwd);
	}

	public void clickLogin() {
		loginBtn.click();
	}

	// Getter for wait
	public WebElement getUserName() {
		return userName;
	}
}
