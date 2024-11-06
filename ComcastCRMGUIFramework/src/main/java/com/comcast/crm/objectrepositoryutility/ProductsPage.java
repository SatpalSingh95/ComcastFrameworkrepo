package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductsPage 
{
public WebElement getCreateProductImgBtn() {
		return createProductImgBtn;
	}

@FindBy(xpath="//img[@alt='Create Product...']")
private WebElement createProductImgBtn;
}
