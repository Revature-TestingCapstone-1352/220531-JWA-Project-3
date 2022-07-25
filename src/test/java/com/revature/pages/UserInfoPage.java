package com.revature.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserInfoPage {

	private WebDriver driver;
	
	private By loggedOutText = By.xpath("/html/body/app-root/app-user-information/h4");
	
	public UserInfoPage(WebDriver driver) {
		this.driver = driver;
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
