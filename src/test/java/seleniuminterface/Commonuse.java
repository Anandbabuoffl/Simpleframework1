package seleniuminterface;

import org.openqa.selenium.WebElement;

public interface Commonuse {
	
	void browsersetup();
	void desiredbrowsersetup(String desiredbrowser);
	String url(String url);
	WebElement element(String attribute,String value);
	void type(WebElement element,String text);
	void click(WebElement element);
	void close();
	

}
