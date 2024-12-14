package practice.orgtest;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
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

public class Dummyorg {

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
Row row = sh.getRow(1);
String cel = row.getCell(2).getStringCellValue()+count;


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


 driver = new ChromeDriver();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
driver.get(url);
driver.findElement(By.name("user_name")).sendKeys(un);
driver.findElement(By.name("user_password")).sendKeys(pwd);
driver.findElement(By.id("submitButton")).click();
Thread.sleep(2000);
driver.findElement(By.linkText("Organizations")).click();
driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
driver.findElement(By.name("accountname")).sendKeys(cel);
Thread.sleep(1000);
driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
Thread.sleep(1000);
String actdata = driver.findElement(By.xpath("//span[@class ='dvHeaderText']")).getText();
if(actdata.contains(cel)) {
	System.out.println(cel + "is created and pass");
}
else
{
	System.out.println(cel + "is not created and fail");
	}
String actorgname = driver.findElement(By.id("dtlview_Organization Name")).getText();
if(actorgname.equals(cel)) {
	System.out.println(cel + "is verified");	
}
else
{
	System.out.println(cel +"is not verified");
	}
driver.quit();







	}

}
