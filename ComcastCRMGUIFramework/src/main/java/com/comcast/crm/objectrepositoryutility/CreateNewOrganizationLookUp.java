package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewOrganizationLookUp 
{
	public WebDriver driver;

	
	
	public CreateNewOrganizationLookUp(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}


	@FindBy(xpath="//input[@name='search_text']")
	private WebElement searchTextField;
	
	
	@FindBy(name="search")
	private WebElement searchButton;


	public WebElement getTextField() {
		return searchTextField;
	}


	public WebElement getSearchButton() {
		return searchButton;
	}
	
	

	
	public void searchInfo(String orgName)
	{
		searchTextField.sendKeys(orgName);
		
	}
	
	
	public void searchButton()
	{
		searchButton.click();
	}
}
