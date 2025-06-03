package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class MasterDataPage extends BasePage {

	public MasterDataPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//span[contains(@class,'sidenav-nav-item-span') and contains(., 'Master Data')]")
	private WebElement masterDataMenu;

	@FindBy(xpath = "//button[normalize-space()='Continent']")
	private WebElement continentButton;

	@FindBy(id = "accountDropdownMenuLink")
	private WebElement myAccount;

	@FindBy(xpath = "//div[normalize-space()='My Dashboard']")
	private WebElement dashboard;

	// Actions
	public void clickMasterDataMenu() {
		masterDataMenu.click();
	}

	public void clickContinentButton() {
		continentButton.click();
	}

	public void clickMyAccount() {
		Actions act = new Actions(driver);
		act.moveToElement(myAccount).click().build().perform();
	}

	public void clickDashboard() {
		dashboard.click();
	}

	// Getters for waits
	public WebElement getMyAccount() {
		return myAccount;
	}

	public WebElement getDashboard() {
		return dashboard;
	}

	public WebElement getMasterDataMenu() {
		return masterDataMenu;
	}

	public WebElement getContinentButton() {
		return continentButton;
	}
}
