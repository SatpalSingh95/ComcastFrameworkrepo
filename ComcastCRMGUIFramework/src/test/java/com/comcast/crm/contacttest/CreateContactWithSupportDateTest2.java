package com.comcast.crm.contacttest;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
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

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.objectrepositoryutility.ContactPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;

public class CreateContactWithSupportDateTest2 
{
	
public static void main(String[] args) throws InterruptedException, IOException 
{
	

	// Create object
		FileUtility fLib=new FileUtility();
		ExcelUtility eLib=new ExcelUtility();
		JavaUtility jLib=new JavaUtility();
	// get data from excel
		String BROWSER = fLib.getDataFromPropertiesFile("browser");
		String URL = fLib.getDataFromPropertiesFile("url");
		String USERNAME =  fLib.getDataFromPropertiesFile("username");
		String PASSWORD =  fLib.getDataFromPropertiesFile("password");

				// Read TestScript data from Excel file
				String lastName =eLib.getDataFromExcel("contact", 4, 2)+jLib.getRandomNumber();
		
			
 
	// login to app
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
			
				// login to the Application
				driver.get(URL);
				Thread.sleep(2000);
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
				driver.findElement(By.name("user_name")).sendKeys(USERNAME);
				driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
				driver.findElement(By.id("submitButton")).click();
				
				// Navigate the Contact module
				//Thread.sleep(2000);
				driver.findElement(By.linkText("Contacts")).click();
				

				// Step:3 click on "Create Contacts " Button
				
				driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
				
// enter all the details and create new contact
	String startDate=jLib.getSystemDateyyyyMMdd();
	String endDate=jLib.getRequiredDateyyyyMMdd(30);
	driver.findElement(By.name("lastname")).sendKeys(lastName);

	driver.findElement(By.name("support_start_date")).clear();
     driver.findElement(By.name("support_start_date")).sendKeys(startDate);
     
     driver.findElement(By.name("support_end_date")).clear();
     driver.findElement(By.name("support_end_date")).sendKeys(endDate);
	
	// phone number
	//driver.findElement(By.id("phone")).sendKeys(lastName);
	
	
	
	driver.findElement(By.name("button")).click();
	Thread.sleep(2000);
	
	// driver.switchTo().alert().accept();
	// verify header phone Number info Expected Result

	
	String actStartDate = driver.findElement(By.id("dtlview_Support Start Date")).getText();
	System.out.println(actStartDate);
	if(actStartDate.trim().equals(startDate))
	{
		System.out.println(startDate + " information is verified == PASS");
		}
	else
	{
		System.out.println(startDate + "is not verified == FAIL");
	}
	Thread.sleep(2000);
	
	String actendDate = driver.findElement(By.id("dtlview_Support End Date")).getText();
	System.out.println(actendDate);
	if(actendDate.trim().equals(endDate))
	{
		System.out.println(endDate + "information is  verified == PASS");
		}
	else
	{
		System.out.println( endDate+ "information is not verified == FAIL");
	}
	
	// Step :5 logout
	driver.quit();
	
	
		
}



}