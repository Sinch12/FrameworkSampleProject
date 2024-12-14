package readdata;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

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
import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

public class ReadDataFromxml {

		@Test 
				//public void SampleTest(XmlTest test) {
				//System.out.println("executed");
				//System.out.println(test.getParameter("Browser"));
				//System.out.println(test.getParameter("url"));
					
				public  void createorgTest(XmlTest test) throws FileNotFoundException, IOException, ParseException, InterruptedException{
					JSONParser  p = new JSONParser();
					Object obj = p.parse(new FileReader(".\\src\\test\\resources\\data\\appCommonData.json.json"));
					JSONObject map = (JSONObject)obj;
					//Object url = map.get("url");
					//System.out.println(url);
					//Object Browser = map.get("Browser");
					//System.out.println(Browser);
					String browser = test.getParameter("browser");
					System.out.println(browser);
					System.out.println(test.getParameter("url"));
					System.out.println(test.getParameter("username"));
					System.out.println(test.getParameter("password"));
					
					Random r =new Random();
					int count = r.nextInt(1000);
					
					FileInputStream fis1 = new FileInputStream(".\\src\\test\\resources\\data\\testScriptdata3.xlsx");
					Workbook wb = WorkbookFactory.create(fis1);
					String data = wb.getSheet("org").getRow(1).getCell(2).getStringCellValue()+count;
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
					driver.findElement(By.name("accountname")).sendKeys(data);
					driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
					Actions a = new Actions(driver);
					a.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
					Thread.sleep(2000);
					driver.findElement(By.linkText("Sign Out")).click();}}


