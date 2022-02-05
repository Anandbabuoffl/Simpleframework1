package pageobjectmodel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Myinfopage {
	WebDriver driver;
	public Myinfopage(WebDriver d) {
		
	    driver=d;
		PageFactory.initElements(d, this);
	}
	
	@FindBy(id="btnSave") WebElement edit;
	@FindBy(id="personal_txtEmpFirstName") WebElement fname;
	@FindBy(id="personal_txtEmpMiddleName") WebElement mname;
	@FindBy(id="personal_txtEmpLastName") WebElement lname;
	
	
	public void edit() {
		edit.click();
		
	}
	
	public void setfanme(String fn) {
		fname.clear();
		fname.sendKeys(fn);
	}
	
	public void setManme(String mn) {
		mname.clear();
		mname.sendKeys(mn);
	}

	public void setLname(String ln) {
		lname.clear();
		lname.sendKeys(ln);
		
	}
}
