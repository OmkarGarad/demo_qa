package com.Bookstation;

import java.io.File;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.bouncycastle.pqc.jcajce.provider.rainbow.SignatureSpi.withSha224;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByTagName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v85.browser.Browser;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;
import com.demoqa.Action;

import NOV_Practice.properties_data;

public class Bookstation_login {

	WebDriver driver;
	WebDriverWait wait;
	Actions act;
	
	// This Test can Run by TestNG.xml 
	// here we used parameterization or multiple cross browser
	
	@BeforeTest
	@Parameters("browser")
	public void lauch_browser(String browser) throws Throwable {
		
	if(browser.equalsIgnoreCase("chrome")) {
		System.setProperty("webdriver.chrome.driver", "C:/Users/Shree/Desktop/jar/chromedriver.exe");
		driver = new ChromeDriver();
		
		}
	else if (browser.equalsIgnoreCase("Firefox")) {
		System.setProperty("webdriver.gecko.driver", "C:/Users/Shree/Desktop/jar/geckodriver.exe");
		driver = new FirefoxDriver();
	}
	else if (browser.equalsIgnoreCase("Edge")) {
		System.setProperty("webdriver.edge.driver", "C:/Users/Shree/Desktop/jar/msedgedriver.exe");
		driver = new EdgeDriver();
	}
	else {
		throw new Exception("Browser is not correct");
	}
	}
	
	@Test
	public void test01() {
		
	driver.get("https://uat.bookstation.in/");
	driver.manage().window().maximize();
			boolean Login_Text = driver.findElement(By.xpath("//a[contains(text(),'Login')]")).isDisplayed();
		Assert.assertTrue(Login_Text);

		WebElement Login_Account = driver.findElement(By.xpath("//a[contains(text(),'Login')]"));
		Login_Account.click();

		System.out.println(driver.getCurrentUrl());

	}

	@Test
	public void test02() throws Exception {

		wait = new WebDriverWait(driver, Duration.ofMillis(4000));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("emailid_validation")));

		driver.findElement(By.id("emailid_validation")).sendKeys("yogi.nautiyal@gmail.com");
		
		//driver.findElement(By.id("emailid_validation")).clear();
		
	WebElement cl=	driver.findElement(By.id("emailid_validation"));
	
	
			

		  driver.findElement(By.id("password_validation")).sendKeys("Admin@1234");
		  driver.findElement(By.cssSelector("input.login_btn")).click();
		  System.out.println("in");
		 
	}

	@AfterTest
	public void end() {
		driver.quit();
	}

	

}
