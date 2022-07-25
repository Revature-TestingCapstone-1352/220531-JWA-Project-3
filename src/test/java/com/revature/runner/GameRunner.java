package com.revature.runner;

import com.revature.pages.*;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import org.junit.platform.suite.api.Suite;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;


@Suite
public class GameRunner {
    public static WebDriver driver;


    // we'll need a driver and an instance of our WikiPage POM
    public static CartPage cartPage;
    public static LoginPage loginPage;
    public static CheckoutPage checkoutPage;
    public static WishListPage wishListPage;
    public static HomePage homePage;


    @BeforeAll
    public static void setup() {
        File chrome = new File("src/test/resources/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", chrome.getAbsolutePath());

        driver = new ChromeDriver();

        checkoutPage = new CheckoutPage(driver);
        loginPage = new LoginPage(driver);
        wishListPage = new WishListPage(driver);
        cartPage = new CartPage(driver);
        homePage = new HomePage(driver);
        //ADD YOUR WEB PAGES HERE
    }

    @AfterAll
    public static void teardown() {
        driver.quit();

    }
}
