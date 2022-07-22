package com.revature.runner;

import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import org.junit.platform.suite.api.Suite;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;

@Suite
public class GameRunner {
    public static WebDriver driver;


    @BeforeAll
    public static void setup() {
        File chrome = new File("src/test/resources/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", chrome.getAbsolutePath());
        driver = new ChromeDriver();
    }

    @AfterAll
    public static void teardown() {
        driver.quit();
    }


}
