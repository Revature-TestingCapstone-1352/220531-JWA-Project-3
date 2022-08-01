package com.revature.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

<<<<<<< HEAD
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.paulhammant.ngwebdriver.ByAngular;
=======
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.revature.runner.GameRunner;
>>>>>>> origin/staging

public class StorePage {
	private WebDriver driver;
	
	public StorePage (WebDriver driver) {
<<<<<<< HEAD
	this.driver = driver;
}

	
	private By mostlynegative = By.xpath("/html/body/app-root/app-store/div/div/div[1]/div/div[2]/div[1]");
	private By mixed = By.xpath("/html/body/app-root/app-store/div/div/div[1]/div/div[2]/div[2]");
	private By positive = By.xpath("/html/body/app-root/app-store/div/div/div[1]/div/div[2]/div[3]");
	private By mostlypositive = By.xpath("/html/body/app-root/app-store/div/div/div[1]/div/div[2]/div[4]");
	private By verypositive = By.xpath("/html/body/app-root/app-store/div/div/div[1]/div/div[2]/div[5]");
	private By overwhelminglypositive = By.xpath("/html/body/app-root/app-store/div/div/div[1]/div/div[2]/div[6]");
	
	
	private By allgames = By.className("card");


	
	private By mostlynegativebox = By.xpath("/html/body/app-root/app-store/div/div/div[1]/div/div[2]/div[1]/label/span");
	private By mixedbox = By.xpath("/html/body/app-root/app-store/div/div/div[1]/div/div[2]/div[2]/label/span");
	private By positivebox = By.xpath("/html/body/app-root/app-store/div/div/div[1]/div/div[2]/div[3]/label/span");
	private By mostlypositivebox = By.xpath("/html/body/app-root/app-store/div/div/div[1]/div/div[2]/div[4]/label/span");
	private By verypositivebox = By.xpath("/html/body/app-root/app-store/div/div/div[1]/div/div[2]/div[5]/label/span");
	private By overwhelminglypositivebox = By.xpath("/html/body/app-root/app-store/div/div/div[1]/div/div[2]/div[6]/label/span");
	
	
	public void clickAdd()  {	
	driver.findElement(mostlynegativebox).click();
	driver.findElement(mixedbox).click();
	driver.findElement(positivebox).click();
	driver.findElement(mostlypositivebox).click();
	driver.findElement(verypositivebox).click();
	driver.findElement(overwhelminglypositivebox).click();
	}
	
	public int checkNumberOfGames() {
		
		WebElement gamesdivunchecked = driver.findElement(By.xpath("//*[@id=\"games\"]/div"));
		List<WebElement> games = gamesdivunchecked.findElements(By.xpath("./child::*"));
//		List<WebElement> gamesdivunchecked = driver.findElements(allgames);
		//driver.navigate().to("http://localhost:4200/");
		return games.size();
	}
	
	public void clickMostlyNegativeBox() {
		driver.findElement(mostlynegativebox).click();
		
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
=======
		this.driver = driver;
	}

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
	private By oPositiveText = By.xpath("//*[@id=\"games\"]/div/div[7]/div");
	
	public By getOPositiveText() {
		return oPositiveText;
	}
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
>>>>>>> origin/staging
