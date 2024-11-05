package practice.testng;

import org.testng.annotations.Test;

public class OrderTest2 
{
@Test 
public void createOrderTest()
{
	System.out.println("Execute createOrdertest===>123");
	String str=null;
	System.out.println(str.equals("123"));
}

@Test(dependsOnMethods="createOrderTest")
public void billingAnOrderTest()
{
	
System.out.println("Execute billingAnOrderTest===>123");
}
}
