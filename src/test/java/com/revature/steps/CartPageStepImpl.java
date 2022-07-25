package com.revature.steps;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.revature.pages.CartPage;
import com.revature.pages.HomePage;
import com.revature.pages.LoginPage;
import com.revature.runner.GameRunner;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;



public class CartPageStepImpl {
	//This is where the driver will execute these tests.
	
		private static WebDriver driver = GameRunner.driver;
		private static CartPage cartPage = GameRunner.cartPage;
		private static HomePage homePage = GameRunner.homePage;
		private static LoginPage loginPage = GameRunner.loginPage;
		

		@Given("User is on the HomePage")
		public void user_is_on_the_home_page() {
			driver.get("http://localhost:4200");
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		}
		
		@When("User clicks the Cart button")
		public void user_clicks_the_cart_button() {
			// Write code here that turns the phrase above into concrete actions
			 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//			 driver.findElement(cartPage.navCartButton).click();
		}
		
		@Then("User should be on the Cart page")
		public void user_should_be_on_the_cart_page() {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
			String theURL = driver.getCurrentUrl();
			assertEquals("http://localhost:4200/cart",theURL);
		}
		
		
		
		//-----------------------------------------------------------------------------
		
		
		
		
		@Given("User has navigated to the HomePage")
		public void user_has_navigated_to_the_home_page() {
			driver.get("http://localhost:4200/");
			homePage.navToLoginPage();
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
			
			// Write code here that turns the phrase above into concrete actions
//			throw new io.cucumber.java.PendingException();
		}
		
		@Given("The User has navigated to the loginPage")
		public void the_user_has_navigated_to_the_login_page() {
			// Write code here that turns the phrase above into concrete actions
			throw new io.cucumber.java.PendingException();
		}
		
		@Given("The User has inserted credentials and logged in")
		public void the_user_has_inserted_credentials_and_logged_in() {
			// Write code here that turns the phrase above into concrete actions
			throw new io.cucumber.java.PendingException();
		}
		
		@Given("The User is on the general landing page")
		public void the_user_is_on_the_general_landing_page() {
			// Write code here that turns the phrase above into concrete actions
			throw new io.cucumber.java.PendingException();
		}
		
		@When("User clicks on Cart page")
		public void user_clicks_on_cart_page() {
			// Write code here that turns the phrase above into concrete actions
			throw new io.cucumber.java.PendingException();
		}
		
		

}
