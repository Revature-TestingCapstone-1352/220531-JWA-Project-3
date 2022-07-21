package com.revature.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {
	private WebDriver driver;
	
	public CheckoutPage(WebDriver driver) {
		this.driver = driver;
		// this next bit of code is working from the PageFactory
		//PageFactory.initElements(driver, this);
	}
	private By addToCart = By.xpath("/html/body/app-root/app-store/div/div/div[2]/div/div[1]/div/div[4]/div/button[2]");
	private By viewCart = By.xpath("/html/body/app-root/router-outlet/app-nav-bar/ul/li[3]/a");
	private By proceedToCheckout = By.xpath("/html/body/app-root/app-cart/div/div/div[2]/div/button");
	private By orderButton = By.id("btnOrder");
	private By thankYouOrder = By.xpath("/html/body/app-root/app-checkout/div/h4");
	private String thankYouText = driver.findElement(thankYouOrder).getText();
}
