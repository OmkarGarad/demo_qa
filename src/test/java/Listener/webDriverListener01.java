package Listener;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.Test;

public class webDriverListener01 {

	WebDriver driver;
	JavascriptExecutor js;
	
	@SuppressWarnings("deprecation")
	@Test
	public void checkBox() throws Exception {

		System.setProperty("webdriver.chrome.driver", "C:/Users/Shree/Desktop/jar/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		EventFiringWebDriver eventdriver = new EventFiringWebDriver(driver);
		webDriverListener02_TrackChange trackchange = new webDriverListener02_TrackChange();
		
		eventdriver.register(trackchange);
		
		eventdriver.get("https://demoqa.com/");
		eventdriver.manage().window().maximize();
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)", " ");
		Thread.sleep(3000);
		/// CLICK ON ELEMENT
		eventdriver.findElement(By.xpath("//h5[text()='Elements']")).click();
		Thread.sleep(3000);

		// click check box tab
		eventdriver.findElement(By.xpath("//span[text()='Check Box']")).click();

		eventdriver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);

		// check box drop down open
		eventdriver.findElement(By.xpath("//button[@class='rct-collapse rct-collapse-btn']")).click();

		eventdriver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);

		// check box dropdown close
		eventdriver.findElement(By.xpath("//button[@class='rct-collapse rct-collapse-btn']")).click();

		// click check box
		eventdriver.findElement(By.xpath("//span[@class='rct-checkbox']")).click();
		eventdriver.navigate().back();

	}
}
