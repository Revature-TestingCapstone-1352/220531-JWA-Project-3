package com.revature.runner;

import com.revature.pages.*;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import org.junit.platform.suite.api.Suite;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.revature.pages.CartPage;
import com.revature.pages.CheckoutPage;
import com.revature.pages.HomePage;
import com.revature.pages.LoginPage;

import com.revature.pages.StorePage;

import com.revature.pages.UserInfoPage;

import com.revature.pages.WishListPage;


import java.io.File;
import java.time.Duration;


@Suite
public class GameRunner {
	
	public static  WebDriver driver;

	// we'll need a driver and an instance of our WikiPage POM
	public static CartPage cartPage;
	public static LoginPage loginPage;
	public static CheckoutPage checkoutPage;
	public static WishListPage wishListPage;
	public static UserInfoPage userInfoPage;
	public static HomePage homePage;
	public static StorePage storePage;

	@BeforeAll
	public static void setup() {
		File chrome = new File("src/test/resources/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver",chrome.getAbsolutePath());
		
		driver = new ChromeDriver();
		

		checkoutPage = new CheckoutPage(driver);
		cartPage = new CartPage(driver);
		loginPage = new LoginPage(driver);
		wishListPage = new WishListPage(driver);
		
		//ADD YOUR WEB PAGES HERE
		userInfoPage = new UserInfoPage(driver);
		homePage = new HomePage(driver);

		storePage = new StorePage(driver);
		//ADD YOUR WEB PAGES HERE

		driver.get("http://localhost:4200");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

	}
	
	@AfterAll
	public static void teardown() {
		driver.quit();
	}
}
