package practice.testng;

import org.testng.annotations.Test;

public class ContactTest
{
@Test
public void createContact()
{
	System.out.println("execute createContact with ----Hdfc");
	}

@Test
public void modifyContactTest()
{
	//System.out.println("create contact ICICI");
//System.out.println("execute modifyContactTest--->HDFC--->ICICI");
	System.out.println("execute query insert contact in DB==>ICICI");

System.out.println("execute modifyContactTest--->ICICI--->ICICI_1");
}

@Test
public void deleteContactTest()
{
	//System.out.println("execute deleteContactTest---->ICICI");
	System.out.println("execute query insert contact in DB==>UPI");
	System.out.println("execute deleteContactTest UPI");
	
}
}
// now all the test cases are independent no need to give the priority.