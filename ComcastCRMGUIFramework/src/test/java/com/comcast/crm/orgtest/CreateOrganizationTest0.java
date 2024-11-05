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

public class CreateOrganizationTest0 
{
public static void main(String[] args) throws InterruptedException, FileNotFoundException, IOException, ParseException 
{
	// Create object
	FileUtility fLib=new FileUtility();
	ExcelUtility eLib=new ExcelUtility();
	JavaUtility jLib= new JavaUtility();
// get data from properties file
	String BROWSER = fLib.getDataFromPropertiesFile("browser");
	String URL = fLib.getDataFromPropertiesFile("url");
	String USERNAME =  fLib.getDataFromPropertiesFile("username");
	String PASSWORD =  fLib.getDataFromPropertiesFile("password");



	// Read TestScript data from Excel file
			String orgName =eLib.getDataFromExcel("org1", 1, 2)+jLib.getRandomNumber();
	WebDriver driver = null;
	/*
	 * // step1 : get the java representation object of the physical file
	 * FileInputStream fis = new
	 * FileInputStream("./configAppData/Commondata.properties");
	 * 
	 * // step 2 using properties class, load all the keys Properties pobj=new
	 * Properties(); pobj.load(fis);
	 * 
	 * //step:3 Read the Data using getProperty method String BROWSER
	 * =pobj.getProperty("browser"); String URL =pobj.getProperty("url"); String
	 * USERNAME =pobj.getProperty("username"); String
	 * PASSWORD=pobj.getProperty("password");
	 * 
	 * //generate the random Number Random random =new Random(); int
	 * randomInt=random.nextInt(1000);
	 * 
	 * // Read TestScript data from Excel file FileInputStream fs = new
	 * FileInputStream("./testData/TestScriptData.xlsx"); Workbook wb =
	 * WorkbookFactory.create(fs); Sheet sh=wb.getSheet("org1"); Row
	 * row=sh.getRow(1); String orgName = row.getCell(2).toString() +randomInt;
	 * System.out.println(orgName);
	 * 
	 * wb.close();
	 */
		
			
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
	
	
	// Object Initialization
	//LoginPage lp = PageFactory.initElements(driver,LoginPage.class);
	
	 // object utilization
 /*
	lp.getUsernameEdit().sendKeys("admin");
	lp.getPasswordEdit().sendKeys("admin");
	lp.getLoginBtn().click();
	*/
	
	LoginPage lp=new LoginPage(driver);
//	lp.loginToapp("admin","admin");
	lp.loginToapp(USERNAME,PASSWORD,URL);
	
	
	/*
	 * // verify header msg expected result OrganizationInfoPage oip=new
	 * OrganizationInfoPage(driver); String actOrgName =
	 * oip.getHeaderMsg().getText(); if(actOrgName.contains(orgName)) {
	 * System.out.println(orgName + "name is verified ==Pass"); } else {
	 * System.out.println(orgName + "name is not verified ==Fail"); }
	 */
	
      	


	// step logout
	
	driver.quit();
}
}
