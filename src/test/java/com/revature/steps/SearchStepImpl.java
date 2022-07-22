package com.revature.steps;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.revature.pages.HomePage;
import com.revature.runner.GameRunner;

import io.cucumber.java.en.*;

public class SearchStepImpl {

	public static WebDriver driver = GameRunner.driver;
	public static HomePage homePage = GameRunner.homePage;

	@Given("The user is on the homepage")
	public void the_user_is_on_the_homepage() {


		driver.get("http://localhost:4200/");
		new WebDriverWait(driver, Duration.ofSeconds(3));

	}

	@When("I search for {string}")
	public void i_search_for(String string) {
		HomePage homePage = new HomePage(driver);
		string = "Dawn of";

		driver.findElement(homePage.getSearchBar()).sendKeys(string);


		//	   new WebDriverWait(driver, Duration.ofSeconds(3));
	}

	@Then("The first game should be {string}")
	public void the_first_game_should_be(String string) {
		String item = driver.findElement(By
				.xpath("/html/body/app-root/app-store/div/div/div[2]/div/div[1]/div/div[2]")).getText(); 

		string = "Warhammer 40,000: Dawn of War II: Retribution";

		assertEquals(string,item);
	}

}
