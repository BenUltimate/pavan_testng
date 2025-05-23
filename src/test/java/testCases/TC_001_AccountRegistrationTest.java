package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;
public class TC_001_AccountRegistrationTest extends BaseClass {
	

	@Test
	public void verify_account_registration() {
		try {
			logger.info("***Started Test case");
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			hp.clickRegister();

			AccountRegistrationPage regpage = new AccountRegistrationPage(driver);
			regpage.setFirstName(randomeString().toUpperCase());
			regpage.setLastName(randomeString().toUpperCase());

			// randomly generate the email
			regpage.setEmail(randomeString() + "@gmail.com");
			regpage.setTelephone("23123123");

			String password = randomeAlphaNumberic();
		

			regpage.setPassword(password);
			regpage.setConfirmPassword(password);

			regpage.setPrivacyPolicy();
			regpage.clickContinue();

			String confmsg = regpage.getConfirmationMsg();
			if(confmsg.equals("Your Account Has Been Created!")) {
				Assert.assertTrue(true);
			}else {
				logger.error("Test Failed");
				logger.debug("Debug logs");
			}
			
			Assert.assertEquals(confmsg, "Your Account Has Been Created!");
			logger.info("Ended Test Case");

		} catch(Exception e){
			Assert.fail();
			
		}
		
	}


}
