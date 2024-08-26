package com.Runner;

import org.testng.annotations.Test;

import com.Baseclass.BaseClass;

public class CrossBrowser extends BaseClass{
	@Test
	 private void chrome() {
		 browserLaunch("chrome");
		  launchingUrl(driver, "https://www.amazon.in/");
		  System.out.println("Browser ID: "+ Thread.currentThread().getId());
		  terminateBrowser();  
	 }
	@Test
	 private void firefox() {
		 browserLaunch("firefox");
		  launchingUrl(driver, "https://www.amazon.in/");
		  System.out.println("Browser ID: "+ Thread.currentThread().getId());
		  terminateBrowser();  
	 }
	@Test
	 private void edge() {
		 browserLaunch("edge");
		  launchingUrl(driver, "https://www.amazon.in/");
		  System.out.println("Browser ID: "+ Thread.currentThread().getId());
		  terminateBrowser();  
	 }
	
}
