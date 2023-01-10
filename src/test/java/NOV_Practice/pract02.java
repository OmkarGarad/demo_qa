package NOV_Practice;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class pract02 {

	@Test
		public void udemytest() throws Exception{
			System.setProperty("webdriver.chrome.driver", "C:/Users/Shree/Desktop/jar/chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.get("file:///C:/Users/Shree/Desktop/data/Omkar%20Training/Offline%20Website/Offline%20Website/pages/examples/logout.html");
			driver.manage().window().maximize();
			

			WebElement logo = driver.findElement(By.xpath("//button"));
			
			TakesScreenshot ts = (TakesScreenshot)driver;
			File src = logo.getScreenshotAs(OutputType.FILE);
			File dest = new File("logo.png");
			FileUtils.copyFile(src, dest);
			
			 driver.switchTo().newWindow(WindowType.WINDOW);
			   driver.navigate().to("https://www.crmpro.com/");
}

	
}