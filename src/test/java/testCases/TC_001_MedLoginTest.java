package testCases;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

import pageObjects.MedHomePage;
import pageObjects.MedLoginPage;
import testBase.BaseClass;

public class TC_001_MedLoginTest extends BaseClass {

	@Test
	public void verify_login() {

		logger.info("****Started verify login**************");

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

			// Step 4: Verify login success
			wait.until(ExpectedConditions.visibilityOf(homePage.getMyAccountConfirm()));
			Assert.assertTrue(homePage.isLoginSuccesfull(), "Login was not successful.");
		} catch (Exception e) {
			Assert.fail();
		}
		logger.info("*****Starting TC002_Login******");
	}
}