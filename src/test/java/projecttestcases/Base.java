package projecttestcases;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.Readconfig;

public class Base { // public class Base implements Common use;this is for interface

	public static WebDriver driver;
	public static Logger log;
	Readconfig rc = new Readconfig();
	
	
	
	public String baseurl = rc.geturl();
	public String username = rc.getusername();
	public String password = rc.getpassword();
	

	@Parameters("browser")
	@BeforeSuite
	public void desiredbrowsersetup(String desiredbrowser) {
		log= LogManager.getLogger(Base.class.getName());
		switch (desiredbrowser) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			 driver = new ChromeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		default:
			System.out.println("Driver is not found");
			break;
		}
		driver.get(baseurl);
		driver.manage().window().maximize();
		log.info("Application page");
		
	}

	public static void addscreenshot(WebDriver driver, String testname) throws IOException {
		SimpleDateFormat sm = new SimpleDateFormat("MM-dd-yyyymm-hh-ss");
		Date date = new Date();
		String actualtime = sm.format(date);
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String storescreenshot = "./Screenshot" + testname + actualtime + "./png";
		File des = new File(storescreenshot);
		FileUtils.copyFile(src, des);
	}

	public String getrandomemail(int digits) {
		String emailids=RandomStringUtils.randomAlphabetic(digits);
		return emailids;
	}
	public String getrandomephonenumbers(int digits) {
		String phonenum=RandomStringUtils.randomNumeric(digits);
		return phonenum;
	}
	
	@AfterSuite
	public void teardown() {
		driver.quit();
	}

}