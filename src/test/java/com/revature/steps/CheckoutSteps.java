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

import com.revature.pages.CheckoutPage;
import com.revature.runner.GameRunner;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CheckoutSteps {
	public static WebDriver driver = GameRunner.driver;
	public static CheckoutPage checkoutPage = GameRunner.checkoutPage;
	
	@Given("that a User has an Item in their Cart and is viewing their Cart")
	public void that_a_user_has_an_item_in_their_cart_and_is_viewing_their_cart() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("the User clicks the Proceed to Checkout button, then the Place Order button")
	public void the_user_clicks_the_proceed_to_checkout_button_then_the_place_order_button() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("the User will have successfully bought the games")
	public void the_user_will_have_successfully_bought_the_games() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Given("that a User has an empty Cart and is viewing their Cart")
	public void that_a_user_has_an_empty_cart_and_is_viewing_their_cart() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("the User tries to Checkout")
	public void the_user_tries_to_checkout() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("the Cart Page will display that the Cart is empty and the Proceed to Checkout will not be displayed")
	public void the_cart_page_will_display_that_the_cart_is_empty_and_the_proceed_to_checkout_will_not_be_displayed() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
}
