package com.listner;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.Baseclass.BaseClass;
import com.aventstack.extentreports.MediaEntityBuilder;

public class ITestListnerClass extends BaseClass implements ITestListener{
	public String testName;
	public String methodName;
	
	@Override
	public void onTestStart(ITestResult result) {
	}
	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		try {
			ExtentReport_Test.extenttest.pass(result.getMethod().getMethodName()+":"+"Test Pass",
					MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot()).build());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void onTestFailure(ITestResult result) {
		try {
			ExtentReport_Test.extenttest.fail(result.getMethod().getMethodName()+":"+"Test Failed",
					MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot()).build());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
	}
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
	}
	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
	}

		

}
