package drillpackage;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Program4 {
	WebDriver driver;
	void initialize() 
	{
		String chromedriverpath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", chromedriverpath +"\\Browser\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.navigate().to("http://demo.guru99.com/test/newtours/register.php");		
		driver.manage().window().maximize();
	}
	
	@SuppressWarnings("null")
	void a()
	{
		try
		{
			WebElement firstname = driver.findElement(By.name("first"));
			firstname.sendKeys("Elango");
		}
		catch(NoSuchElementException e) {
			System.out.println("No Such element Excpetion is handled");
		}
		
		try
		{							
			driver.switchTo().alert();		
		}
		catch(NoAlertPresentException e)
		{
			System.out.println("No alert Present Exception is handled");			
		}
		try
		{
			driver.switchTo().window("title");
			
		}
		catch(NoSuchWindowException e)
		{
			System.out.println("No such window Exception is handled");
		}
		
		try
		{	
			driver.close();
			driver.findElement(By.name("first")).sendKeys("firstname");;
		}
		catch(WebDriverException e)
		{
			System.out.println("Webdriver exception is handled after closing the browser");
		}
		
		try { 
            double val = Double.parseDouble("String");   
            System.out.println(val); 
        } catch(NumberFormatException e) { 
            System.out.println("Number format exception"); 
        } 
		try
		{
			String arr[] = {"Hi","Hello"};
			System.out.println(arr[2]);
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			System.out.println("Arrya index out of bound excpetion");
		}
		
		try
        {
            ArithmeticException ae = new ArithmeticException();
            throw ae;
        }
        catch (ArithmeticException e)
        {
            System.out.println("Caught the manually thrown Arithmetic Exception");
        }
		
		 try { 
	            String val = null;  
	            System.out.println(val.charAt(1)); 
	        } catch(NullPointerException e) { 
	            System.out.println("NullPointerException is handled"); 
	        } 
	}
	
	void b()
	{
		initialize();
		WebElement firstname = driver.findElement(By.name("firstName"));
		firstname.sendKeys("Elango");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement lastName =driver.findElement(By.name("lastName"));
		lastName.sendKeys("Chennai");
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(lastName));
		
	}
	public static void main(String args[])
	{
		Program4 pgm4 = new Program4();
		pgm4.initialize();
		pgm4.a();
	}
}
