package demopackage;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class demoTest {
	public static void main(String args[])
	{
		String url="https://www.amazon.in";
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		
//		String title=driver.getTitle();
//		String expectedTitle="Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
//		Assert.assertEquals(expectedTitle,title);
//		System.out.println("Assertion pass");
		driver.quit();
//new
	}
}

