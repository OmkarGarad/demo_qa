package com.amazon;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.apache.bcel.generic.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.SendKeysAction;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.demoqa.Action;

public class amazon_prac {
	
	WebDriver driver;
	@Test
	public void  jbk_lauch_url() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		System.setProperty("webdriver.chrome.driver","C://Users//Shree//Desktop//jar//chromedriver_win32//chromedriver.exe");
		 driver = new ChromeDriver(options);
		 
		 driver.get("https://www.tutorialspoint.com/about/about_careers.htm");
		 
		 driver.manage().window().maximize();
		 
		 System.out.println("launch");
		 
		 //String l = Keys.chord(Keys.CONTROL,Keys.ENTER);
		 String l = Keys.chord(Keys.CONTROL,"T");
	      // open new tab
	      driver.findElement(By.xpath("//*[text()='Terms of Use']")).sendKeys(l);
	   
		// driver.get("https://www.amazon.in/ref=nav_logo");
		 
		 
		 //synchronization
		 
		 //___fluent
			/*
			 * Wait<WebDriver> w = new FluentWait<WebDriver>(driver).
			 * withTimeout(Duration.ofMillis(3000)).pollingEvery(Duration.ofMillis(3000)).
			 * ignoring(NoSuchElementException.class);
			 * 
			 * w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
			 * "//a[text()='Mobiles']")));
			 */
		 
		 
		 //___explicit
		// WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(4000));
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Mobiles']")));
		 
		 
		 //---implicit
		// driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
		 
		 
			/*
			 * Actions act = new Actions(driver);
			 * 
			 * 
			 * act.sendKeys(Keys.chord(Keys.CONTROL,"T")); act.build().perform();
			 */		 
		 

		 
		
			   
		 
		

}
}