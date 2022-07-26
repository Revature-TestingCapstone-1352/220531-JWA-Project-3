package com.revature.steps;

import static org.junit.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.revature.pages.CartPage;
import com.revature.pages.HomePage;
import com.revature.pages.LoginPage;
import com.revature.runner.GameRunner;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddToCartFromHomePageStepImpl {
	
	public static WebDriver driver = GameRunner.driver;
	public static HomePage homePage = new HomePage(driver);
	public static LoginPage loginPage = new LoginPage(driver);
	public static CartPage cartPage = new CartPage(driver);
	
	@Given("the User is on the home page")
	public void the_user_is_on_the_home_page() {
        driver.get("http://localhost:4200");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
  	}
	
	@When("the User clicks on Add To Cart on a game")
	public void the_user_clicks_on_add_to_cart_on_a_game() {
		new WebDriverWait(driver, Duration.ofSeconds(10))
		.until(ExpectedConditions.elementToBeClickable(homePage.getfirstAddToCartButton()));
	    homePage.clickFirstAddToCartButtion();
	}

	@When("the User clicks on the Cart button")
	public void the_user_clicks_on_the_cart_button() {
		new WebDriverWait(driver, Duration.ofSeconds(10))
		.until(ExpectedConditions.elementToBeClickable(homePage.navCartButton));
	    homePage.clickNavToCart(); 
	}

	@Then("the User should see the game they added in their cart")
	public void the_user_should_see_the_game_they_added_in_their_cart() {
		new WebDriverWait(driver, Duration.ofSeconds(10))
			.until(ExpectedConditions.urlToBe("http://localhost:4200/cart"));
		
	    assertEquals("Evochron Mercenary", cartPage.getCartTableFirstItemName());
	}
	
	@Given("the User logged in and on the home page")
	public void the_user_logged_in_and_on_the_home_page() {
		new WebDriverWait(driver, Duration.ofSeconds(10))
			.until(ExpectedConditions.elementToBeClickable(homePage.getLoginLink()));

		homePage.navToLoginPage();
		loginPage.loginValidUser("Testing123", "Orders");
	}
}
