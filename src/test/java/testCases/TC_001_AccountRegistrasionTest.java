package testCases;


import org.testng.Assert;

import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;

import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistrasionTest extends BaseClass{

	
	
	
	
	
	
	
	@Test
	public void test_account_Registration(){
		logger.info("********** starting TC_001_AccountRegistrasionTest");
		HomePage hp= new HomePage(driver);
		hp.clickMyAccount();
		hp.clicklnkRegister();
		
		AccountRegistrationPage regPage = new AccountRegistrationPage(driver);
		regPage.setFirstName(randomString().toUpperCase());
		regPage.setLastName(randomString().toUpperCase());
		regPage.setEmail(randomString()+"@gmail.test");
		regPage.setTelephone(randomNumber());
		
		String password  =randomAlphaNumeric();
		regPage.setPassword(password);
		regPage.setConfirmPassword(password);
		
		regPage.setPrivacyPolicy();
		regPage.clickContinue();
		
		String confmsg = regPage.getConfirmationMsg();
		if(confmsg.equals("Your Account has been Created!")) {
			logger.info("Registration succeful.........");
			Assert.assertTrue(true);
		}else {
			logger.error("Registration failed........");
			Assert.fail();
		}
		logger.info("********** Finished TC_001_AccountRegistrasionTest");
		
	}
	
	
	
	
	
	
	
}
