package com.POM;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.Baseclass.BaseClass;
import com.Interface.SwagLabsInterface;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.readerfile.Frm;

public class SwagLabsLogin extends BaseClass implements SwagLabsInterface {
	
	@FindBy(id="userName") 
    private WebElement userName;
	
	@FindBy(id="password") 
	private WebElement password;
	
	@FindBy(id="login") 
	private WebElement login;
	
	@FindBy(xpath="title")
	private WebElement title;
	
	@FindBy(xpath="blanklogin")
	private WebElement blankLogin;
	
	public SwagLabsLogin()
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean validLogin(ExtentTest extenttest) {
		try {
			launchingUrl(driver, Frm.getInstancefrm().getInstanceConfigurationReader().getUrl());
			inputPassing(driver, userName,Frm.getInstancefrm().getInstanceConfigurationReader().getUserName());
			inputPassing(driver, password,Frm.getInstancefrm().getInstanceConfigurationReader().getPassword());
			clickElement(driver,login);
		   validation(driver,Frm.getInstancefrm().getInstanceConfigurationReader().getHome());
			extenttest.log(Status.PASS,"Login Successfull");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			extenttest.log(Status.FAIL,"Login UnSuccessfull"+e.getMessage());
			return false;
		}
		return true;
	}
	public void blankloginData() throws IOException {
		
		inputPassing(driver, userName,Frm.getInstancefrm().getInstanceConfigurationReader().getBlank());
		inputPassing(driver, password,Frm.getInstancefrm().getInstanceConfigurationReader().getBlank());
		clickElement(driver,login);
		validation(driver,Frm.getInstancefrm().getInstanceConfigurationReader().getHome());
		//Assert.assertEquals(blankLogin.getText(),"Epic sadface: Username and password is required");
}
	public void invalidPass() throws IOException {
			inputPassing(driver, userName,Frm.getInstancefrm().getInstanceConfigurationReader().getUserName());
			inputPassing(driver, password,Frm.getInstancefrm().getInstanceConfigurationReader().getInvalidPass());
			clickElement(driver,login);
			validation(driver,Frm.getInstancefrm().getInstanceConfigurationReader().getHome());
}
	public void invalidEmail() throws IOException {
		
		inputPassing(driver, userName,Frm.getInstancefrm().getInstanceConfigurationReader().getInvalidEmail());
		inputPassing(driver, password,Frm.getInstancefrm().getInstanceConfigurationReader().getInvalidPass());
		clickElement(driver,login);
		validation(driver,Frm.getInstancefrm().getInstanceConfigurationReader().getHome());
}
}
