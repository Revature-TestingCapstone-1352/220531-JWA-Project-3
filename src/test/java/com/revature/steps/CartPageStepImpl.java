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
import com.revature.pages.WishListPage;
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
		private static WishListPage wishListPage = GameRunner.wishListPage;
		
		
		
		@Given("User has navigated to the LandingPage")
		public void user_has_navigated_to_the_landing_page() {
			driver.get("http://localhost:4200");
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		}

		@Given("User navigates to LoginPage")
		public void user_navigates_to_login_page() {
			homePage.navToLoginPage();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		}

		
		@Given("User enters correct credentials and logs in")
		public void user_enters_correct_credentials_and_logs_in() {
			loginPage.loginValidUser("joshua_test", "test_joshua");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		}
		
		
		
		
		
		@Given("User navigates to StorePage")
		public void user_navigates_to_store_page() {
		    homePage.navToStore();
		    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		}
		
		
		@When("User clicks the addToWishListButton")
		public void user_clicks_the_add_to_wish_list_button() {
	
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		    cartPage.testStoreAddToWLButt();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
		}

		

		
		
		@Given("User navigates to wishListPage")
		public void user_navigates_to_wish_list_page() {
			
			
		    homePage.navToWishListPage();
		    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
		}
		
		
		

		
		@Given("User clicks the addToCartButton")
		public void user_clicks_the_add_to_cart_button() {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
			cartPage.clickAddToCartButton();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		  
		}
		
		@When("User navigates to cart")
		public void user_navigates_to_cart() {
			
			homePage.clickNavToCart();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		   
		}
		
		@Then("User should see the game in the cart")
		public void user_should_see_the_game_in_the_cart() {
			
			String gameName_ItShouldBe = "Evochron Mercenary";
			
			String actualGameName = cartPage.getCheckOutGameName();
		   
			assertEquals(gameName_ItShouldBe,actualGameName);

			
			
		}

				
		
		

		

}
