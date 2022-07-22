package com.revature.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage 
{
	protected WebDriver driver;
	
	private By addWishListButton = By.xpath("//*[@id=\"games\"]/div/div[2]/div/div[4]/div/button[1]");
	
	public HomePage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void clickAdd()
	{
		driver.findElement(addWishListButton).click();
	}

}
