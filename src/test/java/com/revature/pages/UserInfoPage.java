package com.revature.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserInfoPage {

	private WebDriver driver;
	
  public UserInfoPage(WebDriver driver) {
		this.driver = driver;
	}
	
	
		//Providing Web Element Xpath
		private By usernameInput = By.xpath("//*[@id=\"form1\"]/div/div[1]/input");
		private By passwordInput = By.xpath("//*[@id=\"form1\"]/div/div[2]/input");
		private By loginButton = By.xpath("//*[@id=\"form1\"]/div/div[3]/button");
		private By userInfoLink = By.xpath("/html/body/app-root/router-outlet/app-nav-bar/ul/li[7]/a");
		private By usernameInfoCard = By.xpath("//*[@id=\"userinfocard\"]/div/div[1]/span");
    private By loggedOutText = By.xpath("/html/body/app-root/app-user-information/h4");
		
		//Creating getters
		public By getUsernameInput() {
			return usernameInput;
		}
		public By getPasswordInput() {
			return passwordInput;
		}
		public By getLoginButton() {
			return loginButton;
		}
		public By getUserInfoLink() {
			return userInfoLink;
		}
		public By getUsernameInfoCard() {
			return usernameInfoCard;
		}
    
    public boolean isUserPageEmpty() {
		try {
			new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(loggedOutText));
			return driver.findElement(loggedOutText).getText().equals("You need to login to view this page!");
		} catch(Exception e) {
			return false;
		}
	}
}
