package com.revature.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    private By body = By.xpath("/html/body");
    private By loginLink = By.xpath("/html/body/app-root/router-outlet/app-nav-bar/ul/li[6]/a");
    private By addWishListButton = By.xpath("//*[@id=\"games\"]/div/div[2]/div/div[4]/div/button[1]");
    private By gamesDisplayed = By.xpath("/html/body/app-root/app-store/div/div/div[2]/div");
    private By searchBar = By.xpath("/html/body/app-root/app-store/nav/input");
    private By darkLightModeButton = By.xpath("/html/body/app-root/router-outlet/app-nav-bar/ul/li[10]/button/h5");
    private By nextPageButton = By.xpath("//*[@id=\"basicPaginate\"]/pagination-template/nav/ul/li[10]/a");
    private By previousPageButton = By.xpath("//*[@id=\"basicPaginate\"]/pagination-template/nav/ul/li[1]/a");
    private By numberedPageButton = By.xpath("//*[@id=\"basicPaginate\"]/pagination-template/nav/ul/li[6]/a");
    private By firstAddToCartButton = By.xpath("//*[@id=\"games\"]/div/div[1]/div/div[4]/div/button[2]");
    private By userInfoLink = By.xpath("/html/body/app-root/router-outlet/app-nav-bar/ul/li[7]/a");
    private By checkoutPage = By.xpath("/html/body/app-root/router-outlet/app-nav-bar/ul/li[4]/a");
    public By navCartButton = By.xpath("/html/body/app-root/router-outlet/app-nav-bar/ul/li[3]/a");
    private By navWishListButton = By.xpath("/html/body/app-root/router-outlet/app-nav-bar/ul/li[2]/a");
    private By navStoreButton = By.xpath("/html/body/app-root/router-outlet/app-nav-bar/ul/li[1]/a");
    private By metacriticLink = By.xpath("/html/body/app-root/app-store/div/div/div[2]/div/div[1]/div/div[3]/div[6]/div/a");
    private By registerLink = By.xpath("/html/body/app-root/router-outlet/app-nav-bar/ul/li[5]/a");


    public By getfirstAddToCartButton() {
        return firstAddToCartButton;
    }

    public void clickFirstAddToCartButtion() {
        driver.findElement(firstAddToCartButton).click();
    }

    public void clickAdd() {
        driver.findElement(addWishListButton).click();
    }

    public By getLoginLink() {
        return loginLink;
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

    public void navToLoginPage() {
        driver.findElement(getLoginLink()).click();
    }

    public void navToWishListPage() {
        driver.findElement(navWishListButton).click();
    }

    public By getMetatcriticLink() {
        return metacriticLink;
    }

    public By getRegisterLink() {
        return registerLink;
    }

    public void clickNavToCheckout() {
        driver.findElement(checkoutPage).click();

    }

    public void clickNavToCart() {
        driver.findElement(navCartButton).click();
    }

    public void navToStore() {
        driver.findElement(navStoreButton).click();
    }

    public By getUserInfoLink() {
        return userInfoLink;
    }

    public void searchFor(String input) {
        driver.findElement(searchBar).sendKeys(input);
    }

    public void navigateToLoginPage() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(getLoginLink()));
        driver.findElement(getLoginLink()).click();
    }

}
