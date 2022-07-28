package com.revature.steps;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

import com.revature.pages.HomePage;
import com.revature.runner.GameRunner;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProductDisplaySteps {
	public static WebDriver driver = GameRunner.driver;
	public static HomePage homePage = GameRunner.homePage;
	
	@Given("a User is on the Store Page")
	public void a_user_is_on_the_store_page() {

		driver.get("http://localhost:4200");
		new WebDriverWait(driver, Duration.ofSeconds(3));
//<<<<<<< HEAD
//		loginForHomePage("joshua_test", "test_joshua");
//
//=======
	}

	@When("the games are displayed")
	public void the_games_are_displayed() {

		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfElementLocated(homePage.getGamesDisplayed()));
	    WebElement isDisplayedPre = driver.findElement(homePage.getGamesDisplayed());
	    boolean isDisplayed = isDisplayedPre.isDisplayed();
		assertEquals(isDisplayed, true);

	}

	@Then("there should be a maximum of twenty-four games displayed per page")
	public void maximum_of_twentyfour_games() {

		List<WebElement> twentyFour = driver.findElement(homePage.getGamesDisplayed()).findElements(By.xpath("./child::*"));
		//removing pagination child element from list
		twentyFour.remove(twentyFour.size() - 1);
		assertThat(twentyFour.size() <= 24);
	}

	@Given("the User is on the Store Page again")
	public void a_user_is_on_the_store_page_again() {
	    driver.get("http://localhost:4200");
	    new WebDriverWait(driver, Duration.ofSeconds(3));
	}

	@When("when the User clicks on the Metacritic link of a game")
	public void when_the_user_clicks_on_the_metacritic_link_of_a_game() {
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(homePage.getMetatcriticLink()));
		driver.findElement(homePage.getMetatcriticLink()).click();
	}

	@Then("there is a valid Metacritic review displayed")
	public void there_is_a_valid_metacritic_review_displayed() {
		Set<String> handles = driver.getWindowHandles();
		String origin = driver.getWindowHandle();
		Iterator<String> iter = handles.iterator();
		while (iter.hasNext()) {
			String newWindow = iter.next();
			if (!origin.equalsIgnoreCase(newWindow)) {
				driver.switchTo().window(newWindow);
			}
		}
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.titleIs("Evochron Mercenary for PC Reviews - Metacritic"));
		assertEquals(driver.getTitle(), "Evochron Mercenary for PC Reviews - Metacritic");
		driver.switchTo().window(origin);
	}
}
