package Listener;


import org.testng.Assert;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(listenersEx.class)

public class RetryListenerClass {

	@Test (retryAnalyzer = RetryListner.class )
	public void test01() throws Exception {
		Thread.sleep(100);
		System.out.println(1);
	}

	@Test (retryAnalyzer = RetryListner.class )
	public void test02() throws Exception {
		Thread.sleep(500);

		System.out.println(2);
		Assert.fail();
	}

	@Test (retryAnalyzer = RetryListner.class ) 
	public void test03(){ 
		//Assert.fail(); 
		System.out.println(3);
		}

	@Test(retryAnalyzer = RetryListner.class )
	public void test04() {

		System.out.println(4);
	}

	@Test(retryAnalyzer = RetryListner.class )
	public void test05() {

		System.out.println(5);
		//Assert.fail();
	}

	@Test(retryAnalyzer = RetryListner.class )
	public void test06() {
		System.out.println(6);
	}

	@Test(retryAnalyzer = RetryListner.class )
	public void test07() {
		System.out.println(7);
		System.out.println("omkar");
	}

}
