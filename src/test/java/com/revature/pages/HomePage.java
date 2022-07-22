package com.revature.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;

    private By darkLightModeButton = By.xpath("/html/body/app-root/router-outlet/app-nav-bar/ul/li[10]/button/h5");

    private By nextPageButton = By.xpath("//*[@id=\"basicPaginate\"]/pagination-template/nav/ul/li[10]/a");
    private By body = By.xpath("/html/body");


    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickDarkModeButton() {
        driver.findElement(darkLightModeButton).click();
    }

    public String checkBackGroundColor() {
        return driver.findElement(body).getAttribute("class");
    }

    public void clickNextPageButton() {
        driver.findElement(nextPageButton).click();
    }

    public String elementTextAfterClickingNextPage() {
        By nextPageFirstElementToCheck = By.xpath("//*[@id=\"games\"]/div/div[1]/div/div[2]");

        return driver.findElement(nextPageFirstElementToCheck).getText();
    }
}
