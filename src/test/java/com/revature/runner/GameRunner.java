package com.revature.runner;

import java.io.File;
import java.time.Duration;

import org.junit.Test;
import org.junit.platform.suite.api.Suite;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.revature.pages.CartPage;
import com.revature.steps.CartPageStepImpl;
import com.revature.pages.CheckoutPage;
import com.revature.pages.HomePage;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

//@CucumberOptions(features = "src/test/resources/chromedriver.exe", glue = "com.revature.steps" )
@Suite
@RunWith(Cucumber.class)
//@CucumberOptions(features = "Features" )


@CucumberOptions(features = "src/test/resources/",
plugin = {"pretty", "html:target/cucumber/bagextra"},
glue = "com.revature.steps",
extraGlue = "io.tpd.springbootcucumber.bagcommons")
public class GameRunner {
	
	
	
	// we'll need a driver and an instance of our WikiPage POM
	public static  WebDriver driver;

	// we'll need a driver and an instance of our WikiPage POM
	public static CartPage cartPage;
	

	public static CheckoutPage checkoutPage;
	public static HomePage homePage;


	@BeforeAll //@BeforeClass is JUnit 4
	public static void setup() {
		File chrome = new File("src/test/resources/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver",chrome.getAbsolutePath());
		
		driver = new ChromeDriver();
		
		//ADD YOUR WEB PAGES HERE
		cartPage = new CartPage(driver);

//		checkoutPage = new CheckoutPage(driver);
//		homePage = new HomePage(driver);
		
		
		// THIS WILL TAKE ALL TESTS TO THE HOME PAGE BEFORE ALL TESTS.
	


		
	}
	

	
	
	@AfterAll
	public static void teardown() {
//		driver.quit();
	}
	
	
}
