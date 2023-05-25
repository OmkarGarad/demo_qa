package vois_prac;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class test01 {
	WebDriver driver;
	
	@Test
	public void lauch() {
		
		System.setProperty("webdriver.chrome.driver", "C:/Users/Shree/Desktop/jar/chromedriver.exe");
		 driver = new ChromeDriver();
		 driver.get("https://www.facebook.com/")
		
	}

}
