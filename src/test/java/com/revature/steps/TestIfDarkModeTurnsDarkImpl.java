package com.revature.steps;

import com.revature.pages.HomePage;
import com.revature.runner.GameRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestIfDarkModeTurnsDarkImpl {
    public static final WebDriver driver = GameRunner.driver;
    public static final HomePage homePage = new HomePage(driver);

    @Given("that a user is on the HomePage")
    public void that_a_user_is_on_the_HomePage() {
        driver.get("http://localhost:4200");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
    }

    @When("the User clicks the darkLightButton")
    public void the_User_clicks_the_darkLightButton() {
        homePage.clickDarkModeButton();
    }

    @Then("the HomePage background color will change to dark")
    public void the_HomePage_background_color_will_change_to_dark() {
        assertEquals("dark-theme", homePage.checkBackGroundColor());
    }

    @Given("that a user is on the HomePage and background is dark")
    public void that_a_user_is_on_the_HomePage_and_background_is_dark() {
        driver.get("http://localhost:4200");
        homePage.clickDarkModeButton();
    }

    @When("the User clicks the darkLightButton again")
    public void the_User_clicks_the_darkLightButton_again() {
        homePage.clickDarkModeButton();
    }

    @Then("the HomePage background color will change to light")
    public void the_HomePage_background_color_will_change_to_light() {
        assertEquals("", homePage.checkBackGroundColor());
    }
}
