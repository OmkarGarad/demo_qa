package Listener;


import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;


public class RetryListner implements IRetryAnalyzer {
	
	int max_count =5;
			int count=0;


	public boolean retry(ITestResult result) {
		if(count<=max_count){
			count++;
			return true;
		}
		return false;
	}

}
