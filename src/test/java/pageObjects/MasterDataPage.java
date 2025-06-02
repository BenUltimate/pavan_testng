package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MasterDataPage extends BasePage {

	public MasterDataPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//span[contains(@class,'sidenav-nav-item-span') and contains(., 'Master Data')]")
	private WebElement masterDataMenu;

	@FindBy(xpath = "//button[normalize-space()='Continent']")
	private WebElement continentButton;

	public void clickMasterDataMenu() {
		masterDataMenu.click();
	}

	public void clickContinentButton() {
		continentButton.click();
		;
	}

}
