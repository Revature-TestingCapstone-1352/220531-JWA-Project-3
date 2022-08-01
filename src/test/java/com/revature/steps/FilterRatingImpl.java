package com.revature.steps;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.revature.pages.HomePage;
import com.revature.pages.StorePage;
import com.revature.runner.GameRunner;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class FilterRatingImpl {
	private static WebDriver driver = GameRunner.driver;
	private static StorePage storePage = GameRunner.storePage;
	private static HomePage homePage = GameRunner.homePage;
	
	public void clickAll() throws InterruptedException {
		
		driver.navigate().refresh();
		driver.findElement(storePage.getNegativeBox()).click();
		driver.findElement(storePage.getMixedBox()).click();
		driver.findElement(storePage.getPositiveBox()).click();
		driver.findElement(storePage.getMostlyPositiveBox()).click();
		driver.findElement(storePage.getVeryPositiveBox()).click();
		driver.findElement(storePage.getOverwhelminglyPositiveBox()).click();
		
	}
	
	public int checkNumberOfGames(By whichFilter, By whichNextPage) {
		int count = 0;
		
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(whichFilter));
		List<WebElement> initialGames = driver.findElement(whichFilter).findElements(By.xpath("./child::*"));
		new WebDriverWait(driver, Duration.ofSeconds(10));
		initialGames.remove(initialGames.size() - 1);
		count += initialGames.size();
		try {
			if (driver.findElement(storePage.getNextPageSpan()).getAttribute("class").equals("pagination-next disabled")) {
				return count;
			}
		} catch (NoSuchElementException e) {
			return count;
		}
		try {
			while (driver.findElement(whichNextPage).isEnabled()) {
				new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(whichFilter));
				new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(whichNextPage));
				new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(whichNextPage));
				driver.findElement(whichNextPage).click();
				new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(whichFilter));
				new WebDriverWait(driver, Duration.ofSeconds(5));
				List<WebElement> numberOfGames = driver.findElement(whichFilter).findElements(By.xpath("./child::*"));
				new WebDriverWait(driver, Duration.ofSeconds(5));
				numberOfGames.remove(numberOfGames.size() - 1);
				count += numberOfGames.size();
			}
		} catch (NoSuchElementException e) {
			return count;
		}
		return count;
	}
	
	public int clickForUnrated() {
		new WebDriverWait(driver, Duration.ofSeconds(5));
		int n = checkNumberOfGames(storePage.getFilterGamesDisplayed(), storePage.getNextPageMixed());
		return n;
	}
	
	public void clickNegativeBox() {
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(storePage.getNegativeBox()));
		driver.findElement(storePage.getNegativeBox()).click();
		new WebDriverWait(driver, Duration.ofSeconds(5));
	}
	
	public void clickMixedBox() {
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(storePage.getMixedBox()));
		driver.findElement(storePage.getMixedBox()).click();
		new WebDriverWait(driver, Duration.ofSeconds(5));
	}
	
	public void clickPositiveBox() {
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(storePage.getPositiveBox()));
		driver.findElement(storePage.getPositiveBox()).click();
		new WebDriverWait(driver, Duration.ofSeconds(5));
	}
	
	public void clickMostlyPositiveBox() {
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(storePage.getMostlyPositiveBox()));
		driver.findElement(storePage.getMostlyPositiveBox()).click();
		new WebDriverWait(driver, Duration.ofSeconds(5));
	}
	
	public void clickVeryPositiveBox() {
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(storePage.getVeryPositiveBox()));
		driver.findElement(storePage.getVeryPositiveBox()).click();
		new WebDriverWait(driver, Duration.ofSeconds(5));
	}
	
	public void clickOverwhelminglyPositiveBox() {
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(storePage.getOverwhelminglyPositiveBox()));
		driver.findElement(storePage.getOverwhelminglyPositiveBox()).click();
		new WebDriverWait(driver, Duration.ofSeconds(5));
	}
	
	@Given("User is on the HomePage")
	public void user_is_on_the_home_page() {
		driver.get("http://localhost:4200");
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfElementLocated(homePage.getLoginLink()));
		new WebDriverWait(driver, Duration.ofSeconds(5));
	}
	
	@When("User ensures each rating is clicked")
	public void user_clicks_each_rating() {
		new WebDriverWait(driver, Duration.ofSeconds(3));
	}
	
	@Then("User should be able to view games that have no rating")
	public void user_should_be_able_to_view_games_filtered_by_rating() throws InterruptedException {
		clickAll();
		Thread.sleep(2000);
		new WebDriverWait(driver, Duration.ofSeconds(10));
		int n = clickForUnrated();
		assertEquals(6, n);
	}
	
	@When("User selects Mostly Negative filter")
	public void user_selects_mostly_negative_filter() {
		new WebDriverWait(driver, Duration.ofSeconds(3));
	}
	
	@Then("User should be able to view games that are Mostly Negative")
	public void User_should_be_able_to_view_games_that_are_mostly_negative() throws InterruptedException {
		clickAll();
		Thread.sleep(2000);
		new WebDriverWait(driver, Duration.ofSeconds(10));
		clickNegativeBox();
		Thread.sleep(2000);
		new WebDriverWait(driver, Duration.ofSeconds(10));
		int n = checkNumberOfGames(storePage.getFilterGamesDisplayed(), storePage.getNextPageMixed());
		assertEquals(13, n);
	}
	
	@When("User selects Mixed filter")
	public void User_selects_Mixed_filter() {
		new WebDriverWait(driver, Duration.ofSeconds(3));
	}
	
	@Then("User should be able to view games that are Mixed")
	public void User_should_be_able_to_view_games_that_are_Mixed() throws InterruptedException {
		clickAll();
		Thread.sleep(2000);
		new WebDriverWait(driver, Duration.ofSeconds(10));
		clickMixedBox();
		Thread.sleep(2000);
		new WebDriverWait(driver, Duration.ofSeconds(10));
		int n = checkNumberOfGames(storePage.getFilterGamesDisplayed(), storePage.getNextPageMixed());
		assertEquals(34, n);
	}
	
	@When("User selects Positive filter")
	public void user_selects_Positive_filter() {
		new WebDriverWait(driver, Duration.ofSeconds(3));
	}
	
	@Then("User should be able to view games that are Positive")
	public void User_should_be_able_to_view_games_that_are_Positive() throws InterruptedException {
		clickAll();
		Thread.sleep(2000);
		new WebDriverWait(driver, Duration.ofSeconds(10));
		clickPositiveBox();
		Thread.sleep(2000);
		new WebDriverWait(driver, Duration.ofSeconds(10));
		int n = checkNumberOfGames(storePage.getFilterGamesDisplayed(), storePage.getNextPageMixed());
		assertEquals(10, n);
	}
	
	@When("User selects Mostly Positive filter")
	public void user_selects_mostly_positive_filter() {
		new WebDriverWait(driver, Duration.ofSeconds(3));
	}
	
	@Then("User should be able to view games that are Mostly Positive")
	public void User_should_be_able_to_view_games_that_are_mostly_positive() throws InterruptedException {
		clickAll();
		Thread.sleep(2000);
		new WebDriverWait(driver, Duration.ofSeconds(10));
		clickMostlyPositiveBox();
		Thread.sleep(2000);
		new WebDriverWait(driver, Duration.ofSeconds(10));
		int n = checkNumberOfGames(storePage.getFilterGamesDisplayed(), storePage.chopperCard);
		assertEquals(30, n);
	}
	
	@When("User selects Very Positive filter")
	public void user_selects_very_positive_filter() {
		new WebDriverWait(driver, Duration.ofSeconds(3));
	}
	
	@Then("User should be able to view games that are Very Positive")
	public void User_should_be_able_to_view_games_that_are_very_positive() throws InterruptedException {
		clickAll();
		clickVeryPositiveBox();
		
		new WebDriverWait(driver, Duration.ofSeconds(15))
		.until(ExpectedConditions.visibilityOfElementLocated(storePage.chopperCard));
		WebElement card = driver.findElement(storePage.chopperCard);
		
		assertTrue(card.isDisplayed());
	}
	
	@When("User selects Overwhelmingly Positive filter")
	public void user_selects_overwhelmingly_positive_filter() {
		new WebDriverWait(driver, Duration.ofSeconds(3));
	}
	
	@Then("User should be able to view games that are Overwhelmingly Positive")
	public void User_should_be_able_to_view_games_that_are_overwhelmingly_positive() throws InterruptedException {
		clickAll();
		clickOverwhelminglyPositiveBox();
		
//		Thread.sleep(2000);
//		new WebDriverWait(driver, Duration.ofSeconds(10));
//		int n = checkNumberOfGames(storePage.getFilterGamesDisplayed(), storePage.getNextPageOverPositive());
//		assertEquals(44, n);
		
		new WebDriverWait(driver, Duration.ofSeconds(15))
		.until(ExpectedConditions.visibilityOfElementLocated(storePage.sRowCard));
		WebElement card = driver.findElement(storePage.sRowCard);
		
		assertTrue(card.isDisplayed());
	}
}
