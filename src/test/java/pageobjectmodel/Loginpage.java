package pageobjectmodel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage  {
WebDriver driver;

@FindBy(id="txtUsername") WebElement firstname; 
@FindBy(id="txtPassword") WebElement password;
@FindBy(id="btnLogin") WebElement login;
@FindBy(id="menu_pim_viewMyDetails")WebElement info;

//Initialize all page objects for given driver instance
public Loginpage(WebDriver d) {
	driver=d;
	PageFactory.initElements(d,this);
}

public void setfname(String fname) {
firstname.sendKeys(fname);
}

public void password(String password1) {
	password.sendKeys(password1);
}

public void login() {
	login.click();
}

public void myinfo() {
	info.click();
}
public String gettitle() {
	String title=driver.getTitle();
	return title;
}
 
}