package com.revature.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.revature.runner.GameRunner;

public class LoginPage 
{
  protected WebDriver driver;
	private By usernameBy = By.xpath("//*[@id=\"form1\"]/div/div[1]/input");
	private By passwordBy = By.xpath("//*[@id=\"form1\"]/div/div[2]/input");
	public By loginButtonBy = By.xpath("//*[@id=\"form1\"]/div/div[3]/button");
	private By logoutButtonBy = By.xpath("/html/body/app-root/router-outlet/app-nav-bar/ul/li[8]/a");
	private By loginPageButtonBy = By.xpath("/html/body/app-root/router-outlet/app-nav-bar/ul/li[6]/a");
	private By storePageBy = By.xpath("/html/body/app-root/router-outlet/app-nav-bar/ul/li[1]/a");
	private By wishlistPageBy = By.xpath("/html/body/app-root/router-outlet/app-nav-bar/ul/li[2]/a");
	private By cartPageBy = By.xpath("/html/body/app-root/router-outlet/app-nav-bar/ul/li[3]/a");
	private By userInfoPageBy = By.xpath("/html/body/app-root/router-outlet/app-nav-bar/ul/li[7]/a");
	
	private static HomePage homePage;
	
	
	public HomePage loginValidUser(String username, String password)
	{
		new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(loginButtonBy));
		driver.findElement(usernameBy).sendKeys(username);
		driver.findElement(passwordBy).sendKeys(password);
		driver.findElement(loginButtonBy).click();
		
		return GameRunner.homePage;
	}
	
	public RegisterPage loginInvalidUser(String username, String password) {
		new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(loginButtonBy));
		driver.findElement(usernameBy).sendKeys(username);
		driver.findElement(passwordBy).sendKeys(password);
		driver.findElement(loginButtonBy).click();
		
		return GameRunner.registerPage;
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
		new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(loginPageButtonBy));
		driver.findElement(loginPageButtonBy).click();
	}
	
	public void initialLogout() {
		driver.get("http://localhost:4200");
		try {
			//new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.visibilityOfElementLocated(logoutButtonBy));
			driver.findElement(logoutButtonBy).click();
		} catch (Exception e) {};
	}
	
	public void logout() {
		new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(loginPageButtonBy));
		driver.findElement(logoutButtonBy).click();
	}
	
	public void initialLogin() {
		driver.get("http://localhost:4200");
		new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(loginPageButtonBy));
		driver.findElement(loginPageButtonBy).click();
		new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(loginButtonBy));
		driver.findElement(usernameBy).sendKeys("TestUser");
		driver.findElement(passwordBy).sendKeys("TestPass");
		driver.findElement(loginButtonBy).click();
	}
	
	public HomePage toStorePage() {
		new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(storePageBy));
		driver.findElement(storePageBy).click();
		return GameRunner.homePage;
	}
	
	public CartPage toCartPage() {
		new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(cartPageBy));
		driver.findElement(cartPageBy).click();
		return GameRunner.cartPage;
	}
	
	public WishListPage toWishlistPage() {
		new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(wishlistPageBy));
		driver.findElement(wishlistPageBy).click();
		return GameRunner.wishListPage;
	}
	
	public UserInfoPage toUserInfoPage() {
		new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(userInfoPageBy));
		driver.findElement(userInfoPageBy).click();
		return GameRunner.userInfoPage;
	}


    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // public HomePage loginValidUser(String username, String password) {
    //     driver.findElement(usernameBy).sendKeys(username);
    //     driver.findElement(passwordBy).sendKeys(password);
    //     driver.findElement(loginButtonBy).click();

    //     return new HomePage(driver);
    // }

    public By getUsernameBy() {
        return usernameBy;
    }
}
	// public WebDriver getDriver() {
	// 	return driver;
	// }
  
// }


