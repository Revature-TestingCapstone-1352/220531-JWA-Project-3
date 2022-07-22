package com.revature.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
		return driver.findElement(gameNameBy).getText();
	}

}
