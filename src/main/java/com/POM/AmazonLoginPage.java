package com.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.Baseclass.BaseClass;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class AmazonLoginPage extends BaseClass {
	
	
	
	@FindBy(id="nav-link-accountList")
	private WebElement signinbtn;
	
	@FindBy(xpath="//input[@type='email']")
	private WebElement emailid;
	
	@FindBy(xpath="//input[@class='a-button-input']")
	private WebElement continuebtn;
	
	@FindBy(xpath="//input[@type='password']")
	private WebElement password;
	
	@FindBy(id="signInSubmit")
	private WebElement signinbutton;
	
	@FindBy(xpath="//div[@class='a-alert-content'])[3]")
	private WebElement emailError;
	
	@FindBy(xpath="//div[@class='a-box-inner a-alert-container']")
	private WebElement passError;
	
	@FindBy(xpath="//div[@class='a-alert-content']")
	private WebElement emailEmpty;
	
	@FindBy(xpath="//*[contains(text(),'Enter your password')])[2]")
	private WebElement passEmpty;
	
	@FindBy(id="nav-link-accountList-nav-line-1")
	private WebElement titleText;
	
	public AmazonLoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	public boolean validLogin(ExtentTest extenttest) {
	try {
		
		launchingUrl(driver, "https://www.amazon.in/");
		clickElement(driver,signinbtn);
		inputPassing(driver, emailid,"rmtlpriya1208@gmail.com");
		clickElement(driver,continuebtn);
		inputPassing(driver,password, "priya@2025");
		clickElement(driver,signinbutton);
		//String title=titleText.getText();
		//Assert.assertEquals(title, 
				//"Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in");
		explicitWaitVisible(driver,titleText);
		Assert.assertEquals(titleText.getText(),"Hello Lakshmi");
				extenttest.log(Status.PASS,"Login Sucessfull");
	} catch (AssertionError e) {
		// TODO Auto-generated catch block
		extenttest.log(Status.FAIL,"Login Failed"+e.getMessage());
		return false;
	}
	return true;
	}
	public void invalidEmailId() {
		launchingUrl(driver, "https://www.amazon.in/");
		clickElement(driver,signinbtn);
		inputPassing(driver, emailid,"rmtlpriya1208@gmail");
		clickElement(driver,signinbtn);
		Assert.assertEquals(emailError.getText(),"Invalid email address");
}
	public void validEmailInvalidPassword() {
		launchingUrl(driver, "https://www.amazon.in/");
		clickElement(driver,signinbtn);
		inputPassing(driver, emailid,"rmtlpriya1208@gmail.com");
		clickElement(driver,continuebtn);
		inputPassing(driver,password, "priya");
		clickElement(driver,signinbutton);
		Assert.assertEquals(passError.getText(),"Your Password is incorrect");
	}
	public void emptyEmail() {
		launchingUrl(driver, "https://www.amazon.in/");
		clickElement(driver,signinbtn);
		inputPassing(driver, emailid,"");
		clickElement(driver,signinbtn);
		Assert.assertEquals(emailEmpty.getText(),"Enter your mobile number or email");
}
	public void emptyPassword() {
		launchingUrl(driver, "https://www.amazon.in/");
		clickElement(driver,signinbtn);
		inputPassing(driver, emailid,"rmtlpriya1208@gmail.com");
		clickElement(driver,continuebtn);
		inputPassing(driver,password, "");
		clickElement(driver,signinbutton);
		Assert.assertEquals(passError.getText(),"Enter your password");
	}

}
