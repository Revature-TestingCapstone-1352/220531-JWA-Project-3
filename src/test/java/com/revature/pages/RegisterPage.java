package com.revature.pages;

import com.revature.runner.GameRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class RegisterPage {

	protected WebDriver driver;
	public HomePage homePage = GameRunner.homePage;
	
	private By registerButtonBy = By.xpath("/html/body/app-root/app-register/div/div/div/div/div/div[4]/button");
	private By usernameBy = By.xpath("/html/body/app-root/app-register/div/div/div/div/div/div[1]/input");
	private By passwordBy = By.xpath("/html/body/app-root/app-register/div/div/div/div/div/div[2]/input");
	private By emailBy = By.xpath("/html/body/app-root/app-register/div/div/div/div/div/div[3]/input");
	
	public RegisterPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public By getUserName() {
		return usernameBy;
	}

	public By getPassword() {
		return passwordBy;
	}

	public By getEmail() {
		return emailBy;
	}

	public By getRegisterButton() {
		return registerButtonBy;
	}

	public void enterInformation(String username, String password, String email) {
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(getUserName()));
		driver.findElement(getUserName()).sendKeys(username);
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(getPassword()));
		driver.findElement(getPassword()).sendKeys(password);
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(getEmail()));
		driver.findElement(getEmail()).sendKeys(email);
		new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.elementToBeClickable(getRegisterButton()));
		driver.findElement(getRegisterButton()).click();
	}
	
	public void clickRegister(){
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(homePage.getRegisterLink()));
		driver.findElement(homePage.getRegisterLink()).click();
	}
	
	public boolean isOnThePage() {
		try {
//			new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(registerButtonBy));
			WebElement registerButton = driver.findElement(registerButtonBy);
			if (registerButton.getText().equals("Register")) {
				return true;
			}else {
				return false;
			}
		} catch(Exception e) {
			return false;
		}
	}
}
