package drillpackage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Program5 {
	
	WebDriver driver;
	void initialize() 
	{
		String chromedriverpath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", chromedriverpath +"\\Browser\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.navigate().to("http:google.com");		
		driver.manage().window().maximize();
		driver.findElement(By.name("q")).sendKeys("Selenium tutorial");
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		List<WebElement> elements = driver.findElements(By.xpath("//h3[@class='LC20lb DKV0Md']"));
		for(WebElement lnk: elements)
		{
			System.out.println(lnk.getText());
		}
		
	}
	
	public static void main(String args[])
	{
		Program5 pgm5 = new Program5();
		pgm5.initialize();
	}

}
