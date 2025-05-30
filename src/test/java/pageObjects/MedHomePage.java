package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MedHomePage extends BasePage {

	public MedHomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	// button[@id='accountDropdownMenuLink']

	@FindBy(id = "accountDropdownMenuLink")
	private WebElement myAccount;

	@FindBy(xpath = "//a[text()='Sign in']")

	private WebElement linkSignIn;

	public void clickMyAccount() {

		myAccount.click();

	}

	public void navigateToMyLoginPage() {
		Actions act = new Actions(driver);

		act.moveToElement(myAccount).perform();

		/*
		 * 
		 * //Approach->1 // Instead of click(), use JS click JavascriptExecutor js =
		 * (JavascriptExecutor) driver; js.executeScript("arguments[0].click();",
		 * linkSignIn);
		 * 
		 */
		
		linkSignIn.click();

	}
	
	

}
