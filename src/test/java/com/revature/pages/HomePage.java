package com.revature.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	
	private WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		//PageFactory.initElements(driver, this);
	}
	
	public By firstAddToCartButton = By.xpath("//*[@id=\"games\"]/div/div[1]/div/div[4]/div/button[2]");
	
}
