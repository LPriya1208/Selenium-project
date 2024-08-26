package com.POM;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.PageFactoryFinder;
import org.testng.Assert;

import com.Baseclass.BaseClass;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class LoginPage extends BaseClass {
	
	
	@FindBy(id="email")
	private WebElement emailid;
	
	@FindBy(id="pass")
	private WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	private WebElement login;
	
	@FindBy(xpath="//div[contains(text(),'The email address or mobile number you entered isn't connected to an account.')]")
	private WebElement emailError;

	@FindBy(xpath="//div[contains(text(),'The password that you've entered is incorrect.')]")
	private WebElement passError;
	
	@FindBy(xpath="//div[contains(text(),'The email address or mobile number you entered isn't connected to an account.')]")
	private WebElement emailEmpty;

	@FindBy(xpath="//div[contains(text(),'The password that you've entered is incorrect.')]")
	private WebElement passEmpty;
	
	
	
	public LoginPage(WebDriver driver2) {
		this.driver =driver2;
		PageFactory.initElements(driver,this);
	}
	
	public boolean validLogin1(ExtentTest extenttest) {
		try {
			launchingUrl(driver, "https://www.facebook.com/");
			inputPassing(driver, emailid,"rmtlpriya1208@gmail.com");
			inputPassing(driver,password, "priya@2025");
			clickElement(driver,login);
			String title=driver.getTitle();
			Assert.assertEquals(title, "Facebook");
			extenttest.log(Status.PASS,"Login Sucessfull");
			
		} catch (AssertionError e) {
			// TODO Auto-generated catch block
			extenttest.log(Status.FAIL,"Login UnSucessfull"+e.getMessage());
			return false;
		}	
		return true;
	}
	
	public void invalidEmailId1() {
		launchingUrl(driver, "https://www.facebook.com/");
		inputPassing(driver, emailid,"rmtlpriya1208@gmail");
		clickElement(driver, login);
		Assert.assertEquals(emailError.getText(), "The email address or mobile number you entered isn't connected to an account.");
		
	}
	public void validEmailInvalidPassword1() {
		launchingUrl(driver, "https://www.facebook.com/");
		inputPassing(driver, emailid,"rmtlpriya1208@gmail.com");
		inputPassing(driver,password, "priya");
		clickElement(driver, login);
		Assert.assertEquals(passError.getText(), "The password that you've entered is incorrect.");
		
	}
	public void emptyEmail1() {
		launchingUrl(driver, "https://www.facebook.com/");
		inputPassing(driver, emailid,"");
		inputPassing(driver,password, "priya@2025");
		clickElement(driver, login);
		Assert.assertEquals(emailEmpty.getText(), "The email address or mobile number you entered isn't connected to an account.");
		
	}
	public void emptyPassword1() {
		launchingUrl(driver, "https://www.facebook.com/");
		inputPassing(driver, emailid,"rmtlpriya1208@gmail.com");
		inputPassing(driver,password, "");
		clickElement(driver, login);
		Assert.assertEquals(passEmpty.getText(), "The password that you've entered is incorrect.");
		
	}
}
