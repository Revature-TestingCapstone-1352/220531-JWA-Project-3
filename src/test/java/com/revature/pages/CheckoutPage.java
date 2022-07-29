package com.revature.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutPage {
    private WebDriver driver;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    //TEMP until LoginPage is setup ----------------------------------------
    private By loginLink = By.xpath("/html/body/app-root/router-outlet/app-nav-bar/ul/li[6]/a");
    private By uNameField = By.xpath("/html/body/app-root/app-login/div/div/div/div/div/div[1]/input");
    private By pKeyField = By.xpath("/html/body/app-root/app-login/div/div/div/div/div/div[2]/input");
    private By loginButton = By.xpath("/html/body/app-root/app-login/div/div/div/div/div/div[3]/button");


    // ---------------------------------------------------------------------

    private By addToCart = By.xpath("/html/body/app-root/app-store/div/div/div[2]/div/div[1]/div/div[4]/div/button[2]");
    private By viewCart = By.xpath("/html/body/app-root/router-outlet/app-nav-bar/ul/li[3]/a");
    private By proceedToCheckout = By.xpath("/html/body/app-root/app-cart/div/div/div[2]/div/button");
    private By orderButton = By.id("btnOrder");
    private By thankYouOrder = By.xpath("/html/body/app-root/app-checkout/div/h4");
    //private String thankYouText = driver.findElement(thankYouOrder).getText();
    private By emptyCart = By.xpath("/html/body/app-root/app-cart/div[1]/h4");
    //private String emptyCartText = driver.findElement(emptyCart).getText();
    private By proceedFromCartMsg = By.xpath("/html/body/app-root/app-checkout/div[1]/h5");


    public By getThankYou() {
        return thankYouOrder;
    }

    public By getEmptyCart() {
        return emptyCart;
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

    public By getViewCart() {
        return viewCart;
    }

    public By getAddToCart() {
        return addToCart;
    }

    public By getProceedToCheckout() {
        return proceedToCheckout;
    }

    public By getOrderButton() {
        return orderButton;
    }

    public By getProceedFromCartMsg() {
        return proceedFromCartMsg;
    }

    //TODO: Make sure this is transferred to LoginPage, getters may not be necessary
    public void loginForCheckout(String username, String password) {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(getLoginLink()));
        driver.findElement(getLoginLink()).click();
        new WebDriverWait(driver, Duration.ofSeconds(3));
        driver.findElement(getuNameField()).sendKeys(username);
        new WebDriverWait(driver, Duration.ofSeconds(3));
        driver.findElement(getpKeyField()).sendKeys(password);
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(getLoginButton()));
        driver.findElement(getLoginButton()).click();
    }

    public void addToCart() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(getAddToCart()));
        driver.findElement(getAddToCart()).click();
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(getViewCart()));
        driver.findElement(getViewCart()).click();
    }

    public void viewCart() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(getViewCart()));
        driver.findElement(getViewCart()).click();
    }

    public void proceedToCheckout() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(getProceedToCheckout()));
        driver.findElement(getProceedToCheckout()).click();
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(getOrderButton()));
        driver.findElement(getOrderButton()).click();
    }

    public String getEmptyCartText() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        String emptyCartText = driver.findElement(getEmptyCart()).getText();
        return emptyCartText;
    }


    
    // CHECKOUT PAGE THINGS

    //THE NAME OF THE TOP GAME IN THE TABLE AFTER ADDING TO CART
    private By checkOutGameName = By.xpath("/html/body/app-root/app-cart/div/div/div[2]/table/tbody/tr/td[2]/span[1]/b");

    private By shoppingCartEmptyMessage = By.xpath("/html/body/app-root/app-cart/div[1]/h4");

    private By removeButton_First_Item_In_Cart = By.xpath("/html/body/app-root/app-cart/div/div/div[2]/table/tbody/tr/td[1]/button");

    public String getCheckOutGameName() {

        String gameName = driver.findElement(checkOutGameName).getText();
        return gameName;

    }

    public void clickremoveButton_First_Item_In_Cart() {
        driver.findElement(removeButton_First_Item_In_Cart).click();
    }

    public String getEmptyStringMessage() {
        String msg = driver.findElement(shoppingCartEmptyMessage).getText();
        return msg;
    }


}
