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
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.objectrepositoryutility.CreateNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.crm.objectrepositoryutility.OrganizationInfoPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;

public class CreateOrganizationTest 
{
public static void main(String[] args) throws InterruptedException, FileNotFoundException, IOException, ParseException 
{
	// Create object
	FileUtility fLib=new FileUtility();
	ExcelUtility eLib=new ExcelUtility();
	JavaUtility jLib= new JavaUtility();
// get data from excel
	String BROWSER = fLib.getDataFromPropertiesFile("browser");
	String URL = fLib.getDataFromPropertiesFile("url");
	String USERNAME =  fLib.getDataFromPropertiesFile("username");
	String PASSWORD =  fLib.getDataFromPropertiesFile("password");



	// Read TestScript data from Excel file
			String orgName =eLib.getDataFromExcel("org1", 1, 2)+jLib.getRandomNumber();
	WebDriver driver = null;
		
			
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
			
    // step 1 login to application
	driver.get(URL);
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	
	// This static initElements always required two Objects the first one is driver object it means when we run this program this 
	// program is going to launch a program that browser session ID we have to pass because the Page Factory will initialize the
	// Element in the run time.the page factory should know which browser i want to initialize elements.that is the reason we have to  
	// pass the driver object and which pom class we have to initialize that you have to pass that is second argument  because there is so many 
	// POM classes.so we have to tell page factory go and initialize this page. so this pagefactory load all the elements in the current 
	//address. it will return the object of POM class.
	
	
	// we do not write this line because have to write in each script. We simplify this.
//	LoginPage lp = PageFactory.initElements(driver,LoginPage.class);
	
	/*lp.getUsernameEdit().sendKeys("admin");
	lp.getPasswordEdit().sendKeys("admin");
	lp.getLoginBtn().click();;
	*/
	
	LoginPage lp=new LoginPage(driver);
	lp.loginToapp(USERNAME,PASSWORD,URL);
	
	// navigate to Home page
	
HomePage hp= new HomePage(driver);
hp.getOrgLink().click();

// Create  organization

OrganizationsPage cnp=new OrganizationsPage(driver);
cnp.getCreateNewOrgBtn().click();

// create  new Organization
CreateNewOrganizationPage cnop=new CreateNewOrganizationPage(driver);
cnop.createorg(orgName);

// verify header msg expected result
OrganizationInfoPage oip=new OrganizationInfoPage(driver);
String actOrgName = oip.getHeaderMsg().getText();
if(actOrgName.contains(orgName))
{
System.out.println(orgName + "name is verified ==Pass");	
}
else 
{
	System.out.println(orgName + "name is not verified ==Fail");	
	}

	
      	
	/*
	driver.findElement(By.name("user_name")).sendKeys(USERNAME);
	driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
	driver.findElement(By.id("submitButton")).click();
	
	// navigate to the organization
	driver.findElement(By.linkText("Organizations")).click();
	

	// Step:3 click on "Create Organization " Button
	
	driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
	
	// Step 4 enter all the details and create new Organization
	
	driver.findElement(By.name("accountname")).sendKeys(orgName);
	Thread.sleep(2000);
	
	driver.findElement(By.name("button")).click();
	Thread.sleep(2000);
	
	
	// verify header msg Expected Result
      String headerInfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	if(headerInfo.contains(orgName))
	{
		System.out.println(orgName + "is created == PASS");
		}
	else
	{
		System.out.println(orgName + "is not created == FAIL");
	}
	Thread.sleep(2000);
	
	// verify orgName info Expected Result
	String actOrgName=driver.findElement(By.id("mouseArea_Organization Name")).getText();
	if(actOrgName.trim().equals(orgName))
	{
		System.out.println(orgName + " is created == PASS");
		}
	else
	{
		System.out.println(orgName + " is not created == FAIL");
	}
	
	// Step :5 logout
driver.quit();

	*/

	// step logout

hp.logout();
	
	driver.quit();
}
}
