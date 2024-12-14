import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Readexcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\data\\testScriptdata3.xlsx");
Workbook wb = WorkbookFactory.create(fis);
String data = wb.getSheet("org").getRow(1).getCell(2).getStringCellValue();
System.out.println(data);
	}

}
