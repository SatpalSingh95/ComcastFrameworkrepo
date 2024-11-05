package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreateNewOrganizationPage 
{
	WebDriver driver;
	public CreateNewOrganizationPage(WebDriver driver)
	{
		this.driver =driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
	@FindBy(name="accountname")
	private WebElement orgNameEdit;

	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	//@FindBy(name="button")
	private WebElement saveBtn;

	@FindBy(name="industry")
	private WebElement industryDB;
	
	@FindBy(id="phone")
	private WebElement phoneNumberTextField;
	
	public WebElement getPhoneNumber() {
		return phoneNumberTextField;
	}

	public WebElement getOrgNameEdit() {
		return orgNameEdit;
	}
   
	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	public void createorg(String orgName)
	{
		orgNameEdit.sendKeys(orgName);
		saveBtn.click();
		
	}
	
	public void createorg(String orgName,String industry)
	{
		orgNameEdit.sendKeys(orgName);
		Select sel = new Select(industryDB);
		sel.selectByVisibleText(industry);
		saveBtn.click();
		
	}
	
	public void enterPhn(String phoneNumber)
	{
		phoneNumberTextField.sendKeys(phoneNumber);
		
		
	}
}
