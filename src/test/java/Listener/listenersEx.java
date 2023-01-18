package Listener;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class listenersEx implements ITestListener {
	public void onTestStart(ITestResult result) {
		System.out.println("testcase started with name " + result.getName());
		System.out.println("start time" + new java.util.Date());
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("testcase passedwith name " + result.getName());
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("testcase failed with name " + result.getName());
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("testcase skipped with name " + result.getName());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}

	public void onStart(ITestContext context) {
		System.out.println("suite started");
	}

	public void onFinish(ITestContext context) {
		System.out.println("suite finished" + context.getName());
	}
}
