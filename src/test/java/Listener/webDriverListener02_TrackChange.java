package Listener;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;


@SuppressWarnings("deprecation")
public class webDriverListener02_TrackChange implements WebDriverEventListener{

	public void afterAlertAccept(WebDriver driver) {
		System.out.println(1);
		
	}

	public void afterAlertDismiss(WebDriver driver) {
		System.out.println(2);
		
	}

	public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		System.out.println(3);
		
	}

	public void afterClickOn(WebElement element, WebDriver driver) {
		System.out.println(4);
		
	}

	public void afterFindBy(By by, WebElement element, WebDriver driver) {
		System.out.println(5);
		
	}

	public <X> void afterGetScreenshotAs(OutputType<X> target, X screenshot) {
		
		System.out.println(6);
	}

	public void afterGetText(WebElement element, WebDriver driver, String text) {
		System.out.println(7);
		
	}

	public void afterNavigateBack(WebDriver driver) {
		System.out.println(8);
		
	}

	public void afterNavigateForward(WebDriver driver) {
		
		System.out.println(9);
	}

	public void afterNavigateRefresh(WebDriver driver) {
		
		System.out.println(10);
	}

	public void afterNavigateTo(String url, WebDriver driver) {
		System.out.println(11);
		
	}

	public void afterScript(String script, WebDriver driver) {
		System.out.println(12);
		
	}

	public void afterSwitchToWindow(String windowName, WebDriver driver) {
		System.out.println(13);
		
	}

	public void beforeAlertAccept(WebDriver driver) {
		System.out.println(14);
		
	}

	public void beforeAlertDismiss(WebDriver driver) {
		System.out.println(15);
		
	}

	public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		System.out.println(16);
		
	}

	public void beforeClickOn(WebElement element, WebDriver driver) {
		System.out.println(17);
		
	}

	public void beforeFindBy(By by, WebElement element, WebDriver driver) {
		
		System.out.println(18);
	}

	public <X> void beforeGetScreenshotAs(OutputType<X> target) {
		System.out.println(19);
		
	}

	public void beforeGetText(WebElement element, WebDriver driver) {
		
		System.out.println(20);
	}

	public void beforeNavigateBack(WebDriver driver) {
		System.out.println(21);
		
	}

	public void beforeNavigateForward(WebDriver driver) {
		System.out.println(22);
		
	}

	public void beforeNavigateRefresh(WebDriver driver) {
		System.out.println(23);
		
	}

	public void beforeNavigateTo(String url, WebDriver driver) {
		
		System.out.println(24);
	}

	public void beforeScript(String script, WebDriver driver) {
		System.out.println(25);
		
	}

	public void beforeSwitchToWindow(String windowName, WebDriver driver) {
		
		System.out.println(26);
	}

	public void onException(Throwable throwable, WebDriver driver) {
		
		System.out.println(27);
	}

}
