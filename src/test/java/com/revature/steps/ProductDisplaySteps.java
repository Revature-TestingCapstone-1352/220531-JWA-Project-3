package com.revature.steps;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

import com.revature.pages.HomePage;
import com.revature.runner.GameRunner;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProductDisplaySteps {
	public static WebDriver driver = GameRunner.driver;
	public static HomePage homePage = GameRunner.homePage;
	
	@Given("a User is on the Store Page")
	public void a_user_is_on_the_store_page() {
	    homePage.loginForHomePage("joshua_test", "test_joshua");
	}

	@When("the games are displayed")
	public void the_games_are_displayed() {
	    assertEquals(homePage.areDisplayed(), true);
	}

	@Then("there should be a maximum of twenty-four games displayed per page")
	public void maximum_of_twentyfour_games() {
	    assertEquals(homePage.areThereTwentyFour(), 24);
	}

	@Given("a User is on the Store Page again")
	public void a_user_is_on_the_store_page_again() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("when the User clicks on the Metacritic link of a game")
	public void when_the_user_clicks_on_the_metacritic_link_of_a_game() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("there is a valid Metacritic review displayed")
	public void there_is_a_valid_metacritic_review_displayed() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
}
