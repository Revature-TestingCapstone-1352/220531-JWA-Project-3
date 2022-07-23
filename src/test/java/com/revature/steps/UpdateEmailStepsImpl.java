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
	
//	public void editUserEmailPage(String newEmail) {
//		new WebDriverWait(driver, Duration.ofSeconds(3));
//		driver.findElement(userInfoPage.getEmailField()).sendKeys(newEmail);
//		new WebDriverWait(driver, Duration.ofSeconds(10))
//		.until(ExpectedConditions.elementToBeClickable(userInfoPage.getLoginButton()));
//		driver.findElement(userInfoPage.getLoginButton()).click();
//	}
	
	
	
	
	@Given("the user is on the UserInformation Page")
	public void the_user_is_on_the_user_information_page() {
		driver.get("http://localhost:4200/userInformation");
//		new WebDriverWait(driver, Duration.ofSeconds(3));
//		loginForHomePage("username", "password");
	}


    @When("the user clicks on Edit User Details")
     public void the_user_clicks_on_edit_user_details() {
     userInfoPage.editUserDetailButton.click();
    }

    @When("the user enter the {string}> and clicks the Update E-mail button")
    public void the_user_enter_the_and_clicks_the_update_e_mail_button(String email) {
		userInfoPage.EnterNewEmail.sendKeys(email);    
	}

    @Then("the user seccussfully update the Email")
    public void the_user_seccussfully_update_the_email() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

}
