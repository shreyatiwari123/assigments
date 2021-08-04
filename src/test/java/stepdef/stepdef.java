package stepdef;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;


public class stepdef {
	WebDriver driver;
	String url="https://parabank.parasoft.com/parabank/index.htm";
	String username="john";
	String pass="demo";

//	@Before
//	public void setup() {
//		driver=new ChromeDriver();
//		
//	}
	@Given("user open the browser")
	public void user_open_the_browser() {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
	}
	@When("user navigate to url")
	public void  user_navigate_to_url() {
		driver.get(url);
	}
	@When("user enter username as john and password as demo and click on login button")
	public void  user_enter_username_and_password_and_click_on_login_button() {
		login();
	}
	
	public void login() {
		WebElement user=driver.findElement(By.xpath("//input[@name='username']"));
		WebElement password=driver.findElement(By.xpath("//input[@name='password']"));
		user.sendKeys(username);
		password.sendKeys(pass);
		WebElement login=driver.findElement(By.xpath("//input[@value='Log In']"));
		login.click();
	}
	
	
	@After
	public void teardown() {
		driver.quit();
	}
}
