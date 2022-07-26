package com.revature.steps;

import static org.junit.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.revature.pages.HomePage;
import com.revature.pages.LoginPage;
import com.revature.pages.RegisterPage;
import com.revature.runner.GameRunner;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RegisterSteps 
{
	private WebDriver driver = GameRunner.driver;
	private RegisterPage registerPage = GameRunner.registerPage;
	private LoginPage loginPage = GameRunner.loginPage;
	private HomePage homePage = GameRunner.homePage;

	
	public void enterInformation(String username, String password, String email)
	{
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(registerPage.getUserName()));
		driver.findElement(registerPage.getUserName()).sendKeys(username);
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(registerPage.getPassword()));
		driver.findElement(registerPage.getPassword()).sendKeys(password);
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(registerPage.getEmail()));
		driver.findElement(registerPage.getEmail()).sendKeys(email);
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(registerPage.getRegisterButton()));
		driver.findElement(registerPage.getRegisterButton()).click();
	}
	
	public void clickRegister()
	{
//		driver.get("http://localhost:4200");
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(homePage.getRegisterLink()));
		driver.findElement(homePage.getRegisterLink()).click();
	}
	
	@Given("A guest is on the home page")
	public void a_guest_is_on_the_home_page()
	{
		driver.get("http://localhost:4200");
		new WebDriverWait(driver, Duration.ofSeconds(3));
		registerPage.clickRegister();
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(registerPage.getRegisterButton()));
	}
	
	@When("a guest enters a {string} and {string} and {string}")
	public void a_guest_enters_a_and_and(String username, String password, String email)
	{
		new WebDriverWait(driver, Duration.ofSeconds(5));
		registerPage.enterInformation(username, password, email);
	}
	
	@Then("a guest can register by pressing the register button and be on the Homepage")
	public void a_guest_can_register_by_pressing_the_register_button_and_be_on_the_homepage()
	{
		new WebDriverWait(driver, Duration.ofSeconds(5));
		
		WebElement userInput = driver.findElement(loginPage.getUsernameBy());
		
		boolean isSearchBar = userInput.isDisplayed();
		
		assertEquals(isSearchBar,true);
	}

}
