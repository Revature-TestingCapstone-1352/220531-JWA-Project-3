package com.revature.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage 
{
	protected WebDriver driver;
	
	private By usernameBy = By.xpath("//*[@id=\"form1\"]/div/div[1]/input");
	private By passwordBy = By.xpath("//*[@id=\"form1\"]/div/div[2]/input");
	private By loginButtonBy = By.xpath("//*[@id=\"form1\"]/div/div[3]/button");
	private By logoutButtonBy = By.xpath("/html/body/app-root/router-outlet/app-nav-bar/ul/li[9]/a");
	
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
	
	public RegisterPage loginInvalidUser(String username, String password) {
		driver.findElement(usernameBy).sendKeys(username);
		driver.findElement(passwordBy).sendKeys(password);
		driver.findElement(loginButtonBy).click();
		
		return new RegisterPage(driver);
	}
	
	public boolean isLoggedIn() {
		try {
			WebElement logoutButton = driver.findElement(logoutButtonBy);
			System.out.println("LOGOUT BUTTON ENABLED (TODO DELETE): " + logoutButton.isEnabled());
			if (logoutButton.isEnabled()) return true;
			else return false;
		} catch(Exception e) {
			return false;
		}
	}

}
