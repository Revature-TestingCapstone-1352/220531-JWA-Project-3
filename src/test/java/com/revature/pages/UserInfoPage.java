package com.revature.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserInfoPage {
	private WebDriver driver;
	public UserInfoPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	 
	@FindBy(xpath  = "//*[@id=\"changeemailcard\"]/div/div[1]/input")
	public WebElement EnterNewEmail;
	
	public By editUserDetail = By.xpath("//*[@id=\"userinfocard\"]/div/div[3]/button");
	public void getUserInfoLink() {
		driver.findElement(editUserDetail).click();
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
}
