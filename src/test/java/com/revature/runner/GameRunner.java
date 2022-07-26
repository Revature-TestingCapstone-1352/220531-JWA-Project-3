package com.revature.runner;

import java.io.File;
//import io.cucumber.junit.*;
import java.time.Duration;

import org.junit.platform.suite.api.Suite;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.revature.pages.CheckoutPage;
import com.revature.pages.HomePage;
import com.revature.pages.LoginPage;
import com.revature.pages.RegisterPage;
import com.revature.pages.WishListPage;

import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/chromedriver.exe", glue = "com.revature.steps" )
@Suite
public class GameRunner {
	
	
	
	// we'll need a driver and an instance of our WikiPage POM
	public static  WebDriver driver;
	public static LoginPage loginPage;
	public static CheckoutPage checkoutPage;
	public static WishListPage wishListPage;
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
		loginPage = new LoginPage(driver);
		wishListPage = new WishListPage(driver);
		homePage = new HomePage(driver);
		registerPage = new RegisterPage(driver);
		
		//ADD YOUR WEB PAGES HERE
	}
	
	@AfterAll
	public static void teardown() 
  {
		driver.quit();
	}
	
	
}
