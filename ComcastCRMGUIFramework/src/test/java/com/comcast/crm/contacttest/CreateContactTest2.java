package com.comcast.crm.contacttest;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.objectrepositoryutility.ContactPage1;

public class CreateContactTest2 extends BaseClass {
	
	@Test
	public void createContactTest() throws IOException, InterruptedException {

		// Read TestScript data from Excel file
		String lastName = eLib.getDataFromExcel("contact", 1, 2) + jLib.getRandomNumber();

		ContactPage1 cp = new ContactPage1(driver);
		cp.navigateToContactsLink();
		cp.createContact();
		cp.getLastName().sendKeys(lastName);
		cp.getSaveButton().click();

		String actLastName = driver.findElement(By.id("dtlview_Last Name")).getText();
		if (actLastName.trim().contains(lastName)) {
			System.out.println(lastName + " Information is verified == PASS");
		} else {
			System.out.println(lastName + " Information is not verified == FAIL");
		}
	}
	/*
	 * @Test public void createContactWithsupportDate() throws InterruptedException,
	 * EncryptedDocumentException, IOException {
	 * 
	 * // Read TestScript data from Excel file String lastName
	 * =eLib.getDataFromExcel("contact", 4, 2)+jLib.getRandomNumber();
	 * 
	 * 
	 * 
	 * // login to app
	 * 
	 * HomePage hp=new HomePage(driver); hp.getContactLink().click();
	 * 
	 * // click to create contact button ContactPage cp=new ContactPage(driver);
	 * //cp.getCreateNewOrgBtn().click(); cp.getLastnameField(lastName);
	 * 
	 * //enter all the details and create new contact String
	 * startDate=jLib.getSystemDateYYYYDDMM(); String
	 * endDate=jLib.getRequiredDateYYYYDDMM(30);
	 * driver.findElement(By.name("lastname")).sendKeys(lastName);
	 * 
	 * driver.findElement(By.name("support_start_date")).clear();
	 * driver.findElement(By.name("support_start_date")).sendKeys(startDate);
	 * 
	 * driver.findElement(By.name("support_end_date")).clear();
	 * driver.findElement(By.name("support_end_date")).sendKeys(endDate);
	 * 
	 * // phone number //driver.findElement(By.id("phone")).sendKeys(lastName);
	 * 
	 * 
	 * 
	 * driver.findElement(By.name("button")).click(); Thread.sleep(2000);
	 * 
	 * 
	 * // verify header phone Number info Expected Result
	 * 
	 * 
	 * String actStartDate =
	 * driver.findElement(By.id("dtlview_Support Start Date")).getText();
	 * if(actStartDate.trim().equals(startDate)) { System.out.println(startDate +
	 * " information is verified == PASS"); } else { System.out.println(startDate +
	 * "is not verified == FAIL"); } Thread.sleep(2000);
	 * 
	 * String actendDate =
	 * driver.findElement(By.id("dtlview_Support End Date")).getText();
	 * if(actStartDate.trim().equals(startDate)) { System.out.println(startDate +
	 * "information is  verified == PASS"); } else { System.out.println(startDate +
	 * "information is not verified == FAIL"); }
	 * 
	 * 
	 * 
	 * 
	 * 
	 * }
	 * 
	 * 
	 * 
	 * @Test public void createContactWithOrgTest() {
	 * 
	 * 
	 * }
	 * 
	 */
}
