package com.crm.comcast.contacttest;

import java.io.IOException;


import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.ContactPage1;
import com.comcast.crm.objectrepositoryutility.CreateNewOrganizationLookUp;
import com.comcast.crm.objectrepositoryutility.CreateNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;

/**
 * @author Satpal Singh
 * 
 */
public class CreateContactTest extends BaseClass {

	@Test(groups={"smokeTest"})
	public void createContact() throws EncryptedDocumentException, IOException {
		System.out.println("execute createContact & verify ");

		/* Read TestScript data from Excel file*/
		String lastName = eLib.getDataFromExcel("contact", 1, 2) + jLib.getRandomNumber();
        // Navigate to contact module 
		/*
		 * HomePage hp=new HomePage(driver);
		 * hp.getContactLink().click();
		 * 
		 */
		
		// click on  "create contact" Button 
		ContactPage1 cp = new ContactPage1(driver);
		cp.navigateToContactsLink();
		cp.createContact();
		cp.getLastName().sendKeys(lastName);
		cp.getSaveButton().click();
		// String actHeader = driver.findElement(By.className("dvHeaderText")).getText();
		
		//verify Header lastName Info Expected Result
		String  actHeader=cp.getHeaderMsg().getText();
		boolean status=actHeader.contains(lastName);
		
		
		Assert.assertEquals(status, true);
		
		
		String actLastName = driver.findElement(By.id("dtlview_Last Name")).getText();
		
		SoftAssert soft=new SoftAssert();
		soft.assertEquals(actLastName, lastName);
	
	}

	@Test(groups="regressionTest")
	public void createContactWithsupportDate() throws EncryptedDocumentException, IOException, InterruptedException {
		System.out.println("execute createContactWithDate and verify");

		// Read TestScript data from Excel file
		String lastName = eLib.getDataFromExcel("contact", 4, 2) + jLib.getRandomNumber();

//	// navigate to contact module
//	HomePage hp=new HomePage(driver);
//	hp.getContactLink().click();

		// enter all the details and create new contact

		ContactPage1 cp = new ContactPage1(driver);
		cp.navigateToContactsLink();
		cp.createContact();

		// enter all the details and create new contact

		String startDate = jLib.getSystemDateyyyyMMdd();
		String endDate = jLib.getRequiredDateyyyyMMdd(30);

		cp.getLastName().sendKeys(lastName);
		cp.startDate(startDate);
		cp.endDate(endDate);
		cp.getSaveButton().click();

		// driver.switchTo().alert().accept();

		String actStartDate = driver.findElement(By.id("dtlview_Support Start Date")).getText();
		System.out.println(actStartDate);
		if (actStartDate.trim().equals(startDate)) {
			System.out.println(startDate + " information is verified == PASS");
		} else {
			System.out.println(startDate + " is not verified == FAIL");
		}

		Thread.sleep(2000);

		String actendDate = driver.findElement(By.id("dtlview_Support End Date")).getText();
		System.out.println(actendDate);
		if (actendDate.trim().equals(endDate)) {
			System.out.println(endDate + " information is  verified == PASS");
		} else {
			System.out.println(endDate + " information is not verified == FAIL");
		}

	}

	@Test(groups="regressionTest")
	public void createContactWithOrgTest() throws EncryptedDocumentException, IOException {
		System.out.println("execute createContactWithDate and verify");

		// Read TestScript data from Excel file
		String orgName = eLib.getDataFromExcel("contact", 7, 2) + jLib.getRandomNumber();
		String contactLastName = eLib.getDataFromExcel("contact", 7, 3) + jLib.getRandomNumber();

// navigate to organization Module

		HomePage hp = new HomePage(driver);

		// step 3 click on "create Organization" button
		OrganizationsPage op = new OrganizationsPage(driver);
		op.createOrg();
		op.createNewOrgBtn();
		op.orgNameEdit(orgName);
		op.saveBtn();

		// step4 enter all the details and create new Organization

		// verify header phone Number info Expected Result

		String headerInfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if (headerInfo.contains(orgName)) {
			System.out.println(orgName + "header verified===Pass");
		} else {
			System.out.println(orgName + "header is not  verified==Fail");
		}

// click on create contact button

		ContactPage1 cp = new ContactPage1(driver);
		cp.navigateToContactsLink();

// enter all the details and create new Org
		cp.createContact();
		cp.lastName(contactLastName);

		cp.lookup();
//switch to child window
		WebDriverUtility wLib = new WebDriverUtility();
		wLib.switchToTabOnURL(driver, "http://localhost:8888/index.php?module=Accounts&action=Popup&popuptype=specific_contact_account_address&form=TasksEditView&form_submit=false&fromlink=&recordid=");
System.out.println(driver.getCurrentUrl());
		CreateNewOrganizationLookUp cnop = new CreateNewOrganizationLookUp(driver);
		System.out.println(orgName);
		cnop.searchInfo(orgName);
		cnop.searchButton();

		driver.findElement(By.xpath("//a[text()='" + orgName + "']")).click();
	


  		// switch to parent window
  		wLib.switchToTabOnURL(driver, "Contacts&action");
  		
cp.clickOnSaveBtn();
  		
		String actOrgName = driver.findElement(By.id("mouseArea_Organization Name")).getText();
		if (actOrgName.trim().contains(orgName)) {
			System.out.println(orgName + "is verified == PASS");
		} else {
			System.out.println(orgName + "is not verified == FAIL");
		}

	}

}
