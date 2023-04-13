package NOV_Practice;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class selenium_file_download {
	
		

		@Test
		public void upload() throws Exception {
			
			
			
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			System.setProperty("webdriver.chrome.driver", "C:/Users/Shree/Desktop/jar/chromedriver.exe");
			
			WebDriver driver = new ChromeDriver(options);
			
			driver.get("https://www.selenium.dev/downloads/");
			
			driver.manage().window().maximize();
			
			WebElement download_button = driver.findElement(By.xpath("//a[text()='4.8.1']"));
			
			String file_url = download_button.getAttribute("href");
			
			String wget_command = "cmd /c C:\\Wget\\wget.exe -P D: --no-check-certificate " + file_url;
			
			try {
		         URL url = new URL(file_url);
		         URLConnection connection = url.openConnection();
		         connection.connect();
		         BufferedInputStream bis = new BufferedInputStream(connection.getInputStream());
		         FileOutputStream fos = new FileOutputStream("C:\\Users\\Shree/Downloads");
		         byte[] data = new byte[1024];
		         int count;
		         while ((count = bis.read(data, 0, 1024)) != -1) {
		            fos.write(data, 0, count);
		         }
		         fos.close();
		         bis.close();
		      } catch (Exception e) {
		         e.printStackTrace();
		      }



}}
