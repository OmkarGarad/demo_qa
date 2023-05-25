package captcha_read_write;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.imageio.ImageIO;

import org.apache.xml.security.utils.Base64;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class mhada_login {



	
WebDriver driver;
JavascriptExecutor js;
	


	@Test
  public void f() throws InterruptedException, Exception {
		
		driver.get("https://computerizationmhada.vinsys.live/login");
		
		
		Thread.sleep(2000);
		driver.findElement(By.name("email")).sendKeys("ree-dye@mhada.com");
		
		driver.findElement(By.id("password")).sendKeys("12345678");
		
		Thread.sleep(2000);
		
	
		String currentUrl = driver.getCurrentUrl();

		URL url = new URL(currentUrl);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();

		int statusCode = connection.getResponseCode();

		
		while (driver.findElement(By.id("captcha")).getText().isEmpty())
			
		{
			driver.findElement(By.id("refresh")).click();
			
			downloadImage();
			
			String captcha = extractCaptcha();
			
		
			
			driver.findElement(By.id("captcha")).clear();
			
			driver.findElement(By.id("captcha")).sendKeys(captcha);
			
			Thread.sleep(2000);			
	
			}
		System.out.println("click submit");
		driver.findElement(By.id("m_login_signin_submit")).click();	
		Thread.sleep(3000);
		System.out.println("click submit");
		
		
		while(statusCode >= 200 && statusCode < 300) {
			
			Thread.sleep(2000);
			
			driver.navigate().back();
			
			driver.findElement(By.name("email")).sendKeys("ree-dye@mhada.com");
			
			driver.findElement(By.id("password")).sendKeys("12345678");
			
			Thread.sleep(2000);

			driver.findElement(By.id("refresh")).click();
			
			downloadImage();
			
			String captcha = extractCaptcha();
			
		
			
			driver.findElement(By.id("captcha")).clear();
			
			driver.findElement(By.id("captcha")).sendKeys(captcha);
			
		
		
		
		}
		
	}
	
	
	
  
	private String extractCaptcha() {
		Tesseract tesseract = new Tesseract();
		 try {
			  
	            tesseract.setDatapath("C://Users/Shree/Desktop/jar/Tess4J-3.4.8-src/Tess4J/tessdata");
	            
	  
	            // the path of your tess data folder
	            // inside the extracted file
	            String text = tesseract.doOCR(new File("C:/Users/Shree/Desktop/captcha_mhada_01.png"));
	  
	            // path of your image file
	            System.out.println("check1");
	            
	            System.out.print(text);
	            
	            System.out.println("check2");
	            return text;
	            
	        }
	        catch(TesseractException e) {
	            e.printStackTrace();
	            return null;
	        }
			
	}


	private void downloadImage() {
		try {
			System.out.println("check3");
		     WebElement logo = driver.findElements(By.tagName("img")).get(2);
		     
		     String logoSRC = logo.getAttribute("src");

		     URL url = new URL(logoSRC);
		     InputStream is = url.openStream();

		     FileOutputStream fos = new FileOutputStream("C:/Users/Shree/Desktop/captcha_mhada_01.png");
		     byte[] buffer = new byte[4096];
		     int length;
		     while ((length = is.read(buffer)) != -1) {
		         fos.write(buffer, 0, length);
		     }
		     is.close();
		     fos.close();

		     } catch (Exception e) {
		    	 System.out.println("in errror");
		        e.printStackTrace();
		     }
		
	}
	

	@BeforeMethod
  public void beforeMethod() {
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--remote-allow-origins=*");
	  System.setProperty("webdriver.chrome.driver","C:/Users/Shree/Desktop/jar/chromedriver.exe");
	  driver = new ChromeDriver(opt);
	  driver.manage().window().maximize();
  }
  

  @AfterMethod
  public void afterMethod() {
	 // driver.quit();
  }

	



}
