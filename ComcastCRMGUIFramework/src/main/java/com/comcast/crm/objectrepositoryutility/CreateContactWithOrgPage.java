package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateContactWithOrgPage 
{

@FindBy(linkText="Organizations")
private WebElement OrgLink;

@FindBy(xpath="//img[@title='Create Organization...")
private WebElement createOrg;

@FindBy(name="accountname")
private WebElement accountname;


@FindBy(linkText ="button")
private WebElement btn;


@FindBy(name="Contacts")
private WebElement contacts;


@FindBy(xpath="//img[@title='Create Contact...']")
private WebElement createContactBtn;


@FindBy(name="lastname")
private WebElement createNewOrg;


@FindBy(xpath="//input[@name='account_name']/following-sibling::img")
private WebElement lookUpWindow;



@FindBy(name="search_text")
private WebElement searchText;

@FindBy(name="search")
private WebElement search;



@FindBy(name="button")
private WebElement button;



public WebElement getOrgLink() {
	return OrgLink;
}



public WebElement getCreateOrg() {
	return createOrg;
}



public WebElement getAccountname() {
	return accountname;
}



public WebElement getBtn() {
	return btn;
}



public WebElement getContacts() {
	return contacts;
}



public WebElement getCreateContactBtn() {
	return createContactBtn;
}



public WebElement getCreateNewOrg() {
	return createNewOrg;
}



public WebElement getLookUpWindow() {
	return lookUpWindow;
}



public WebElement getSearchText() {
	return searchText;
}



public WebElement getSearch() {
	return search;
}



public WebElement getButton() {
	return button;
}

public void orgLink()
{
OrgLink.click();;	
}

public void createContact()
{
createOrg.click();;	
}

public void accountName()
{
accountname.click();;	
}
public void btn()
{
btn.click();;	
}

public void contacts()
{
	contacts.click();
}

public void createContactBtn()
{
createContactBtn.click();;	
}

public void createNewOrg()
{
	
	createNewOrg.click();
}

public void lookUpWindow()
{
	lookUpWindow.sendKeys();	
}

public void search()
{
	searchText.click();	
}






}
