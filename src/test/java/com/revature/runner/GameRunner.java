package com.revature.runner;

import java.io.File;
import java.time.Duration;

import org.junit.platform.suite.api.Suite;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.revature.pages.CartPage;
import com.revature.pages.CheckoutPage;
import com.revature.pages.HomePage;
import com.revature.pages.LoginPage;
import com.revature.pages.UserInfoPage;
import com.revature.pages.RegisterPage;
import com.revature.pages.WishListPage;

import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;

 
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
	public static RegisterPage registerPage;

	
	public  WebDriver getDriver() 
  {
		
		File chrome = new File("src/test/resources/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver",chrome.getAbsolutePath());
		driver = new ChromeDriver();
		
		
		return driver;
	}
	



	
	@BeforeAll //@BeforeClass is JUnit 4
	public static void setup() {
		File chrome = new File("src/test/resources/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver",chrome.getAbsolutePath());
		
		driver = new ChromeDriver();
		

		//ADD YOUR WEB PAGES HERE
		
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
