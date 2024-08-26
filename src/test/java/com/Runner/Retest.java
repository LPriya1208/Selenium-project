package com.Runner;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retest implements IRetryAnalyzer{
	private int retrycount =0;
	private static final int maxCount=10;
	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		if(retrycount<maxCount) {
			retrycount ++;
			return true;
		}
		return false;
	}
	

}
