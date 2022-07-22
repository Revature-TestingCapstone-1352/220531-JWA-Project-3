package com.revature.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
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
	
	
	//TEMP until LoginPage is setup ----------------------------------------
	private By loginLink = By.xpath("/html/body/app-root/router-outlet/app-nav-bar/ul/li[6]/a");
	private By uNameField = By.xpath("/html/body/app-root/app-login/div/div/div/div/div/div[1]/input");
	private By pKeyField = By.xpath("/html/body/app-root/app-login/div/div/div/div/div/div[2]/input");
	private By loginButton = By.xpath("/html/body/app-root/app-login/div/div/div/div/div/div[3]/button");
		
	public void loginForHomePage(String username, String password) {
		driver.findElement(loginLink).click();
		driver.findElement(uNameField).sendKeys(username);
		driver.findElement(pKeyField).sendKeys(password);
		driver.findElement(loginButton).click();
	}
	// ---------------------------------------------------------------------
	private WebElement gamesDisplayed = driver.findElement(By.xpath("/html/body/app-root/app-store/div/div/div[2]/div"));
	
	public boolean areDisplayed() {
		return gamesDisplayed.isDisplayed();
	}
	
	private List<WebElement> twentyFour = gamesDisplayed.findElements(By.xpath("./child::*"));
	
	public int areThereTwentyFour() {
		return twentyFour.size();
	}
}
