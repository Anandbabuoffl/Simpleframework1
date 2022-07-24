package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import projecttestcases.Base;

public class Listnerandreports extends Base implements ITestListener {
	ExtentReports extent;
	ExtentTest test;
	SimpleDateFormat format;

	

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("Test is started");
		test = extent.createTest(result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, " " + result.getMethod().getMethodName() + " is passed");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL, "" + result.getMethod().getMethodName() + " is failure");
		test.log(Status.FAIL, result.getThrowable());
		
		
		format = new SimpleDateFormat("MM-dd-yyyy hh-mm-ss");
		Date date = new Date();
		String actuallytimedate = format.format(date);
		File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String storescreenshot = ("./Screenshots/screenshot " + result.getMethod().getMethodName() + actuallytimedate +".png");
		File destination = new File(storescreenshot);
		try {
			FileUtils.copyFile(source, destination);
		} catch (IOException e) {
			e.printStackTrace();
		}
		test.addScreenCaptureFromPath(storescreenshot, "Test fail");

	}

	@Override
	public void onTestSkipped(ITestResult result) {

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {

	}

	@Override
	public void onStart(ITestContext context) {

		// extent=Reports.Onstart();

		format = new SimpleDateFormat("MM-dd-yyyy hh-mm-ss");
		Date date = new Date();
		String actualdate = format.format(date);

		ExtentSparkReporter spark = new ExtentSparkReporter("./ExtentReports/testreport "+actualdate+ ".html");
		extent = new ExtentReports();
		extent.attachReporter(spark);
        extent.setSystemInfo("Host name", "local host");
        extent.setSystemInfo("Environment", "DA");
        extent.setSystemInfo("user", "Anand");
        
        spark.config().setDocumentTitle("Simple Framwork");
        spark.config().setReportName("Functional tests");
        spark.config().setTheme(Theme.DARK);
        
	}

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
	}

}
