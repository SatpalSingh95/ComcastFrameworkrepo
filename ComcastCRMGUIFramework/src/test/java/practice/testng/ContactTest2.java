package practice.testng;

import org.testng.annotations.Test;

public class ContactTest2
{
@Test
public void createContactTest()
{
	System.out.println("execute createContact with ----Hdfc");
	}

@Test(dependsOnMethods = "createContactTest")
public void modifyContactTest()
{
System.out.println("execute modifyContactTest--->Hdfc--->ICICI");
}

@Test(dependsOnMethods = "modifyContactTest")
public void deleteContactTest()
{
	System.out.println("execute deleteContactTest ICICI");
	}
}
