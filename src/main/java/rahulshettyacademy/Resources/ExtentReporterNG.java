package rahulshettyacademy.Resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporterNG {

	
	public static ExtentReports getReportObject() {
		String path = System.getProperty("user.dir") + "//reports//index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);	
		reporter.config().setDocumentTitle("Simple Automation Report");
		reporter.config().setReportName("Test Report");
		reporter.config().setTheme(Theme.STANDARD);
		
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Debashree Dutta");
		return extent;
		
		
	}
}
