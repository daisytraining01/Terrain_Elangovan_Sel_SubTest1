package drillpackage;
import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Program1 
{
	WebDriver driver;
	
	void initialize() 
	{
		String chromedriverpath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", chromedriverpath +"\\Browser\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.navigate().to("http://demo.guru99.com/test/newtours/register.php");		
		driver.manage().window().maximize();
	}
	
	//Select values from dropdown
	void a()
	{
		WebElement element = driver.findElement(By.name("country"));
		Select ddl = new Select(element);
		ddl.selectByValue("AUSTRALIA");
	}
	
	//Fetch the values and display
	void b()
	{
		WebElement firstname = driver.findElement(By.name("firstName"));
		firstname.sendKeys("Elango");
		System.out.println("The first name is " + firstname.getAttribute("value"));
		WebElement lastName =driver.findElement(By.name("lastName"));
		lastName.sendKeys("Chennai");
		System.out.println("The last name is " + lastName.getAttribute("value"));
		WebElement phone =driver.findElement(By.name("phone"));
		phone.sendKeys("8765432456");
		System.out.println("The phone number is " + phone.getAttribute("value"));
		WebElement userName =driver.findElement(By.name("userName"));		
		userName.sendKeys("Elango@gmail.com");
		System.out.println("The userName is " + userName.getAttribute("value"));
		WebElement address1 =driver.findElement(By.name("address1"));
		address1.sendKeys("Nehru street");
		System.out.println("The address1 is " + address1.getAttribute("value"));
		WebElement city =driver.findElement(By.name("city"));
		city.sendKeys("Chennai");
		System.out.println("The city is " + city.getAttribute("value"));
		WebElement state =driver.findElement(By.name("state"));
		state.sendKeys("TN");
		System.out.println("The state is " + state.getAttribute("value"));
		WebElement postalCode =driver.findElement(By.name("postalCode"));
		postalCode.sendKeys("600018");
		System.out.println("The postalCode is " + postalCode.getAttribute("value"));
		WebElement element = driver.findElement(By.name("country"));
		Select ddl = new Select(element);
		ddl.selectByValue("INDIA");		
		WebElement email =driver.findElement(By.id("email"));
		email.sendKeys("elangoc");
		System.out.println("The email is " + email.getAttribute("value"));
		WebElement password =driver.findElement(By.name("password"));
		password.sendKeys("Elango@guru99");
		System.out.println("The password is " + password.getAttribute("value"));
		WebElement confirmPassword = driver.findElement(By.name("confirmPassword"));
		confirmPassword.sendKeys("Elango@guru99");
		System.out.println("The confirmPassword is " + confirmPassword.getAttribute("value"));
		driver.findElement(By.name("submit")).click();
	}
	//Printing the post completion
	void c()
	{
		WebDriverWait wait = new WebDriverWait(driver, 3);
		WebElement msg = driver.findElement(By.xpath("//a[@href='login.php']"));
		if(msg.getText().equals(" sign-in "))
		{
			System.out.println(driver.findElement(By.xpath("//a[@href='login.php' ]/..")).getText());
		}
		else
		{
			Assert.fail("The Registration is failed.");
		}
	}
	
	//Fetch the confirmation report
	void d()
	{
		System.out.println(driver.findElement(By.xpath("//a[@href='login.php' ]/..")).getText());
	}
	
	//Multiple records
	void e()
	{
		driver.navigate().to("http://demo.guru99.com/test/newtours/register.php");		
		driver.manage().window().maximize();
		WebElement firstname = driver.findElement(By.name("firstName"));
		firstname.sendKeys("Elangovan");
		System.out.println("The first name is " + firstname.getAttribute("value"));
		WebElement lastName =driver.findElement(By.name("lastName"));
		lastName.sendKeys("India");
		System.out.println("The last name is " + lastName.getAttribute("value"));
		WebElement phone =driver.findElement(By.name("phone"));
		phone.sendKeys("987654321");
		System.out.println("The phone number is " + phone.getAttribute("value"));
		WebElement userName =driver.findElement(By.name("userName"));		
		userName.sendKeys("Elangov23@gmail.com");
		System.out.println("The userName is " + userName.getAttribute("value"));
		WebElement address1 =driver.findElement(By.name("address1"));
		address1.sendKeys("Gandhi street");
		System.out.println("The address1 is " + address1.getAttribute("value"));
		WebElement city =driver.findElement(By.name("city"));
		city.sendKeys("Tiruchy");
		System.out.println("The city is " + city.getAttribute("value"));
		WebElement state =driver.findElement(By.name("state"));
		state.sendKeys("TN");
		System.out.println("The state is " + state.getAttribute("value"));
		WebElement postalCode =driver.findElement(By.name("postalCode"));
		postalCode.sendKeys("600020");
		System.out.println("The postalCode is " + postalCode.getAttribute("value"));
		WebElement element = driver.findElement(By.name("country"));
		Select ddl = new Select(element);
		ddl.selectByValue("AUSTRALIA");		
		WebElement email =driver.findElement(By.id("email"));
		email.sendKeys("elangod");
		System.out.println("The email is " + email.getAttribute("value"));
		WebElement password =driver.findElement(By.name("password"));
		password.sendKeys("Elangod@guru");
		System.out.println("The password is " + password.getAttribute("value"));
		WebElement confirmPassword = driver.findElement(By.name("confirmPassword"));
		confirmPassword.sendKeys("Elangod@guru");
		System.out.println("The confirmPassword is " + confirmPassword.getAttribute("value"));
		driver.findElement(By.name("submit")).click();
		c();
		d();
	}
	//Negtive scenario
	void f()
	{
		driver.navigate().to("http://demo.guru99.com/test/newtours/register.php");		
		driver.manage().window().maximize();
		WebElement password =driver.findElement(By.name("password"));
		password.sendKeys("Elangod@guru");
		driver.findElement(By.name("submit")).click();
		WebElement errmsg = driver.findElement(By.xpath("//span[text()='PAssword and con.password does not match']"));
		if(errmsg.isDisplayed())
		{
			System.out.println("Error message is displayed");
		}
		else
		{
			Assert.fail("Error message is not displayed");
		}
	}
	void g()
	{
		TakesScreenshot srcshot = ((TakesScreenshot) driver);
		File srcfile = srcshot.getScreenshotAs(OutputType.FILE);
		
	}
	public static void main(String args[]) 
	{		
		Program1 pgm1 = new Program1();
		pgm1.initialize();
		pgm1.a();
		pgm1.b();
		pgm1.c();
		pgm1.d();
		pgm1.e();		
	}
}
