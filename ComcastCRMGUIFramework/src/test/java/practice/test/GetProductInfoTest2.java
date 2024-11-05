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

public class GetProductInfoTest2
{
	@Test(dataProvider = "getData")
	public void getProductInfoTest(String brandName,String ProductName) throws InterruptedException
	{
	WebDriver driver=new ChromeDriver();	
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.get("https://www.amazon.in/");

	// search product
	driver.findElement(By.id("twotabsearchtextbox")).sendKeys(brandName,Keys.ENTER);
	
	// capture product info
	
	// String x="//span[text()='Apple iPhone 13 (128GB) - Starlight']/../../../../div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/a/span/span[1]";

	Thread.sleep(2000); 
	String x="//span[text()='Apple iPhone 13 (128GB) - Starlight']/ancestor::div[3]//div[1]/div[1]/div[1]/div[2]/div[1]/a/span/span[1]";
	String price=driver.findElement(By.xpath(x)).getText();
System.out.println(price);

	}
@DataProvider
public Object[][] getData() throws EncryptedDocumentException, IOException
{
	ExcelUtility eLib=new ExcelUtility();
	int rowCount =eLib.getRowcount("product");
	
	Object[][] objArr=new Object[rowCount][2];
	
	for(int i=0;i<rowCount;i++ )
	{
		objArr[i][0]=eLib.getDataFromExcel("product",i+1,0);
		objArr[i][1]=eLib.getDataFromExcel("product",i+1,1);;
	}
	return objArr;
}
}

