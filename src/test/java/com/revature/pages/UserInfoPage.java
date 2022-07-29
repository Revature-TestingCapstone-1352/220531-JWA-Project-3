package com.revature.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
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
	private By secondOrderDate = By.xpath("/html/body/app-root/app-user-information/div/div[2]/table[2]/thead/tr/th[1]");
	private By secondOrderTotal = By.xpath("/html/body/app-root/app-user-information/div/div[2]/table[2]/thead/tr/th[2]");
	private By secondOrderFirstGame = By.xpath("/html/body/app-root/app-user-information/div/div[2]/table[2]/tbody/tr/td[2]/span/b");
	private By usernameInput = By.xpath("//*[@id=\"form1\"]/div/div[1]/input");
	private By passwordInput = By.xpath("//*[@id=\"form1\"]/div/div[2]/input");
	private By loginButton = By.xpath("//*[@id=\"form1\"]/div/div[3]/button");
	private By userInfoLink = By.xpath("/html/body/app-root/router-outlet/app-nav-bar/ul/li[7]/a");
	private By usernameInfoCard = By.xpath("//*[@id=\"userinfocard\"]/div/div[1]/span");
	private By loggedOutText = By.xpath("/html/body/app-root/app-user-information/h4");
	 
	@FindBy(xpath  = "//*[@id=\"changeemailcard\"]/div/div[1]/input")
	public WebElement EnterNewEmail;
	
	private By editUserDetail = By.xpath("//*[@id=\"userinfocard\"]/div/div[3]/button");
	public By geteditUserDetail() {
		return editUserDetail;
	}
	
	public By editUserEmail = By.xpath("//*[@id=\"changeemailcard\"]/div/div[2]/button");
	public void getUserNewEmailLink() {
		driver.findElement(editUserEmail).click();
	}	
	
	@FindBy(xpath  = "//*[@id=\"changepwdcard\"]/div/div[1]/input")
	public WebElement EnterNewPassword;
	@FindBy(xpath  = "//*[@id=\"changepwdcard\"]/div/div[2]/input")
	public WebElement ConfirmNewPassword;
	
	public By editUserPassword = By.xpath("/html/body/app-root/app-user-information/div/div[3]/div/div/div/div/div[3]/button");
	public void getUserNewPasswordLink() {
		driver.findElement(editUserPassword).click();
	}
	
	@FindBy(xpath  = "//*[@id=\"changepwdcard\"]/div/label")
	public WebElement passNotMatchDisplayed;
	
	private By logoutSeccussLink = By.xpath("/html/body/app-root/app-logout/h4");
	public By getLogoutSeccussLink() {
		return logoutSeccussLink;
    }

	//private By errorPasswordLink = By.xpath("//*[@id=\"changepwdcard\"]/div/label");
	private By errorPasswordLink = By.xpath("/html/body/app-root/app-user-information/div/div[3]/div/div/div/div/label");
	public By getErrorPasswordLink() {
		return errorPasswordLink; 
	}
	
	public String findPasswordError() {
		JavascriptExecutor jse6 = (JavascriptExecutor) driver;
		jse6.executeScript("window.scrollTo(0, document.body.scrollHeight)");

		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfElementLocated(getErrorPasswordLink()));


		String passwordErrorText = driver.findElement(getErrorPasswordLink()).getText();
		
		return passwordErrorText;
	}
		
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
	
	public String getSecondOrderDate() {
		return driver.findElement(secondOrderDate).getText();
	}

	public String getSecondOrderTotal() {
		return driver.findElement(secondOrderTotal).getText();
	}

	public String getSecondOrderFirstGame() {
		return driver.findElement(secondOrderFirstGame).getText();

	}
	public boolean isUserPageEmpty() {
  try {
			new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(loggedOutText));
			return driver.findElement(loggedOutText).getText().equals("You need to login to view this page!");
		} catch(Exception e) {
			return false;
		}
	}


	//Creating getters
	public By getUsernameInput() {
		return usernameInput;
	}
	public By getPasswordInput() {
		return passwordInput;
	}
	public By getLoginButton() {
		return loginButton;
	}
	public By getUserInfoLink() {
		return userInfoLink;
	}
	public By getUsernameInfoCard() {
		return usernameInfoCard;
	}
	
    
    	
	
}
