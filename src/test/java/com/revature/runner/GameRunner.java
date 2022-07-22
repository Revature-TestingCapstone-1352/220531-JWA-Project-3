package com.revature.runner;

import java.io.File;

import org.junit.Test;
import org.junit.platform.suite.api.Suite;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.revature.pages.CartPage;
import com.revature.pages.CheckoutPage;
import com.revature.pages.HomePage;
import com.revature.steps.CartPageStepImpl;

import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@Suite
@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/chromedriver.exe", glue = "com.revature.steps" )
public class GameRunner {

	public  WebDriver getDriver() {
		
		File chrome = new File("src/test/resources/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver",chrome.getAbsolutePath());
		
		driver = new ChromeDriver();
		return driver;
	}
	
	
	public static  WebDriver driver;

	public static CartPage cartPage;
	public static CartPageStepImpl cartPageSteps;

	public static CheckoutPage checkoutPage;
	public static HomePage homePage;


	@BeforeAll
	public static void setup() {
		File chrome = new File("src/test/resources/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver",chrome.getAbsolutePath());
		
		driver = new ChromeDriver();
		
		//ADD YOUR WEB PAGES HERE
		cartPage = new CartPage(driver);

		checkoutPage = new CheckoutPage(driver);
		homePage = new HomePage(driver);
	}
	
	
	
//	@Test
//	public void canClickCartButton() throws InterruptedException {
//		cartPageSteps.randoTesto();
//	}
	
	
	@AfterAll
	public static void teardown() {
		driver.quit();
	}
	
	
}
