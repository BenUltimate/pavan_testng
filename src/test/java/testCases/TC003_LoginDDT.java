package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

/**
 * Data is valid - login success - test pass - logout Data is valid - login
 * failed - test fail
 * 
 * Data is invalid - login success - test fail - logout Data is invalid - login
 * failed - test pass
 */

public class TC003_LoginDDT extends BaseClass {
	// if there are data providers written in another class then we have to write
	// like this
	// if data provider is there in same class then no need
	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class,groups= "Datadriver")
	public void verify_loginDDT(String email,String pwd,String exp) {
		
		logger.info("Starting TC_003_LoginDDT");
		
		
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			hp.clickLogin();
			
			LoginPage lp = new LoginPage(driver);
			lp.setEmail(email);
			lp.setPassword(pwd);
			lp.clickLogin();
			
			MyAccountPage macc = new MyAccountPage(driver);
			boolean targetPage = macc.isMyAccountPageExists();
			
			/*
			 * Data is valid - login success - test pass - logout
			 * 				 -login faled    - test fail 
			 * 
			 * Data is invalid - login success - test fail - logout
			 * 					 login failed - test pass
			 * 
			 */
			
			if(exp.equalsIgnoreCase("Valid")) {
				if(targetPage==true) {
					Assert.assertTrue(true);
					macc.clickLogout();
				}
				else {
					Assert.assertTrue(false);
				}
			}
			
			if(exp.equalsIgnoreCase("Invalid")) {
				if(targetPage==true) {
					macc.clickLogout();
					Assert.assertTrue(false);
				}else {
					Assert.assertTrue(true);
				}
				
			
		
		}
		logger.info("****Finished TC_003_LoginDDT****");
		
		
	}
	
		}