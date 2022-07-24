package com.revature.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterPage {

	protected WebDriver driver;
	
	private By GetRegisterButton = By.xpath("/html/body/app-root/app-register/div/div/div/div/div/div[4]/button");
	
	public RegisterPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public boolean isOnThePage() {
		try {
			WebElement registerButton = driver.findElement(GetRegisterButton);
			System.out.println("REGISTER BUTTON TEXT (TODO DELETE): " + registerButton.getText());
			if (registerButton.getText().equals("Register")) return true;
			else return false;
		} catch(Exception e) {
			return false;
		}
	}
}
