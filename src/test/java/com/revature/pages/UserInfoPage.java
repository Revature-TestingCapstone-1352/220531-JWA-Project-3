package com.revature.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserInfoPage {

	private WebDriver driver;
	
	public UserInfoPage(WebDriver driver) {
		this.driver = driver;
	}
	
	private By viewOrderHistoryButton = By.xpath("/html/body/app-root/app-user-information/div/div[1]/div/div/div/div/div[4]/button");
	private By orderHistoryHeader = By.xpath("/html/body/app-root/app-user-information/div/div[2]/h4");
	private By firstOrderDate = By.xpath("/html/body/app-root/app-user-information/div/div[2]/table/thead/tr/th[1]");
	private By firstOrderTotal = By.xpath("/html/body/app-root/app-user-information/div/div[2]/table/thead/tr/th[2]");
	private By firstOrderFirstGame = By.xpath("/html/body/app-root/app-user-information/div/div[2]/table/tbody/tr[1]/td[2]/span/b");
	private By firstOrderSecondGame = By.xpath("/html/body/app-root/app-user-information/div/div[2]/table/tbody/tr[2]/td[2]/span/b");

	public void clickViewOrderHistoryButton() {
		new WebDriverWait(driver, Duration.ofSeconds(10))
			.until(ExpectedConditions.elementToBeClickable(viewOrderHistoryButton));
		
		driver.findElement(viewOrderHistoryButton).click();
	}
	
	public void waitForOrderHistoryHeader() {
		new WebDriverWait(driver, Duration.ofSeconds(10))
			.until(ExpectedConditions.visibilityOf(driver.findElement(orderHistoryHeader)));
	}
	
	public String getFirstOrderDate() {
		return driver.findElement(firstOrderDate).getText();
	}

	public String getFirstOrderTotal() {
		return driver.findElement(firstOrderTotal).getText();
	}

	public String getFirstOrderFirstGame() {
		return driver.findElement(firstOrderFirstGame).getText();
	}

	public String getFirstOrderSecondGame() {
		return driver.findElement(firstOrderSecondGame).getText();
	}
}
