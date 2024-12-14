package practice.contacttest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
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

public class CreateContactWithSupportDateTest {

	public static void main(String[] args) throws Throwable {
		//read data from property file
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\data\\integration.properties");
		Properties p = new Properties();
		p.load(fis);
		String browser = p.getProperty("browser");
		String url = p.getProperty("url");
		String un = p.getProperty("username");
		System.out.println(un);
		String pwd = p.getProperty("password");
		System.out.println(pwd);

		//random number
		Random r = new Random();
		int count = r.nextInt(1000);

		//read data from excel file
		FileInputStream fis1 = new FileInputStream(".\\src\\test\\resources\\data\\testScriptdata3.xlsx");
		Workbook wb = WorkbookFactory.create(fis1);
		Sheet sh = wb.getSheet("org");
		Row row = sh.getRow(4);
		String lastname = row.getCell(2).getStringCellValue()+count;


		WebDriver driver = null;
		if(browser.equals("chrome")) {
			driver=new ChromeDriver();
		}else if (browser.equals("firefox")) {
			driver= new FirefoxDriver(); 	
		}
		else if(browser.equals("edge")) {
			driver= new EdgeDriver();
		}
		else {
			driver = new ChromeDriver();
		}


		driver.get("http://localhost:8888/");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		driver.findElement(By.name("lastname")).sendKeys(lastname);
		//date format
		java.util.Date dateobj = new java.util.Date();  
		System.out.println(dateobj.toString());
		SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
		String startdate = s.format(dateobj);
		System.out.println(startdate);

		//SimpleDateFormat s1 = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = s.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH,+30);
		String enddate = s .format(cal.getTime());
		System.out.println(enddate);
		Thread.sleep(3000);
		driver.findElement(By.name("support_start_date")).clear();
		driver.findElement(By.name("support_start_date")).sendKeys(startdate);
		driver.findElement(By.name("support_end_date")).clear();
		driver.findElement(By.name("support_end_date")).sendKeys(enddate);
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
		Thread.sleep(1000);
		String actdata = driver.findElement(By.xpath("//span[@class ='dvHeaderText']")).getText();
		if(actdata.contains(lastname)) {
			System.out.println(lastname + "is created and pass");
		}
		else
		{
			System.out.println(lastname + "is not created and fail");
			}
		String actstart = driver.findElement(By.id("dtlview_Support Start Date")).getText();
		if(actstart.equals(startdate)) {
			System.out.println(startdate + "is verified");	
		}
		else
		{
			System.out.println(startdate +"is not verified");
			}
			String actenddate = driver.findElement(By.id("dtlview_Support End Date")).getText();
		if(actenddate.equals(enddate)) {
			System.out.println(enddate + "is verified");	
		}
		else
		{
			System.out.println(enddate +"is not verified");
			}
		driver.quit();
		
	}

}
