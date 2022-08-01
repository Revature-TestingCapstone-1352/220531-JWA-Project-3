package com.revature.steps;

import static org.junit.Assert.assertEquals;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.revature.pages.HomePage;
import com.revature.pages.UserInfoPage;
import com.revature.runner.GameRunner;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LogoutStepsImpl {
	
	public static WebDriver driver = GameRunner.driver;
	public static HomePage homePage = GameRunner.homePage;
	public static UserInfoPage userInfoPage = GameRunner.userInfoPage;
	
	public void loginForHomePage(String username, String password) {
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(homePage.getLoginLink()));
		driver.findElement(homePage.getLoginLink()).click();
		new WebDriverWait(driver, Duration.ofSeconds(3));
		driver.findElement(homePage.getuNameField()).sendKeys(username);
		new WebDriverWait(driver, Duration.ofSeconds(3));
		driver.findElement(homePage.getpKeyField()).sendKeys(password);
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(homePage.getLoginButton()));
		driver.findElement(homePage.getLoginButton()).click();
	}
	
	public void getLogoutLink() {
		driver.findElement(homePage.getLogoutLink()).click();
	}
	
	public void getUserInfoLink() {
		driver.findElement(homePage.getUserInfoLink()).click();
	}
	
	@Given("LoggedIn User is on the Home Page")
	public void logged_in_user_is_on_the_home_page() {
		driver.get("http://localhost:4200");
		loginForHomePage("username", "password");
	}

	@When("The User clicks on LogoutButton")
		public void the_user_clicks_on_logout_button() {
		
		
		new WebDriverWait(driver, Duration.ofSeconds(10))
		.until(ExpectedConditions.elementToBeClickable(homePage.getLoginLink()));
		getLogoutLink();
	}
	
	@Then("Logout seccussful")
	public void logout_seccussful() {
		
	new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(userInfoPage.getLogoutSeccussLink()));
		String logoutSeccussText = driver.findElement(userInfoPage.getLogoutSeccussLink()).getText();
		assertEquals(logoutSeccussText, "Logout was successful.");
	}
}
