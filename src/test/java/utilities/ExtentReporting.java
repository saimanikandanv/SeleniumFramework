package utilities;

import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporting {
	
	public static ExtentSparkReporter reporter;
	public static ExtentReports reports;
	
	public static ExtentReports configReports()
	{
		String reportpath=System.getProperty("user.dir")+"\\Reports\\index.html";
		reporter = new ExtentSparkReporter(reportpath);
		reporter.config().setDocumentTitle("Test NG Demo");
		reporter.config().setReportName("Test Results");
		reports=new ExtentReports();
		reports.attachReporter(reporter);
		return reports;
	}

}
