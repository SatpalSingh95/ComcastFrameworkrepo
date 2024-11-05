package practice.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class GetProductInfoTest1
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
	String x="//span[text()='"+ProductName+"']/ancestor::div[3]//div[1]/div[1]/div[1]/div[2]/div[1]/a/span/span[1]";
	String price=driver.findElement(By.xpath(x)).getText();
System.out.println(price);

	}
@DataProvider
public Object[][] getData()
{
	Object[][] objArr=new Object[3][2];
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
}
}

