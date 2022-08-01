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

public class EmailStepImpl {

	private static WebDriver driver = GameRunner.driver;
	private static UserInfoPage userInfoPage = GameRunner.userInfoPage;
	private static LoginPage loginPage = GameRunner.loginPage;
	private static HomePage homePage = GameRunner.homePage;
	
	@Given("User logs in with their {string} and {string}")
	public void user_logs_in_with_their_and(String username, String password) {
		driver.get("http://localhost:4200/login");
		loginPage.loginValidUser(username, password);
	   
	}

	@When("User clicks User Information")
	public void user_clicks_user_information() {
		new WebDriverWait(driver, Duration.ofSeconds(10))
		.until(ExpectedConditions.elementToBeClickable(homePage.getUserInfoLink()));
		
	    driver.findElement(By.xpath("/html/body/app-root/router-outlet/app-nav-bar/ul/li[7]/a")).click();
	    
	}

	@Then("{string} will be able to see the email address displayed in E-mail address field")
	public void will_be_able_to_see_the_email_address_displayed_in_e_mail_address_field(String username) {
	   WebElement emailfield = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id=\"userinfocard\"]/div/div[2]/span"))));
	    assertEquals("E-mail address: revsales@mail.com", emailfield.getText());
	    
		
	}
	
}
