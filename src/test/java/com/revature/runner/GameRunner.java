package com.revature.runner;

import com.revature.pages.*;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import java.io.File;
//import io.cucumber.junit.*;
import java.time.Duration;

import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.Suite;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;

import com.revature.pages.*;


import com.revature.pages.CheckoutPage;
import com.revature.pages.HomePage;
import com.revature.pages.LoginPage;
import com.revature.pages.RegisterPage;
import com.revature.pages.UserInfoPage;
import com.revature.pages.WishListPage;


import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@Suite
@IncludeTags("CucumberTests")
public class GameRunner {
	
	
	
	// we'll need a driver and an instance of our WikiPage POM
	public static  WebDriver driver;
	public static LoginPage loginPage;
	public static CheckoutPage checkoutPage;
	public static WishListPage wishListPage;
	public static HomePage homePage;
	public static RegisterPage registerPage;
	public static CartPage cartPage;
	public static UserInfoPage userInfoPage;

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
	public static void teardown() 
  	{
		driver.quit();
	}
	
	
}