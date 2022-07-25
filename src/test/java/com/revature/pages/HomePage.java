package com.revature.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	private WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		// this next bit of code is working from the PageFactory
		// PageFactory.initElements(driver, this);
	}

	private By firstAddToCartButton = By.xpath("//*[@id=\"games\"]/div/div[1]/div/div[4]/div/button[2]");
	private By viewCart = By.xpath("/html/body/app-root/router-outlet/app-nav-bar/ul/li[3]/a");
	
	public By getfirstAddToCartButton() {
		return firstAddToCartButton;
	}
	
	public By getViewCartLink() {
		return viewCart;
	}

	// TEMP until LoginPage is setup ----------------------------------------
	private By loginLink = By.xpath("/html/body/app-root/router-outlet/app-nav-bar/ul/li[6]/a");
	private By uNameField = By.xpath("/html/body/app-root/app-login/div/div/div/div/div/div[1]/input");
	private By pKeyField = By.xpath("/html/body/app-root/app-login/div/div/div/div/div/div[2]/input");
	private By loginButton = By.xpath("/html/body/app-root/app-login/div/div/div/div/div/div[3]/button");
	private By addWishListButton = By.xpath("//*[@id=\"games\"]/div/div[2]/div/div[4]/div/button[1]");
	private By gamesDisplayed = By.xpath("/html/body/app-root/app-store/div/div/div[2]/div");
	
	//Navigation Buttons
	public By navCartButton = By.xpath("/html/body/app-root/router-outlet/app-nav-bar/ul/li[3]/a");
	
	private By searchBar = By.xpath("/html/body/app-root/app-store/nav/input");

	public void clickAdd()
	{
		driver.findElement(addWishListButton).click();
	}


	public By getLoginLink() {
		return loginLink;
	}

	public By getuNameField() {
		return uNameField;
	}

	public By getpKeyField() {
		return pKeyField;
	}

	public By getLoginButton() {
		return loginButton;
	}

	public By getGamesDisplayed() {
		return gamesDisplayed;

	}
	public By getSearchBar() {
		return searchBar;
	}
	
	//----------------------NAV CLICK FUNCTIONS--------------------------------------
	
	public void navToLoginPage() {
		driver.findElement(getLoginLink()).click();
	}
	
	public void clickNavToCart() {
		driver.findElement(navCartButton).click();
	}
}
