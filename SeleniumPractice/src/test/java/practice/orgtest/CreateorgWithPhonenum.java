package practice.orgtest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CreateorgWithPhonenum {

	public static void main(String[] args) throws InterruptedException, Throwable {
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
			Row row = sh.getRow(7);
			String orgname = row.getCell(2).getStringCellValue()+count;
			String phonenum = row.getCell(3).getStringCellValue().toString();
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
			driver.findElement(By.name("accountname")).sendKeys(orgname);
			driver.findElement(By.id("phone")).sendKeys(phonenum);
			driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
			Thread.sleep(3000);
			String actphn = driver.findElement(By.id("dtlview_phone")).getText();
			if(actphn.contains(phonenum)) {
				System.out.println(phonenum + "is created==pass");
			}else {
				System.out.println(phonenum + "is not created==fail");
			}}}
			/*String actorgname = driver.findElement(By.id("dtlview_Organization Name")).getText();
			if(actorgname.equals(data)) {
				System.out.println(data + "is created==pass");
			}else {
				System.out.println(data + "is not created==fail");
	}

}

	private static Object getRow(int i) {
		// TODO Auto-generated method stub
		return null;
	}}*/
