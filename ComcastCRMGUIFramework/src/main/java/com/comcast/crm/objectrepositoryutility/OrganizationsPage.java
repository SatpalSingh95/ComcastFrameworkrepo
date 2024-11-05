package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsPage 
{

	WebDriver driver;
	public OrganizationsPage(WebDriver driver)
	{
		this.driver =driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(name="search_text")
	private WebElement searchEdit;
	
	@FindBy(name="search_field")
	private WebElement searchDD;
	
	@FindBy(name="submit")
	private WebElement searchButton;
	
	

	public WebElement getSearchButton() {
		return searchButton;
	}

	public WebElement getSearchEdit() {
		return searchEdit;
	}

	public WebElement getSearchDD() {
		return searchDD;
	}

	@FindBy(xpath="//img[@alt='Create Organization...']")
	private WebElement createNewOrgBtn;;
	
	@FindBy(xpath="//a[text()='Organizations']")
	WebElement OrgLink;
	
	public WebElement getCreateNewOrgBtn()
	{
		return createNewOrgBtn;
		
		
	}
	
	public WebElement getOrgLink() {
		return OrgLink;
	}
	
	public void createOrg()
	{
		OrgLink.click();
		
	}
	
	
	public void createNewOrgBtn()
	{
		createNewOrgBtn.click();
	}
	
	@FindBy(name="accountname")
	private WebElement orgNameEdit;
	public WebElement getOrgNameEdit() {
		return orgNameEdit;
	}
	public void orgNameEdit(String orgName)
	{
		orgNameEdit.sendKeys(orgName);
	}
 
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	public void saveBtn()
	{
		saveBtn.click();
	}

}
