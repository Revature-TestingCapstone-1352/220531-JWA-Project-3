package com.revature.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.revature.runner.GameRunner;

public class StorePage {
	private WebDriver driver;
	
	public StorePage (WebDriver driver) {
		this.driver = driver;
	}

	private By negativeBox = By.xpath("/html/body/app-root/app-store/div/div/div[1]/div/div[2]/div[1]/label/span");
	private By mixedBox = By.xpath("/html/body/app-root/app-store/div/div/div[1]/div/div[2]/div[2]/label/span");
	private By positiveBox = By.xpath("/html/body/app-root/app-store/div/div/div[1]/div/div[2]/div[3]/label/span");
	private By mostlyPositiveBox = By.xpath("/html/body/app-root/app-store/div/div/div[1]/div/div[2]/div[4]/label/span");
	private By veryPositiveBox = By.xpath("/html/body/app-root/app-store/div/div/div[1]/div/div[2]/div[5]/label/span");
	private By overwhelminglyPositiveBox = By.xpath("/html/body/app-root/app-store/div/div/div[1]/div/div[2]/div[6]/label/span");
	private By nextPageSpan = By.xpath("/html/body/app-root/app-store/div/div/div[2]/div/pagination-controls/pagination-template/nav/ul/li[4]/span");
	private By nextPage = By.xpath("/html/body/app-root/app-store/div/pagination-controls/pagination-template/nav/ul/li[5]/a");
	
	private By filterGamesDisplayed = By.xpath("/html/body/app-root/app-store/div/div/div[2]/div");
	
	private By mostlyNegative = By.xpath("/html/body/app-root/app-store/div/div/div[1]/div/div[2]/div[1]");
	private By mixed = By.xpath("/html/body/app-root/app-store/div/div/div[1]/div/div[2]/div[2]");
	private By positive = By.xpath("/html/body/app-root/app-store/div/div/div[1]/div/div[2]/div[3]");
	private By mostlyPositive = By.xpath("/html/body/app-root/app-store/div/div/div[1]/div/div[2]/div[4]");
	private By veryPositive = By.xpath("/html/body/app-root/app-store/div/div/div[1]/div/div[2]/div[5]");
	private By overwhelminglyPositive = By.xpath("/html/body/app-root/app-store/div/div/div[1]/div/div[2]/div[6]");
	private By unrated = By.xpath("/html/body/app-root/app-store/div/div/div[1]/div/div[2]/div[0]");
	
	private By tickClass = By.xpath("//*[@id=\"inner-box2\"]");
	
	public By getTickClass() {
		return tickClass;
	}
	
	public By getNextPage() {
		return nextPage;
	}
	
	public By getNextPageSpan() {
		return nextPageSpan;
	}

	public By getNegativeBox() {
		return negativeBox;
	}

	public By getMixedBox() {
		return mixedBox;
	}

	public By getPositiveBox() {
		return positiveBox;
	}

	public By getMostlyPositiveBox() {
		return mostlyPositiveBox;
	}

	public By getVeryPositiveBox() {
		return veryPositiveBox;
	}

	public By getOverwhelminglyPositiveBox() {
		return overwhelminglyPositiveBox;
	}

	public By getFilterGamesDisplayed() {
		return filterGamesDisplayed;
	}

	public By getMostlyNegative() {
		return mostlyNegative;
	}

	public By getMixed() {
		return mixed;
	}

	public By getPositive() {
		return positive;
	}

	public By getMostlyPositive() {
		return mostlyPositive;
	}

	public By getVeryPositive() {
		return veryPositive;
	}

	public By getOverwhelminglyPositive() {
		return overwhelminglyPositive;
	}

	public By getUnrated() {
		return unrated;
	}
}
