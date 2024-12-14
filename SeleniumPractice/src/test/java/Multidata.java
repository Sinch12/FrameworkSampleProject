import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Multidata {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
FileInputStream fis=new FileInputStream("C:\\Users\\Sinchana K S\\eclipse-workspace\\Readexceldata\\src\\test\\resources\\data\\testScriptdata2.xlsx");
Workbook wb = WorkbookFactory.create(fis);
int rownum = wb.getSheet("Sheet1").getLastRowNum();
System.out.println(rownum);
for(int i = 1;i<=rownum;i++) {
	String data = wb.getSheet("Sheet1").getRow(i).getCell(0).getStringCellValue();
	String data1 = wb.getSheet("Sheet1").getRow(i).getCell(1).getStringCellValue();
System.out.println (data+" "+ data1);

	}
	}
}
