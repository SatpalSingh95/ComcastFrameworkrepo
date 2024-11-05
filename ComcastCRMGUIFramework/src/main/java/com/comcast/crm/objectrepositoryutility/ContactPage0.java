package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class ContactPage0 extends WebDriverUtility
{

	WebDriver driver;
	public ContactPage0(WebDriver driver)
	{
		this.driver =driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(xpath="//img[@title=' Create Contact...']")
	private WebElement createContactButton;
	
	

	public WebElement getCreateContactButton() {
		return createContactButton;
	}

	public WebElement getLastnameField() {
		return lastnameField;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	@FindBy(name="lastname")
	private WebElement lastnameField;
	
	@FindBy(xpath="//*[@value='  Save  ']")
	private WebElement saveButton;
	
	public void setLastnameField(String lastname)
	{
	lastnameField.sendKeys(lastname);
	saveButton.click();
	}
	
	/*
	 * public void createorg(String orgName,String industry) {
	 * orgNameEdit.sendKeys(orgName); Select sel = new Select(industryDB);
	 * sel.selectByVisibleText(industry); saveBtn.click();
	 * 
	 * }
	 */
	

	public WebElement getCreateNewBtn() {
		// TODO Auto-generated method stub
		return null;
	}
}
