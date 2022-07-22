package com.revature.steps;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.revature.pages.HomePage;
import com.revature.runner.GameRunner;

import io.cucumber.java.en.*;

public class SearchStepImpl {
	
	HomePage homePage;
	public static WebDriver driver;// = GameRunner.driver;
//	public static HomePage homePage = GameRunner.homePage;
	
	@Given("The user is on the homepage")
	public void the_user_is_on_the_homepage() {
		//delet later
		File chrome = new File("src/test/resources/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver",chrome.getAbsolutePath());
		
		driver = new ChromeDriver();
		
		//
		
	    driver.get("http://localhost:4200/");
//	    new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.titleContains("Your Home Page"));
	}

	@When("I search for {string}")
	public void i_search_for(String string) {
	HomePage homePage = new HomePage(driver);
	   string = "Dawn of";
	   homePage.searchFor(string);
	}

	@Then("The first game should be {string}")
	public void the_first_game_should_be(String string) {
	   string = "";
	}
	
}
