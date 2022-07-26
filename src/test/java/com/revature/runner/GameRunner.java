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
import com.revature.pages.UserInfoPage;
import com.revature.pages.RegisterPage;
import com.revature.pages.WishListPage;


import java.io.File;


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
		

		checkoutPage = new CheckoutPage(driver);
		cartPage = new CartPage(driver);
		loginPage = new LoginPage(driver);
		wishListPage = new WishListPage(driver);
//<<<<<<< HEAD
//		
//		//ADD YOUR WEB PAGES HERE
//		userInfoPage = new UserInfoPage(driver);
//		homePage = new HomePage(driver);
//		
//		
//		
//		driver.get("http://localhost:4200");
////        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
//
//=======
		homePage = new HomePage(driver);
		registerPage = new RegisterPage(driver);
		
		//ADD YOUR WEB PAGES HERE
	}
	
	@AfterAll
	public static void teardown() {
		driver.quit();
	}
}
