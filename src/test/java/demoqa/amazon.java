package demoqa;

import java.time.Duration;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class amazon {

		  
		WebDriver driver;
		
		@Test(priority=1)
		public void initiazieBrowser()
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			driver.get("https://www.amazon.in/ref=nav_logo");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
		}
		
		@Test(priority=2)
		public void addProduct()
		{
			WebElement searchbox=driver.findElement(By.id("twotabsearchtextbox"));
			searchbox.click();
			searchbox.sendKeys("mens shoes");
			searchbox.sendKeys(Keys.ENTER);
		
				
			
			JavascriptExecutor js=(JavascriptExecutor)driver; 
			js.executeScript("window.scrollBy(0,550)", "");
			WebElement shoe=driver.findElement(By.xpath("//span[text()='Men Seawalk IDP Sneakers']"));
		
			shoe.click();
			
			
			
			Set<String> handles=driver.getWindowHandles();
			Iterator <String> it=handles.iterator();
			String parent=it.next();
			String child=it.next();
			driver.switchTo().window(child);			// switch to child window
			
			js.executeScript("window.scrollBy(0,500)", "");
			
			driver.findElement(By.xpath("//input[@title='Add to Shopping Cart']")).click();    	// add cart button click
			driver.findElement(By.id("nav-cart-count-container")).click();      // click on cart icon
			
			
			
			driver.manage().timeouts().implicitlyWait(Duration.ofMillis(3000));
			 
			WebDriverWait w = new WebDriverWait(driver, Duration.ofMillis(3000));
			w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(child)));
			
			
			 Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofMillis(1000))
					 .pollingEvery(Duration.ofMillis(2000)).ignoring(NoSuchMethodException.class);
			 
			 
		
		
		
	}


}
