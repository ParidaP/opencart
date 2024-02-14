package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;


public class TC__002_LoginTest extends BaseClass{
	
	
	
    HomePage homePage =new HomePage(driver);
	LoginPage loginPage = new LoginPage(driver);
	MyAccountPage myAccountPage = new MyAccountPage(driver);
	@Test
	public void test_Login() {
		try {
		logger.info("Starting TC_002_LoginTest ......");
		homePage.clickMyAccount();
		homePage.clickLogin();
		loginPage.setEmail(rb.getString("email"));
		loginPage.setPassword(rb.getString("password"));
		loginPage.clickLogin();
		boolean result =myAccountPage.isMyAccountPageExists();
	
		Assert.assertEquals(result, true);
		
			}catch(Exception e) {
		Assert.fail();
	}
	
		logger.info("Finished TC_002_LoginTest ......");
	
	}
	
}
