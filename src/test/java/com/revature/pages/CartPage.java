package com.revature.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class CartPage {


    //ASSIGNING THE WEB DRIVER FOR THE CARTPAGE
    private WebDriver driver;

    // a constructor to create an instance of this Page, and also initialize the web elements on the page.
    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // SETTING UP ALL THE ELEMENTS THAT WE ARE GOING TO BE USING ON THE CART PAGE


    private By addToCartButton = By.xpath("//*[@id=\"games\"]/div/div/div/div[4]/div/button[2]/span");
    public By cartTableFirstItem = By.xpath("/html/body/app-root/app-cart/div/div/div[2]/table/tbody/tr/td[2]/span[1]/b");

    // STORE PAGE ITEMS
    private By storeWishListButton = By.xpath("//*[@id=\"games\"]/div/div[1]/div/div[4]/div/button[1]");


    public void clickAddToCartButton() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(addToCartButton).click();
    }

    public String getCartTableFirstItemName() {
        return driver.findElement(cartTableFirstItem).getText();
    }

    ///////////////// WISH LIST ITEMS \\\\\\\\\\\\\\\\\\\\\\\\

    public void testStoreAddToWLButt() {
        driver.findElement(storeWishListButton).click();
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
