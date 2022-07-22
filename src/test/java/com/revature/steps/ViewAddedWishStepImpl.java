package com.revature.steps;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.revature.pages.HomePage;
import com.revature.pages.LoginPage;
import com.revature.pages.WishListPage;
import com.revature.runner.GameRunner;

import java.time.Duration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ViewAddedWishStepImpl 
{

	private WebDriver driver = GameRunner.driver;
	private WishListPage wishListPage = GameRunner.wishListPage;
	private LoginPage loginPage = GameRunner.loginPage;
	private HomePage homePage = GameRunner.homePage;
	
	public void loginForWishlist(String username, String password) {
		/*
		new WebDriverWait(driver, Duration.ofSeconds(10))
		.until(ExpectedConditions.elementToBeClickable(null));
		*/
		driver.get("http://localhost:4200");
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(homePage.getLoginLink()));
		
		driver.findElement(homePage.getLoginLink()).click();
		new WebDriverWait(driver, Duration.ofSeconds(3));
		driver.findElement(homePage.getuNameField()).sendKeys(username);
		new WebDriverWait(driver, Duration.ofSeconds(3));
		driver.findElement(homePage.getpKeyField()).sendKeys(password);
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(homePage.getLoginButton()));
		driver.findElement(homePage.getLoginButton()).click();
	}
	
	public void clickAdd()
	{
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(homePage.getaddWishlistButton()));
		driver.findElement(homePage.getaddWishlistButton()).click();
	}

	
	public String findGameName()
	{
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(driver.findElement(wishListPage.getGameNameBy())));
		
		return driver.findElement(wishListPage.getGameNameBy()).getText();
	}
	
	@Given("A user logs in through the Login Page")
	public void a_user_logs_in_through_the_login_page()
	{
		driver.get("http://localhost:4200");
		new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	@When("they type in a valid {string} and {string}")
	public void they_type_in_a_valid_and(String username, String Password)
	{
		new WebDriverWait(driver, Duration.ofSeconds(5));
		loginForWishlist(username, Password);
	}
	
	@When("they go to the Home Page they should be able to click add to wishlist on an item")
	public void they_go_to_the_home_page_they_should_be_able_to_click_add_to_wishlist_on_an_item()
	{
		new WebDriverWait(driver, Duration.ofSeconds(5));
		clickAdd();
	}
	
	@Then("view that item on the wishlist page")
	public void view_that_item_on_the_wishlist_page()
	{
		boolean truth = findGameName().equals("Evochron Mercenary");
		
		assertTrue(truth);
		//assertEquals(wishListPage.findGameName(), new String("Evochron Mercenary"));
	}
	
	
	
}
