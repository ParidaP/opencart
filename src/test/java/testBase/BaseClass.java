package testBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;


public class BaseClass {
	public static WebDriver driver;
	public Logger logger;
	public ResourceBundle rb;
	
	
	@BeforeClass
	@Parameters({"browser"})
	public void setup(String br) {
		
		rb=ResourceBundle.getBundle("config"); //loading config.properties file 
		logger=LogManager.getLogger(this.getClass());
		
		if(br.equals("chrome"))
		{
			driver =new ChromeDriver();	
		}
		else if(br.equals("edge")) {
			driver =new EdgeDriver();
		}
		else
		{
			driver =new ChromeDriver();
		}
		
		
		
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get(rb.getString("appURL")); //  variable in properties file should be in double quotations.
		driver.manage().window().maximize();
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.close();
	}
	
	
public String randomString() {
		
		String generateString =RandomStringUtils.randomAlphabetic(5); // this will generate string with 5 characters
		
		return generateString;
				
	}
	
	public String randomNumber() {
		
   String generateString =RandomStringUtils.randomNumeric(10); // this will generate 10 digit number in string format 
		
		return generateString;
	}
	
	
	
	public String randomAlphaNumeric() {
		
		String Str = RandomStringUtils.randomAlphabetic(5);
		String num = RandomStringUtils.randomNumeric(10);
		
		return Str+num;
		
	}
	
	public  String CaptureScreen(String tname) {
		
		String  timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
	
		
		TakesScreenshot takeScreenshot = (TakesScreenshot)driver;
		File source = takeScreenshot.getScreenshotAs(OutputType.FILE);
		String destination =System.getProperty("user.dir")+ "\\screenshots\\ "+tname + "_" + timeStamp + ".png";
		
		
		try {
			FileUtils.copyFile(source, new File(destination));
		
		}catch(IOException e) {
			e.getMessage();
		}
		return destination;
	}
	}	
		
		
	
	
	
	
	
	
	
	
	
	
	
	

