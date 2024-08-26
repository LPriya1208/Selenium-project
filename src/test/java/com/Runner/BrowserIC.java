package com.Runner;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import com.Baseclass.BaseClass;

public class BrowserIC extends BaseClass{
	@Test(invocationCount=3)
	 private void chrome() {
		 browserLaunch("chrome");
		  launchingUrl(driver, "https://www.amazon.in/");
		  System.out.println("Browser ID: "+ Thread.currentThread().getId());
		  terminateBrowser();  
	 }
	@Test
	@Ignore
	 private void edge() {
		 browserLaunch("edge");
		  launchingUrl(driver, "https://www.amazon.in/");
		  System.out.println("Browser ID: "+ Thread.currentThread().getId());
		  terminateBrowser();  
	 }	
	@Test(timeOut=2000)
	 private void example1() {
		 browserLaunch("chrome");
		  launchingUrl(driver, "https://www.facebook.com/");
		  System.out.println("Browser ID: "+ Thread.currentThread().getId());
		  terminateBrowser();  
	 }
	@Test(enabled=false)
	 private void example2() {
		 browserLaunch("edge");
		  launchingUrl(driver, "https://www.google.com/");
		  System.out.println("Browser ID: "+ Thread.currentThread().getId());
		  terminateBrowser();  
	 }


}
