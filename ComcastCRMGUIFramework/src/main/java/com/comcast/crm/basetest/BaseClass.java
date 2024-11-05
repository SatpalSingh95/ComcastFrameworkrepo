package com.comcast.crm.basetest;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.generic.databaseutility.DataBaseUtility;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;

public class BaseClass {

	DataBaseUtility dbLib = new DataBaseUtility();

// create Object
	public FileUtility fLib = new FileUtility();
	public ExcelUtility eLib = new ExcelUtility();
	public JavaUtility jLib = new JavaUtility();

	 public WebDriver driver = null;
	 
	
	// if we use static keyword it will not participate in parallel execution because static variable has only one instance
	public static WebDriver sdriver = null;

	@BeforeSuite(groups= {"smokeTest","regressionTest"})
	public void configBS() throws SQLException {
		System.out.println("=== Connect to DB, Report Config ===");
		dbLib.getDbConnection();
		
		
	
		
	}
	/*
//@Parameters("BROWSER")
	@BeforeClass(groups= {"smokeTest","regressionTest"})
	public void configBC(String browser) throws IOException {
		System.out.println("Launch the browser");
		String BROWSER=browser;
		
		//String BROWSER = fLib.getDataFromPropertiesFile("browser");
*/
	//	driver = null;
	@BeforeClass(groups= {"smokeTest","regressionTest"})
	public void configBC() throws IOException {
		System.out.println("Launch the browser");
		
		
		String BROWSER = fLib.getDataFromPropertiesFile("browser");

		if (BROWSER.equals("chrome")) {

			driver = new ChromeDriver();

		} else if (BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();
		} else if (BROWSER.equals("edge")) {
			driver = new EdgeDriver();
		} else {
			driver = new ChromeDriver();
		}
		sdriver=driver;
		UtilityClassObject.setDriver(driver);

	}

	@BeforeMethod(groups= {"smokeTest","regressionTest"})
	public void configBM() throws IOException {
		System.out.println("==Login==");
		LoginPage lp = new LoginPage(driver);
		String URL = fLib.getDataFromPropertiesFile("url");
		String USERNAME = fLib.getDataFromPropertiesFile("username");

		String PASSWORD = fLib.getDataFromPropertiesFile("password");

		lp.loginToapp(USERNAME, PASSWORD, URL);

	}

	@AfterMethod(groups= {"smokeTest","regressionTest"})
	public void configAM() {
		System.out.println("=== Logout ===");
		HomePage hp = new HomePage(driver);
		hp.logout();
	}

	@AfterClass(groups= {"smokeTest","regressionTest"})
	public void configAC() {
		System.out.println("close the Browser");
		driver.quit();
	}

	@AfterSuite(groups= {"smokeTest","regressionTest"})
	public void configAS() throws SQLException {
		System.out.println("close Db, Report backUP");
		dbLib.closeDbConnection();
		

	}

}
