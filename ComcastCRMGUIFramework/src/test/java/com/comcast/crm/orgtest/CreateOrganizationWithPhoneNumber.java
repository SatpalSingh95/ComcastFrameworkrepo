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
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class CreateOrganizationWithPhoneNumber 
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
			     Row row=sh.getRow(7);
			     String orgName = row.getCell(2).toString() +randomInt;
			     String phoneNumber = row.getCell(3).getStringCellValue();
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
	
	// phone number
	driver.findElement(By.id("phone")).sendKeys(phoneNumber);
	
	
	
	driver.findElement(By.name("button")).click();
	Thread.sleep(2000);
	
	
	// verify header phone Number info Expected Result

	
	String actPhoneNumber = driver.findElement(By.id("dtlview_Phone")).getText();
	if(actPhoneNumber.trim().contains(phoneNumber))
	{
		System.out.println(phoneNumber + "is created == PASS");
		}
	else
	{
		System.out.println(phoneNumber + "is not created == FAIL");
	}
	Thread.sleep(2000);
	/*
	 * // verify header message info Expected Result

	
	String headerInfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	if(headerInfo.trim().contains(orgName))
	{
		System.out.println(orgName + "is verified == PASS");
		}
	else
	{
		System.out.println(orgName + "is not verified == FAIL");
	}
	// verify header orgName info Expected Result

	
	String actOrgName = driver.findElement(By.id("dtlview_Organization Name")).getText();
	if(actOrgName.trim().contains(orgName))
	{
		System.out.println(orgName + "is verified == PASS");
		}
	else
	{
		System.out.println(orgName + "is not verified == FAIL");
	}
	 * 
	 * 
	 * 
	 */
	
	
	// Step :5 logout
driver.quit();

	
	
	
	
}
}
