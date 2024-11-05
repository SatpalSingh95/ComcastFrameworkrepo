package com.comcast.crm.orgtest;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.CreateNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.crm.objectrepositoryutility.OrganizationInfoPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;

public class DeleteOrgTest 
{

public static void main(String[] args) throws IOException {
	
	
	
	// Create object
		FileUtility fLib=new FileUtility();
		ExcelUtility eLib=new ExcelUtility();
		JavaUtility jLib= new JavaUtility();
		WebDriverUtility wLib= new WebDriverUtility();
	// get data from excel
		String BROWSER = fLib.getDataFromPropertiesFile("browser");
		String URL = fLib.getDataFromPropertiesFile("url");
		String USERNAME =  fLib.getDataFromPropertiesFile("username");
		String PASSWORD =  fLib.getDataFromPropertiesFile("password");



		// Read TestScript data from Excel file
				String orgName =eLib.getDataFromExcel("org1", 10, 2)+jLib.getRandomNumber();
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
		
// step1 login to application
driver.get(URL);
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

LoginPage lp=new LoginPage(driver);
lp.loginToapp(USERNAME,PASSWORD,URL);

// navigate to Home page

HomePage hp= new HomePage(driver);
hp.getOrgLink().click();

//Create  organization

OrganizationsPage cnp=new OrganizationsPage(driver);
cnp.getCreateNewOrgBtn().click();

//create  new Organization
CreateNewOrganizationPage cnop=new CreateNewOrganizationPage(driver);
cnop.createorg(orgName);

//verify header msg expected result
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
//go back to Organization Page

hp.getOrgLink().click();
// search for Organization

cnp.getSearchEdit().sendKeys(orgName);
wLib.select(cnp.getSearchDD(), "Organization Name");
cnp.getSearchButton().click();

// In dynamic web Table select and delete org

driver.findElement(By.xpath("//a[text()='"+orgName+"']/../../td[8]/a[text()='del']")).click();

driver.switchTo().alert().accept();  
// step 5 logout
//hp.logout();

//driver.quit();
}
	
	
}
