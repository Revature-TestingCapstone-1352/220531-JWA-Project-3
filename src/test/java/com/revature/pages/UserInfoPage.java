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
	 
//	private By editUserDetailButton = By.xpath("//*[@id=\"userinfocard\"]/div/div[3]/button");
	@FindBy(xpath  = "//*[@id=\"userinfocard\"]/div/div[3]/button") 
	public WebElement editUserDetailButton;	
//	public By geteditUserDetailButton() {
//		return editUserDetailButton;
//	}
	@FindBy(xpath  = "//*[@id=\"changeemailcard\"]/div/div[1]")
	public WebElement EnterNewEmail;
	

	
	
	
	
}
