package com.revature.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {
	private WebDriver driver;
	
	public CheckoutPage(WebDriver driver) {
		this.driver = driver;
		// this next bit of code is working from the PageFactory
		//PageFactory.initElements(driver, this);
	}
	//TEMP until LoginPage is setup ----------------------------------------
	private By loginLink = By.xpath("/html/body/app-root/router-outlet/app-nav-bar/ul/li[6]/a");
	private By uNameField = By.xpath("/html/body/app-root/app-login/div/div/div/div/div/div[1]/input");
	private By pKeyField = By.xpath("/html/body/app-root/app-login/div/div/div/div/div/div[2]/input");
	private By loginButton = By.xpath("/html/body/app-root/app-login/div/div/div/div/div/div[3]/button");
	
	public void loginForCheckout(String username, String password) {
		driver.findElement(loginLink).click();
		driver.findElement(uNameField).sendKeys(username);
		driver.findElement(pKeyField).sendKeys(password);
		driver.findElement(loginButton).click();
	}
	// ---------------------------------------------------------------------
	
	private By addToCart = By.xpath("/html/body/app-root/app-store/div/div/div[2]/div/div[1]/div/div[4]/div/button[2]");
	private By viewCart = By.xpath("/html/body/app-root/router-outlet/app-nav-bar/ul/li[3]/a");
	private By proceedToCheckout = By.xpath("/html/body/app-root/app-cart/div/div/div[2]/div/button");
	private By orderButton = By.id("btnOrder");
	private By thankYouOrder = By.xpath("/html/body/app-root/app-checkout/div/h4");
	private String thankYouText = driver.findElement(thankYouOrder).getText();
	private By emptyCart = By.xpath("/html/body/app-root/app-cart/div[1]/h4");
	private String emptyCartText = driver.findElement(emptyCart).getText();
	
	public void addToCart() {
		driver.findElement(addToCart).click();
		driver.findElement(viewCart).click();
	}
	
	public void viewCart() {
		driver.findElement(viewCart).click();
	}
	
	public void proceedToCheckout() {
		driver.findElement(proceedToCheckout).click();
		driver.findElement(orderButton).click();
	}
	
	public String successfulOrderText() {
		return thankYouText;
	}
	
	public String emptyCartString() {
		return emptyCartText;
	}
}
