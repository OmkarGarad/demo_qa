package demoqa;

import java.io.FileInputStream;

import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import NOV_Practice.properties_data;



public class Apache_POI_Excel_read_write {
	
	
	
	public void read() throws Exception{
		DataFormatter df = new DataFormatter();
		FileInputStream fis = new FileInputStream("C:/Users/Shree/Desktop/Data1.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Sheet1");
		int rows = sh.getLastRowNum();
		for(int i=0;i<rows;i++){
			int cols = sh.getRow(i).getLastCellNum();
			for(int j=0;j<cols;j++){
				Cell c = sh.getRow(i).getCell(j);
				String value = df.formatCellValue(c);
				System.out.print("  " + value);
				
			}System.out.println();
		}
		
	}
	
	public String read_cell(int row,int col) throws Exception{
		DataFormatter df = new DataFormatter();
		FileInputStream fis = new FileInputStream("C:/Users/Shree/Desktop/Data1.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Sheet1");
		Cell c = sh.getRow(row).getCell(col);
		return df.formatCellValue(c);
			
	}
	public void write_cell(int row,int col,String text) throws Exception{
	
		FileInputStream fis = new FileInputStream("C:/Users/Shree/Desktop/Data1.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Sheet1");
		sh.getRow(row).createCell(col).setCellValue(text);
		FileOutputStream fos = new FileOutputStream("C:/Users/Shree/Desktop/Data1.xlsx");
		wb.write(fos);
		fos.close();
       
		
	}
	
	
	@Test
	public void test01() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:/Users/Shree/Desktop/jar/chromedriver.exe" );
		WebDriver driver = new ChromeDriver();
		for(int i=1;i<7;i++){
		driver.get("C:/Users/Shree/Desktop/data/Omkar Training/Offline Website/Offline Website/index.html");
		driver.findElement(By.id("email")).sendKeys(read_cell(i, 0));
		driver.findElement(By.id("password")).sendKeys(read_cell(i, 1));
		driver.findElement(By.xpath("//button")).click();
		if(driver.getTitle().equals("JavaByKiran | Dashboard")){
			write_cell(i, 2, "pass");
			driver.findElement(By.linkText("LOGOUT")).click();
		}else{
			write_cell(i, 2, "fail");
			driver.navigate().refresh();
		}
	}}
	


}
