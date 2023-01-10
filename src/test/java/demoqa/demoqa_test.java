package demoqa;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.print.PrintException;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import NOV_Practice.properties_data;

@Test
public class demoqa_test {
	WebDriver driver;
	JavascriptExecutor js;
	
	
	/*
	 * @BeforeClass public void lauch() throws Exception{
	 * 
	 * System.setProperty("webdriver.chrome.driver",
	 * pro.getDriverpath()); driver = new
	 * ChromeDriver(); driver.get("https://demoqa.com/");
	 * driver.manage().window().maximize(); driver.manage().window().minimize();
	 * }
	 */

	public void Element() throws Exception {

		System.setProperty("webdriver.chrome.driver", "C:/Users/Shree/Desktop/jar/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://demoqa.com/");
		driver.manage().window().maximize();
		driver.manage().window().minimize();

		// page scroll
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)", " ");
		Thread.sleep(3000);

		/// CLICK ON ELEMENT
		driver.findElement(By.xpath("//h5[text()='Elements']")).click();
		Thread.sleep(3000);

		// ELEMENT DROPDOWN UP
		driver.findElement(By.xpath("//div[text()='Elements']//following-sibling::div")).click();
		Thread.sleep(3000);
		// ELEMENT DROPDOWN DOWN
		driver.findElement(By.xpath("//div[text()='Elements']//following-sibling::div")).click();

		// page scroll
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", " ");

		driver.findElement(By.xpath("//span[text()='Text Box']")).click();

		driver.findElement(By.id("userName")).sendKeys("Omkar Shivaji Garad");
		driver.findElement(By.id("userEmail")).sendKeys("Omkar@vinsys.com");
		driver.findElement(By.id("currentAddress")).sendKeys("Dattawadi Akurdi Pune 411035");
		driver.findElement(By.id("permanentAddress")).sendKeys("Dattawadi Akurdi Pune 411035");
		driver.findElement(By.id("submit")).click();

		driver.navigate().back();

	}

	public void checkBox() throws Exception {

		System.setProperty("webdriver.chrome.driver", "C:/Users/Shree/Desktop/jar/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://demoqa.com/");
		driver.manage().window().maximize();
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)", " ");
		Thread.sleep(3000);
		/// CLICK ON ELEMENT
		driver.findElement(By.xpath("//h5[text()='Elements']")).click();
		Thread.sleep(3000);

		// click check box tab
		driver.findElement(By.xpath("//span[text()='Check Box']")).click();

		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);

		// check box drop down open
		driver.findElement(By.xpath("//button[@class='rct-collapse rct-collapse-btn']")).click();

		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);

		// check box dropdown close
		driver.findElement(By.xpath("//button[@class='rct-collapse rct-collapse-btn']")).click();

		// click check box
		driver.findElement(By.xpath("//span[@class='rct-checkbox']")).click();
		driver.navigate().back();
		

	}

	public void radioButton() throws Exception {

		System.setProperty("webdriver.chrome.driver", "C:/Users/Shree/Desktop/jar/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://demoqa.com/");
		driver.manage().window().maximize();

		Thread.sleep(6000);

		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)", " ");
		Thread.sleep(3000);
		/// CLICK ON ELEMENT
		driver.findElement(By.xpath("//h5[text()='Elements']")).click();
		Thread.sleep(3000);

		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)", " ");

		// click Radio Button tab
		driver.findElement(By.xpath("//span[text()='Radio Button']")).click();

		boolean yesradio = driver.findElement(By.xpath("//label[@for='yesRadio']")).isEnabled();
		System.out.println(yesradio);

		// check radio is enabled
		WebElement yes_radio_enabled = driver.findElement(By.xpath("//label[@for='yesRadio']"));
		System.out.println(yes_radio_enabled.isEnabled());

		// click on yes radio button
		Thread.sleep(3000);

		WebElement yes_radio_select = driver.findElement(By.xpath("//label[@for='yesRadio']"));
		yes_radio_select.click();

		boolean yes_radio_selected = driver.findElement(By.xpath("//input[@id='yesRadio']")).isSelected();

		Thread.sleep(3000);
		System.out.println(yes_radio_selected);

		Thread.sleep(3000);
		boolean no_radio_enabled = driver.findElement(By.xpath("//input[@id='noRadio']")).isEnabled();
		System.out.println(no_radio_enabled);
		driver.navigate().back();

	}

	public void webtables() throws Exception {

		System.setProperty("webdriver.chrome.driver", "C:/Users/Shree/Desktop/jar/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://demoqa.com/");
		driver.manage().window().maximize();

		Thread.sleep(6000);

		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)", " ");
		Thread.sleep(3000);
		/// CLICK ON ELEMENT
		driver.findElement(By.xpath("//h5[text()='Elements']")).click();
		Thread.sleep(3000);

		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)", " ");

		// click web tables tab
		driver.findElement(By.xpath("//span[text()='Web Tables']")).click();

		// enter name in search box
		// driver.findElement(By.id("searchBox")).sendKeys("Cierra");
		// driver.findElement(By.id("basic-addon2")).click();

		/*
		 * String table_NAME = "Cierra"; WebElement table_search = (WebElement)
		 * driver.findElements(By .xpath(
		 * "//div[@class='rt-tbody']//child::div[@class='rt-tr-group'][1]//child::div[@class='rt-td'][1]"
		 * ));
		 */

		// all names xpath
		/*
		 * List<WebElement> table_name = driver.findElements(By .xpath(
		 * "//div[@class='rt-table']//child::div[@class='rt-tbody']//div[@class='rt-tr-group']//div[@class='rt-td']"
		 * ));
		 */

		// div[@class='rt-table']//child::div[@class='rt-tbody']//div[@class='rt-tr-group']//div[@class='rt-td']

		// div[@class='rt-table']//child::div[@class='rt-tbody']//div[@class='rt-tr-group']
		// System.out.println(table_name.size());

		List<WebElement> department = driver
				.findElements(By.xpath("//div[@class='rt-tr-group']//div[@class='rt-td'][6]"));
		System.out.println(department.size());

		//
		// department.stream().forEach(e->{
		// if(e.getText() != ""){
		// String name = e.getText().trim();
		// String dept =
		// driver.findElements(By.xpath("//div[@class='rt-tr-group']//div[@class='rt-td'][6]"));
		// }
		// }
		for (int i = 0; i < department.size(); i++) {

			String dept = driver.findElements(By.xpath("//div[@class='rt-tr-group']//div[@class='rt-td'][6]")).get(i)
					.getText();

			if (dept.length() != 1) {
				System.out.println(dept);
			} else {
				System.out.println("error");
			}
		}
	}
}