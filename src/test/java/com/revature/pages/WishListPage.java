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
	
	public WishListPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public String findGameName()
	{
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(driver.findElement(gameNameBy)));
		
		return driver.findElement(gameNameBy).getText();
	}

}
