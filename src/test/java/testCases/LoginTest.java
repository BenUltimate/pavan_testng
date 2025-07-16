package testCases;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class LoginTest extends BaseClass {

	@Test
	public void testValidLogin() throws Exception {
		logger.info("====== Starting Login Test ======");

		// Step 1: Navigate to Login Page
		logger.info("Clicking on Login button on Home Page");
		HomePage home = new HomePage(driver);
		home.clickLoginButton();

		// Step 2: Enter credentials
		logger.info("Entering valid credentials");
		LoginPage login = new LoginPage(driver);
		String email = p.getProperty("email");
		String password = p.getProperty("password");
		logger.info("Email entered: " + email);
		login.login(email, password);

		// Step 3: Wait for dashboard/profile name to appear
		logger.info("Waiting for profile name 'Super Adminn' to be visible on Home Page");
		HomePage hp = new HomePage(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(hp.getProfileNameElement()));

		// Step 4: Assertion to verify login success
		logger.info("Verifying if user is logged in by checking for profile name");
		Assert.assertTrue(hp.isUserLoggedIn(), "Login failed - profile name not displayed");

		logger.info("====== Login Test Passed Successfully ======");
	}
}
