package com.Interface;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public interface SwagLabsInterface {
	String userName="user-name";
	String password="id='password";
	String login="login-button";	
	String title="//div[@class=\"app_logo\"]";
	String blanklogin="//div[@class='error-message-container error']";
	
	String product_one="(//div[@data-test='inventory-item-name'])[1]";
	String addtocart="//button[@id='add-to-cart']";
	String cart_badge="//div[@id='shopping_cart_container']";
	String checkout="checkout";
	String first_name="//(input[@type='text'])[1]";
	String last_name="//(input[@type='text'])[2]";
	String postal_code= "//(input[@type='text'])[3]";
	String continue_btn="//input[@id='continue']";
	String finish= "finish";
	String confirmtext="//h2[@class='complete-header']";
	String menu_button="//button[@type='button']";
	String logout="//a[@id='logout_sidebar_link']";
	
	String product_two="(//div[@data-test='inventory-item-name'])[2]";
	String product_three="(//div[@data-test='inventory-item-name'])[3]";
	String product_four="(//div[@data-test='inventory-item-name'])[4]";
	String product_five="(//div[@data-test='inventory-item-name'])[5]";
	
}
