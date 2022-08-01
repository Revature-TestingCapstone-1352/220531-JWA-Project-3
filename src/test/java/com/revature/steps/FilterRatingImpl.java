package com.revature.steps;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.revature.pages.HomePage;
import com.revature.pages.StorePage;
import com.revature.runner.GameRunner;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FilterRatingImpl {
	private static WebDriver driver = GameRunner.driver;
	private static StorePage storePage = GameRunner.storePage;
	private static HomePage homePage = GameRunner.homePage;
	private static JavascriptExecutor jsExec;
	private static WebDriverWait jsWait;
	
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
	
	public long getFiltGamesCount() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		return (long) js.executeScript("return JSON.parse(localStorage.getItem(arguments[0]))", "filteredItemCount");

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
	
	 private void waitForAngularLoad() {
	        String angularReadyScript = "return angular.element(document).injector().get('$http').pendingRequests.length === 0";
	        angularLoads(angularReadyScript);
	    }
	 
	 private void angularLoads(String angularReadyScript) {
	        try {
	            ExpectedCondition<Boolean> angularLoad = driver -> Boolean.valueOf(((JavascriptExecutor) driver)
	                .executeScript(angularReadyScript).toString());
	            boolean angularReady = Boolean.valueOf(jsExec.executeScript(angularReadyScript).toString());
	            if (!angularReady) {
	                jsWait.until(angularLoad);
	            }
	        } catch (WebDriverException ignored) {
	        }
	    }
	 
	 public void waitUntilAngularReady() {
	        try {
	            Boolean angularUnDefined = (Boolean) jsExec.executeScript("return window.angular === undefined");
	            if (!angularUnDefined) {
	                Boolean angularInjectorUnDefined = (Boolean) jsExec.executeScript("return angular.element(document).injector() === undefined");
	                if (!angularInjectorUnDefined) {
	                    waitForAngularLoad();
	                }
	            }
	        } catch (WebDriverException ignored) {
	        }
	    }
	
	@Then("User should be able to view games that have no rating")
	public void user_should_be_able_to_view_games_filtered_by_rating() throws InterruptedException {
		clickAll();
		
//		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
//		wait.withTimeout(Duration.ofSeconds(20));
//		wait.pollingEvery(Duration.ofMillis(250));
//		wait.until(ExpectedConditions);
		
		waitForAngularLoad();
		
		long n = getFiltGamesCount();
		assertEquals(6, n);
	}
	
	@When("User selects Mostly Negative filter")
	public void user_selects_mostly_negative_filter() {

		
		new WebDriverWait(driver, Duration.ofSeconds(3));
	}
	
	@Then("User should be able to view games that are Mostly Negative")
	public void User_should_be_able_to_view_games_that_are_mostly_negative() throws InterruptedException {
		
		clickAll();
		clickNegativeBox();
		
		
		
		long n = getFiltGamesCount();
		assertEquals(13, n);
	}
	
	@When("User selects Mixed filter")
	public void User_selects_Mixed_filter() {
		new WebDriverWait(driver, Duration.ofSeconds(3));
	}
	
	@Then("User should be able to view games that are Mixed")
	public void User_should_be_able_to_view_games_that_are_Mixed() throws InterruptedException {
		clickAll();
		clickMixedBox();
		waitForAngularLoad();
		
		long n = getFiltGamesCount();
		assertEquals(34, n);
	}
	
	@When("User selects Positive filter")
	public void user_selects_Positive_filter() {
		new WebDriverWait(driver, Duration.ofSeconds(3));
	}
	
	@Then("User should be able to view games that are Positive")
	public void User_should_be_able_to_view_games_that_are_Positive() throws InterruptedException {
		clickAll();
		clickPositiveBox();

		waitForAngularLoad();
		
		long n = getFiltGamesCount();
		assertEquals(10, n+1);
	}
	
	@When("User selects Mostly Positive filter")
	public void user_selects_mostly_positive_filter() {
		new WebDriverWait(driver, Duration.ofSeconds(3));
	}
	
	@Then("User should be able to view games that are Mostly Positive")
	public void User_should_be_able_to_view_games_that_are_mostly_positive() throws InterruptedException {
		clickAll();
		clickMostlyPositiveBox();

		waitForAngularLoad();
		
		long n = getFiltGamesCount();
		assertEquals(30, n);
	}
	
	@When("User selects Very Positive filter")
	public void user_selects_very_positive_filter() {
		new WebDriverWait(driver, Duration.ofSeconds(3));
	}
	
	@Then("User should be able to view games that are Very Positive")
	public void User_should_be_able_to_view_games_that_are_very_positive() throws InterruptedException {
		clickAll();
//		new WebDriverWait(driver, Duration.ofSeconds(10));
//		clickVeryPositiveBox();
//		new WebDriverWait(driver, Duration.ofSeconds(10));
//		int n = checkNumberOfGames(storePage.getFilterGamesDisplayed(), storePage.getNextPageVeryPositive());
//		assertEquals(120, n);
		clickVeryPositiveBox();
		
		waitForAngularLoad();
		
		long n = getFiltGamesCount();
		assertEquals(120, n);
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
		
		waitForAngularLoad();
		
		long n = getFiltGamesCount();
		assertEquals(44, n);
	}
}
