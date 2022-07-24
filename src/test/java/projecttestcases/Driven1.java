package projecttestcases;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Driven1 {
	
	public Object[][] dd() throws FileNotFoundException {
		File src=new File("C:/Users/bbuanan/Music/Test2.xlsx");
		FileInputStream fis=new FileInputStream(src);
		XSSFWorkbook wb=new XSSFWorkbook();
		XSSFSheet sheet=wb.getSheet("sheettest");
	    int rows= sheet.getPhysicalNumberOfRows();
		XSSFRow r= sheet.getRow(rows);
		int cells=r.getPhysicalNumberOfCells();
	
		
		Object[][] testlogin=new Object[rows][cells];
		
		for(int i=0;i<rows;i++) {
			for(int j=0;j<cells;j++)
			{
				
			}
		}
		return testlogin;
		
	}
}
