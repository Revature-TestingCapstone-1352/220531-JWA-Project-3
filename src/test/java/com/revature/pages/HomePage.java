package com.revature.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	private WebDriver driver;
	
	private By addWishListButton = By.xpath("//*[@id=\"games\"]/div/div[2]/div/div[4]/div/button[1]");
	private By gamesDisplayed = By.xpath("/html/body/app-root/app-store/div/div/div[2]/div");
	private By gamesDivBy = By.xpath("//*[@id=\"games\"]");
	private By addCartButton = By.xpath("//*[@id=\"games\"]/div/div[2]/div/div[4]/div/button[2]");
    private By metacriticLink = By.xpath("/html/body/app-root/app-store/div/div/div[2]/div/div[1]/div/div[3]/div[6]/div/a");
    private By searchField = By.xpath("/html/body/app-root/app-store/nav/input");
	private By registerLink = By.xpath("/html/body/app-root/router-outlet/app-nav-bar/ul/li[5]/a");
	private By loginLink = By.xpath("/html/body/app-root/router-outlet/app-nav-bar/ul/li[6]/a");
	private By uNameField = By.xpath("/html/body/app-root/app-login/div/div/div/div/div/div[1]/input");
	private By pKeyField = By.xpath("/html/body/app-root/app-login/div/div/div/div/div/div[2]/input");
	private By loginButton = By.xpath("/html/body/app-root/app-login/div/div/div/div/div/div[3]/button");
  private By addWishListButton = By.xpath("//*[@id=\"games\"]/div/div[2]/div/div[4]/div/button[1]");
	private By gamesDisplayed = By.xpath("/html/body/app-root/app-store/div/div/div[2]/div");
	
// ============== Khellil code	
	private By logoutLink = By.xpath("/html/body/app-root/router-outlet/app-nav-bar/ul/li[8]/a");
	private By userInfoLink = By.xpath("/html/body/app-root/router-outlet/app-nav-bar/ul/li[7]/a");

	public By getLogoutLink() {
		return logoutLink;
	}
	public By getUserInfoLink() {
		return userInfoLink; 
	}
//	 ==============
	
  public void clickAdd()
	{
		driver.findElement(addWishListButton).click();
  }
	private By wishListLink = By.xpath("/html/body/app-root/router-outlet/app-nav-bar/ul/li[2]/a");
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	

	

    public By getWishListLink() {
		return wishListLink;
	}
	
    public By getMetatcriticLink() {
    	return metacriticLink;
    }
	public By getRegisterLink() {
		return registerLink;
	}

	public By getSearchField() {
		return searchField;
	}

	public By getaddWishlistButton() {
		return addWishListButton;
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
	
	public By getGamesDiv() {
		return gamesDivBy;
	}
	
	public boolean onHomePage() {
		try {
			new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(gamesDivBy));
			WebElement gameList = driver.findElement(gamesDivBy);
			if (gameList != null) return true;
			else return false;
		} catch(Exception e) {
			return false;
		}
	}
	
	public void addItemToCart() {
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(addCartButton));
		driver.findElement(addCartButton).click();
	}
	
	public void addItemToWishlist() {
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(addWishListButton));
		driver.findElement(addWishListButton).click();

	}
	
	public void navigateToLoginPage() {
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(getLoginLink()));
		driver.findElement(getLoginLink()).click();
	}
	
	public void clickAdd()
	{
		driver.findElement(getaddWishlistButton()).click();
	}
	
	public void navigateToWishList()
	{
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(getWishListLink()));
		driver.findElement(getWishListLink()).click();
	}
}
