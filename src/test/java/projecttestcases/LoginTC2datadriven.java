package projecttestcases;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageobjectmodel.Loginpage;
import utilities.Datadrivenfile;

public class LoginTC2datadriven extends Base {

	@Test(dataProvider="login")
	public void login(String uname,String pasd) {
		Loginpage lp=new Loginpage(driver);
		lp.setfname(uname);
		lp.password(pasd);
		lp.login();
		driver.navigate().to(baseurl);
	}
	
	@DataProvider(name="login")
	
	public Object[][] getadata() throws IOException {
		
		String filepath="C:\\Users\\bbuanan\\eclipse-workspace\\SimpleTestFramework\\src\\test\\java\\testdata\\Test.xlsx";
		int rows=Datadrivenfile.rowcounts(filepath, 0);
	    int column=	Datadrivenfile.columncounts(filepath, 0, 1);
		
		Object[][] logindata=new Object[rows][column];
		
		for(int i=0;i<rows;i++) {
			for(int j=0;j<column;j++) {
				logindata[i][j]=Datadrivenfile.getcelldata(filepath, 0, i,j);
			}
		}
		return logindata;
		
	}
}
