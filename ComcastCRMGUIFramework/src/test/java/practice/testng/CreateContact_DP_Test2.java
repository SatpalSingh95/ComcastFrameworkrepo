package practice.testng;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateContact_DP_Test2 
{
@Test (dataProvider = "getData")
public void createContactTest(String firstName,String lastName,long phoneNumber)
{
	System.out.println("FirstName:"+firstName + ", LastName: " +lastName + ", PhoneNumber: "+phoneNumber);
}

@DataProvider
public Object[][] getData()
{
Object[][] objArr=new Object[3][3];	 // 1st indicates how many times you want to execute and // 2nd index indicates how many parameters you want to pass.

objArr[0][0]="deepak";
objArr[0][1]="hr";
objArr[0][2]=9856235689l;

objArr[1][0]="sam";
objArr[1][1]="sh";
objArr[1][2]=9451235645l;

objArr[2][0]="john";
objArr[2][1]="smith";
objArr[2][2]=947135689l;

return objArr;
}
}
