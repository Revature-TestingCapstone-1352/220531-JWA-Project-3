package com.revature.runner;

import java.io.File;
//import io.cucumber.junit.*;

import org.junit.platform.suite.api.Suite;
//import org.junit.jupiter.api.AfterAll;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
//import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.revature.pages.HomePage;

//
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/chromedriver.exe", glue = "com.revature.steps" )
@Suite
public class GameRunner {
	
	public static WebDriver driver;
	public static HomePage homePage;

	public  WebDriver getDriver() {
		
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
		homePage = new HomePage(driver);
	}
	
	@AfterAll
	public static void teardown() {
		driver.quit();
	}
	
	
}
