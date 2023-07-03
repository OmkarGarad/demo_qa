
package com.makeMyTrip;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.swing.Action;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import NOV_Practice.properties_data;

public class makeMyTrip {
	

	
	JavascriptExecutor js;
	WebDriver driver;

	/*
	 * @BeforeMethod public void before() {
	 * 
	 * ChromeOptions options = new ChromeOptions();
	 * options.addArguments("--remote-allow-origins=*");
	 * System.setProperty("webdriver.chrome.driver",
	 * "C:/Users/Shree/Desktop/jar/chromedriver.exe"); WebDriver driver = new
	 * ChromeDriver(options); driver.navigate().to("https://www.makemytrip.com/"); ;
	 * driver.manage().window().maximize();
	 * 
	 * }
	 * 
	 * @AfterMethod public void after(){ driver.close(); }
	 */

	@Test(priority=1)
	public void loginpage() throws Exception {
		
		/*
		 * ChromeOptions options = new ChromeOptions();
		 * options.addArguments("--remote-allow-origins=*");
		 * System.setProperty("webdriver.chrome.driver",
		 * "C://Users//Shree//Downloads//chromedriver_win32//chromedriver.exe");
		 * WebDriver driver = new ChromeDriver(options);
		 * driver.navigate().to("https://www.makemytrip.com/"); ;
		 * driver.manage().window().maximize();
		 */
		 
		
		
		// click on login and create account

		driver.findElement(By.xpath("//li[@data-cy='account']")).click();

		// enter mobile number
		driver.findElement(By.id("username")).sendKeys("8796311101");

		// click on send otp button
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@data-cy='continueBtn']")).click();

	}

	@Test(priority=2)
	public void currencypage() throws Exception {
		
		
		
		/*
		 * ChromeOptions options = new ChromeOptions();
		 * options.addArguments("--remote-allow-origins=*");
		 * System.setProperty("webdriver.chrome.driver",
		 * "C://Users//Shree//Downloads//chromedriver_win32//chromedriver.exe");
		 * WebDriver driver = new ChromeDriver(options);
		 * driver.navigate().to("https://www.makemytrip.com/"); ;
		 * driver.manage().window().maximize();
		 */
		 
		 
		
		
		// click on currency and language
		driver.findElement(By.xpath("//li[@class='makeFlex column makeRelative vrtlCenter conCurLang geoSwitcher']"))
				.click();

		// click on dropdown
		driver.findElement(By.xpath("//div[@class='selectConWrap']")).click();

		// LIST OF COUNTRY
		List<WebElement> country_name = driver.findElements(By.xpath("//p[@class='listRow']"));
		for (int i = 0; i < country_name.size(); i++) {
			System.out.println(country_name.get(i).getText());
		}

		// Select Country UAE
		driver.findElement(By.xpath("//p[text()='UAE']")).click();
	}

	@Test(priority=3)
	public void trip_type() {
		
		 ChromeOptions options = new ChromeOptions();
		  options.addArguments("--remote-allow-origins=*");
		  System.setProperty("webdriver.chrome.driver",
		  "C://Users//Shree//Downloads//chromedriver_win32//chromedriver.exe");
		  WebDriver driver = new ChromeDriver(options);
		  driver.navigate().to("https://www.makemytrip.com/"); ;
		  driver.manage().window().maximize();

		driver.findElement(By.xpath("//ul[@class='fswTabs latoBlack greyText']//li[1]")).click();

		List<WebElement> triptype = driver
				.findElements(By.xpath("//ul[@class='fswTabs latoBlack greyText']//li[@class='selected']"));

		for (WebElement we : triptype) {

			if (we.isDisplayed()) {
				System.out.println(we.getText());
			}

		}
		// boolean name =triptype.isSelected();
		// System.out.println(name);

		/*
		 * for (int i = 0; i < triptype.size(); i++) { // List<WebElement>
		 * trip_type_name = //
		 * driver.findElements(By.xpath("//ul[@class='fswTabs latoBlack //
		 * greyText']//li["+i+"]"));
		 * 
		 * 
		 * String trip_name = triptype.get(i).getText();
		 * System.out.println(trip_name);
		 * 
		 * 
		 * }
		 */

	}

	@Test(priority=4)
	public void Select_a_Fair_Type() throws Exception {
		
		
		/*
		 * ChromeOptions options = new ChromeOptions();
		 * options.addArguments("--remote-allow-origins=*");
		 * System.setProperty("webdriver.chrome.driver",
		 * "C://Users//Shree//Downloads//chromedriver_win32//chromedriver.exe");
		 * WebDriver driver = new ChromeDriver(options);
		 * driver.navigate().to("https://www.makemytrip.com/"); ;
		 * driver.manage().window().maximize();
		 */
		  
		  
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,200)", " ");

		Actions act = new Actions(driver);
		Thread.sleep(2000);
		WebElement student_fair = driver.findElement(By.xpath("//ul[@class='specialFareNew']//li[3]"));
		act.moveToElement(student_fair).build().perform();

		WebElement student_fair_text = driver.findElement(
				By.xpath("//ul[@class='specialFareNew']//li[3]//div[@class='specialFareTooltip whiteText']"));
		act.moveToElement(student_fair_text).build().perform();

		System.out.println(student_fair_text.getText());

		List<WebElement> fare_type = driver.findElements(By.xpath("//ul[@class='specialFareNew']//li"));
		for (int i = 0; i < fare_type.size(); i++) {
			WebElement tes = fare_type.get(i);
			act.moveToElement(tes).build().perform();
			tes.click();
			System.out.println("*****___****");
			System.out.println(tes.getText());
			Thread.sleep(2000);
		}

		/// for each loop
		/*
		 * for (WebElement fare_type_A : fare_type) { Thread.sleep(2000);
		 * act.moveToElement(fare_type_A).build().perform();
		 * fare_type_A.click(); System.out.println("*****___****");
		 * System.out.println(fare_type_A.getText()); Thread.sleep(2000); }
		 */
	}

	@Test(priority=5)
	public void close_addvertisement() throws Exception {
		
		
		  ChromeOptions options = new ChromeOptions();
		  options.addArguments("--remote-allow-origins=*");
		  System.setProperty("webdriver.chrome.driver",
		  "C://Users//Shree//Downloads//chromedriver_win32//chromedriver.exe");
		  WebDriver driver = new ChromeDriver(options);
		  driver.navigate().to("https://www.makemytrip.com/"); ;
		  driver.manage().window().maximize();
		 
		  
		  
		boolean add = driver
				.findElement(
						By.xpath("//div[@class='langCard  fixedCard bounceAni']//child::span[@class='langCardClose']"))
				.isDisplayed();
		if (add == true) {

			driver.findElement(
					By.xpath("//div[@class='langCard  fixedCard bounceAni']//child::span[@class='langCardClose']"))
					.click();
			System.out.println("found");
		} else {
			System.out.println("Advertise not found ");
		}

	}

	@Test(priority=6)
	public void oneway_from_dropdown() throws Exception {

		/*
		 * ChromeOptions options = new ChromeOptions();
		 * options.addArguments("--remote-allow-origins=*");
		 * System.setProperty("webdriver.chrome.driver",
		 * "C://Users//Shree//Downloads//chromedriver_win32//chromedriver.exe");
		 * WebDriver driver = new ChromeDriver(options);
		 * driver.navigate().to("https://www.makemytrip.com/"); ;
		 * driver.manage().window().maximize();
		 */

		Actions act1 = new Actions(driver);

		WebElement from_city = driver.findElement(By.xpath("//label[@for='fromCity']"));
		from_city.click();
		Thread.sleep(5000);
		act1.sendKeys(Keys.ARROW_DOWN).build().perform();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		// WebElement auto_suggestion_dropdown_title = driver
		// .findElement(By.xpath("//li[@id='react-autowhatever-1-section-0-item-0']"));
		// act1.moveToElement(auto_suggestion_dropdown_title).build().perform();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		List<WebElement> city_dropdown_list = driver.findElements(By.xpath("//ul[@role='listbox']/li"));

		for (int i = 0; i < city_dropdown_list.size(); i++) {
			act1.sendKeys(Keys.ARROW_DOWN).build().perform();
			String drop_name = city_dropdown_list.get(i).getText();
			System.out.println(drop_name);
			System.out.println("---***---");
			Thread.sleep(1000);

		}

		/*
		 * for (WebElement webElement : city_dropdown_list) {
		 * System.out.println(webElement.getText()); }
		 */

		//// Scroll Drop down
		// js.executeScript("document.querySelector(\"#react-autowhatever-1\").scrollTop=100");
		// js.executeScript("document.querySelector(\"#react-autowhatever-1\").scrollBy(0,100)");

		System.out.println("in bound");

		Thread.sleep(4000);
	}

	@Test(priority=7)
	public void select_city_oneway_from_dropdown() throws Exception {
		

		 ChromeOptions options = new ChromeOptions();
		  options.addArguments("--remote-allow-origins=*");
		  System.setProperty("webdriver.chrome.driver",
		  "C://Users//Shree//Downloads//chromedriver_win32//chromedriver.exe");
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

	@Test(priority=8)
	public void select_oneway_date() throws Exception {

		 ChromeOptions options = new ChromeOptions();
		  options.addArguments("--remote-allow-origins=*");
		  System.setProperty("webdriver.chrome.driver",
		  "C://Users//Shree//Downloads//chromedriver_win32//chromedriver.exe");
		  WebDriver driver = new ChromeDriver(options);
		  driver.navigate().to("https://www.makemytrip.com/"); ;
		  driver.manage().window().maximize();

		Thread.sleep(4000);
		// click on one way
		WebElement select_oneway = driver.findElement(By.xpath("//div[@class='makeFlex']/ul/li[1]"));

		select_oneway.click();

		Thread.sleep(4000);

		/// remove login POPUP
		/*
		 * try { WebElement remove_login_popup = driver.findElement(By.
		 * xpath("//div[@class='fsw_inputBox dates reDates inactiveWidget ']"));
		 * remove_login_popup.click(); } catch (Exception e) {
		 * System.out.println("Login Popup Not found"); }
		 */

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

		// remove advertisement
		Thread.sleep(4000);
		boolean add = driver
				.findElement(
						By.xpath("//div[@class='langCard  fixedCard bounceAni']//child::span[@class='langCardClose']"))
				.isDisplayed();
		if (add == true) {

			driver.findElement(
					By.xpath("//div[@class='langCard  fixedCard bounceAni']//child::span[@class='langCardClose']"))
					.click();
			System.out.println("found");
		} else {
			System.out.println("Advertise not found ");
		}
		Thread.sleep(4000);
		WebElement return_date = driver.findElement(By.xpath("//p[@class='font16 blackText latoBold']"));
		return_date.click();
		Thread.sleep(4000);
		WebElement random_click = driver.findElement(By.xpath("//div[@class='hsBackDrop']"));
		random_click.click();

	}

	@Test(priority=9)
	public void search_window() throws Exception {

		 ChromeOptions options = new ChromeOptions();
		  options.addArguments("--remote-allow-origins=*");
		  System.setProperty("webdriver.chrome.driver",
		  "C://Users//Shree//Downloads//chromedriver_win32//chromedriver.exe");
		  WebDriver driver = new ChromeDriver(options);
		  driver.navigate().to("https://www.makemytrip.com/"); ;
		  driver.manage().window().maximize();
		  
		boolean add = driver
				.findElement(
						By.xpath("//div[@class='langCard  fixedCard bounceAni']//child::span[@class='langCardClose']"))
				.isDisplayed();
		if (add == true) {

			driver.findElement(
					By.xpath("//div[@class='langCard  fixedCard bounceAni']//child::span[@class='langCardClose']"))
					.click();
			System.out.println("found");
		} else {
			System.out.println("Advertise not found ");
		}
		WebElement click_search = driver
				.findElement(By.xpath("//a[@class='primaryBtn font24 latoBold widgetSearchBtn ']"));
		click_search.click();

		Thread.sleep(4000);
		try {
			WebElement fair_lock_frame = driver
					.findElement(By.xpath("//span[@class='bgProperties icon20 overlayCrossIcon']"));
			fair_lock_frame.click();
		} catch (Exception e) {
			System.out.println("not found");

		}

	}

	@Test(priority=10)
	public void window_handling() throws Exception {

		 ChromeOptions options = new ChromeOptions();
		  options.addArguments("--remote-allow-origins=*");
		  System.setProperty("webdriver.chrome.driver",
		  "C://Users//Shree//Downloads//chromedriver_win32//chromedriver.exe");
		  WebDriver driver = new ChromeDriver(options);
		  driver.navigate().to("https://www.makemytrip.com/"); ;
		  driver.manage().window().maximize();
		  
		WebElement new_window = driver.findElement(By.xpath("//ul[@class='recentSearches']//li[1]"));
		new_window.click();

		//new_window.click();
		//new_window.click();
	//	new_window.click();
		
		Thread.sleep(4000);
		try {
			WebElement fair_lock_frame = driver
					.findElement(By.xpath("//span[@class='bgProperties icon20 overlayCrossIcon']"));
			fair_lock_frame.click();
			System.out.println("found");
		} catch (Exception e) {
			System.out.println("not found");

			
			/// FIRST WINDOW HANDLE
			String main_window_handle = driver.getWindowHandle();
			Set<String> allwindow = driver.getWindowHandles();
			Iterator<String> iterator = allwindow.iterator();

			while (iterator.hasNext()) {
				String child_window = iterator.next();
				if (!main_window_handle.equalsIgnoreCase(child_window)) {
					driver.switchTo().window(main_window_handle);
					// WebElement text =
					// driver.findElement(By.id("sampleHeading"));
					// System.out.println("Heading of child window is " +
					// text.getText());
				}

			}
		}
		
		//SECOND WINDOW HANDLE
		Thread.sleep(4000);
		new_window.click();
		Thread.sleep(4000);
		String main_window_handle = driver.getWindowHandle();
		Set<String> allwindow = driver.getWindowHandles();
		Iterator<String> iterator = allwindow.iterator();
		while (iterator.hasNext()) {
			String child_window = iterator.next();
			if (!main_window_handle.equalsIgnoreCase(child_window)) {
				Thread.sleep(4000);
				driver.switchTo().window(main_window_handle);
				// WebElement text = driver.findElement(By.id("sampleHeading"));
				// System.out.println("Heading of child window is " +
				// text.getText());
			}

		}
		
		//THIRD WINDOW HANDLE
		new_window.click();
		Thread.sleep(4000);
		new_window.click();
		Thread.sleep(4000);
	main_window_handle = driver.getWindowHandle();
		allwindow = driver.getWindowHandles();
		iterator = allwindow.iterator();

		while (iterator.hasNext()) {
			String child_window = iterator.next();
			if (!main_window_handle.equalsIgnoreCase(child_window)) {
				driver.switchTo().window(child_window);
				
				// WebElement text =
				// driver.findElement(By.id("sampleHeading"));
				// System.out.println("Heading of child window is " +
				// text.getText());
			}

			
		}
		//close main window
		//driver.close();
	
		while (iterator.hasNext()) {
			
			String child_window = iterator.next();
			if (!main_window_handle.equalsIgnoreCase(child_window)) {
				Thread.sleep(2000);
				driver.switchTo().window(child_window);
				driver.close();
				
				// WebElement text =
				// driver.findElement(By.id("sampleHeading"));
				// System.out.println("Heading of child window is " +
				// text.getText());
			}
			
			

	}
	
	}
	
	@Test(priority=11)
	public void window_handling1() throws Exception {

		 ChromeOptions options = new ChromeOptions();
		  options.addArguments("--remote-allow-origins=*");
		  System.setProperty("webdriver.chrome.driver",
		  "C://Users//Shree//Downloads//chromedriver_win32//chromedriver.exe");
		  WebDriver driver = new ChromeDriver(options);
		  driver.navigate().to("https://www.makemytrip.com/"); ;
		  driver.manage().window().maximize();
		  
		WebElement new_window = driver.findElement(By.xpath("//ul[@class='recentSearches']//li[1]"));
		new_window.click();
		
			/// FIRST WINDOW HANDLE
			String main_window_handle = driver.getWindowHandle();
			Set<String> allwindow = driver.getWindowHandles();
			//Iterator<String> iterator = allwindow.iterator();

			for (String win : allwindow) {
				if (!win.equals(main_window_handle)) {
					driver.switchTo().window(win);
					
					
					// WebElement text =
					// driver.findElement(By.id("sampleHeading"));
					// System.out.println("Heading of child window is " +
					// text.getText());
				}
				new_window.click();
					if (!win.equals(main_window_handle)) {
						driver.switchTo().window(win);
						
						//driver.close();
						// WebElement text =
						// driver.findElement(By.id("sampleHeading"));
						// System.out.println("Heading of child window is " +
						// text.getText());
					}
					if (win.equals(main_window_handle)) {
						driver.switchTo().window(main_window_handle);
						
						//driver.close();
						// WebElement text =
						// driver.findElement(By.id("sampleHeading"));
						// System.out.println("Heading of child window is " +
						// text.getText());
					}
				
			}
			//driver.switchTo().window(main_window_handle);
		}
	
	@Test(priority=12)
	public void multiple_window_handling() throws Exception {

		 ChromeOptions options = new ChromeOptions();
		  options.addArguments("--remote-allow-origins=*");
		  System.setProperty("webdriver.chrome.driver",
		  "C://Users//Shree//Downloads//chromedriver_win32//chromedriver.exe");
		  WebDriver driver = new ChromeDriver(options);
		  driver.navigate().to("https://www.makemytrip.com/"); ;
		  driver.manage().window().maximize();
		  
		Thread.sleep(5000);

		WebElement new_window = driver.findElement(By.xpath("//a[text()='Mobiles']"));
		new_window.click();
	Thread.sleep(5000);
		
		
		 /*driver.findElement(By.xpath(
				  "//div[@class='_octopus-search-result-card_style_apbSearchResultItem__2-mx4'][1]"
				  )).click(); 
		 driver.findElement(By.xpath(
				  "//div[@class='_octopus-search-result-card_style_apbSearchResultItem__2-mx4'][2]"
				  )).click(); 
		 driver.findElement(By.xpath(
				  "//div[@class='_octopus-search-result-card_style_apbSearchResultItem__2-mx4'][3]"
				  )).click(); 
		 driver.findElement(By.xpath(
				  "//div[@class='_octopus-search-result-card_style_apbSearchResultItem__2-mx4'][4]"
				  )).click(); 
		 driver.findElement(By.xpath(
				  "//div[@class='_octopus-search-result-card_style_apbSearchResultItem__2-mx4'][5]"
				  )).click(); 
		 driver.findElement(By.xpath(
				  "//div[@class='_octopus-search-result-card_style_apbSearchResultItem__2-mx4'][6]"
				  )).click(); */
	
	
	List<WebElement> mobile_tab = driver.findElements(By.xpath(
			  "//div[@class='_octopus-search-result-card_style_apbSearchResultItem__2-mx4']"
			  ));
		 for (WebElement mob_tab : mobile_tab) {
			mob_tab.click();
		}
		 
		 Set<String> handles = driver.getWindowHandles();
		 List<String> hlist = new ArrayList<String>(handles);
		 
		 
		for (String e : hlist) {
			String tilte =driver.switchTo().window(e).getTitle();
			if(tilte.contains("boAt Bassheads 100 in Ear Wired Earphones")){
				//System.out.println("found");
			System.out.println("found"+" : "+driver.getCurrentUrl()+" : " + driver.getTitle());
			driver.switchTo().window(e);
			break;
			
		}else {
			System.out.println("not found"+" : "+driver.getCurrentUrl()+" : " + driver.getTitle());
			
		} 
		
	}
	
	}
	@Test(priority=13)
	public void zerodha() throws Exception {
		

		 ChromeOptions options = new ChromeOptions();
		  options.addArguments("--remote-allow-origins=*");
		  System.setProperty("webdriver.chrome.driver",
		  "C://Users//Shree//Downloads//chromedriver_win32//chromedriver.exe");
		  WebDriver driver = new ChromeDriver(options);
		  driver.navigate().to("https://www.makemytrip.com/"); ;
		  driver.manage().window().maximize();
		  
		  
		driver.findElement(By.id("userid")).sendKeys("XI5779");
		driver.findElement(By.id("password")).sendKeys("Omkar@1234");
		driver.findElement(By.xpath("//button")).click();
		
		Thread.sleep(3000);
		driver.findElement(By.id("pin")).sendKeys("271097");
		driver.findElement(By.xpath("//button")).click();

}
	
	@Test(priority=14)
	public void lauch_firefox() {
		
		//FirefoxOptions options = new FirefoxOptions();
		 // options.addArguments("--remote-allow-origins=*");
		System.setProperty("webdriver.gecko.driver",
				"C:/Users/Shree/Desktop/jar/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.navigate().to("https://www.makemytrip.com/");
		driver.manage().window().maximize();

	}
	
	
	
	
	
	
	
	
	
}
	
	
