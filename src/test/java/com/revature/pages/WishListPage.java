package com.revature.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class WishListPage {
    protected WebDriver driver;

    private By gameNameBy = By.xpath("//*[@id=\"games\"]/div/div/div/div[2]");

    public WishListPage(WebDriver driver) {
        this.driver = driver;
    }

    public By getGameNameBy() {
        return gameNameBy;
    }

    //TODO: getters maybe unnecessary
    public String findGameName() {
        //new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(driver.findElement(getGameNameBy())));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String gamename = driver.findElement(getGameNameBy()).getText();
        return gamename;
    }
}
