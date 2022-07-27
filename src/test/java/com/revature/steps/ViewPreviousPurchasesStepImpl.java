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

	@Given("a User enters their {string} and {string} in the login form and click the login button")
	public void a_user_enters_their_and_in_the_login_form(String username, String password) {
		driver.get("http://localhost:4200");
		new WebDriverWait(driver, Duration.ofSeconds(10))
			.until(ExpectedConditions.elementToBeClickable(homePage.getLoginLink()));

		homePage.navToLoginPage();
		loginPage.loginValidUser(username, password);
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

	@Then("{string} can see a previous purchase they have made")
	public void they_can_see_a_previous_purchase_they_have_made(String username) {
		userInfoPage.waitForOrderHistoryHeader();
		
		if (username.equals("Testing123")) {
			assertEquals("Order Placed: 2022-07-24", userInfoPage.getFirstOrderDate());
			assertEquals("Order Total: €39.98", userInfoPage.getFirstOrderTotal());
			assertEquals("The Elder Scrolls V: Skyrim", userInfoPage.getFirstOrderFirstGame());
			assertEquals("BioShock", userInfoPage.getFirstOrderSecondGame());
		} 
		if (username.equals("Multiple")) {
			assertEquals("Order Placed: 2022-07-26", userInfoPage.getFirstOrderDate());
			assertEquals("Order Total: €39.98", userInfoPage.getFirstOrderTotal());
			assertEquals("Portal", userInfoPage.getFirstOrderFirstGame());
			assertEquals("Super Street Fighter IV Arcade Edition", userInfoPage.getFirstOrderSecondGame());
			
			assertEquals("Order Placed: 2022-07-24", userInfoPage.getSecondOrderDate());
			assertEquals("Order Total: €9.99", userInfoPage.getSecondOrderTotal());
			assertEquals("Saints Row: The Third", userInfoPage.getSecondOrderFirstGame());
		}
	}
}
