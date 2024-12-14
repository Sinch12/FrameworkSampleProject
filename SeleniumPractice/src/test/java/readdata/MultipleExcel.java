package readdata;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class MultipleExcel {

	public static void main(String[] args) throws Throwable {
FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\data\\testScriptdata3.xlsx");
Workbook wb = WorkbookFactory.create(fis);
//int count =wb.getSheet("org").getLastRowNum();
//for (int i = 0; i <=count; i++) {
	Sheet sh = wb.getSheet("org");
			Row row = sh.getRow(0);
	Cell cel = row.getCell(1);
	//cel.get
	//System.out.println(data);
	
}
	}


