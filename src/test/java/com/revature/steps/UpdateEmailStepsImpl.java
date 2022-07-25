package com.revature.steps;

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

public class UpdateEmailStepsImpl {
	
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
	
	@Given("the user is on the home Page")
	public void the_user_is_on_the_home_page() {
		driver.get("http://localhost:4200");
		new WebDriverWait(driver, Duration.ofSeconds(3));
		loginForHomePage("username", "password");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	  
	@When("the user clicks on User Information Button")
	    public void the_user_clicks_on_user_information_button() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(homePage.userInfoLink).click();
	}

    @When("the user clicks on Edit User Details")
     public void the_user_clicks_on_edit_user_details() {
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    	driver.findElement(userInfoPage.editUserDetail).click();
    }
    
    @When("the user enter the {string}> and clicks the Update E-mail button")
    public void the_user_enter_the_and_clicks_the_update_e_mail_button(String newEmail) {
		userInfoPage.EnterNewEmail.sendKeys(newEmail); 
		driver.findElement(userInfoPage.editUserEmail).click();
	}

    @Then("the user seccussfully update the Email")
    public void the_user_seccussfully_update_the_email() {
    	driver.get("http://localhost:4200/userInformation");
	}
}
