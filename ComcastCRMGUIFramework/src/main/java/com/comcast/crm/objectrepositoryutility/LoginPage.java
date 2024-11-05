package com.comcast.crm.objectrepositoryutility;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
/**
 * @author Satpal
 * Contains Login page elements & business lib like login()
 * 
 * 
 */
public class LoginPage  extends WebDriverUtility
{
	
	
	
	// rule1 create java a separate class
// rule 2 Object creation(identify all the elements using @FindBy annotations)
	WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		this.driver =driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
	@FindBy(name="user_name")
	private WebElement usernameEdit;
	
	@FindBy(name="user_password")
	private	WebElement passwordEdit;
	
	@FindBy(id="submitButton")
	private	WebElement loginBtn;

	
	// Object Initialization
	// initialization should be done it in where test script not in the where POM classes
	
	// rule 4 Object Encapsulation
	// rule 5 object utilization
	
	public WebElement getUsernameEdit() {
		return usernameEdit;
	}

	public WebElement getPasswordEdit() {
		return passwordEdit;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	
	/**
	 * login to application based on username,password url arguments
	 * @param url
	 * @param username
	 * @param password
	 */
	// to get automatically /** press enter
	
	
	// provide Action
	// Business method only for specific script
	public void loginToapp( String username, String password,String url)
	{
		
	driver.get(url);
driver.manage().window().maximize();
	WaitForPageToLoad(driver);
	    usernameEdit.sendKeys(username);
        passwordEdit.sendKeys(password);
        loginBtn.click();
	}
	
	
}
