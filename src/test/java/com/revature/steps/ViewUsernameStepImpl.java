package com.revature.steps;

import static org.junit.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.revature.pages.HomePage;
import com.revature.pages.LoginPage;
import com.revature.pages.UserInfoPage;
import com.revature.runner.GameRunner;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ViewUsernameStepImpl {
	// add in the driver
	private WebDriver driver = GameRunner.driver;
	private HomePage homePage = GameRunner.homePage;
	private LoginPage loginPage = GameRunner.loginPage;

	@Given("user is logged in")
	public void user_is_logged_in() {
		driver.get("http://localhost:4200");
		homePage.navigateToLoginPage();
		loginPage.loginValidUser("TestUser", "TestPass");
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
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/app-root/app-user-information/div/div/div/div/div/div/div[1]/span")));
		WebElement usernameText = driver.findElement(By.xpath("/html/body/app-root/app-user-information/div/div/div/div/div/div/div[1]/span"));
		String text = usernameText.getText();
		assertEquals(text, "Logged in user: TestUser");
	}
}
