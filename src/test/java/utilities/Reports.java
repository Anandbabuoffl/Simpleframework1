package utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Reports  {

	
	public static ExtentReports Onstart() 
	{
	   SimpleDateFormat format = new SimpleDateFormat("mm-dd-yyyy hh-mm-ss");
		Date date = new Date();
		String actualdate = format.format(date);

		ExtentSparkReporter spark = new ExtentSparkReporter
				("./testreport"+actualdate+".html");
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(spark);
		/*
		 * ExtentTest test=extent.createTest("Test"); test.log(Status.PASS, "Test");
		 * //extent.flush();
		 */	
		return extent;
		}

}
