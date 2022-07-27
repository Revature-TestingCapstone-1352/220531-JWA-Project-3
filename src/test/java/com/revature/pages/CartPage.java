package com.revature.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class CartPage {


	//ASSIGNING THE WEB DRIVER FOR THE CARTPAGE
	private WebDriver driver;
	private HomePage hp;
	private LoginPage loginPage;
	public String gameSelectedName;
	
	// a constructor to create an instance of this Page, and also initialize the web elements on the page.
	public CartPage(WebDriver driver) {
		this.driver = driver;

		
		PageFactory.initElements(driver, this);
		this.gameSelectedName = "";
		
	}
	
	// SETTING UP ALL THE ELEMENTS THAT WE ARE GOING TO BE USING ON THE CART PAGE
	
	
	
	
	private By addToCartButton = By.xpath("//*[@id=\"games\"]/div/div/div/div[4]/div/button[2]/span");	
	private By cartTable = By.xpath("/html/body/app-root/app-cart/div/div/div[2]/table/tbody");
	public By cartTableFirstItem = By.xpath("/html/body/app-root/app-cart/div/div/div[2]/table/tbody/tr/td[2]/span[1]/b");
	
	
	private By nameOfFirstGameInCart = By.xpath("/html/body/app-root/app-cart/div/div/div[2]/table/tbody/tr/td[2]/span[1]/b");
	
	
	// STORE PAGE ITEMS
	
	private By storePageGameName = By.xpath("//*[@id=\"games\"]/div/div[1]/div/div[2]");
	private By storeWishListButton = By.xpath("//*[@id=\"games\"]/div/div[1]/div/div[4]/div/button[1]");
	
	
	
	public void clickAddToCartButton() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(addToCartButton).click();
	}
	
	
	public void noItemsInCartPage() {
		
		driver.findElement(shoppingCartEmptyMessage).click();
	}
	
	
	
	// SETTER FOR GAME SELECTED NAME
	public void setGameSelectedName(String gameName) {
		this.gameSelectedName = gameName;
	}
	
	
	// GETTER FOR GAME SELECTED NAME
	public String getGameSelectedName() {
		return this.gameSelectedName;
	}
	
	
	
	public By getCartTableFirstItem() {
		 
		 
		 return cartTableFirstItem;
	}
	
	
	public By getCartTable() {
		return cartTable;
	}
	
	public String getCartTableFirstItemName() {
		return driver.findElement(cartTableFirstItem).getText();
	}
	
	//\\\\\\\\\\\\\\\\\\\\\\\\ LOGIN PAGE ITEMS \\\\\\\\\\\\\\\\\\\\\\\\
	
	
	/////////////////// JF LOGIN THINGS \\\\\\\\\\\\\\\\\\\\\\\\
	public void loginThenNavigateToCart() {
		driver.findElement(hp.getLoginLink()).click();
		hp.getLoginLink();
		
	}
	
	// JF LOGIN THINGS
	public void moveToLogin() {
		hp.navToLoginPage();
	}
	
	
	
	
	///////////////// WISH LIST ITEMS \\\\\\\\\\\\\\\\\\\\\\\\
	
	private By nameOfFirstGameInWishList = By.xpath("//*[@id=\"games\"]/div/div/div/div[2]");
	
	public String getNameOfFirstGameInWishList() {
		String gameName = driver.findElement(nameOfFirstGameInWishList).getText();		
		return gameName;
	}
	
	
	
	public void testStoreAddToWLButt() {
		driver.findElement(storeWishListButton).click();
	}
	
	public String getStoreGameName() {
		return driver.findElement(storePageGameName).getText();
	}
	
	
	
	
	public String getNameOfFristGameInCart() {
		String gameName = driver.findElement(nameOfFirstGameInCart).getText();
		return gameName;
	}
	
	
	


	// CHECKOUT PAGE THINGS
	
	//THE NAME OF THE TOP GAME IN THE TABLE AFTER ADDING TO CART
	private By checkOutGameName = By.xpath("/html/body/app-root/app-cart/div/div/div[2]/table/tbody/tr/td[2]/span[1]/b");
	
	private By shoppingCartEmptyMessage = By.xpath("/html/body/app-root/app-cart/div[1]/h4");
	
	private By removeButton_First_Item_In_Cart = By.xpath("/html/body/app-root/app-cart/div/div/div[2]/table/tbody/tr/td[1]/button");
	
	
	
	
	public String getCheckOutGameName() {
		
		String gameName = driver.findElement(checkOutGameName).getText();
		return gameName;
		
	}
	
	
	public void clickremoveButton_First_Item_In_Cart() {
		driver.findElement(removeButton_First_Item_In_Cart).click();
	}
	
	public String getEmptyStringMessage() {
		String msg = driver.findElement(shoppingCartEmptyMessage).getText();
		return msg;
	}

	
	
	

	
}
