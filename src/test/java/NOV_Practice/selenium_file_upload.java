package NOV_Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class selenium_file_upload {
	@Test
	public void upload() throws Exception {
		
		
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		System.setProperty("webdriver.chrome.driver", "C:/Users/Shree/Desktop/jar/chromedriver.exe");
		
		WebDriver driver = new ChromeDriver(options);
		
		driver.get("https://www.foundit.in/seeker/registration");
		
		driver.manage().window().maximize();
		
		WebElement uploadbutton = driver.findElement(By.id("file-upload"));
		
		Thread.sleep(4000);
		
		uploadbutton.sendKeys("C:\\Users\\Shree\\Downloads\\DifficultAreaList (15).pdf");
		
	}

}
