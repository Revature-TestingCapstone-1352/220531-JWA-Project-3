package com.revature.steps;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.revature.pages.CartPage;
import com.revature.runner.GameRunner;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;



public class CartPageStepImpl {
	//This is where the driver will execute these tests.
	
		private static WebDriver driver = GameRunner.driver;
		private static CartPage cartPage = GameRunner.cartPage;
		
		@Given("User is on the HomePage")
		public void user_is_on_the_home_page() {
			driver.get("http://localhost:4200");
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		}
		
		@When("User clicks the Cart button")
		public void user_clicks_the_cart_button() {
			// Write code here that turns the phrase above into concrete actions
			 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			 driver.findElement(cartPage.navCartButton).click();
		}
		
		@Then("User should be on the Cart page")
		public void user_should_be_on_the_cart_page() {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
			String theURL = driver.getCurrentUrl();
			assertEquals("http://localhost:4200/cart",theURL);
		}
		
		

}
