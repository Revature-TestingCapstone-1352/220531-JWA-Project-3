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

    public static CartPage cartPage;
    public static LoginPage loginPage;
    public static CheckoutPage checkoutPage;
    public static WishListPage wishListPage;
    public static UserInfoPage userInfoPage;
    public static HomePage homePage;
    public static RegisterPage registerPage;

    @BeforeAll //@BeforeClass is JUnit 4
    public static void setup() {
        File chrome = new File("src/test/resources/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", chrome.getAbsolutePath());

        driver = new ChromeDriver();

        checkoutPage = new CheckoutPage(driver);
        cartPage = new CartPage(driver);
        loginPage = new LoginPage(driver);
        wishListPage = new WishListPage(driver);
        homePage = new HomePage(driver);
        registerPage = new RegisterPage(driver);
        userInfoPage = new UserInfoPage(driver);
    }

    @AfterAll
    public static void teardown() {
        driver.quit();
    }
}
