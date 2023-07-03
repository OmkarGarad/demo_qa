package captcha_read_write;

import org.bouncycastle.pqc.jcajce.provider.rainbow.SignatureSpi.withSha224;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.locators.RelativeLocator.RelativeBy;
import org.testng.annotations.Test;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class kp_login {
	
	@Test
	public void login_kp() {
		
		System.setProperty("webdriver.chrome.driver","C://Users//Shree//Desktop//jar//chromedriver_win32//chromedriver.exe");
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--remote-allow-origins=*");
		
		WebDriver driver = new ChromeDriver(opt);
		
		driver.get("https://kpbsuat.vinsys.live/");
		
		driver.manage().window().maximize();
		
		
		  WebElement mail= driver.findElement(By.id("email"));
		  
		  mail.sendKeys("omkar.garad@vinsys.com");
		  
		WebElement pass= driver.findElement(with(By.id("password")).below(mail));
		pass.sendKeys("Omkar@123");
		
		WebElement login_button = driver.findElement(with(By.xpath("//button")).below(mail));
		login_button.click();
		
	}
	
	

	@Test()
	public void select_city_oneway_from_dropdown() throws Exception {
		

		 ChromeOptions options = new ChromeOptions();
		  options.addArguments("--remote-allow-origins=*");
		  System.setProperty("webdriver.chrome.driver",
		  "C://Users//Shree//Desktop//jar//chromedriver_win32//chromedriver.exe");
		  WebDriver driver = new ChromeDriver(options);
		  driver.navigate().to("https://www.makemytrip.com/"); ;
		  driver.manage().window().maximize();

		WebElement from_city = driver.findElement(By.xpath("//label[@for='fromCity']"));
		from_city.click();

		Thread.sleep(4000);

		WebElement enter_city = driver.findElement(By.xpath("//input[@placeholder='From']"));
		enter_city.sendKeys("pune");
		Thread.sleep(4000);
		Actions act1 = new Actions(driver);

		act1.sendKeys(Keys.DOWN, Keys.ENTER).build().perform();
		Thread.sleep(4000);

		WebElement to_city = driver.findElement(By.xpath("//input[@placeholder='To']"));
		to_city.sendKeys("bang");
		Thread.sleep(4000);
		act1.sendKeys(Keys.DOWN, Keys.ENTER).build().perform();

	}

}
