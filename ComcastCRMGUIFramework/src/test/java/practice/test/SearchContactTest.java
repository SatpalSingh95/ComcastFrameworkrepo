package practice.test;



import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.objectrepositoryutility.LoginPage;

/** 
 * test class for Contact module
 * @author Satpal
 * 
 * 
 * 
 */

public class SearchContactTest  extends BaseClass 
{
	// write scenario
	/**
	 * Scenario: login()==>navigateContact==>createcontact()==verify  
	 * 
	 */
	
	@Test
	public void SearchContactTest()
	{
		// Instead of writing this   //login to app
		
	/* step1: login to app */
		
	
	 
LoginPage lp=new LoginPage(driver);
lp.loginToapp("url", "username", "password");
	}
	
	
	
	
}
