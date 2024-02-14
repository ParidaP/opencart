package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	WebDriver driver;
	
	/*
	 * first we create constructor 
	 * 
	 * */
	
	public HomePage(WebDriver driver){
		super(driver);		
	}
	
	//elements
	@FindBy(xpath="//span[normalize-space()='My Account']") WebElement lnkMyAccount;
	@FindBy(xpath="//span[normalize-space()='Register']") WebElement lnkRegister;
	@FindBy(xpath="//span[normalize-space()='Login']") WebElement lnkLogin;

    @FindBy(xpath="//a[normalize-space()='Login']") WebElement LoginLink;
	
	public void clickMyAccount() {
		lnkMyAccount.click();
	}
	
	public void clicklnkRegister() {
		lnkRegister.click();
	}
	
	
	
	public void clickLogin() {
		LoginLink.click();
	}
	
	
	
	
	
	
	
	
	}
