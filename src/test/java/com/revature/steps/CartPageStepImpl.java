package com.revature.steps;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.revature.pages.CartPage;
import com.revature.runner.GameRunner;



public class CartPageStepImpl {
	//This is where the driver will execute these tests.
	
		private static WebDriver driver = GameRunner.driver;
		private static CartPage cartPage = GameRunner.cartPage;
		
		
		@Test
		public void randoTesto() throws InterruptedException {
//			File chrome = new File("src/test/resources/chromedriver.exe");
//			System.setProperty("webdriver.chrome.driver",chrome.getAbsolutePath());
			
//			WebDriver driver = new ChromeDriver();
			
//			System.out.println("I ran here");
			driver.get("http://localhost:4200/");
			System.out.println("I instantiated");
			
			
//			String navCartButtonPath = "/html/body/app-root/router-outlet/app-nav-bar/ul/li[3]/a";
//			String shoppingCartEmptyMessagePath = "/html/body/app-root/app-cart/div[1]/h4";
//			String addToCartButtonPath = "//*[@id=\"games\"]/div/div[2]/div/div[4]/div/button[2]";
//			String cartTablePath ="/html/body/app-root/app-cart/div/div/div[2]/table/tbody";
//					cartTblRemoveButtonsPath =
			int millies = 800;
			driver.wait(millies);
			
			WebElement navBtn = cartPage.navCartButton;
			navBtn.click();
//			driver.wait(millies)
//			driver.wait(millies ,ExpectedConditions.elementToBeClickable(By.xpath(navCartButtonPath))).click();
//			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(navCartButtonPath))).click();
//			WebElement web = driver.findElement(By.xpath(navCartButtonPath));
//			web.click();
		}
}
