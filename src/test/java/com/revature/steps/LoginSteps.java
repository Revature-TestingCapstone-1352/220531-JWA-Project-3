package com.revature.steps;

import static org.junit.Assert.*;

import com.revature.pages.CartPage;
import com.revature.pages.HomePage;
import com.revature.pages.LoginPage;
import com.revature.pages.RegisterPage;
import com.revature.pages.UserInfoPage;
import com.revature.pages.WishListPage;
import com.revature.runner.GameRunner;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {

	private LoginPage loginPage = GameRunner.loginPage;
	private RegisterPage registerPage = GameRunner.registerPage;
	private HomePage homePage = GameRunner.homePage;
	private CartPage cartPage = GameRunner.cartPage;
	private WishListPage wishlistPage = GameRunner.wishListPage;
	private UserInfoPage userInfoPage = GameRunner.userInfoPage;
	
	@Given("the user is on the login page")
	public void the_user_is_on_the_login_page() {
	    loginPage.toLoginPage();
	}

	@When("the user enters valid credentials to log in")
	public void the_user_enters_valid_credentials() {
	    homePage = loginPage.loginValidUser("TestUser", "TestPass");
	}

	@Then("the user is redirected to the store page")
	public void the_user_is_redirected_to_the_store_page() {
	    assertTrue(homePage.onHomePage());
	}

	@Then("the user is logged in")
	public void the_user_is_logged_in() {
		assertTrue(loginPage.isLoggedIn());
	}

	@When("the user enters invalid credentials to log in")
	public void the_user_enters_invalid_credentials() {
		registerPage = loginPage.loginInvalidUser("TestNotAUser", "TestNotAPass");
	}
	
	@When("the user enters the wrong username to log in")
	public void the_user_enters_the_wrong_username_to_log_in() {
		registerPage = loginPage.loginInvalidUser("TestNotAUser", "TestPass");
	}

	@When("the user enters the wrong password to log in")
	public void the_user_enters_the_wrong_password_to_log_in() {
		registerPage = loginPage.loginInvalidUser("TestUser", "TestNotAPass");
	}

	@Then("the user is redirected to the registration page")
	public void the_user_is_redirected_to_the_registration_page() {
	    assertTrue(registerPage.isOnThePage());
	}

	@Then("the user is not logged in")
	public void the_user_is_not_logged_in() {
		assertFalse(loginPage.isLoggedIn());
	}

	@Given("a user is logged in")
	public void a_user_is_logged_in() {
		loginPage.initialLogin();
	}

	@Given("a user has added a game to their cart")
	public void a_user_has_added_a_game_to_their_cart() {
	    homePage = loginPage.toStorePage();
	    homePage.addItemToCart();
	}

	@Given("a user is on the cart page")
	public void a_user_goes_to_the_cart_page() {
	    cartPage = loginPage.toCartPage();
	}

	@When("a user clicks the logout button")
	public void a_user_clicks_the_logout_button() {
	    loginPage.logout();
	}

	@When("a user goes to the cart page")
	public void a_user_goes_to_the_cart_page1() {
	    cartPage = loginPage.toCartPage();
	}

	@Then("the cart should be empty")
	public void the_cart_should_be_empty() {
		assertTrue(cartPage.isCartEmpty());
		
	}

	@Given("a user has added a game to their wishlist")
	public void a_user_has_added_a_game_to_their_wishlist() {
		homePage.addItemToWishlist();
	}

	@Given("a user is on the wishlist page")
	public void a_user_goes_to_the_wishlist_page() {
	    loginPage.toWishlistPage();
	}

	@When("a user goes to the wishlist page")
	public void a_user_goes_to_the_wishlist_page1() {
	    loginPage.toWishlistPage();
	}

	@Then("the wishlist should be empty")
	public void the_wishlist_should_be_empty() {
	    assertTrue(wishlistPage.isWishlistEmpty());
	}

	@Given("a user is on the user information page")
	public void a_user_goes_to_the_user_information_page() {
	    userInfoPage = loginPage.toUserInfoPage();
	}

	@When("a user goes to the user information page")
	public void a_user_goes_to_the_user_information_page1() {
		userInfoPage = loginPage.toUserInfoPage();
	}

	@Then("the user information page should be empty")
	public void the_user_information_page_should_be_empty() {
	    assertTrue(userInfoPage.isUserPageEmpty());
	}
	
	@Given("the user is already logged out")
	public void the_user_is_already_logged_out() {
	    loginPage.initialLogout();
	}
	
	
	
}
