package utilities;


import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testBase.BaseClass;

public class ExtentReportManager implements ITestListener {

    public ExtentSparkReporter sparkReporter;   //UI of the report
	public ExtentReports extent; //populate common info on the report 
	public ExtentTest test; // creating test case entries in the report and update status of the test methods
	
	
	String repName;
	 public void onStart(ITestContext context) {  // name and location of the report
		    
		 
		 String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());//time stamp
		 repName ="Test-Report-" + timeStamp +".html";
		 
		 
		 
		 sparkReporter = new ExtentSparkReporter (System.getProperty("user.dir")+".\\reports\\"+repName);
		 
		 sparkReporter.config().setDocumentTitle("OpenCart Automation Test report"); 
		 sparkReporter.config().setReportName("OpenCart Functional Testing");
		 sparkReporter.config().setTheme(Theme.DARK);
		 
		extent =new ExtentReports();
		extent.attachReporter(sparkReporter);
		
		extent.setSystemInfo("computer Name", "localhost");
		extent.setSystemInfo("Environment","QA");
		
		extent.setSystemInfo("Tester Name","Parida");
		extent.setSystemInfo("OS","Windows11");
		extent.setSystemInfo("Browser name","Chrome,FIrefox,Edge");
		
		 
	 }
		 
	
	
	public void onTestSuccess(ITestResult result) {
	   
		test = extent.createTest(result.getName());
		test.log(Status.PASS, "Test case Passed is:"+ result.getName());
		
	  }
	
	
	public void onTestFailure(ITestResult result) {
		test = extent.createTest(result.getName());
		test.log(Status.FAIL, "Test case Failed is:"+ result.getName());
		test.log(Status.FAIL, "Test case Failed cause is:"+ result.getThrowable());
	 
	try {
		String imgPath = new BaseClass().CaptureScreen(result.getName());
		test.addScreenCaptureFromPath(imgPath);
		}catch(Exception e1){
			e1.printStackTrace();
		}
	
	}

	
	public void onTestSkipped(ITestResult result) {
		test = extent.createTest(result.getName());
		test.log(Status.SKIP, "Test case SKIPPED is:"+ result.getName());
		
	  }
	
	
	
	 
	 public  void onFinish(ITestContext context) {
		   extent.flush();
		  }
}

