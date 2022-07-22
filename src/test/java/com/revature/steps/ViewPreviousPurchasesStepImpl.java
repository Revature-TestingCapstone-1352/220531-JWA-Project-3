package com.revature.steps;

import org.openqa.selenium.WebDriver;

import com.revature.runner.GameRunner;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ViewPreviousPurchasesStepImpl {

	public static WebDriver driver = GameRunner.driver;
	
	@Given("a User logs in and has already made a purchase")
	public void a_user_logs_in_and_has_already_made_a_purchase() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("a User clicks the User Information button")
	public void a_user_clicks_the_user_information_button() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("clicks on the View Previous Orders button")
	public void clicks_on_the_view_previous_orders_button() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("the User should see past purchases they made")
	public void the_user_should_see_past_purchases_they_made() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
}
