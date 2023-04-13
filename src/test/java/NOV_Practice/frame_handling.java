package NOV_Practice;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.bouncycastle.jcajce.provider.asymmetric.dsa.DSASigner.noneDSA;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class frame_handling {
	
	
	WebDriver driver;
	
	
	@Test(priority=1)
	public void initiazieBrowser() throws Exception
	{
		properties_data pro = new properties_data();
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("headless");
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver(opt);
		driver.get(pro.geturl());
		driver.manage().window().maximize();
		/*
		 * WebElement fr = driver.findElement(By.id("frame1"));
		 * driver.switchTo().frame(fr);
		 */
		
		int countIframesInPage = driver.findElements(By.tagName("iframe")).size();
        System.out.println("Number of Frames on a Page:" + countIframesInPage);
        
        //Locate the frame1 on the webPage
        WebElement frame1=driver.findElement(By.id("frame1"));
        
        //Switch to Frame1
        driver.switchTo().frame(frame1);
        
        //Locate the Element inside the Frame1
        WebElement frame1Element= driver.findElement(By.tagName("body"));
        
        //Get the text for frame1 element
        String frame1Text=frame1Element.getText();
        System.out.println("Frame1 is :"+frame1Text);
        
        //Number of Frames on a Frame1
        int countIframesInFrame1 =driver.findElements(By.tagName("iframe")).size();
        System.out.println("Number of iFrames inside the Frame1:" + countIframesInFrame1);
        
        //switch to child frame
        driver.switchTo().frame(0);
        
       
        
        int countIframesInFrame2 =driver.findElements(By.tagName("iframe")).size();
        System.out.println("Number of iFrames inside the Frame2:" + countIframesInFrame2);
        
       // driver.close();
        
        
     driver.switchTo().parentFrame();
        
     //Locate the Element inside the Frame1
     WebElement childframe1Element= driver.findElement(By.tagName("body"));
     
     //Get the text for frame1 element
     String childframe1Text=childframe1Element.getText();
     System.out.println("Frame1 is :"+childframe1Text);
	

	}}


