import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Writebacktoexcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\data\\testScriptdata3.xlsx");
Workbook wb = WorkbookFactory.create(fis);
wb.getSheet("org").getRow(1).createCell(4).setCellValue("abc");
FileOutputStream fos= new FileOutputStream(".\\src\\test\\resources\\data\\testScriptdata3.xlsx");
wb.write(fos);
wb.close();

	}

}
