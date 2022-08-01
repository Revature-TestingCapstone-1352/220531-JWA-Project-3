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

	public By card = By.className("card");
	private By negativeBox = By.xpath("//*[@id=\"inner-box2\"]/div[1]/label/span");
	private By mixedBox = By.xpath("//*[@id=\"inner-box2\"]/div[2]/label/span");
	private By positiveBox = By.xpath("//*[@id=\"inner-box2\"]/div[3]/label/span");
	private By mostlyPositiveBox = By.xpath("//*[@id=\"inner-box2\"]/div[4]/label/span");
	private By veryPositiveBox = By.xpath("//*[@id=\"inner-box2\"]/div[5]/label/span");
	private By overwhelminglyPositiveBox = By.xpath("//*[@id=\"inner-box2\"]/div[6]/label/span");
	private By nextPageSpan = By.xpath("//*[@id=\"basicPaginate\"]/pagination-template/nav/ul/li[5]");
	private By nextPageMixed = By.xpath("//*[@id=\"basicPaginate\"]/pagination-template/nav/ul/li[5]/a");
	private By nextPageMostlyPositive = By.xpath("//*[@id=\"basicPaginate\"]/pagination-template/nav/ul/li[5]/a");
	private By nextPageVeryPositive = By.xpath("//*[@id=\"basicPaginate\"]/pagination-template/nav/ul/li[8]/a");
	private By nextPageOverPositive = By.xpath("//*[@id=\"basicPaginate\"]/pagination-template/nav/ul/li[5]/a");
	private By filterGamesDisplayed = By.xpath("//*[@id=\"games\"]/div");
	public By sRowCard= By.xpath("//*[@id=\"games\"]/div/div[7]/div");
	public By chopperCard = By.xpath("//*[@id=\"games\"]/div/div[7]/div");
	public By evoCard = By.xpath("//*[@id=\"games\"]/div/div[7]/div");
	
	public By pageFive = By.xpath("//*[@id=\"basicPaginate\"]/pagination-template/nav/ul/li[7]/a/span[2]");
	public By nextBtn = By.xpath("//*[@id=\"basicPaginate\"]/pagination-template/nav/ul/li[4]/span");
	public By firstCard = By.xpath("//*[@id=\"games\"]/div/div[1]/div");
	
	
	//-----------------------Jf Code -----------------------
	
	//MOSTLY NEGATIVE REVIEWS
	public By dead_Mountaineer_Hotel = By.xpath("//*[@id=\"games\"]/div/div[7]/div");
	//MIXED REVIEWS
	public By from_dust_game = By.xpath("//*[@id=\"games\"]/div/div[7]/div");
	// POSITIVE REVIEWS
	public By race_injection = By.xpath("//*[@id=\"games\"]/div/div[7]/div");
	
	
	

	public By getNextPageMixed() {
		return nextPageMixed;
	}
	
	public By getNextPageMostlyPositive() {
		return nextPageMostlyPositive;
	}

	public By getNextPageVeryPositive() {
		return nextPageVeryPositive;
	}

	public By getNextPageOverPositive() {
		return nextPageOverPositive;
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
}
