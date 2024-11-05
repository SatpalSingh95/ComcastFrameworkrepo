package practice.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class GetProductInfoTest0
{
	@Test
	public void getProductInfoTest() throws InterruptedException
	{
	WebDriver driver=new ChromeDriver();	
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.get("https://www.amazon.in/");

	// search product
	driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone",Keys.ENTER);
	
	// capture product info
	
	// String x="//span[text()='Apple iPhone 13 (128GB) - Starlight']/../../../../div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/a/span/span[1]";

	Thread.sleep(2000); 
	String x="//span[text()='Apple iPhone 13 (128GB) - Starlight']/ancestor::div[3]//div[1]/div[1]/div[1]/div[2]/div[1]/a/span/span[1]";
	String price=driver.findElement(By.xpath(x)).getText();
System.out.println(price);
}
}
