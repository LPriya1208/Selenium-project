package com.listner;

import java.io.IOException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.Baseclass.BaseClass;
import com.aventstack.extentreports.ExtentTest;

public class ExtentReport_Test {
	
	public static ExtentTest extenttest;
	
	public void extentTestReportStartup() {
		BaseClass b =new BaseClass();
		b.extentReportStart(null);
		
	}
	
	public void extentTestReportEnd() throws IOException{
		BaseClass b =new BaseClass();
		b.extentReportTearDown(null);
		
	}

}
