package com.revature.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserInfoPage {

	private WebDriver driver;
	
	public UserInfoPage(WebDriver driver) {
		this.driver = driver;
	}
	
	private By viewOrderHistory = By.xpath("//*[@id=\"userinfocard\"]/div/div[4]/button");
	private By orderHistoryHeader = By.xpath("/html/body/app-root/app-user-information/div/div[2]/h4");
	private By firstOrderDate = By.xpath("/html/body/app-root/app-user-information/div/div[2]/table/thead/tr/th[1]");
	private By firstOrderTotal = By.xpath("/html/body/app-root/app-user-information/div/div[2]/table/thead/tr/th[2]");
	private By firstOrderFirstGame = By.xpath("/html/body/app-root/app-user-information/div/div[2]/table/tbody/tr[1]/td[2]/span/b");
	private By firstOrderSecondGame = By.xpath("/html/body/app-root/app-user-information/div/div[2]/table/tbody/tr[2]/td[2]/span/b");

	public By getViewOrderHistoryButton() {
		return viewOrderHistory;
	}
	
	public By getOrderHistoryHeader() {
		return orderHistoryHeader;
	}
	
	public By getFirstOrderDate() {
		return firstOrderDate;
	}

	public By getFirstOrderTotal() {
		return firstOrderTotal;
	}

	public By getFirstOrderFirstGame() {
		return firstOrderFirstGame;
	}

	public By getFirstOrderSecondGame() {
		return firstOrderSecondGame;
	}
}
