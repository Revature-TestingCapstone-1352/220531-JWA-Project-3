package com.revature.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;

    private By darkLightModeButton = By.xpath("/html/body/app-root/router-outlet/app-nav-bar/ul/li[10]/button/h5");


    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
}
