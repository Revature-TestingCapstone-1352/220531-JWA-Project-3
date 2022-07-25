package com.revature.pages;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StorePage {
	private WebDriver driver;
	
	public StorePage (WebDriver driver) {
	this.driver = driver;
}

	
	private By mostlynegative = By.xpath("/html/body/app-root/app-store/div/div/div[1]/div/div[2]/div[1]");
	private By mixed = By.xpath("/html/body/app-root/app-store/div/div/div[1]/div/div[2]/div[2]");
	private By positive = By.xpath("/html/body/app-root/app-store/div/div/div[1]/div/div[2]/div[3]");
	private By mostlypositive = By.xpath("/html/body/app-root/app-store/div/div/div[1]/div/div[2]/div[4]");
	private By verypositive = By.xpath("/html/body/app-root/app-store/div/div/div[1]/div/div[2]/div[5]");
	private By overwhelminglypositive = By.xpath("/html/body/app-root/app-store/div/div/div[1]/div/div[2]/div[6]");
	
	private By negativebox = By.xpath("/html/body/app-root/app-store/div/div/div[1]/div/div[2]/div[1]/label/span");
	private By mixedbox = By.xpath("/html/body/app-root/app-store/div/div/div[1]/div/div[2]/div[2]/label/span");
	private By positivebox = By.xpath("/html/body/app-root/app-store/div/div/div[1]/div/div[2]/div[3]/label/span");
	private By mostlypositivebox = By.xpath("/html/body/app-root/app-store/div/div/div[1]/div/div[2]/div[4]/label/span");
	private By verypositivebox = By.xpath("/html/body/app-root/app-store/div/div/div[1]/div/div[2]/div[5]/label/span");
	private By overwhelminglypositivebox = By.xpath("/html/body/app-root/app-store/div/div/div[1]/div/div[2]/div[6]/label/span");
	
	
	public void clickAdd()  {	
	
	}
	
	public void clickNegativeBox() {
		driver.findElement(negativebox).click();
		
	}
	
	public void clickMixedBox() {
		driver.findElement(mixedbox).click();
	}
	
	public void clickPositiveBox() {
		driver.findElement(positivebox).click();
	}
	
	public void clickMostlyPositiveBox() {
		driver.findElement(mostlypositivebox).click();
	}
	
	public void clickVeryPositiveBox() {
		driver.findElement(verypositivebox).click();
	}
	
	public void clickOverwhelminglyPositiveBox() {
		driver.findElement(overwhelminglypositivebox).click();
	}
	
	
}