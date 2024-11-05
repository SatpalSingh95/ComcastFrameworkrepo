package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage1 
{
	public WebDriver driver;

	public ContactPage1(WebDriver driver)
	{
		this.driver =driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(className="dvHeaderText")
	private WebElement headerMsg;
	
	public WebElement getHeaderMsg() {
		return headerMsg;
	}
	@FindBy(xpath="//a[text()='Contacts']")
	private WebElement contactLink;
	

	@FindBy(xpath="//img[@alt='Create Contact...']")
	private WebElement createContactButton;
	
	@FindBy(xpath="//span[text()='Creating New Contact']")
	private WebElement createNewContact;

	@FindBy(xpath="//input[@name='lastname']")
	private WebElement lastName;

	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveButton;
	
	@FindBy(xpath="//img[@title='Select']")
	private WebElement lookupBtn;
	
	
	
	public WebElement getLookupBtn() {
		return lookupBtn;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}

	public WebElement getLastName() {
		return lastName;
	}

	public WebElement getCreateNewContact() {
		return createNewContact;
	}

	public WebElement getCreateContactLink() {
		return contactLink;
	}

	public WebElement getCreateContactButton() {
		return createContactButton;
	}
	
	public void lastName(String contactLastName)
	{
		lastName.sendKeys(contactLastName);
	}
	
public void clickOnSaveBtn()
{
	saveButton.click();
}
	
	public void navigateToContactsLink()
	{
		Actions act = new Actions(driver);
		act.moveToElement(contactLink).click().perform();
	
	}
	
	
	public void createContact()
	{
	createContactButton.click();
	}
	
	@FindBy(name="support_start_date")
	private WebElement supportStartDate;
	
	@FindBy(name="support_end_date")
	private WebElement supportEndDate;

	public WebElement getSupportStartDate() {
		return supportStartDate;
	}

	public WebElement getSupportEndDate() {
		return supportEndDate;
	}
	
	public void startDate(String startDate)
	{
		supportStartDate.clear();
		supportStartDate.sendKeys(startDate);
	}
	public void endDate(String endDate)
	{
		supportEndDate.clear();
		supportEndDate.sendKeys(endDate);
	}
	
	public void lookup()
	{
		lookupBtn.click();
	}

	/*
	 * public WebElement getHeadMsg() { // TODO Auto-generated method stub return
	 * null; }
	 */
	
	
	
	
	

	
}
