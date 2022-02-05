package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.eventusermodel.XSSFSheetXMLHandler;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Datadrivenfile {

	static FileInputStream fis;
	static XSSFWorkbook wb;
	static XSSFSheet sheet;
	static XSSFRow rows;
	static XSSFCell cells;

	public static int rowcounts(String file, int xlsindex) throws IOException {
		fis = new FileInputStream(file);
		wb = new XSSFWorkbook(fis);
		sheet = wb.getSheetAt(xlsindex);
		int rowcounts = sheet.getPhysicalNumberOfRows();
		wb.close();
		fis.close();
		return rowcounts;
	}

	public static int columncounts(String file, int xlsindex, int rows) throws IOException {
		fis = new FileInputStream(file);
		wb = new XSSFWorkbook(fis);
		sheet = wb.getSheetAt(xlsindex);
		XSSFRow row = sheet.getRow(rows);
		int cellcounts = row.getPhysicalNumberOfCells();
		wb.close();
		fis.close();
		return cellcounts;

	}

	public static  String getcelldata(String file, int xlsindex, int rows, int columns) throws IOException {
		fis = new FileInputStream(file);
		wb = new XSSFWorkbook(fis);
		sheet = wb.getSheetAt(xlsindex);
		XSSFRow row = sheet.getRow(rows);
		XSSFCell cells = row.getCell(columns);
		DataFormatter formatter = new DataFormatter();
		String celldata = formatter.formatCellValue(cells);
		wb.close();
		fis.close();
		return celldata;

	}

}
