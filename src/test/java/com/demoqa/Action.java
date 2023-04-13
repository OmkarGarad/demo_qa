package com.demoqa;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.security.Key;
import java.util.concurrent.ConcurrentHashMap.KeySetView;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import NOV_Practice.properties_data;

public class Action {
	WebDriver driver;
	
	
	@Test
	public void newtab() throws Exception{
		
		
		System.setProperty("webdriver.chrome.driver", "C:/Users/Shree/Desktop/jar/chromedriver.exe");
		 driver = new ChromeDriver();
		driver.get("https://demoqa.com/");
		driver.manage().window().maximize();
		
	Actions act = new Actions(driver);
	WebElement move = driver.findElement(By.xpath("//div[@class='home-banner']")); 
	System.out.println(move.getLocation());
	act.moveToElement(move);
	act.contextClick().build().perform();
	
	act.sendKeys("C");
	
	/*
	 * Robot robot = new Robot(); robot.keyPress(KeyEvent.VK_DOWN);
	 * robot.keyPress(KeyEvent.VK_DOWN); robot.keyRelease(KeyEvent.VK_DOWN);
	 * robot.keyPress(KeyEvent.VK_ENTER); robot.keyRelease(KeyEvent.VK_ENTER);
	 */
	//act.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();

}

}
