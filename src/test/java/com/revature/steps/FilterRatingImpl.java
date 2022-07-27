package com.revature.steps;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

import com.revature.pages.CartPage;
import com.revature.pages.StorePage;
import com.revature.runner.GameRunner;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class FilterRatingImpl {

	
	private static WebDriver driver = GameRunner.driver;
	private static StorePage storePage = GameRunner.storePage;
	
	@Given("User will end up in the HomePage")
	public void user_will_end_up_in_the_home_page() {
		driver.get("http://localhost:4200");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	
	@When("User clicks each rating")
	public void user_clicks_each_rating() {
		storePage.clickAdd();
	}
	
	@Then("User should be able to view games that have no rating")
	public void user_should_be_able_to_view_games_filtered_by_rating() {
		
		assertEquals(6, storePage.checkNumberOfGames());
	}
	
	@When("User selects Mostly Negative filter")
	public void user_selects_mostly_negative_filter() {
		
        storePage.clickAdd();
        storePage.clickMostlyNegativeBox();
	}
	
	@Then("User should be able to view games that are Mostly Negative")
	public void User_should_be_able_to_view_games_that_are_mostly_negative() {
		
		
		assertEquals(13, storePage.checkNumberOfGames());
        
	}
	
	@When("User selects Mixed filter")
	public void User_selects_Mixed_filter() {
	
        storePage.clickAdd();
        storePage.clickMixedBox();
	}
	
	@Then("User should be able to view games that are Mixed")
	public void User_should_be_able_to_view_games_that_are_Mixed() {
	
        
		assertEquals(34, storePage.checkNumberOfGames());
	}
	
	@When("User selects Positive filter")
	public void user_selects_Positive_filter() {
	
        storePage.clickAdd();
        storePage.clickPositiveBox();
	}
	
	@Then("User should be able to view games that are Positive")
	public void User_should_be_able_to_view_games_that_are_Positive() {
	
        
		assertEquals(10, storePage.checkNumberOfGames());
	}
	
	@When("User selects Mostly Positive filter")
	public void user_selects_mostly_positive_filter() {
	
        storePage.clickAdd();
        storePage.clickMostlyPositiveBox();
	}
	
	@Then("User should be able to view games that are Mostly Positive")
	public void User_should_be_able_to_view_games_that_are_mostly_positive() {
	
        
		assertEquals(30, storePage.checkNumberOfGames());
	}
	
	@When("User selects Very Positive filter")
	public void user_selects_very_positive_filter() {
	
        storePage.clickAdd();
        storePage.clickVeryPositiveBox();
	}
	
	@Then("User should be able to view games that are Very Positive")
	public void User_should_be_able_to_view_games_that_are_very_positive() {
	
        
		assertEquals(120, storePage.checkNumberOfGames());
	}
	
	@When("User selects Overwhelmingly Positive filter")
	public void user_selects_overwhelmingly_positive_filter() {
	
        storePage.clickAdd();
        storePage.clickOverwhelminglyPositiveBox();
	}
	
	@Then("User should be able to view games that are Overwhelmingly Positive")
	public void User_should_be_able_to_view_games_that_are_overwhelmingly_positive() {
		
        
		assertEquals(44, storePage.checkNumberOfGames());
	}
	
}
