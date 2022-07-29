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
	
	public void clickAll() {
		driver.navigate().refresh();
		new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.findElement(storePage.getNegativeBox()).click();
		new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.findElement(storePage.getMixedBox()).click();
		new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.findElement(storePage.getPositiveBox()).click();
		new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.findElement(storePage.getMostlyPositiveBox()).click();
		new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.findElement(storePage.getVeryPositiveBox()).click();
		new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.findElement(storePage.getOverwhelminglyPositiveBox()).click();
		new WebDriverWait(driver, Duration.ofSeconds(10));
		
	}
	
	public int checkNumberOfGames(By whichFilter) {
		int count = 0;
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(whichFilter));
		List<WebElement> initialGames = driver.findElement(whichFilter).findElements(By.xpath("./child::*"));
		new WebDriverWait(driver, Duration.ofSeconds(10));
		initialGames.remove(initialGames.size() - 1);
		count += initialGames.size();
		//new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(storePage.getNextPageSpan()));
		//new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(storePage.getNextPage()));
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(storePage.getNextPage()));
		try {
			while (driver.findElement(storePage.getNextPage()).isEnabled()) {
				new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(whichFilter));
				new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(storePage.getNextPage()));
				new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(storePage.getNextPage()));
				driver.findElement(storePage.getNextPage()).click();
				new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(whichFilter));
				new WebDriverWait(driver, Duration.ofSeconds(5));
				List<WebElement> numberOfGames = driver.findElement(whichFilter).findElements(By.xpath("./child::*"));
				new WebDriverWait(driver, Duration.ofSeconds(5));
				numberOfGames.remove(numberOfGames.size() - 1);
				count += numberOfGames.size();
				if (driver.findElement(storePage.getNextPageSpan()).getAttribute("class").equals("pagination-next disabled")) {
					break;
				}
			}
		} catch (NoSuchElementException e) {
			return count;
		}
		return count;
	}
	
	public int clickForUnrated() {
		new WebDriverWait(driver, Duration.ofSeconds(5));
		int n = checkNumberOfGames(storePage.getUnrated());
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
		driver.manage().window().maximize();
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfElementLocated(homePage.getLoginLink()));
		new WebDriverWait(driver, Duration.ofSeconds(5));
	}
	
	@When("User ensures each rating is clicked")
	public void user_clicks_each_rating() {
		new WebDriverWait(driver, Duration.ofSeconds(3));
	}
	
	@Then("User should be able to view games that have no rating")
	public void user_should_be_able_to_view_games_filtered_by_rating() {
		clickAll();
		int n = clickForUnrated();
		assertEquals(6, n);
	}
	
	@When("User selects Mostly Negative filter")
	public void user_selects_mostly_negative_filter() {
		new WebDriverWait(driver, Duration.ofSeconds(3));
	}
	
	@Then("User should be able to view games that are Mostly Negative")
	public void User_should_be_able_to_view_games_that_are_mostly_negative() {
		clickAll();
		clickNegativeBox();
		int n = checkNumberOfGames(storePage.getMostlyNegative());
		assertEquals(13, n);
	}
	
	@When("User selects Mixed filter")
	public void User_selects_Mixed_filter() {
		new WebDriverWait(driver, Duration.ofSeconds(3));
	}
	
	@Then("User should be able to view games that are Mixed")
	public void User_should_be_able_to_view_games_that_are_Mixed() {
		clickAll();
		clickMixedBox();
		int n = checkNumberOfGames(storePage.getMixed());
		assertEquals(34, n);
	}
	
	@When("User selects Positive filter")
	public void user_selects_Positive_filter() {
		new WebDriverWait(driver, Duration.ofSeconds(3));
	}
	
	@Then("User should be able to view games that are Positive")
	public void User_should_be_able_to_view_games_that_are_Positive() {
		clickAll();
		clickPositiveBox();
		int n = checkNumberOfGames(storePage.getPositive());
		assertEquals(10, n);
	}
	
	@When("User selects Mostly Positive filter")
	public void user_selects_mostly_positive_filter() {
		new WebDriverWait(driver, Duration.ofSeconds(3));
	}
	
	@Then("User should be able to view games that are Mostly Positive")
	public void User_should_be_able_to_view_games_that_are_mostly_positive() {
		clickAll();
		clickMostlyPositiveBox();
		int n = checkNumberOfGames(storePage.getMostlyPositive());
		assertEquals(30, n);
	}
	
	@When("User selects Very Positive filter")
	public void user_selects_very_positive_filter() {
		new WebDriverWait(driver, Duration.ofSeconds(3));
	}
	
	@Then("User should be able to view games that are Very Positive")
	public void User_should_be_able_to_view_games_that_are_very_positive() {
		clickAll();
		clickVeryPositiveBox();
		int n = checkNumberOfGames(storePage.getVeryPositive());
		assertEquals(120, n);
	}
	
	@When("User selects Overwhelmingly Positive filter")
	public void user_selects_overwhelmingly_positive_filter() {
		new WebDriverWait(driver, Duration.ofSeconds(3));
	}
	
	@Then("User should be able to view games that are Overwhelmingly Positive")
	public void User_should_be_able_to_view_games_that_are_overwhelmingly_positive() {
		clickAll();
		clickOverwhelminglyPositiveBox();
		int n = checkNumberOfGames(storePage.getOverwhelminglyPositive());
		assertEquals(44, n);
	}
}
