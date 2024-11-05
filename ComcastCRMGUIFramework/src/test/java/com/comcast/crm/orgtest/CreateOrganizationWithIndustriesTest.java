package com.comcast.crm.orgtest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class CreateOrganizationWithIndustriesTest 
{
public static void main(String[] args) throws InterruptedException, FileNotFoundException, IOException, ParseException 
{
	
	// step1 : get the java representation object of the physical file
		FileInputStream fis = new FileInputStream("./configAppData/Commondata.properties");
	// step 2  using properties class, load all the keys
	
				Properties pobj=new Properties();
				pobj.load(fis);
			
				//step:3 Read the Data using getProperty method
				String BROWSER =pobj.getProperty("browser");
				String URL =pobj.getProperty("url");
				String USERNAME =pobj.getProperty("username");
				String PASSWORD=pobj.getProperty("password");
				

			
			//generate the random Number
			Random random =new Random();
			int randomInt=random.nextInt(1000);
			
			
			
			// Read TestScript data from Excel file
			FileInputStream fs = new FileInputStream("./testData/TestScriptData.xlsx");
			Workbook wb = WorkbookFactory.create(fs);
		     Sheet sh=wb.getSheet("org1");
			     Row row=sh.getRow(4);
			     String orgName = row.getCell(2).toString() +randomInt;
			     String industry = row.getCell(3).toString(); // this is static we donot use random number
			     String type = row.getCell(4).toString(); 
				 System.out.println(orgName);
			
			wb.close();
			
		
			WebDriver driver=null;
			
			if(BROWSER.equals("chrome"))
			{
				
				driver=new ChromeDriver();
				
			}
				else if(BROWSER.equals("firefox"))
				{
					driver=new FirefoxDriver();
			}
				else if(BROWSER.equals("edge"))
				{
					driver=new EdgeDriver();
				}
				else
				{
					driver=new ChromeDriver();
				}
			
			System.out.println(BROWSER);
			
 // step1: login to the Application
	driver.get(URL);
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.findElement(By.name("user_name")).sendKeys(USERNAME);
	driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
	driver.findElement(By.id("submitButton")).click();
	
	//Thread.sleep(2000);
	driver.findElement(By.linkText("Organizations")).click();
	

	// Step:3 click on "Create Organization " Button
	
	driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
	
	// Step 4 enter all the details and create new Organization
	
	driver.findElement(By.name("accountname")).sendKeys(orgName);
	Thread.sleep(2000);
	WebElement wbselec1=  driver.findElement(By.name("industry"));
	Select sell1 =new Select(wbselec1);
	sell1.selectByVisibleText(industry);
	
	WebElement wbselec2=  driver.findElement(By.name("accounttype"));
	
	Select sell2 =new Select(wbselec2);
	sell2.selectByVisibleText(type);
	
	
	driver.findElement(By.name("button")).click();
	Thread.sleep(2000);
	
	// verify the drop down industry and type info
	String actIndustries=driver.findElement(By.id("dtlview_Industry")).getText();
	if(actIndustries.equals(industry))
	{
		System.out.println(industry + " information is verified == PASS");
		}
	else
	{
		System.out.println(industry+ " information is not verifed == FAIL");
	}
	
	
	String actType=driver.findElement(By.id("dtlview_Type")).getText();
	if(actType.equals(type))
	{
		System.out.println(type + " information is verified == PASS");
		}
	else
	{
		System.out.println(type+ " information is not verifed == FAIL");
	}
	
	// Step :5 logout
driver.quit();

	
	
	
	
}
}
