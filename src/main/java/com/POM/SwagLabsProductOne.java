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

public class SwagLabsProductOne extends BaseClass implements SwagLabsInterface {
	
	@FindBy(xpath="product_one") 
    private WebElement productOne;
	
	@FindBy(xpath="addtocart") 
	private WebElement addToCart;
	
	@FindBy(xpath="cart_badge") 
	private WebElement cartBadge;
	
	@FindBy(xpath="checkout")
	private WebElement checkOut;
	
	@FindBy(xpath="first_name")
	private WebElement firstName;
	
	@FindBy(xpath="last_name")
	private WebElement lastName;
	
	@FindBy(xpath="postal_code")
	private WebElement postalCode;
	
	@FindBy(xpath="continue_btn")
	private WebElement continueButton;
	
	@FindBy(xpath="finish")
	private WebElement finishbutton;
	
	@FindBy(xpath="confirmtext")
	private WebElement confirmText;
	
	@FindBy(xpath="menu_button")
	private WebElement menuButton;
	
	@FindBy(xpath="logout")
	private WebElement logOut;
	
	public void SwagLabsProductOne()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void selectProductOne() throws IOException
	{  
		String text = getText(driver, productOne);
		clickElement(driver, productOne);
		clickElement(driver, addToCart);
		clickElement(driver, cartBadge);

		clickElement(driver, checkOut);
		inputPassing(driver, firstName,Frm.getInstancefrm().getInstanceConfigurationReader().getFirstName());
		inputPassing(driver, lastName,Frm.getInstancefrm().getInstanceConfigurationReader().getLastName());
		inputPassing(driver, postalCode,Frm.getInstancefrm().getInstanceConfigurationReader().getPostalCode());
	    clickElement(driver, continueButton);
	    clickElement(driver, finishbutton);
	    getText(driver, confirmText);			
	    clickElement(driver, menuButton);
	    clickElement(driver, logOut);
	}		
}

