package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class Readconfig {

	Properties pro;
	
	public Readconfig() {
		File src=new File("./configurationfile/config.properties");
		try {
		FileInputStream fis=new FileInputStream(src);
		pro=new Properties();
		pro.load(fis);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public String geturl() {
		 String url=pro.getProperty("appurl");
		return url;
		 
	}
	
	public String getusername() {
		 String username=pro.getProperty("appusername");
		return username;
		 
	}
	
	public String getpassword() {
		 String password=pro.getProperty("apppassword");
		return password;
		 
	}
}
