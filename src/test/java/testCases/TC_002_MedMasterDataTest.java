package testCases;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.MasterDataPage;
import pageObjects.MedHomePage;
import pageObjects.MedLoginPage;
import testBase.BaseClass;

public class TC_002_MedMasterDataTest extends BaseClass {

	@Test
	public void verify_masterdata() {
		logger.info("**** Started verify_masterdata test ****");

		try {
			MedHomePage homePage = new MedHomePage(driver);
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

			// Step 1: Click on "My Account"
			wait.until(ExpectedConditions.elementToBeClickable(homePage.getMyAccount()));
			homePage.clickMyAccount();

			// Step 2: Navigate to Login Page
			wait.until(ExpectedConditions.elementToBeClickable(homePage.getLinkSignIn()));
			homePage.navigateToMyLoginPage();

			// Step 3: Enter login credentials
			MedLoginPage loginPage = new MedLoginPage(driver);
			wait.until(ExpectedConditions.visibilityOf(loginPage.getUserName()));
			loginPage.setEmail(p.getProperty("email"));
			loginPage.setPassword(p.getProperty("password"));
			loginPage.clickLogin();

			// Step 4: Interact with Master Data page
			MasterDataPage mdp = new MasterDataPage(driver);

			wait.until(ExpectedConditions.visibilityOf(mdp.getMyAccount()));
			mdp.clickMyAccount();

			wait.until(ExpectedConditions.elementToBeClickable(mdp.getDashboard()));
			mdp.clickDashboard();

			wait.until(ExpectedConditions.elementToBeClickable(mdp.getMasterDataMenu()));
			mdp.clickMasterDataMenu();

			wait.until(ExpectedConditions.elementToBeClickable(mdp.getContinentButton()));
			mdp.clickContinentButton();
			
			
			//add continent
			wait.until(ExpectedConditions.elementToBeClickable(mdp.getAddContinent()));
			mdp.clickAddContinent();
			mdp.enterContinentCode("5555");
			mdp.enterContinentName("Auto");
			mdp.clickSave();
			

			
			logger.info("**** Master Data verification steps completed successfully ****");

		} catch (Exception e) {
			logger.error("Exception occurred in verify_masterdata test: ", e);
			Assert.fail("Test failed due to exception: " + e.getMessage());
		}
	}
}
