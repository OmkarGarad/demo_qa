package com.apacheExcel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

import NOV_Practice.properties_data;



public class Apache_POI_Excel {
	
	
	
	public void read_excelXLSX() throws Exception{
	
		DataFormatter df = new DataFormatter();
	FileInputStream fis = new FileInputStream("C:/Users/Shree/Desktop/Akash.xlsx");
	Workbook wb = WorkbookFactory.create(fis);
	Sheet sh = wb.getSheet("Sheet1");
	int rows = sh.getLastRowNum();
	for(int i=0;i<=rows;i++){
		int cols = sh.getRow(i).getLastCellNum();
		for(int j=0;j<cols;j++){
			Cell c = sh.getRow(i).getCell(j);
			String value = df.formatCellValue(c);
			System.out.print(value+" | ");
		}
		System.out.println();
		
	}
	
	}
@Test
public void test01() throws Exception{
read_excelXLSX();	
}
	
	


}
