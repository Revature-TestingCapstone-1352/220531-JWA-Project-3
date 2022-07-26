package com.revature.steps;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;

import com.revature.pages.CartPage;
import com.revature.pages.HomePage;
import com.revature.pages.LoginPage;
import com.revature.pages.WishListPage;
import com.revature.runner.GameRunner;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class jfRemoveGameFromCartStepImpl {

	
	private static WebDriver driver = GameRunner.driver;
	private static CartPage cartPage = GameRunner.cartPage;
	private static HomePage homePage = GameRunner.homePage;
	private static LoginPage loginPage = GameRunner.loginPage;
	private static WishListPage wishListPage = GameRunner.wishListPage;
	
	
	@When("User clicks the removeGameButton")
	public void user_clicks_the_remove_game_button() {
		
		cartPage.clickremoveButton_First_Item_In_Cart();
		
	    
	}

	@Then("User should see the empty cart message")
	public void user_should_see_the_empty_cart_message() {
		
		String what_msg_should_be = "Your shopping cart is empty!";
		String actual_msg = cartPage.getEmptyStringMessage();
		
		assertEquals(what_msg_should_be,actual_msg);
	  
	}
	
	
	
	
}
