package com.demoqa;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import org.openqa.selenium.support.locators.RelativeLocator.RelativeBy;

public class relative_locators {
	
	@Test
	public void relative_locators() throws Exception {
	
	System.setProperty("webdriver.chrome.driver","C://Users//Shree//Desktop//jar//chromedriver_win32//chromedriver.exe");
	ChromeOptions opt = new ChromeOptions();
	opt.addArguments("--remote-allow-origins=*");
	
	WebDriver driver = new ChromeDriver(opt);
	driver.get("https://www.amazon.in/");
	driver.manage().window().maximize();
	
	
	WebElement mobiles =  driver.findElement(By.xpath("//a[@data-csa-c-content-id='nav_cs_mobiles']"));
	
	//click on best seller
	
	/*
	 * WebElement bestseller =
	 * driver.findElement(with(By.xpath("//a[@class='nav-a  ']")).toLeftOf(mobiles))
	 * ; bestseller.click();
	 */
	 
			
	
	  Thread.sleep(3000);
	  // click on todays deal 
	  WebElement today_deals =  driver.findElement(with(By.xpath("//a[@class='nav-a  ']")).toRightOf(mobiles));
	  today_deals.click();
	 

}
}