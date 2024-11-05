package com.crm.comcast.orgtest;


import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.objectrepositoryutility.CreateNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.OrganizationInfoPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;


@Listeners(com.comcast.listenerutility.ListImpClass.class)
public class CreateOrgTest extends BaseClass
{
@Test(groups="smokeTest")
public void createOrgTest() throws EncryptedDocumentException, IOException
{
	System.out.println("execute createOrgTest & verify");
	
	//ListImpClass.test.log(Status.INFO,"read data from Excel");
	UtilityClassObject.getTest().log(Status.INFO,"read data from Excel");
	
	// Read TestScript data from Excel file
				String orgName =eLib.getDataFromExcel("org1", 1, 2)+jLib.getRandomNumber();
			
				
				
				// navigate to Home page(Organaization module)
				
		//	HomePage hp= new HomePage(driver);
				
				UtilityClassObject.getTest().log(Status.INFO,"navigate to Organization page");
			OrganizationsPage op=new OrganizationsPage(driver);
			op.createOrg();
		    op.getCreateNewOrgBtn().click();
		 // enter all the details and create  new Organization
		    
		    
		    UtilityClassObject.getTest().log(Status.INFO,"navigate to CreateNewOrganization");
		    CreateNewOrganizationPage cnop=new CreateNewOrganizationPage(driver);
		    cnop.createorg(orgName);
		    
		    UtilityClassObject.getTest().log(Status.INFO,orgName + "Create a New Organization");
			   
			
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
			
}
@Test(groups="regressionTest")
public void createContactWithPhoneNumber() throws EncryptedDocumentException, IOException
{
	System.out.println("execute createOrgWithIndustries & verify");
	
	// Read TestScript data from Excel file
	String orgName =eLib.getDataFromExcel("org1", 7, 2)+jLib.getRandomNumber();
	// Read TestScript data from Excel file
	String phoneNumber =eLib.getDataFromExcel("org1", 7, 3)+jLib.getRandomNumber();

	
	OrganizationsPage op=new OrganizationsPage(driver);
	op.createOrg();
    op.getCreateNewOrgBtn().click();
 // enter all the details and create  new Organization
    CreateNewOrganizationPage cnop=new CreateNewOrganizationPage(driver);
    cnop.createorg(orgName);
	cnop.enterPhn(phoneNumber);
	
	cnop.getSaveBtn();
	

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
}


}
