package com.revature.steps;

import static org.junit.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.revature.pages.HomePage;
import com.revature.pages.UserInfoPage;
import com.revature.runner.GameRunner;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ViewUsernameStepImpl {
	// add in the driver
	private WebDriver driver = GameRunner.driver;
	private HomePage homePage = GameRunner.homePage;
	private UserInfoPage userInfoPage = GameRunner.userInfoPage;

	@Given("user is logged in")
	public void user_is_logged_in() {
		homePage
	}

	@Given("user is on the home page")
	public void user_is_on_the_home_page() {
		driver.get("http://localhost:4200");
	}

	@When("user clicks User Information page")
	public void user_clicks_user_information_page() {
		new WebDriverWait(driver, Duration.ofSeconds(3));
		WebElement userInfoLink = driver
				.findElement(By.xpath("/html/body/app-root/router-outlet/app-nav-bar/ul/li[7]/a"));
		userInfoLink.click();
	}

	@Then("user can see their own Username on the User Information page")
	public void user_can_see_their_own_username_on_the_user_information_page() {
		new WebDriverWait(driver, Duration.ofSeconds(3));
		WebElement usernameText = driver.findElement(By.xpath("//*[@id=\"userinfocard\"]/div/div[1]/span"));
		assertEquals(usernameText, "Logged in user: TestUser");
	}
}
