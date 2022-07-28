package com.revature.steps;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.revature.pages.HomePage;
import com.revature.pages.LoginPage;
import com.revature.pages.WishListPage;
import com.revature.runner.GameRunner;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RemoveFromWishStepImpl 
{
	private WebDriver driver = GameRunner.driver;
	private WishListPage wishListPage = GameRunner.wishListPage;
	private LoginPage loginPage = GameRunner.loginPage;
	private HomePage homePage = GameRunner.homePage;
	
	@Given("A customer logs in through the Login Page")
	public void a_customer_logs_in_through_the_login_page()
	{
		driver.get("http://localhost:4200");
		new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	@When("the user types in a valid {string} and {string}")
	public void the_user_types_in_a_valid_and(String username, String Password)
	{
		new WebDriverWait(driver, Duration.ofSeconds(5));
		homePage.navigateToLoginPage();
		loginPage.loginValidUser(username, Password);
	}
	
	@When("a customer should be able to go to the Home Page and be able to click add to wishlist on an item")
	public void a_customer_should_be_able_to_go_to_the_home_page_and_be_able_to_click_add_to_wishlist_on_an_item()
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		homePage.clickAdd();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		homePage.navigateToWishList();
	}
	
	@When("a customer should be able to remove the wishlist item by pressing the remove from wishlist button")
	public void a_customer_should_be_able_to_remove_the_wishlist_item_by_pressing_the_remove_from_wishlist_button()
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		wishListPage.clickRemoveButton();
	}
	
	@Then("be unable to see the wishlist item on the wishlist page")
	public void be_unable_to_see_the_wishlist_item_on_the_wishlist_page()
	{
		new WebDriverWait(driver, Duration.ofSeconds(20));
		
		
		boolean notThere = wishListPage.findWishListNotPresent().equals("Try to add game to the wishlist or login to see your wishlist!");
		
		assertTrue(notThere);
		
//		boolean isDisplayed;
		
//		try 
//		{
//			isDisplayed = driver.findElement(wishListPage.getRemoveButton()).isDisplayed();
//		} catch(Exception e) 
//		{
//			isDisplayed = false;
//		}
		
//		assertEquals(isDisplayed,false);
	}

}
