package com.comcast.crm.generic.webdriverutility;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

public class UtilityClassObject 
{
	// I want share my Extent report Test Object. this Object i want to make it multiple object. i want to share this test object into what multiple threads
	// that is reason i am using ThreadLocal.
public static ThreadLocal<ExtentTest> test = new ThreadLocal<ExtentTest>();

public static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

// Anybody want to access driver object and if anybody want to use my ExtentReport object(test )
// i will provide getters and setter method

public static ExtentTest getTest()
{
	
return test.get();// this method will give the Extent report object for the multiple threads. when you achieve parallel Execution this method will share the object.
}

public static void setTest(ExtentTest actTest)
{
	test.set(actTest);
}

public static WebDriver getDriver()
{
	return driver.get();
}

public static void setDriver(WebDriver actDriver)
{
	driver.set(actDriver);
}

}

// This class help us to share my static variable for multiple threads in case of parallel Execution.
