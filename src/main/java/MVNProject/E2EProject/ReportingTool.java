package MVNProject.E2EProject;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ReportingTool
{
	static ExtentReports extent;
	public static ExtentReports getReportDetails()
	{
		String ReportPath = System.getProperty("user.dir")+"/output.html";
		
		ExtentSparkReporter reports = new ExtentSparkReporter(ReportPath);
		reports.config().setReportName("Sample Automation Report");

		extent = new ExtentReports();
		extent.attachReporter(reports);
		extent.setSystemInfo("Tester", "Gourav");
		return extent;
	}
}