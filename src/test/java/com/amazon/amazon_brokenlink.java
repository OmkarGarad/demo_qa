package com.amazon;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

import org.apache.hc.core5.http.HttpConnection;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class amazon_brokenlink {
	

	
	    
@Test
public void AmazonBrokenLink() {
	
	String homePage = "https://www.amazon.in/";
	String url = "";
	  HttpURLConnection huc = null;
	  int respCode = 200;
	  int total_count =0;
	  int empty_count = 0;
	  int homepage_count = 0;
	  int brokenlink_count =0;
	  int validlink_count =0;
	
	  ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
	System.setProperty("webdriver.chrome.driver", "C:/Users/Shree/Desktop/jar/chromedriver.exe");
	WebDriver driver = new ChromeDriver(options);
	  driver.get(homePage);
	driver.manage().window().maximize();
	
	
	  List<WebElement> links = driver.findElements(By.tagName("a"));
	
	  
	  Iterator<WebElement> it = links.iterator();
		  
		  while(it.hasNext()){
		  
		  url = it.next().getAttribute("href");
		  
		//  System.out.println(url);
		  
total_count ++;

if(url==null || url.isEmpty()) {
	System.out.println(url +"URL is either not configured for anchor tag or it is empty");
	empty_count ++;
    continue;
}
if(!url.startsWith(homePage)) {
	System.out.println(url + "URL belongs to another domain, skipping it.");
	homepage_count ++;
    continue;
}
try {
	  huc = (HttpURLConnection)(new URL(url).openConnection());
	  huc.setRequestMethod("HEAD");
	huc.connect();
	respCode = huc.getResponseCode();
	   if(respCode >= 400){
		   brokenlink_count ++;
           System.out.println(url+" is a broken link");
       }
       else{
    	   validlink_count ++;
           System.out.println(url+" is a valid link");
       } }
	   catch (MalformedURLException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
} catch (IOException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();

}


}System.out.println(total_count);
System.out.println(empty_count);
System.out.println(homepage_count);
System.out.println(brokenlink_count);
System.out.println(validlink_count);
}}

		 







