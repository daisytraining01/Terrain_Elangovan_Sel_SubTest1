package drillpackage;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Program2 {
	int rowCount = -1;
	WebDriver driver;
	String filepath = System.getProperty("user.dir") + "\\Browser\\";
	void initialize() 
	{
		String chromedriverpath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", chromedriverpath +"\\Browser\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.navigate().to("https://www.w3schools.com/sql/sql_syntax.asp");		
		driver.manage().window().maximize();
	}
	
	public void writexl() throws FileNotFoundException, IOException
	{	    		
		int columnCount = -1;
		@SuppressWarnings("resource")
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("Pgm2");
		Row row = sheet.createRow(++rowCount);
        List<WebElement> header = driver.findElements(By.xpath("//table[@class='w3-table-all notranslate']/tbody/tr[1]//th"));
    	for(WebElement el : header)
    	{
    			System.out.println(el.getText());    			
    			Cell cell = row.createCell(++columnCount);
    			cell.setCellValue(el.getText());
    	}
    	//Row2
    	row = sheet.createRow(1);
    	columnCount = -1;
        List<WebElement> row2 = driver.findElements(By.xpath("//table[@class='w3-table-all notranslate']/tbody/tr[2]/td"));
    	for(WebElement el : row2)
    	{
    			System.out.println(el.getText());    			
    			Cell cell = row.createCell(++columnCount);
    			cell.setCellValue(el.getText());
    	}
    	//Row3
    	row = sheet.createRow(2);
    	columnCount = -1;
        List<WebElement> row3 = driver.findElements(By.xpath("//table[@class='w3-table-all notranslate']/tbody/tr[3]/td"));
    	for(WebElement el : row3)
    	{
    			System.out.println(el.getText());    			
    			Cell cell = row.createCell(++columnCount);
    			cell.setCellValue(el.getText());
    	}
    	//Row4
    	row = sheet.createRow(3);
    	columnCount = -1;
        List<WebElement> row4 = driver.findElements(By.xpath("//table[@class='w3-table-all notranslate']/tbody/tr[4]/td"));
    	for(WebElement el : row4)
    	{
    			System.out.println(el.getText());    			
    			Cell cell = row.createCell(++columnCount);
    			cell.setCellValue(el.getText());
    	}
    	//Row5
    	row = sheet.createRow(4);
    	columnCount = -1;
        List<WebElement> row5 = driver.findElements(By.xpath("//table[@class='w3-table-all notranslate']/tbody/tr[5]/td"));
    	for(WebElement el : row5)
    	{
    			System.out.println(el.getText());    			
    			Cell cell = row.createCell(++columnCount);
    			cell.setCellValue(el.getText());
    	}
    	
    	//Row6
    	row = sheet.createRow(5);
    	columnCount = -1;
        List<WebElement> row6 = driver.findElements(By.xpath("//table[@class='w3-table-all notranslate']/tbody/tr[6]/td"));
    	for(WebElement el : row6)
    	{
    			System.out.println(el.getText());    			
    			Cell cell = row.createCell(++columnCount);
    			cell.setCellValue(el.getText());
    	}
        try (FileOutputStream outputStream = new FileOutputStream("JavaBooks.xls")) {
            workbook.write(outputStream);
        }
    }	



public static void main (String args[]) throws FileNotFoundException, IOException
{
	Program2 pgm2 = new Program2();
	pgm2.initialize();
	pgm2.writexl();
}

}
