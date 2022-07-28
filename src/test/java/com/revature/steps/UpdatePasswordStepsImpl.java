package com.revature.steps;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.revature.pages.HomePage;
import com.revature.pages.UserInfoPage;
import com.revature.runner.GameRunner;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UpdatePasswordStepsImpl {
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
	
	public void getUserInfoLink() {
		driver.findElement(homePage.getUserInfoLink()).click();
	}
	 private void geteditUserDetail() {
		 driver.findElement(userInfoPage.geteditUserDetail()).click();
	}

	
	@Given("the user is on the home_Page")
	public void the_user_is_on_the_home_page() {
		driver.get("http://localhost:4200");
		new WebDriverWait(driver, Duration.ofSeconds(3));
		loginForHomePage("username", "password");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}

	@When("the user clicks on User Information_Button")
	public void the_user_clicks_on_user_information_button() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		//driver.findElement(homePage.userInfoLink).click();
		getUserInfoLink();
	}

	@When("the user clicks on Edit_User_Details")
	public void the_user_clicks_on_edit_user_details() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    	//driver.findElement(userInfoPage.editUserDetail).click();
		geteditUserDetail();
	}

	@When("the user type in a valid <{string}> and confirm same password and clicks on Update password button")
	public void the_user_type_in_a_valid_and_confirm_same_password_and_clicks_on_update_password_button(String password) {
		 driver.manage().window().maximize();
		 JavascriptExecutor js = (JavascriptExecutor)driver; // To fix "Element Is Not Clickable at Point" error
		userInfoPage.EnterNewPassword.sendKeys(password); 
		userInfoPage.ConfirmNewPassword.sendKeys(password);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebElement button =driver.findElement(By.xpath("//*[@id=\"changepwdcard\"]/div/div[3]/button"));
		js.executeScript("arguments[0].click();", button);
	}

	@Then("the user seccussfully update the Password")
	public void the_user_seccussfully_update_the_password() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("http://localhost:4200/userInformation");
	}
	
	
	
// =============
	@Given("the user is on the homePage again")
	public void the_user_is_on_the_home_page_again() {
		driver.get("http://localhost:4200");
		new WebDriverWait(driver, Duration.ofSeconds(3));
		loginForHomePage("username", "password");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@When("the user type in a <{string}> and confirm diff <{string}> and clicks on Update password button")
	public void the_user_type_in_a_and_confirm_diff_and_clicks_on_update_password_button(String password, String confirmpassword) {
		// driver.manage().window().maximize();
		 JavascriptExecutor js = (JavascriptExecutor)driver; // To fix "Element Is Not Clickable at Point" error
		userInfoPage.EnterNewPassword.sendKeys(password); 
		userInfoPage.ConfirmNewPassword.sendKeys(confirmpassword);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		WebElement button =driver.findElement(By.xpath("//*[@id=\"changepwdcard\"]/div/div[3]/button"));
		
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(button));
		//button.click();
		js.executeScript("arguments[0].click();", button);
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(button));
	}

	@Then("the user get a Popup message")
	public void the_user_get_a_popup_message() {
//		new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.presenceOfElementLocated(userInfoPage.getErrorPasswordLink()));
//		String passwordErrorText = driver.findElement(userInfoPage.getErrorPasswordLink()).getText();
//		assertEquals(passwordErrorText, "Passwords do not match.");
		
//		new WebDriverWait(driver, Duration.ofSeconds(10));
//		WebElement usernameText = driver.findElement(By.xpath("//*[@id=\"changepwdcard\"]/div/label"));
//		assertEquals(usernameText, "Passwords do not match.");

		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#changepwdcard > div > label")));
		assertEquals("Passwords do not match.", 
		//driver.findElement(By.xpath("//*[@id=\\\"changepwdcard\\\"]/div/label")).getText());
        driver.findElement(By.cssSelector("#changepwdcard > div > label")).getText());
		
//		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfElementLocated(userInfoPage.getErrorPasswordLink()));
//		String labelText = driver.findElement(By.id("//*[@id=\"changepwdcard\"]/div/label")).getText();
//		assertEquals(labelText, "Passwords do not match.");
		
//		new WebDriverWait(driver, Duration.ofSeconds(3));
//		WebElement usernameText = driver.findElement(By.xpath("/html/body/app-root/app-user-information/div/div[3]/div/div/div/div/label"));
//		assertEquals(usernameText, "Passwords do not match.");
		
//		new WebDriverWait(driver, Duration.ofSeconds(3));
//		boolean errorIsThere = userInfoPage.findPasswordError().equals("Passwords do not match.");
//		assertTrue(errorIsThere);
		
     }
	
}
