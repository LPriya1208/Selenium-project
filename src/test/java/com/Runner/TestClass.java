package com.Runner;

import org.testng.annotations.Test;

import com.Baseclass.BaseClass;

public class TestClass extends BaseClass {
  @Test
  private void browserLaunch()
  {
	  browserLaunch("chrome");
	  launchingUrl(driver, "https://www.amazon.in/");
	  
  }
@Test(priority = -2)
  private void search() {
	  
  }
@Test(priority = 5)					
private void close() {
	driver.quit();
	  
}
}
