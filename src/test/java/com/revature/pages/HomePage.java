package com.revature.pages;

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
	public void setLoginLink(By loginLink) {
		this.loginLink = loginLink;
	}
	public void setuNameField(By uNameField) {
		this.uNameField = uNameField;
	}
	public void setpKeyField(By pKeyField) {
		this.pKeyField = pKeyField;
	}
	public void setLoginButton(By loginButton) {
		this.loginButton = loginButton;
	}
	public void setGamesDisplayed(By gamesDisplayed) {
		this.gamesDisplayed = gamesDisplayed;
	}
	
	
	//private WebElement gamesDisplayed = driver.findElement(By.xpath("/html/body/app-root/app-store/div/div/div[2]/div"));
	
	/*
	public boolean areDisplayed() {
		return gamesDisplayed.isDisplayed();
	}
	*/
	
	/*
	private List<WebElement> twentyFour = gamesDisplayed.findElements(By.xpath("./child::*"));
	
	public int areThereTwentyFour() {
		return twentyFour.size();
	}
	*/
}
