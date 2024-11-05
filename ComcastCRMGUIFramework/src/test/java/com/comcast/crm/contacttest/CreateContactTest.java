package com.comcast.crm.contacttest;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;

public class CreateContactTest {
	public static void main(String[] args) throws InterruptedException, IOException {

		// Create object
		FileUtility fLib=new FileUtility();
		ExcelUtility eLib=new ExcelUtility();
		JavaUtility jLib= new JavaUtility();
	// get data from excel
		String BROWSER = fLib.getDataFromPropertiesFile("browser");
		String URL = fLib.getDataFromPropertiesFile("url");
		String USERNAME =  fLib.getDataFromPropertiesFile("username");
		String PASSWORD =  fLib.getDataFromPropertiesFile("password");

	

		// Read TestScript data from Excel file
				String lastName =eLib.getDataFromExcel("contact", 1, 2)+jLib.getRandomNumber();
		WebDriver driver = null;

		if (BROWSER.equals("chrome")) {

			driver = new ChromeDriver();

		} else if (BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();
		} else if (BROWSER.equals("edge")) {
			driver = new EdgeDriver();
		} else {
			driver = new ChromeDriver();
		}

		System.out.println(BROWSER);
		
		//step:1  login to Application
          driver.get(URL);
	     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();

		// Thread.sleep(2000);
		// step:2 navigate to contact module
		driver.findElement(By.linkText("Contacts")).click();

		// Step:3 click on "Create Contacts " Button
        driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
         // Step 4 enter all the details and create new Organization
          driver.findElement(By.name("lastname")).sendKeys(lastName);
		Thread.sleep(2000);
		driver.findElement(By.name("button")).click();
		Thread.sleep(2000);

		// verify header phone Number info Expected Result

		String actLastName = driver.findElement(By.id("dtlview_Last Name")).getText();
		if (actLastName.trim().contains(lastName)) {
			System.out.println(lastName + " is created == PASS");
		} else {
			System.out.println(lastName + " is not created == FAIL");
		}
		Thread.sleep(2000);

		// Step :5 logout
		driver.quit();

	}
}
