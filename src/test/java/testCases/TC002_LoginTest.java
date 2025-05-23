package testCases;

import org.testng.Assert;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass{
	
	public void verify_login() {
		logger.info("****Starting TC_002_LoginTest****");
		
		try {
		//HomePage
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		//LoginPage
		LoginPage lp = new LoginPage(driver);
		lp.setEmail(p.getProperty("email"));
		lp.setPassword(p.getProperty("password"));
		
		//MyAccount
		MyAccountPage macc = new MyAccountPage(driver);
		boolean targetPage = macc.isMyAccountPageExists();
		
		Assert.assertEquals(targetPage, true,"Login Failed ");
		Assert.assertTrue(targetPage);
		
	}catch(Exception e) {
		Assert.fail();
	}
		logger.info("****Starting TC_002_LoginTest****");
	}

}
