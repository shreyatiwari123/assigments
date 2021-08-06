package stepdef;


import org.junit.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class stepdef {
	WebDriver driver;
	String url="https://parabank.parasoft.com/parabank/index.htm";
	String username="john";
	String pass="demo";
	WebDriverWait wait;

	@Before
	public void setup() {
		driver=new ChromeDriver();
		wait=new WebDriverWait(driver,20);
	}
	
	@Given("user open the browser")
	public void user_open_the_browser() {
		
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
	public void user_click_on_open_new_account_button() throws InterruptedException {
		Thread.sleep(3000);
	WebElement button=driver.findElement(By.xpath("//input[@value='Open New Account']"));
	button.click();
		
	}
	@Then("user will verify that new account is opened")
	public void user_will_verify_that_new_account_is_opened() throws InterruptedException {
	String expectedmsg="Account Opened!";
	Thread.sleep(3000);
	WebElement msg1=driver.findElement(By.xpath("//h1[text()='Account Opened!']"));
	String msg2=msg1.getText();
	
	Assert.assertEquals(expectedmsg,msg2);
	System.out.println("user successfully verified that new account is opened");
	}
	 
	
	@Then("user click on transfer funds")
	public void user_click_on_transfer_funds() {
	WebElement funds=driver.findElement(By.xpath("//a[text()='Transfer Funds']"));
	funds.click();
	}
	@Then("user will click on ammount to be tranfer")
	public void user_will_click_on_ammount_to_be_tranfer() {
	WebElement ammount=driver.findElement(By.id("amount"));
	ammount.sendKeys("50000");	
	}
	@When("user will select from account and to account")
	public void user_will_select_from_account_and_to_account() throws InterruptedException {

	Select dropdown = new Select(driver.findElement(By.xpath("//select[@id='fromAccountId']")));
	Select dropdown2= new Select(driver.findElement(By.xpath("//select[@id='fromAccountId']")));
	dropdown.selectByValue("14787");
	dropdown2.selectByValue("15009");
	
	}
	
	@Then("user will click on transfer button")
	public void user_will_click_on_transfer_button() {
	WebElement button=driver.findElement(By.xpath("//input[@value='Transfer']"));
	button.click();
	}
		
	
	@After
	public void teardown() {
		driver.quit();
	}
}