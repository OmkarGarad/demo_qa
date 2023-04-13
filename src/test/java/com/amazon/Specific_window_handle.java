package com.amazon;

import java.sql.Driver;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import NOV_Practice.properties_data;

public class Specific_window_handle {
	
	static WebDriver driver;
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver",
				"C:/Users/Shree/Desktop/jar/chromedriver.exe");
		 driver = new ChromeDriver();
		driver.navigate().to("https://www.amazon.in/");
		;
		driver.manage().window().maximize();

		WebElement new_window = driver.findElement(By.xpath("//a[text()='Mobiles']"));
		new_window.click();
	
		 driver.findElement(By.xpath(
				  "//div[@class='_octopus-search-result-card_style_apbSearchResultItem__2-mx4'][1]"
				  )).click(); 
		
		 driver.findElement(By.xpath(
				  "//div[@class='_octopus-search-result-card_style_apbSearchResultItem__2-mx4'][1]"
				  )).click(); 
		 driver.findElement(By.xpath(
				  "//div[@class='_octopus-search-result-card_style_apbSearchResultItem__2-mx4'][2]"
				  )).click(); 
		 driver.findElement(By.xpath(
				  "//div[@class='_octopus-search-result-card_style_apbSearchResultItem__2-mx4'][3]"
				  )).click(); 
		 driver.findElement(By.xpath(
				  "//div[@class='_octopus-search-result-card_style_apbSearchResultItem__2-mx4'][4]"
				  )).click(); 
		 driver.findElement(By.xpath(
				  "//div[@class='_octopus-search-result-card_style_apbSearchResultItem__2-mx4'][5]"
				  )).click(); 
		 driver.findElement(By.xpath(
				  "//div[@class='_octopus-search-result-card_style_apbSearchResultItem__2-mx4'][6]"
				  )).click(); 
		 
		 Set<String> handles = driver.getWindowHandles();
		 List<String> hlist = new ArrayList<String>(handles);
		 if(switchToRightWindow("boAt Airdopes", hlist)){
			 System.out.println("found url"+driver.getCurrentUrl()+":"+ driver.getTitle());
		 }


	}

	public static boolean  switchToRightWindow(String windowTitle , List<String>hlist){
		
		for (String e : hlist) {
			String title =driver.switchTo().window(e).getTitle();
		if(title.contains(windowTitle)){
			System.out.println("Found ");
			return true;
		}
		
		}
		return false;
		
	}
	
	
}
