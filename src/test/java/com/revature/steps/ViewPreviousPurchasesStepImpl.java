package com.revature.steps;

import static org.junit.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.revature.pages.HomePage;
import com.revature.pages.LoginPage;
import com.revature.pages.UserInfoPage;
import com.revature.runner.GameRunner;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ViewPreviousPurchasesStepImpl {

	public static WebDriver driver = GameRunner.driver;
	public static HomePage homePage = new HomePage(driver);
	public static LoginPage loginPage = new LoginPage(driver);
	public static UserInfoPage userInfoPage = new UserInfoPage(driver);
	
	@Given("a User is logged in and has made a previous purchase")
	public void a_user_is_logged_in_and_has_made_a_previous_purchase() {
		new WebDriverWait(driver, Duration.ofSeconds(10))
			.until(ExpectedConditions.elementToBeClickable(homePage.getLoginLink()));
	
		homePage.navToLoginPage();
		loginPage.loginValidUser("Testing123", "Orders");
	}

	@When("they click on the User Information button")
	public void they_click_on_the_user_information_button() {
		new WebDriverWait(driver, Duration.ofSeconds(10))
			.until(ExpectedConditions.elementToBeClickable(homePage.getfirstAddToCartButton()));
		
		driver.findElement(homePage.getUserInfoLink()).click();
	}

	@When("then they click on the View Previous Orders button")
	public void then_they_click_on_the_view_previous_orders_button() {
		userInfoPage.clickViewOrderHistoryButton();
	}

	@Then("they can see a previous purchase they have made")
	public void they_can_see_a_previous_purchase_they_have_made() {
		userInfoPage.waitForOrderHistoryHeader();
		
		assertEquals("Order Placed: 2022-07-24", userInfoPage.getFirstOrderDate());
		assertEquals("Order Total: €39.98", userInfoPage.getFirstOrderTotal());
		assertEquals("The Elder Scrolls V: Skyrim", userInfoPage.getFirstOrderFirstGame());
		assertEquals("BioShock", userInfoPage.getFirstOrderSecondGame());
	}
	
	@Given("a User is logged in and has made previous purchases")
	public void a_user_is_logged_in_and_has_made_previous_purchases() {
		// Login with different user who has made two purchases
	    throw new io.cucumber.java.PendingException();
	}
	
	@Then("they can see the previous purchases they have made")
	public void they_can_see_the_previous_purchases_they_have_made() {
		// Do the same assertions twice
	    throw new io.cucumber.java.PendingException();
	}
}
