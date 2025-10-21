package com.selenium.testng1;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
 
public class RetryClass implements IRetryAnalyzer {
	
	int retry = 2;
	int count = 0;
	public boolean retry(ITestResult result) {
		if (count < retry) {
			count++;
			return true;
		}
		return false;
	}
}
