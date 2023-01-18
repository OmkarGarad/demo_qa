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
		
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("incognito");
		opt.addArguments("start-maximized");
		
			System.setProperty("webdriver.chrome.driver", "C:/Users/Shree/Desktop/jar/chromedriver.exe");
			
			WebDriver driver = new ChromeDriver(opt);
			driver.get("https://www.amazon.in/ref=nav_logo");
			//driver.manage().window().maximize();
			

			

	}
}