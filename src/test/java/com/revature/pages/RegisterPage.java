package com.revature.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPage {

	protected WebDriver driver;
	
	private By registerButtonBy = By.xpath("/html/body/app-root/app-register/div/div/div/div/div/div[4]/button");
	
	public RegisterPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public boolean isOnThePage() {
		try {
			new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(registerButtonBy));
			WebElement registerButton = driver.findElement(registerButtonBy);
			if (registerButton.getText().equals("Register")) return true;
			else return false;
		} catch(Exception e) {
			return false;
		}
	}
}
