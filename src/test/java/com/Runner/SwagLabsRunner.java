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
import com.POM.SwagLabsLogin;
import com.POM.SwagLabsProductFive;
import com.POM.SwagLabsProductFour;
import com.POM.SwagLabsProductOne;
import com.POM.SwagLabsProductThree;
import com.POM.SwagLabsProductTwo;
import com.listner.ExtentReport_Test;
import com.listner.ITestListnerClass;
import com.readerfile.Frm;

@Listeners(ITestListnerClass.class)
public class SwagLabsRunner extends BaseClass {
			
	@BeforeTest
	public void setup() throws IOException {
	
		browserLaunch(Frm.getInstancefrm().getInstanceConfigurationReader().getBrowser());
		
	}
	
	@Test(priority=1)
	public void LoginTest()  {
		ExtentReport_Test.extenttest= extentReports
				.createTest("LoginTest"+":"+Thread.currentThread().getStackTrace()[1].getMethodName().toString())
				.info("Valid Email with Valid Password");
		
		SwagLabsLogin  slp =new SwagLabsLogin();
		Assert.assertTrue(slp.validLogin(ExtentReport_Test.extenttest));
	}
@Test(priority=2)
	public void invalidPassword() throws IOException  {
		ExtentReport_Test.extenttest= extentReports
				.createTest("InvalidPassword"+":"+Thread.currentThread().getStackTrace()[1].getMethodName().toString())
	     		.info("Valid Email with InValid Password");
		SwagLabsLogin  slp =new SwagLabsLogin();
		slp.invalidPass();
	
	}

@Test(priority=3)
public void blanklogin() throws IOException  {
	ExtentReport_Test.extenttest= extentReports
			.createTest("blankLogin"+":"+Thread.currentThread().getStackTrace()[1].getMethodName().toString())
     		.info("blank Email with blank Password");
	SwagLabsLogin  slp =new SwagLabsLogin();
	slp.blankloginData();

}
@Test(priority=5)
public void firstProduct() throws IOException  {
	ExtentReport_Test.extenttest= extentReports
			.createTest("FirstProduct"+":"+Thread.currentThread().getStackTrace()[1].getMethodName().toString())
     		.info("Sauce Labs Backpack");
	
	SwagLabsLogin  slp =new SwagLabsLogin();
	SwagLabsProductOne  prod1 =new SwagLabsProductOne();
	prod1.selectProductOne();

}

@Test(priority=6)
public void secondProduct() throws IOException  {
	ExtentReport_Test.extenttest= extentReports
			.createTest("SecondProduct"+":"+Thread.currentThread().getStackTrace()[1].getMethodName().toString())
     		.info("Sauce Labs Bike Light");
	
	SwagLabsLogin  slp =new SwagLabsLogin();
	SwagLabsProductTwo  prod2 =new SwagLabsProductTwo();
	prod2.selectProductTwo();

}

@Test(priority=7)
public void thirdProduct() throws IOException  {
	ExtentReport_Test.extenttest= extentReports
			.createTest("ThirdProduct"+":"+Thread.currentThread().getStackTrace()[1].getMethodName().toString())
     		.info("Sauce Labs Bolt T-Shirt");
	
	SwagLabsLogin  slp =new SwagLabsLogin();
	SwagLabsProductThree  prod3 =new SwagLabsProductThree();
	prod3.selectProductThree();

}

@Test(priority=8)
public void FourthProduct() throws IOException  {
	ExtentReport_Test.extenttest= extentReports
			.createTest("FourthProduct"+":"+Thread.currentThread().getStackTrace()[1].getMethodName().toString())
     		.info("Sauce Labs Fleece Jacket");
	
	SwagLabsLogin  slp =new SwagLabsLogin();
	SwagLabsProductFour  prod4 =new SwagLabsProductFour();
	prod4.selectProductFour();

}

@Test(priority=9)
public void FivthProduct() throws IOException  {
	ExtentReport_Test.extenttest= extentReports
			.createTest("FivthProduct"+":"+Thread.currentThread().getStackTrace()[1].getMethodName().toString())
     		.info("Sauce Labs Onesie");
	
	SwagLabsLogin  slp =new SwagLabsLogin();
	SwagLabsProductFive  prod4 =new SwagLabsProductFive();
	prod4.selectProductFive();

}
@Test(priority=4)
public void invalidEmail() throws IOException  {
	ExtentReport_Test.extenttest= extentReports
			.createTest("blankLogin"+":"+Thread.currentThread().getStackTrace()[1].getMethodName().toString())
     		.info("blank Email with blank Password");
	SwagLabsLogin  slp =new SwagLabsLogin();
	slp.invalidEmail();

}
	@AfterTest
	public void close() {
		terminateBrowser();
	}
	@BeforeSuite 
	public void startTest() {
		extentReportStart("C:\\Users\\User\\eclipse-workspace\\open_MRS\\Report");
	}
	@AfterSuite
	public void endTest() throws IOException {
		extentReportTearDown("C:\\Users\\User\\eclipse-workspace\\open_MRS\\Report\\index.html");
}
}
