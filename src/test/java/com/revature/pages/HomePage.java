package com.revature.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        // this next bit of code is working from the PageFactory
        //PageFactory.initElements(driver, this);
    }

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
	
	public By getfirstAddToCartButton() {
		return firstAddToCartButton;
	}
	
	public By getViewCartLink() {
		return viewCart;
	}

    public void clickAdd() {
        driver.findElement(addWishListButton).click();
    }


    public By getLoginLink() {
        return loginLink;
    }

    public By getuNameField() {
        return uNameField;
    }

    public By getpKeyField() {
        return pKeyField;
    }

    public By getLoginButton() {
        return loginButton;
    }

    public By getGamesDisplayed() {
        return gamesDisplayed;
    }

   

    public void clickDarkModeButton() {
        driver.findElement(darkLightModeButton).click();
    }

    public String checkBackGroundColor() {
        return driver.findElement(body).getAttribute("class");
    }

    public void clickNextPageButton() {
        driver.findElement(nextPageButton).click();
    }

    public void clickPreviousPageButton() {
        driver.findElement(previousPageButton).click();
    }

    public void clickNumberedPage() {
        driver.findElement(numberedPageButton).click();
    }

    public String elementTextAfterClickingNextPage() {
        By nextPageFirstElementToCheck = By.xpath("//*[@id=\"games\"]/div/div[1]/div/div[2]");

        return driver.findElement(nextPageFirstElementToCheck).getText();
    }

    public String elementTextAfterClickingPreviousButton() {
        By previousPageFirstElementToCheck = By.xpath("//*[@id=\"games\"]/div/div[1]/div/div[2]");

        return driver.findElement(previousPageFirstElementToCheck).getText();
    }

    public String elementTextAfterClickingPageNumber() {
        By numberedPageFirstElementToCheck = By.xpath("//*[@id=\"games\"]/div/div[1]/div/div[2]");

        return driver.findElement(numberedPageFirstElementToCheck).getText();
    }

	
	//----------------------NAV CLICK FUNCTIONS--------------------------------------
	
	public void navToLoginPage() {
		driver.findElement(getLoginLink()).click();
	}
	
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
	
	public void clickNavToCheckout() {
		driver.findElement(checkoutPage).click();
	}
	
	public void clickNavToCart() {
		driver.findElement(navCartButton).click();
	}

	public By getUserInfoLink() {
		return userInfoLink;
	}
	
	
	public void searchFor(String input) {
		driver.findElement(searchBar).sendKeys(input);
	}
	
//    public By getSearchBar() {
//        return searchBar;
//    }
	public void navigateToLoginPage() {
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(getLoginLink()));
		driver.findElement(getLoginLink()).click();
	}
	
}
