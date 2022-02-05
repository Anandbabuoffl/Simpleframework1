package projecttestcases;

import org.testng.annotations.Test;

import pageobjectmodel.Myinfopage;

public class MyfopageTC3 extends Base {
	
	@Test
	public void myfodetail() {
		Myinfopage info=new Myinfopage(driver);
		info.edit();
		info.setfanme("Anand");
		info.setManme("babu");
		info.setLname("c");
	}

}
