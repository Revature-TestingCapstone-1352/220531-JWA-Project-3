package com.revature.steps;

import org.openqa.selenium.WebDriver;

import com.revature.runner.GameRunner;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddToCartFromHomePageStepImpl {
	
	public static WebDriver driver = GameRunner.driver;
	
	@Given("the User is on the home page")
	public void the_user_is_on_the_home_page() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	
	@When("the User clicks on Add To Cart on a game")
	public void the_user_clicks_on_add_to_cart_on_a_game() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("the User clicks on the Cart button")
	public void the_user_clicks_on_the_cart_button() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("the User should see the game they added in their cart")
	public void the_user_should_see_the_game_they_added_in_their_cart() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
}
