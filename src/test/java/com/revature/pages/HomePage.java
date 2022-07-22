package com.revature.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	private WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		// this next bit of code is working from the PageFactory
		//PageFactory.initElements(driver, this);
	}
	
	public By firstAddToCartButton = By.xpath("//*[@id=\"games\"]/div/div[1]/div/div[4]/div/button[2]");
	public By cartButton = By.xpath("/html/body/app-root/router-outlet/app-nav-bar/ul/li[3]/a");
	
	public CartPage goToCartPage() {
		driver.findElement(cartButton).click();
		return new CartPage(driver);
	}
	
	
	//TEMP until LoginPage is setup ----------------------------------------
	private By loginLink = By.xpath("/html/body/app-root/router-outlet/app-nav-bar/ul/li[6]/a");
	private By uNameField = By.xpath("/html/body/app-root/app-login/div/div/div/div/div/div[1]/input");
	private By pKeyField = By.xpath("/html/body/app-root/app-login/div/div/div/div/div/div[2]/input");
	private By loginButton = By.xpath("/html/body/app-root/app-login/div/div/div/div/div/div[3]/button");
	// ---------------------------------------------------------------------
	private By gamesDisplayed = By.xpath("/html/body/app-root/app-store/div/div/div[2]/div");

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
}
