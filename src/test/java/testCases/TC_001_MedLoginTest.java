package testCases;

import org.testng.annotations.Test;

import pageObjects.MedHomePage;
import pageObjects.MedLoginPage;
import testBase.BaseClass;

public class TC_001_MedLoginTest extends BaseClass {

	@Test
	public void verify_login() throws Exception {

		MedHomePage lp = new MedHomePage(driver);
		Thread.sleep(3000);
		lp.clickMyAccount();
		Thread.sleep(3000);
		lp.navigateToMyLoginPage();
		Thread.sleep(3000);

		MedLoginPage mlp = new MedLoginPage(driver);
		mlp.setEmail(p.getProperty("email"));
		mlp.setPassword(p.getProperty("password"));
		mlp.clickLogin();
		Thread.sleep(3000);
	}

}
