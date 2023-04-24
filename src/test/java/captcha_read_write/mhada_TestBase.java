package captcha_read_write;

import javax.swing.JOptionPane;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class mhada_TestBase {
	
	
	
	/*
	 * WebDriver driver; JavascriptExecutor js;
	 * 
	 * 
	 * 
	 * @BeforeTest public void beforeMethod() { ChromeOptions opt = new
	 * ChromeOptions(); opt.addArguments("--remote-allow-origins=*");
	 * System.setProperty("webdriver.chrome.driver",
	 * "C:/Users/Shree/Desktop/jar/chromedriver.exe"); driver = new
	 * ChromeDriver(opt); driver.manage().window().maximize();
	 * driver.get("https://computerizationmhada.vinsys.live/login"); }
	 * 
	 * 
	 * @Test public void f() throws InterruptedException {
	 * 
	 * 
	 * Thread.sleep(2000);
	 * driver.findElement(By.name("email")).sendKeys("ree-dye@mhada.com");
	 * 
	 * driver.findElement(By.id("password")).sendKeys("12345678");
	 * 
	 * }
	 * 
	 * @AfterTest public void afterMethod() { driver.close(); }
	 * 
	 */




	/*public class Login {
		WebDriver driver;
	  @Test
	  public void Launch_URL() throws Exception
	  {
		  ChromeOptions options = new ChromeOptions();
		  options.addArguments("--remote-allow-origins=*");
		  System.setProperty("webdriver.chrome.driver", "C:/Users/Shree/Desktop/jar/chromedriver.exe");
		  WebDriver driver=new ChromeDriver(options);
		  driver.get("https://computerizationmhada.vinsys.live/login");
		  driver.manage().window().maximize();
	  
		System.out.println("dsnbf");
		Thread.sleep(3000);
		driver.findElement(By.name("email")).sendKeys("testarcht@vinsys.com");
		 System.out.println("email inserted");
		 driver.findElement(By.id("password")).sendKeys("12345678");
		 System.out.println("password inserted");
		 String captchaVal = JOptionPane.showInputDialog("Please enter the captcha value:");
		 driver.findElement(By.name("captcha")).sendKeys(captchaVal);
		 System.out.println("entered captcha");
		 driver.findElement(By.id("m_login_signin_submit")).click();
		 System.out.println("login button clicked");
	}
	@Test
	public void close(){
		System.out.println("dsbhfhj");
	}*/


	
		WebDriver driver;
		
	  @Test
	  public void Launch_URL() throws Exception
	  {
		  ChromeOptions options = new ChromeOptions();
		  options.addArguments("--remote-allow-origins=*");
		  System.setProperty("webdriver.chrome.driver", "C:/Users/Shree/Downloads/chromedriver_win32 (2)/chromedriver.exe");
		  WebDriver driver=new ChromeDriver(options);
		  driver.get("https://computerizationmhada.vinsys.live/login");
		  driver.manage().window().maximize();
	  }
	  
	  @Test(priority=2)
	  public void AppLogin() throws InterruptedException
	  {
	  
		System.out.println("dsnbf");
		Thread.sleep(3000);
		driver.findElement(By.name("email")).sendKeys("testarcht@vinsys.com");
		 System.out.println("email inserted");
		 driver.findElement(By.id("password")).sendKeys("12345678");
		 System.out.println("password inserted");
		 String captchaVal = JOptionPane.showInputDialog("Please enter the captcha value:");
		 driver.findElement(By.name("captcha")).sendKeys(captchaVal);
		 System.out.println("entered captcha");
		 driver.findElement(By.id("m_login_signin_submit")).click();
		 System.out.println("login button clicked");
	}
	  
	@Test(priority=3)
	public void close(){
		System.out.println("CLOSED THE DRIVER");
	}


	}


