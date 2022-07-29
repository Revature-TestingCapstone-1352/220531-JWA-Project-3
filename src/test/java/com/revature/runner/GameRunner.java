package com.revature.runner;

import java.io.File;

import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.revature.pages.CartPage;
import com.revature.pages.CheckoutPage;
import com.revature.pages.HomePage;
import com.revature.pages.LoginPage;
import com.revature.pages.RegisterPage;
import com.revature.pages.StorePage;
import com.revature.pages.UserInfoPage;
import com.revature.pages.WishListPage;

import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;

@Suite
@SelectClasspathResource("features")
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
	public static StorePage storePage;

  @BeforeAll //@BeforeClass is JUnit 4
	public static void setup() {
		File chrome = new File("src/test/resources/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver",chrome.getAbsolutePath());
		
		driver = new ChromeDriver();
		
		homePage = new HomePage(driver);
		checkoutPage = new CheckoutPage(driver);
		loginPage = new LoginPage(driver);
		wishListPage = new WishListPage(driver);
		registerPage = new RegisterPage(driver);
		cartPage = new CartPage(driver);
		userInfoPage = new UserInfoPage(driver);
		storePage = new StorePage(driver);
	}
  
	@AfterAll
	public static void teardown()
  	{
		driver.quit();
	}


}
