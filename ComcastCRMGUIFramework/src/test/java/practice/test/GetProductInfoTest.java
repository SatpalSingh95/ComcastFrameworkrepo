package practice.test;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.comcast.crm.generic.fileutility.ExcelUtility;

public class GetProductInfoTest 
{
@Test
public void getProductInfoTest(String brandName, String productName) throws InterruptedException
{
WebDriver driver=new ChromeDriver();	
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
driver.get("https://www.amazon.in/");

// search product
//driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone",Keys.ENTER);

driver.findElement(By.id("twotabsearchtextbox")).sendKeys(brandName,Keys.ENTER);



Thread.sleep(2000);
// capture product Info
//String x="//span[text()='Apple iPhone 16 (128 GB) - Black']/../../../../div[3]/div[1]/div[1]/div/div[1]/div[1]/a/span/span[text()='₹79,900']";

// String x="//span[text()='"+productName+"']/../../../../div[3]/div[1]/div[1]/div/div[1]/div[1]/a/span/span[text()='₹79,900']";

//String x="//span[text()='"+productName+"']/../../../../div[3]/div[1]/div/div[1]/div[1]/a/span/span[2]/span[2]";
//span[text()='Apple iPhone 16 (128 GB) - Black']/../../../../div[3]/div[1]/div[1]/div/div[1]/div[1]/a/span/span[1]

//String x="span[text()='Apple iPhone 16 (128 GB) - Black']/../../../../div[3]/div[1]/div[1]/div/div[1]/div[1]/a/span/span[1]";

String x="//span[text()='"+productName+"']/../../../../div[3]/div[1]/div/div[1]/div[1]/a/span/span[2]/span[2]";

Thread.sleep(2000);
String price =driver.findElement(By.xpath(x)).getText();
System.out.println(price);
driver.quit();
}

@DataProvider



public Object[][] getData() throws EncryptedDocumentException, IOException
{
	ExcelUtility eLib=new ExcelUtility();
	int rowCount=eLib.getRowcount("product");
	
	
//Object[][] objArr=new Object[3][2];	 // 1st indicates how many times you want to execute and // 2nd index indicates how many parameters you want to pass.


Object[][] objArr=new Object[rowCount][2];



for(int i=0;i<rowCount;i++ )
{
	objArr[i][0]=eLib.getDataFromExcel("product",i+1,0);
	objArr[i][1]=eLib.getDataFromExcel("product",i+1,1);;
	



}
return objArr;




/*
objArr[0][0]="iphone";
objArr[0][1]="Apple iPhone 16 (128 GB) - Black";
//objArr[0][2]=9856235689l;

objArr[1][0]="iphone";
objArr[1][1]="Apple iPhone 16 (128 GB) - White";
//objArr[1][2]=9451235645l;

objArr[2][0]="iphone";
objArr[2][1]="Apple iPhone 13 (256GB) - Pink";
//objArr[2][2]=947135689l;

return objArr;
*/
}
}
