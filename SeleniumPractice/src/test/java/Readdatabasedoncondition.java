import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Readdatabasedoncondition {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\data\\testScriptdata3.xlsx");
Workbook wb = WorkbookFactory.create(fis);
int count = wb.getSheet("org").getLastRowNum();
System.out.println(count);
String expectedcondition = "TC-02";
String data1=" " ;
String data2 =" ";
String data3 =" ";
boolean flag=false;
for (int i = 0; i <=count; i++) {
	String data=" ";
	try {
	 data = wb.getSheet("org").getRow(i).getCell(0).getStringCellValue();
	 if(data.equals(expectedcondition)) {
		 data1 = wb.getSheet("org").getRow(i).getCell(1).getStringCellValue();
		 data2 = wb.getSheet("org").getRow(i).getCell(2).getStringCellValue();
		 data3 = wb.getSheet("org").getRow(i).getCell(3).getStringCellValue();
		 
	 }
	}catch (Exception e) {
	}}if(flag==true) {
	//System.out.println(data);
	System.out.println(data1);
	System.out.println(data2);
	System.out.println(data3);
	}
	else
	{
		System.out.println("not available ");
	}
	
	

 
	}

}
