package stepdef;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
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
		System.out.println("browser opened");
	}
	@When("user navigate to url")
	public void  user_navigate_to_url() {
		driver.get(url);
		System.out.println("user navigated to url");
	}
	@When("user enter username as john and password as demo and click on login button")
	public void  user_enter_username_and_password_and_click_on_login_button() {
		login();
		System.out.println("user loged into system");
	}
	
	public void login() {
		WebElement user=driver.findElement(By.xpath("//input[@name='username']"));
		WebElement password=driver.findElement(By.xpath("//input[@name='password']"));
		user.sendKeys(username);
		password.sendKeys(pass);
		WebElement login=driver.findElement(By.xpath("//input[@value='Log In']"));
		login.click();
	}
	
	@Then("user is able to login in the application")
	public void user_is_able_to_login_in_the_application() {
		String expectedmsg="Welcome John Smiths";
		WebElement welcomemsg=driver.findElement(By.xpath("//p[@class='smallText']"));
		String msg=welcomemsg.getText();
		Assert.assertEquals(expectedmsg, msg);
		System.out.println("user is able to login into the system");
		
	}
	@Then("user click on open new account")
	public void user_click_on_open_new_account() {
		WebElement OpenAccount=driver.findElement(By.xpath("//a[text()='Open New Account']"));
		OpenAccount.click();
		
		
	}
	@When("user select account type as Saving")
	public void user_select_account_type_as_Saving() {
	Select drpdown=new Select(driver.findElement(By.id("type")));
	drpdown.selectByVisibleText("SAVINGS");
	
	
			
		
	}
	@When("user click on open new account button")
	public void user_click_on_open_new_account_button() {
	WebElement button=driver.findElement(By.xpath("//input[@value='Open New Account']"));
	button.click();
		
	}
	@Then("user will verify that new account is opened")
	public void user_will_verify_that_new_account_is_opened() {
	String expectedmsg="Account Opened!";
	WebElement msg1=driver.findElement(By.xpath("//*[@id='rightPanel']/div/div/h1"));
	String msg2=msg1.getText();
	Assert.assertEquals(expectedmsg,msg2);
	System.out.println("user successfully verified that new account is opened");
	}
	@After
	public void teardown() {
		driver.quit();
	}
}
