package practice.orgtest;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.xml.XmlTest;

public class CreateOrganizationTest {

	public static void main(String[] args) throws InterruptedException, EncryptedDocumentException, IOException {
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
			String data = wb.getSheet("org").getRow(1).getCell(2).getStringCellValue()+count;
			wb.close();
			WebDriver driver = null;
			if(browser.equals("chrome")) {
				driver=new ChromeDriver();
			}else if(browser.equals("firefox")) {
				driver=new FirefoxDriver();}
				else if(browser.equals("edge")) {
					driver=new EdgeDriver();
				}else {
					driver= new   ChromeDriver();
				}
			driver.get("http://localhost:8888/");
			driver.findElement(By.name("user_name")).sendKeys("admin");
			driver.findElement(By.name("user_password")).sendKeys("admin");
			driver.findElement(By.id("submitButton")).click();
			driver.findElement(By.linkText("Organizations")).click();
			driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
			driver.findElement(By.name("accountname")).sendKeys(data);
			driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
			Thread.sleep(3000);
			String headerinfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
			if(headerinfo.contains(data)) {
				System.out.println(data + "is created==pass");
			}else {
				System.out.println(data + "is not created==fail");
			}
			String actorgname = driver.findElement(By.id("dtlview_Organization Name")).getText();
			if(actorgname.equals(data)) {
				System.out.println(data + "is created==pass");
			}else {
				System.out.println(data + "is not created==fail");
			
			
			
			
			//Actions a = new Actions(driver);
			//a.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
			//Thread.sleep(2000);
			//driver.findElement(By.linkText("Sign Out")).click();
	}}}

//span[@class='dvHeaderText']
