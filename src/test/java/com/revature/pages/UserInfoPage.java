package com.revature.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



public class UserInfoPage {
	//adding instance of our WebDriver
	private WebDriver driver;
	//Constructor to create an instance of this page
	public UserInfoPage(WebDriver driver) {
		this.driver = driver;
	}
		//Providing Web Element Xpath
		private By usernameInput = By.xpath("//*[@id=\"form1\"]/div/div[1]/input");
		private By passwordInput = By.xpath("//*[@id=\"form1\"]/div/div[2]/input");
		private By loginButton = By.xpath("//*[@id=\"form1\"]/div/div[3]/button");
		private By userInfoLink = By.xpath("/html/body/app-root/router-outlet/app-nav-bar/ul/li[7]/a");
		private By usernameInfoCard = By.xpath("//*[@id=\"userinfocard\"]/div/div[1]/span");
		
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
}
