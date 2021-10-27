package MVNProject.E2EProject;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class Listeners extends base implements ITestListener
{
	WebDriver driver = null;
	ExtentReports extent = ReportingTool.getReportDetails();
	ExtentTest test;
	//ThreadLocal<ExtentTest> threadSafe = new ThreadLocal<ExtentTest>();
	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getMethod().getMethodName());
		//threadSafe.set(test);
	}

	public void onTestSuccess(ITestResult result) {
		//threadSafe.set() instead of test to make it thread safe
		test.pass(result.getMethod().getMethodName());
		
	}

	public void onTestFailure(ITestResult result) {
		//threadSafe.set() instead of test to make it thread safe
		test.fail(result.getThrowable());
		String testname = result.getMethod().getMethodName();
		
		try
		{
			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (Exception e)
		{
			e.printStackTrace();
		} 
		
		try {
			//threadSafe.set() instead of test to make it thread safe
			test.addScreenCaptureFromPath(getScreenshot(testname, driver),testname);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		extent.flush();
		
	}
	
}
