package com.Runner;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Baseclass.BaseClass;
import com.POM.AmazonLoginPage;
import com.POM.LoginPage;
import com.listner.ExtentReport_Test;
import com.listner.ITestListnerClass;

@Listeners(ITestListnerClass.class)
public class AmazonRunner extends BaseClass {
	
	public static WebDriver driver;
	
	@BeforeTest
	public void setup() {
		driver =BaseClass.browserLaunch("chrome");
	}
	
	@Test(priority=-1)
	public static void validLoginTest()
	{
		ExtentReport_Test.extenttest= extentReports
				.createTest("LoginTest"+":"+Thread.currentThread().getStackTrace()[1].getMethodName().toString())
				.info("Valid Email with Valid Password");
		AmazonLoginPage lp =new AmazonLoginPage(driver);
		Assert.assertTrue(lp.validLogin(ExtentReport_Test.extenttest));
	}
	@Test(priority=0)
	public static void invalidEmail()
	{
		ExtentReport_Test.extenttest= extentReports
				.createTest("LoginTest"+":"+Thread.currentThread().getStackTrace()[1].getMethodName().toString())
				.info("InValid Email with Valid Password");
		AmazonLoginPage lp =new AmazonLoginPage(driver);
	    lp.invalidEmailId();
	}
	@Test(priority=1)
	public static void validEmailInvalidPass()
	{
		ExtentReport_Test.extenttest= extentReports
				.createTest("LoginTest"+":"+Thread.currentThread().getStackTrace()[1].getMethodName().toString())
				.info("Valid Email with InValid Password");
		AmazonLoginPage lp =new AmazonLoginPage(driver);
		lp.validEmailInvalidPassword();
	}
	
	@Test(priority=2)
	public static void emptyEmailId()
	{
		ExtentReport_Test.extenttest= extentReports
				.createTest("LoginTest"+":"+Thread.currentThread().getStackTrace()[1].getMethodName().toString())
				.info("Empty Email");
		AmazonLoginPage lp =new AmazonLoginPage(driver);
		lp.emptyEmail();
	}
	
	@Test(priority=3)
	public static void emptyPass()
	{
		ExtentReport_Test.extenttest= extentReports
				.createTest("LoginTest"+":"+Thread.currentThread().getStackTrace()[1].getMethodName().toString())
				.info("Empty Password");
		AmazonLoginPage lp =new AmazonLoginPage(driver);
		lp.emptyPassword();
	}
	
	@AfterTest
	public void browserClose() {
		terminateBrowser();
	}
	
	@BeforeSuite
	public  void extendStarttup() {
	extentReportStart("C:\\Users\\User\\eclipse-workspace\\open_MRS\\Report");
}

	@AfterSuite
	public void extendReportEnd() throws IOException {
	extentReportTearDown("C:\\Users\\User\\eclipse-workspace\\open_MRS\\Report\\index.html");
}

}
