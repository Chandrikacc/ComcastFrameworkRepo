package practice_Test;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class SampleReportPrgram {
	public ExtentSparkReporter spark;
	public static ExtentReports report;
	@BeforeSuite()
	public void configBS() {
		spark=new ExtentSparkReporter("./AdvancedReport/report.html");
		spark.config().setDocumentTitle("CRM Test Suite Results");
		spark.config().setReportName("CRM Report");
		spark.config().setTheme(Theme.DARK);
		
		//Attach report, Add environmental information and create Test
		report=new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Windows-11");
		report.setSystemInfo("Browser", "Chrome-100");
	}
	@Test
	public void createContactTest() {
		WebDriver driver=new ChromeDriver();
		driver.get("http://localhost:8888");
		TakesScreenshot ts=(TakesScreenshot)driver;
		String filePath = ts.getScreenshotAs(OutputType.BASE64);
		
		ExtentTest test = report.createTest("createContactTest");
		
		test.log(Status.INFO, "login to app");
		test.log(Status.INFO, "navigate to Contact page");
		test.log(Status.INFO,"create contact");
		if("HFC".equals("HDFC")) {
			test.log(Status.PASS, "contact created");
		}
		else {
			test.log(Status.FAIL, "contact is not created");
			test.addScreenCaptureFromBase64String(filePath, "FailedScreenshot");
		}			
	}
	
	@AfterSuite()
	public void configAS(){
		report.flush();
	}

}
