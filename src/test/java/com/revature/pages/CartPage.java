package com.revature.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.support.PageFactory;

//import com.revature.runner.GameRunner;

public class CartPage {

	
	private WebDriver driver;

	// a constructor to create an instance of this Page, and also initialize the web elements on the page.
	public CartPage(WebDriver driver) {
		this.driver = driver;
		// this next bit of code is working from the PageFactory
		PageFactory.initElements(driver, this);
	}
	
	
	
	// 
	
	@FindBy(id ="js-link-box-en")
	public WebElement englishLink;
	
	
	@FindBy(xpath = "//*[@id=\"js-link-box-it\"]")
	public WebElement germanLink;

	
}
