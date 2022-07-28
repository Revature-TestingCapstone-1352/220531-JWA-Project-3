package com.revature.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserInfoPage {
	private WebDriver driver;
	public UserInfoPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	 
	@FindBy(xpath  = "//*[@id=\"changeemailcard\"]/div/div[1]/input")
	public WebElement EnterNewEmail;
	
	private By editUserDetail = By.xpath("//*[@id=\"userinfocard\"]/div/div[3]/button");
	public By geteditUserDetail() {
		return editUserDetail;
	}
	
	public By editUserEmail = By.xpath("//*[@id=\"changeemailcard\"]/div/div[2]/button");
	public void getUserNewEmailLink() {
		driver.findElement(editUserEmail).click();
	}	
	
	@FindBy(xpath  = "//*[@id=\"changepwdcard\"]/div/div[1]/input")
	public WebElement EnterNewPassword;
	@FindBy(xpath  = "//*[@id=\"changepwdcard\"]/div/div[2]/input")
	public WebElement ConfirmNewPassword;
	
	public By editUserPassword = By.xpath("/html/body/app-root/app-user-information/div/div[3]/div/div/div/div/div[3]/button");
	public void getUserNewPasswordLink() {
		driver.findElement(editUserPassword).click();
	}
	
	@FindBy(xpath  = "//*[@id=\"changepwdcard\"]/div/label")
	public WebElement passNotMatchDisplayed;
	
	private By logoutSeccussLink = By.xpath("/html/body/app-root/app-logout/h4");
	public By getLogoutSeccussLink() {
		return logoutSeccussLink;
    }

	//private By errorPasswordLink = By.xpath("//*[@id=\"changepwdcard\"]/div/label");
	private By errorPasswordLink = By.xpath("/html/body/app-root/app-user-information/div/div[3]/div/div/div/div/label");
	public By getErrorPasswordLink() {
		return errorPasswordLink; 
	}
	
	public String findPasswordError() {
		JavascriptExecutor jse6 = (JavascriptExecutor) driver;
		jse6.executeScript("window.scrollTo(0, document.body.scrollHeight)");

		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfElementLocated(getErrorPasswordLink()));

		String passwordErrorText = driver.findElement(getErrorPasswordLink()).getText();
		
		return passwordErrorText;
	}
}
