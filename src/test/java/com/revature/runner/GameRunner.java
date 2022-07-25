package com.revature.runner;

import java.io.File;
import java.time.Duration;

import org.junit.platform.suite.api.Suite;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.revature.pages.CartPage;
import com.revature.pages.CheckoutPage;
import com.revature.pages.HomePage;
import com.revature.pages.LoginPage;
import com.revature.pages.WishListPage;

import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


//@CucumberOptions(features = "Features" )
@Suite
@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/chromedriver.exe", glue = "com.revature.steps" )
public class GameRunner {
	
	public static  WebDriver driver;

	// we'll need a driver and an instance of our WikiPage POM
	public static CartPage cartPage;
	public static LoginPage loginPage;
	public static CheckoutPage checkoutPage;
	public static WishListPage wishListPage;
	public static HomePage homePage;


	public  WebDriver getDriver() //what is this for? when is it used?
  {
		
		File chrome = new File("src/test/resources/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver",chrome.getAbsolutePath());
		driver = new ChromeDriver();
		
		
		return driver;
	}


	@BeforeAll
	public static void setup() {
		File chrome = new File("src/test/resources/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver",chrome.getAbsolutePath());
		
		driver = new ChromeDriver();
		

		checkoutPage = new CheckoutPage(driver);
		cartPage = new CartPage(driver);
		loginPage = new LoginPage(driver);
		wishListPage = new WishListPage(driver);
		cartPage = new CartPage(driver);
		homePage = new HomePage(driver);
		
		
		
		driver.get("http://localhost:4200");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

	}
	
	@AfterAll
	public static void teardown() {
		driver.quit();
	}
}
