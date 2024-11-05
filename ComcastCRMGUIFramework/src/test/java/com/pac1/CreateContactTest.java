package com.pac1;


import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class CreateContactTest
{
	@BeforeSuite
	public void configBS()
	{
		System.out.println("execute BS");
	}
	
	@BeforeClass
	public void configBC()
	{
		System.out.println("execute BC");
	}
	
@Test
public void createContact()
{
	System.out.println("execute createContact");
}
@Test
public void createContactWithDate()
{
	System.out.println("execute createContactWithDate");
}

@BeforeMethod
public void configBM()
{
	System.out.println("execute BM");
	
}

@AfterMethod
public void configAM()
{
System.out.println("execute AM");	
}

@AfterClass
public void configAC()
{
	System.out.println("execute AC");
}
@AfterSuite
public void configAS()
{
	System.out.println("execute AS");
}
}
