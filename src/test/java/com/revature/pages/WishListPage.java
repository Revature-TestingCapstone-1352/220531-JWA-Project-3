package com.revature.pages;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WishListPage 
{
	protected WebDriver driver;
	
	private By gameNameBy = By.xpath("//*[@id=\"games\"]/div/div/div/div[2]");
	
	private By removeFromBy = By.xpath("//*[@id=\"games\"]/div/div/div/div[4]/div/button[1]/span");
	
	private By addToCartBy = By.xpath("//*[@id=\"games\"]/div/div/div/div[4]/div/button[2]/span");
	
	private By loginLink = By.xpath("/html/body/app-root/router-outlet/app-nav-bar/ul/li[6]/a");
	private By uNameField = By.xpath("/html/body/app-root/app-login/div/div/div/div/div/div[1]/input");
	private By pKeyField = By.xpath("/html/body/app-root/app-login/div/div/div/div/div/div[2]/input");
	private By loginButton = By.xpath("/html/body/app-root/app-login/div/div/div/div/div/div[3]/button");
	
	public WishListPage(WebDriver driver)
	{
		this.driver = driver;
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

	public By getGameNameBy() {
		return gameNameBy;
	}

	public By getRemoveFromBy() {
		return removeFromBy;
	}

	public By getAddToCartBy() {
		return addToCartBy;
	}
	
	public String findGameName()
	{
		//new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(driver.findElement(getGameNameBy())));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String gamename = driver.findElement(getGameNameBy()).getText();
		return gamename;
	}
}
