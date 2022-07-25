package com.revature.steps;

import java.time.Duration;

import org.openqa.selenium.WebDriver;

import com.revature.pages.CartPage;
import com.revature.pages.StorePage;
import com.revature.runner.GameRunner;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class FilterRatingImpl {

	
	private static WebDriver driver = GameRunner.driver;
	private static StorePage storePage = GameRunner.storePage;
	
//	@Given("User is on the HomePage")
//	public void user_is_on_the_home_page() {
//		driver.get("http://localhost:4200");
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//	}
	
	@When("User clicks each rating")
	public void user_clicks_each_rating() {
		storePage.clickAdd();
	}
	
	@Then("User should be able to view games that have no rating")
	public void user_should_be_able_to_view_games_filtered_by_rating() {
		
	}
	
	@When("User selects Mostly Negative filter")
	public void user_selects_mostly_negative_filter() {
		driver.get("http://localhost:4200");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	
	@Then("User should be able to view games that are Mostly Negative")
	public void User_should_be_able_to_view_games_that_are_mostly_negative() {
		driver.get("http://localhost:4200");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	
	@When("User selects Mixed filter")
	public void User_selects_Mixed_filter() {
		driver.get("http://localhost:4200");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	
	@Then("User should be able to view games that are Mixed")
	public void User_should_be_able_to_view_games_that_are_Mixed() {
		driver.get("http://localhost:4200");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	
	@When("User selects Positive filter")
	public void user_selects_Positive_filter() {
		driver.get("http://localhost:4200");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	
	@Then("User should be able to view games that are Positive")
	public void User_should_be_able_to_view_games_that_are_Positive() {
		driver.get("http://localhost:4200");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	
	@When("User selects Mostly Positive filter")
	public void user_selects_mostly_positive_filter() {
		driver.get("http://localhost:4200");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	
	@Then("User should be able to view games that are Mostly Positive")
	public void User_should_be_able_to_view_games_that_are_mostly_positive() {
		driver.get("http://localhost:4200");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	
	@When("User selects Very Positive filter")
	public void user_selects_very_positive_filter() {
		driver.get("http://localhost:4200");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	
	@Then("User should be able to view games that are Very Positive")
	public void User_should_be_able_to_view_games_that_are_very_positive() {
		driver.get("http://localhost:4200");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	
	@When("User selects Overwhelmingly Positive filter")
	public void user_selects_overwhelmingly_positive_filter() {
		driver.get("http://localhost:4200");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	
	@Then("User should be able to view games that are Overwhelmingly Positive")
	public void User_should_be_able_to_view_games_that_are_overwhelmingly_positive() {
		driver.get("http://localhost:4200");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	
}
