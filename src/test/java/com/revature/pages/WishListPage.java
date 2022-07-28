package com.revature.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
public class WishListPage {
	
	protected WebDriver driver;

	public WishListPage(WebDriver driver) {
        this.driver = driver;
    }
	
	
	private By gameNameBy = By.xpath("//*[@id=\"games\"]/div/div/div/div[2]");
	
	private By removeFromBy = By.xpath("//*[@id=\"games\"]/div/div/div/div[4]/div/button[1]/span");
	
	private By addToCartBy = By.xpath("//*[@id=\"games\"]/div/div/div/div[4]/div/button[2]/span");
	
	//private By emptyWishlistText = By.xpath("/html/body/app-root/app-wishlist/div/div/h4");
	
	private By loginLink = By.xpath("/html/body/app-root/router-outlet/app-nav-bar/ul/li[6]/a");
	private By uNameField = By.xpath("/html/body/app-root/app-login/div/div/div/div/div/div[1]/input");
	private By pKeyField = By.xpath("/html/body/app-root/app-login/div/div/div/div/div/div[2]/input");
	private By loginButton = By.xpath("/html/body/app-root/app-login/div/div/div/div/div/div[3]/button");
	private By removeButton = By.xpath("/html/body/app-root/app-wishlist/div/div/div/div/div[4]/div/button[1]");
	private By wishListNotThereText = By.xpath("/html/body/app-root/app-wishlist/div/div/h5");

	// STORE PAGE ITEMS
    private By storeWishListButton = By.xpath("//*[@id=\"games\"]/div/div[1]/div/div[4]/div/button[1]");
	
	public By getWishListNotThereText() {
		return wishListNotThereText;
	}

	public By getRemoveButton() 
	{
		return removeButton;
	}

	
	
	public By getLoginLink() {
		return loginLink;
	}

   

    public By getGameNameBy() {
        return gameNameBy;
    }

    //TODO: getters maybe unnecessary


    public String findGameName() {
        //new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(driver.findElement(getGameNameBy())));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String gamename = driver.findElement(getGameNameBy()).getText();
        return gamename;
    }
	public By getRemoveFromBy() {
		return removeFromBy;
	}

	public By getAddToCartBy() {
		return addToCartBy;
	}
	
	public boolean isWishlistEmpty() {
		try {
			new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(gameNameBy));
			return false;
		} catch(Exception e) {
			return true;
		}
	}
	
	public void clickRemoveButton(){
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(getRemoveButton()));
		driver.findElement(getRemoveButton()).click();
	}
	
	public String findWishListNotPresent()
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String notThere = driver.findElement(getWishListNotThereText()).getText();
		return notThere;
	}

	///////////////// WISH LIST ITEMS \\\\\\\\\\\\\\\\\\\\\\\\

    public void testStoreAddToWLButt() {
        driver.findElement(storeWishListButton).click();
    }

}
