package com.revature.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage 
{
	protected WebDriver driver;
	
	private By usernameBy = By.xpath("//*[@id=\"form1\"]/div/div[1]/input");
	private By passwordBy = By.xpath("//*[@id=\"form1\"]/div/div[2]/input");
	private By loginButtonBy = By.xpath("//*[@id=\"form1\"]/div/div[3]/button");
	private By logoutButtonBy = By.xpath("/html/body/app-root/router-outlet/app-nav-bar/ul/li[8]/a");
	private By loginPageButtonBy = By.xpath("/html/body/app-root/router-outlet/app-nav-bar/ul/li[6]/a");
	
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
			new WebDriverWait(driver, Duration.ofSeconds(5));
			WebElement logoutButton = driver.findElement(logoutButtonBy);
			System.out.println("LOGOUT BUTTON ENABLED (TODO DELETE): " + logoutButton.getText());
			return logoutButton.isEnabled();
		} catch(Exception e) {
			return false;
		}
	}
	
	public void toLoginPage() {
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(loginPageButtonBy));
		driver.findElement(loginPageButtonBy).click();
	}
	
	public void initialLogout() {
		driver.get("http://localhost:4200");
		try {
			new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(logoutButtonBy));
			driver.findElement(logoutButtonBy).click();
		} catch (Exception e) {};
	}
	
	public void logout() {
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(loginPageButtonBy));
		driver.findElement(logoutButtonBy).click();
	}

}
