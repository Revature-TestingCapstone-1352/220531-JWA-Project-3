package com.revature.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.support.PageFactory;

//import com.revature.runner.GameRunner;

public class CartPage {

	
	private WebDriver driver;
	
	private By emptyCartText = By.xpath("/html/body/app-root/app-cart/div[1]/h4");

	// a constructor to create an instance of this Page, and also initialize the web elements on the page.
	public CartPage(WebDriver driver) {
		this.driver = driver;
		// this next bit of code is working from the PageFactory
		PageFactory.initElements(driver, this);
	}
	
	public boolean isCartEmpty() {
		try {
			new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(emptyCartText));
			return driver.findElement(emptyCartText).getText().equals("Your shopping cart is empty!");
		} catch(Exception e) {
			return false;
		}
	}
	
	
	
	// 
	
	@FindBy(id ="js-link-box-en")
	public WebElement englishLink;
	
	
	@FindBy(xpath = "//*[@id=\"js-link-box-it\"]")
	public WebElement germanLink;

	
}
