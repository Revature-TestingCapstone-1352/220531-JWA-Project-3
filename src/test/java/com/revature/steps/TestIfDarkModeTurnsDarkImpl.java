package com.revature.steps;

import com.revature.pages.HomePage;
import com.revature.runner.GameRunner;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;


public class TestIfDarkModeTurnsDarkImpl {
    public static WebDriver driver = GameRunner.driver;
    public static HomePage homePage = new HomePage(driver);

    @Given("that a user is on the HomePage")
    public void that_a_user_is_on_the_HomePage() {
        driver("");
    }
}
