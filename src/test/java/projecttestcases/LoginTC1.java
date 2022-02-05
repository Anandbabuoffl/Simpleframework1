package projecttestcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjectmodel.Loginpage;

public class LoginTC1 extends Base {
    
    Loginpage lp;
    

    @Test(priority=1)
	public void login() {
	    lp=new Loginpage(driver);
		lp.setfname(username);
		lp.password(password);
		lp.login();
	}
	
	@Test(priority = 2 ,enabled=true)
	public void myinfo() {
		lp.myinfo();	
}

	@Test(priority=3)
	public void getpagetitle() throws IOException {
		String actualtitle=lp.gettitle();
		System.out.println(actualtitle);
		String expectedtitle="OrangeHRM";
		Assert.assertEquals(actualtitle, expectedtitle);
		Base.addscreenshot(driver,"getpagetitle");
	}
	
}
