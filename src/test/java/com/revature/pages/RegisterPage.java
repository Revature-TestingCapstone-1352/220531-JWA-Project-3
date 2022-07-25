package com.revature.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPage 
{
	
	private WebDriver driver;
	
	public RegisterPage(WebDriver driver) 
	{
		this.driver = driver;
	}
	
	private By usernameBy = By.xpath("/html/body/app-root/app-register/div/div/div/div/div/div[1]/input");
	private By passwordBy = By.xpath("/html/body/app-root/app-register/div/div/div/div/div/div[2]/input");
	private By emailBy = By.xpath("/html/body/app-root/app-register/div/div/div/div/div/div[3]/input");
	private By registerButton = By.xpath("/html/body/app-root/app-register/div/div/div/div/div/div[4]/button");
	
	public By getUserName()
	{
		return usernameBy;
	}
	
	public By getPassword()
	{
		return passwordBy;
	}
	
	public By getEmail()
	{
		return emailBy;
	}
	
	public By getRegisterButton()
	{
		return registerButton;
	}
	
}
