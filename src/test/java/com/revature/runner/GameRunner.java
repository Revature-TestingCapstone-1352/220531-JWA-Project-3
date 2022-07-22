package com.revature.runner;

import com.revature.pages.HomePage;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.platform.suite.api.Suite;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/chromedriver.exe", glue = "com.revature.steps")
@Suite
public class GameRunner {


    // we'll need a driver and an instance of our WikiPage POM
    public static WebDriver driver;
    public static HomePage homePage;

    public WebDriver getDriver() {

        File chrome = new File("src/test/resources/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", chrome.getAbsolutePath());
//
        driver = new ChromeDriver();
        return driver;
    }


    @BeforeAll //@BeforeClass is JUnit 4
    public static void setup() {
        File chrome = new File("src/test/resources/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", chrome.getAbsolutePath());

        driver = new ChromeDriver();

        //ADD YOUR WEB PAGES HERE
    }

    @AfterAll
    public static void teardown() {
        driver.quit();
    }


}
