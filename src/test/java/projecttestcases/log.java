package projecttestcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

;

public class log {
static Logger log=LogManager.getLogger(log.class);
	public static void main(String[] args)
	{
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://howtodoinjava.com/log4j2/log4j2-xml-configuration-example/");
		log.info("test");
	}

}
