package practice.orgtest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateOrganizationwithindustriesTest {

	public static void main(String[] args) throws EncryptedDocumentException, IOException, InterruptedException {
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\data\\integration.properties");
		Properties p = new Properties();
		p.load(fis);
		String browser = p.getProperty("browser");
		String url = p.getProperty("url");
		String un = p.getProperty("username");
		String pwd = p.getProperty("password");
				
			Random r =new Random();
			int count = r.nextInt(1000);
			
			FileInputStream fis1 = new FileInputStream(".\\src\\test\\resources\\data\\testScriptdata3.xlsx");
			Workbook wb = WorkbookFactory.create(fis1);
			 Sheet sh = wb.getSheet("org");
					Row row = sh.getRow(4);
					String cell = row.getCell(2).getStringCellValue();
					String industry = row.getCell(3).getStringCellValue();
					String type = row.getCell(4).getStringCellValue();
			wb.close();
			WebDriver driver = null;
			if(browser.equals("chrome")) {
				driver=new ChromeDriver();
			}else if(browser.equals("firefox")) {
				driver=new FirefoxDriver();}
				else if(browser.equals("edge")) {
					driver=new EdgeDriver();
				}else {
					driver= new ChromeDriver();
				}
			driver.get("http://localhost:8888/");
			driver.findElement(By.name("user_name")).sendKeys("admin");
			driver.findElement(By.name("user_password")).sendKeys("admin");
			driver.findElement(By.id("submitButton")).click();
			driver.findElement(By.linkText("Organizations")).click();
			driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
			driver.findElement(By.name("accountname")).sendKeys(cell);
			WebElement ind = driver.findElement(By.name("industry"));
			Select s = new Select(ind);
			s.selectByVisibleText(industry);
			
			WebElement ind1 = driver.findElement(By.name("accounttype"));
			Select s1 = new Select(ind1);
			s1.selectByVisibleText(type);
			
			driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
			Thread.sleep(2000);
			String actindname = driver.findElement(By.id("dtlview_Industry")).getText();
			if(actindname.equals(industry)) {
				System.out.println(industry + "is created==pass");
			}else {
				System.out.println(industry + "is not created==fail");
	}
			String acttype = driver.findElement(By.id("dtlview_Type")).getText();
			if(acttype.equals(type)) {
				System.out.println(type + " is verified==pass");
			}else {
				System.out.println(type + " is not verified==fail");
			
	}}	}
			/*String headerinfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
			if(headerinfo.contains(cell)) {
				System.out.println(cell + "is created==pass");
			}else {
				System.out.println(cell + "is not created==fail");
			}
			String actorgname = driver.findElement(By.id("dtlview_Organization Name")).getText();
			if(actorgname.equals(cell)) {
				System.out.println(cell + "is created==pass");
			}else {
				System.out.println(cell + "is not created==fail");
	}

}}*/
