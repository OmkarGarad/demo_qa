package demoqa;

import java.awt.RenderingHints.Key;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import NOV_Practice.properties_data;

@Test
public class Udemy_practice {

	
	JavascriptExecutor js;
	WebDriver driver;
	public void udemytest(){
		System.setProperty("webdriver.chrome.driver", "C:/Users/Shree/Desktop/jar/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.manage().window().maximize();
		
		WebElement id = driver.findElement(By.id("username"));
				id.sendKeys("rahulshettyacademy");
				
				WebElement pass = driver.findElement(By.id("password"));
				pass.sendKeys("learning");
				
				WebElement radio  = driver.findElement(By.xpath("//span[text()=' User']"));
				radio.click();
				
				
				
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
				
				wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//button[@id='okayBtn']")));	
				//handle pop up
				WebElement popup  = driver.findElement(By.xpath("//button[@id='okayBtn']"));
				popup.click();
				
				
				
				WebElement checkbox  = driver.findElement(By.xpath("//span[@class='text-white termsText']"));
				checkbox.click();
				
				
				WebElement signin = driver.findElement(By.id("signInBtn"));
				signin.click();
				
				driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
				
				js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollBy(0,1000)", " ");
				
				List<WebElement> add_to_cart = driver.findElements(By.xpath("//button[@class='btn btn-info']"));
				
	
				
				wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//button[@class='btn btn-info']")));
				
				for (WebElement add : add_to_cart) {
					wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//button[@class='btn btn-info']")));
					System.out.println("add_click");
					add.click();
				}
				
				WebElement Element = driver.findElement(By.xpath("//a[@class='nav-link btn btn-primary']"));
				
				 js.executeScript("arguments[0].scrollIntoView();", Element);
				 
				 Element.click();
				
	}
	@Test
	public void udemytest_windowHanle() throws Exception{
		System.setProperty("webdriver.chrome.driver", "C:/Users/Shree/Desktop/jar/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://the-internet.herokuapp.com/");
		driver.manage().window().maximize();
		
		//WebElement multiple_window = driver.findElement(By.xpath("//a[text()='Multiple Windows']"));
		
		//multiple_window.click();
		
		List<WebElement>  topic = driver.findElements(By.xpath("//a"));
		
	
		for (WebElement top_windowhandle : topic) {
			
			//System.out.println(top_windowhandle.getText());
			
			if(top_windowhandle.getText().contains("Multiple Windows")){
				top_windowhandle.click();
				System.out.println("in");
				break;
			}
				
			}
		WebElement click_child = driver.findElement(By.xpath("//a[text()='Click Here']"));
		click_child.click();
		
		System.out.println("Child Window Title" + " : " + driver.findElement(By.xpath("//h3")).getText());
		
		
		String main_window = driver.getWindowHandle();
		Set<String> child = driver.getWindowHandles();
		
		for (String s : child) {
			if(!s.equals(main_window)){
				driver.switchTo().window(main_window);
			}
		}
		
	System.out.println("Main Window Title" + " : " + driver.findElement(By.xpath("//h3")).getText());
		
				
		}
	
	
	@Test
	public void udemytest_frame() throws Exception{
		System.setProperty("webdriver.chrome.driver", "C:/Users/Shree/Desktop/jar/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://the-internet.herokuapp.com/");
		driver.manage().window().maximize();
		
		List<WebElement>  topic = driver.findElements(By.xpath("//a"));
		
		
		for (WebElement top_windowhandle : topic) {
			
			//System.out.println(top_windowhandle.getText());
			
			if(top_windowhandle.getText().contains("Nested Frames")){
				top_windowhandle.click();
				System.out.println("In");
				break;
			}
				
			}
		Thread.sleep(5000);
		driver.switchTo().frame("frame-top");
		
		driver.switchTo().frame("frame-middle");
		//driver.switchTo().frame(driver.findElement(By.xpath("//frame[@src='/frame_middle']")));
		System.out.println(driver.findElement(By.xpath("//div")).getText());
}
	@Test
	public void udemytest_check_box() throws Exception{
		System.setProperty("webdriver.chrome.driver", "C:/Users/Shree/Desktop/jar/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(4000));
		
		WebElement checkbox = driver.findElement(By.xpath("//div[@id='checkbox-example']//following::label[@for='benz']//input[@type='checkbox']"));
		checkbox.click();
		
		
		
		/*WebDriverWait w = new  WebDriverWait(driver, Duration.ofMillis(3000));
		w.until(ExpectedConditions.visibilityOfAllElements(checkbox));*/
		
		//List<WebElement> checkbox_list = driver.findElements(By.xpath("//div[@id='checkbox-example']//child::input"));
		
		List<WebElement> checkBoxName = driver.findElements(By.xpath("//div[@id='checkbox-example']//following::label[@for='benz']"));
		
	/*checkBoxName.stream().forEach(e->{
		
		String option2 = e.getText();
		System.out.println("Text :: -> "+option2);
	});
*/
		
		
		
		/*for (WebElement check : checkBoxName) {
			System.out.println(("Check"));
			if(check.isSelected()){
			
				System.out.println(("Checkk Box :: "+check.getText()));
			}
			
		}*/


}
	
	@Test
	public void google_infosys() throws Exception{
		System.setProperty("webdriver.chrome.driver", "C:/Users/Shree/Desktop/jar/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https:www.google.com");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//input[@title='Search']")).sendKeys("Infosys linkedin");
		
		Actions act = new Actions(driver);
		
		act.sendKeys(Keys.DOWN).sendKeys(Keys.ENTER).build().perform();	
		
		Thread.sleep(4000);
		
		//act.sendKeys(Keys.ENTER).build().perform();
		//Thread.sleep(4000);
		
		act.moveToElement(driver.findElement(By.xpath("//a[@href='https://in.linkedin.com/company/infosys']"))).build().perform();
		
		//act.contextClick().sendKeys(Keys.DOWN).click().build().perform();
		
		/// chord is used to multiple keys (control + enter = new tab open).(control+shift+enter= redirect to new tab))
		String clicklnk = Keys.chord(Keys.CONTROL,Keys.ENTER);
		driver.findElement(By.xpath("//a[@href='https://in.linkedin.com/company/infosys']")). sendKeys(clicklnk);
		
		String main_window = driver.getWindowHandle();
		Set<String> child_window = driver.getWindowHandles();
		
		
		for (String e : child_window) {
			if(!(main_window.equals(child_window))){
				driver.switchTo().window(e);
			}
		}
	System.out.println("DONE");

}
	
	public void relative_locators(){
		System.setProperty("webdriver.chrome.driver", "C:/Users/Shree/Desktop/jar/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.manage().window().maximize();
		
		WebElement id = driver.findElement(By.id("username"));
				id.sendKeys("rahulshettyacademy");
				
				WebElement pass = driver.findElement(By.id("password"));
				pass.sendKeys("learning");



}}
