package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class ContactPage extends WebDriverUtility
{

	WebDriver driver;
	public ContactPage(WebDriver driver)
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
	
	public void getLastnameField(String lastname)
	{
	lastnameField.sendKeys(lastname);
	saveButton.click();
	}
}
