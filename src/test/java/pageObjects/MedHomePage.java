package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class MedHomePage extends BasePage {

	public MedHomePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "accountDropdownMenuLink")
	private WebElement myAccount;

	@FindBy(xpath = "//a[text()='Sign in']")
	private WebElement linkSignIn;

	@FindBy(xpath = "//h5[contains(text(), 'ACCOUNT |')]")
	private WebElement myAccountConfirm;

	// Actions
	public void clickMyAccount() {
		myAccount.click();
	}

	public void navigateToMyLoginPage() {
		Actions act = new Actions(driver);
		act.moveToElement(myAccount).perform();
		linkSignIn.click();
	}

	public boolean isLoginSuccesfull() {
		return myAccountConfirm.isDisplayed();
	}

	// Getter Methods for Explicit Waits
	public WebElement getMyAccount() {
		return myAccount;
	}

	public WebElement getLinkSignIn() {
		return linkSignIn;
	}

	public WebElement getMyAccountConfirm() {
		return myAccountConfirm;
	}
}
