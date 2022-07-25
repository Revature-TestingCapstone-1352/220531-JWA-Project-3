package com.revature.steps;

import com.revature.pages.HomePage;
import com.revature.runner.GameRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClickToSeeMoreGamesImpl {
    public static final WebDriver driver = GameRunner.driver;
    public static final HomePage homePage = new HomePage(driver);

    @Given("that a user is on the HomePage viewing games")
    public void that_a_user_is_on_the_HomePage_viewing_games() {
        driver.get("http://localhost:4200");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
    }

    @When("the User clicks the nextPageButton")
    public void the_user_clicks_the_nextPageButton() {
        homePage.clickNextPageButton();
    }

    @Then("the page will display next game page")
    public void the_page_will_display_next_game_page() {
        assertEquals(homePage.elementTextAfterClickingNextPage(), "Demigod");
    }

    @Given("that a user is on the HomePage and not on first game page")
    public void that_a_user_is_on_the_HomePage_and_not_on_first_game_page() {
        driver.get("http://localhost:4200");
        homePage.clickNextPageButton();
    }

    @When("the User clicks the previousPageButton")
    public void the_user_clicks_the_previousPageButton() {
        homePage.clickPreviousPageButton();
    }

    @Then("the page will display previous game page")
    public void the_page_will_display_previous_game_page() {
        assertEquals(homePage.elementTextAfterClickingPreviousButton(), "Evochron Mercenary");
    }

    @Given("that a user is on the HomePage viewing first game page")
    public void that_a_user_is_on_the_HomePage_viewing_first_game_page() {
        driver.get("http://localhost:4200");
    }

    @When("the User clicks numberedPageButton")
    public void the_user_clicks_the_numberedPageButton() {
        homePage.clickNumberedPage();
    }

    @Then("the page will display specified game page")
    public void the_page_will_display_specified_game_page() {
        assertEquals(homePage.elementTextAfterClickingPageNumber(), "PT Boats: South Gambit");
    }
}
