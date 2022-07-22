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

    @Then("the page will display more games")
    public void the_page_will_display_more_games() {
        assertEquals(homePage.elementTextAfterClickingNextPage(), "Demigod");
    }
}
