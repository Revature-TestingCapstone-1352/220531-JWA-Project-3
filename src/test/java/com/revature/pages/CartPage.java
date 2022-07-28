package com.revature.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage {

	
	private WebDriver driver;
	
	private By emptyCartText = By.xpath("/html/body/app-root/app-cart/div[1]/h4");
      // SETTING UP ALL THE ELEMENTS THAT WE ARE GOING TO BE USING ON THE CART PAGE
    private By addToCartButton = By.xpath("//*[@id=\"games\"]/div/div/div/div[4]/div/button[2]/span");
    public By cartTableFirstItem = By.xpath("/html/body/app-root/app-cart/div/div/div[2]/table/tbody/tr/td[2]/span[1]/b");
      
  

   

	
	public CartPage(WebDriver driver) {
		this.driver = driver;
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
	
	

    // @FindBy(id ="js-link-box-en")
	// public WebElement englishLink;
	
	
	// @FindBy(xpath = "//*[@id=\"js-link-box-it\"]")
	// public WebElement germanLink;

  

    public void clickAddToCartButton() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(addToCartButton).click();
    }

    public String getCartTableFirstItemName() {
        return driver.findElement(cartTableFirstItem).getText();
    }




    

    

}
