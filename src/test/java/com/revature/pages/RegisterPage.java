package com.revature.pages;

import com.revature.runner.GameRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegisterPage {

    private WebDriver driver;
    public HomePage homePage = GameRunner.homePage;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    private By usernameBy = By.xpath("/html/body/app-root/app-register/div/div/div/div/div/div[1]/input");
    private By passwordBy = By.xpath("/html/body/app-root/app-register/div/div/div/div/div/div[2]/input");
    private By emailBy = By.xpath("/html/body/app-root/app-register/div/div/div/div/div/div[3]/input");
    private By registerButton = By.xpath("/html/body/app-root/app-register/div/div/div/div/div/div[4]/button");

    public By getUserName() {
        return usernameBy;
    }

    public By getPassword() {
        return passwordBy;
    }

    public By getEmail() {
        return emailBy;
    }

    public By getRegisterButton() {
        return registerButton;
    }

    //TODO: getters may be unnecessary
    public void enterInformation(String username, String password, String email) {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(getUserName()));
        driver.findElement(getUserName()).sendKeys(username);
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(getPassword()));
        driver.findElement(getPassword()).sendKeys(password);
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(getEmail()));
        driver.findElement(getEmail()).sendKeys(email);
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(getRegisterButton()));
        driver.findElement(getRegisterButton()).click();
    }

    public void clickRegister() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(homePage.getRegisterLink()));
        driver.findElement(homePage.getRegisterLink()).click();
    }
}
