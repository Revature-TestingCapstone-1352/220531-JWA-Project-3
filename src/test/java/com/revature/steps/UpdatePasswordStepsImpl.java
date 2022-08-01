package com.revature.steps;

import static org.junit.Assert.assertEquals;

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
	 public void getLogoutLink() {
			driver.findElement(homePage.getLogoutLink()).click();
		}
	
	@Given("the user is on the home_Page")
	public void the_user_is_on_the_home_page() {
		driver.get("http://localhost:4200");
		new WebDriverWait(driver, Duration.ofSeconds(3));
		loginForHomePage("username", "password");
		new WebDriverWait(driver, Duration.ofSeconds(8)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"games\"]")));

	}

	@When("the user clicks on User Information_Button")
	public void the_user_clicks_on_user_information_button() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		getUserInfoLink();
	}

	@When("the user clicks on Edit_User_Details")
	public void the_user_clicks_on_edit_user_details() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		geteditUserDetail();
	}

	@When("the user type in a valid <{string}> and confirm same password and clicks on Update password button")
	public void the_user_type_in_a_valid_and_confirm_same_password_and_clicks_on_update_password_button(String password) {
		 driver.manage().window().maximize();
		 JavascriptExecutor js = (JavascriptExecutor)driver; // To fix "Element Is Not Clickable at Point" error
//		userInfoPage.EnterNewPassword.sendKeys(password); 
//		userInfoPage.ConfirmNewPassword.sendKeys(password);
		 userInfoPage.enterNewPassword(password);
	        userInfoPage.enterConfirmPass(password);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebElement button =driver.findElement(By.xpath("//*[@id=\"changepwdcard\"]/div/div[3]/button"));
		js.executeScript("arguments[0].click();", button);
	}

	@Then("the user seccussfully update the Password")
	public void the_user_seccussfully_update_the_password() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		JavascriptExecutor js = (JavascriptExecutor)driver; 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebElement button =driver.findElement(By.xpath("/html/body/app-root/router-outlet/app-nav-bar/ul/li[8]/a"));//logout
		js.executeScript("arguments[0].click();", button);
		new WebDriverWait(driver, Duration.ofSeconds(8));
		loginForHomePage("username", "password");// login using the new password
		new WebDriverWait(driver, Duration.ofSeconds(8)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"games\"]")));
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-root/router-outlet/app-nav-bar/ul/li[8]/a")));
		assertEquals("Logout username", 
        driver.findElement(By.xpath("/html/body/app-root/router-outlet/app-nav-bar/ul/li[8]/a")).getText());
	}
	
	
	@Given("the user is on the homePage again")
	public void the_user_is_on_the_home_page_again() {
		driver.get("http://localhost:4200");
		new WebDriverWait(driver, Duration.ofSeconds(3));
		loginForHomePage("username", "password");
		new WebDriverWait(driver, Duration.ofSeconds(8)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"games\"]")));
	}

	@When("the user type in a <{string}> and confirm diff <{string}> and clicks on Update password button")
	public void the_user_type_in_a_and_confirm_diff_and_clicks_on_update_password_button(String password, String confirmpassword) {
        JavascriptExecutor js = (JavascriptExecutor)driver; // To fix "Element Is Not Clickable at Point" error
//		userInfoPage.EnterNewPassword.sendKeys(password); 
//		userInfoPage.ConfirmNewPassword.sendKeys(confirmpassword);
        userInfoPage.enterNewPassword(password);
        userInfoPage.enterConfirmPass(confirmpassword);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		WebElement button =driver.findElement(By.xpath("//*[@id=\"changepwdcard\"]/div/div[3]/button"));
		
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(button));
		js.executeScript("arguments[0].click();", button);
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(button));
	}

	@Then("the user get a Popup message")
	public void the_user_get_a_popup_message() {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#changepwdcard > div > label")));
		assertEquals("Passwords do not match.", 
        driver.findElement(By.cssSelector("#changepwdcard > div > label")).getText());
	}
	
}
