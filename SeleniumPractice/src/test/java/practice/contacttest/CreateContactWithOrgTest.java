package practice.contacttest;

import java.io.FileInputStream;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CreateContactWithOrgTest {

	public static void main(String[] args) throws Throwable {
		//create organisation
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
		Sheet sh = wb.getSheet("contact");
		Row row = sh.getRow(7);
		String orgname = row.getCell(2).getStringCellValue()+count;
		String lastname = row.getCell(3).getStringCellValue()+count;
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
		driver.findElement(By.name("accountname")).sendKeys(orgname);
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
		Thread.sleep(3000);
		String headerinfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(headerinfo.contains(orgname)) {
			System.out.println(orgname + "is created==pass");
		}else {
			System.out.println(orgname + "is not created==fail");
		}
		String actorgname = driver.findElement(By.id("dtlview_Organization Name")).getText();
		if(actorgname.equals(orgname)) {
			System.out.println(orgname + "is created==pass");
		}else {
			System.out.println(orgname + "is not created==fail");
		}
		//create contact
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		driver.findElement(By.name("lastname")).sendKeys(lastname);
		driver.findElement(By.xpath("//input[@name = 'account_name']/following-sibling::img")).click();

		//switch to child window
		Set<String> wh = driver.getWindowHandles();
		Iterator<String> it = wh.iterator();
		while(it.hasNext()){
			String wh1 = it.next();//capture the program
			driver.switchTo().window(wh1);
			String acturl = driver.getCurrentUrl();
			if(acturl.contains("module=Accounts")) {
				break;
			}


		}
		driver.findElement(By.id("search_txt")).sendKeys(orgname);
		driver.findElement(By.name("search")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='"+orgname+"']")).click();
		Thread.sleep(2000);
		//switch to parent window
		Set<String> wh1 = driver.getWindowHandles();
		Iterator<String> it1 = wh1.iterator();
		while(it1.hasNext()){
			String wh2 = it1.next();//capture the program
			driver.switchTo().window(wh2);
			String acturl = driver.getCurrentUrl();
			if(acturl.contains("Contacts&action")) {
				break;
			}}
		System.out.println("-----------------------");
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
		Thread.sleep(2000);
		String headerinfo1 = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		System.out.println(headerinfo1);
		System.out.println(lastname);
		Thread.sleep(1000);
		if(headerinfo1.contains(lastname)) {
			System.out.println(lastname + "is created==pass");
		}else {
			System.out.println(lastname + "is not created==fail");
		}
		String actorgname1 = driver.findElement(By.id("mouseArea_Organization Name")).getText();
		if(actorgname1.trim().equals(orgname)) {
			System.out.println(orgname + "is created==pass");
		}else {
			System.out.println(orgname + "is not created==fail");

		}
		driver.close();
	}
	}
