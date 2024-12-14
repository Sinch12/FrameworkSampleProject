import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Amazon_excel {

	public static void main(String[] args) throws InterruptedException, EncryptedDocumentException, IOException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.className("Pke_EE")).sendKeys("iphone14 promax");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(3000);
		List<WebElement> allname = driver.findElements(By.xpath("//div[contains(@class,'KzDlHZ')]"));//name
		List<WebElement> allprice = driver.findElements(By.xpath("//div[contains(text(),'₹1,')]"));//price
		System.out.println(allname.size());
		System.out.println(allprice.size() );
		for (int i = 0; i <allname.size(); i++) {
			String text1 = allname.get(0).getText();
			String text2 = allprice.get(1).getText();
		
			//System.out.println(text1+ "==>"+ text2);
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\data\\testScriptdata3.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Sheet2");
		for (int j = 0; j <allname.size(); j++) {	
		Row row = sh.createRow(i);
		
		Cell cel = row.createCell(1);
		cel.setCellType(CellType.STRING);
		cel.setCellValue(text1+"\t"+ "\t"+text2);
		FileOutputStream fos = new FileOutputStream(".\\src\\test\\resources\\data\\testScriptdata3.xlsx");
		wb.write(fos);
		wb.close();}
		System.out.println("executed");
		}
		
		}

	}


