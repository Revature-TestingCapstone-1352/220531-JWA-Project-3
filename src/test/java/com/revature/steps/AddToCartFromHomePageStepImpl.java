package com.revature.steps;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.revature.pages.CartPage;
import com.revature.pages.HomePage;
import com.revature.runner.GameRunner;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddToCartFromHomePageStepImpl {
	
	public static WebDriver driver = GameRunner.driver;
	public static HomePage homePage = new HomePage(driver);
	public static CartPage cartPage;
	
	@Given("the User is on the home page")
	public void the_user_is_on_the_home_page() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("http://localhost:4200");
  	}
	
	@When("the User clicks on Add To Cart on a game")
	public void the_user_clicks_on_add_to_cart_on_a_game() {
	    WebElement button = driver.findElement(homePage.firstAddToCartButton);
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", button);
//	    new WebDriverWait(driver, Duration.ofSeconds(10)).until
//			(ExpectedConditions.elementToBeClickable(homePage.firstAddToCartButton));
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	    driver.findElement(homePage.firstAddToCartButton).click();
	}

	@When("the User clicks on the Cart button")
	public void the_user_clicks_on_the_cart_button() {
	    cartPage = homePage.goToCartPage(); 
	}

	@Then("the User should see the game they added in their cart")
	public void the_user_should_see_the_game_they_added_in_their_cart() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
}
