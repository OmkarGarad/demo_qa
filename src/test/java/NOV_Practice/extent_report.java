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
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;

public class extent_report {
	
	static ExtentReports report;
	static ExtentTest test;
	
	
	private String capture(WebDriver driver) throws Exception {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File Dest = new File("src/../ErrImages/" + System.currentTimeMillis()
		+ ".png");
		String errflpath = Dest.getAbsolutePath();
		FileUtils.copyFile(scrFile, Dest);
		
		//return null;
		return errflpath;
	}
	
	
	@BeforeTest
	public void startreport() {
		report = new ExtentReports(System.getProperty("user.dir")+"\\ExtentReportResults.html", true);
		test = report.startTest("pract02");
		
	}

	@Test
		public void udemytest() throws Exception{
		
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("incognito");
		opt.addArguments("start-maximized");
		
			System.setProperty("webdriver.chrome.driver", "C:/Users/Shree/Desktop/jar/chromedriver.exe");
			
			WebDriver driver = new ChromeDriver(opt);
			driver.get("https://www.amazon.in/ref=nav_logo");
			//driver.manage().window().maximize();
			
			WebElement logo  = driver.findElement(By.id("nav-logo-sprites"));
			
			System.out.println("Height :" +logo.getRect().getDimension().getHeight());
			
			test.log(LogStatus.PASS, "Navigated to the specified URL");
			test.log(LogStatus.PASS,test.addScreenCapture(capture(driver))+ "Test Pass");
			

	}
	
	@AfterTest
	public static void endTest()
	{
	report.endTest(test);
	report.flush();
	}
}