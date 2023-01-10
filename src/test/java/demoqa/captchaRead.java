package demoqa;


import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;

import javax.imageio.ImageIO;

import org.apache.xml.security.utils.Base64;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import NOV_Practice.properties_data;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;


public class captchaRead {
	
WebDriver driver;
JavascriptExecutor js;
	


	@Test
  public void f() throws InterruptedException {
		driver.get("https://ott2022.vinsys.live");
		Thread.sleep(2000);
		driver.findElement(By.id("userName")).sendKeys("9923111230");
		Thread.sleep(2000);
		driver.findElements(By.className("MuiTypography-button")).get(3).click();
		Thread.sleep(1000);
		String otp = driver.findElement(By.tagName("form")).getText();
		System.out.println(otp);
		otp = otp.substring(35, 42);
		driver.findElement(By.id("loginOtp")).sendKeys(otp);
		
		while (!driver.findElement(By.tagName("button")).isEnabled())
			
		{
			js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,200)", " ");
			driver.findElements(By.className("MuiTypography-button")).get(4).click();
			downloadImage();
			String captcha = extractCaptcha();
			Thread.sleep(3000);
			js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,200)", " ");
			driver.findElement(By.id("captcha")).clear();
			driver.findElement(By.id("captcha")).sendKeys(captcha);
			Thread.sleep(2000);			
		}
		driver.findElement(By.tagName("button")).click();
		
		Thread.sleep(10000);
	}
	
  
	private String extractCaptcha() {
		Tesseract tesseract = new Tesseract();
		 try {
			  
	            tesseract.setDatapath("C://Users/Shree/Desktop/jar/Tess4J-3.4.8-src/Tess4J/tessdata");
	            
	  
	            // the path of your tess data folder
	            // inside the extracted file
	            String text
	                = tesseract.doOCR(new File("C:/Users/Shree/Desktop/captcha.jpeg"));
	  
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
		     WebElement logo = driver.findElements(By.tagName("img")).get(1);
		     String logoSRC = logo.getAttribute("src");
		     String[] baseArr = logoSRC.split(",");
		     String base64 = baseArr[baseArr.length - 1];
		     byte[] data = Base64.decode(base64);
		     ByteArrayInputStream memstream = new ByteArrayInputStream(data);
		     BufferedImage saveImage = ImageIO.read(memstream);
		     ImageIO.write(saveImage, "jpeg", new File("C:/Users/Shree/Desktop/captcha.jpeg"));
		     
		     } catch (Exception e) {
		    	 System.out.println("in errror");
		        e.printStackTrace();
		     }
		
	}
	

	@BeforeMethod
  public void beforeMethod() {
	  System.setProperty("webdriver.chrome.driver","C:/Users/Shree/Desktop/jar/chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
  }
  

  @AfterMethod
  public void afterMethod() {
	 // driver.quit();
  }

	

}
