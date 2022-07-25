package com.revature.steps;

import static org.junit.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.revature.pages.HomePage;
import com.revature.pages.UserInfoPage;
import com.revature.runner.GameRunner;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ViewPreviousPurchasesStepImpl {

	public static WebDriver driver = GameRunner.driver;
	public static HomePage homePage = GameRunner.homePage;
	public static UserInfoPage userInfoPage = GameRunner.userInfoPage;
	
	public void loginForPreviousOrder(String username, String password) {
		new WebDriverWait(driver, Duration.ofSeconds(10))
			.until(ExpectedConditions.elementToBeClickable(homePage.getLoginLink()));
		
		driver.findElement(homePage.getLoginLink()).click();
		driver.findElement(homePage.getuNameField()).sendKeys(username);
		driver.findElement(homePage.getpKeyField()).sendKeys(password);
		driver.findElement(homePage.getLoginButton()).click();
	}
	
	@Given("a User is logged in and has made a previous purchase")
	public void a_user_is_logged_in_and_has_made_a_previous_purchase() {
		loginForPreviousOrder("Testing123", "Orders");
	}

	@When("they click on the User Information button")
	public void they_click_on_the_user_information_button() {
		new WebDriverWait(driver, Duration.ofSeconds(10))
			.until(ExpectedConditions.elementToBeClickable(homePage.getUserInfoLink()));
		
		driver.findElement(homePage.getUserInfoLink()).click();
	}

	@When("then they click on the View Previous Orders button")
	public void then_they_click_on_the_view_previous_orders_button() {
		new WebDriverWait(driver, Duration.ofSeconds(10))
			.until(ExpectedConditions.elementToBeClickable(userInfoPage.getViewOrderHistoryButton()));
		
		driver.findElement(userInfoPage.getViewOrderHistoryButton()).click();
	}

	@Then("they can see previous purchases they have made")
	public void they_can_see_previous_purchases_they_have_made() {
		new WebDriverWait(driver, Duration.ofSeconds(10))
			.until(ExpectedConditions.visibilityOf(driver.findElement(userInfoPage.getOrderHistoryHeader())));
		
		assertEquals("Order Placed: 2022-07-24", driver.findElement(userInfoPage.getFirstOrderDate()).getText());
		assertEquals("Order Total: €39.98", driver.findElement(userInfoPage.getFirstOrderTotal()).getText());
		assertEquals("The Elder Scrolls V: Skyrim", driver.findElement(userInfoPage.getFirstOrderFirstGame()).getText());
		assertEquals("BioShock", driver.findElement(userInfoPage.getFirstOrderSecondGame()).getText());
	}
}
