package com.revature.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.revature.runner.GameRunner;

//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.support.PageFactory;

//import com.revature.runner.GameRunner;

public class CartPage {

	
//	private WebDriver driver;
	private GameRunner driver;;

	// a constructor to create an instance of this Page, and also initialize the web elements on the page.
	public CartPage(WebDriver driver) {
		this.driver = (GameRunner) driver;
		// this next bit of code is working from the PageFactory
		PageFactory.initElements(driver, this);
	}
	
	
	
	// THIS LOCATES THE TOP LEVEL NAVIGATION CART BUTTON
	@FindBy(xpath = "/html/body/app-root/router-outlet/app-nav-bar/ul/li[3]/a")
	public WebElement navCartButton;
	
	
	
	// THIS LOCATES THE TOP LEVEL NAVIGATION CART BUTTON
	@FindBy(xpath = "/html/body/app-root/app-cart/div[1]/h4")
	public WebElement shoppingCartEmptyMessage;
	
	
	@FindBy(xpath = "//*[@id=\"games\"]/div/div[2]/div/div[4]/div/button[2]")
	public WebElement addToCartButton;
	
	
	// THIS CART TABLE WILL ONLY APPEAR IF THERE IS AN ITEM IN THE CART
	@FindBy(xpath = "/html/body/app-root/app-cart/div/div/div[2]/table/tbody")
	public WebElement cartTable;
	
	
	// THIS WILL BRING UP ALL THE BUTTONS INSIDE OF THE cartTable
	public WebElement cartTblRemoveButtons = cartTable.findElement(By.tagName("button"));
	
	

	
}
