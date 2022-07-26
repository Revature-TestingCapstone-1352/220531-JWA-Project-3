package com.revature.steps;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.revature.pages.CheckoutPage;
import com.revature.pages.HomePage;
import com.revature.pages.LoginPage;
import com.revature.runner.GameRunner;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CheckoutSteps {
	public static WebDriver driver = GameRunner.driver;
	public static CheckoutPage checkoutPage = GameRunner.checkoutPage;
	public static LoginPage loginPage = GameRunner.loginPage;
	public static HomePage homePage = GameRunner.homePage;
	
	@Given("that a User has an Item in their Cart and is viewing their Cart")
	public void that_a_user_has_an_item_in_their_cart_and_is_viewing_their_cart() {
	    driver.get("http://localhost:4200");
	    new WebDriverWait(driver, Duration.ofSeconds(5));
	    homePage.navigateToLoginPage();
		loginPage.loginValidUser("joshua_test", "test_joshua");
		new WebDriverWait(driver, Duration.ofSeconds(5));
		checkoutPage.addToCart();
	}

	@When("the User clicks the Proceed to Checkout button, then the Place Order button")
	public void the_user_clicks_the_proceed_to_checkout_button_then_the_place_order_button() {
		new WebDriverWait(driver, Duration.ofSeconds(5));
		checkoutPage.proceedToCheckout();
	}

	@Then("the User will have successfully bought the games")
	public void the_user_will_have_successfully_bought_the_games() {

		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfElementLocated(checkoutPage.getThankYou()));
		String thankYouText = driver.findElement(checkoutPage.getThankYou()).getText();
		assertEquals(thankYouText, "Thank you for your Order.");

	}

	@Given("that a User has an empty Cart and is viewing their Cart")
	public void that_a_user_has_an_empty_cart_and_is_viewing_their_cart() {

		driver.get("http://localhost:4200");
		new WebDriverWait(driver, Duration.ofSeconds(5));
		checkoutPage.loginForCheckout("joshua_test", "test_joshua");
		new WebDriverWait(driver, Duration.ofSeconds(5));
		checkoutPage.viewCart();
	}

	@When("the User tries to Checkout")
	public void the_user_tries_to_checkout() {
	    new WebDriverWait(driver, Duration.ofSeconds(3));
	}

	@Then("the Cart Page will display that the Cart is empty and the Proceed to Checkout will not be displayed")
	public void the_cart_page_will_display_that_the_cart_is_empty_and_the_proceed_to_checkout_will_not_be_displayed() {
		String emptyCartText = checkoutPage.getEmptyCartText();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		assertEquals(emptyCartText, "Your shopping cart is empty!");

	}

	@When("the User clicks the Checkout Tab")
	public void the_user_clicks_the_checkout_tab() {
		driver.findElement(homePage.getCheckoutPage()).click();
		new WebDriverWait(driver, Duration.ofSeconds(3));
	}

	@Then("the User should be told to proceed from Cart")
	public void the_user_should_be_told_to_proceed_from_cart() {
		
		new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.presenceOfElementLocated(checkoutPage.getProceedFromCartMsg()));
		String wantedMsg = "Please proceed from Cart.";
		String foundMsg = driver.findElement(checkoutPage.getProceedFromCartMsg()).getText();
//		System.out.println("FOUND=" + foundMsg);
		assertEquals(wantedMsg, foundMsg);
	}

}
