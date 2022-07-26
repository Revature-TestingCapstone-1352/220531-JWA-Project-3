package com.revature.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



    //TEMP until LoginPage is setup
    private By loginLink = By.xpath("/html/body/app-root/router-outlet/app-nav-bar/ul/li[6]/a");
    private By uNameField = By.xpath("/html/body/app-root/app-login/div/div/div/div/div/div[1]/input");
    private By pKeyField = By.xpath("/html/body/app-root/app-login/div/div/div/div/div/div[2]/input");
    private By loginButton = By.xpath("/html/body/app-root/app-login/div/div/div/div/div/div[3]/button");
    private By addWishListButton = By.xpath("//*[@id=\"games\"]/div/div[2]/div/div[4]/div/button[1]");
    private By gamesDisplayed = By.xpath("/html/body/app-root/app-store/div/div/div[2]/div");
    private By searchBar = By.xpath("/html/body/app-root/app-store/nav/input");
    private By darkLightModeButton = By.xpath("/html/body/app-root/router-outlet/app-nav-bar/ul/li[10]/button/h5");
    private By body = By.xpath("/html/body");
    private By nextPageButton = By.xpath("//*[@id=\"basicPaginate\"]/pagination-template/nav/ul/li[10]/a");
    private By previousPageButton = By.xpath("//*[@id=\"basicPaginate\"]/pagination-template/nav/ul/li[1]/a");
    private By numberedPageButton = By.xpath("//*[@id=\"basicPaginate\"]/pagination-template/nav/ul/li[6]/a");
  	private By userInfoLink = By.xpath("/html/body/app-root/router-outlet/app-nav-bar/ul/li[7]/a");
    private By checkoutPage = By.xpath("/html/body/app-root/router-outlet/app-nav-bar/ul/li[4]/a");
	//Navigation Buttons
	public By navCartButton = By.xpath("/html/body/app-root/router-outlet/app-nav-bar/ul/li[3]/a");

    private By firstAddToCartButton = By.xpath("//*[@id=\"games\"]/div/div[1]/div/div[4]/div/button[2]");
	private By viewCart = By.xpath("/html/body/app-root/router-outlet/app-nav-bar/ul/li[3]/a");

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	private By loginLink = By.xpath("/html/body/app-root/router-outlet/app-nav-bar/ul/li[6]/a");
	private By uNameField = By.xpath("/html/body/app-root/app-login/div/div/div/div/div/div[1]/input");
	private By pKeyField = By.xpath("/html/body/app-root/app-login/div/div/div/div/div/div[2]/input");
	private By loginButton = By.xpath("/html/body/app-root/app-login/div/div/div/div/div/div[3]/button");
	private By addWishListButton = By.xpath("//*[@id=\"games\"]/div/div[2]/div/div[4]/div/button[1]");
	private By gamesDisplayed = By.xpath("/html/body/app-root/app-store/div/div/div[2]/div");
    private By metacriticLink = By.xpath("/html/body/app-root/app-store/div/div/div[2]/div/div[1]/div/div[3]/div[6]/div/a");
    private By searchField = By.xpath("/html/body/app-root/app-store/nav/input");
	private By registerLink = By.xpath("/html/body/app-root/router-outlet/app-nav-bar/ul/li[5]/a");
	
    public By getMetatcriticLink() {
    	return metacriticLink;
    }
	public By getRegisterLink() {
		return registerLink;
	}

	public By getSearchField() {
		return searchField;
	}

	public By getaddWishlistButton() {
		return addWishListButton;
	}
	
	public By getLoginLink() {
		return loginLink;

	}
	
	public void clickNavToCart() {
		driver.findElement(navCartButton).click();
	}

	public By getUserInfoLink() {
		return userInfoLink;
	}

	public By getCheckoutPage() {
		return checkoutPage;

	
	public By getLoginButton() {
		return loginButton;

	}
	
	public void searchFor(String input) {
		driver.findElement(searchBar).sendKeys(input);
	}
	

	public void navigateToLoginPage() {
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(getLoginLink()));
		driver.findElement(getLoginLink()).click();
	}
	
	public void clickAdd()
	{
		driver.findElement(getaddWishlistButton()).click();
	}

}
