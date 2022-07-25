package com.revature.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage 
{
	protected WebDriver driver;
	
	private By usernameBy = By.xpath("//*[@id=\"form1\"]/div/div[1]/input");
	private By passwordBy = By.xpath("//*[@id=\"form1\"]/div/div[2]/input");
	private By loginButtonBy = By.xpath("//*[@id=\"form1\"]/div/div[3]/button");
	
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public HomePage loginValidUser(String username, String password)
	{
		driver.findElement(usernameBy).sendKeys(username);
		driver.findElement(passwordBy).sendKeys(password);
		driver.findElement(loginButtonBy).click();
		
		return new HomePage(driver);
	}

	public By getUsernameBy() {
		return usernameBy;
	}

	public By getPasswordBy() {
		return passwordBy;
	}

	public By getLoginButtonBy() {
		return loginButtonBy;
	}

	public WebDriver getDriver() {
		return driver;
	}
	
	

}
