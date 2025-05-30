package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MedLoginPage extends BasePage{

	public MedLoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy( xpath="//input[@id='email']")
	private WebElement userName;
	
	@FindBy(xpath="//input[@id='password']")
	private WebElement password;
	
	@FindBy(xpath="//button[normalize-space(text())='Login']")
	private WebElement loginBtn;
	
	
	public void setEmail(String email) {
		userName.sendKeys(email);
	}
	
	public void setPassword(String pwd) {
		password.sendKeys(pwd);
	}
	
	public void clickLogin() {
		
		loginBtn.click();
	}
	
}
