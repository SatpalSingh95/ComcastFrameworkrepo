package practice.testng;

import org.testng.annotations.Test;

public class OrderTest3 
{
	// this test case execute 10 times.
@Test (invocationCount=10)
public void createOrderTest()
{
	System.out.println("Execute createOrdertest===>123");
}

// this test case will not take participate in execution only
@Test(enabled=false)
public void billingAnOrderTest()
{
	
System.out.println("Execute billingAnOrderTest===>123");
}
}
